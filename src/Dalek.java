

/*
 * This is the Dalek Class that holds everything about the Dalek Object
 */

/**
 *
 * @author richj0985
 */
public class Dalek {
    // Instance Variables
    private int row;
    private int col;
    private boolean crashed = false;
    
    /**
     * A constructor to create a new dalek
     */
    public Dalek(){
        // set random location for dalek
        setRandomLocation();
    }

    // Methods
   
    /**
     * Set new random location for dalek
     */
    public void setRandomLocation(){
        this.row = (int) (Math.random() * 12);
        this.col = (int) (Math.random() * 12);
    
        // reset the dalek's crash state
        this.crashed = false;    
    }
    
    
    /**
     * Returns the row that the dalek is on
     * @return the row coordinate of the dalek
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Returns the column that the dalek is on
     * @return the column coordinate of the dalek
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * Moves the dalek toward the proper direction of the doctor
     * @param doctor the doctor to move relative to
     */
    public void advanceTowards(Doctor doctor){       
        
        // determine the dalek's position relative to the doctor
        int rowMove = this.row - doctor.getRow();
        int colMove = this.col - doctor.getCol();
        
        // determine the dalek's new row position based
        // on direction of the doctor
        if(rowMove < 0){
            this.row++;
        } else if(rowMove > 0){
            this.row--;
        }
     
        // determine the dalek's new column position based
        // on direction of the doctor
        if(colMove < 0){
            this.col++;
        } else if(colMove > 0){
            this.col--;
        }
    }
    
    /**
     * Determines if one dalek has crashed into another dalek
     * @param dalek the dalek that is being compared to
     */
    public void intersection(Dalek dalek){
        boolean crash = false;
        
        // if the row and column position are the same between this 
        // dalek and the one passed to compare to, then this 
        // dalek has crashed. 
        if(this.row == dalek.getRow() && this.col == dalek.getCol()){
            this.crashed = true;
        }
    }
    
    /**
     * Determines if the Dalek has crashed
     * @return true or false if the dalek has crashed or not
     */
    public boolean hasCrashed (){
        return this.crashed == true;
    }
}
