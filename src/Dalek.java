

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    
    // Constructor
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    // Methods
    public boolean hasCrashed (){
        return this.crashed == true;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
        
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
    
    public void intersection(Dalek dalek){
        boolean crash = false;
        
        if(this.row == dalek.getRow() && this.col == dalek.getCol()){
            this.crashed = true;
        }
    }
}
