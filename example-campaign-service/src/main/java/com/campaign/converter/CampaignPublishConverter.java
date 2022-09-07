package com.campaign.converter;

import com.campaign.dto.CampaignPublishDto;
import com.campaign.persistence.entity.CampaignPublishEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CampaignPublishConverter {

    public static CampaignPublishDto entityToDto(CampaignPublishEntity campaignPublishEntity) {
        return CampaignPublishDto.builder()
                .id(campaignPublishEntity.getId())
                .publisherName(campaignPublishEntity.getPublisherName())
                .campaignId(campaignPublishEntity.getCampaignId())
                .build();
    }
}
