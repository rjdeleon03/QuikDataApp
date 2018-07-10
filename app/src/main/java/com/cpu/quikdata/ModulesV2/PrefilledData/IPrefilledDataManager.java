package com.cpu.quikdata.ModulesV2.PrefilledData;

import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

public interface IPrefilledDataManager {

    void onPrefilledDataRetrieved(PrefilledData prefilledData);

    QuestionModel getQuestionModel(int index);

    int getItemsCount();
}
