package com.android.oop.sortingalgorithms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] arrayNums;
    Random randomNumber = new Random();
    TextView details, unsorted, sorted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details = (TextView) findViewById(R.id.textDetails);
        unsorted = (TextView) findViewById(R.id.textUnsorted);
        sorted = (TextView) findViewById(R.id.textSorted);

        details.setMovementMethod(new ScrollingMovementMethod());

        arrayNums = new int[20];
        for(int i = 0;i<arrayNums.length;i++)
        {
            arrayNums[i] = randomNumber.nextInt(100);
        }

        unsorted.setText(Arrays.toString(arrayNums));



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

    public void BubbleSort(View view)
    {
        BubbleSort(arrayNums);
    }

    public void SelectionSort(View view)
    {
        SelectionSort(arrayNums);
    }

    public void InsertionSort(View view)
    {
        InsertionSort(arrayNums);
    }

    public void Clear(View view)
    {
        sorted.setText("");
        details.setText("");

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
                    arrayNums[j+1] = temp;
                    details.append("swapping"+array[i]+"and"+array[j]+"\n");
                }
            }
        }
        sorted.setText(Arrays.toString(array));
    }

    private void SelectionSort(int[] array)
    {
        //sorted.setText("");
        details.setText("Selection Sort\n");
        for(int i = 0;i<array.length;i++)
        {
            for(int j = i+1;j<array.length;j++)
            {
                if(array[j]<array[i])
                {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    details.append("swapping"+array[i]+"and"+array[j]+"\n");

                }
            }
        }
        sorted.setText(Arrays.toString(array));
    }

    private void InsertionSort(int[] array) {
        //sorted.setText("");
        for (int i = 1; i < array.length; i++)
        {
            for(int j = i; j>0;j--)
            {
                if(array[j]<array[j-1])
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    details.append("swapping"+array[j]+"and"+array[j-1]+"\n");
                }
            }
        }
        sorted.setText(Arrays.toString(array));

    }
}
