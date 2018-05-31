package com.rjdeleon.mvp_app.Modules.NewDnca.Health;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class HealthEnumBaseViewModel extends BaseEnumViewModel {

    protected HealthRepositoryManager mHealthRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param enumClass
     */
    protected HealthEnumBaseViewModel(Context context,
                                      HealthRepositoryManager healthRepositoryManager,
                                      @Nullable Class<? extends Enum> enumClass) {
        super(context, enumClass);
        mHealthRepositoryManager = healthRepositoryManager;
    }
}
