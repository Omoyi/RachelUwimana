package VehicleManagementSystem;

public class Truck extends Vehicle{

    private double loadCapacity;
    public Truck(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, double loadCapacity) {
        super(vehicleId, yearOfFabrication, ownerName, registrationNumber, baseTaxRate, "Truck");
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be greater than 0.");
        }
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0){
            throw new IllegalArgumentException("The truck's load capacity cannot be 0 or negative");
        }
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int period = java.time.Year.now().getValue() - getYearOfFabrication();

        if (loadCapacity > 10){
            tax = tax * 1.25;
        } else if (period > 15) {
            tax = tax * 1.15;
        }

        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println("Truck Tax Report");
        System.out.println("-----------------");
        System.out.println(super.toString());
        System.out.println("Load capacity: " + loadCapacity + " tons");
        System.out.println("Tax amount: " + calculateTax());

    }
}
