package com.po.optimizer.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RunIdDetails")
public class RunIdDetails {
    private String id;
    private Long runId;
    private String sectors;
    private String marketCap;
    private String selectedStocks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRunId() {
        return runId;
    }

    public void setRunId(Long runId) {
        this.runId = runId;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getSelectedStocks() {
        return selectedStocks;
    }

    public void setSelectedStocks(String selectedStocks) {
        this.selectedStocks = selectedStocks;
    }
}
