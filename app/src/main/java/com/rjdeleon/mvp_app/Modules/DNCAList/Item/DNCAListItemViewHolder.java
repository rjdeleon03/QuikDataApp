package com.rjdeleon.mvp_app.Modules.DNCAList.Item;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DncaListItemBinding;

public class DNCAListItemViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewHead;
    private TextView textViewDesc;

    public DNCAListItemViewHolder(View view) {
        super(view);
        this.textViewHead = itemView.findViewById(R.id.dnca_item_head);
        this.textViewDesc = itemView.findViewById(R.id.dnca_item_desc);
    }

    public void setHead(String head) {
        textViewHead.setText(head);
    }

    public void setDesc(String desc) {
        textViewDesc.setText(desc);
    }

}
