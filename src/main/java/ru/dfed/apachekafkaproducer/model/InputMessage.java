package ru.dfed.apachekafkaproducer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InputMessage {

    @JsonProperty("system.dateCreate")
    private String dateCreate;

    @JsonProperty("system.processID")
    private String processID;

    @JsonProperty("dataInvestmentAgreement.sourceSystemOrderId")
    private String sourceSystemOrderId;


}
