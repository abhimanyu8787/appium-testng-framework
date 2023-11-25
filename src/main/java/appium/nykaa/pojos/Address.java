package appium.nykaa.pojos;

import java.util.List;

public class Address {
	
	private int numberOfAddresses;
	private List<Addresses> addresses;
	
	public int getNumberOfAddresses() {
		return numberOfAddresses;
	}
	public void setNumberOfAddresses(int numberOfAddresses) {
		this.numberOfAddresses = numberOfAddresses;
	}
	public List<Addresses> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Addresses> addresses) {
		this.addresses = addresses;
	}

}
