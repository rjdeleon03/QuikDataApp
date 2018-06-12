package com.cpu.quikdata.Modules.NewDnca.CaseStories.Image;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesRepositoryManager;

public class CaseStoriesImageViewModel extends NewDncaBaseViewModel {

    private CaseStoriesRepositoryManager mCaseStoriesRepositoryManager;
    public final ObservableField<String> imagePath = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param caseStoriesRepositoryManager
     * @param index
     */
    public CaseStoriesImageViewModel(Context context,
                                     CaseStoriesRepositoryManager caseStoriesRepositoryManager,
                                     int index) {
        super(context);
        mCaseStoriesRepositoryManager = caseStoriesRepositoryManager;
        imagePath.set(mCaseStoriesRepositoryManager.getImagePath(index));
    }
}
