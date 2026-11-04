public class Main {
    public static void main(String[] args) {
        // Objek 1: Default
        CylinderS c1 = new CylinderS();
        System.out.println("=== Silinder 1 (Default) ===");
        System.out.println("Radius : " + c1.getRadius());
        System.out.println("Tinggi : " + c1.getHeight());
        System.out.println("Volume : " + c1.getVolume());

        System.out.println();

        // Objek 2: Custom
        CylinderS c2 = new CylinderS(7.0, 15.0);
        System.out.println("=== Silinder 2 (Custom) ===");
        System.out.println("Radius : " + c2.getRadius());
        System.out.println("Tinggi : " + c2.getHeight());
        System.out.println("Volume : " + c2.getVolume());
    }
}