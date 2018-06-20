package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelDate;

public class DialogItemViewModelDate extends DialogItemViewModel {

    public final ObservableField<SimpleDate> value1 = new ObservableField<>(new SimpleDate());

    public DialogItemViewModelDate(DialogItemModelDate model) {
        text.set(model.getText());
        value1.set(model.getValue1());
    }

    /**
     * Sets the date received
     * @param year
     * @param month
     * @param day
     */
    public void onDateReceivedSet(int year, int month, int day) {
        value1.set(new SimpleDate(year, month, day));
    }
}
