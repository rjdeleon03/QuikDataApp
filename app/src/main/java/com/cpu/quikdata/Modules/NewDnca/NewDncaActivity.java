package com.cpu.quikdata.Modules.NewDnca;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesFragment;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesNavigator;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationListFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationListViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.Utils.ImageUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;
import com.cpu.quikdata.databinding.NewDncaActivityBinding;

import java.util.List;

import static com.cpu.quikdata.AppConstants.REQUEST_IMAGE_CAPTURE;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator, CaseStoriesNavigator {

    private NewDncaFragment mNewDncaFragment;
    private NewDncaViewModel mMainViewModel;

    private FormDetailsViewModel mFormDetailsViewModel;
    private GenInfoViewModel mGenInfoViewModel;
    private ShelterInfoViewModel mShelterInfoViewModel;
    private FoodSecurityViewModel mFoodSecurityViewModel;
    private LivelihoodsViewModel mLivelihoodsViewModel;
    private HealthViewModel mHealthViewModel;
    private WashViewModel mWashViewModel;
    private EvacuationListViewModel mEvacuationListViewModel;
    private EvacuationItemViewModel mEvacuationItemViewModel;
    private CaseStoriesViewModel mCaseStoriesViewModel;

    private FormDetailsFragment mFormDetailsFragment;
    private GenInfoFragment mGenInfoFragment;
    private ShelterInfoFragment mShelterInfoFragment;
    private FoodSecurityFragment mFoodSecurityFragment;
    private LivelihoodsFragment mLivelihoodsFragment;
    private HealthFragment mHealthFragment;
    private WashFragment mWashFragment;
    private EvacuationListFragment mEvacuationListFragment;
    private EvacuationItemFragment mEvacuationItemFragment;
    private CaseStoriesFragment mCaseStoriesFragment;

    private CameraOwner mCameraOwner = null;
    private NewDncaActivityBinding mMainBinding;

    public enum NewDncaComponent {
        MENU,
        FORM_DETAILS,
        GEN_INFO,
        SHELTER_INFO,
        FOOD_SECURITY,
        LIVELIHOODS,
        HEALTH,
        WASH,
        EVACUATION,
        EVACUATION_ITEM,
        CASE_STORIES
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.new_dnca_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_new_dnca);
        setSupportActionBar(toolbar);

        {
            // Setup view and viewModel
            mNewDncaFragment = (NewDncaFragment) findOrCreateViewFragment(NewDncaComponent.MENU);
            mMainViewModel = (NewDncaViewModel) findOrCreateViewModel(NewDncaComponent.MENU);

            // Link view and viewModel
            mNewDncaFragment.setViewModel(mMainViewModel);
            mMainViewModel.setNewDncaNavigator(this);

            // Bind viewModel to view
            mMainBinding.setViewModel(mMainViewModel);
        }

        // Restore viewModels if applicable when activity is started
        List<Fragment> loadedFragments = getSupportFragmentManager().getFragments();
        for(Fragment currentFragment : loadedFragments) {
            
            if (currentFragment instanceof ViewModelHolder) continue;

            if(currentFragment.getTag().equals(NewDncaComponent.FORM_DETAILS.toString())) {
                mFormDetailsFragment = (FormDetailsFragment) currentFragment;
                mFormDetailsViewModel = (FormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
                mFormDetailsFragment.setViewModel(mFormDetailsViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.GEN_INFO.toString())) {
                mGenInfoFragment = (GenInfoFragment) currentFragment;
                mGenInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
                mGenInfoFragment.setViewModel(mGenInfoViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.SHELTER_INFO.toString())) {
                mShelterInfoFragment = (ShelterInfoFragment) currentFragment;
                mShelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
                mShelterInfoFragment.setViewModel(mShelterInfoViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.FOOD_SECURITY.toString())) {
                mFoodSecurityFragment = (FoodSecurityFragment) currentFragment;
                mFoodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
                mFoodSecurityFragment.setViewModel(mFoodSecurityViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.LIVELIHOODS.toString())) {
                mLivelihoodsFragment = (LivelihoodsFragment) currentFragment;
                mLivelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
                mLivelihoodsFragment.setViewModel(mLivelihoodsViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.HEALTH.toString())) {
                mHealthFragment = (HealthFragment) currentFragment;
                mHealthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
                mHealthFragment.setViewModel(mHealthViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.WASH.toString())) {
                mWashFragment = (WashFragment) currentFragment;
                mWashViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
                mWashFragment.setViewModel(mWashViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.EVACUATION.toString())) {
                mEvacuationListFragment = (EvacuationListFragment) currentFragment;
                mEvacuationListViewModel = (EvacuationListViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
                mEvacuationListFragment.setViewModel(mEvacuationListViewModel);

            } else if(currentFragment.getTag().equals(NewDncaComponent.CASE_STORIES.toString())) {
                mCaseStoriesFragment = (CaseStoriesFragment) currentFragment;
                mCaseStoriesViewModel = (CaseStoriesViewModel) findOrCreateViewModel(NewDncaComponent.CASE_STORIES);
                mCaseStoriesFragment.setViewModel(mCaseStoriesViewModel);
                mCameraOwner = mCaseStoriesViewModel;

            }
        }
    }

    @Override
    public void onBackButtonPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            mMainViewModel.performCleanup();
        }
        onBackPressed();
    }

    /**
     * Show form details fragment
     */
    @Override
    public void onFormDetailsButtonPressed() {
        FormDetailsFragment formDetailsFragment = (FormDetailsFragment) findOrCreateViewFragment(NewDncaComponent.FORM_DETAILS);
        mFormDetailsViewModel = (FormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
        formDetailsFragment.setViewModel(mFormDetailsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formDetailsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FORM_DETAILS.toString());
    }

    /**
     * Show general information fragment
     */
    @Override
    public void onGenInfoButtonPressed() {
        GenInfoFragment genInfoFragment = (GenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
        mGenInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
        genInfoFragment.setViewModel(mGenInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), genInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.GEN_INFO.toString());
    }

    /**
     * Show shelter information fragment
     */
    @Override
    public void onShelterInfoButtonPressed() {
        ShelterInfoFragment shelterInfoFragment = (ShelterInfoFragment) findOrCreateViewFragment(NewDncaComponent.SHELTER_INFO);
        mShelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
        shelterInfoFragment.setViewModel(mShelterInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), shelterInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.SHELTER_INFO.toString());
    }

    /**
     * Show food security fragment
     */
    @Override
    public void onFoodSecurityButtonPressed() {
        FoodSecurityFragment foodSecurityFragment = (FoodSecurityFragment) findOrCreateViewFragment(NewDncaComponent.FOOD_SECURITY);
        mFoodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
        foodSecurityFragment.setViewModel(mFoodSecurityViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), foodSecurityFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FOOD_SECURITY.toString());
    }

    /**
     * Show livelihoods fragment
     */
    @Override
    public void onLivelihoodsButtonPressed() {
        LivelihoodsFragment livelihoodsFragment = (LivelihoodsFragment) findOrCreateViewFragment(NewDncaComponent.LIVELIHOODS);
        mLivelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
        livelihoodsFragment.setViewModel(mLivelihoodsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), livelihoodsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.LIVELIHOODS.toString());
    }

    /**
     * Show health fragment
     */
    @Override
    public void onHealthButtonPressed() {
        HealthFragment healthFragment = (HealthFragment) findOrCreateViewFragment(NewDncaComponent.HEALTH);
        mHealthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
        healthFragment.setViewModel(mHealthViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), healthFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.HEALTH.toString());
    }

    /**
     * Show wash fragment
     */
    @Override
    public void onWashButtonPressed() {
        WashFragment washFragment = (WashFragment) findOrCreateViewFragment(NewDncaComponent.WASH);
        mWashViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
        washFragment.setViewModel(mWashViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), washFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.WASH.toString());
    }

    /**
     * Show evacuation fragment
     */
    @Override
    public void onEvacuationButtonPressed() {
        EvacuationListFragment evacuationListFragment = (EvacuationListFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION);
        mEvacuationListViewModel = (EvacuationListViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
        evacuationListFragment.setViewModel(mEvacuationListViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), evacuationListFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.EVACUATION.toString());
    }

    /**
     * Show evacuation item fragment
     */
    @Override
    public void onEvacuationAddButtonPressed(int index) {
//        ViewFactory.startEvacuationListActivity(this);
        EvacuationItemFragment evacuationItemFragment = (EvacuationItemFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION_ITEM);
        mEvacuationItemViewModel = (EvacuationItemViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION_ITEM);
        mEvacuationItemViewModel.setItemIndex(index);
        evacuationItemFragment.setViewModel(mEvacuationItemViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), evacuationItemFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.EVACUATION_ITEM.toString());

    }

    /**
     * Show case stories fragment
     */
    @Override
    public void onCaseStoriesButtonPressed() {
        mCaseStoriesFragment = (CaseStoriesFragment) findOrCreateViewFragment(NewDncaComponent.CASE_STORIES);
        mCaseStoriesViewModel = (CaseStoriesViewModel) findOrCreateViewModel(NewDncaComponent.CASE_STORIES);
        mCaseStoriesFragment.setViewModel(mCaseStoriesViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mCaseStoriesFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.CASE_STORIES.toString());
    }

    /**
     * Starts image capture activity
     * @param cameraOwner
     */
    @Override
    public void onCameraButtonPressed(CameraOwner cameraOwner) {
        ViewFactory.startCameraActivity(this);
        mCameraOwner = cameraOwner;
    }

    /**
     * Handles results from startActivityForResult calls
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (mCameraOwner != null) {
                mCameraOwner.addImagePath(ImageUtils.getImagePath(this, ImageUtils.getBitmapFromIntent(data)));
                onImagesUpdated();
            }
        }
    }

    /**
     * Refreshes case stories fragment data when image updates occur
     */
    @Override
    public void onImagesUpdated() {
        mCaseStoriesFragment.refreshData();
    }

    @NonNull
    private Fragment findOrCreateViewFragment(NewDncaComponent fragmentType) {

        // Retrieve fragment if it exists
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentType.toString());

        switch(fragmentType) {
            case MENU:
                if (fragment == null || !(fragment instanceof NewDncaFragment)) {
                    fragment = NewDncaFragment.newInstance();
                    ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                            fragment,
                            R.id.new_dnca_fragment_container,
                            false,
                            fragmentType.toString());
                }
                break;

            case FORM_DETAILS:
                if (fragment == null || !(fragment instanceof FormDetailsFragment)) {
                    fragment = FormDetailsFragment.newInstance();
                }
                break;

            case GEN_INFO:
                if (fragment == null || !(fragment instanceof GenInfoFragment)) {
                    fragment = GenInfoFragment.newInstance();
                }
                break;

            case SHELTER_INFO:
                if (fragment == null || !(fragment instanceof ShelterInfoFragment)) {
                    fragment = ShelterInfoFragment.newInstance();
                }
                break;

            case FOOD_SECURITY:
                if (fragment == null || !(fragment instanceof FoodSecurityFragment)) {
                    fragment = FoodSecurityFragment.newInstance();
                }
                break;

            case LIVELIHOODS:
                if (fragment == null || !(fragment instanceof LivelihoodsFragment)) {
                    fragment = LivelihoodsFragment.newInstance();
                }
                break;

            case HEALTH:
                if (fragment == null || !(fragment instanceof HealthFragment)) {
                    fragment = HealthFragment.newInstance();
                }
                break;

            case WASH:
                if (fragment == null || !(fragment instanceof WashFragment)) {
                    fragment = WashFragment.newInstance();
                }
                break;

            case EVACUATION:
                if (fragment == null || !(fragment instanceof EvacuationListFragment)) {
                    fragment = EvacuationListFragment.newInstance();
                }
                break;

            case EVACUATION_ITEM:
                if (fragment == null || !(fragment instanceof EvacuationItemFragment)) {
                    fragment = EvacuationItemFragment.newInstance();
                }
                break;

            case CASE_STORIES:
                if (fragment == null || !(fragment instanceof CaseStoriesFragment)) {
                    fragment = CaseStoriesFragment.newInstance();
                }
                break;
        }

        return fragment;
    }

    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(NewDncaComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel;

        retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getSupportFragmentManager().findFragmentByTag(tag);
        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case MENU:
                    viewModel = new NewDncaViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case FORM_DETAILS:
                    viewModel = new FormDetailsViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case GEN_INFO:
                    viewModel = new GenInfoViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case SHELTER_INFO:
                    viewModel = new ShelterInfoViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case FOOD_SECURITY:
                    viewModel = new FoodSecurityViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case LIVELIHOODS:
                    viewModel = new LivelihoodsViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case HEALTH:
                    viewModel = new HealthViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case WASH:
                    viewModel = new WashViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case EVACUATION:
                    viewModel = new EvacuationListViewModel(Injection.provideDncaRepository(getApplicationContext()));
                    break;

                case EVACUATION_ITEM:
                    viewModel = new EvacuationItemViewModel(Injection.provideDncaRepository(getApplicationContext()), mEvacuationListViewModel, -1);
                    break;

                case CASE_STORIES:
                    viewModel = new CaseStoriesViewModel(Injection.provideDncaRepository(getApplicationContext()), this);
                    break;
            }

            viewModel.setNewDncaNavigator(this);

            if (retainedViewModel != null) {
                // If container already exists, just inject viewModel into container
                retainedViewModel.setViewModel(viewModel);

            } else {

                // Bind viewModel to activity's lifecycle using fragment manager
                ActivityUtils.addFragmentToActivity(
                        getSupportFragmentManager(),
                        ViewModelHolder.createContainer(viewModel),
                        tag);
            }
        }

        return viewModel;
    }
}
