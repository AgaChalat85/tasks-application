package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByType {

    @JsonProperty("trello")
    private Trello trello;

    public AttachmentsByType() {

    }

    public AttachmentsByType(Trello trello) {
        this.trello = trello;
    }

    public Trello getTrello() {
        return trello;
    }
}
