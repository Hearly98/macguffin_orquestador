package com.macguffin.orquestador.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SubscriptionDTO {
    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastUpdated;
    private Integer userId;
    private String statusName;
    private String planName;
}
