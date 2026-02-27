package com.sandeep.quantitymeasurement;

public class QuantityMeasurementApp {
	
	// Feet Class
	public static class Feet{
		
		private final double value;
		
		public Feet(double value) {
			this.value=value;
		}
		public double getValue() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(getClass() != obj.getClass()) {
				return false;
			}
			Feet other= (Feet) obj;
			return Double.compare(this.value, other.value)==0;
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
		
	}
	
	public static void demonstrateFeetEquality() {
		
		Feet feet1 = new Feet(15.89);
		Feet feet2 = new Feet(15.89);
		String result;
		
		if(feet1.equals(feet2)) {
			result = "Feet objects are equal";
		}
		else {
			result = "Feet objects are not equal";
		}
		System.out.println(result);
	}
	
	// Inches Class
	public static class Inches{
		
		private final double value;
		
		public Inches(double value) {
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(this.getClass() != obj.getClass()) {
				return false; 
			}
			Inches other = (Inches) obj;
			return Double.compare(other.value, this.value) == 0;
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value); 
		}
		
	}
	
	public static void demonstrateInchesEquality() {
		
		Inches inche1 = new Inches(43.2);
		Inches inche2 = new Inches(43.2);
		String result;
		
		if(inche1.equals(inche2)) {
			System.out.println("Inches objects are equal");
		}
		else {
			System.out.println("Inches objects are not equal");
		}
	}
	
	public static void main(String[] args) {
		
		demonstrateFeetEquality();
		demonstrateInchesEquality(); 	
	
	}
}