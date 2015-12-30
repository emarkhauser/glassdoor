package ca.markhauser.service;

import java.util.ArrayList;
import org.springframework.web.client.RestTemplate;
import ca.markhauser.model.CompanyResponse;
import ca.markhauser.model.Employer;

public class EmployerService {

	private String glassdoorApiUrl = "http://api.glassdoor.com/api/api.htm?&userip=0.0.0.0&useragent=&format=json";
	private String glassdoorUrlEmployerBase = glassdoorApiUrl
			+ "&v=1&action=employers";

	public EmployerService() {
	}

	public ArrayList<Employer> getEmployers(String partnerId,
			String partnerKey, String location) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Employer> employers = new ArrayList<Employer>();
		int pageNumber = 0;
		int currentPageNumber = 0;
		int totalNumberOfPages = 0;
		do {
			pageNumber++;
			CompanyResponse companyResponse = restTemplate.getForObject(
					glassdoorUrlEmployerBase + "&t.p=" + partnerId + "&t.k="
							+ partnerKey + "&l=" + location + "&pn="
							+ pageNumber, CompanyResponse.class);
			currentPageNumber = companyResponse.getResponse().getCurrentPageNumber();
			totalNumberOfPages = companyResponse.getResponse().getTotalNumberOfPages();
			employers.addAll(companyResponse.getResponse().getEmployers());
		} while (currentPageNumber < totalNumberOfPages);
		return employers;
	}

}