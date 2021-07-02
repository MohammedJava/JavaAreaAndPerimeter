import java.util.*;
import java.text.*;

//Author: Mohammed
//Purpose: Print area and volume for different shapes using mathematical formulas
//         and display the result depending on the number of significant figures desired.


public class JavaProgram4 {
    public static void main(String[] args) {
        System.out.println("Enter which shape or solid's area and perimeter/volume you wish to calculate: ");

        //Print all types
        System.out.println("    2D : Square, Rectangle, Circle, Triangle, Parallelogram and Trapezoid");
        System.out.println("    3D : Sphere, Rectangular Box, Cube, Cylinder, Cone");
        double perimeter, area, volume, side1,side2,side3,side4,base,radius,height,length,width;
        Scanner input = new Scanner(System.in);

        //remove spaces and uppercase from entry
        String entry = input.nextLine().toLowerCase().replaceAll("\\s","");
        try {
            switch (entry) {
                case "square":
                    System.out.println("Enter value of the side ");
                    side1 = input.nextDouble();
                    System.out.println("Perimeter: " + roundValue(4 * side1,4));
                    System.out.println("Area: " + roundValue(Math.pow(side1, 2),4));
                    break;
                case "rectangle":
                    System.out.println("Enter value of the first side ");
                    side1 = input.nextDouble();
                    System.out.println("Enter value of the second side ");
                    side2 = input.nextDouble();
                    System.out.println("Perimeter: " + roundValue((side2 + side1) * 2,4));
                    System.out.println("Area: " + roundValue((side1 * side2),4));
                    break;
                case "circle":
                    System.out.println("Enter value of the radius ");
                    radius = input.nextDouble();
                    System.out.println("Perimeter: " + roundValue(2 * Math.PI * radius,4));
                    System.out.println("Area: " + roundValue(Math.pow(radius, 2) * Math.PI,4));
                    break;
                case "triangle":
                    System.out.println("Enter value of the first side ");
                    side1 = input.nextDouble();
                    System.out.println("Enter value of the second side ");
                    side2 = input.nextDouble();
                    System.out.println("Enter value of the third side ");
                    side3 = input.nextDouble();
                    //Area calculed using Heron's formula
                    System.out.println("Perimeter: " + roundValue(side1 + side2 + side3,4));
                    double s = (side1 + side2 + side3) / 2;
                    System.out.println("Area: " + roundValue(Math.sqrt(s * (s-side1) * (s-side2) * (s-side3)),4));
                    break;
                case "parallelogram":
                    System.out.println("Enter value of the base ");
                    side1 = input.nextDouble();
                    System.out.println("Enter value of the height");
                    height = input.nextDouble();
                    System.out.println("Perimeter: " + roundValue((2 * (side1 + height)),8));
                    System.out.println("Area: " + roundValue(side1 * height,8));
                    break;
                case "trapezoid":
                    System.out.println("Enter value of the first side ");
                    side1 = input.nextDouble();
                    System.out.println("Enter value of the second side ");
                    side2 = input.nextDouble();
                    System.out.println("Enter value of the third side ");
                    side3 = input.nextDouble();
                    System.out.println("Enter value of the fourth side ");
                    side4 = input.nextDouble();
                    System.out.println("Enter value of the base");
                    base = input.nextDouble();
                    System.out.println("Enter value of the height");
                    height = input.nextDouble();
                    System.out.println("Perimeter: " + roundValue(4 * side1,4));
                    System.out.println("Area: " + roundValue(Math.pow(side1, 2),4));
                    break;
                case "sphere":
                    System.out.println("Enter value of the radius ");
                    radius = input.nextDouble();
                    System.out.println("Area: " + roundValue(4 * Math.PI * Math.pow(radius,2),4));
                    System.out.println("Volume: " + roundValue((4.0 / 3.0) * Math.PI * Math.pow(radius,3),4));
                    break;
                case "cube":
                    System.out.println("Enter value of the side ");
                    side1 = input.nextDouble();
                    System.out.println("Area: " + roundValue(6 * Math.pow(side1,2),4));
                    System.out.println("Volume: " +  roundValue(Math.pow(side1, 3),4));
                    break;
                case "rectangularbox":
                    System.out.println("Enter value of the width ");
                    width = input.nextDouble();
                    System.out.println("Enter value of the height ");
                    height = input.nextDouble();
                    System.out.println("Enter value of the length ");
                    length = input.nextDouble();
                    System.out.println("Area: " + roundValue(((2 * length * width) + (2 * width * height) + (2 * length * height)),4));
                    System.out.println("Volume: " + roundValue((height * length * width),4));
                    break;

                case "cylinder":
                    System.out.println("Enter value of the radius");
                    radius = input.nextDouble();
                    System.out.println("Enter value of the height");
                    height = input.nextDouble();
                    System.out.println("Area: " + roundValue((2 * Math.PI * Math.pow(radius,2)) + (2 * height * Math.PI * radius),4));
                    System.out.println("Volume: " + roundValue((height * Math.PI * Math.pow(radius,2)),4));
                    break;

                case "cone":
                    System.out.println("Enter value of the radius ");
                    radius = input.nextDouble();
                    System.out.println("Enter value of the height");
                    height = input.nextDouble();
                    //slant height value
                    length = Math.sqrt(Math.pow(radius,2) + Math.pow(height,2));
                    System.out.println("Area: " + roundValue(((Math.PI * radius * length) + (Math.PI * Math.pow(radius,2))),4));
                    System.out.println("Volume: " + roundValue((1.0/3 * Math.pow(radius,2) * height * Math.PI),4));
                    break;
                default:
                    System.out.println("Invalid Choice. Try again later.");
                    break;
            }
        }
        catch (Exception e){
            System.out.println("An error occurred. To try again, enter A. To exit, enter X.");
        }
    }

    //Method to round values
    public static String roundValue(double n, int significantNum){
        int counter = 0;
        String decimal = "#.";
        while(counter != significantNum){
            //adds a hashtag for each decimal
            decimal += "#";
            counter++;
        }
        //DecimalFormat form required
        DecimalFormat m = new DecimalFormat(decimal);
        //Format the number and return string
        return m.format(n);
    }
}
