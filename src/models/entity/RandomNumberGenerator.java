package models.entity;

import java.util.Random;

public class RandomNumberGenerator
{
	public static long getLongID()
	{
		long x = 1234567L;
		long y = 23456789L;
		Random r = new Random();
		long number = x+((long)(r.nextDouble()*(y-x)));
		return number;
	}
}
