package com.izettle.assignment.model;

import java.util.Date;

/**
 * The dummy model for the assignment
 *
 * Created by dimitris.lachanas on 07/07/15.
 */
public class LayoutItemModel {

    private Date mDateTime;
    private String mText;
    private String mExpandedText;

    public LayoutItemModel(Date dateTime, String text, String expandedText) {
        this(dateTime, text);
        mExpandedText = expandedText;
    }
    public LayoutItemModel(Date dateTime, String text) {
        mDateTime = dateTime;
        mText = text;
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

    public String getExpandedText() {
        return mExpandedText;
    }

    public void setExpandedText(String expandedText) {
        this.mExpandedText = expandedText;
    }
}
