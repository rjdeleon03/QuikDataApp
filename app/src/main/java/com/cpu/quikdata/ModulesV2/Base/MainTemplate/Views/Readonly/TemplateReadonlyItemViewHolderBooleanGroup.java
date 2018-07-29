package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanGroup;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyBooleanGroupBinding;

public class TemplateReadonlyItemViewHolderBooleanGroup extends TemplateItemViewHolder<TemplateQuestionItemViewModelBooleanGroup> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderBooleanGroup(LayoutInflater inflater, TemplateQuestionItemViewModelBooleanGroup viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlyBooleanGroupBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_boolean_group, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}