package com.admin.campaign.advice;

import com.admin.campaign.advice.constant.ErrorCodes;
import com.admin.campaign.advice.exception.ExternalServiceException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class CampaignServiceErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String body = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            Map<String, String> map = mapper.readValue(body, new TypeReference<Map<String, String>>() {
            });
            String code = map.getOrDefault("code", "" + ErrorCodes.UNKNOWN_ERROR);
            String message = map.getOrDefault("message", StringUtils.EMPTY);
            throw new ExternalServiceException(message, Integer.parseInt(code));

        } catch (IOException ex) {
            log.error("Error Occurred.MethodKey : {}", methodKey);
            throw new IllegalStateException("Error Occurred.MethodKey : " + methodKey);
        }
    }
}
