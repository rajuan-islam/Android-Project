package com.fahim.defensemechanism;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment {

    private ListView list;
    private View lastClicked=null;

    public interface ListFragmentInterface{
        public void changeByPosition(int position);
    }
    public ListFragmentInterface hostActivityInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View minimalView = inflater.inflate(R.layout.list_fragment_layout,container,false);

        // setting up
        list = (ListView) minimalView.findViewById(R.id.minimalList);
        MinimalAdapter adapter;
        if( Manager.onLegendPage ) adapter = new MinimalAdapter(getActivity(),Manager.sub_legends);
        else adapter = new MinimalAdapter(getActivity(),Manager.sub_moves);
        list.setAdapter(adapter);

        // listeners
        setUpListeners();

        return minimalView;
    }

    /*
    * SETTING UP WHAT HAPPENS AT SELECTION
    * */
    private void setUpListeners(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // setting background color
                view.setBackgroundColor(Manager.redMinimal);
                // setting text color
                TextView text = (TextView) view.findViewById(R.id.name);
                text.setTextColor(Manager.whiteMinimal);
                if(Manager.onLegendPage){
                    text = (TextView) view.findViewById(R.id.origin);
                    text.setTextColor(Manager.whiteMinimal);
                }

                // resetting last clicked colors
                try {
                    if(lastClicked!=view){
                        lastClicked.setBackgroundColor(Color.TRANSPARENT);
                        text = (TextView) lastClicked.findViewById(R.id.name);
                        text.setTextColor(Manager.textGreyMinimal);
                        if(Manager.onLegendPage){
                            text = (TextView) lastClicked.findViewById(R.id.origin);
                            text.setTextColor(Manager.textGreyMinimal);
                        }
                    }
                } catch (Exception e){}

                // keeping track
                lastClicked = view;

                // setting detail tab resource
                hostActivityInterface.changeByPosition(position);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        hostActivityInterface = (ListFragmentInterface) activity;
    }
}
