package aston.group86.hospitalboot.service;

import static aston.group86.hospitalboot.datatest.DataTest.SICK_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import aston.group86.hospitalboot.entity.Sick;
import aston.group86.hospitalboot.repository.SickRepository;
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
@DisplayName("Тестирование SickService")
class SickServiceTest {
    @Mock
    private SickRepository repository;

    @InjectMocks
    private SickService sickService;

    private Sick sick;

    @BeforeEach
    void setUp() {
        sick = SICK_1;
    }

    @Test
    @DisplayName("Должен вернуть список всех болезней")
    void findAll_shouldReturnSickList() {
        when(repository.findAll()).thenReturn(List.of(sick));

        ResponseEntity<List<Sick>> response = sickService.findAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .hasSize(1)
                .first()
                .extracting(Sick::getSickName)
                .isEqualTo("Flu");
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Должен найти болезнь по идентификатору")
    void findById_shouldReturnSick() {
        when(repository.findById(1L)).thenReturn(Optional.of(sick));

        ResponseEntity<Sick> response = sickService.findById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Sick::getSickName)
                .isEqualTo("Flu");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Должен вернуть 404, если болезнь не найдена")
    void findById_shouldReturnNotFoundIfSickDoesNotExist() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Sick> response = sickService.findById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Должен сохранить новую болезнь")
    void save_shouldSaveSick() {
        when(repository.save(any(Sick.class))).thenReturn(sick);

        ResponseEntity<Sick> response = sickService.save(sick);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(Sick::getSickName)
                .isEqualTo("Flu");
        verify(repository, times(1)).save(any(Sick.class));
    }

    @Test
    @DisplayName("Должен удалить болезнь по идентификатору")
    void deleteById_shouldDeleteSick() {
        when(repository.existsById(1L)).thenReturn(true);

        ResponseEntity<Void> response = sickService.deleteById(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(204, response.getStatusCodeValue());
        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Должен вернуть 404, если болезнь не найдена для удаления")
    void deleteById_shouldReturnNotFoundIfSickDoesNotExist() {
        when(repository.existsById(1L)).thenReturn(false);

        ResponseEntity<Void> response = sickService.deleteById(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(404, response.getStatusCodeValue());
        verify(repository, times(1)).existsById(1L);
        verify(repository, never()).deleteById(1L);
    }
}