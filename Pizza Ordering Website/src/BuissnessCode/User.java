package BuissnessCode;

//Run FrontDoor.java Project to start the Project 
public class User {

private String name;
private String phone;
private String email;
private String address;
private Pizza pizza;
private String ordertype;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Pizza getPizza() {
	return pizza;
}
public void setPizza(Pizza pizza) {
	this.pizza = pizza;
}
public String getOrdertype() {
	return ordertype;
}
public void setOrdertype(String ordertype) {
	this.ordertype = ordertype;
}
public User(String name, String phone, String email, String address, Pizza pizza, String ordertype) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.address = address;
	this.pizza = pizza;
	this.ordertype = ordertype;
}




}
