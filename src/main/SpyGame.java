package main;

import java.util.*;
import topicSets.foodSet;

public class SpyGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int playerNum;
		String blankConfirm;
		//get the number of playerNames to generate playing field
		System.out.println("Please indicate the number of players: ");
		playerNum = sc.nextInt();
		System.out.println("Blanks on?: (Y/N) ");
		blankConfirm = sc.next();

		int spys;
		int blanks;
		//set spys
		spys = Math.floorDiv(playerNum, 4);
		//set blanks
		if(blankConfirm.equalsIgnoreCase("Y")) {
			blanks = Math.floorDiv(playerNum, 6);
		}
		else {
			blanks = 0;
			System.out.println("Blank not set. ");
		}
		
		//seeds for spy, blank, and pleb
		int tempSpySeed = rand.nextInt(playerNum);
		int tempBlankSeed = rand.nextInt(playerNum);
		int tempPlebSeed = rand.nextInt(playerNum);
		
		//check to make sure tempSpySeed and tempPlebSeed are not the same!!!
		
		
		//This is temporary, needs to move to setWords method later
		ArrayList<String> playerWords = new ArrayList<String>(Arrays.asList(new String[playerNum]));
		Collections.fill(playerWords, null);
		
		
		//call setRoles to assign roles this also needs to be implemented later
		ArrayList<Boolean> playerRoles = setRoles(playerNum, spys, blanks,tempSpySeed,tempBlankSeed);
		String spyWord = "ds"; //placeholder call greenFood whatever thing here
		String plebWord = "d"; //placeholder
		
		
		ArrayList<String> playerNames = new ArrayList<>();
		//fills out playerNames, also set words to playerWords depending on playerRoles booleans
		System.out.println("Please enter names: ");
		for(int i=0;i< playerNum ;i++) {
			System.out.println("Name of player: ");
			playerNames.add(sc.nextLine());
			if(playerRoles.get(i) == true) {
				playerWords.set(i, spyWord);
			}
			else if(playerRoles.get(i) == false) {
				playerWords.set(i, plebWord);
			}
		}
		
		
		//start doing the encryption stuff here
		
		
		//then need to make a kill off system to track spy or not
		
		
	}
	
	public static ArrayList<Boolean> setRoles(int playerNum, int spys,int blanks, int tempSpySeed, int tempBlankSeed) {
		ArrayList<Boolean> playerRoles = new ArrayList<Boolean>(Arrays.asList(new Boolean[playerNum]));
		Collections.fill(playerRoles, Boolean.FALSE);
		
		//run until all spys and blanks have been assigned
		while(spys > 0 && blanks > 0) {
			//int tempSpySeed = rand.nextInt(playerNum);
			
//			int tempSpySeed = temp % (playerNum+1);
			if(playerRoles.get(tempSpySeed) != true && playerRoles.get(tempSpySeed) != null) {
				playerRoles.set(tempSpySeed, true);
				spys--;
			}
			if(playerRoles.get(tempBlankSeed) != true && playerRoles.get(tempBlankSeed) != null) {
				playerRoles.set(tempBlankSeed, null);
				blanks--;
			}
			
		}
		
		return playerRoles;
	}
	
}
