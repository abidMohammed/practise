package inheritance;

import java.util.Arrays;
import java.util.List;

public class MyGreetings extends Greetings{
	private int greetingCount = 0;
	@Override
	public void greet(String greeting) {
		greetingCount++;
		super.greet(greeting);
	}

	//Simply using a method that belongs to a superclass without really knowing its
	//implementation details may produce unexpected side-effects.
	//
	@Override
	public void greetAll(List<String> list) {
		greetingCount += list.size();
		super.greetAll(list);
	}
	
	public int getGreetingCount() {
		return greetingCount;
	}


	public static void main(String[] args) {
		MyGreetings mg = new MyGreetings();
		List<String> list = Arrays.asList("hi","hello", "howdy");
		mg.greet("wazzup");
		mg.greetAll(list);
		System.out.println("I sent " + mg.greetingCount + " greetings"); //Prints: I sent 7 greetings

		//mg.greetHello();
	}

}
