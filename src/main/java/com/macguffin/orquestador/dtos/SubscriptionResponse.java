package com.macguffin.orquestador.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubscriptionResponse {
    private SubscriptionDTO subscription;
    private List<SubscriptionStatusDTO> statuses;
    private List<SubscriptionTypeDTO> types;
}
