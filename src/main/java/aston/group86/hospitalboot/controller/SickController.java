package aston.group86.hospitalboot.controller;

import aston.group86.hospitalboot.entity.Sick;
import aston.group86.hospitalboot.service.SickService;
import aston.group86.hospitalboot.service.dto.SickDTO;
import java.util.List;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sicks")
@AllArgsConstructor
public class SickController {

  private final SickService service;

  /**
   * Получение списка всех болезней.
   *
   * @return список всех болезней в виде {@link ResponseEntity} с объектами {@link Sick}.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Sick>> findAll() {
    return service.findAll();
  }

  /**
   * Получение болезни по идентификатору.
   *
   * @param id идентификатор болезни.
   * @return болезнь в виде {@link ResponseEntity} с объектом {@link Sick}.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Sick> findById(@PathVariable int id) {
    return service.findById(id);
  }

  /**
   * Сохранение новой болезни.
   *
   * @param sick данные новой болезни.
   * @return сохраненная болезнь в виде {@link ResponseEntity} с объектом {@link Sick}.
   */
  @PostMapping
  public ResponseEntity<Sick> save(@RequestBody Sick sick) {
    return service.save(sick);
  }

  /**
   * Обновление информации о болезни.
   *
   * @param sick данные болезни для обновления.
   * @return обновленная болезнь в виде {@link ResponseEntity} с объектом {@link Sick}.
   */
  @PutMapping
  public ResponseEntity<Sick> update(@RequestBody Sick sick) {
    return service.update(sick);
  }

  /**
   * Удаление болезни по идентификатору.
   *
   * @param id идентификатор болезни.
   * @return пустой ответ в виде {@link ResponseEntity<Void>}.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    return service.deleteById(id);
  }
}
