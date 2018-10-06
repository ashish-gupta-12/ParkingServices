package com.randd.parkingservice;

public class CustomerDetails {
	
	String ownerName, carNo, time, token;
	String phoneNo;
	int floor, section, compartment;
	
	
	public CustomerDetails(String ownerName, String carNo, String time, String phoneNo) {
		super();
		this.ownerName = ownerName;
		this.carNo = carNo;
		this.time = time;
		this.phoneNo = phoneNo;
	}

	public String getTime() {
		return time;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	


	public String getToken() {
		return token;
	}

	public int getSection() {
		return section;
	}



	public void setFloor(int floor) {
		this.floor = floor;
	}


	public void setSection(int section) {
		this.section = section;
	}


	public void setCompartment(int compartment) {
		this.compartment = compartment;
		String token = this.getFloor()+":"+this.getSection()+":"+this.getCompartment();
		this.setToken(token);
	}


	public String getOwnerName() {
		return ownerName;
	}


	public String getCarNo() {
		return carNo;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getFloor() {
		return floor;
	}


	public int getCompartment() {
		return compartment;
	}

	@Override
	public String toString() {
		return "CustomerDetails [ownerName=" + ownerName + ", carNo=" + carNo + ", time=" + time + ", token=" + token
				+ ", phoneNo=" + phoneNo + ", floor=" + floor + ", section=" + section + ", compartment=" + compartment
				+ "]";
	}

}
