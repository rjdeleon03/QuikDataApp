package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSecurityFragment extends BaseMultiPageFragment {

    public static final String FOOD_SECURITY_IMPACT_VIEWMODEL_TAG = "FOOD_SECURITY_IMPACT_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_COPING_VIEWMODEL_TAG = "FOOD_SECURITY_COPING_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_NEEDS_VIEWMODEL_TAG = "FOOD_SECURITY_NEEDS_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_ASSISTANCE_VIEWMODEL_TAG = "FOOD_SECURITY_ASSISTANCE_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_GAPS_VIEWMODEL_TAG = "FOOD_SECURITY_GAPS_VIEWMODEL_TAG";

    public static FoodSecurityFragment newInstance() {
        return new FoodSecurityFragment();
    }

    public FoodSecurityFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Setup specific repository manager
        FoodSecurityRepositoryManager repositoryManager = (FoodSecurityRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup impact data fragment
            FoodImpactDataFragment foodImpactDataFragment = FoodImpactDataFragment.newInstance();
            FoodImpactDataViewModel foodImpactDataViewModel = new FoodImpactDataViewModel(getContext().getApplicationContext(), repositoryManager);
            foodImpactDataFragment.setViewModel(foodImpactDataViewModel);
            mAdapter.addFragment(foodImpactDataFragment);

            // Bind impact data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(foodImpactDataViewModel),
                    FOOD_SECURITY_IMPACT_VIEWMODEL_TAG);
        }

        {
            // Setup coping data fragment
            GenericCopingDataFragment genericCopingDataFragment = GenericCopingDataFragment.newInstance();
            GenericCopingDataViewModel genericCopingDataViewModel = new GenericCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
            genericCopingDataFragment.setViewModel(genericCopingDataViewModel);
            mAdapter.addFragment(genericCopingDataFragment);

            // Bind coping data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(genericCopingDataViewModel),
                    FOOD_SECURITY_COPING_VIEWMODEL_TAG);
        }

        {
            // Setup needs data fragment
            FoodNeedsDataFragment foodNeedsDataFragment = FoodNeedsDataFragment.newInstance();
            FoodNeedsDataViewModel foodNeedsDataViewModel = new FoodNeedsDataViewModel(getContext().getApplicationContext(), repositoryManager);
            foodNeedsDataFragment.setViewModel(foodNeedsDataViewModel);
            mAdapter.addFragment(foodNeedsDataFragment);

            // Bind needs data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(foodNeedsDataViewModel),
                    FOOD_SECURITY_NEEDS_VIEWMODEL_TAG);
        }

        {
            // Setup assistance data fragment
            AssistanceDataFragment assistanceDataFragment = AssistanceDataFragment.newInstance();
            AssistanceDataViewModel assistanceDataViewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
            assistanceDataFragment.setViewModel(assistanceDataViewModel);
            mAdapter.addFragment(assistanceDataFragment);

            // Bind assistance data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(assistanceDataViewModel),
                    FOOD_SECURITY_ASSISTANCE_VIEWMODEL_TAG);
        }

        {
            // Setup gaps data fragment
            FoodGapsDataFragment foodGapsDataFragment = FoodGapsDataFragment.newInstance();
            FoodGapsDataViewModel foodGapsDataViewModel = new FoodGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
            foodGapsDataFragment.setViewModel(foodGapsDataViewModel);
            mAdapter.addFragment(foodGapsDataFragment);

            // Bind gaps data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(foodGapsDataViewModel),
                    FOOD_SECURITY_GAPS_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}
