package com.campaign.controller;

import com.campaign.dto.CampaignPublishDto;
import com.campaign.models.CreatePublishRequest;
import com.campaign.service.CampaignPublishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/publish")
public class CampaignPublishController {

    private final CampaignPublishService campaignPublishService;

    @GetMapping("/{campaignId}")
    public CampaignPublishDto getCampaignPublish(@PathVariable final Long campaignId) {
        return campaignPublishService.findById(campaignId);
    }

    @PostMapping
    public Long createCampaign(@Valid @RequestBody CreatePublishRequest createRequest) {
        return campaignPublishService.createCampaignPublish(createRequest);
    }

}


