package entity.product;

import entity.product.annot.ProductAnnotations;

import static entity.constants.Constants.PRODUCER;
import static entity.constants.Constants.SCREEN;

/**
 * @author Arsalan
 *         Entity laptop
 */
public class Laptop extends Product {

	@ProductAnnotations.FriendlyName(PRODUCER)
	private String producer;
	@ProductAnnotations.FriendlyName(SCREEN)
	private double screenResolution;

	public Laptop() {
	}

	/**
	 * @param id               laptop
	 * @param name             laptop
	 * @param cost             laptop
	 * @param producer         laptop
	 * @param screenResolution laptop
	 */
	public Laptop(int id, String name, int cost, String producer, double screenResolution) {
		super(id, name, cost);
		this.producer = producer;
		this.screenResolution = screenResolution;
	}

	/**
	 * @return producer laptop
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @param producer laptop
	 */
	@ProductAnnotations.Set(PRODUCER)
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * @return screenResolution laptop
	 */
	public double getScreenResolution() {
		return screenResolution;
	}

	/**
	 * @param screenResolution laptop
	 */
	@ProductAnnotations.Set(SCREEN)
	public void setScreenResolution(double screenResolution) {
		this.screenResolution = screenResolution;
	}

	/**
	 * @return a string representation of entity laptop
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + ", producer:" + this.getProducer() + ", screen:" + this.getScreenResolution());
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Laptop laptop = (Laptop) o;

		if (Double.compare(laptop.screenResolution, screenResolution) != 0) return false;
		return producer != null ? producer.equals(laptop.producer) : laptop.producer == null;

	}


}
