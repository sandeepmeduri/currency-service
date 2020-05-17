package com.infy.currency.dto;

/**
 * @author Sandeep_Meduri
 *
 */
public class CurrencyDTO {
	
	private String from;
	
	private String to;
	
	private double conversion;
	
	public CurrencyDTO() {
	}

	public CurrencyDTO(String from, String to, double conversion) {
		this.from = from;
		this.to = to;
		this.conversion = conversion;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getConversion() {
		return conversion;
	}

	public void setConversion(double conversion) {
		this.conversion = conversion;
	}

}
