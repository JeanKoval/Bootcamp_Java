package JeanKoval.com.github.Padrao_Singleton.Singleton;

public class Singleton {
	private static Singleton uniqueInstance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return uniqueInstance;
	}
	
	public void HelloWorld() {
		System.out.println("Hello World!");
	}
}
