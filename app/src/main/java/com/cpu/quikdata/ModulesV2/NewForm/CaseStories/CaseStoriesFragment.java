package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaseStoriesFragment extends BaseFragment<CaseStoriesViewModel> {


    public CaseStoriesFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.CASE_STORIES.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static CaseStoriesFragment newInstance() {

        return new CaseStoriesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.template_case_stories_fragment, container, false);
    }

}