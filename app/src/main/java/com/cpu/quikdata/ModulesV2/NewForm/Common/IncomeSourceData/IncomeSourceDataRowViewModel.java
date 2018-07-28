package com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceDataRow;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.IncomeSourceDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;

public class IncomeSourceDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, IncomeSourceDataRow, GenericEnumDataRow.IncomeSourceType, ITemplateEnumDataManager<IncomeSourceDataRow>> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public IncomeSourceDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }
}