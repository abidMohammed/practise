package inheritance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

	BufferedReader br = null;
	Map<Integer, String> choiceDrinkMap = new HashMap<Integer, String>();
	Map<Integer, Integer> drinkPriceMap = new HashMap<Integer, Integer>();
	private int item;
	private int amountEntered;
	private int amountToReturn;
	private int totalAmount;
	private boolean invalidInput = true;
	private boolean hasSufficientFunds;
	private boolean resetAndRefund;

	public VendingMachine() {
		init();
		showmenu();
	}

	private void init() {
		choiceDrinkMap.put(1, "Coke");
		choiceDrinkMap.put(2, "Pepsi");
		choiceDrinkMap.put(3, "Soda");

		drinkPriceMap.put(1, 25);
		drinkPriceMap.put(2, 35);
		drinkPriceMap.put(3, 45);
	}

	private void showmenu() {
		totalAmount = 0;
		System.out.println("Press 1 for Coke, 2 for Pepsi, 3 for Soda");

		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String choice = br.readLine();
			item = Integer.parseInt(choice);
			if(item<1 || item >3){
				throw new NumberFormatException();
			}
			System.out.println("You Selected " + choiceDrinkMap.get(item));
			System.out.println("Please Pay " + getPrice(item) + " cents.You can enter 1,5,10,25 Cents only");
			do {
				hasSufficientFunds = collectMoney(choice);
			} while (!hasSufficientFunds);

			dispense(item);

			// reset();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Invalid Input.Please try again");
		} finally {
			showmenu();
		}
	}

	private boolean collectMoney(String a) throws IOException {
		totalAmount = accumulateCoins();

		if (totalAmount > getPrice(item)) {
			returnMoney();
		} else if (totalAmount < getPrice(item)) {
			totalAmount = accumulateCoins();
		}

		if (totalAmount >= getPrice(item)) {
			returnMoney();
			return true;
		}
		
		return false;
	}

	private void returnMoney() {
		amountToReturn = totalAmount - getPrice(item);
		if (amountToReturn > 0 && !resetAndRefund) {
			System.out.println("Please collect change of " + amountToReturn + " cents");
		}
	}
	
	private void refundMoney() {
		System.out.println("Cancelling Request .Please collect your " + totalAmount + " cents");
	}

	private int validate(String inputString) throws IOException {
		int inputNum = 0;

		try {
			inputNum = Integer.valueOf(inputString);

			do {
				if (inputNum == 1 || inputNum == 5 || inputNum == 10 || inputNum == 25 || inputNum == 99 || inputNum == 0) {
					invalidInput = false;
				} else {
					System.out.println(
							"Invalid Input. You Entered:" + inputString + " .Allowed Input: 1,5,10,25,99,0.Try Again");
					inputNum = Integer.parseInt(br.readLine());
				}
			} while (invalidInput);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input " + inputString + " .Please Enter Only Numbers.");
		}
		return inputNum;
	}

	private int accumulateCoins() throws IOException {
		boolean continueLoop;
		System.out.println("Item Price is " + getPrice(item) + ". You entered " + totalAmount + ".Pending coins "
				+ (getPrice(item) - totalAmount) + " cents");

		do {
			System.out.println("Enter coins as needed . Enter 99 to finish entering coins.Press 0 to cancel request");

			String input = br.readLine();
			amountEntered = validate(input);

			if (!input.contentEquals("99") && !input.contentEquals("0")) {
				totalAmount = totalAmount + amountEntered;
			}
			else if(input.contentEquals("0")){
				resetAndRefund=true;
			}
			continueLoop = input.contentEquals("99") || input.contentEquals("0");

		} while (!continueLoop);

		return totalAmount;
	}

	private int getPrice(int item) {
		return drinkPriceMap.get(item);
	}

	private void dispense(int item) {
		if(resetAndRefund){
			refundMoney();
		}
		else{
			System.out.println("Dispensing " + choiceDrinkMap.get(item) + ".Please collect your item");	
		}
	}
}