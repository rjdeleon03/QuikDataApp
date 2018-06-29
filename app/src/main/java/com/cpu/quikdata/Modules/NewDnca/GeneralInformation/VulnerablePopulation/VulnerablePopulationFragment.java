package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog.VulnerablePopulationDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_VULNERABLE;

/**
 * A simple {@link Fragment} subclass.
 */
public class VulnerablePopulationFragment extends BaseEnumFragment {

    private VulnerablePopulationFragmentAdapter mVulnerablePopulationAdapter;

    public static VulnerablePopulationFragment newInstance() {
        return new VulnerablePopulationFragment();
    }

    public VulnerablePopulationFragment() {
        setFragmentTag(GEN_INFO_VULNERABLE.toString());
    }

    /**
     * Show Population Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        VulnerablePopulationDialogViewModel dialogViewModel = new VulnerablePopulationDialogViewModel(
                (VulnerablePopulationRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        VulnerablePopulationDialogViewModel dialogViewModel = new VulnerablePopulationDialogViewModel(
                (VulnerablePopulationRepositoryManager) mViewModel,
                rowIndex,
                false);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mVulnerablePopulationAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mVulnerablePopulationAdapter = new VulnerablePopulationFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (VulnerablePopulationViewModel) mViewModel);
        mRowRecycler.setAdapter(mVulnerablePopulationAdapter);
    }
}
