package inheritance;

import java.util.List;

public class Greetings {

	public void hello() {
		System.out.println(" super hello()");
	}

	public void greetHello() {
		hello();
	}

	public void greet(String greeting) {
		System.out.println(greeting);
	}
	
	public void greetAll(List<String> list) {
		for(String greeting: list) {
			greet(greeting);
		}
	}
}
