package com.android.oop.shellsort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView results;
    int[] arrayNums;
    Random randomNumber = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results = (TextView) findViewById(R.id.textRes);
        int[] arrayNums = {5,99,35,4,17,56,25,2,8,49,88};
        ShellSort(arrayNums);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void ShellSort(int[] array)
    {
        //find the number of steps required
        int h = 1;
        while(h <= array.length/3)
        {
            h = h*3 + 1;
        }
        results.setText(Integer.toString(h));

        while(h>0)
        {
            for(int j = 0; j<array.length;j++)
            {
                for(int k = j; k<array.length;k+=h)
                {
                    if(k+h < array.length && array[k]>array[k+h])
                    {
                        int temp = array[k];
                        array[k] = array[k+h];
                        array[k+h] = temp;

                    }
                }

            }
            h=(h-1)/3;
        }

        results.setText(Arrays.toString(array));

    }
}
