package com.admin.campaign.controller;

import com.admin.campaign.dto.CampaignDto;
import com.admin.campaign.models.CreateRequest;
import com.admin.campaign.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/campaign/admin")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping("/{campaignId}")
    public CampaignDto getCampaign(@PathVariable final Long campaignId) {
        return campaignService.findById(campaignId);
    }

    @PostMapping
    public Long createCampaign(@Valid @RequestBody CreateRequest createRequest) {
       return campaignService.createCampaign(createRequest);
    }

}


