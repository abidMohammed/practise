package inheritance;

import java.util.Arrays;
import java.util.List;

//Solves the inheritance issue that MyGreetings.java has.
//This uses the Decorator pattern, sometimes called 'delegation'
public class ForwardingGreetings {
	private Greetings gr;   // composition; has-a instead of is-a
	
	public ForwardingGreetings() {
		gr = new Greetings();
	}
	
	//Forwarding methods
	public void greet(String greeting) {
		gr.greet(greeting);
	}

	
	public void greetAll(List<String> list) {
		gr.greetAll(list);
	}
	

}
