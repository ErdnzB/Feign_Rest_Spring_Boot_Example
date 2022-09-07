package com.campaign.persistence.repository;

import com.campaign.persistence.entity.CampaignPublishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignPublishRepository extends JpaRepository<CampaignPublishEntity, Long> {
}
