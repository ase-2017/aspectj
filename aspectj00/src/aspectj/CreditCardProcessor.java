package aspectj;

public class CreditCardProcessor {
    public void debit(CreditCard card, Currency amount) 
       throws InvalidCardException, NotEnoughAmountException,
              CardExpiredException {
        // Debiting logic
    }
    
    public void credit(CreditCard card, Currency amount) 
        throws InvalidCardException {
        // Crediting logic
    }
}