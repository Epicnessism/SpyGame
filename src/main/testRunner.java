package main;

import java.util.ArrayList;

//import java.lang.*;
public class testRunner {
	public static void main(String[] args) {
//		int pl = 9;
//		System.out.println(pl % 5);
		
		ArrayList playerRoles = new ArrayList();
		int playerNum = 6;
		for(int i=1;i<=playerNum;i++) {
			playerRoles.add(i);
			System.out.println(playerRoles);
		}
	}
}
