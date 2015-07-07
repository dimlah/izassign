package com.izettle.assignment.adapter;

import android.view.View;

import java.util.List;

/**
 * That adapter is used for the Linear and GridLayout view as they both have the same behaviour and have to hide the
 * {@link com.izettle.assignment.adapter.BaseLayoutAdapter.ListItemViewHolder#expanded} attribute
 *
 * Created by dimitris.lachanas on 07/07/15.
 */
public class LinearGridLayoutAdapter extends BaseLayoutAdapter {


    public LinearGridLayoutAdapter(List layoutModels) {
        super(layoutModels);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.expanded.setVisibility(View.GONE);
    }

}
