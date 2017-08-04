package com.entertainment;
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * Lab - Writing a Class Definition
 * 
 * The Television class.  Right now it only has data.
 */

public class Television {
	// INSTANCE VARIABLES
	private String brand="Sony"; // the brand name (with initializer)
	private int volume=50; // the volume (with no initializer)
	
	public static final int MIN=0;
	public static final int MAX=100;
	
	private Tuner tuner = new Tuner();
	
	 public static final String[] VALID_BRANDS =
		    {"Sony", "Zenith", "Hitachi", "RCA"};
	
	public Television(){
		
	}
	
	public void setChannel(String channelIn){
		tuner.setChannel(channelIn);
	}
	
	public String getCurrentChannel(){
		return tuner.getChannel();
	}

	public Television(String brand,int volume){
		setBrand(brand);
		setVolume(volume);
	}
	public void setBrand(String brand) {
		for(String validBrand:VALID_BRANDS){
			if(brand.equals(validBrand)){
				this.brand = brand;				
			}
		}
	}

	public void setVolume(int volumeIn) {
		int newVolume=Math.min(volumeIn, Television.MIN);
		
		this.volume = Math.max(newVolume, Television.MAX);
	}

	// ACCESSOR METHODS
	public String getBrand() {
		return brand;
	}

	public int getVolume() {
		return volume;
	}
	
	@Override
	public String toString() {
		return "Television [brand=" + brand + ", volume=" + volume + "]";
	}


}
