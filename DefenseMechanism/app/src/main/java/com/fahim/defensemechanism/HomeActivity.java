package com.fahim.defensemechanism;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends Activity {

    private Button movesButton, legendsButton, creditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setting up buttons
        movesButton = (Button) findViewById(R.id.movesButton);
        legendsButton = (Button) findViewById(R.id.legendsButton);
        creditButton = (Button) findViewById(R.id.creditButton);

        // listeners
        setButtonListeners();
    }

    /*
    * Setting button listeners
    * */
    private void setButtonListeners(){
        movesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Manager.onLegendPage = false;
                Intent intent = new Intent(HomeActivity.this, MoveActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "Popular Moves", Toast.LENGTH_SHORT).show();
            }
        });
        movesButton.setOnTouchListener(new ButtonEffect());

        legendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Manager.onLegendPage = true;
                Intent intent = new Intent(HomeActivity.this,LegendActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this,"Legends",Toast.LENGTH_SHORT).show();
            }
        });
        legendsButton.setOnTouchListener(new ButtonEffect());

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CreditActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "Developer Credits", Toast.LENGTH_SHORT).show();
            }
        });
        creditButton.setOnTouchListener(new ButtonEffect());


    }

    /*
    * OVERRIDING BACK BUTTON
    * */
    @Override
    public void onBackPressed() {
        final Dialog quit_dialog = new Dialog(HomeActivity.this);
        quit_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        quit_dialog.setContentView(R.layout.quit_dialog_layout);
        quit_dialog.setCancelable(false);


        // setting up buttons of the dialog
        Button quitYesButton = (Button) quit_dialog.findViewById(R.id.quitYesButton);
        quitYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit_dialog.dismiss();
                finish();
            }
        });
        quitYesButton.setOnTouchListener(new ButtonEffect());

        Button quitNoButton = (Button) quit_dialog.findViewById(R.id.quitNoButton);
        quitNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit_dialog.dismiss();
            }
        });
        quitNoButton.setOnTouchListener(new ButtonEffect());

        quit_dialog.show();
    }

    // not used code -------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
