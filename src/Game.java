
import java.awt.Color;

/*
 * Dalek Assignment Game
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
                
        //
        // DALEK CREATIONS 
        //
        // Create each dalek one at a time and ensure
        // they don't create in the same random location
        
        // create Dalek1.  No issue of crash with others
        Dalek dalek1 = new Dalek ();
        
        // create dalek2 and check to ensure isn't in 
        // same location as dalek 1.  If it is pick a new
        // new location
        Dalek dalek2 = new Dalek ();
        do {      
            // determine if in same location a other daleks
            // if it is it will set the dalek to crashed state
            // if crashed pick new lcoation
            dalek2.intersection(dalek1);
            if(dalek2.hasCrashed()){
                // pick new random location for the dalek
                dalek2.setRandomLocation();
            }
        }while(dalek2.hasCrashed());

        // create dalek3 and check to ensure isn't in 
        // same location as dalek 1.  If it is pick a new
        // new location
        Dalek dalek3 = new Dalek ();
        do {      
            // determine if in same location a other daleks
            // if it is it will set the dalek to crashed state
            // if crashed pick new lcoation
            dalek3.intersection(dalek1);
            dalek3.intersection(dalek2);
            if(dalek3.hasCrashed()){
                // pick new random location for the dalek
                dalek3.setRandomLocation();
            }
        }while(dalek3.hasCrashed());

        
        // DOCTOR CREATION
        // create the doctor and see if already captured by dalek
        // if already captured pick a new location
        Doctor doctor = new Doctor ();
        do{
            // determine if doctor already captured by dalek
            doctor.intersection(dalek1);
            doctor.intersection(dalek2);
            doctor.intersection(dalek3);

            // if already catpured pick a new location
            if(doctor.isCaptured()){
                dalek3.setRandomLocation();
            }
        }while(doctor.isCaptured());
        
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
            //
            //          INTERSECTIONS
            //
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
            if(dalek1.hasCrashed()){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            
            if(dalek2.hasCrashed()){
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            
            if(dalek3.hasCrashed()){
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            
            
            //
            //        END GAME
            //
            // If the Doctor is captured than the game is over
            if(doctor.isCaptured()){
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
            
            //
            //        DOCTOR MOVEMENTS
            //
            // Check if the doctor has been captured or not
            // If not then he may move throughout the board
            if(doctor.isCaptured() == false){
                // Get a click on the board
                Coordinate click = board.getClick();
                board.removePeg(doctor.getRow(), doctor.getCol());
                doctor.move(click.getRow(), click.getCol());
                board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            }

            //
            //        DALEK MOVEMENTS
            //
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
