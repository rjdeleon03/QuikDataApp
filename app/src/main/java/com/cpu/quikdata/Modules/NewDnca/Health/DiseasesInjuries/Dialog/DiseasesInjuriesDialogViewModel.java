package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesRepositoryManager;

public class DiseasesInjuriesDialogViewModel extends DialogViewModel {

    private DiseasesInjuriesRepositoryManager mDiseasesInjuriesRepositoryManager;

    private String[] mQuestions = {
            "NUMBER OF CASES OF ILLNESSES",
            "Diarrhea",
            "Pneumonia",
            "Dengue",
            "Measles",
            "Others",
            "MEDICAL NEEDS",
            "Check-up",
            "Hospitalization",
            "Medicines",
            "Others"
    };

    /**
     * Constructor
     * @param context
     * @param diseasesInjuriesRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public DiseasesInjuriesDialogViewModel(Context context,
                                           DiseasesInjuriesRepositoryManager diseasesInjuriesRepositoryManager,
                                           int ageGroupIndex,
                                           boolean isNewRow) {
        super(context);
        mDiseasesInjuriesRepositoryManager = diseasesInjuriesRepositoryManager;

        DiseasesInjuriesDataRow diseasesInjuriesDataRow;
        if (isNewRow) {
            diseasesInjuriesDataRow = new DiseasesInjuriesDataRow(mDiseasesInjuriesRepositoryManager.getDiseasesInjuriesAgeGroup(ageGroupIndex));
        } else {
            diseasesInjuriesDataRow = mDiseasesInjuriesRepositoryManager.getDiseasesInjuriesDataRow(ageGroupIndex);
        }

        type.set(diseasesInjuriesDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelDivider(
                new DialogItemModelDivider(mQuestions[0], true)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], diseasesInjuriesDataRow.getMeasles().male, diseasesInjuriesDataRow.getMeasles().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], diseasesInjuriesDataRow.getDiarrhea().male, diseasesInjuriesDataRow.getDiarrhea().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[3], diseasesInjuriesDataRow.getPneumonia().male, diseasesInjuriesDataRow.getPneumonia().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[4], diseasesInjuriesDataRow.getDengue().male, diseasesInjuriesDataRow.getDengue().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[5], diseasesInjuriesDataRow.getIllOthers().male, diseasesInjuriesDataRow.getIllOthers().female)));
        mItemViewModels.add(new DialogItemViewModelDivider(
                new DialogItemModelDivider(mQuestions[6], true)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[7], diseasesInjuriesDataRow.getCheckUp().male, diseasesInjuriesDataRow.getCheckUp().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[8], diseasesInjuriesDataRow.getHospitalization().male, diseasesInjuriesDataRow.getHospitalization().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[9], diseasesInjuriesDataRow.getMedicines().male, diseasesInjuriesDataRow.getMedicines().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[10], diseasesInjuriesDataRow.getMedOthers().male, diseasesInjuriesDataRow.getMedOthers().female)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DialogItemViewModelGenderTuple measles = (DialogItemViewModelGenderTuple) mItemViewModels.get(1);
        DialogItemViewModelGenderTuple diarrhea = (DialogItemViewModelGenderTuple) mItemViewModels.get(2);
        DialogItemViewModelGenderTuple pneumonia = (DialogItemViewModelGenderTuple) mItemViewModels.get(3);
        DialogItemViewModelGenderTuple dengue = (DialogItemViewModelGenderTuple) mItemViewModels.get(4);
        DialogItemViewModelGenderTuple illOthers = (DialogItemViewModelGenderTuple) mItemViewModels.get(5);
        DialogItemViewModelGenderTuple checkUp = (DialogItemViewModelGenderTuple) mItemViewModels.get(7);
        DialogItemViewModelGenderTuple hospitalization = (DialogItemViewModelGenderTuple) mItemViewModels.get(8);
        DialogItemViewModelGenderTuple medicines = (DialogItemViewModelGenderTuple) mItemViewModels.get(9);
        DialogItemViewModelGenderTuple medOthers = (DialogItemViewModelGenderTuple) mItemViewModels.get(10);

        DiseasesInjuriesDataRow diseasesInjuriesDataRow = new DiseasesInjuriesDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(measles.value1.get(), measles.value2.get()),
                new GenderTuple(diarrhea.value1.get(), diarrhea.value2.get()),
                new GenderTuple(pneumonia.value1.get(), pneumonia.value2.get()),
                new GenderTuple(dengue.value1.get(), dengue.value2.get()),
                new GenderTuple(illOthers.value1.get(), illOthers.value2.get()),
                new GenderTuple(checkUp.value1.get(), checkUp.value2.get()),
                new GenderTuple(hospitalization.value1.get(), hospitalization.value2.get()),
                new GenderTuple(medicines.value1.get(), medicines.value2.get()),
                new GenderTuple(medOthers.value1.get(), medOthers.value2.get()));

        mDiseasesInjuriesRepositoryManager.addDiseasesInjuriesDataRow(diseasesInjuriesDataRow);
        super.navigateOnOkButtonPressed();
    }
}
