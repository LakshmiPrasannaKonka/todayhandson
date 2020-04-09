package handsontoday.cf;
import java.util.Date;


public class Customer  {
int custid;
 String custname;
 String email;
 String mobile;
 Date dob;
 Address address;
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", email=" + email + ", mobile=" + mobile
				+ ", dob=" + dob + ", address=" + address + "]";
	

}



}
