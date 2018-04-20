package com.fahim.defensemechanism;

import android.view.MotionEvent;
import android.view.View;

public class ButtonEffect implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if( event.getAction() == MotionEvent.ACTION_DOWN ) {
            v.setBackgroundColor( Manager.redDarkMinimal );
        } else if( event.getAction() == MotionEvent.ACTION_UP ) {
            v.setBackgroundColor( Manager.redMinimal );
        }
        return false;
    }
}
