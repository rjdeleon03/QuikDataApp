package com.rjdeleon.mvp_app.Contracts;

import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public interface NewFormContract {
    interface View {
        void onSwitchToFragment(BaseFragment fragment);
    }

    interface Presenter {

    }
}
