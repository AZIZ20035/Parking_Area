/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parking;

/**
 *
 * @author ENG.AZ1Z
 */

/*abstract*/ class Vehicle
{
     protected int length;
     long ID;
     double num_hour;
     double hour_rate;

    public Vehicle() {
        this.ID = -1;
    }
     
    
     double get_Length()
     {
       return length;
     }

     long get_ID()
     {
       return ID;
     }
   
     public  double CalcMoney()
     {
       return num_hour * hour_rate;
     }
     
     public void setNum_hour(double num_hour) {
        this.num_hour = num_hour;
    }
   
     
}