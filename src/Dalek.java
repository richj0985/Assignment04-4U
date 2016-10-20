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
    private boolean crashed;
    
    // Constructor
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    // Methods
    public boolean hasCrashed (){
        return this.crashed;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public void advanceTowards(Doctor doc){
        
    }
    
    public void crash(){
        
    }
}
