package emrea;
//EMRE ALPOGUNC DATA STRUCT.
//In this class, we are creating our Player class
//where we store all of the data for both of the instances
public class Player {
    private String name;//Player name
    private int num_play;//Player Score

    public Player(String name, int num_play) {//Constructor
        this.name=name;
        this.num_play=num_play;
    }
    //setters and getters
    public String getName() {return name;}//get name
    public int getNum_play() {return num_play;}//get score
    public void setNum_play(int num_play) {this.num_play = num_play;}//set score 
    public void setName(String name) {this.name = name;}//set player name
    

}

