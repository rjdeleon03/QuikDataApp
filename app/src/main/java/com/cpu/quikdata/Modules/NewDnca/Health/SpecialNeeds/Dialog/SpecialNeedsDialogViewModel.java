package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Dialog;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class SpecialNeedsDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType> mSpecialNeedsRepositoryManager;

    private String[] mQuestions = {
        "Number of People with Special Needs",
        "Health/Medical Needs"
    };


    /**
     * Constructor
     * @param specialNeedsRepositoryManager
     * @param specialNeedsIndex
     * @param isNewRow
     */
    public SpecialNeedsDialogViewModel(BaseEnumRepositoryManager<SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType> specialNeedsRepositoryManager,
                                       int specialNeedsIndex,
                                       boolean isNewRow) {
        super();
        mSpecialNeedsRepositoryManager = specialNeedsRepositoryManager;

        SpecialNeedsDataRow specialNeedsDataRow;
        if (isNewRow) {
            specialNeedsDataRow = new SpecialNeedsDataRow(mSpecialNeedsRepositoryManager.getEnumType(specialNeedsIndex));
        } else {
            specialNeedsDataRow = mSpecialNeedsRepositoryManager.getRow(specialNeedsIndex);
        }

        type.set(specialNeedsDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[0], specialNeedsDataRow.getCount(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], specialNeedsDataRow.getNeeds())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        SpecialNeedsDataRow specialNeedsDataRow = new SpecialNeedsDataRow(
                (GenericEnumDataRow.SpecialNeedsType) type.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(1)).value1.get());

        mSpecialNeedsRepositoryManager.addRow(specialNeedsDataRow);
        super.navigateOnOkButtonPressed();
    }
}
