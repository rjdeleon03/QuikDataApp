package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Wash.WashConditionsData;
import com.rjdeleon.mvp_app.Models.Wash.WaterLevelRemarksTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelBase;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelBoolean;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelInt;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions.WashConditionsItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class WashConditionsViewModel extends WashBaseViewModel implements NonEnumSaveableSection {

    private List<WashConditionsItemViewModelBase> mQuestionsViewModels = new ArrayList<>();

    private String[] mQuestions = {
            "",
            "",
            "How many water points and conditions are there?",
            "Is the water potable? \n" +
                    "If not, where do they get clean drinking water? (specify distance from the residential units)",
            "How much time do they spend in fetching water?",
            "Who owns the water source?",
            "Do they have to pay for the water? How much per container?",
            "Do they have to pay fare or transportation cost?",
            "Are there particular times there is no water available?",
            "Are there hand washing facilities?",
            "Is there a proper garbage disposal facility?",
            "Is waste segregation observed?",
            "How do women manage issues related to menstruation? Do they use napkins?",
            "How are napkins disposed?",
            "How are baby diapers disposed?",
            "What are the current defecation practices?",
            "What are the toilet facilities available? How many?",
            "What are the conditions of the latrines after the disaster?",
            "Is the current defecation practice a threat to water supplies or living areas?",
            "Are the existing facilities properly maintained?",
            "Are there security and protection issues?",
            "Are the toilets segregated between male and female?",
            "Are the toilets accessible for all (seniors, disabled, children, pregnant, etc)?"
    };

    /**
     * Constructor
     * @param context
     * @param washRepositoryManager
     */
    public WashConditionsViewModel(Context context, WashRepositoryManager washRepositoryManager) {
        super(context, washRepositoryManager);

        WashConditionsData washConditionsData = mWashRepositoryManager.getWashConditionsData();
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[1], "Sample")));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[2], "Sample")));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[2], washConditionsData.getWaterPointsNumber())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[3], washConditionsData.getWaterPotable())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[4], washConditionsData.getTimeFetchingWater())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[5], washConditionsData.getWaterSourceOwner())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[6], washConditionsData.getPayForWater())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[7], washConditionsData.getPayForTranspo())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[8], washConditionsData.getTimesNoWater())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[9], washConditionsData.getHasWashingFacilities())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[10], washConditionsData.getHasGarbageDisposal())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[11], washConditionsData.getIsWasteSegregated())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[12], washConditionsData.getWomenMenstruation())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[13], washConditionsData.getNapkinsDisposed())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[14], washConditionsData.getDiapersDispoed())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[15], washConditionsData.getDefecationPractices())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[16], washConditionsData.getToiletFacilities())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[17], washConditionsData.getToiletConditions())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[18], washConditionsData.getIsDefecationThreat())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[19], washConditionsData.getAreFacilitiesMaintained())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[20], washConditionsData.getHasSecurityIssues())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[21], washConditionsData.getAreToiletsSegregated())));
        mQuestionsViewModels.add(new WashConditionsItemViewModelString(new BaseQuestion(mQuestions[22], washConditionsData.getAreToiletsAccessible())));
    }

    /**
     * Gets number of questions
     * @return
     */
    public int getQuestionsCount() {
        return mQuestionsViewModels.size();
    }

    /**
     * Gets question at specified index
     * @return
     */
    public WashConditionsItemViewModelBase getQuestionViewModel(int index) {
        return mQuestionsViewModels.get(index);
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        WashConditionsData washConditionsData = new WashConditionsData(
                new WaterLevelRemarksTuple(),
                new WaterLevelRemarksTuple(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(3)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(4)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(5)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(7)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(8)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(9)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(10)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(11)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(12)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(13)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(14)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(15)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(16)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(17)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(18)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(19)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(20)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(21)).answer.get(),
                ((WashConditionsItemViewModelString) mQuestionsViewModels.get(22)).answer.get());
        mWashRepositoryManager.saveWashConditionsData(washConditionsData);
    }
}
