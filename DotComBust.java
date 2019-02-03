import java.util.*;

public class DotComBust{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList= new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	private void setUpGame(){
	DotCom one=new DotCom();
	one.setName("Santa Maria");
	DotCom two=new DotCom();
	two.setName("USS Constitution");
	DotCom three=new DotCom();
	three.setName("USS Arizona");
	dotComsList.add(one);
	dotComsList.add(two);
	dotComsList.add(three);
	System.out.println("Your goal is to sink three Enemy Ships\nTry to sink them all in the fewest number of guesses\n");
	System.out.println("The ships are placed in a 7x7 grid.\nRows are named from Alphabets(A-G) and the columns are named from 0-6\nThe length of each ship is 3 cells placed consecutively in horizontal or vertical orientation\n");
	System.out.println("Input should be row then column (ex:C4)\n");
	System.out.println("All The Best\n");
	
	for(DotCom dotComToSet:dotComsList){
	ArrayList<String> newLocation=helper.placeDotCom(3);
	dotComToSet.setLocationCells(newLocation);
	}
	}
	
	private void startPlaying(){
		while(!dotComsList.isEmpty()){
			String userGuess=helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess){
	numOfGuesses++;
	String result="miss";
	for(DotCom dotComToTest:dotComsList){
		result=dotComToTest.checkYourself(userGuess);
		if(result.equals("hit")){
			break;
		}
		if (result.equals("kill")){
			dotComsList.remove(dotComToTest);
			break;
	}}
	System.out.println(result);
	}
	
	private void finishGame(){
		System.out.println("All dot coms are dead, our stock is now worth nothing");
	if(numOfGuesses<=18){
		System.out.println("It only took you "+numOfGuesses+" guesses to finish the game");
	}else{
		System.out.println("Took you long enough "+numOfGuesses+" guesses to finish the game");
	}}
	
public static void main(String[] args){
DotComBust game=new DotComBust();
game.setUpGame();
game.startPlaying();
}
}	
		