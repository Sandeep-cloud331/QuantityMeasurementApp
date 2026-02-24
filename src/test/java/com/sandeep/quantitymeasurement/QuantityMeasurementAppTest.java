package com.sandeep.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantityMeasurementAppTest {

	
	@Test
	void testEquality_SameValue() {
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(11.02);
		QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(11.02);
		assertTrue(f1.equals(f2));
	}
	
	@Test
	void testEquality_DifferentValue() {
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);
		assertFalse(f1.equals(f2));
	}
	
	@Test
	void testEquality_NullComparison() {
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
		assertFalse(f1.equals(null));
	}
	
	@Test
	void testEquality_NonNumericInput() {
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
		assertFalse(f1.equals("1.0"));
	}
	@Test
	void testEqualit_SameReference() {
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
		assertTrue(f1.equals(f1));
	}

}
