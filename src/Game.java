
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
        
        Doctor doctor = new Doctor (6, 6);
        board.putPeg(Color.GREEN, 6, 6);
        
        Dalek dalek1 = new Dalek (11, 11);
        board.putPeg(Color.BLACK, 11, 11);
        
        Dalek dalek2 = new Dalek (0, 0);
        board.putPeg(Color.BLACK, 0, 0);
        
        Dalek dalek3 = new Dalek (11, 0);
        board.putPeg(Color.BLACK, 11, 0);
        
        System.out.println(dalek2.hasCrashed());
      
//       Put a coloured peg at row, col
//       board.putPeg(Color.RED, 1, 5);
//       board.putPeg(Color.MAGENTA, 2, 6);
        
//         Remove a coloured peg at row, col
//        board.removePeg(1, 5);
        
        // Put a message on the board
        board.displayMessage("Please click the board");
        
        while(true){
            // Get a click on the board
            Coordinate click = board.getClick();
            board.removePeg(doctor.getRow(), doctor.getCol());
            doctor.move(doctor, click.getRow(), click.getCol());
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            
            if(dalek1.hasCrashed() == false){
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            }
            
            if(dalek1.hasCrashed() == false){
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            }
            
            if(dalek3.hasCrashed() == false){
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advanceTowards(doctor);
                board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
            }
            
//            // Put a peg on the board by clicking
//            board.putPeg(Color.MAGENTA, row, col);
        }
        
        
        
        
    }
}
