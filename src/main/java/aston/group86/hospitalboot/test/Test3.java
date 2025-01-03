package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {

  public static void main(String[] args) {
    List<String> strings = List.of(
        "ERROR,message of error 1",
        "DEBUG,message of debug 1",
        "ERROR,message of error 2",
        "ERROR,message of error 3",
        "DEBUG,message of debug 2",
        "DEBUG,message of debug 3",
        "TRACE,message of trace 1");

    System.out.println(countByLogLevel(strings));

  }

  //Необходимо реализовать метод, который вернет мапу, содержащую количество ошибок определенного типа, преобразованное к enumam
  public static Map<LogLevel, Long> countByLogLevel(List<String> strings) {
    return strings.stream()
        .map(str -> str.split(","))
        .map(arr -> LogLevel.valueOf(arr[0]))
        .collect(Collectors.groupingBy(logLevel -> logLevel, Collectors.counting()));
  }

  public static class Log {

    private LogLevel logLevel;
    private String message;

    public Log(LogLevel logLevel, String message) {
      this.logLevel = logLevel;
      this.message = message;
    }

    public LogLevel getLogLevel() {
      return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
      this.logLevel = logLevel;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

  }

  public enum LogLevel {
    TRACE, DEBUG, ERROR;

    public static Map<String, LogLevel> map = Arrays.stream(LogLevel.values())
        .collect(Collectors.toMap(Enum::name, e -> e));

    public static LogLevel getLevel(String level) {
      return map.get(level);
    }
  }


}
