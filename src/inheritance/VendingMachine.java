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
		System.out.println("Welcome.\nPress 1 for Coke, 2 for Pepsi, 3 for Soda");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	String a=br.readLine();
        	item=Integer.parseInt(a);
			System.out.println("You Selected "+itemDrinkMap.get(item));
			System.out.println("Please Pay "+getPrice(item)+" cents");
			amountEntered=Integer.parseInt(a);
			dispense(item,amountEntered);
			reset();
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}
	}
	
	private int getPrice(int item){
		return drinkPriceMap.get(item);
	}
	
	private void dispense(int item,int amountEntered){
		if(amountEntered>getPrice(item)){
			System.out.println("Dispensing "+itemDrinkMap.get(item));
			amountToReturn=amountEntered-getPrice(item);
			System.out.println("Please collect change of "+amountToReturn+" cents");
		}
		else if(amountEntered<getPrice(item)){
			System.out.println("Item Price is "+getPrice(item)+"You entered "+amountEntered);
			System.out.println("Please enter "+(getPrice(item)-amountEntered)+" cents");
		}
		else{
			System.out.println("Dispensing "+itemDrinkMap.get(item));
		}
		
	}
	
	private void reset(){
		System.out.println("Reset completed");
	}
}