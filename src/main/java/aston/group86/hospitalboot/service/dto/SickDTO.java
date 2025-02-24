package aston.group86.hospitalboot.service.dto;

import aston.group86.hospitalboot.entity.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SickDTO implements Serializable {
    @NotNull
    private Long id;
    @NotBlank
    private String sickName;
    @NotBlank
    private String stageSick;
    private List<Client> clients;
}
