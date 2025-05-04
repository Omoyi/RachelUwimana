package TaxEnforcementSystem;

import java.time.LocalDate;

public abstract class TaxDeclaration {
    private String declarationId;
    private String taxpayerName;
    private String taxpayerTIN;
    private LocalDate declarationDate;
    private double taxAmount;
    private boolean isPaid;

    public TaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double taxAmount, boolean isPaid) {
        setDeclarationId(declarationId);
        setTaxpayerName(taxpayerName);
        setTaxpayerTIN(taxpayerTIN);
        setDeclarationDate(declarationDate);
        setTaxAmount(taxAmount);
        this.isPaid = isPaid;
    }

    public String getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(String declarationId) {
        if (declarationId.isEmpty() || declarationId == null){
            throw new IllegalArgumentException("The declaration Id can't be empty");
        }
        this.declarationId = declarationId;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public void setTaxpayerName(String taxpayerName) {
        if (taxpayerName.isEmpty() || taxpayerName == null){
            throw new IllegalArgumentException("The taxpayer's name can't be empty");
        }
        this.taxpayerName = taxpayerName;
    }

    public String getTaxpayerTIN() {
        return taxpayerTIN;
    }

    public void setTaxpayerTIN(String taxpayerTIN) {
        if (taxpayerTIN.isEmpty() || !taxpayerTIN.matches("\\d{9}")){
            throw new IllegalArgumentException("The taxpayer TIN, can only be 9 digits");
        }
        this.taxpayerTIN = taxpayerTIN;
    }

    public LocalDate getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(LocalDate declarationDate) {
        if (declarationDate == null || declarationDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("The declaration date can't be empty or in the future!");
        }
        this.declarationDate = declarationDate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        if (taxAmount < 0){
            throw new IllegalArgumentException("The tax amount can't be less than zero");
        }
        this.taxAmount = taxAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "TaxDeclaration{" +
                "declarationId='" + declarationId + '\'' +
                ", taxpayerName='" + taxpayerName + '\'' +
                ", taxpayerTIN='" + taxpayerTIN + '\'' +
                ", declarationDate=" + declarationDate +
                ", taxAmount=" + taxAmount +
                ", isPaid=" + isPaid +
                '}';
    }

    public abstract double calculateTax();
    public abstract boolean validateDeclaration();
    public abstract void generateReport();
    public abstract void enforceCompliance();
}
