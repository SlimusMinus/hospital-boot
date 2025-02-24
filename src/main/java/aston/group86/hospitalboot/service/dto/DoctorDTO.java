package aston.group86.hospitalboot.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) для представления врача.
 * Используется для передачи данных врача между слоями приложения.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO implements Serializable {
    @NotNull
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private int age;
    @NotBlank
    private String specification;
    @NotBlank
    private String status;
    private List<ClientDTO> clients;

    public DoctorDTO(String firstName, String lastName, int age, String specification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.specification = specification;
    }
}
