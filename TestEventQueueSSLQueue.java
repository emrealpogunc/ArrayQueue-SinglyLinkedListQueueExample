package emrea;
//importing the necessary libraries
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
//EMRE ALPOGUNC 63190011 DATA STRUCT. HW 3 Second Part
public class TestEventQueueSSLQueue {
//Here, we are trying to do the same application but with SSL Queue instead of the
//Array Queue
	public static void main(String[] args) {
		String days[]= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};//again, we have the dates here
		int daycount=0;//daycount for days array's indexing. 
		int num = 0;
		int max=0;//max value
		String winname = " ";//winner's name 
		Queue<Player> n = new LinkedList<Player>();//our Queues in order to use them for upcoming rounds.
		Queue<Player> m = new LinkedList<Player>();
		Queue<Player> lost = new LinkedList<Player>();
		Queue<Player> asa = new LinkedList<Player>();
		
		Player p1 = new Player("Emre",0);//Creating our players
		Player p2 = new Player("Eren",0);
		Player p3 = new Player("Chris",0);
		Player p4 = new Player("Shinji",0);
		Player p5 = new Player("Grant",0);
		Player p6 = new Player("Josh",0);
		Player p7 = new Player("Cannur",0);
		Player p8 = new Player("Asuka",0);
		Player p9 = new Player("Rei",0);
		Player p10 = new Player("Mista",0);
		
		n.offer(p1);//Adding them to the queue.
		n.offer(p2);
		n.offer(p3);
		n.offer(p4);
		n.offer(p5);
		n.offer(p6);
		n.offer(p7);
		n.offer(p8);
		n.offer(p9);
		n.offer(p10);
	
		Random rand=new Random();//random number is going to be used for the players.
		//Those random numbers are going to be their scores.
		int a=n.size();
		//Aassigning the numbers to the players.
		for(int i=0;i<a;i++) {
			int k = rand.nextInt(110-30)+30;
			((LinkedList<Player>) n).get(i).setNum_play(k);
		}
		//First round's date
		System.out.println("Starting day: "+days[daycount]);
		//Prints the players and their scores 
		for(int i=0;i<n.size();i++) {
			System.out.print(((LinkedList<Player>) n).get(i).getName()+" ");
			System.out.print(((LinkedList<Player>) n).get(i).getNum_play()+" ");
		}

		if(n.size()>5){//day count, id it's bigger than 5
			//it's going to take 2 days to finish.
			daycount=daycount+2;
		}
		else {
			daycount++;//otherwise only 1 day.
		}
		//Addin the successful players from the prior queue to the
		//new queue
		for(int j=0;j<n.size();j++) {
		Player rr = ((LinkedList<Player>) n).get(j);
		int aa=rr.getNum_play();
		if(aa>=70){//round 1 in order to pass, the player needs at least 70 points.
			for(int kk=0;kk<n.size();kk++) {
				if(((LinkedList<Player>) n).get(kk).getNum_play()==aa) {
					int bb=((LinkedList<Player>) n).get(kk).getNum_play();
					m.offer(((LinkedList<Player>) n).get(kk));
				}
			}
		}
		}
		System.out.println(" ");
		System.out.println("Ending of Round: "+days[daycount]);
		System.out.println(" ");
		System.out.println("Starting day: "+days[daycount]);
		if(m.size()>5){//same daycount logic here, increases the index for the date
			daycount=daycount+2;
		}
		else {
			daycount++;
		}
		for(int i=0;i<m.size();i++) {//prints the players after the round 
			System.out.print(((LinkedList<Player>) m).get(i).getName()+" ");
			System.out.print(((LinkedList<Player>) m).get(i).getNum_play()+" ");
		}
		
		for(int j=0;j<m.size();j++) {//playing the round
		Player rr = ((LinkedList<Player>) m).get(j);
		int aa=rr.getNum_play();
		if(aa>=75){
			for(int kk=0;kk<m.size();kk++) {
				if(((LinkedList<Player>) m).get(kk).getNum_play()==aa) {
					int bb=((LinkedList<Player>) m).get(kk).getNum_play();
					lost.offer(((LinkedList<Player>) m).get(kk));
				}
			}
		}
		}
		System.out.println(" ");
		System.out.println("Ending of Round: "+days[daycount]);
		System.out.println(" ");
		System.out.println("Starting day: "+days[daycount]);
		if(lost.size()>5){//updating the dates here again
			daycount=daycount+2;
		}
		else {
			daycount++;
		}
		
		for(int i=0;i<lost.size();i++) {//printing the players and their points
			System.out.print(((LinkedList<Player>) lost).get(i).getName()+" ");
			System.out.print(((LinkedList<Player>) lost).get(i).getNum_play()+" ");
		}
		//playing the last round
		for(int j=0;j<lost.size();j++) {
		Player rr = ((LinkedList<Player>) lost).get(j);
		int aa=rr.getNum_play();
		if(aa>=80){
			for(int kk=0;kk<lost.size();kk++) {
				if(((LinkedList<Player>) lost).get(kk).getNum_play()==aa) {
					int bb=((LinkedList<Player>) lost).get(kk).getNum_play();
					asa.offer(((LinkedList<Player>) lost).get(kk));
				}
			}
		}
		}
		System.out.println(" ");
		System.out.println("Ending of Round: "+days[daycount]);
		System.out.println(" ");//printing the results of the round.
		for(int i=0;i<asa.size();i++) {
		System.out.print(((LinkedList<Player>) asa).get(i).getName()+" ");
		System.out.print(((LinkedList<Player>) asa).get(i).getNum_play()+" ");
		
		}
		//here, after the last round we find the winner 
		//We are both printing the score as well as the name of the player here.
		for (int countere = 0; countere < asa.size(); countere++)
		{
		     if (((LinkedList<Player>) asa).get(countere).getNum_play()> max)
		     {
		           max = ((LinkedList<Player>) asa).get(countere).getNum_play();//winner's score 
		           winname=((LinkedList<Player>) asa).get(countere).getName();//winner's name
		     }
		}
		System.out.println(" ");
		System.out.println("Winner: "+winname);//prints the winner's name 
		System.out.println("Winner's Score: "+max);//and winner's score
	}
}


