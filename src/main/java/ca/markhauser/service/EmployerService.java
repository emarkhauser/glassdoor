package ca.markhauser.service;

import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ca.markhauser.model.CompanyResponse;
import ca.markhauser.model.Employer;

@Service
public class EmployerService {

	private String glassdoorApiUrl = "http://api.glassdoor.com/api/api.htm?&userip=0.0.0.0&useragent=&format=json";
	private String glassdoorUrlEmployerBase = glassdoorApiUrl
			+ "&v=1&action=employers";

	private static final Logger logger = LoggerFactory
			.getLogger(EmployerService.class);

	public EmployerService() {
	}

	public LinkedList<Employer> getEmployers(String partnerId,
			String partnerKey, String location) {
		
		LinkedList<Employer> employers = new LinkedList<Employer>();
		int i = 1;
		int totalNumberPages = 0;

		do {
			CompanyResponse companyResponse = getCompanyResponseByPage(partnerId, partnerKey, location, i);
			employers.addAll(companyResponse.getResponse().getEmployers());
			totalNumberPages = companyResponse.getResponse().getTotalNumberOfPages();
			i ++;
		} while (i <= totalNumberPages);

		return employers;
	}

	private CompanyResponse getCompanyResponseByPage(String partnerId,
			String partnerKey, String location, int pageNumber) {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Page Number: " + pageNumber + ": Rest Template object created");
		CompanyResponse companyResponse = restTemplate.getForObject(
				glassdoorUrlEmployerBase + "&t.p=" + partnerId + "&t.k="
						+ partnerKey + "&l=" + location + "&pn=" + pageNumber,
				CompanyResponse.class);
		logger.info("Page Number: " + pageNumber + ": Received REST response for page");
		return companyResponse;
	}

}