package provider.impl;

import provider.Reader;

import java.util.Random;

/**
 * @author Arsalan
 */
public class RandomReader implements Reader {

	private Random random;
	private static final int DEFAULT_BOUND = 1000;

	public RandomReader() {
		random = new Random();
	}


	@Override
	public int getInt() {
		return random.nextInt(DEFAULT_BOUND);
	}

	@Override
	public double getDouble() {
		return random.nextDouble();
	}

	@Override
	public String getString(String s) {
		return s + random.nextInt();
	}
}
