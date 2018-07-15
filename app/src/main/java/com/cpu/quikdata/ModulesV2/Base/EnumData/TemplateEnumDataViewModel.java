package com.cpu.quikdata.ModulesV2.Base.EnumData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D> extends BaseViewModel<AC> implements IBaseDataManager<D> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateEnumDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mActivity.get() != null) {
            mActivity.get().onAddButtonPressed();
        }
    }
}