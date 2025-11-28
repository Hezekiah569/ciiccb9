public class Task15 {
    public static void main(String[] args) {
        Circle circleOne = new Circle(21);
        Rectangle rectOne = new Rectangle(20, 40);

        System.out.println("CIRCLE AREA: " + circleOne.calculateArea());
        System.out.println("CIRCLE PERIMETER: " + circleOne.calculatePerimeter());

        System.out.println("\nRECTANGLE AREA: " + rectOne.calculateRectangleArea());
        System.out.println("RECTANGLE PERIMETER: " + rectOne.calculateRectanglePerimeter());
    }
}

interface Shape {
    double calculateArea();
    double calculatePerimeter();
    double calculateRectangleArea();
    double calculateRectanglePerimeter();
}

class AbstractShape implements Shape {
    public double radius;
    public String color;
    public double length;
    public double width;

    AbstractShape() {}
    AbstractShape(String color, double length, double width) {

    }
    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double calculateRectangleArea() {
        return length * width;
    }

    @Override
    public double calculateRectanglePerimeter() {
        return 2*(length + width);
    }
}

class Circle extends AbstractShape {

    Circle(double r) {
        this.radius = r;
    }
}

class Rectangle extends AbstractShape {

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}
