package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;

import java.util.ArrayList;
import java.util.List;

public abstract class DialogViewModel extends NewDncaBaseViewModel implements DialogItemDataSource {

    public final ObservableField<GenericEnum> type = new ObservableField<>();
    protected List<DialogItemViewModel> mItemViewModels = new ArrayList<>();
    protected BaseEnumNavigator mBaseEnumNavigator;
    protected BaseEnumRepositoryManager mRepositoryManager;
    protected int mRowIndex;

    /**
     * Constructor
     */
    public DialogViewModel() {
        super();
    }

    /**
     * Sets the base age group navigator
     * @param baseEnumNavigator
     */
    public void setBaseAgeGroupNavigator(BaseEnumNavigator baseEnumNavigator) {
        mBaseEnumNavigator = baseEnumNavigator;
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        mBaseEnumNavigator.onDialogOkButtonPressed();
    }

    /**
     * Handles navigation when cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        mBaseEnumNavigator.onDialogCloseButtonPressed();
    }


    /**
     * Gets all item viewModels
     * @return
     */
    @Override
    public List<DialogItemViewModel> getItemViewModels() {
        return mItemViewModels;
    }


    /**
     * Sets the data
     * @param baseEnumNavigator
     * @param repositoryManager
     * @param rowIndex
     */
    public void setData(BaseEnumNavigator baseEnumNavigator, BaseEnumRepositoryManager repositoryManager, int rowIndex) {
        mBaseEnumNavigator = baseEnumNavigator;
        mRepositoryManager = repositoryManager;
        mRowIndex = rowIndex;
    }

}
