package com.campaign.client;

import com.campaign.dto.CampaignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "campaign-admin-service", url = "${campaign-admin-service.url}")
public interface CampaignAdminServiceClient {

    @GetMapping("/campaign/admin/{campaignId}")
    CampaignDto getCampaign(@PathVariable final Long campaignId);
}
