package com.wisemoney.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class driver {

	public static void main(String[] args) {
		
		final Sharpe sharpe = new Sharpe();
		
		//List<Double> msft = new ArrayList<>(Arrays.asList(72.50,72.78,72.90,72.75,72.69,72.40,72.20,71.98,72.25,72.58,72.97,73.23,74.0,74.15));
		//List<Double> aapl = new ArrayList<>(Arrays.asList(156.98,156.90,156.47,156.20,156.76,156.56,156.30,156.12,156.02,155.65,155.67,155.93,156.12,156.70));
		
		double [] aapl = {156.98,156.90,156.47,156.20,156.76,156.56,156.30,156.12,156.02,155.65,155.67,155.93,156.12,156.70};
		final double [] returns = { 0.054, 0.0086, -0.0846, 0.1040, 0.013, 0.0037, 0.0078, 0.0116, 0.00923, 0.0112, 0.0187, 0.0061 };
		
		double sharperatio = sharpe.getSharpeRatio(returns, 0.0224);
		
		System.out.println("==> AAPL change in price:");
		for (int i = 0; i < aapl.length; i++) {
			double diff = 0;
			diff = Math.round(Math.abs(aapl[i+1] - aapl[i])*100)/100.0d;
			i++; 
			System.out.println(diff);
		}
		
		System.out.println("Sharpe Ratio is: "+sharperatio);
	}
}
