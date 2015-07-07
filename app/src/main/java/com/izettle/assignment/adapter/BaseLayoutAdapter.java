package com.izettle.assignment.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.izettle.assignment.R;
import com.izettle.assignment.model.LayoutItemModel;

import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * This is the {@link RecyclerView.Adapter} and is used for the common initializations and manipulations of the layout
 *
 * Created by dimitris.lachanas on 07/07/15.
 */
public class BaseLayoutAdapter extends RecyclerView.Adapter<BaseLayoutAdapter.ListItemViewHolder> {

    protected final List<LayoutItemModel> mLayoutModels;
    protected int mLastPosition = -1;

    public BaseLayoutAdapter(List layoutModels) {
        mLayoutModels = layoutModels;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int i) {
        LayoutItemModel model = mLayoutModels.get(i);
        viewHolder.text.setText(model.getText());
        String dateStr = DateUtils.formatDateTime(viewHolder.text.getContext(), model.getDateTime().getTime(), DateUtils.FORMAT_ABBREV_TIME);
        viewHolder.date.setText(dateStr);
        setAnimation(viewHolder.container, i);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mLayoutModels != null) {
            return mLayoutModels.size();
        }
        return count;
    }


    /**
     * The {@link RecyclerView.ViewHolder} used for our layouts
     */
    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_text) TextView text;
        @Bind(R.id.txt_date) TextView date;
        @Bind(R.id.txt_expanded) TextView expanded;
        @Bind(R.id.container) LinearLayout container;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    /**
     * Animate the first occurrence of the view
     *
     * @param viewToAnimate
     * @param position
     */
    protected void setAnimation(View viewToAnimate, int position) {
        if (position > mLastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            mLastPosition = position;
        }
    }
}
