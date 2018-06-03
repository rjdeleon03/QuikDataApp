package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFacilitiesData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationFacilitiesData;
import com.rjdeleon.mvp_app.Models.Generics.BoolIntTuple;
import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelInt;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class EvacuationFacilitiesDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "Accommodation Capacity of the Evacuation Center or Temporary Shelter:",
            "Toilet(s)",
            "Wide Entrance/Exit",
            "Electricity",
            "Water Supply",
            "Proper Ventilation"
    };

    /**
     * Constructor
     * @param context
     * @param evacuationRepositoryManager
     */
    public EvacuationFacilitiesDataViewModel(Context context, EvacuationRepositoryManager evacuationRepositoryManager) {
        super(context, evacuationRepositoryManager);

        EvacuationFacilitiesData facilitiesData = mEvacuationRepositoryManager.getFacilitiesData();
        mQuestionsViewModels.add(new QuestionItemViewModelInt(new BaseQuestion(mQuestions[0], facilitiesData.getCapacity())));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1], facilitiesData.getToilets().isYes), facilitiesData.getToilets().remarks, "Number of Toilets"));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2], facilitiesData.getWideEntrance().isYes), facilitiesData.getWideEntrance().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3], facilitiesData.getElectricity().isYes), facilitiesData.getElectricity().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[4], facilitiesData.getWaterSupply().isYes), facilitiesData.getWaterSupply().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[5], facilitiesData.getProperVentilation().isYes), facilitiesData.getProperVentilation().remarks));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        List<QuestionItemViewModelBoolean> booleansList = new ArrayList<>();
        for (int i = 1; i < mQuestionsViewModels.size(); i++) {
            booleansList.add((QuestionItemViewModelBoolean) mQuestionsViewModels.get(i));
        }

        EvacuationFacilitiesData facilitiesData = new EvacuationFacilitiesData(
                ((QuestionItemViewModelInt) mQuestionsViewModels.get(0)).answer.get(),
                new BoolIntTuple(booleansList.get(0).answer.get(), booleansList.get(0).remarksInt.get()),
                new BoolRemarksTuple(booleansList.get(1).answer.get(), booleansList.get(1).remarks.get()),
                new BoolRemarksTuple(booleansList.get(2).answer.get(), booleansList.get(2).remarks.get()),
                new BoolRemarksTuple(booleansList.get(3).answer.get(), booleansList.get(3).remarks.get()),
                new BoolRemarksTuple(booleansList.get(4).answer.get(), booleansList.get(4).remarks.get()));

        mEvacuationRepositoryManager.saveFacilitiesData(facilitiesData);
    }
}