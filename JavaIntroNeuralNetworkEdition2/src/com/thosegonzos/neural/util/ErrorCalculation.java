package com.thosegonzos.neural.util;

public class ErrorCalculation 
{
	private double globalError;
	private int setSize;
	
	public double calculateRMS()
	{
		final double err = Math.sqrt(this.globalError / this.setSize);
		return err;
	}
	
	public void reset()
	{
		this.globalError = 0;
		this.setSize = 0;
	}
	
	public void updateErrror(final double actual[], final double ideal[])
	{
		for (int i = 0; i < actual.length; i++)
		{
			final double delta = ideal[i] - actual[i];
			this.globalError += delta * delta;
			this.setSize += ideal.length;
		}
	}
}