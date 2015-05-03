/* 
 * Based on http://www.javaworld.com/article/2073918/core-java/i-want-my-aop---part-1.html?page=2
 * by Ramnivas Laddad
 * 
 */
package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogCreditCardProcessorOperationsAspect {
    private void logOperation(String status, String operation, 
            CreditCard card, Currency amount) {
logger.log(status + " " + operation + 
 " Card: " + card + " Amount: " + amount);
}


	    Logger logger = new StdoutLogger();
	    @Pointcut("execution(public * CreditCardProcessor.*(..))")
	    public void publicOperation() {}
	        
	    @Pointcut("publicOperation() && args(card, amount)")
	    public void publicOperationCardAmountArgs(CreditCard card, Currency amount) {}
	        
	    @org.aspectj.lang.annotation.Before("publicOperationCardAmountArgs(card, amount)") 
	    		public void Before(JoinPoint joinpoint, CreditCard card, Currency amount){
	        logOperation("Starting",
	             joinpoint.getSignature().toString(), card, amount);
	    }
	    
	    @AfterReturning("publicOperationCardAmountArgs(card, amount)")
	        public void afterPublicOperationCardAmountArgs(JoinPoint joinpoint, CreditCard card, Currency amount) {
	        logOperation("Completing",
	            joinpoint.getSignature().toString(), card, amount);
	    }
	    @AfterThrowing(value="publicOperationCardAmountArgs(card, amount)", throwing="e")
	    public void afterThrowingPublicOperationCardAmountArgs(JoinPoint joinpoint, RuntimeException e, CreditCard card, Currency amount) {
	        logOperation("Completing",
	            joinpoint.getSignature().toString(), card, amount);
	    }
}
