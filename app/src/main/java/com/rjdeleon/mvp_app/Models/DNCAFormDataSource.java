package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

import java.util.List;

/**
 * Main entry point for accessing DNCA Form data
 */
public interface DNCAFormDataSource {

    interface LoadDncaFormsCallback {
        void onDncaFormsLoaded(List<DNCAListItem> forms);

        void onDataNotAvailable();
    }

    interface GetDncaFormCallback {
        void onDncaFormLoaded(DNCAForm form);

        void onDataNotAvailable();
    }

    interface SubmitDncaFormCallback {
        void onDncaFormSubmitted();
    }

    void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback);

    void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback);

    void submitDncaForm(@NonNull SubmitDncaFormCallback callback);

    void saveFormInfo(FormInfo formInfo);

    void saveGenInfo(GenInfo genInfo);
}
