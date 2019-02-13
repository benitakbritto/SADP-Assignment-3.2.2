/*
 * This file is used to check the GPS
 * connectivity
 */
package travel_reminder;

import java.io.*;
import java.util.Random;

public class CNT_GPS implements CNT_iGPS{

 /* Used to get the number of bars/strength in mobile network
 * Maximum number of bars is five
 * @return int bar_number the number of bars in the network
 */
  public int getMobileNetwork(){
    /*
    * generating the strength/ bar number randomly
    */
    Random rand = new Random();
    int bar_number = rand.nextInt(5);
    return bar_number;
  }

  public boolean isGpsWeak(){
    /*
     * calls functions getMobileNetwork() to determine
     * the number of bars/strength
     */
     int bar_number = getMobileNetwork();
     if(bar_number == 0 || bar_number == 1){
        /*
         * network is weak
         */
         return true;
       }
         else{
           return false;
      }
  }
}
