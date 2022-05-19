package emrea;

public class TestEventQueueArray extends ESportsEvent {
	//EMRE ALPOGUNC 63190011 DATA STRUCT. HW 3
	TestEventQueueArray(int num,String a) {//constructor
		super(num,a);
	}
	public static void main(String[] args) {
		ESportsEvent game = new ESportsEvent(10,"GTA_Competition");
		
		Player p1 = new Player("Emre",0);//creating the object type variables
		Player p2 = new Player("Eren",0);
		Player p3 = new Player("Chris",0);
		Player p4 = new Player("Shinji",0);
		Player p5 = new Player("Grant",0);
		Player p6 = new Player("Josh",0);
		Player p7 = new Player("Cannur",0);
		Player p8 = new Player("Asuka",0);
		Player p9 = new Player("Rei",0);
		Player p10 = new Player("Mista",0);
		
		game.EnqueueINT(p1);//adding them to the queue
		game.EnqueueINT(p2);
		game.EnqueueINT(p3);
		game.EnqueueINT(p4);
		game.EnqueueINT(p5);
		game.EnqueueINT(p6);
		game.EnqueueINT(p7);
		game.EnqueueINT(p8);
		game.EnqueueINT(p9);
		game.EnqueueINT(p10);

		game.getGameName(game);//prints the game's name
		game.updateScore(game);//add the scores to the players from here
		//Execute the play method for 3 times.!!!!
		game.play(game);//first round 
		System.out.println("The Players and their scores: ");
		game.Display();//display the results after the first round
		game.play(game);//second round
		game.Display();//displays the results after the second round
		game.play(game);//playing the last round also prints the winner and the respective score of the winner.
		System.out.println("The Players and their respective scores: ");
		game.Display();//displays the finalists
	}

}
