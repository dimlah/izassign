package com.izettle.assignment.adapter;

import android.view.View;

import com.izettle.assignment.model.LayoutItemModel;

import java.util.List;

/**
 * That adapter is for displaying the Staggered layout which needs in some cases the
 * {@link com.izettle.assignment.adapter.BaseLayoutAdapter.ListItemViewHolder#expanded} attribute
 * Created by dimitris.lachanas on 07/07/15.
 */
public class StaggeredGridLayoutAdapter extends BaseLayoutAdapter {

    public StaggeredGridLayoutAdapter(List layoutModels) {
        super(layoutModels);
    }


    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        if(i % 2 == 0) {
            LayoutItemModel model = mLayoutModels.get(i);
            viewHolder.expanded.setText(model.getExpandedText());
            viewHolder.expanded.setVisibility(View.VISIBLE);
        } else {
            viewHolder.expanded.setVisibility(View.GONE);
        }
    }
}
