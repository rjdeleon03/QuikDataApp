package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationItem extends RealmObject implements IEnumDataRow<GenericEnumDataRow.EvacuationType> {

    @Required
    @PrimaryKey
    private String id;

    private EvacuationCenterDetails evacuationCenterDetails;
    private EvacuationFacilitiesDetails evacuationFacilitiesDetails;
    private EvacuationPopulationData evacuationPopulationData;

    public EvacuationItem() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EvacuationCenterDetails getEvacuationCenterDetails() {
        return evacuationCenterDetails;
    }

    public void setEvacuationCenterDetails(EvacuationCenterDetails evacuationCenterDetails) {
        this.evacuationCenterDetails = evacuationCenterDetails;
    }

    public EvacuationFacilitiesDetails getEvacuationFacilitiesDetails() {
        return evacuationFacilitiesDetails;
    }

    public void setEvacuationFacilitiesDetails(EvacuationFacilitiesDetails evacuationFacilitiesDetails) {
        this.evacuationFacilitiesDetails = evacuationFacilitiesDetails;
    }

    public EvacuationPopulationData getEvacuationPopulationData() {
        return evacuationPopulationData;
    }

    public void setEvacuationPopulationData(EvacuationPopulationData evacuationPopulationData) {
        this.evacuationPopulationData = evacuationPopulationData;
    }

    @Override
    public GenericEnumDataRow.EvacuationType getActualType() {
        return GenericEnumDataRow.EvacuationType.EVACUATION_TYPE;
    }

    @Override
    public void setupFields() {}

}
