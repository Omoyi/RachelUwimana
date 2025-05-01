package VehicleManagementSystem;

public abstract class Vehicle {
    public String vehicleId;
    public int yearOfFabrication;
    public String ownerName;
    public String registrationNumber;
    public double baseTaxRate;
    public String vehicleType;

    public abstract double calculateTax();
    public abstract void generateTaxReport();

    public Vehicle(String vehicleId, int yearOfFabrication, String ownerName, String registrationNumber, double baseTaxRate, String vehicleType) {
        this.vehicleId = vehicleId;
        this.yearOfFabrication = yearOfFabrication;
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
        this.baseTaxRate = baseTaxRate;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        if (yearOfFabrication > java.time.Year.now().getValue() || yearOfFabrication < 0){
            throw new RuntimeException("Wrong entry as the year of fabrication is in the future or negative!");
        }
        this.yearOfFabrication = yearOfFabrication;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getBaseTaxRate() {
        return baseTaxRate;
    }

    public void setBaseTaxRate(double baseTaxRate) {
        this.baseTaxRate = baseTaxRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "\n Vehicle Owner: " + ownerName + "\n Vehicle Id: " + vehicleId + "\n Vehicle Type: " + vehicleType + "\n Year of fabrication: " + yearOfFabrication + "\n Registration number: " + registrationNumber + "\n Base tax rate: " + baseTaxRate ;
    }
}
