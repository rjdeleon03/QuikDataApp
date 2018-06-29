package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageRepositoryManager;

public class InfrastructureDamageDialogViewModel extends DialogViewModel {

    private InfrastructureDamageRepositoryManager mInfrastructureDamageRepositoryManager;

    private String[] mQuestions = {
            "Infrastructure Count",
            "Functional?",
            "Remarks"
    };

    private String[] mComments = {
            "(Specify if intermittent electricity, communications, etc)"
    };

    /**
     * Constructor
     * @param infrastructureDamageRepositoryManager
     * @param infaTypeIndex
     * @param isNewRow
     */
    public InfrastructureDamageDialogViewModel(InfrastructureDamageRepositoryManager infrastructureDamageRepositoryManager,
                                               int infaTypeIndex,
                                               boolean isNewRow) {
        super();
        mInfrastructureDamageRepositoryManager = infrastructureDamageRepositoryManager;

        InfrastructureDamageDataRow infrastructureDamageDataRow;
        if (isNewRow) {
            infrastructureDamageDataRow = new InfrastructureDamageDataRow(mInfrastructureDamageRepositoryManager.getInfrastructureDamageType(infaTypeIndex));
        } else {
            infrastructureDamageDataRow = mInfrastructureDamageRepositoryManager.getInfrastructureDamageRow(infaTypeIndex);
        }

        type.set(infrastructureDamageDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[0], infrastructureDamageDataRow.getDamaged())));
        mItemViewModels.add(new DialogItemViewModelBoolean(
                new DialogItemModelBoolean(mQuestions[1], infrastructureDamageDataRow.isFunctional())));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[2], mComments[0], infrastructureDamageDataRow.getRemarks())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        InfrastructureDamageDataRow infrastructureDamageDataRow = new InfrastructureDamageDataRow(
                (GenericEnumDataRow.InfraType) type.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelBoolean) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(2)).value1.get()
        );
        mInfrastructureDamageRepositoryManager.addInfrastructureDamageRow(infrastructureDamageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
