public class OCP_1 {
    public static void main(String[] args) {
        Rectangle Rectangle = new Rectangle(10, 10);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(2, 3);
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println(areaCalculator.calculate(Rectangle));
        System.out.println(areaCalculator.calculate(circle));
        System.out.println(areaCalculator.calculate(triangle));
    }
}

interface Shape {
    double area();
}

class Triangle implements Shape {
    public int base;
    public int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class Rectangle implements Shape {
    public int width;
    public int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Circle implements Shape {
    public int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}

class AreaCalculator {
    public double calculate(Shape shapes) {
        return shapes.area();
    }
}