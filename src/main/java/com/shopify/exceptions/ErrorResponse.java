package com.shopify.exceptions;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "error")
public class ErrorResponse 
{
	
	
    
	private Long errorCode;
	

	//General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;
    
    

	
    public ErrorResponse(Long errorCode, String message, List<String> details) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.details = details;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
 
   
}