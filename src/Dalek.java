
import java.awt.Color;

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
    private Color colour;
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
    
    public Color getColour(){
        if(this.crashed){
            return this.colour = Color.RED;
        }else{
            return this.colour = Color.BLACK;
        }
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
//        if(doctor.getRow() > this.row){
//            this.row ++;
//        } else if(doctor.getCol() < this.row){
//            this.row --;
//        }
//        
//        if(doctor.getCol() > this.col){
//            this.col ++;
//        } else if(doctor.getCol() < this.col){
//            this.col --;
//        }
//    }
    
//    public void crash(){
//        this.crashed = true;
//    }
    
    public void intersection(Dalek dalek){
        boolean crash = false;
        
        if(this.row == dalek.getRow() && this.col == dalek.getCol()){
            this.crashed = true;
        }
    }
}
