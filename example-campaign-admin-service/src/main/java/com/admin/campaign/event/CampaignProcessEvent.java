package com.admin.campaign.event;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CampaignProcessEvent {

    private CampaignEvent campaignEvent;
}
