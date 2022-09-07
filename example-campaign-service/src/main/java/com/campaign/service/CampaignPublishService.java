package com.campaign.service;

import com.campaign.advice.exception.NoSuchCampaignException;
import com.campaign.client.CampaignAdminServiceClient;
import com.campaign.converter.CampaignPublishConverter;
import com.campaign.dto.CampaignDto;
import com.campaign.dto.CampaignPublishDto;
import com.campaign.event.CampaignEvent;
import com.campaign.event.CampaignProcessEvent;
import com.campaign.models.CreatePublishRequest;
import com.campaign.persistence.entity.CampaignPublishEntity;
import com.campaign.persistence.repository.CampaignPublishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CampaignPublishService {

    private final CampaignAdminServiceClient adminClient;
    private final CampaignPublishRepository repository;
    private final KafkaService kafkaService;

    public CampaignPublishDto findById(Long id) {
        CampaignPublishEntity campaignPublishEntity = repository.findById(id).orElseThrow(NoSuchCampaignException::new);
        return CampaignPublishConverter.entityToDto(campaignPublishEntity);
    }

    public Long createCampaignPublish(CreatePublishRequest createRequest) {
        CampaignPublishEntity campaignPublishEntity = new CampaignPublishEntity();
        CampaignDto campaignDto = adminClient.getCampaign(createRequest.getCampaignId());
        campaignPublishEntity.setCampaignId(campaignDto.getId());
        campaignPublishEntity.setPublisherName(createRequest.getPublisherName());
        CampaignPublishEntity entity = repository.save(campaignPublishEntity);
        CampaignEvent campaignEvent = CampaignEvent.builder().campaignPublishId(entity.getId()).build();
        CampaignProcessEvent campaignProcessEvent = CampaignProcessEvent.builder().campaignEvent(campaignEvent).build();
        log.info("Produce By Kafka is started object {}", campaignProcessEvent);
        kafkaService.sendCampaignProcessEvent(campaignProcessEvent);
        log.info("Produced");
        return entity.getId();
    }
}
