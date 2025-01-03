package aston.group86.hospitalboot.test;

public class Data {
  String code;
  String version;

  public Data(String code, String version) {
    this.code = code;
    this.version = version;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "Data{" +
        "code='" + code + '\'' +
        ", version='" + version + '\'' +
        '}';
  }
}
