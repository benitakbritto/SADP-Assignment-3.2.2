/*
* User interface class which is used to get the source and
* destination information from the user
*/
package travel_reminder;
import java.util.Scanner;
import java.io.*;

public class INT_SourceDest{
    public String source,destination;
    /*
    getter function which gets the source
    @return String which is the source
    */
    public String getSource(){
        System.out.println("-----------------------");
        System.out.println("Enter Source Location");
        Scanner s = new Scanner(System.in);
        source=s.nextLine();
        return source;
    }

    /*
    getter function which gets the Destination
    @return String which is the Destination
    */
    public String getDest(){
        System.out.println("Enter Destination");
        Scanner s=new Scanner(System.in);

         destination=s.nextLine();
        System.out.println("Validating information...");
        return destination;
    }

}
