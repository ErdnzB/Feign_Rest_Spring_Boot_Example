package com.campaign.advice.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

    public static final int CAMPAIGN_NOT_FOUND = 101003;
    public static final int UNKNOWN_ERROR = 26999;
    public static final int VALIDATION_ERROR = 26900;
}
