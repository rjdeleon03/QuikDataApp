package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class DNCAFormRepository implements DNCAFormDataSource {

    private static DNCAFormRepository INSTANCE = null;
    private final DNCAFormDataSource mDncaFormLocalDataSource;
    private DNCAForm mForm;

    /**
     * Private constructor
     */
    private DNCAFormRepository(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        mDncaFormLocalDataSource = checkNotNull(dncaFormLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary
     * @param dncaFormLocalDataSource
     * @return
     */
    public static DNCAFormRepository getInstance(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DNCAFormRepository(dncaFormLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Destroys instance to create it the next time getInstance() is called
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Creates a new and empty DNCA form
     * @param callback
     */
    @Override
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {
        checkNotNull(callback);

        if (mForm == null) {
            mForm = new DNCAForm();
        }
        callback.onDncaFormLoaded(mForm);
    }

    /**
     * Saves form info to new DNCA form
     * @param formInfo
     */
    @Override
    public void saveFormInfo(FormInfo formInfo) {
        mForm.setFormInfo(formInfo);
    }
}