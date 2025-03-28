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
public class TravelInformation {

	// region Private Members

	private String startdate;
	private String enddate;
	private String departurecountry;
	private String covercountry;

	// endregion

	// region Public Members

	// TODO: Create an empty public TravelInformation() constructor
	public TravelInformation() {
	}
	// TODO: Create public getter and setter methods for all private variables


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getDeparturecountry() {
		return departurecountry;
	}


	public void setDeparturecountry(String departurecountry) {
		this.departurecountry = departurecountry;
	}


	public String getCovercountry() {
		return covercountry;
	}


	public void setCovercountry(String covercountry) {
		this.covercountry = covercountry;
	}
	
	// endregion

}
