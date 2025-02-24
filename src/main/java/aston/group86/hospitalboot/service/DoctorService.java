package aston.group86.hospitalboot.service;

import aston.group86.hospitalboot.entity.Doctor;
import aston.group86.hospitalboot.repository.DoctorRepository;
import aston.group86.hospitalboot.service.dto.DoctorDTO;
import aston.group86.hospitalboot.service.mapper.DoctorMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для управления данными о врачах.
 * <p>
 * Этот класс предоставляет методы для выполнения операций CRUD (создание, чтение, обновление,
 * удаление) с объектами Doctor и их преобразования в DTO для взаимодействия с внешними системами.
 *
 * <p>
 * Использует {@link DoctorRepository} для выполнения операций с базой данных, а также
 * {@link DoctorMapper} для преобразования между сущностями и DTO.
 * </p>
 *
 * <p>
 * Логирование выполняется с использованием аннотации {@code @Slf4j}, что позволяет отслеживать
 * выполнение операций и обрабатывать возможные ошибки.
 * </p>
 */
@AllArgsConstructor
@Service
@Slf4j
public class DoctorService {

  private DoctorRepository repository;

  /**
   * Получить список всех докторов.
   *
   * @return ResponseEntity со списком объектов DoctorDTO.
   */
  @Transactional(readOnly = true)
  @Cacheable(value = "doctors")
  public ResponseEntity<List<DoctorDTO>> findAll() {
    log.info("Запрос на получение всех докторов из базы данных.");
    List<Doctor> doctors = repository.findAll();
    log.debug("Найдено {} докторов.", doctors.size());
    List<DoctorDTO> doctorDTOs = doctors.stream()
        .map(DoctorMapper.INSTANCE::toDoctorDTO)
        .toList();
    log.info("Возвращается список докторов размером {}.", doctorDTOs.size());
    return ResponseEntity.ok(doctorDTOs);
  }

  /**
   * Получить доктора по идентификатору.
   *
   * @param id идентификатор доктора.
   * @return ResponseEntity с объектом DoctorDTO или статусом 404, если доктор не найден.
   */
  @Transactional(readOnly = true)
  @Cacheable(value = "doctor", key = "#id")
  public ResponseEntity<DoctorDTO> findById(long id) {
    log.info("Запрос на получение доктора с id={}.", id);
    return repository.findById(id)
        .map(doctor -> {
          DoctorDTO doctorDTO = DoctorMapper.INSTANCE.toDoctorDTO(doctor);
          log.info("Доктор с id={} найден.", id);
          return ResponseEntity.ok(doctorDTO);
        })
        .orElseGet(() -> {
          log.warn("Доктор с id={} не найден.", id);
          return ResponseEntity.notFound().build();
        });
  }

  /**
   * Сохранить нового доктора.
   *
   * @param doctorDTO объект DoctorDTO, который нужно сохранить.
   * @return ResponseEntity с сохраненным объектом DoctorDTO.
   */
  @Transactional
  @CacheEvict(value = {"doctors", "doctor"}, allEntries = true)
  public ResponseEntity<DoctorDTO> save(DoctorDTO doctorDTO) {
    log.info("Запрос на сохранение нового доктора: {}.", doctorDTO);
    Doctor doctor = DoctorMapper.INSTANCE.toDoctor(doctorDTO);
    Doctor savedDoctor = repository.save(doctor);
    DoctorDTO savedDoctorDTO = DoctorMapper.INSTANCE.toDoctorDTO(savedDoctor);
    log.info("Новый доктор сохранён с id={}.", savedDoctor.getId());
    return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctorDTO);
  }

  /**
   * Обновить данные доктора.
   *
   * @param doctorDTO объект DoctorDTO с обновленными данными.
   * @return ResponseEntity с обновленным объектом DoctorDTO или статусом 404, если доктор не найден.
   */
  @Transactional
  @CacheEvict(value = {"doctors", "doctor"}, allEntries = true)
  public ResponseEntity<DoctorDTO> update(DoctorDTO doctorDTO) {
    log.info("Запрос на обновление доктора с id={}.", doctorDTO.getId());
    if (!repository.existsById(doctorDTO.getId())) {
      log.warn("Доктор с id={} не найден для обновления.", doctorDTO.getId());
      return ResponseEntity.notFound().build();
    }
    Doctor doctor = DoctorMapper.INSTANCE.toDoctor(doctorDTO);
    Doctor updatedDoctor = repository.save(doctor);
    DoctorDTO updatedDoctorDTO = DoctorMapper.INSTANCE.toDoctorDTO(updatedDoctor);
    log.info("Доктор с id={} обновлён.", updatedDoctor.getId());
    return ResponseEntity.ok(updatedDoctorDTO);
  }

  /**
   * Удалить доктора по идентификатору.
   *
   * @param id идентификатор доктора.
   * @return ResponseEntity со статусом 204 (успешно удалено) или 404 (не найдено).
   */
  @Transactional
  @CacheEvict(value = {"doctors", "doctor"}, allEntries = true)
  public ResponseEntity<Void> delete(long id) {
    log.info("Запрос на удаление доктора с id={}.", id);
    if (!repository.existsById(id)) {
      log.warn("Доктор с id={} не найден для удаления.", id);
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    log.info("Доктор с id={} успешно удалён.", id);
    return ResponseEntity.noContent().build();
  }

  /**
   * Запланированное задание для обновления статусов докторов.
   * Обновляет статус докторов со статусом "free" на "we have job".
   */
  @Transactional
  @Scheduled(fixedRate = 10000)
  public void updateDoctorStatus() {
    log.info("Starting scheduled task to update doctor statuses...");

    List<Doctor> freeDoctors = repository.findByStatus("free");

    freeDoctors.forEach(doctor -> {
      doctor.setStatus("we have job");
      repository.save(doctor);
      log.info("Updated status for doctor with ID {} to 'we have job'", doctor.getId());
    });

    log.info("Scheduled task completed. Total updated: {}", freeDoctors.size());
  }

}