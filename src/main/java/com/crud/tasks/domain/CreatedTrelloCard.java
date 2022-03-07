package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private Badges badges;

    public CreatedTrelloCard() {

    }

    public CreatedTrelloCard(String id, String name, String shortUrl, Badges badges) {
        this.id = id;
        this.name = name;
        this.shortUrl = shortUrl;
        this.badges = badges;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Badges getBadges() {
        return badges;
    }
}

