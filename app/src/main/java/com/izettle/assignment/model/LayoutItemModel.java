package com.izettle.assignment.model;

import java.util.Date;

/**
 * Created by dimitris.lachanas on 07/07/15.
 */

public class LayoutItemModel {
    private static int mNextId = 0;
    Date mDateTime;
    String mText;
    int mId = ++mNextId;
    private String mExpandedText;

    public static int getNextId() {
        return mNextId;
    }

    public static void setNextId(int nextId) {
        LayoutItemModel.mNextId = nextId;
    }

    public Date getDateTime() {
        return mDateTime;
    }

    public void setDateTime(Date dateTime) {
        this.mDateTime = dateTime;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getExpandedText() {
        return mExpandedText;
    }

    public void setExpandedText(String expandedText) {
        this.mExpandedText = expandedText;
    }
}
