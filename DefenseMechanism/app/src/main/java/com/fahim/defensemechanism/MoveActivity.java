package com.fahim.defensemechanism;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;


public class MoveActivity extends Activity implements ListFragment.ListFragmentInterface {

    View selectedTabView;
    TextView tabText;
    DetailFragment detailFragment;
    TabHost tabHost;

    @Override
    public void changeByPosition(int position) {
        // changing resources
        detailFragment.setByPosition(position);
        // activating second tab
        tabHost.setCurrentTab(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        /*
        * TABS SETUP
        * */
        // setting up tabhost
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.setBackgroundColor(Manager.greyMinimal);

        // setting up tab 1
        TabSpec spec = tabHost.newTabSpec("Tag 1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Moves");
        tabHost.addTab(spec);

        // setting up tab 2
        spec = tabHost.newTabSpec("Tag 2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Details");
        tabHost.addTab(spec);

        // setting up initial colors
        final TabWidget tabWidget = tabHost.getTabWidget();
        for(int i=0; i<tabWidget.getTabCount(); i++){
            selectedTabView = tabWidget.getChildTabViewAt(i);
            selectedTabView.setBackgroundColor(Manager.redDarkMinimal);

            tabText = (TextView) selectedTabView.findViewById(android.R.id.title);
            tabText.setTextColor(Manager.textGreyMinimal);
        }

        // setting up initial selection color
        selectedTabView = tabHost.getCurrentTabView();
        selectedTabView.setBackgroundColor(Manager.redMinimal);
        tabText = (TextView) selectedTabView.findViewById(android.R.id.title);
        tabText.setTextColor(Manager.whiteMinimal);


        // setting up listener for selection color change on tab
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                View currentTabView = tabHost.getCurrentTabView();
                currentTabView.setBackgroundColor(Manager.redMinimal);
                tabText = (TextView) currentTabView.findViewById(android.R.id.title);
                tabText.setTextColor(Manager.whiteMinimal);

                // resetting previous selection color
                if(currentTabView!=selectedTabView){
                    selectedTabView.setBackgroundColor(Manager.redDarkMinimal);
                    tabText = (TextView) selectedTabView.findViewById(android.R.id.title);
                    tabText.setTextColor(Manager.textGreyMinimal);

                    // keeping record
                    selectedTabView=currentTabView;
                }
            }
        });

        /*
        * FRAGMENTS SETUP
        * */
        detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragmentMinimal);
    }
}
