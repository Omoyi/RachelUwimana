package VehicleManagementSystem;

public class Motorcycle extends Vehicle{

    private int engineCapacity;
    public Motorcycle(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, int engineCapacity) {
        super(vehicleId, yearOfFabrication, ownerName, registrationNumber, baseTaxRate, "Motorcycle");
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0.");
        }
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity <= 0){
            throw new IllegalArgumentException("The Engine capacity should not be 0 or less than 0");
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int period = java.time.Year.now().getValue() - getYearOfFabrication();
        int depreciation = period/5;

        tax = tax * (1 - (0.05 * depreciation));

        if(engineCapacity > 500){
            tax = tax * 1.2;
        }
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println("Motorcycle Tax Report");
        System.out.println("----------------------");
        System.out.println(super.toString());
        System.out.println("Engine capacity: " + engineCapacity + " CC");
        System.out.println("Tax amount: " + calculateTax());
    }
}
