package aston.group86.hospitalboot.controller;

import aston.group86.hospitalboot.service.DoctorService;
import aston.group86.hospitalboot.service.dto.DoctorDTO;
import java.util.List;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для управления данными врачей. Обрабатывает HTTP-запросы для операций с врачами.
 * Использует {@link DoctorService} для выполнения бизнес-логики.
 */
@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

  private final DoctorService doctorService;

  /**
   * Получение списка всех врачей.
   *
   * @return список всех врачей в виде {@link ResponseEntity} с объектами {@link DoctorDTO}.
   */
  @GetMapping
  public ResponseEntity<List<DoctorDTO>> findAll() {
    return doctorService.findAll();
  }

  /**
   * Получение информации о враче по идентификатору.
   *
   * @param id идентификатор врача.
   * @return информация о враче в виде {@link ResponseEntity} с объектом {@link DoctorDTO}.
   */
  @GetMapping("/{id}")
  public ResponseEntity<DoctorDTO> findById(@PathVariable int id) {
    return doctorService.findById(id);
  }

  /**
   * Сохранение данных нового врача.
   *
   * @param doctorDTO данные нового врача.
   * @return сохраненный врач в виде {@link ResponseEntity} с объектом {@link DoctorDTO}.
   */
  @PostMapping
  public ResponseEntity<DoctorDTO> save(@RequestBody DoctorDTO doctorDTO) {
    return doctorService.save(doctorDTO);
  }

  /**
   * Обновление информации о враче.
   *
   * @param doctorDTO обновленные данные врача.
   * @return обновленный врач в виде {@link ResponseEntity} с объектом {@link DoctorDTO}.
   */
  @PutMapping
  public ResponseEntity<DoctorDTO> update(@RequestBody DoctorDTO doctorDTO) {
    return doctorService.update(doctorDTO);
  }

  /**
   * Удаление врача по идентификатору.
   *
   * @param id идентификатор врача.
   * @return пустой ответ в виде {@link ResponseEntity<Void>}.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    return doctorService.delete(id);
  }
}
