package VehicleManagementSystem;

public class SUV extends Vehicle{

    private boolean isFourWheelDrive;
    public SUV(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, boolean isFourWheelDrive) {
        super(vehicleId, yearOfFabrication, ownerName, registrationNumber, baseTaxRate, "SUV");
        this.isFourWheelDrive = isFourWheelDrive;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int age = java.time.Year.now().getValue() - getYearOfFabrication();

        if (isFourWheelDrive){
            tax = tax * 1.1;
        }
        else if (age > 10){
            tax = tax * 0.95;
        }
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println("SUV Tax Report");
        System.out.println("----------------------");
        System.out.println(super.toString());
        System.out.println("Four wheel drive: " + isFourWheelDrive);
        System.out.println("Tax amount: " + calculateTax());
    }
}
