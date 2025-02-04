package utilities;

public class JavaUtility {
	
	public double calculateTotalAfterDiscount(String price, String discount) {
	    try {
	        // Convert price and discount from String to double
	        double priceValue = Double.parseDouble(price);
	        double discountValue = Double.parseDouble(discount);

	        // Calculate total after discount
	        double totalValue = priceValue - discountValue;
	        
	        // Return the total value
	        return totalValue;

	    } catch (NumberFormatException e) {
	        System.out.println("Invalid number format: " + e.getMessage());
	        return 0.0;  // Return 0 if there's a parsing error
	    }
	}
	
	public double calculateTotalAfterShippingCharges(String price, String shippingCharge) {
	    try {
	        // Convert price and discount from String to double
	        double priceValue = Double.parseDouble(price);
	        double shippingChargeValue = Double.parseDouble(shippingCharge);

	        // Calculate total after discount
	        double totalValue = priceValue + shippingChargeValue;
	        
	        // Return the total value
	        return totalValue;

	    } catch (NumberFormatException e) {
	        System.out.println("Invalid number format: " + e.getMessage());
	        return 0.0;  // Return 0 if there's a parsing error
	    }
	}
	
	public double calculateTotalAfterMultiplyingQuantity(String price, String quantity) {
	    try {
	        // Convert price and discount from String to double
	        double priceValue = Double.parseDouble(price);
	        double quantityValue = Double.parseDouble(quantity);

	        // Calculate total after discount
	        double totalValue = priceValue * quantityValue;
	        
	        // Return the total value
	        return totalValue;

	    } catch (NumberFormatException e) {
	        System.out.println("Invalid number format: " + e.getMessage());
	        return 0.0;  // Return 0 if there's a parsing error
	    }
	}
	
	 public static double stringToDouble(String str) {
	        try {
	            // Handle null strings as well
	            if (str == null || str.isEmpty()) {
	                return 0.0;
	            }
	            return Double.parseDouble(str);
	        } catch (NumberFormatException e) {
	            // Handle invalid number format gracefully
	            System.err.println("Invalid input for conversion to double: " + str);
	            return 0.0; // Return a default value (can be adjusted based on your needs)
	        }
	    }
	 
	 public double addTwoNumbers(double num1,double num2) {
		 double total = num1 + num2;
		 return total;
	 }
	 
	 public double totalAfterDiscountAndQuantities(String price, String quantity, String discount) {
		 double priceValue = Double.parseDouble(price);
		 double quantityValue = Double.parseDouble(quantity);
	     double discountValue = Double.parseDouble(discount);
	     
	     double totalValue = (priceValue * quantityValue)- discountValue;
	     return totalValue;
	 }
}
