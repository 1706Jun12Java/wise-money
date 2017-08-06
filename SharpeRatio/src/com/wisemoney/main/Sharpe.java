package com.wisemoney.main;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Sharpe {

	public final double getSharpeRatio(final double [] returns, final double riskFreeReturn) {
		final DescriptiveStatistics stats = new DescriptiveStatistics();
        for(double item : returns) {
    		stats.addValue(item);
    	}        
        final int MONTH_IN_YEAR = 12;
        
    	double mean = stats.getMean();
    	double annualizedMean = mean * MONTH_IN_YEAR;

    	double std = stats.getStandardDeviation();
    	double annualizedStd = std * Math.sqrt( MONTH_IN_YEAR );

    	double sharpeRatio = 0.0;
    	sharpeRatio = (annualizedMean - (riskFreeReturn) ) / annualizedStd; // *  unbiasedFactor;

    	return sharpeRatio;
	}

}
