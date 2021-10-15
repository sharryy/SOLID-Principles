/*
In this example, if in future we want to add further classes
we have to modify existing code so that to cater that type.
So our class is open for modification as well.
 */

public class refactored1 {
    public static void main(String[] args) {
        Rectangle Rectangle = new Rectangle(10, 10);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(2, 3);
        AreaCalculator areaCalculator = new AreaCalculator();
    }
}

class Triangle {
    public int base;
    public int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}

class Rectangle {
    public int width;
    public int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

class Circle {
    public int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }
}

class AreaCalculator {
    public void calculate(Object shapes) {

        /*
        Runtime-Type Checking Introduces Modification in code.
        So OCP is broken
         */

        if (shapes instanceof Triangle)
            ((Triangle) shapes).area();
        else if (shapes instanceof Circle)
            ((Circle) shapes).area();
        else if (shapes instanceof Rectangle)
            ((Rectangle) shapes).area();
    }
}