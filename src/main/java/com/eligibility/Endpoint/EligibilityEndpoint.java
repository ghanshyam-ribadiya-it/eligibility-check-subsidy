package com.eligibility.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eligibility.service.EligibilityService;
import com.usereligibility.xml.payload.EligibilityRequest;
import com.usereligibility.xml.payload.EligibilityResponse;

@Endpoint
public class EligibilityEndpoint {

	private static final String NAMESPACE_URI = "http://www.usereligibility.com/xml/payload";

	@Autowired
	EligibilityService eligibilityService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "EligibilityRequest")
	@ResponsePayload
	public EligibilityResponse checkTheUserEligibility(@RequestPayload EligibilityRequest eligibilityRequest) {
		return eligibilityService.getEligibilityOfTheUser(eligibilityRequest);
	}

}
