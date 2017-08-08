package com.thosegonzos.hopfield;

public class ConsoleHopfield 
{
	public static String formatBoolean(final boolean b[])
	{
		final StringBuilder result = new StringBuilder();
		result.append('[');
		for (int i = 0; i < b.length; i++)
		{
			if (b[i])
			{
				result.append('T');
			}
			else
			{
				result.append('F');
			}
			if (i != b.length - 1)
			{
				result.append(',');
			}
		}
		result.append(']');
		return (result.toString());
	}
	
		
	public static void main(String[] args) 
	{
		// Create the Hopfield neural network
		final HopfieldNetwork network = new HopfieldNetwork(4);
		// Train with this pattern
		final boolean[] pattern1 = { true, true, false, false };
		// This pattern will be presented
		final boolean[] pattern2 = { true, false, false, false };
		
		boolean[] result;
		
		// Train the neural network with pattern1
		System.out.println("Training Hopfield netwoirk with: " + formatBoolean(pattern1));
		network.train(pattern1);
		
		// Present pattern1 and see it recognized
		result = network.present(pattern1);
		System.out.println("Presenting pattern: " + formatBoolean(pattern1) +
				", and got " + formatBoolean(result));
		
		// Present pattern2
		result = network.present(pattern2);
		System.out.println("Presenting pattern: " + formatBoolean(pattern2) +
				", and got " + formatBoolean(result));
	}

}
