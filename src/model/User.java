package model;

public class User {
   private int userid;
   private String username;
   private String sex;
   private int age;
   
	
	public int getUserid() {
		return userid;
	}
	
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getSex() {
		return sex;
	}
	
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [id=" + userid + ", uname=" + username + ", age=" + age + "]";
	}
	
	
   
}
