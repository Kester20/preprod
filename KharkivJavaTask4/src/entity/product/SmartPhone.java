package entity.product;

/**
 * Entity smart phone
 */
public class SmartPhone extends Phone {

	private String androidVersion;


	public SmartPhone() {

	}

	/**
	 * @param id             smart phone
	 * @param name           smart phone
	 * @param cost           smart phone
	 * @param producer       smart phone
	 * @param androidVersion smart phone
	 */
	public SmartPhone(int id, String name, double cost, String producer, String androidVersion) {
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
