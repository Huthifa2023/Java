package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer IDcopy, String role) {
    	this.securityIncidents = new ArrayList<String>();
		this.employeeID = IDcopy;
		this.role = role;
	}
    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
		if(length < 6) {
			return false;
		}
		else {
			super.setPin(pin);
			return true;
		}
    }
    public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.getId() == confirmedAuthID) {
			return true;
		}
		else {
			this.authIncident();
			return false;
		}
    }
    // TO DO: Implement HIPAACompliantAdmin!
    public ArrayList<String> reportSecurityIncidents() {
    	return securityIncidents;
    }
    
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
}
