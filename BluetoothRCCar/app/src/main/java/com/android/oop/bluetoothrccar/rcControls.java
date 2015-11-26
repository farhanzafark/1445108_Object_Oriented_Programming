package com.android.oop.bluetoothrccar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class rcControls extends AppCompatActivity {

    ImageButton forward, left, right, back, light, buzzer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_controls);

        /*------------------------- Set Buttons ----------------------------*/
        forward = (ImageButton) findViewById(R.id.btnForward);
        left = (ImageButton) findViewById(R.id.btnLeft);
        right = (ImageButton) findViewById(R.id.btnRight);
        back = (ImageButton) findViewById(R.id.btnBack);
        light = (ImageButton) findViewById(R.id.btnLights);
        buzzer = (ImageButton) findViewById(R.id.btnBuzzer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rc_controls, menu);
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

    public void onClickBtnForward(View view)
    {

    }

    public void onClickBtnBack(View view)
    {

    }

    public void onClickBtnLeft(View view)
    {

    }

    public void onClickBtnRight(View view)
    {

    }

    public void onClickBtnLights(View view)
    {

    }

    public void onClickBtnBuzzer(View view)
    {

    }

}
