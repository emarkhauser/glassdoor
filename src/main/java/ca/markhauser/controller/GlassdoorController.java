/**
 * 
 */
package ca.markhauser.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.markhauser.model.Employer;
import ca.markhauser.service.EmployerService;

@RestController
public class GlassdoorController {

	@RequestMapping("/employers")
	public ArrayList<Employer> employers(
			@RequestParam(value = "partnerId") String partnerId,
			@RequestParam(value = "partnerKey") String partnerKey,
			@RequestParam(value = "location") String location) {
		EmployerService employerService = new EmployerService();
		return employerService.getEmployers(partnerId, partnerKey, location);
	}

}
