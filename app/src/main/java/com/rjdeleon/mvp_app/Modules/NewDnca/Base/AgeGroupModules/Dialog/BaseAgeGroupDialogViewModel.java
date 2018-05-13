package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;

public abstract class BaseAgeGroupDialogViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected Context mContext;

    /**
     * Constructor
     * @param context
     */
    public BaseAgeGroupDialogViewModel(Context context) {
        mContext = context;
    }

    /**
     * Sets the base age group navigator
     * @param baseAgeGroupNavigator
     */
    public void setBaseAgeGroupNavigator(BaseAgeGroupNavigator baseAgeGroupNavigator) {
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
    }

    /**
     * Handles navigation when Cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        if (mBaseAgeGroupNavigator != null) {
            mBaseAgeGroupNavigator.onDialogCloseButtonPressed();
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        mBaseAgeGroupNavigator.onDialogOkButtonPressed();
    }
}
