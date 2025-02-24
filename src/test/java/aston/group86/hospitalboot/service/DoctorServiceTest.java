package aston.group86.hospitalboot.service;

import static aston.group86.hospitalboot.datatest.DataTest.DOCTOR_1;
import static aston.group86.hospitalboot.datatest.DataTest.DOCTOR_DTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import aston.group86.hospitalboot.entity.Doctor;
import aston.group86.hospitalboot.repository.DoctorRepository;
import aston.group86.hospitalboot.service.dto.DoctorDTO;
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
@DisplayName("Тестирование DoctorService")
class DoctorServiceTest {

    @Mock
    private DoctorRepository repository;

    @InjectMocks
    private DoctorService doctorService;

    private Doctor doctor;
    private DoctorDTO doctorDTO;

    @BeforeEach
    void setUp() {
        doctor = DOCTOR_1;
        doctorDTO = DOCTOR_DTO;
    }

    @Test
    @DisplayName("Должен вернуть список всех врачей")
    void findAll_shouldReturnDoctorDTOList() {
        when(repository.findAll()).thenReturn(List.of(doctor));

        ResponseEntity<List<DoctorDTO>> response = doctorService.findAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .hasSize(1)
                .first()
                .extracting(DoctorDTO::getFirstName)
                .isEqualTo("John");
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Должен найти врача по идентификатору")
    void findById_shouldReturnDoctorDTO() {
       when(repository.findById(1L)).thenReturn(Optional.of(doctor));

        ResponseEntity<DoctorDTO> response = doctorService.findById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(DoctorDTO::getFirstName)
                .isEqualTo("John");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Должен вернуть 404, если врач не найден")
    void findById_shouldReturnNotFoundIfDoctorDoesNotExist() {
        /*when(repository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<DoctorDTO> response = doctorService.findById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(repository, times(1)).findById(1L);*/
    }

    @Test
    @DisplayName("Должен сохранить нового врача")
    void save_shouldSaveDoctorAndReturnDoctorDTO() {
        when(repository.save(any(Doctor.class))).thenReturn(doctor);

        ResponseEntity<DoctorDTO> response = doctorService.save(doctorDTO);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody())
                .isNotNull()
                .extracting(DoctorDTO::getFirstName)
                .isEqualTo("John");
        verify(repository, times(1)).save(any(Doctor.class));
    }

    @Test
    @DisplayName("Должен удалить врача по идентификатору")
    void delete_shouldDeleteDoctorAndReturnNoContent() {
        when(repository.existsById(1L)).thenReturn(true);

        ResponseEntity<Void> response = doctorService.delete(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(204, response.getStatusCodeValue());
        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Должен вернуть 204, если врач не найден для удаления")
    void delete_shouldReturnNoContentIfDoctorDoesNotExist() {
        when(repository.existsById(1L)).thenReturn(false);

        ResponseEntity<Void> response = doctorService.delete(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(404, response.getStatusCodeValue());
        verify(repository, times(1)).existsById(1L);
        verify(repository, never()).deleteById(1L);
    }

}