package com.eligibility.service;

import org.springframework.stereotype.Component;

import com.usereligibility.xml.payload.EligibilityRequest;
import com.usereligibility.xml.payload.EligibilityResponse;

@Component
public class EligibilityService {

	public EligibilityResponse getEligibilityOfTheUser(EligibilityRequest eligibilityRequest) {

		EligibilityResponse eligibilityResponse = new EligibilityResponse();

		Long income = eligibilityRequest.getIncome();
		Integer houseHoldSize = eligibilityRequest.getHouseHoldSize();

		double subsidy = (income * houseHoldSize) / 100;

		eligibilityResponse.setAmount(subsidy);
		eligibilityResponse.setIsUserEligibleFOrSubciddy(true);

		return eligibilityResponse;
	}

}
