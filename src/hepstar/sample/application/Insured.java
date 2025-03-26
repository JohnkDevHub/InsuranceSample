/*
 * Author henry
 *
 * Copyright (c) 2025 Hepstar, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Hepstar. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hepstar
 *
 * HEPSTAR MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
/**
 * 
 */
package hepstar.sample.application;

/**
 * @author henry
 *
 */
public class Insured {

	// region Private Members

	private String id;
	private String firstname;
	private String surname;
	private String dob;
	private String residency;
	

	// endregion

	// region Public Members

	// TODO: Create an empty public Insured() constructor
	public Insured() {
	}
	// TODO: Create public getter and setter methods for all private variables


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getResidency() {
		return residency;
	}


	public void setResidency(String residency) {
		this.residency = residency;
	}


	@Override
	public String toString() {
		return "Insured [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", dob=" + dob
				+ ", residency=" + residency + "]";
	}
	
	// endregion
	
	

}
