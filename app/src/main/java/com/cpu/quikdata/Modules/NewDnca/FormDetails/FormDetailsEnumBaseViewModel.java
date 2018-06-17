package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

public abstract class FormDetailsEnumBaseViewModel extends BaseQuestionViewModel {

    protected FormDetailsRepositoryManager mFormDetailsRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param formDetailsRepositoryManager
     */
    public FormDetailsEnumBaseViewModel(Context context, FormDetailsRepositoryManager formDetailsRepositoryManager) {
        super(context);
        mFormDetailsRepositoryManager = formDetailsRepositoryManager;
    }
}
