package com.company;
import java.util.Scanner;

class Circle {
    private final double PI = 3.14159;
    private double radius;

    public Circle() {
        radius = 0.0;
    }
    public Circle(double r) {
        radius = r;
    }
    public void setRadius(double r) {
        radius = r;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return PI * radius * radius;
    }
    public double getCircumference()
    {
        return 2*PI*radius;
    }
}
class Sphere {
    private final double PI = 3.14159;
    private double radius;

    public Sphere() {
        radius = 0.0;
    }
    public Sphere(double r) {
        radius = r;
    }
    public void setRadius(double r) {
        radius = r;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return 4 * PI * radius * radius;
    }
    public double getCircumference()
    {
        return 2*PI*radius;
    }
    public double getVolume()
    {
        return (4/3) * PI * radius * radius * radius;
    }
}
class Square
{
    private double side;
    public Square()
    {
        side=0.0;
    }
    public Square(double side)
    {
        this.side=side;
    }
    public void setSide(double side)
    {
        this.side=side;
    }
    public double getSide()
    {
        return this.side;
    }
    public double getArea()
    {
        return this.side*this.side;
    }

    public double getPerimeter()
    {
        return 4*this.side;
    }

}
class Rectangle
{
    private double length;
    private double width;

    public Rectangle()
    {
        this.length=0.0;
        this.width=0.0;
    }
    public Rectangle(double length,double width)
    {
        this.length=length;
        this.width=width;
    }
    public void setLength(double length)
    {
        this.length=length;
    }
    public double getLength()
    {
        return this.length;
    }
    public void setWidth(double width)
    {
        this.width=width;
    }
    public double getWidth()
    {
        return this.width;
    }
    public double getArea()
    {
        return this.length*this.width;
    }

    public double getPerimeter()
    {
        return 2*(this.length+this.width);
    }

}
class Triangle  {
    private final double a, b, c; // sides

    public Triangle() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;

    }
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getArea() {

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }


    public double getPerimeter() {
        // P = a + b + c
        return a + b + c;
    }
}
class Cylinder
{
    private double radius;
    private double height;
    private final double PI = 3.14159;
    public Cylinder()
    {
        this.radius=0.0;
        this.height=0.0;
    }
    public Cylinder(double radius,double height)
    {
        this.radius=radius;
        this.height=height;
    }
    public void setRadius(double radius)
    {
        this.radius=radius;
    }
    public double getRadius()
    {
        return this.radius;
    }
    public void setHeight(double height)
    {
        this.height=height;
    }
    public double getHeight()
    {
        return this.height;
    }
    public double getArea() {
        return (2 * PI * radius * height)+2 * PI * radius * radius;
    }
    public double getPerimeter()
    {
        return 2*PI*radius;
    }
    public double getVolume()
    {
        return PI * radius * radius * height;
    }


}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc=new Scanner(System.in);
        while(true)
        {

            System.out.println("Select the shape to calculate area and perimeters for : ");
            System.out.println("1.Circle:");
            System.out.println("2.Rectangle:");
            System.out.println("3.Triangle:");
            System.out.println("4.Square:");
            System.out.println("5.Sphere:");
            System.out.println("6.Cylinder:");
            System.out.println("7.Exit:");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            int radius,length,width,height,side,a,base,c;
            switch(choice)
            {
                case 1://Circle
                {
                    System.out.print("Enter Radius: ");
                    radius=sc.nextInt();
                    Circle circle=new Circle(radius);
                    System.out.println("\n");
                    System.out.println("Area of Circle with radius "+radius+" is :"+circle.getArea());
                    System.out.println("Circumference of Circle with radius "+radius+" is :"+circle.getCircumference());
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 2://rectangle
                {
                    System.out.print("Enter length: ");
                    length=sc.nextInt();
                    System.out.print("Enter width: ");
                    width=sc.nextInt();

                    Rectangle rectangle=new Rectangle(length,width);
                    System.out.println("\n");
                    System.out.println("Area of Rectangle with length "+length+" and width " + width + "is :"+ rectangle.getArea());
                    System.out.println("Perimeter of Rectangle with length "+length+" and width " + width + "is :"+rectangle.getPerimeter());
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 3://Triangle
                {
                    System.out.print("Enter first side: ");
                    a = sc.nextInt();
                    System.out.print("Enter base: ");
                    base = sc.nextInt();
                    System.out.print("Enter second side: ");
                    c = sc.nextInt();
                    if ((a + base) <= c) {
                        System.out.println("Invalid input \n make sure side1+base>side2");
                    } else {
                        Triangle triangle = new Triangle(a, base, c);
                        System.out.println("\n");
                        System.out.println("Area of Traingle with sides " + a + " , " + base + " , " + c + " is :" + triangle.getArea());
                        System.out.println("Perimeter of Traingle with sides " + a + " , " + base + " , " + c + " is :" + triangle.getPerimeter());
                    }
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 4://square3
                {
                    System.out.print("Enter side: ");
                    side=sc.nextInt();
                    Square square=new Square(side);
                    System.out.println("\n");
                    System.out.println("Area of sqaure with sides "+side+" is :"+  square.getArea());
                    System.out.println("Perimeter of sqaure with sides "+side+" is :"+  square.getPerimeter());
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 5://sphere
                {
                    System.out.print("Enter Radius: ");
                    radius=sc.nextInt();
                    Sphere sphere=new Sphere(radius);
                    System.out.println("\n");
                    System.out.println("Area of sphere with radius "+radius+" is :"+sphere.getArea());
                    System.out.println("Circumference of sphere with radius "+radius+" is :"+sphere.getCircumference());
                    System.out.println("Volume of sphere with radius "+radius+" is :"+sphere.getVolume());
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 6://cylinder
                {
                    System.out.print("Enter Radius: ");
                    radius=sc.nextInt();
                    System.out.print("Enter Height: ");
                    height=sc.nextInt();
                    Cylinder cylinder=new Cylinder(radius,height);
                    System.out.println("\n");
                    System.out.println("Area of cylinder with radius "+radius+" and height "+height +" is :"+cylinder.getArea());
                    System.out.println("Perimeter of cylinder with radius "+radius+" and height "+height +" is :"+cylinder.getPerimeter());
                    System.out.println("Volume of cylinder with radius "+radius+" and height "+height +" is :"+cylinder.getVolume());
                    System.out.println("\nPress any key and enter for menu");
                    sc.next();
                    break;
                }
                case 7://exit
                {
                    System.out.println("Thank You....");
                    return;
                }
            }

        }


    }
}
