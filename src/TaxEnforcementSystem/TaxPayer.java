package TaxEnforcementSystem;

public class TaxPayer {
     private String tin;
     private String name;
     private String type;
     private int complianceScore;

     public String getTin() {
          return tin;
     }

     public void setTin(String tin) {
          if (!tin.matches("\\d{9}") || tin.isEmpty()){
               throw new IllegalArgumentException("The tin should be 9 digits only!");
          }
          this.tin = tin;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          if (name.trim().isEmpty() || name == null){
             throw new IllegalArgumentException("The name should not be empty!");
          }
          this.name = name.trim();
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          if (type != "Individual" || type != "Company"){

          }
          this.type = type;
     }

     public int getComplianceScore() {
          return complianceScore;
     }

     public void setComplianceScore(int complianceScore) {
          this.complianceScore = complianceScore;
     }
}
