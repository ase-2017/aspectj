package aspectj;

public class StdoutLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println(message);

	}

}
