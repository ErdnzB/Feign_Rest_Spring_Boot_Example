package com.campaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignDto implements Serializable {


    private Long id;
    private String title;
    private String subtitle;
    private boolean visible;

}



