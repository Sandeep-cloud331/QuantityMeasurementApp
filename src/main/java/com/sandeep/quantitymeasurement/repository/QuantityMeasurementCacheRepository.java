package com.sandeep.quantitymeasurement.repository;

import com.sandeep.quantitymeasurement.model.QuantityMeasurementEntity;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {
    private final List<QuantityMeasurementEntity> storage = new ArrayList<>();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        storage.add(entity);
    }
}