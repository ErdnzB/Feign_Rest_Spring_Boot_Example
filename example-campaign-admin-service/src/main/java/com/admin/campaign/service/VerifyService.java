package com.admin.campaign.service;

import com.admin.campaign.persistence.entity.VerifyEntity;
import com.admin.campaign.persistence.repository.VerifyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class VerifyService {

    private final VerifyRepository repository;


    public Long createVerification(Long campaignId) {
        VerifyEntity verifyEntity = new VerifyEntity();
        verifyEntity.setCampaignId(campaignId);
        verifyEntity.setPublished(true);
        return repository.save(verifyEntity).getId();
    }
}
