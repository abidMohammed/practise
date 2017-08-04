package com.entertainment;

public class ColorTelevision extends Television{
	
	private int colorTint=5;

	public int getColorTint() {
		return colorTint;
	}

	public void setColorTint(int colorTint) {
		this.colorTint = colorTint;
	}
	
	@Override
	public String toString() {
		return "ColorTelevision [colorTint="+ colorTint+" " +super.toString()+ "]";
	}

}
