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
        if(doctor.getRow() > this.row){
            this.row ++;
        } else if(doctor.getCol() < this.row){
            this.row --;
        }
        
        if(doctor.getCol() > this.col){
            this.col ++;
        } else if(doctor.getCol() < this.col){
            this.col --;
        }
    }
    
    public void crash(){
        this.crashed = true;
    }
}
