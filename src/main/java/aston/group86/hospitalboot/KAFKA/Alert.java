package aston.group86.hospitalboot.KAFKA;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Alert implements Serializable {

  private final int alertId;
  private String stageId;
  private final String alertLevel;
  private final String alertMessage;
}










