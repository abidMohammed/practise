package inheritance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
	
    BufferedReader br = null;
    Map<Integer,String> itemDrinkMap = new HashMap<Integer,String>();
    Map<Integer,Integer> drinkPriceMap = new HashMap<Integer,Integer>();
    int item=0;
    int amountEntered=0;
    int amountToReturn=0;
    int totalAmount=0;
    boolean invalidInput=true;


	public VendingMachine() {
		itemDrinkMap.put(1, "Coke");
		itemDrinkMap.put(2, "Pepsi");
		itemDrinkMap.put(3, "Soda");
		
		drinkPriceMap.put(1, 25);
		drinkPriceMap.put(2, 35);
		drinkPriceMap.put(3, 45);
		showmenu();
	}

	private void showmenu() {
		boolean hasSufficientFunds;
		System.out.println("Welcome.\nPress 1 for Coke, 2 for Pepsi, 3 for Soda");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	String a=br.readLine();
        	item=Integer.parseInt(a);
			System.out.println("You Selected "+itemDrinkMap.get(item));
			System.out.println("Please Pay "+getPrice(item)+" cents.You can enter 1,5,10,25 Cents only");
			do{
			hasSufficientFunds=collectMoney(a);
			}while(!hasSufficientFunds);

			dispense(item);
			
			//reset();
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}
	}
	
	private boolean collectMoney(String a) throws IOException{
		totalAmount=accumulateCoins();
		
		if(totalAmount>getPrice(item)){
			amountToReturn=totalAmount-getPrice(item);
			System.out.println("Please collect change of "+amountToReturn+" cents");
		}
		else if(totalAmount<getPrice(item)){
			System.out.println("Item Price is "+getPrice(item)+". You entered "+totalAmount);
			System.out.println("Please enter "+(getPrice(item)-totalAmount)+" cents");
			totalAmount=accumulateCoins();
		}
		
		if(totalAmount >= getPrice(item))
		{
			return true;
		}
		return false;
	}
	
	private int validate(int input) throws IOException{
		do{
		if(input == 1 || input == 5 || input == 10 || input == 25 || input == 99){
			invalidInput=false;
		}
		else{
			System.out.println("Invalid Input. You Entered:"+input+" .Allowed Input: 1,5,10,25,99.Try Again");
			input=Integer.parseInt(br.readLine());
		}
		}
		while(invalidInput);
		
		return input;
	}
	
	private int accumulateCoins() throws IOException{
		boolean continueLoop;
		
		do{
		System.out.println("Enter coins as needed . Enter 99 to finish entering coins");

		String input=br.readLine();
		amountEntered=validate(Integer.valueOf(input));

		if(!input.contentEquals("99")){
		totalAmount=totalAmount+amountEntered;
		}
	    continueLoop=input.contentEquals("99");

		}while(!continueLoop);
		
		return totalAmount;
	}
	
	private int getPrice(int item){
		return drinkPriceMap.get(item);
	}
	
	private void dispense(int item){
		System.out.println("Dispensing "+itemDrinkMap.get(item));
	}
}