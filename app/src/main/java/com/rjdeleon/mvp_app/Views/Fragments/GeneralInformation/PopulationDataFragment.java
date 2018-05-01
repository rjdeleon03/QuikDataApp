package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.PopulationDataPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

public class PopulationDataFragment extends BaseFragment implements PopulationDataContract.View {

    private PopulationDataPresenter mPresenter;
    private RecyclerView mGrid;
    private PopulationDataFragmentAdapter mAdapter;

    public PopulationDataFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Population Data";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize presenter
        this.mPresenter = new PopulationDataPresenter(this, navigationPresenter);
        PopulationDataFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_fragment, container, false);
        binding.setPresenter(mPresenter);


        // Initialize adapter
        View view = binding.getRoot();
        this.mGrid = view.findViewById(R.id.nf_population_grid);
        mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        this.mAdapter = new PopulationDataFragmentAdapter(mPresenter);
        mGrid.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onAddButtonClick(View view) {
        mAdapter.notifyDataSetChanged();
    }
}