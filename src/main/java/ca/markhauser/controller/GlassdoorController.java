/**
 * 
 */
package ca.markhauser.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.markhauser.model.CompanyResponse;
import ca.markhauser.model.Employer;

@RestController
public class GlassdoorController {

	String glassdoorApiUrl = "http://api.glassdoor.com/api/api.htm?&userip=0.0.0.0&useragent=&format=json";
	String glassdoorUrlEmployerBase = glassdoorApiUrl + "&v=1&action=employers";

	@RequestMapping("/employers")
	public ArrayList<Employer> employers(
			@RequestParam(value = "partnerId") String partnerId,
			@RequestParam(value = "partnerKey") String partnerKey,
			@RequestParam(value = "location") String location) {
		RestTemplate restTemplate = new RestTemplate();
		CompanyResponse companyResponse = restTemplate.getForObject(
				glassdoorUrlEmployerBase + "&t.p=" + partnerId + "&t.k="
						+ partnerKey + "&l=" + location, CompanyResponse.class);
		return companyResponse.getResponse().getEmployers();
	}

}
