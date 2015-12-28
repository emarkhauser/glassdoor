package ca.markhauser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	int currentPageNumber;
    int totalNumberOfPages;
    int totalRecordCount;
    Employer employers;

}