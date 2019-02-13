/*
* This file is used to get the source and destination location
* from the user and validate the location
* This file is used to decrement the time/ distance
* remaining as the user is traveling
*/
package travel_reminder;
import java.io.*;
import java.util.Scanner;

public class CNT_SourceDest implements CNT_ISourceDest{

    INT_SourceDest ISD;
    private String source;
    private String destination;
    private int source_index;
    private int dest_index;

    public void setSourceIndex(int s_index){
        source_index=s_index;
    }

    public void setDestIndex(int d_index){
        dest_index=d_index;
    }

    public int getSourceIndex(){
        return source_index;
    }
    public int getDestIndex(){
        return dest_index;
    }

    /*
     * helper function used for validating the locations
     * @param vector location list of valid locations
     * @param string source source location
     * @param string destination destination location
     * @return bool true if locations are valid
     */
    public boolean validateLocation(ENT_Location imapObj, String source, String destination)
    {
        int source_index = -1;
        int dest_index = -1;

        for (int i=0; i<imapObj.location.length; i++){
      /*
       * source location found in the vector
       * and stores the index at which the location
       * was found
       */
            if(imapObj.location[i].equals(source)){
                source_index = i;
                setSourceIndex(source_index);
            }

            /*
             * destination location found in the vector
             * and stores the index at which the location
             * was found
             */
            if(imapObj.location[i].equals(destination)){
                dest_index = i;
                setDestIndex(dest_index);
            }
        }

        /*
         * source and destination locations
         * must be different
         */
        if(source_index == dest_index){
            System.out.println("Invalid Input");
            System.out.println("--------------------");
            return false;
        }

            /*
             * the source and destination indices were
             * modified, as the location was found
             * Hence, they are valid
             */
        if(source_index!=-1 && dest_index!=-1){
            System.out.println("Valid Input");
            return true;
        }
    /*
     * if either the source and destination indices were
     * not modified, the location was not found
     * Hence, the location/ locations are invalid
     */

        System.out.println("Invalid Source or Destination!");
        return false;
    }

    /*
     * Used to check the source and destination entered by the user
     * @param vector location list of valid locations
     */
  /*  public void getSourceDest(ENT_Location imapObj){
        ISD = new INT_SourceDest();
        source=ISD.getSource();
        destination=ISD.getDest();
        while(!validateLocation(imapObj,  source,  destination)){
          source=ISD.getSource();
          destination=ISD.getDest();
       }
    }*/
    public void getSourceDest(ENT_Location imapObj){
      ISD = new INT_SourceDest();
       do{
         source=ISD.getSource();
         destination=ISD.getDest();
       }while(!validateLocation(imapObj,  source,  destination));
    }
}
