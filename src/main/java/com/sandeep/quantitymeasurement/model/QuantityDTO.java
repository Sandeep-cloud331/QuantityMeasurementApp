package com.sandeep.quantitymeasurement.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {
	
	public QuantityDTO(double v1, String u1, String t1) {
		// TODO Auto-generated constructor stub
		this.value = v1;
	    this.unit = u1;
	    this.measurementType = t1;
	}

	@NotNull(message="Value must not be null")
	private Double value;
	
	@NotEmpty(message="Unit must not be empty")
	private String unit;
	
	@NotEmpty(message="Measurement type must not be empty")
	private String measurementType;
	
}
