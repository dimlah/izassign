package com.izettle.assignment.event;

/**
 *
 * This event is used in order for the fragment to be informed if it should change the layout
 *
 * Created by dimitris.lachanas on 07/07/15.
 */
public class LayoutChangedEvent {

    public final static int LINEAR = 1111;
    public final static int GRID = 2222;
    public final static int STAGGERED_GRID = 3333;

    private final int mLayoutType;

    public LayoutChangedEvent(int layoutType) {
        mLayoutType = layoutType;
    }

    public int getLayoutType() {
        return mLayoutType;
    }
}
