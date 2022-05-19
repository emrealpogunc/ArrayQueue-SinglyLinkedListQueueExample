package emrea;
import java.util.Scanner;
//EMRE ALPOGUNC 63190011 DATA STRUCT. HW 3 
public class ESportsEvent {
	int frontINT,rearINT,capacityINT,rear,front,cap;//Array Queue needs these
	//Variables in order to be implemented perfectly.
	//fronINT is the front of the queue while rearINT is the rear or the back of the queue.
	
	String gName;//game name 
	Player queue[];//the main queue which we are going to use for the Array Queue.
	Player que[];
	String days[]= {"Monday","Tuesday","Wednesday",
			"Thursday","Friday","Saturday","Sunday"};//days to be displayed
	int day_count=0;//day counter to be used as index
	int round=0;//round counter
	String winname;
	int max=0;//max value of the queue
	Player winner;
	
	ESportsEvent(int num,String name){//Constructor
		capacityINT=num;
		frontINT=rearINT=0;
		queue=new Player[capacityINT];
		gName=name;
	}
	
	String getGameName(ESportsEvent a) {
		return a.gName;
	}//Prints the game name 
	
	void EnqueueINT(Player n) {//Enqueue application is here
		if(capacityINT==rearINT) {//if capacaity is the rear of the array
			//then that means the array is empty.
			System.out.println("The Array Queue is Full.");
		}
		
		else {
			queue[rearINT]=n;//otherwise if it's not empty
			//add the value to the rear and increase the rear value
			rearINT++;
		}
	}
	
	void DequeueINT() {//Dequeue application method is here 
		if(rearINT==frontINT) {//if the rear is equal to the front then
			//there is no element to pull out.
			return;
		}
		else {
            for (int i=0;i<rearINT-1;i++) {
                queue[i]=queue[i+1];//shift the indexes
            }
            if (rearINT < capacityINT) {//store nulls as the indicator of empty indexes.
                queue[rearINT] = null;
                }
            rearINT--;
		}
	}

	
	void Display() {//Displays the array queues
		System.out.println(" ");
		if(rearINT==frontINT){
			System.out.println("The Array Queue is Empty.");
		}
		else {
			for(int i=frontINT;i<rearINT;i++) {
				Player a=queue[i];
				System.out.print(a.getName()+" ");
			}
			System.out.println(" ");
			for(int i=frontINT;i<rearINT;i++) {
				Player a=queue[i];
				System.out.print(a.getNum_play()+" ");
			}
			
		}
		System.out.println(" ");
		}
	
	void updateScore(ESportsEvent g) {//The updating method where we update the method via
		//taking the values as an input from the user and we overwrite the previoulsy written values.
		Scanner tes = new Scanner(System.in);
		for(int i =0;i<g.queue.length;i++) {
			if(g.queue[i]!=null) {
			System.out.println("Please enter the score for the player "+g.queue[i].getName()+":");
			int obj = tes.nextInt();
			g.queue[i].setNum_play(obj);
			System.out.println(g.queue[i].getName()+"'s score is now: "+g.queue[i].getNum_play());
			}
		}
	}
	
	
	void play(ESportsEvent g) {//The main method where the game occurs
		ESportsEvent temp = new ESportsEvent(10,gName);
		round++;//setting the round
		int count=0;
		int num=0;

		if(round==1) {//score limits for each round.
			num=70;
		}
		if(round==2){
			num=75;
		}
		if(round==3){
			num=80;
		}
		System.out.println("Playing day: "+days[day_count]);
		
		if(day_count==6){day_count=0;}//if it's sunday take it back to monday
		if(g.queue.length>5) {
			day_count=day_count+2;//If the array content is bigger than 5
			//it will take 2 days to finish since we are working with 10 people.
		}
		else {//otherwise just increase by one
		day_count=day_count+1;
		}
		//We add the successful players to a temporary temp queue to be transfered to our original queue again.
		for(int i =0;i<g.queue.length;i++) {
			if(g.queue[i]!=null) {
			int a=g.queue[i].getNum_play();
			if(a>=num) {
				temp.EnqueueINT(g.queue[i]);
				count++;
		
		}

		}
		}
		//emptying the main queue to include the temp content
		for(int i=0;i<g.queue.length;i++) {
			g.DequeueINT();
		}
		//including the temp's content here.
		for(int i=0;i<count;i++){
			g.EnqueueINT(temp.queue[i]);
		}
		//if it's round 3 it's the last part so we need to end the method and give the results.
		if(round==3) {
			for (int countere = 0; countere < g.queue.length; countere++)
			{
				if(g.queue[countere]!=null) {
			     if (g.queue[countere].getNum_play() > max)
			     {
			           max = g.queue[countere].getNum_play();
			           winname=g.queue[countere].getName();
			     }
				}
			}
			
			System.out.println("Winner's Score: "+max);//prints the winner's score 
			System.out.println("Winner: "+winname);//prints the winners name 
		}
		System.out.println("Next day to be played: "+days[day_count]);//ending day of the tournament
		System.out.println("Round: "+round);//round number
	}
	
	}
	
	
	

