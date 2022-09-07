package com.admin.campaign.converter;

import com.admin.campaign.dto.CampaignDto;
import com.admin.campaign.persistence.entity.CampaignEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CampaignConverter {

    public static CampaignDto campaignDto(CampaignEntity campaignEntity){
        return CampaignDto.builder()
                .id(campaignEntity.getId())
                .subtitle(campaignEntity.getSubtitle())
                .title(campaignEntity.getTitle())
                .visible(campaignEntity.isVisible())
                .build();
    }
}
