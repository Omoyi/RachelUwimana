package VehicleManagementSystem;

public class Bus extends Vehicle{

    private int passengerCapacity;
    public Bus(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, int passengerCapacity) {
        super(vehicleId, yearOfFabrication, ownerName, registrationNumber, baseTaxRate, "Bus");
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be greater than 0.");
        }
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0){
            throw new IllegalArgumentException("The passenger capacity can not be 0 or negative(-)");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int period = java.time.Year.now().getValue() - getYearOfFabrication();
        int eachTenPassengers = passengerCapacity/10;

        tax = tax * (1 + (0.02 * eachTenPassengers));

        if (period > 20){
            tax = tax * 1.1;
        }

        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println("Bus Tax Report");
        System.out.println("----------------------");
        System.out.println(super.toString());
        System.out.println("Passenger capacity: " + passengerCapacity);
        System.out.println("Tax amount: " + calculateTax());
    }
}
