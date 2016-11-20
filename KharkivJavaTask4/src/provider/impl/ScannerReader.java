package provider.impl;

import provider.Reader;

import java.util.Scanner;

/**
 * @author Arsalan
 */
public class ScannerReader implements Reader {

	private Scanner scanner;

	public ScannerReader() {
		this.scanner = new Scanner(System.in);
	}


	@Override
	public int getInt() {
		return scanner.nextInt();
	}

	@Override
	public double getDouble() {
		return scanner.nextDouble();
	}

	@Override
	public String getString(String s) {
		return scanner.next();
	}
}
