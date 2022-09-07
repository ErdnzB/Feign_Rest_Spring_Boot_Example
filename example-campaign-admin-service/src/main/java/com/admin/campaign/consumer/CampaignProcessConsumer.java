package com.admin.campaign.consumer;

import com.admin.campaign.event.CampaignProcessEvent;
import com.admin.campaign.service.VerifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CampaignProcessConsumer {

    private final VerifyService verifyService;

    @KafkaListener(topics = "${kafka.topic.campaignProcessTopic}",
            groupId = "campaign-process-consumer-group-1",
            containerFactory = "kafkaListenerCampaignProcessFactory")
    public void listenCampaignProcessTopic(final CampaignProcessEvent campaignProcessEvent) {
        log.info("new campaignProcessEvent : {} consumed..", campaignProcessEvent.toString());
        Long verificationId = verifyService.createVerification(campaignProcessEvent.getCampaignEvent().getCampaignPublishId());
        log.info("consumed correctly Verification is Created id is {}", verificationId);
    }
}
