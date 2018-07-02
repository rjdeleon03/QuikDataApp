package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsData;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

import java.util.List;

public class SpecialNeedsViewModel extends HealthEnumBaseViewModel implements BaseEnumRepositoryManager<SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType> {

    /**
     * Constructor
     * @param healthRepositoryManager
     */
    public SpecialNeedsViewModel(HealthRepositoryManager healthRepositoryManager) {
        super(healthRepositoryManager, GenericEnumDataRow.SpecialNeedsType.class);
        mGenericEnumDataRows.addAll(mHealthRepositoryManager.getSpecialNeedsData().getSpecialNeedsDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        SpecialNeedsData specialNeedsData = new SpecialNeedsData((List<SpecialNeedsDataRow>)(Object) mGenericEnumDataRows);
        mHealthRepositoryManager.saveSpecialNeedsData(specialNeedsData);
    }

    /**
     * Adds special needs data row
     * @param row
     */
    @Override
    public void addRow(SpecialNeedsDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes special needs data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets special needs data row
     * @param rowIndex
     * @return
     */
    @Override
    public SpecialNeedsDataRow getRow(int rowIndex) {
        return (SpecialNeedsDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets special needs type based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.SpecialNeedsType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.SpecialNeedsType) ageGroupList.get(typeIndex);
    }
}
