//package pig;
//^only used for project programs that require a package

import java.util.*;

/**
 * CS249 GHP #2 Pig
 * 9/18/14, Last Revision(3): 9/25/14
 * @author Matt Preisendorfer
 * Program plays the game pig with two players, the computer and the user
 * Functions: main(), dice_roll(), AI(), User()
 */
public class Pig {
    
    public static void main(String[] args) {
/**
 *Main Function
 * @author Matt Preisendorfer
 * Variables:
 *  int user score
 *  int ai_score
 *  int turn
 *  Boolean winner
 * Process: to decide who's turn it  is and determine a winner
 * Parameters: String[] args
 */    
    int user_score = 0, //the User's score 
        ai_score = 0, //the Computers score
        turn = 0; //Who's turn it is, 0 = User, 1 = Computer 
    
    Boolean winner = false; //If someone has scored over 100 it beccomes true
    
        
        System.out.println("Welcome to Pig!");
        
      while(winner != true){  //while no one has won
        if(turn == 0){ //if it's the user's turn
          
           user_score = user_score + User(user_score); //score from current turn + user's score
            System.out.println("User Score Is " + user_score);
        
            if(user_score >= 100){ //if 100 or over the user wins
            System.out.println("User Wins!");
            winner = true; //there is a winner(the user)
            }
        turn = 1; //turn is now the computer's
        }
        
        else if(turn == 1){ //computer's turn
            ai_score = ai_score + AI(ai_score); //score from current turn + computer's score
            System.out.println("AI Score Is " + ai_score);    
         
            if(ai_score >= 100){ //if 100 or over computer wins
            System.out.println("AI Wins!");
            winner = true; //there is a winner(the computer)
            }
        turn = 0; //turn is now the user's    
        }
        
        
      }
    }
    
public static int dice_roll(){ 
/**
 *Function for rolling die
 * @author Matt Preisendorfer
 * Variables:
 *  int a = the value of the roll
 * Process: generates a random number between 1-6 and sets it to int a
 * Parameters: none
 */
    int a = 0; //resting to 0
    a = (int) (Math.random( ) * 6) +1; //random number between 1-6
    return a; //returns value rolled
}    

public static int AI(int ai_score){
/**
 *Function for Computers turn
 * @author Matt Preisendorfer
 * Variables:
 *  int roll = the value of the roll
 *  int current_turn_score = score of the current turn so far
 *  boolean end_turn = whether or not it is the end of the turn
 * Process: has the AI roll the dice until it has 20 or more points, then holds
 * Parameters: int ai_score 
 */    
    
    System.out.println("Computer's Turn");
    int roll = 0;
    boolean end_turn = false;
    int current_turn_score = 0;
    
    while(current_turn_score < 20 && end_turn != true && ai_score + current_turn_score < 100){ 
        roll = dice_roll();
       // System.out.println("Rolled " + roll);
     
        if(roll == 1){ //if rolled one, end turn and current_turn_score = 0
            current_turn_score = 0;
            end_turn = true;
        }
        else if(roll != 1){ //anything else add to current_turn_score
            current_turn_score = current_turn_score + roll;
        }        
    }//END OF WHILE current_score && end_turn
System.out.println("End of Computer's Turn");
return current_turn_score;    
}//END OF AI FUNCTION



public static int User(int user_score){
/**
 *Function for Users turn
 * @author Matt Preisendorfer
 * Variables:
 *  int roll = the value of the roll
 *  int current_turn_score = score of the current turn so far
 *  char inputs = the character the user inputs
 *  boolean end_turn = whether or not it is the end of the turn
 *  scanner input = gets the users input for roll or hold (r or h)
 * Process: has the User roll the dice of Hold, if score is 100 or over, ends turn automatically 
 * Parameters: int user_score 
 */    
        
    System.out.println("It's Your Turn");
    
    int roll = 0;
    boolean end_turn = false;
    int current_turn_score = 0;
    char inputs;
    Scanner input = new Scanner(System.in);
    
    while(end_turn != true && user_score + current_turn_score < 100){
    
    System.out.printf("Type " + "\"R\"" + " to roll or " + "\"H\"" + " to hold: ");
    inputs = input.next().charAt(0);  //GETS THE NEXT CHARACTER
    
        if(inputs == 'H' || inputs == 'h'){ //if user holds then end turn
            end_turn = true;
        }
        else if(inputs == 'R' || inputs == 'r'){ //if user rolls
            roll = dice_roll();
            System.out.println("Rolled " + roll);
                if(roll == 1){ //if 1 end turn and current_turn_score = 0
                current_turn_score = 0;
                end_turn = true;
                }
                else if(roll != 1){ //anything else add to current_turn_score
                current_turn_score = current_turn_score + roll;
                }            
        }
        else{ //user inputs something other than H or R
       System.out.println("Not A Valid Input");
        }
    
    }
   
return current_turn_score;
}
}


