package aston.group86.hospitalboot.service;

import aston.group86.hospitalboot.entity.Sick;
import aston.group86.hospitalboot.repository.SickRepository;
import java.util.List;
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
public class SickService {

  private final SickRepository repository;

  /**
   * Получить список всех болезней.
   *
   * @return ResponseEntity со списком объектов Sick.
   */
  @Transactional
  @Cacheable(value = "sicks")
  public ResponseEntity<List<Sick>> findAll() {
    log.info("Запрос на получение списка всех болезней.");
    List<Sick> sicks = repository.findAll();
    log.info("Найдено {} болезней.", sicks.size());
    return ResponseEntity.ok(sicks);
  }

  /**
   * Найти болезнь по идентификатору с кешированием.
   *
   * @param id идентификатор болезни.
   * @return Optional с объектом Sick, если болезнь найдена.
   */
  @Transactional(readOnly = true)
  @Cacheable(value = "sick", key = "#id")
  public ResponseEntity<Sick> findById(long id) {
    log.info("Запрос на поиск болезни с id={}.", id);
    return repository.findById(id)
        .map(sick -> {
          log.info("Болезнь с id={} найдена.", id);
          return ResponseEntity.ok(sick);
        })
        .orElseGet(() -> {
          log.warn("Болезнь с id={} не найдена.", id);
          return ResponseEntity.notFound().build();
        });
  }

  /**
   * Сохранить новую болезнь.
   *
   * @param sick объект Sick для сохранения.
   * @return ResponseEntity с сохраненным объектом Sick.
   */
  @Transactional
  @CacheEvict(value = {"sicks", "sick"}, allEntries = true)
  public ResponseEntity<Sick> save(Sick sick) {
    log.info("Запрос на сохранение новой болезни: {}.", sick);
    Sick savedSick = repository.save(sick);
    log.info("Новая болезнь сохранена с id={}.", savedSick.getId());
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSick);
  }

  /**
   * Обновить данные болезни.
   *
   * @param sick объект Sick с обновленными данными.
   * @return ResponseEntity с обновленным объектом Sick, или статусом 404, если болезнь не найдена.
   */
  @Transactional
  @CachePut(value = "sick", key = "#sick.id")
  public ResponseEntity<Sick> update(Sick sick) {
    log.info("Запрос на обновление болезни с id={}.", sick.getId());
    if (!repository.existsById(sick.getId())) {
      log.warn("Болезнь с id={} не найдена для обновления.", sick.getId());
      return ResponseEntity.notFound().build();
    }
    Sick updatedSick = repository.save(sick);
    log.info("Болезнь с id={} успешно обновлена.", updatedSick.getId());
    return ResponseEntity.ok(updatedSick);
  }

  /**
   * Удалить болезнь по идентификатору.
   *
   * @param id идентификатор болезни.
   * @return ResponseEntity со статусом 204 (успешно удалено) или 404 (не найдено).
   */
  @Transactional
  @CacheEvict(value = {"sicks", "sick"}, allEntries = true)
  public ResponseEntity<Void> deleteById(long id) {
    log.info("Запрос на удаление болезни с id={}.", id);
    if (!repository.existsById(id)) {
      log.warn("Болезнь с id={} не найдена для удаления.", id);
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    log.info("Болезнь с id={} успешно удалена.", id);
    return ResponseEntity.noContent().build();
  }
}
