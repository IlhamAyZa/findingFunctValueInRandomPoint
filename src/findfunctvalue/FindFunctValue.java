package findfunctvalue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class FindFunctValue {

    private static ArrayList<Double> functCoef = new ArrayList<>();
    private static ArrayList<double[]> listOfPoints = new ArrayList<>();
    private static Random rand = new Random();
    private static Scanner scn = new Scanner(System.in);
    private static int n, m, maxX, minX;

    public static void main(String[] args) {
        System.out.print("Enter n : ");
        n = scn.nextInt();
        System.out.println("");

        System.out.print("Enter max : ");
        maxX = scn.nextInt();
        System.out.println("");
        System.out.print("Enter min : ");
        minX = scn.nextInt();
        System.out.println("");

        System.out.print("Enter num of points : ");
        m = scn.nextInt();
        System.out.println("");

        createFunction(n);
        createPoints();

        System.out.println("VALUES: ");
        for (int i = 0; i < listOfPoints.size(); i++) {
            giveValueOfFunct(listOfPoints.get(i));
        }

    }

    public static void createFunction(int n) {
        System.out.println("Creating function...");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " : ");
            functCoef.add(scn.nextDouble());
            System.out.println("");
        }
    }

    private static void createPoints() {
        double[] point = new double[n];
        for (int i = 0; i < n; i++) {
            point[i] = minX + (maxX - minX) * rand.nextDouble();
        }
        listOfPoints.add(point);
    }

    private static void giveValueOfFunct(double[] point) {
        double value = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value += functCoef.get(i) * Math.pow(point[j], n - j);
            }
        }

        System.out.printf("Function at point has value %.4f at point: ", value);
        System.out.print("[ ");
        for (int i = 0; i < point.length; i++){
            System.out.printf("%.4f, ", point[i]);
        }
        System.out.print(" ]");
    }

}
