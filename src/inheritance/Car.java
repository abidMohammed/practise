package inheritance;

public enum Car {
	AUDI("A4",35000.1),
	TESLA("MODEL S",22000.1),
	FORD("MUSTAND",25000.1),
	HONDA("CIVIC",20000.1);
	
	private String name;
	private double price;
	
	private Car(String name,double price){
		this.name=name;
		this.price=price;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
}
