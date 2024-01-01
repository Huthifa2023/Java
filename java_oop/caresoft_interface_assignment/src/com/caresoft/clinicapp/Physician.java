package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician(Integer IDcopy) {
		super.setId(IDcopy);
	}
    // TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if(length < 4) {
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
			return false;
		}
    }
	
	
	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
}
