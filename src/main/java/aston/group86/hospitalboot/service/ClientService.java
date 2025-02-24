package aston.group86.hospitalboot.service;

import aston.group86.hospitalboot.entity.Client;
import aston.group86.hospitalboot.repository.ClientRepository;
import aston.group86.hospitalboot.service.dto.ClientDTO;
import aston.group86.hospitalboot.service.mapper.ClientMapper;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Slf4j
public class ClientService {

  private ClientRepository repository;

  /**
   * Получить список всех клиентов.
   *
   * @return ResponseEntity со списком объектов ClientDTO.
   */
  @Transactional(readOnly = true)
  @Cacheable(value = "clients")
  public ResponseEntity<List<ClientDTO>> findAll() {
    log.info("Запрос на получение всех клиентов.");
    List<Client> clients = repository.findAll();
    log.debug("Найдено {} клиентов.", clients.size());
    List<ClientDTO> clientDTOs = clients.stream()
        .map(ClientMapper.INSTANCE::clientToClientDTO)
        .toList();
    log.info("Возвращается список клиентов размером {}.", clientDTOs.size());
    return ResponseEntity.ok(clientDTOs);
  }

  @Transactional(readOnly = true)
  @Cacheable(value = "client", key = "#id")
  public ResponseEntity<ClientDTO> findById(Long id) {
    log.info("Запрос на получение клиента с id={}.", id);
    return repository.findById(id)
        .map(client -> {
          ClientDTO clientDTO = ClientMapper.INSTANCE.clientToClientDTO(client);
          log.info("Клиент с id={} найден.", id);
          return ResponseEntity.ok(clientDTO);
        })
        .orElseGet(() -> {
          log.warn("Клиент с id={} не найден.", id);
          return ResponseEntity.notFound().build();
        });
  }

  /**
   * Сохранить нового клиента.
   *
   * @param clientDTO объект ClientDTO, который нужно сохранить.
   * @return ResponseEntity с сохраненным объектом ClientDTO.
   */
  @Transactional
  @CacheEvict(value = {"clients", "client"}, allEntries = true)
  public ResponseEntity<ClientDTO> save(ClientDTO clientDTO) {
    log.info("Запрос на сохранение нового клиента: {}.", clientDTO);
    Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
    Client savedClient = repository.save(client);
    ClientDTO savedClientDTO = ClientMapper.INSTANCE.clientToClientDTO(savedClient);
    log.info("Новый клиент сохранён с id={}.", savedClient.getId());
    return ResponseEntity.status(HttpStatus.CREATED).body(savedClientDTO);
  }

  /**
   * Обновить данные клиента.
   *
   * @param clientDTO объект ClientDTO с обновленными данными.
   * @return ResponseEntity с обновленным объектом ClientDTO, или статусом 404, если клиент не
   * найден.
   */
  @Transactional
  @CacheEvict(value = {"clients", "client"}, allEntries = true)
  public ResponseEntity<ClientDTO> update(ClientDTO clientDTO) {
    log.info("Запрос на обновление клиента с id={}.", clientDTO.getId());
    if (!repository.existsById(clientDTO.getId())) {
      log.warn("Клиент с id={} не найден для обновления.", clientDTO.getId());
      return ResponseEntity.notFound().build();
    }
    Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
    Client updatedClient = repository.save(client);
    ClientDTO updatedClientDTO = ClientMapper.INSTANCE.clientToClientDTO(updatedClient);
    log.info("Клиент с id={} обновлён.", updatedClient.getId());
    return ResponseEntity.ok(updatedClientDTO);
  }

  /**
   * Удалить клиента по идентификатору.
   *
   * @param id идентификатор клиента.
   * @return ResponseEntity со статусом 204 (успешно удалено) или 404 (не найдено).
   */
  @Transactional
  @CacheEvict(value = {"clients", "client"}, allEntries = true)
  public ResponseEntity<Void> deleteById(long id) {
    log.info("Запрос на удаление клиента с id={}.", id);
    if (!repository.existsById(id)) {
      log.warn("Клиент с id={} не найден для удаления.", id);
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    log.info("Клиент с id={} успешно удалён.", id);
    return ResponseEntity.noContent().build();
  }
}
