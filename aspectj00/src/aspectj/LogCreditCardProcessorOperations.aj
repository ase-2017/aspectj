/* 
 * Based on http://www.javaworld.com/article/2073918/core-java/i-want-my-aop---part-1.html?page=2
 * by Ramnivas Laddad
 * 
 */

package aspectj;

public aspect LogCreditCardProcessorOperations {
    Logger logger = new StdoutLogger();
    pointcut publicOperation():
        execution(public * CreditCardProcessor.*(..));
    pointcut publicOperationCardAmountArgs(CreditCard card, 
                                           Currency amount):
        publicOperation() && args(card, amount);
    before(CreditCard card, Currency amount):
        publicOperationCardAmountArgs(card, amount) {
        logOperation("Starting",
             thisJoinPoint.getSignature().toString(), card, amount);
    }
    after(CreditCard card, Currency amount) returning:
        publicOperationCardAmountArgs(card, amount) {
        logOperation("Completing",
            thisJoinPoint.getSignature().toString(), card, amount);
    }
    after (CreditCard card, Currency amount) throwing (Exception e):
        publicOperationCardAmountArgs(card, amount) {
        logOperation("Exception " + e, 
            thisJoinPoint.getSignature().toString(), card, amount);
    }
    private void logOperation(String status, String operation, 
                              CreditCard card, Currency amount) {
        logger.log(status + " " + operation + 
                   " Card: " + card + " Amount: " + amount);
    }
}