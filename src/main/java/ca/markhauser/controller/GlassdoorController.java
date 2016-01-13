/**
 * 
 */
package ca.markhauser.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.markhauser.model.Employer;
import ca.markhauser.service.EmployerService;

@RestController
public class GlassdoorController {
	
	@Autowired
	EmployerService employerService;

	@RequestMapping("/employers")
	public Collection<Employer> employers(
			@RequestParam(value = "partnerId") String partnerId,
			@RequestParam(value = "partnerKey") String partnerKey,
			@RequestParam(value = "location") String location) {
		return employerService.getEmployers(partnerId, partnerKey, location);
	}

}
