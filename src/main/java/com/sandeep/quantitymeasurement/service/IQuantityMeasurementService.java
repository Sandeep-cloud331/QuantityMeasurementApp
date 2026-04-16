package com.sandeep.quantitymeasurement.service;

import com.sandeep.quantitymeasurement.model.*;

import java.util.List;

public interface IQuantityMeasurementService {
	
	QuantityMeasurementDTO compareQuantities(QuantityDTO thisQty, QuantityDTO thatQty);
    QuantityMeasurementDTO convertQuantity(QuantityDTO thisQty, QuantityDTO thatQty);
    QuantityMeasurementDTO addQuantities(QuantityDTO thisQty, QuantityDTO thatQty);
    QuantityMeasurementDTO subtractQuantities(QuantityDTO thisQty, QuantityDTO thatQty);
    QuantityMeasurementDTO divideQuantities(QuantityDTO thisQty, QuantityDTO thatQty);
    
    List<QuantityMeasurementDTO> getAllHistory();
    List<QuantityMeasurementDTO> getHistoryByOperation(String operation);
    List<QuantityMeasurementDTO> getHistoryByType(String measurementType);
    List<QuantityMeasurementDTO> getErrorHistory();
    long getOperationCount(String operation);
	
}
