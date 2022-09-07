package com.admin.campaign.advice.exception;

import org.springframework.http.HttpStatus;

import static com.admin.campaign.advice.constant.ErrorCodes.CAMPAIGN_NOT_FOUND;

public class NoSuchCampaignException extends GeneralException {

    public NoSuchCampaignException() {
        super(HttpStatus.NOT_FOUND, CAMPAIGN_NOT_FOUND, "No Such Campaign");
    }
}
