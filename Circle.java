public class Circle {
    private double radius;
    private String color;

    // Constructor
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
z
    public Circle(double r) {
        this.radius = r;
        this.color = "red";
    }

    public Circle(double r, String c) {
        this.radius = r;
        this.color = c;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String s) {
        this.color = s;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}