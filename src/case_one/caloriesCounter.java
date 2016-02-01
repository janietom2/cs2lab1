import java.io.*;
import java.util.*;

public class caloriesCounter {
    static Scanner fileScanner;
    static int i = 0;
    static int max = 1;

    public static void methodSeparator(int howLong){
        for (i = 0; i <= howLong; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public static double avgOfEach(int[] avg, int n){
        double sum = 0;
        for(i = 0; i < n; i++){
            sum  += avg[i];
        }
        return sum/n;
    }

    public static int sumOfMeals(int[] meal){
        int sum = 0;
        for(i = 0; i < meal.length; i++){
            sum += meal[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        writeFile file = new writeFile();
        file.open();

        int[] breakFast = new int[7];
        int[] lunch = new int[7];
        int[] dinner = new int[7];
        int x = 0;

        try {
            fileScanner = new Scanner(new File("D:/Development/cs2lab1/src/data.txt"));
        } catch (Exception e) {
            file.f.format("Error: " + e.getMessage());
            System.out.println(e.getMessage());
            file.close();

        }

            try{
                while (fileScanner.hasNext()){

                    breakFast[x] = Integer.parseInt(fileScanner.next());
                    lunch[x] = Integer.parseInt(fileScanner.next());
                    dinner[x] = Integer.parseInt(fileScanner.next());
                    x++;

                }
            }
             catch (Exception e){
                 file.f.format("Error: " + e.getMessage());
                 System.out.println(e.getMessage());
                 file.close();
            }

        System.out.println("Each day calories:");
        file.f.format("Each day calories: \n");
        for (x = 0; x < breakFast.length; x++){

            int daySum = breakFast[x] + lunch[x]+ dinner[x];
            System.out.println("Day #"+ (x+1) + " is " + daySum);
            file.f.format("Day #"+ (x+1) + " is " + daySum + "\n");
        }


        methodSeparator(20);
        file.f.format("--------------------\n");

        System.out.println("Average of calories consumed each day:");
        file.f.format("Average of calories consumed each day:\n");
        for (x = 0; x < breakFast.length; x++){

            double avg = (breakFast[x] + lunch[x]+ dinner[x]) / 3;
            System.out.println("Day #"+ (x+1) + " is " + avg);
            file.f.format("Day #"+ (x+1) + " is " + avg + "\n");
        }

        methodSeparator(20);
        file.f.format("--------------------\n");
        System.out.println("Average number of calories consumed in each of the three meals:");
        file.f.format("Average number of calories consumed in each of the three meals: \n");
            System.out.println(avgOfEach(breakFast, 7));
            file.f.format("" + avgOfEach(breakFast, 7) + "\n");
            System.out.println(avgOfEach(lunch, 7));
            file.f.format("" + avgOfEach(lunch, 7) + "\n");
            System.out.println(avgOfEach(dinner, 7));
            file.f.format("" + avgOfEach(dinner, 7) + "\n");

        methodSeparator(20);
        file.f.format("--------------------\n");

        System.out.println("the maximum number of calories consumed in any specific day:");
        file.f.format("the maximum number of calories consumed in any specific day: \n");
        double[] avgMeals = new double[7];

        for (x = 0; x < breakFast.length; x++){
            double avg = (breakFast[x] + lunch[x]+ dinner[x]);
            avgMeals[x] = avg;
        }

        for (x = 0; x < breakFast.length; x++){
            if (avgMeals[x] > avgMeals[max]){
                max = x;
            }
        }

        System.out.println("Max Avg is day " + (max+1) + " " + avgMeals[max] + " calories");
        file.f.format("Max Avg is day " + (max+1) + " " + avgMeals[max] + " calories \n");

        methodSeparator(20);
        file.f.format("--------------------\n");


        max = 1;
        int[] sumOfAll = new int[3];

         sumOfAll[0] = sumOfMeals(breakFast);
         sumOfAll[1] = sumOfMeals(lunch);
         sumOfAll[2] = sumOfMeals(dinner);

        for (x = 0; x < sumOfAll.length; x++){
            if (sumOfAll[x] > sumOfAll[max]){
                max = x;
            }
        }

        System.out.println("The maximum number of calories consumed is: " + sumOfAll[max] + " calories.");

        file.f.format("The maximum number of calories consumed is: " + sumOfAll[max] + " calories.");
        file.close();

    }

}
