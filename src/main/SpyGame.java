package main;

import java.util.*;
import topicSets.foodSet;

public class SpyGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Random rand = new Random();
		
		//Variables used:
		int playerNum; //user input of players in the game
		String blankConfirm; //user input if blanks are wanted
		int spys; //the num of spys remaining
		int blanks; //num of blanks remaining
		int plebs; //num of normal people remaining
		int survivingPlayers; //total remaining players

		//get the number of playerNames to generate playing field
		System.out.println("Please indicate the number of players: ");
		playerNum = sc.nextInt();
		sc.nextLine(); //gets rid of extra newline
		System.out.println("Blanks on (if possible)?: (Y/N) ");
		blankConfirm = sc.nextLine();
		
		//create the players arraylist
		Players current_players = new Players(playerNum);
		current_players.getNum();
		

		spys = Math.floorDiv(playerNum, 3); //set spys
		blanks = blankConfirm.equalsIgnoreCase("Y") ? Math.floorDiv(playerNum, 4) : 0; //creates the spys if wanted
		plebs = playerNum - (spys + blanks); //sets rest of people to normal people
		survivingPlayers = playerNum; //no one is dead yet

		//visual test all numbers were correctly and reasonable //TODELETE
		System.out.println("Spys: "+ spys);
		System.out.println("Blanks: "+ blanks);
		System.out.println("Plebs: "+ plebs);
		

		//This is temporary, needs to move to setWords method later
		//default null setting of playerWords array before populating
		ArrayList<String> playerWords = new ArrayList<String>(Arrays.asList(new String[playerNum]));
		Collections.fill(playerWords, null); //easy way to populate arraylist with nulls
		

		//call setRoles to assign roles this also needs to be implemented later
		ArrayList<Boolean> playerRoles = SpyGame.setRoles(playerNum, spys, blanks);

		//then find their role, and apply their word accordingly method to be implemented //TODO
		String spyWord = "ds"; //placeholder call greenFood whatever thing here
		String plebWord = "d"; //placeholder
		
		ArrayList<String> playerNames = new ArrayList<>();
		//fills out playerNames, also set words to playerWords depending on playerRoles booleans
		for(int i=0;i < playerNum ;i++) {
			System.out.println("Name of player: ");
			playerNames.add(sc.nextLine());
			
			if(playerRoles.get(i) == null) {
				playerWords.set(i, "Blank");
			}
			else if(playerRoles.get(i) == true) {
				playerWords.set(i, spyWord);
			}
			else if(playerRoles.get(i) == false) {
				playerWords.set(i, plebWord);
			}
			System.out.println(playerWords);
		}
		System.out.println(playerNames);
		System.out.println(playerRoles);
		System.out.println(playerWords);
		
		while(!spyTrueWinCondition(playerNum, survivingPlayers, spys, plebs, blanks)) {
			whoToKill(playerNames, playerRoles, playerWords, spys, plebs, blanks); //start killing people
			System.out.println(playerNames);
			System.out.println(playerRoles);
			System.out.println(playerWords);
		}
		
		
		//start doing the encryption stuff here
		//actually probably don't need encrpytion anymore
		
	}
	
	//sets the roles of each player to either a spy, blank, or pleb randomly
	public static ArrayList<Boolean> setRoles(int playerNum, int spys,int blanks) {
		ArrayList<Boolean> playerRoles = new ArrayList<Boolean>(Arrays.asList(new Boolean[playerNum]));
		Collections.fill(playerRoles, Boolean.FALSE);
		System.out.println(playerRoles);
		
		Random rand = new Random();
		
		while(spys > 0 || blanks > 0) {
			
			//seeds for spy, blank, and pleb
			int tempSpySeed = rand.nextInt(playerNum);
			int tempBlankSeed = rand.nextInt(playerNum);
//			int tempPlebSeed = rand.nextInt(playerNum);

			if(playerRoles.get(tempSpySeed) == false) {
				playerRoles.set(tempSpySeed, true);
				spys--;
//				System.out.println(playerRoles);
			}
			if(playerRoles.get(tempBlankSeed) == false) {
				playerRoles.set(tempBlankSeed, null);
				blanks--;
				System.out.println(playerRoles);
			}
			
		}
		return playerRoles;
	}
	
	public static boolean spyTrueWinCondition(int playerNum, int survivingPlayers, int spys, int plebs, int blanks) {
		if(spys > 0) {
			return false;
		}
		else if(playerNum <= 8 && survivingPlayers <= 3 && spys > 0) {
			return true; //spys win
		}
		else if (playerNum > 8 && survivingPlayers <= 4 && spys > 0) {
			return true; //too many rounds, 3 people would be too easy
		}
		return false;
	}
	
	public static String whoToKill(ArrayList<String> playerNames, ArrayList<Boolean> playerRoles, ArrayList<String> playerWords, int spys, int plebs, int blanks) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Who is to be killed?: ");
			String killed = sc.nextLine();
			for(int i = 0; i < playerNames.size(); i++) {
				if (playerNames.get(i).equalsIgnoreCase(killed)) {
					playerWords.set(i,"Dead");
					System.out.println(playerRoles.get(i));
					if(playerRoles.get(i) == null) {
//						blank
						return "Whiteboard";
					}
					else if(playerRoles.get(i) == true) {
						return "Spy";
					}
					else if (playerRoles.get(i) == false) {
						return "Pleb";
					}
				}
			}
		}
	}
}
