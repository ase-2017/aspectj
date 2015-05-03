package twelveIsTheNewThirteen;

public class testMe {
	
	public int setAge(int i) {
		return i;
	}
	
	public static void main(String[] args) {
		testMe o = new testMe();
		
		int x = o.setAge(13);
		
		System.out.println(x);
	}

}
