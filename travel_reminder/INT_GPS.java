package travel_reminder;
import java.io.*;
import java.util.Scanner;

public class INT_GPS{
  /*
  * if status is true, Gps signal is weak
  */
  public void displayGpsStatus(boolean status){
    if(status){
      System.out.println("GPS Signal is weak");
      System.out.println("Quitting Application");
      System.exit(0);
    }
  }
}
