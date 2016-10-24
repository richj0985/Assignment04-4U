
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author richj0985
 */
public class Doctor {
    
    // Instance Variables
    private int row;
    private int col;
    private Color colour;
    private boolean captured = false;
    
    // Constructor
    public Doctor(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    // Methods
    
    public boolean isCaptured (){
        return this.captured == true;
    }
    
    public void move (Doctor doctor, int newRow, int newCol){
        int ranRow = (int) (Math.random() * 11);
        int ranCol = (int) (Math.random() * 11);
        
        if(((newRow == doctor.row) || (newRow == doctor.row + 1) || (newRow == doctor.row - 1)) 
                && ((newCol == doctor.col) || (newCol == doctor.col + 1) || (newCol == doctor.col - 1))){
            this.row = newRow;
            this.col = newCol;
        } else{
            this.row = ranRow;
            this.col = ranCol;
        }
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public Color getColour(){
        if(this.captured){
            return this.colour = Color.YELLOW;
        }else{
            return this.colour = Color.GREEN;
        }
    }
    
     public void intersection(Dalek dalek){
        boolean crash = false;
        
        if(this.row == dalek.getRow() && this.col == dalek.getCol()){
            this.captured = true;
        }
    }
}
