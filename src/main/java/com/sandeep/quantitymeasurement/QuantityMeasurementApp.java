package com.sandeep.quantitymeasurement;

public class QuantityMeasurementApp {
	
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
			Feet other = (Feet) obj;
			return Double.compare(this.value, other.value) == 0;
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}

	
	public static void main(String[] args) {
		
		Feet feet1 = new Feet(15.89);
		Feet feet2 = new Feet(15.89);
		
		if(feet1.equals(feet2)) {
			System.out.println("equal");
		}
		else {
			System.out.println("not equal");
		}

	}

}
