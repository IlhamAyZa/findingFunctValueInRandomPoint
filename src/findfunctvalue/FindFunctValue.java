package findfunctvalue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class FindFunctValue implements FunctionVBP {

    private ArrayList<Double> functCoef = new ArrayList<>();
    private double[][] listOfPoints;
    private Random rand = new Random();
    private Scanner scn = new Scanner(System.in);
    private int n, m, maxX, minX;

    public void main(String[] args) {
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
        for (int i = 0; i < m; i++) {
            giveValueOfFunct(listOfPoints[i]);
            System.out.println("");
        }

    }

    public void createFunction(int n) {
        System.out.println("Creating function...");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " : ");
            functCoef.add(scn.nextDouble());
            System.out.println("");
        }
    }

    private void createPoints() {
        double[] point = new double[n];
        for (int j = 0; j < m; j++){
            for (int i = 0; i < n; i++) {
                point[i] = minX + (maxX - minX) * rand.nextDouble();
            }
            listOfPoints[j] = point;
        }
    }

    @Override
    public void giveValueOfFunct(double[] point) {
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
