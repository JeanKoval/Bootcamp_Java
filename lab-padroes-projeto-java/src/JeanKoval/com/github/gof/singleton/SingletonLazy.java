package JeanKoval.com.github.gof.singleton;


/**
 * Singleton "Pregui�oso"
 *
 * @author jeanck
 */
public class SingletonLazy {
	
	private static SingletonLazy instancia;
	
	private SingletonLazy() {
		super();
	}
	
	public static SingletonLazy getInstancia() {
		if(instancia == null)
			instancia = new SingletonLazy();
		return instancia;
	}
}
