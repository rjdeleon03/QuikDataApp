package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row;

import android.content.Context;

import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialRepositoryManager;

public class PsychosocialRowViewModel extends RowViewModel {

    private PsychosocialRepositoryManager mPsychosocialRepositoryManager;

    private String[] mQuestions = {
            "Manifestations of Mental Stress or Trauma",
            "Cases",
            "Needs"
    };

    /**
     * Constructor
     * @param psychosocialRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public PsychosocialRowViewModel(PsychosocialRepositoryManager psychosocialRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator, int rowIndex) {

        super(baseEnumNavigator, rowIndex);
        mPsychosocialRepositoryManager = psychosocialRepositoryManager;

        PsychosocialDataRow psychosocialDataRow = mPsychosocialRepositoryManager.getPsychosocialDataRow(rowIndex);
        type.set(psychosocialDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[0], psychosocialDataRow.getManifestations())));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[1], psychosocialDataRow.getCases().male, psychosocialDataRow.getCases().female)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[2], psychosocialDataRow.getNeeds())));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mPsychosocialRepositoryManager.deletePsychosocialDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
