package aston.group86.hospitalboot.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import aston.group86.hospitalboot.service.DoctorService;
import aston.group86.hospitalboot.service.dto.DoctorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DoctorController.class)
class DoctorControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockitoBean
  DoctorService doctorService;

  @Test
  void findById() throws Exception {
    DoctorDTO doctor = new DoctorDTO("Alex", "Cat", 33, "Doctor");

    when(doctorService.findById(1)).thenReturn(ResponseEntity.ok(doctor));

    mockMvc.perform(get("/doctors/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()) // Ожидаем 200 OK
        .andExpect(jsonPath("$.lastName").value("Cat"))
        .andExpect(jsonPath("$.firstName").value("Alex"))
        .andExpect(jsonPath("$.age").value("33"));

    verify(doctorService, times(1)).findById(1L);
  }
}