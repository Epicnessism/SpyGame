package main;

import java.util.ArrayList;

public class Players {
	
	private int numPlayers;
	ArrayList players = new ArrayList<>();
	
	public Players(int currentPlayers) {
		//this.numPlayers = currentPlayers;
		
	}
	
	public int getNum() {
		return this.numPlayers;
	}
	
	public void setNum(int currentPlayers) {
		this.numPlayers = currentPlayers;
	}
	
	public static void initPlayers(int playerNum) {
		
	}
}
