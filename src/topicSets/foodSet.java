package topicSets;

import java.util.ArrayList;
import java.util.List;

public class foodSet {
	//ArrayList<String> yellowFoods = new ArrayList<String>();
	String[] greenFood = {"Cabbage","Lettuce","Spinach","adsfas","dfadf"};
	
	public String getWord(int index) {
		index = index % (greenFood.length+1);
		return greenFood[index];
	}
}
