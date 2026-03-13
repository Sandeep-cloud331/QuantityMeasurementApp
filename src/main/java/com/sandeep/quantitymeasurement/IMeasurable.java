package com.sandeep.quantitymeasurement;

public interface IMeasurable {
    double getConversionFactor();
    double convertToBase(double value);
    double convertFromBase(double value);
    String getUnitName();
}
