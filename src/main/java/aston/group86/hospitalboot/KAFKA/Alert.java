package aston.group86.hospitalboot.KAFKA;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alert implements Serializable {

  private int alertId;
  private String stageId;
  private String alertLevel;
  private String alertMessage;
}










