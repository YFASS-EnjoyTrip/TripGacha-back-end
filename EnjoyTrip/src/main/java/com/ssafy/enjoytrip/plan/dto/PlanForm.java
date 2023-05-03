package com.ssafy.enjoytrip.plan.dto;

import lombok.Data;

@Data
public class PlanForm {
    private int planId;
    private int memberId;
    private String title;
    private String image;
    private String startDate;
    private String endDate;
    private int viewCount;
    private int likeCount;
}
