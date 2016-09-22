package com.iermu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mock")
public class Mock {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="RequestUrl")
	private String requestUrl;
	
	//0= get, 1=post, 2=delete
	@Column(name="RequestMethod")
	private int requestMethod;
	
	@Column(name="RequestHeader")
	private String requestHeader;
	
	@Column(name="RequestParameters")
	private String requestParameters;
	
	@Column(name="RequestBody")
	private String requestBody;
	
	@Column(name="ResponseDelay")
	private Integer responseDelay;
	
	@Column(name="StatusCode")
	private String StatusCode;
	
	@Column(name="ResponseFormat")
	private String responseFormat;
	
	@Column(name="ResponseHeader")
	private String responseHeader;
	
	@Column(name="ResponseBody")
	private String responseBody;

	
	public String getResponseFormat() {
		return responseFormat;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public int getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(int requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(String requestHeader) {
		this.requestHeader = requestHeader;
	}

	public String getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(String requestParameters) {
		this.requestParameters = requestParameters;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public Integer getResponseDelay() {
		return responseDelay;
	}

	public void setResponseDelay(int responseDelay) {
		this.responseDelay = responseDelay;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		return "Mock [id=" + id + ", requestUrl=" + requestUrl + ", requestMethod=" + requestMethod + ", requestHeader="
				+ requestHeader + ", requestParameters=" + requestParameters + ", requestBody=" + requestBody
				+ ", responseDelay=" + responseDelay + ", StatusCode=" + StatusCode + ", responseFormat="
				+ responseFormat + ", responseHeader=" + responseHeader + ", responseBody=" + responseBody + "]";
	}

	public Mock(Long id, String requestUrl, int requestMethod, String requestHeader, String requestParameters,
			String requestBody, int responseDelay, String statusCode, String responseFormat, String responseHeader,
			String responseBody) {
		super();
		this.id = id;
		this.requestUrl = requestUrl;
		this.requestMethod = requestMethod;
		this.requestHeader = requestHeader;
		this.requestParameters = requestParameters;
		this.requestBody = requestBody;
		this.responseDelay = responseDelay;
		StatusCode = statusCode;
		this.responseFormat = responseFormat;
		this.responseHeader = responseHeader;
		this.responseBody = responseBody;
	}
	
	public Mock()
	{
	}
	


	
	
	

}
