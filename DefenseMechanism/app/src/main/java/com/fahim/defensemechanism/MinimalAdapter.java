package com.fahim.defensemechanism;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MinimalAdapter extends ArrayAdapter<Container> {

    // constructor
    public MinimalAdapter(Context context, Container[] containers) {
        super(context, R.layout.minimal_adapter_layout, containers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // housekeeping
        LayoutInflater minimalInflater = LayoutInflater.from(getContext());
        View minimalView = minimalInflater.inflate(R.layout.minimal_adapter_layout,parent,false);

        // REFERENCES
        TextView name = (TextView) minimalView.findViewById(R.id.name);
        TextView origin = (TextView) minimalView.findViewById(R.id.origin);
        ImageView image = (ImageView) minimalView.findViewById(R.id.image);

        // CONNECTING
        Container item = getItem(position);
        //name.setText(R.string.demo_name);
        //image.setImageResource(R.drawable.fahim_one);
        name.setText(item.nameId);
        image.setImageResource(item.smallPicId);
        if(item.hasOrigin) origin.setText(item.originId);
        else origin.setVisibility(View.INVISIBLE);

        return minimalView;
    }
}
