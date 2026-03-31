package com.sandeep.quantitymeasurement.service;

import com.sandeep.quantitymeasurement.model.QuantityMeasurementEntity;
import com.sandeep.quantitymeasurement.quantity.Quantity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(Quantity<?> q1, Quantity<?> q2);

    QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit);

    QuantityMeasurementEntity add(Quantity<?> q1, Quantity<?> q2);

    QuantityMeasurementEntity subtract(Quantity<?> q1, Quantity<?> q2);

    QuantityMeasurementEntity divide(Quantity<?> q1, Quantity<?> q2);
}