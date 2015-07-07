package com.izettle.assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.izettle.assignment.adapter.BaseLayoutAdapter;
import com.izettle.assignment.adapter.LinearGridLayoutAdapter;
import com.izettle.assignment.adapter.StaggeredGridLayoutAdapter;
import com.izettle.assignment.event.LayoutChangedEvent;

import de.greenrobot.event.EventBus;


/**
 * A fragment containing the {@link RecyclerView}
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private BaseLayoutAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private final static int sSpanCount = 3;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        updateLayoutManagerAndAdapter(LayoutChangedEvent.LINEAR);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Update the {@link #mLayoutManager} and the {@link #mAdapter} according to the user's selection
     *
     * @param layoutType The user's selection
     */
    private void updateLayoutManagerAndAdapter(int layoutType) {
        switch (layoutType) {
            case LayoutChangedEvent.LINEAR:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mAdapter = new LinearGridLayoutAdapter(DataSource.getItems());
                break;
            case LayoutChangedEvent.GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), sSpanCount);
                mAdapter = new LinearGridLayoutAdapter(DataSource.getItems());
                break;
            case LayoutChangedEvent.STAGGERED_GRID:
                mLayoutManager = new StaggeredGridLayoutManager(sSpanCount, StaggeredGridLayoutManager.VERTICAL);
                mAdapter = new StaggeredGridLayoutAdapter(DataSource.getItems());
                break;
            default:
                break;
        }
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * This method will be called when {@link EventBus} will post a {@link LayoutChangedEvent}. Then the fragment will be aware of this
     * change and will adjust its layout accordingly
     *
     * @param layoutChangedEvent
     */
    public void onEvent(LayoutChangedEvent layoutChangedEvent) {
        updateLayoutManagerAndAdapter(layoutChangedEvent.getLayoutType());
    }
}
