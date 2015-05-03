package twelveIsTheNewThirteen;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProceedAspect {

  @Pointcut("call(* *.setAge(..)) && args(i)")
  void setAgeCall(int i) {}

  @Pointcut("execution(* *.setAge(..)) && args(i)")
  void setAgeExec(int i) {}

/* Remove later, see below
  @Around("setAgeCall(i)")
  public Object advice1d(ProceedingJoinPoint thisJoinPoint, int i) throws Throwable {
    return thisJoinPoint.proceed(new Object[]{i/2}); //using Java 5 autoboxing
  }
*/
  
  /* Remove this first
  @Around("setAgeExec(i)")
  public Object advice2(ProceedingJoinPoint thisJoinPoint, int i) throws Throwable {
    return thisJoinPoint.proceed(new Object[]{i*2}); //using Java 5 autoboxing
  }
  
  */
}