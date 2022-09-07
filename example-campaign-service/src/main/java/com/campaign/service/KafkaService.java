package com.campaign.service;

import com.campaign.configuration.properties.KafkaProperties;
import com.campaign.event.CampaignProcessEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    @Async
    public void sendCampaignProcessEvent(final CampaignProcessEvent campaignProcessEvent) {
        kafkaTemplate.send(kafkaProperties.getTopic().getCampaignProcessTopic(), campaignProcessEvent);
        log.info("{} has been sent to CampaignProcessTopic", campaignProcessEvent.toString());
    }
}
