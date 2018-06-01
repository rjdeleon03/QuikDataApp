package com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial;

import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.Dialog.PsychosocialDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.Dialog.PsychosocialDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PsychosocialFragment extends BaseEnumFragment {

    private PsychosocialFragmentAdapter mPsychosocialAdapter;

    public static PsychosocialFragment newInstance() {
        return new PsychosocialFragment();
    }

    public PsychosocialFragment() {
        // Required empty public constructor
    }

    /**
     * Show psychosocial data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        PsychosocialDialogViewModel dialogViewModel = new PsychosocialDialogViewModel(
                getContext(),
                (PsychosocialRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = PsychosocialDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        PsychosocialDialogViewModel dialogViewModel = new PsychosocialDialogViewModel(
                getContext(),
                (PsychosocialRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = PsychosocialDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mPsychosocialAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mPsychosocialAdapter = new PsychosocialFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (PsychosocialViewModel) mViewModel);
        mRowRecycler.setAdapter(mPsychosocialAdapter);
    }
}