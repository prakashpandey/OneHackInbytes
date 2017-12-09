package com.onehack.recommendation.dao;

public enum Brands {

	Samsung("Samsung"), LG("LG"), Whirlpool("Whirlpool"), Godrej("Godrej");

	public String brands;

	Brands(String brands) {
		this.brands = brands;
	}

	public String getBrands() {
		return brands;
	}
}
