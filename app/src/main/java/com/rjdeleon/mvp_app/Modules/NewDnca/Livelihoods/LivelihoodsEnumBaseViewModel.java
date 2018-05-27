package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

public abstract class LivelihoodsEnumBaseViewModel extends BaseEnumViewModel {

    protected LivelihoodsRepositoryManager mLivelihoodsRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     * @param enumClass
     */
    public LivelihoodsEnumBaseViewModel(Context context,
                                        LivelihoodsRepositoryManager livelihoodsRepositoryManager,
                                        Class<? extends Enum> enumClass) {

        super(context, enumClass);
        mLivelihoodsRepositoryManager = livelihoodsRepositoryManager;
    }
}