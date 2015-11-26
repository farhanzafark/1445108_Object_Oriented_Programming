package com.android.oop.binarysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView details;
    int[] arrayNums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details = (TextView) findViewById(R.id.details);
        arrayNums = new int[100];

        for(int i = 0;i<arrayNums.length;i++)
        {
            arrayNums[i] = i;
        }
        binarySearch(5,0,arrayNums.length);

    }

    private void binarySearch(int searchVal, int lowerBound, int upperBound)
    {
        int currentIndex = (lowerBound + upperBound)/2;
        if(arrayNums[currentIndex]==searchVal)
        {
            details.setText("Found!");

        }
        else
        {
            if(arrayNums[currentIndex]>searchVal)
            {
                binarySearch(searchVal,lowerBound,currentIndex-1);
            }else if(arrayNums[currentIndex]<searchVal)
            {
                binarySearch(searchVal,currentIndex,upperBound);

            }
        }
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
}
