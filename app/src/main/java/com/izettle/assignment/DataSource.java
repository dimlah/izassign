package com.izettle.assignment;

import com.izettle.assignment.model.LayoutItemModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Dummy class for returning back some {@link LayoutItemModel}s
 *
 * Created by dimitris.lachanas on 07/07/15.
 */
public class DataSource {
    private final static int sCount = 30;

    /**
     * Returns the dummy {@link LayoutItemModel}s for displaying in the {@link android.support.v7.widget.RecyclerView}
     *
     * @return
     */
    public static List<LayoutItemModel> getItems() {
        List models = new ArrayList();


        for(int i = 0; i < sCount; i++) {
            LayoutItemModel layoutItemModel = new LayoutItemModel();
            layoutItemModel.setDateTime(new Date());
            layoutItemModel.setText("Text for item " + i);
            layoutItemModel.setExpandedText("Expanded text for item " + i);
            models.add(layoutItemModel);
        }

        return models;
    }
}
