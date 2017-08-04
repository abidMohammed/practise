package inheritance;

import java.util.Arrays;
import java.util.List;

public class InstrumentedGreetingsWrapper extends ForwardingGreetings{  // solves extends Greeting issue below

	private int greetingCount = 0;
	@Override
	public void greet(String greeting) {
		greetingCount++;
		super.greet(greeting);
	}

	//Simply using a method that belongs to a superclass without really knowing its
	//inner-workings may produce unexpected results
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
		InstrumentedGreetingsWrapper mg = new InstrumentedGreetingsWrapper();
		List<String> list = Arrays.asList("hi","hello", "howdy");
		mg.greet("wazzup");
		mg.greetAll(list);
		System.out.println("I sent " + mg.greetingCount + " greetings"); //Prints: I sent 4 greetings
	}

}
