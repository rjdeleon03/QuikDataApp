package com.cpu.quikdata.Modules.NewDnca.Evacuation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationListFragment extends BaseMultiPageFragment {

    private EvacuationListViewModel mViewModel;

    public static EvacuationListFragment newInstance() {
        return new EvacuationListFragment();
    }

    public EvacuationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.evacuation_list_fragment, container, false);
    }


    /**
     * Set the viewModel
     * @param evacuationListViewModel
     */
    public void setViewModel(EvacuationListViewModel evacuationListViewModel) {
        mViewModel = evacuationListViewModel;
    }

}