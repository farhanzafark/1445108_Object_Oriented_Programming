package com.android.oop.contactfinder;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //int currentId = 0;
    static int MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    TextView textName, textNumber;
    Cursor cur;
    ContentResolver cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*=========================== REQUEST PERMISSIONS
                                     =============================================================*/
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        /*========================================================================================*/

        cr = getContentResolver();
        cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        textName = (TextView) findViewById(R.id.textViewName);
        textNumber = (TextView) findViewById(R.id.textviewNumber);

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

    public void onClickNextButton(View view)
    {
        StringBuffer sb = new StringBuffer();

        String phone = null;
        String name = null;

        if(cur.moveToNext())
        {
            String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER )))> 0)
            {
                Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[]{id},null);
                while(pCur.moveToNext())
                {
                    phone = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    sb.append("\n" + phone);
                }
                pCur.close();
            }
        }
        textName.setText(name);
        textNumber.setText(phone);

    }

    public void onClickPreviousButton(View view)
    {
        StringBuffer sb = new StringBuffer();
        //ContentResolver cr = getContentResolver();
        //cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        String phone = null;
        String name = null;

        if(cur.moveToPrevious())
        {
            String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER )))> 0)
            {
                Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[]{id},null);
                while(pCur.moveToNext())
                {
                    phone = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    sb.append("\n" + phone);
                }
                pCur.close();
            }
        }
        textName.setText(name);
        textNumber.setText(phone);

    }

    /*-================== HANDLE PERMISSION REQUEST ==============================================*/
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
            return;

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
