/*
 * This file is used to trigger the alarm
 * when the delimiter value has been reached
 * i.e if time remaining is 5 minutes
 * or distance remaining is 500 m
  * This file is used to calculate
  * the time and distance to reach the destination
*/
package travel_reminder;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class CNT_ETA implements CNT_IETA{

    private Scanner sc;
    private int distance;
    private int time;
    private static int DIST_TIME_CONVERSION_FACTOR = 5;

    /*
     * triggers the alarm
     */
    private void alarmTrigger() {
        char stop = 'Y';
        System.out.println("ALERT!");
        System.out.println("Alarm rings\nAlmost there\nWake up");

        sc = new Scanner(System.in);
        /*
         * alarm is ringing
         *  Enter X/x to stop the alarm
         */
        while (stop != 'X' && stop != 'x'){
            System.out.println("Enter X to stop alarm");
            stop = sc.next().charAt(0);
        }

        sc.close();
        System.out.println("-----------------------------------------------");
    }

    /*
     * converts minutes to hours and minutes
     * @return String
     */
    private String HoursMinute(int time) {
        if (time >= 60) {
            System.out.println("Time to destination is " + (time / 60) + " hrs and " + (time % 60) + " mins");
        } else {
            System.out.println("Time to destination is " + time + "mins");
        }
        return "" + (time / 60) + " hrs and " + (time % 60) + " mins";

    }

    /*
     * calculates the distance from the source to the destination
     * @param vector adjList[] stores the edges of the graph
     * @param int sindex source index
     * @param int dindex destination index
     * @param int distance distance to reach destination
     */
    private int calculateDistance(int graph[][], int src_i, int dest_i) {
        CNT_iMap mapObj = new CNT_Map();
        this.distance = mapObj.dijkstra(graph, src_i, dest_i);
        return this.distance;
    }

    /*
     * calculates the time from the source to the destination
     * Assumption: 1 km takes 5 minutes
     * @param vector adjList[] stores the edges of the graph
     * @param int sindex source index
     * @param int dindex destination index
     * @return int time time to reach destination
     */
    private int calculateTime() {

        this.time = this.distance * DIST_TIME_CONVERSION_FACTOR;

        HoursMinute(time);
        return time;
    }

    /*
     * decrements the time while traveling
     * and triggers the alarm when the delimiter is reached
     * i.e when time remaining is 5 minutes
     * @param int sindex source index
     * @param int dindex destination index
     * @return int time remaining
     */
    private void decrementTime() {

        int time = calculateTime();
        try {
            while (time > 5) {
                time -= 1;
                System.out.println("Time to destination = " + time);
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
        alarmTrigger();
    }

    /*
    * Displays the time left for arrival
    * @return int which is the time
    */
    public int displayTime() {

        return this.time;
    }

    /*
    * Displays the distance left for arrival
    * @return int which is the distance
    */
    public int displayDistance() {
        return this.distance;
    }

   /*
   * go to the initial screen of the application
   */
    private void goToStart() {
        char q_char = 'n';
        sc = new Scanner(System.in);
        while (q_char != 'Q' && q_char != 'q') {
            System.out.println("Enter Q to quit");
            q_char = sc.next().charAt(0);
        }
        System.out.println("------------------------------------------------");
        System.exit(0);
    }

    /*
    * Gives the travel summary
    * @param int graph[][], int scr_i which is the source index, int dest_i
    * which is the destination index
    */
    public void test_ETA(int graph[][], int src_i, int dest_i) {
        calculateDistance(graph, src_i, dest_i);
        decrementTime();

        System.out.println("Journey report:");
        System.out.println("Time taken = " + displayTime() + " mins");
        System.out.println("Distance = " + displayDistance() + "km");
        //goToStart();
    }
}
