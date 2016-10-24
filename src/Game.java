
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author richj0985
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create the Game Board
        Board board = new Board(12, 12);     
        
        // DOCTOR CREATION
        Doctor doctor = new Doctor (6, 6);
        board.putPeg(Color.GREEN, 6, 6);
        
        // DALEK CREATIONS
        // Dalek 1
        Dalek dalek1 = new Dalek (11, 11);
        board.putPeg(Color.BLACK, 11, 11);
        
        // Dalek 2
        Dalek dalek2 = new Dalek (0, 0);
        board.putPeg(Color.BLACK, 0, 0);
        
        // Dalek 3
        Dalek dalek3 = new Dalek (11, 0);
        board.putPeg(Color.BLACK, 11, 0);
        
        // Put a message on the board
        board.displayMessage("Please click the board to play!");
        
        while(true){
            
            //               CHECKING INTERSECTIONS
            // Check if the doctor has been captured by any of the daleks
            doctor.intersection(dalek1);
            doctor.intersection(dalek2);
            doctor.intersection(dalek3);
            
            // Check if any of the daleks have crashed yet
            dalek1.intersection(dalek2);
            dalek1.intersection(dalek3);
            
            dalek2.intersection(dalek1);
            dalek2.intersection(dalek3);
            
            dalek3.intersection(dalek1);
            dalek3.intersection(dalek2);
            
            //                   DOCTOR MOVEMENTS
            // Check if the doctor has been captured or not
            // If not then he may move throughout the board
            if(doctor.isCaptured() == false){
                // Get a click on the board
                Coordinate click = board.getClick();
                board.removePeg(doctor.getRow(), doctor.getCol());
                doctor.move(doctor, click.getRow(), click.getCol());
                board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            // If he has been captured then the game is over and you lose
            } else{
                board.displayMessage("You Lose, Game Over!");
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                break;
            }
            
            //                     DALEK MOVEMENTS
            // Check if all the daleks have crashed and if so then the game is over and you win
            if(dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()){
                board.displayMessage("You Win!");
                break;
            }
            
            // DALEK 1
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek1.hasCrashed() == false){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            } 
            
            // Checking Intersection again after movement
            dalek1.intersection(dalek2);
            dalek1.intersection(dalek3);
            
            // Check to see if the dalek has crashed again
            // If so than it can no longer move
            if(dalek1.hasCrashed() == true){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            
            // DALEK 2
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek2.hasCrashed() == false){
                
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            } 
            
            // Checking Intersection again after movement
            dalek2.intersection(dalek1);
            dalek2.intersection(dalek3);
            
            // Check to see if the dalek has crashed again
            // If so than it can no longer move
            if(dalek2.hasCrashed() == true){
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            
            // DALEK 3
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek3.hasCrashed() == false){
                
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
            }
            
            // Checking Intersection again after movement
            dalek3.intersection(dalek1);
            dalek3.intersection(dalek2);
            
            // Check to see if the dalek has crashed again
            // If so than it can no longer move
            if(dalek3.hasCrashed() == true){
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            
        }
          
    }
}
