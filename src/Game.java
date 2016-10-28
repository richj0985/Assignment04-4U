
import java.awt.Color;

/*
 * Dalek Assingment Game
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
                
        // DALEK CREATIONS
        Dalek dalek1 = new Dalek ();
        Dalek dalek2 = new Dalek ();
        Dalek dalek3 = new Dalek ();
        
        // Make sure dalek 1 doesn't spawn on other daleks
        do{
            
            dalek1.intersection(dalek2);
            dalek1.intersection(dalek3);

            if(dalek1.hasCrashed() == true){
                dalek1 = new Dalek();
            }else{
                break;
            }
        }while(true);
        
        // Make sure dalek 2 doesn't spawn on other daleks
        do{

            dalek2.intersection(dalek1);
            dalek2.intersection(dalek3);

            if(dalek2.hasCrashed() == true){
                dalek2 = new Dalek();
            }else{
                break;
            }
        }while(true);
        
        // Make sure dalek 3 doesn't spawn on other daleks
        do{
            
            dalek3.intersection(dalek1);
            dalek3.intersection(dalek2);

            if(dalek3.hasCrashed() == true){
                dalek3 = new Dalek();
            }else{
                break;
            }
        }while(true);
        
        // DOCTOR CREATION
        Doctor doctor = new Doctor ();
        
        // make sure the doctor doesn't spawn on any of the daleks
        do{
            
            doctor.intersection(dalek1);
            doctor.intersection(dalek2);
            doctor.intersection(dalek3);

            if(doctor.isCaptured() == true){
                dalek3 = new Dalek();
            }else{
                break;
            }
        }while(true);
        
        // Putting Pegs Down for Daleks
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
        
        // Putting Pegs Down for Doctor
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        
        // Put a message on the board
        board.displayMessage("Please click the board to play!");
        
        // Loop through the game
        while(true){            
            //                INTERSECTIONS
            // DOCTOR
            // Check if the doctor has been captured by any of the daleks
            doctor.intersection(dalek1);
            doctor.intersection(dalek2);
            doctor.intersection(dalek3);
            
            // DALEK
            // Check if any of the daleks have crashed yet
            dalek1.intersection(dalek2);
            dalek1.intersection(dalek3);
            
            dalek2.intersection(dalek1);
            dalek2.intersection(dalek3);
            
            dalek3.intersection(dalek1);
            dalek3.intersection(dalek2);
            
            // Change the peg colour of the daleks if they have found to be intersected
            if(dalek1.hasCrashed() == true){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            
            if(dalek2.hasCrashed() == true){
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            
            if(dalek3.hasCrashed() == true){
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            
            //                      END GAME
            // If the Doctor is captured than the game is over
            if(doctor.isCaptured() == true){
                board.displayMessage("You Lose, Game Over!");
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                break;
            }
            
            // Check to see if the game is over
            if(dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()){
                board.displayMessage("You Win!");
                break;
            }
            
            //                   DOCTOR MOVEMENTS
            // Doctor
            // Check if the doctor has been captured or not
            // If not then he may move throughout the board
            if(doctor.isCaptured() == false){
                // Get a click on the board
                Coordinate click = board.getClick();
                board.removePeg(doctor.getRow(), doctor.getCol());
                doctor.move(click.getRow(), click.getCol());
                board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            }
            
            //                     DALEK MOVEMENTS
            // DALEK 1
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek1.hasCrashed() == false){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advanceTowards(doctor);
            } 
                       
            // DALEK 2
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek2.hasCrashed() == false){
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advanceTowards(doctor);
            } 
            
            // DALEK 3
            // Check to see if the dalek has crashed
            // If not than it may move toward the doctor
            if(dalek3.hasCrashed() == false){
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advanceTowards(doctor);
            }
            
            // Put all of the Dalek pegs down into the new positions
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
        }
          
    }
}
