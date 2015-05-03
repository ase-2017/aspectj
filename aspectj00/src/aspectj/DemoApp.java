package aspectj;

public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCard cc = new CreditCard();
		CreditCardProcessor ccp = new CreditCardProcessor();
		Currency amount = new Currency(20, "EUR");
		
		try {
			ccp.credit(cc, amount);
		} catch (InvalidCardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
