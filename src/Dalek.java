

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
        int ranDalRow = (int) (Math.random() * 11);
        int ranDalCol = (int) (Math.random() * 11);
        this.row = ranDalRow;
        this.col = ranDalCol;
    }
    
    // Methods
    
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
          
        int rowMove = this.row - doctor.getRow();
        int colMove = this.col - doctor.getCol();
        
 
              if(rowMove <= 0){
                  this.row++;
              }
              
               if(rowMove >= 0){
                  this.row--;
              }
              
               if(colMove <= 0){
                  this.col++;
              }
               if(colMove >= 0){
                  this.col--;
              }
          }
    
    /**
     * Determines if one dalek has crashed into another dalek
     * @param dalek the dalek that is being compared to
     */
    public void intersection(Dalek dalek){
        boolean crash = false;
        
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
