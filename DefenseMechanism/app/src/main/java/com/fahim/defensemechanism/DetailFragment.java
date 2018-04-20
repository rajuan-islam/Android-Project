package com.fahim.defensemechanism;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    ImageView bigImage;
    TextView bigName, description;

    public void setByPosition(int position){
        Container item;
        if(Manager.onLegendPage) item = Manager.legends[position];
        else item = Manager.moves[position];

        bigImage.setImageResource(item.bigPicId);
        bigName.setText(item.nameId);
        description.setText(item.descriptionId); description.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View detailFragmentView = inflater.inflate(R.layout.fragment_detail, container, false);

        // setting up the references
        bigImage = (ImageView) detailFragmentView.findViewById(R.id.bigImage);
        bigName = (TextView) detailFragmentView.findViewById(R.id.bigName);
        description = (TextView) detailFragmentView.findViewById(R.id.description);

        // initial situation
        // visibility
        description.setVisibility(View.INVISIBLE);
        // default resource
        bigImage.setImageResource(R.drawable.default_description_pic);
        bigName.setText(R.string.selection_prompt_text);

        return detailFragmentView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}
