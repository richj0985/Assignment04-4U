

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
        // set a new random position for the doctor
        setRandomLocation();
    }
    
    // METHODS
    public void setRandomLocation(){
        // set a new random position for the doctor
        this.row = (int) (Math.random() * 12);
        this.col = (int) (Math.random() * 12);
        
        //reset the doctor's captured state
        this.captured = false;
    }
    
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
        // determine if the new position being requested for the doctor
        // is within 1 cell position from the current doctors location
        // if it is then set the new position and if not than 
        // set a new random position for the doctor
        if(    ((newRow == this.row) || (newRow == this.row + 1) || (newRow == this.row - 1)) 
            && ((newCol == this.col) || (newCol == this.col + 1) || (newCol == this.col - 1))){
            // within 1 cell position from doctor
            // set the new position
            this.row = newRow;
            this.col = newCol;
        } else{
            // new position is not withint 1 cell position 
            // determine new random position of the doctor
            this.row = (int) (Math.random() * 11);
            this.col = (int) (Math.random() * 11);
        }
    }
    
    /**
     * Determines if the doctor is captured by one of the daleks
     * @param dalek the dalek that the doctor is compared to
     */
     public void intersection(Dalek dalek){
        // determine if the doctor has intersected with the dalek
        // if it has, than the doctor has been captured
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
