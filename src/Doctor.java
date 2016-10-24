

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
    private boolean captured = false;
    
    
    /**
     * Constructor to create a doctor
     */
    public Doctor(){
        int ranDocRow = (int) (Math.random() * 11);
        int ranDocCol = (int) (Math.random() * 11);
        this.row = ranDocRow;
        this.col = ranDocCol;
    }
    
    // METHODS
    /**
     * Returns the row that the doctor is on
     * @return the row that the doctor is on
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Returns the column that the doctor is on
     * @return the column that the doctor is on
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * Movement of Doctor
     * @param newRow the new row that the doctor is going to move to
     * @param newCol the new column that the doctor is going to move to
     */
    public void move (int newRow, int newCol){
        int ranRow = (int) (Math.random() * 11);
        int ranCol = (int) (Math.random() * 11);
        
        if(((newRow == this.row) || (newRow == this.row + 1) || (newRow == this.row - 1)) 
                && ((newCol == this.col) || (newCol == this.col + 1) || (newCol == this.col - 1))){
            this.row = newRow;
            this.col = newCol;
        } else{
            this.row = ranRow;
            this.col = ranCol;
        }
    }
    
    /**
     * Determines if the doctor is captured by one of the daleks
     * @param dalek the dalek that the doctor is compared to
     */
     public void intersection(Dalek dalek){
        boolean crash = false;
        
        if(this.row == dalek.getRow() && this.col == dalek.getCol()){
            this.captured = true;
        }
    }
    
    /**
     * Tells the user if the doctor is captured or not
     * @return if the doctor is in the state of being captured
     */
    public boolean isCaptured (){
        return this.captured == true;
    }
}
