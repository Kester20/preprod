package entity.product;

import entity.product.annot.ProductAnnotations;

import static entity.constants.Constants.PRODUCER;

/**
 * @author Arsalan
 *         Entity Phone
 */
public class Phone extends Product {

	@ProductAnnotations.FriendlyName("producer")
	private String producer;

	public Phone() {

	}

	/**
	 * @param id       Phone's id
	 * @param name     Phone's name
	 * @param cost     Phone's cost
	 * @param producer Phone's producer
	 */
	public Phone(int id, String name, int cost, String producer) {
		super(id, name, cost);
		this.producer = producer;
	}

	/**
	 * @return producer Phone
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @param producer new value of producer's name
	 */
	@ProductAnnotations.Set(PRODUCER)
	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + ", producer:" + this.getProducer());
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Phone phone = (Phone) o;

		return producer != null ? producer.equals(phone.producer) : phone.producer == null;

	}
}
