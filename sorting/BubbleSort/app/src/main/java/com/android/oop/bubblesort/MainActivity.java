package com.android.oop.bubblesort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView details, unsorted, sorted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details = (TextView) findViewById(R.id.details);
        unsorted = (TextView) findViewById(R.id.unsorted);
        sorted = (TextView) findViewById(R.id.sorted);

        int[] arrayNums = {10,0,33,2,50,99,17,21,37,5,77};
        BubbleSort(arrayNums);

    }

    //bubble sort selection sort insertion sort
    private void BubbleSort(int[] array)
    {
        //sorted.setText("");
        details.setText("Bubble Sort\n");
        for(int i = array.length-1; i>1;i--)
        {
            for(int j = 0; j<i;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    details.append("swapping"+array[i]+"and"+array[j]+"\n");
                }
            }
        }
        sorted.setText(Arrays.toString(array));
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
