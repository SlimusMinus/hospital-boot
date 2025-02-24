package aston.group86.hospitalboot.aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilingAspect {
  private final Map<String, MethodStats> stats = new ConcurrentHashMap<>();

  @Around("execution(* aston.group86.hospitalboot..*(..))")
  public Object profileMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long executionTime = System.currentTimeMillis() - startTime;

    String methodName = joinPoint.getSignature().toShortString();
    stats.compute(methodName, (key, value) -> {
      if (value == null)
        value = new MethodStats();
      value.incrementCount();
      value.addExecutionTime(executionTime);
      return value;
    });

    System.out.println("Method: " + methodName + ", executed in: " + executionTime + " ms");
    return result;
  }
  @Scheduled(fixedRate = 60000)
  public void logStats() {
    stats.forEach((method, stat) ->
        System.out.println("Method: " + method + ", executions: " + stat.getCount() + ", avg time: " + stat.getAverageTime() + " ms"));
  }
}
