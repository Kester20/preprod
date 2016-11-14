package entity.product;

import entity.product.annot.ProductAnnotations;
import static entity.constants.Constants.VERSION;
/**
 * @author Arsalan
 *         Entity smart phone
 */
public class SmartPhone extends Phone {

	@ProductAnnotations.FriendlyName("version")
	private String androidVersion;


	public SmartPhone() {

	}

	/**
	 * @param id             smart phone's id
	 * @param name           smart phone's name
	 * @param cost           smart phone's cost
	 * @param producer       smart phone's producer
	 * @param androidVersion smart phone's version
	 */
	public SmartPhone(int id, String name, int cost, String producer, String androidVersion) {
		super(id, name, cost, producer);
		this.androidVersion = androidVersion;
	}

	/**
	 * @return version smart phone
	 */
	public String getAndroidVersion() {
		return androidVersion;
	}

	/**
	 * @param androidVersion smart phone
	 */
	@ProductAnnotations.Set(VERSION)
	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	/**
	 * @return a string representation of smart phone
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + ", producer:" + this.getProducer() + ", android version:" + this.getAndroidVersion());
		return sb.toString();
	}

	/**
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
