package p2_email_administration_application;

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private String department = "";
	private String password = "";
	private String mailbox;
	public static String company = "teamtristan";
	private int p_length;
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailbox = "500 MB";
	}
	
	public void createEmail() {
		if(this.department == "")
			this.email = this.firstName + "." + this.lastName + "@" + company + ".com";
		else
			this.email = this.firstName + "." + this.lastName + "@" + this.department + "." + company + ".com";
		
	}
	
	public void setDepartment(int input) {
		int d = input;
		switch(d) {
			case 1:
				this.department = "sales";
				break;
			case 2:
				this.department = "development";
				break;
			case 3:
				this.department = "accounting";
				break;
			case 0:
				this.department = "";
				break;
			default:
				System.out.println("This is not a valid department. Try again later.");
		}
	}
	
	public void generatePassword() {
		p_length = (int)(6 + Math.random() *10);		//create char[] to store random elements
		char[] temp = new char[p_length];				
		for(int i = 0; i < p_length - 1; i++) {
			temp[i] = (char)(48 + Math.random() * 91);	//using ASCII values for chars like % or ]
		}
		
		for(int j = 0; j < p_length; j++) {
			this.password += temp[j];
		}
		
	}
	
	public void setEmail(String input) {
		if(this.department == "")
			this.email = input + "@" + company + ".com";
		else
			this.email = input + "@" + this.department + "." + company + ".com";
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMailbox() {
		return this.mailbox;
	}
	
	public void setMailbox(int capacity) {
		if(capacity > 0)
			this.mailbox = capacity + " MB";
		else
			System.out.println("That is not a valid size. Try again later.");
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	
}
