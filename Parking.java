
package com.mycompany.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Parking {
    
  static void Menu()
  {
      System.out.println("");
      System.out.println("Enter 1 to add a vechile");
      System.out.println("Enter 2 to remove a vechile");
      System.out.println("Enter 3 to show the status");
      System.out.println("Enter 4 to exit programme");
  }
  
  static void Show_Status (Vehicle []arr)
  {
      
      int space = 0;
      for (int i = 0;i<100;i++)
      {
          if (arr[i].ID == arr[i+1].ID)
          {
              space++;
          }
          else 
          {
              space++;
                      
              if (arr[i].ID == -1)
              {
                  System.out.println("there is Free spaces equal " + space);
              }
              else 
              {
                   System.out.println("there is Occupied space equal " + space);
              }
              space = 0;
             
          }
      }
      
  }
  
  static void sccessful(String s)
  {
      System.out.println("        Your vehicle is sccessfully " + s);
  }
  
  static void fail()
  {
      System.out.println("        sorry, there is no free space for your vehicle");
  }
  //
  
  static boolean check (Vehicle v,Vehicle [] arr)
  {
      int free_space = 0;
      for (int i = 0;i<100;i++)
       {
             if ( arr[i].ID == -1) 
                 free_space  ++;
              else 
                 free_space = 0;
       }
      return (free_space >= v.length) ;
  }
  
  static void add_vehicle (Vehicle v,Vehicle [] arr)
  {
      int l = v.length;
      for (int i = 0;i<100 &&  l>0;i++)
      {
        if ( arr[i].ID  ==-1)
        {
             arr[i].hour_rate = v.hour_rate;
             arr[i].ID = v.ID;
             l--;
        }
      }                       
  }
  
  static void total_money (long id,double time,Vehicle [] arr)
  {
       
      for (int i = 0;i<100 ;i++)
      {
        if (arr[i].ID == id)
        {
            arr[i].setNum_hour(time);
            System.out.println(arr[i].num_hour);
            System.out.println(arr[i].hour_rate);
            System.out.println("the total money you shoud pay is "+arr[i].CalcMoney()); 
            break;
        }
      }
      
  }
  
  static void remove_vehicle (long id,Vehicle [] arr)
  {
      for (int i = 0;i<100 ;i++)
      {
        if ( arr[i].ID == id) arr[i].ID = -1; 
      } 
  }
  
 
    public static void main(String[] args) {
        
        System.out.println("        WELCOM IN THE PARKING AREA!         ");
        Scanner input = new Scanner (System.in);
        
        Vehicle [] arr = new  Vehicle [101];  
        // initialize the array
        for (int i = 0;i<=100;i++)
        {
            arr[i] = new Vehicle ();
            arr[i].ID = -1;
            if (i == 100)
            {
                arr[100].ID = -2; 
            }
        }                 
       int choice;
       while(true)
        {
            Menu();
            choice=input.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 &&choice != 4)
            {
                System.out.println("Invalid choice, pleace enter a valid choice");
                choice=input.nextInt();
            }
            switch(choice)
            {
                case 1:
                {
                    String type;
                    int ID,num_hour;
                    System.out.println("Choice the type of your vehicle from this types :");
                    System.out.println("Car\tBus\tMotorcycle\tTruck");
                    type = input.next();   
                    System.out.println("Enter your ID :");
                       ID = input.nextInt();
                    switch (type)
                    {
                        case "Car"  :
                        {
                            Car c = new Car(ID);
                            if (check(c,arr))
                            {
                                add_vehicle (c,arr);
                                sccessful("added");
                            }
                            else 
                            {
                               fail();
                            }
                            break;
                        }
                        case "Bus" :
                        {
                            Bus b = new Bus(ID);
                            if (check(b,arr))
                            {
                                add_vehicle (b,arr);
                                sccessful("added");
                            }
                            else 
                            {
                               fail();

                            }
                            break;
                        }
                        case "Truck" :
                        {
                            Truck t = new Truck(ID);
                            if (check(t,arr))
                            {
                               add_vehicle (t,arr);
                                sccessful("added");
                            }
                            else 
                            {
                               fail();
                            }
                            break;
                        }
                        case "Motorcycle" :
                        {
                            Motorcycle m = new Motorcycle(ID);
                            if (check(m,arr))
                            {
                                 add_vehicle (m,arr);
                                sccessful("added");
                            }
                            else 
                            {
                               fail();
                            }
                            break;
                        }
                    }
                     break;
                }
                case 2:
                {
                    long id;
                    double n_of_hour;
                    System.out.println("Enter your vehicle ID");
                    id = input.nextLong();
                    System.out.println("Enter the time you spent in the parking");
                    n_of_hour = input.nextDouble();
                    sccessful("removed");
                    total_money (id,n_of_hour, arr);
                    remove_vehicle (id,arr);                    
                    break;
                }   
                case 3:
                {
                    Show_Status (arr);
                     break;
                }   
                case 4:
                    return ;
            }
        }

} 
}

