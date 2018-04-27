package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Contracts.DNCAListItemContract;

public class DNCAListItemPresenter implements DNCAListItemContract.Presenter{

    private DNCAListItemContract.View mView;
    private int id;

    public DNCAListItemPresenter(DNCAListItemContract.View mView, int id) {
        this.mView = mView;
        this.id = id;
    }

    @Override
    public void downloadDnca(View view) {
        mView.onDownloadDnca(AppConstants.URL + AppConstants.ROUTE_DNCA + "/" + id + "/download");
    }
}
