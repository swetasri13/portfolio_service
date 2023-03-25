package com.po.optimizer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "optimizer_summary")
public class Optimizersummary {

    @Id
    public String objid;

    public String runid;

    public Map<String, Double> min_vol_port;

    public Map<String, Double> max_risk_port;

    public String image;

    public String getRunid() {
        return runid;
    }

    public Map<String, Double> getMin_vol_port() {
        return min_vol_port;
    }

    public Map<String, Double> getMax_risk_port() {
        return max_risk_port;
    }

    public String getImage() {
        return image;
    }


    public void setRunid(String runid) {
        this.runid = runid;
    }

    public void setMin_vol_port(Map<String, Double> min_vol_port) {
        this.min_vol_port = min_vol_port;
    }

    public void setMax_risk_port(Map<String, Double> max_risk_port) {
        this.max_risk_port = max_risk_port;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Optimizersummary{" +
                "objid='" + objid + '\'' +
                ", runid='" + runid + '\'' +
                ", min_vol_port=" + min_vol_port +
                ", max_risk_port=" + max_risk_port +
                ", image='" + image + '\'' +
                '}';
    }
}

