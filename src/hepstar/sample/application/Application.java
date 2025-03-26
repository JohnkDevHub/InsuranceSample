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
package hepstar.sample.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
//
//import com.jcabi.xml.XML;
//import com.jcabi.xml.XMLDocument;


/**
 * @author henry
 *
 */
public class Application {

	// region Private Members

	/**
	 * This method loads the insured details from the insured.txt file
	 * 
	 * @return
	 */
	private static Insured getInsured() {
		Insured insured = new Insured();

		// TODO: Load insured details from insured.txt
		try
		{
			List<String>  data = new ArrayList<>();
			String file = "C:\\Users\\Toshiba\\eclipse-workspace\\InsuranceSample\\src\\hepstar\\sample\\application\\insured.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split("="));//splitting lines
				data.add(lineData.get(1));
				line = br.readLine();
			}
			//
			insured.setId(data.get(0)); 
			insured.setFirstname(data.get(1));
			insured.setSurname(data.get(2));
			insured.setDob(data.get(3));
			insured.setResidency(data.get(4));
			//printing the fetched data
			for(String list : data)
			{				
				System.out.println("--"+list);
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		return insured;
	}

	/**
	 * This method loads the travel information details from the travelinformation.txt file
	 * 
	 * @return
	 */
	private static TravelInformation getTravelInformation() {
		TravelInformation travelinformation = new TravelInformation();

		// TODO: Load travel information details from travelinformation.txt
		try
		{
			List<String>  data = new ArrayList<>();
			String file = "C:\\Users\\Toshiba\\eclipse-workspace\\InsuranceSample\\src\\hepstar\\sample\\application\\travelinformation.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split("="));
				data.add(lineData.get(1));
				line = br.readLine();
			}
			//
			travelinformation.setStartdate(data.get(0)); 
			travelinformation.setEnddate(data.get(1));
			travelinformation.setDeparturecountry(data.get(2));
			travelinformation.setCovercountry(data.get(3));
			//printing the fetched data
			for(String list : data)
			{				
				System.out.println("--"+list);
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return travelinformation;
	}

	/**
	 * This method loads the request message from the request.xml file
	 * 
	 * @return
	 */
	private static String getRequestMessage(Insured insured, TravelInformation travelinformation) throws ParserConfigurationException, SAXException, IOException{
		String requestmessage;
		// TODO: Load the request.xml file into requestmessage variable
		String file = "C:\\Users\\Toshiba\\eclipse-workspace\\InsuranceSample\\src\\hepstar\\sample\\application\\request.xml";
		File xmlFile = new File(file);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
		// TODO: replace all {DATA} with data from the getter methods from either insured or travel information
		// TODO: make sure {SESSION} is replaced with a GUID
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
        	if(line.contains("</Authentication>")) {
        		sb.append("\n").append("<Session>"+UUID.randomUUID()+"</Session>").append("\n");
        	}
        	if(line.contains("{ID}")) {
        		line=line.replace("{FIRSTNAME}", insured.getId());
        	}
        	else if(line.contains("{FIRSTNAME}")) {
        		line=line.replace("{FIRSTNAME}", insured.getFirstname());
        	}
        	else if(line.contains("{SURNAME}")) {
        		line=line.replace("{SURNAME}", insured.getSurname());
        	}
        	else if(line.contains("{DOB}")) {
        		line=line.replace("{DOB}", insured.getDob());
        	}
        	else if(line.contains("{RESIDENCY}")) {
        		line=line.replace("{RESIDENCY}", insured.getResidency());
        	}
        	//
        	if(line.contains("{STARTDATE}")) {
        		line=line.replace("{STARTDATE}", travelinformation.getStartdate());
        	}else if(line.contains("{ENDDATE}")) {
        		line=line.replace("{ENDDATE}", travelinformation.getEnddate());
        	}else if(line.contains("{DEPARTURECOUNTRY}")) {
        		line=line.replace("{DEPARTURECOUNTRY}", travelinformation.getDeparturecountry());
        	}else if(line.contains("{COVERCOUNTRY}")) {
        		line=line.replace("{COVERCOUNTRY}", travelinformation.getCovercountry());
        	}
        	
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();
        
        bufReader.close();
        return requestmessage=xml2String;
	}

	private static String sendRequestMessage(String requestmessage) {
		// TODO: send the request message as an HTTPs POST to our endpoint and receive a response
			//String API="http://localhost:9090/api/";	
			
			String API="https://uat.gateway.insure/products/priced";
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(API))
	                .version(HttpClient.Version.HTTP_1_1)
	                .header("Content-Type", "application/xml") 
	                .POST(HttpRequest.BodyPublishers.ofString(requestmessage))
	                .build();

	        HttpResponse<String> reqqq = null;
			try {
				reqqq = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				String res=reqqq.body();
				System.out.println("THIS IS IT HERE\n"+reqqq);
				
				
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String requestMessage=reqqq.body();
			return requestMessage;
	}

	// endregion

	// region Public Members

	/**
	 * This is where is all begins
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Insured insured = getInsured();
		TravelInformation travelinformation = getTravelInformation();
		String requestmessage = getRequestMessage(insured, travelinformation);

		System.out.println("\n\n View request: "+requestmessage);
		
		String responsemessage = sendRequestMessage(requestmessage);

		System.out.println("\n\n View Response: "+responsemessage);
	}

	// endregion

}
