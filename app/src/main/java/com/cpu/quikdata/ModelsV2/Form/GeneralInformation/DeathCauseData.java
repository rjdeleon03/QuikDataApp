package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.ModelsV2.Base.IEnumDataRowHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DeathCauseData extends RealmObject implements IEnumDataRowHolder<DeathCauseDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<DeathCauseDataRow> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public RealmList<DeathCauseDataRow> getRows() {
        return rows;
    }

    @Override
    public void setRows(RealmList<DeathCauseDataRow> rows) {
        this.rows = rows;
    }
}
