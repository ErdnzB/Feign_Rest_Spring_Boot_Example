package com.admin.campaign.models;

import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRequest {

    private String title;
    private String subtitle;
    private boolean visible;
}
