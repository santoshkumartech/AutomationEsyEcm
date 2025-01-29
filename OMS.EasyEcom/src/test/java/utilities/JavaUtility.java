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
}
