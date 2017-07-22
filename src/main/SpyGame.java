package main;

import java.util.*;
import topicSets.foodSet;

public class SpyGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int playerNum;
		String blankConfirm;
		ArrayList<String> players = new ArrayList<>();
		//ArrayList playerOrder = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		
		int spys;
		int blanks;
		
		//get the number of players to generate playing field
		System.out.println("Please indicate the number of players: ");
		playerNum = sc.nextInt();
		System.out.println("Blanks on?: (Y/N) ");
		blankConfirm = sc.next();
		
		//set spys
		spys = Math.floorDiv(playerNum, 4);
		//System.out.println(spys);
		
		//set blanks
		if(blankConfirm.equalsIgnoreCase("Y")) {
			blanks = Math.floorDiv(playerNum, 6);
		}
		else {
			blanks = 0;
			System.out.println("Blank not set. ");
		}
		
		//get seed
		//int seed = rand.nextInt();
		int plebSeed = (int) (new Date().getTime()/1000000000);
		int blankSeed = (int) (new Date().getTime()/800000000);
		int spySeed = (int) (new Date().getTime()/1200000000);
		
		//initialize pleb and spy words, initialize who is spy and pleb and blanks
		foodSet foodset = new foodSet();
		String plebWord = foodset.getWord(plebSeed);
		String spyWord = foodset.getWord(spySeed);
		
		//check to make sure pleb and spy are not the same, otherwise keep trying
		
		//Players game1 = new Players(playerNum); //creates a playerset
		System.out.println("Please enter names: ");
		for(int i=0;i< playerNum ;i++) {
			System.out.println("Name of player: ");
			players.add(sc.nextLine());
			//timeseed%playerNum = spy,spys--, loop this until spys = 0
		}
		
		
		
	}
	
	
	public ArrayList<Boolean> setRoles(int playerNum, int spys,int blankSeed, int spySeed) {
		ArrayList<Boolean> playerRoles = new ArrayList<Boolean>(Arrays.asList(new Boolean[playerNum]));
		Collections.fill(playerRoles, Boolean.FALSE);
		
		while(spys != 0) {
			int tempSpySeed = spySeed % (playerNum+1);
			if(playerRoles.get(tempSpySeed) != true) {
				playerRoles.set(tempSpySeed, true);
			}
			
		}
		
		return playerRoles;
	}
	
}
