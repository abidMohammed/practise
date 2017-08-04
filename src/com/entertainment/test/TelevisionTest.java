package com.entertainment.test;

import com.entertainment.*;
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
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates two Television objects, sets the instance variables,
 * and uses System.out.println to display them.
 */

class TelevisionTest {
	public static void main(String[] args) {
		
		Television[] tvArray = new Television[2];
		
		tvArray[0] = new ColorTelevision();
		tvArray[1] = new PortableTelevision();
		
		for(Television t:tvArray){
			System.out.println(t);
		}
	
	}
}
