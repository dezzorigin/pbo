public class CylinderS extends Circle {
    private double height;

    // Constructor default
    public CylinderS() {
        super();
        this.height = 10.0;
    }

    // Constructor dengan radius dan tinggi
    public CylinderS(double r, double h) {
        super(r);
        this.height = h;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double h) {
        this.height = h;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }
}