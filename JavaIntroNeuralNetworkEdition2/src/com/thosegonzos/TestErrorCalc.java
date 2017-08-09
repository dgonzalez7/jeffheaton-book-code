package com.thosegonzos;

import com.thosegonzos.neural.util.ErrorCalculation;

public class TestErrorCalc 
{

	public static void main(String[] args) 
	{
		double ideal[][] = 
			{ {1, 2, 3, 4},
			  {5, 6, 7, 8},
			  {9, 10, 11, 12},
			  {13, 14, 15, 16} };
		
		double actual[][] = 
			{ {1, 2, 3, 5},
			  {5, 6, 7, 8},
			  {9, 10, 11, 12},
			  {13, 14, 15, 16} };
		
		ErrorCalculation error = new ErrorCalculation();
		for (int i = 0; i < ideal.length; i++)
		{
			error.updateErrror(actual[i], ideal[i]);
		}
		System.out.println(error.calculateRMS());
	}

}
