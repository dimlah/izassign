package com.izettle.assignment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.izettle.assignment.event.LayoutChangedEvent;

import de.greenrobot.event.EventBus;

/**
 * That's the main (and only in this case) {@link ActionBarActivity} of the project
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int layoutType = -1;

        // here we distinguish the actions chosen by the user regarding the layout switch
        // we could handle the menu in the fragment but in order to show the use of EventBus it was a choice to do it in the activity
        switch (id) {
            case R.id.action_linear:
                layoutType = LayoutChangedEvent.LINEAR;
                break;
            case R.id.action_grid:
                layoutType = LayoutChangedEvent.GRID;
                break;
            case R.id.action_staggered_grid:
                layoutType = LayoutChangedEvent.STAGGERED_GRID;
                break;
            default:
                break;
        }

        if(layoutType != -1) {
            EventBus.getDefault().post(new LayoutChangedEvent(layoutType));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
