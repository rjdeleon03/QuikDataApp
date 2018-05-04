package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData;


import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Dialog.PopulationDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Dialog.PopulationDataDialogContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

import java.util.List;

public class PopulationDataFragment extends BaseFragment implements PopulationDataContract.View {

    private PopulationDataPresenter mPresenter;
    private RecyclerView mGrid;
    private PopulationDataFragmentAdapter mAdapter;
    private Spinner mSpinner;
    private ArrayAdapter<PopulationData.AgeGroup> mSpinnerAdapter;

    public PopulationDataFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Population Data";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize presenter
        this.mPresenter = new PopulationDataPresenter(this, mNavigationPresenter);
        PopulationDataFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_fragment_v1, container, false);
        binding.setPresenter(mPresenter);
        View view = binding.getRoot();

        // Initialize spinner
        List<PopulationData.AgeGroup> spinnerList = mPresenter.getAgeGroupsList();
        this.mSpinner = view.findViewById(R.id.nf_population_age_spinner);
        mSpinnerAdapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_spinner_item, spinnerList
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mSpinner.setAdapter(mSpinnerAdapter);

        // Initialize adapter
        this.mGrid = view.findViewById(R.id.nf_population_grid);
        setCardGridLayout(getResources().getConfiguration().orientation);

        this.mAdapter = new PopulationDataFragmentAdapter(mPresenter);
        mGrid.setAdapter(mAdapter);

        return view;
    }

    @Override
    public PopulationDataDialogContract.View onAddButtonClick(View view) {
        PopulationDataDialogFragment fragment = new PopulationDataDialogFragment();
        fragment.show(getFragmentManager(), "population_dialog");
        return fragment;
    }

    @Override
    public int getAgeGroupSpinnerValue() {
        return (int) mSpinner.getSelectedItemId();
    }

    @Override
    public void onRowDeleteButtonClick() {
        refreshAdapters();
    }

    @Override
    public void onAgeGroupAdd() {
        refreshAdapters();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCardGridLayout(newConfig.orientation);
    }

    private void refreshAdapters() {
        mSpinnerAdapter.notifyDataSetChanged();
        mAdapter.notifyDataSetChanged();
        if (mSpinner.getCount() > 0) {
            mSpinner.setSelection(0);
        }
    }

    private void setCardGridLayout(int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        }
    }
}
