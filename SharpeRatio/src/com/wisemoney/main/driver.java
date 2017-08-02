package com.wisemoney.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class driver {

	public static void main(String[] args) {
		
		List<Double> msft = new ArrayList<>(Arrays.asList(72.50,72.78,72.90,72.75,72.69,72.40,72.20,71.98,72.25,72.58,72.97,73.23,74.0,74.15));
		List<Double> aapl = new ArrayList<>(Arrays.asList(156.98,156.90,156.47,156.20,156.76,156.56,156.30,156.12,156.02,));
		List<Double> goog = new ArrayList<>(Arrays.asList(12.6, 12.4, 12.9));
		
		System.out.println("Microsoft stock prices are:");
		for (Double price: msft){
			System.out.println(price);
		}
	}
}
