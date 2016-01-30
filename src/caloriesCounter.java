import java.io.*;
import java.util.*;

public class caloriesCounter {
    static Scanner fileScanner;
    static int i = 0;

    public static void methodSeparator(int howLong){
        for (i = 0; i <= howLong; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public static double avgOfEach(int[] avg, int n){
        double sum = 0;
        for(i = 0; i < n; i++){
            sum =+ avg[i];
        }
        return sum/n;
    }

    public static void main(String[] args) throws IOException {

        int[] breakFast = new int[7];
        int[] lunch = new int[7];
        int[] dinner = new int[7];
        int x = 0;

        try {
            fileScanner = new Scanner(new File("/Users/pepe/Documents/Development/cs2Lab1/src/data.txt"));
        } catch (Exception e) {
            System.out.println("Error");
        }

        while (fileScanner.hasNext()){

            breakFast[x] = Integer.parseInt(fileScanner.next());
            lunch[x] = Integer.parseInt(fileScanner.next());
            dinner[x] = Integer.parseInt(fileScanner.next());

            x++;

        }


        System.out.println("Each day calories:");
        for (x = 0; x < breakFast.length; x++){

            int daySum = breakFast[x] + lunch[x]+ dinner[x];
            System.out.println("Day #"+ (x+1) + " is " + daySum);
        }


        methodSeparator(20);

        System.out.println("Average of calories consumed each day:");
        for (x = 0; x < breakFast.length; x++){

            double avg = (breakFast[x] + lunch[x]+ dinner[x]) / 3;
            System.out.println("Day #"+ (x+1) + " is " + avg);
        }

        methodSeparator(20);

        System.out.println("Average number of calories consumed in each of the three meals:");
            System.out.println(avgOfEach(breakFast, 7));
            System.out.println(avgOfEach(lunch, 7));
            System.out.println(avgOfEach(dinner, 7));


    }//Main

}//Class
