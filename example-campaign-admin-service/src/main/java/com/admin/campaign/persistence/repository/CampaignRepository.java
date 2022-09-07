package com.admin.campaign.persistence.repository;

import com.admin.campaign.persistence.entity.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<CampaignEntity,Long> {
}
