package com.campaign.models;

import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePublishRequest {


    private Long campaignId;
    private String publisherName;

}
