package JeanKoval.com.github.gof.singleton;


/**
 * Singleton "Apressado"
 *
 * @author jeanck
 */
public class SingletonEager {
	
	private static SingletonEager instancia = new SingletonEager();
	
	private SingletonEager() {
		super();
	}
	
	public static SingletonEager getInstancia() {
		return instancia;
	}
}
