/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.sql.Date;

/**
 *
 * @author Oliver
 */
public class Patient {
        private String firstName;
	private String lastName;
        private String username;
        private Date dob;
        private String mobile;
        private String email;
        private String street;
        private String city;
        private String state;
        private String postcode;
        private String medicare;                           

	public Patient( ){
		this.username = "";
	}
        
        public Patient( String username ) {
		this.username = username;                
	}
        
        public String getUserName() {
            return username ;
	}
        
        public String getFirstName() {
            return firstName ;
	}
        
        public String getLastName() {
            return lastName;
	}
        
        public void setFirstName(String name) {
            this.firstName = name;
	}
        
        public void setLastName(String name) {
            this.lastName = name;
	}
        
        public Date getDate() {
            return dob;
	}
        
        public void setDate(Date date) {
            this.dob = date;
	}       
        
        public String getMobile() {
            return mobile;
	}
        
        public void setMobile(String name) {
            this.mobile = name;
	}
        
        public String getEmail() {
            return email;
	}
        
        public void setEmail(String name) {
            this.email = name;
	}
        
        public String getStreet() {
            return street;
	}
        
        public void setStreet(String name) {
            this.street = name;
	}
        
        public String getCity() {
            return city;
	}
        
        public void setCity(String name) {
            this.city = name;
	}
        
        public String getState() {
            return state;
	}
        
        public void setState(String name) {
            this.state = name;
	}
        
        public String getPostcode() {
            return postcode;
	}
        
        public void setPostcode(String name) {
            this.postcode = name;
	}
        
        public String getMedicare() {
            return medicare;
	}
        
        public void setMedicare(String name) {
            this.medicare = name;
	}
}
