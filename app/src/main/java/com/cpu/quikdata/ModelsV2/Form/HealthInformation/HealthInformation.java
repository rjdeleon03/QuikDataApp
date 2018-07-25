package com.cpu.quikdata.ModelsV2.Form.HealthInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class HealthInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private DiseasesData diseasesData;
    private SpecialNeedsData specialNeedsData;
    private PsychosocialData psychosocialData;
    private HealthCopingDetails healthCopingDetails;
    private HealthGapsDetails healthGapsDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DiseasesData getDiseasesData() {
        return diseasesData;
    }

    public void setDiseasesData(DiseasesData diseasesData) {
        this.diseasesData = diseasesData;
    }

    public SpecialNeedsData getSpecialNeedsData() {
        return specialNeedsData;
    }

    public void setSpecialNeedsData(SpecialNeedsData specialNeedsData) {
        this.specialNeedsData = specialNeedsData;
    }

    public PsychosocialData getPsychosocialData() {
        return psychosocialData;
    }

    public void setPsychosocialData(PsychosocialData psychosocialData) {
        this.psychosocialData = psychosocialData;
    }

    public HealthCopingDetails getHealthCopingDetails() {
        return healthCopingDetails;
    }

    public void setHealthCopingDetails(HealthCopingDetails healthCopingDetails) {
        this.healthCopingDetails = healthCopingDetails;
    }

    public HealthGapsDetails getHealthGapsDetails() {
        return healthGapsDetails;
    }

    public void setHealthGapsDetails(HealthGapsDetails healthGapsDetails) {
        this.healthGapsDetails = healthGapsDetails;
    }
}