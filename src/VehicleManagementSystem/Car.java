package VehicleManagementSystem;

public class Car extends Vehicle {
    public boolean isElectric;

    public Car(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, boolean isElectric) {
        super(vehicleId, yearOfFabrication, ownerName, registrationNumber, baseTaxRate, "Car");
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int period = java.time.Year.now().getValue() - getYearOfFabrication();

        if (period > 10){
            tax = tax * 0.9;
        } else if (isElectric) {
            tax = tax * 0.8;
        }

        return tax;

    }

    @Override
    public void generateTaxReport() {
        System.out.println("Car Tax Report");
        System.out.println("-----------");
        System.out.println(super.toString());
        System.out.println("Electric: " + isElectric + "\n Tax amount: " + calculateTax());
    }
}
