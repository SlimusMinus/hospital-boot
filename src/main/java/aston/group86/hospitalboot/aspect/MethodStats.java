package aston.group86.hospitalboot.aspect;

public class MethodStats {
  private long count = 0;
  private long totalExecutionTime = 0;

  void incrementCount() {
    count++;
  }

  void addExecutionTime(long time) {
    totalExecutionTime += time;
  }

  long getCount() {
    return count;
  }

  long getAverageTime() {
    return count == 0 ? 0 : totalExecutionTime / count;
  }
}
