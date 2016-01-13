package ca.markhauser.model;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	int currentPageNumber;
    int totalNumberOfPages;
    int totalRecordCount;
    LinkedList<Employer> employers;

	public Response() {
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public LinkedList<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(LinkedList<Employer> employers) {
		this.employers = employers;
	}

}