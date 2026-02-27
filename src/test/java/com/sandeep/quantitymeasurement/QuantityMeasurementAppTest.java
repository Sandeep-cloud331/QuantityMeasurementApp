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
	// Inches class test cases
	@Test
	void testInchesEquality_SameValue() {
			QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(23.0);
			QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(23.0);
			assertEquals(i1, i2);
		}
		
		@Test
		void testInchesEquality_DifferentValue() {
			QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.98);
			QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(16.98);
			assertFalse(i1.equals(i2));
		}
		
		@Test
		void testInchesEquality_NullComparison() {
			QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(88.0);
			assertFalse(i1.equals(null));
		}
		
		@Test
		void testInchesEquality_NonNumericInput() {
			QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.0);
			assertFalse(i1.equals("12.0"));
		}
		
		@Test
		void testInchesEquality_SameReference() {
			QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(11.11);
			assertTrue(i1.equals(i1));
		}


}

