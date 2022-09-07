package com.admin.campaign.service;

import com.admin.campaign.advice.exception.NoSuchCampaignException;
import com.admin.campaign.converter.CampaignConverter;
import com.admin.campaign.dto.CampaignDto;
import com.admin.campaign.models.CreateRequest;
import com.admin.campaign.persistence.entity.CampaignEntity;
import com.admin.campaign.persistence.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CampaignService {

    private final CampaignRepository repository;

    public CampaignDto findById(Long id) {
        CampaignEntity campaignEntity = repository.findById(id).orElseThrow(NoSuchCampaignException::new);
        return CampaignConverter.campaignDto(campaignEntity);
    }

    public Long createCampaign(CreateRequest createRequest) {
        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setSubtitle(createRequest.getSubtitle());
        campaignEntity.setTitle(createRequest.getTitle());
        campaignEntity.setVisible(createRequest.isVisible());
        return repository.save(campaignEntity).getId();
    }
}
