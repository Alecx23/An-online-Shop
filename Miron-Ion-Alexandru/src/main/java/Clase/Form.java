package Clase;

public class Form {

	private String address;
	private String phoneNumber;
	private String parola;
	
	
	public Form(String parola) {
		this.parola = parola;
	}

	public Form() {
		
	}
	
	public Form(String address, String phoneNumber) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
	
}
