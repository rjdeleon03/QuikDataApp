package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FamilyDataFragmentBinding;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_FAMILY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyDataFragment extends BaseSubFragment {

    private FamilyDataViewModel mViewModel;

    private GridLayout mGridLayout;

    public static FamilyDataFragment newInstance() {
        return new FamilyDataFragment();
    }

    public FamilyDataFragment() {
        setFragmentTag(GEN_INFO_FAMILY.toString());
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(FamilyDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.family_data_fragment, container, false);

        // Setup binding
        FamilyDataFragmentBinding binding = FamilyDataFragmentBinding.bind(root);
        binding.setViewModel(mViewModel);

        // Setup the grid layout
        setupGridLayout(root);

        return root;
    }

    /**
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setGridOrientation(newConfig);
    }

    /**
     * Sets up the grid layout
     * @param view
     */
    private void setupGridLayout(View view) {
        mGridLayout = view.findViewById(R.id.nd_family_grid);
        setGridOrientation(getContext().getResources().getConfiguration());
    }

    /**
     * Sets the grid layout based on device orientation
     * @param config
     */
    private void setGridOrientation(Configuration config) {

        boolean isLandscape = config.orientation == Configuration.ORIENTATION_LANDSCAPE;

        for (int i = 0; i < 2; i++) {
            View view = mGridLayout.getChildAt(i);

            GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
            lp.columnSpec = GridLayout.spec(-2147483648, 1, GridLayout.FILL, 1.0f);

            int horizontalMargin = AppUtil.dpToPx(getContext(), 8);
            int bottomMargin = AppUtil.dpToPx(getContext(), 16);
            lp.setMargins(horizontalMargin, 0, horizontalMargin, bottomMargin);

            view.setLayoutParams(lp);
        }

        if (isLandscape) {
            mGridLayout.setColumnCount(2);
            mGridLayout.setRowCount(1);
        } else {
            mGridLayout.setColumnCount(1);
            mGridLayout.setRowCount(2);
        }

    }
}