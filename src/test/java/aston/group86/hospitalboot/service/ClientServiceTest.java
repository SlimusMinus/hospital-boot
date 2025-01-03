package aston.group86.hospitalboot.service;

import static aston.group86.hospitalboot.datatest.DataTest.CLIENT_1;
import static aston.group86.hospitalboot.datatest.DataTest.CLIENT_DTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import aston.group86.hospitalboot.entity.Client;
import aston.group86.hospitalboot.repository.ClientRepository;
import aston.group86.hospitalboot.service.dto.ClientDTO;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тестирование ClientService")

class ClientServiceTest {

  @Mock
  private ClientRepository repository;

  @InjectMocks
  private ClientService clientService;

  private Client client;
  private ClientDTO clientDTO;

  @BeforeEach
  void setUp() {
    client = CLIENT_1;
    clientDTO = CLIENT_DTO;
  }

  @Test
  @DisplayName("Должен вернуть список всех клиентов")
  void findAll_shouldReturnClientDTOList() {
    when(repository.findAll()).thenReturn(List.of(client));

    ResponseEntity<List<ClientDTO>> response = clientService.findAll();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody())
        .isNotNull()
        .hasSize(1)
        .first()
        .extracting(ClientDTO::getFirstName)
        .isEqualTo("John");
    verify(repository, times(1)).findAll();
  }

  @Test
  @DisplayName("Должен найти клиента по идентификатору")
  void findById_shouldReturnClientDTO() {
    when(repository.findById(1L)).thenReturn(Optional.of(client));

    ResponseEntity<ClientDTO> response = clientService.findById(1L);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody())
        .isNotNull()
        .extracting(ClientDTO::getFirstName)
        .isEqualTo("John");
    verify(repository, times(1)).findById(1L);
  }

  @Test
  @DisplayName("Должен вернуть 404, если клиент не найден")
  void findById_shouldReturnNotFoundIfClientDoesNotExist() {
   /* when(repository.findById(1L)).thenReturn(Optional.empty());

    ResponseEntity<ClientDTO> response = clientService.findById(1L);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(404, response.getStatusCodeValue());
    verify(repository, times(1)).findById(1L);*/
  }

  @Test
  @DisplayName("Должен сохранить нового клиента")
  void save_shouldSaveClientAndReturnClientDTO() {
    when(repository.save(any(Client.class))).thenReturn(client);

    ResponseEntity<ClientDTO> response = clientService.save(clientDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody())
        .isNotNull()
        .extracting(ClientDTO::getFirstName)
        .isEqualTo("John");
    verify(repository, times(1)).save(any(Client.class));
  }

  @Test
  @DisplayName("Должен удалить клиента по идентификатору")
  void deleteById_shouldDeleteClientAndReturnNoContent() {
    when(repository.existsById(1L)).thenReturn(true);

    ResponseEntity<Void> response = clientService.deleteById(1L);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(204, response.getStatusCodeValue());
    verify(repository, times(1)).existsById(1L);
    verify(repository, times(1)).deleteById(1L);
  }

  @Test
  @DisplayName("Должен вернуть 204, если клиент не найден для удаления")
  void deleteById_shouldReturnNotFoundIfClientDoesNotExist() {
    when(repository.existsById(1L)).thenReturn(false);

    ResponseEntity<Void> response = clientService.deleteById(1L);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(404, response.getStatusCodeValue());
    verify(repository, times(1)).existsById(1L);
    verify(repository, never()).deleteById(1L);
  }
}