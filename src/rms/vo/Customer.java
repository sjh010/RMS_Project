package rms.vo;

public class Customer {
	
	private String id = null;
	private String name;
	private String phone;
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
