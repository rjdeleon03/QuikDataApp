package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationFacilitiesDetails extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<QuestionItemModelBooleanString> booleanStringFields;

    public EvacuationFacilitiesDetails() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public RealmList<QuestionItemModelBooleanString> getBooleanStringFields() {
        return booleanStringFields;
    }

    public void setBooleanStringFields(RealmList<QuestionItemModelBooleanString> booleanStringFields) {
        this.booleanStringFields = booleanStringFields;
    }

    @Override
    public void setupFields() {

        if (booleanStringFields == null) {
            booleanStringFields = new RealmList<>();
        }
        if (booleanStringFields.isEmpty()) {
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "toilets", false, "numberOfToilets", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "wideEntranceExit", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "electricity", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "waterSupply", false, "remarks", ""));
            booleanStringFields.add(new QuestionItemModelBooleanString(AppUtil.generateId(), "properVentilation", false, "remarks", ""));
        }

    }
}