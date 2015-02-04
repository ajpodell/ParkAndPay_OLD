package com.firstapp.aaron.firstapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class SpotActivity extends ActionBarActivity {
    //vars


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);

        Intent intent = getIntent();
        Integer spot_num = intent.getIntExtra("spot_num", -1);
        Log.d("debug", spot_num.toString());

        String spot_text = "Sorry, could not find your spot. Please try again.";
        if(spot_num != -1) {
            spot_text = spot_num.toString();
        }

        // ADD SOME TEXT THATS LIKE, THIS SPOT IS CURRENTLY EXPIRED OR
        //      THIS SPOT WILL EXPIRE AT "time"

        TextView textview = (TextView) findViewById(R.id.spot_num_text);
        textview.setText(spot_text);
        textview.setTextSize(40);
//      TextView textView = new TextView(this);
    }


    // ---- PAY BUTTON LISTENER ------//
    public void onClickPay(View view){
        // add an hour to the time it expires.

        //use single button "pay" for now, then just say "is / is not paid"

        // use DatePickerDialog to pick what time to pay through
        Log.d("test", "pay button clicked");


        final Calendar c = Calendar.getInstance();
        int curHour = c.get(Calendar.HOUR_OF_DAY);
        Integer curMinute = c.get(Calendar.MINUTE);
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // this is an async callback
                        Log.d("test", "should be second: " + Integer.toString(hourOfDay));
                    }
                }, curHour, curMinute, false);
        tpd.show();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spot, menu);
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
