package com.android.oop.bluetoothrccar;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public Button paired, off, scan;
    ArrayAdapter mAdapter;


    private AbsListView mListView;

    ImageButton forward, left, right, back, frontleft,frontright,backleft,backright, light, buzzer;
    SeekBar seekBarSpeed;

    ListView listDevicesFound;
    Button btnScanDevice;
    TextView stateBluetooth;
    BluetoothAdapter bluetoothAdapter;
    TextView textStatus;

    ArrayAdapter<BluetoothDevice> btArrayAdapter;

    private UUID myUUID;
    private final String UUID_STRING_WELL_KNOWN_SPP = "00001101-0000-1000-8000-00805F9B34FB";
    ThreadConnectBTdevice myThreadConnectBTdevice;
    ThreadConnected myThreadConnected;

    private final BroadcastReceiver bReciever = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                DeviceItem newDevice = new DeviceItem(device.getName(), device.getAddress(), "false");
                mAdapter.add(newDevice);
            }
        }
    };

    private final BluetoothServerSocket mmServerSocket = null;

    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //paired = (Button) findViewById(R.id.btp);
        //off = (Button) findViewById((R.id.btnOff));
        //scan = (Button) findViewById(R.id.btnScan);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }*/
    /*--------------------------------------------------------------------------------------------*
                                SET CONTROL BUTTONS/
     */

        /*========================= Set SeekBar ==================================================*/
        seekBarSpeed =(SeekBar) findViewById(R.id.seekBarSpeed);
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                String seekPosition = Integer.toString(seekBar.getProgress());

                if(myThreadConnected!=null)
                {
                    myThreadConnected.write(seekPosition.getBytes());
                }

            }
        });

        /*------------------------- Set Buttons ----------------------------*/
        forward = (ImageButton) findViewById(R.id.btnForward);
        left = (ImageButton) findViewById(R.id.btnLeft);
        right = (ImageButton) findViewById(R.id.btnRight);
        back = (ImageButton) findViewById(R.id.btnBack);
        frontleft = (ImageButton) findViewById(R.id.btnFwdLeft);
        frontright = (ImageButton) findViewById(R.id.btnFwdRight);
        backleft = (ImageButton) findViewById(R.id.btnBackLeft);
        backright = (ImageButton) findViewById(R.id.btnBackRight);
        light = (ImageButton) findViewById(R.id.btnLights);
        buzzer = (ImageButton) findViewById(R.id.btnBuzzer);
    /*--------------------------------------------------------------------------------------------*/
        /*          TOUCH LISTENERS FOR ALL BUTTONS*/
        forward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "F";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "B";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "L";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "R";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        frontright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "I";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        frontleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "G";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        backright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "J";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });

        backleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == (MotionEvent.ACTION_DOWN))
                {
                    if(myThreadConnected!=null){
                        String command = "H";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }
                }
                else if(event.getAction() == (MotionEvent.ACTION_UP)){
                    if(myThreadConnected!=null){
                        String command = "S";
                        myThreadConnected.write(command.getBytes());
                        return true;
                    }

                }
                return false;
            }
        });


/*----------------------------------------------------------------------------------------*/

        btnScanDevice = (Button) findViewById(R.id.btnScan);

        stateBluetooth = (TextView) findViewById(R.id.btnOff);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        listDevicesFound = (ListView) findViewById(R.id.devicesfound);
        btArrayAdapter = new ArrayAdapter<BluetoothDevice>(MainActivity.this, android.R.layout.simple_list_item_1);
        listDevicesFound.setAdapter(btArrayAdapter);
        textStatus = (TextView) findViewById(R.id.textViewStatus);

        myUUID = UUID.fromString(UUID_STRING_WELL_KNOWN_SPP);

        CheckBlueToothState();

        btnScanDevice.setOnClickListener(btnScanDeviceOnClickListener);

        registerReceiver(ActionFoundReceiver,
                new IntentFilter(BluetoothDevice.ACTION_FOUND));

        listDevicesFound.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Object o = parent.getItemAtPosition(position);
                //String str = (String) o;
                //Toast.makeText(MainActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
                BluetoothDevice device = (BluetoothDevice) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Name: " + device.getName() + "\n"
                                + "Address: " + device.getAddress() + "\n"
                                + "BondState: " + device.getBondState() + "\n"
                                + "BluetoothClass: " + device.getBluetoothClass() + "\n"
                                + "Class: " + device.getClass(),
                        Toast.LENGTH_LONG).show();
                textStatus.setText("start ThreadConnectBt");
                myThreadConnectBTdevice = new ThreadConnectBTdevice(device);
                myThreadConnectBTdevice.start();
            }
        });


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

    public void Scan(View view) {

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unregisterReceiver(ActionFoundReceiver);

        if(myThreadConnectBTdevice != null)
        {
            myThreadConnectBTdevice.cancel();
        }
    }

    private void CheckBlueToothState() {
        if (bluetoothAdapter == null) {
            stateBluetooth.setText("Bluetooth NOT supported");
        } else {
            if (bluetoothAdapter.isEnabled()) {
                if (bluetoothAdapter.isDiscovering()) {
                    stateBluetooth.setText("Bluetooth is currently in device discovery process.");
                } else {
                    stateBluetooth.setText("Bluetooth is Enabled.");
                    btnScanDevice.setEnabled(true);
                }
            } else {
                stateBluetooth.setText("Bluetooth is NOT Enabled!");
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }

    private Button.OnClickListener btnScanDeviceOnClickListener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            btArrayAdapter.clear();
            bluetoothAdapter.startDiscovery();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == REQUEST_ENABLE_BT) {
            CheckBlueToothState();
        }
    }

    private final BroadcastReceiver ActionFoundReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                btArrayAdapter.add(device);
                btArrayAdapter.notifyDataSetChanged();
            }
        }
    };

    //Called in ThreadConnectBTdevice once connect successed
    //to start ThreadConnected
    private void startThreadConnected(BluetoothSocket socket) {

        myThreadConnected = new ThreadConnected(socket);
        myThreadConnected.start();
    }

    /*============================================================================================*/
    /*      Control Button Functions    */

   /* public void onClickBtnForward(View view)
    {
        if(myThreadConnected!=null){
            String command = "F";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnBack(View view)
    {
        if(myThreadConnected!=null){
            String command = "B";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnLeft(View view)
    {
        if(myThreadConnected!=null){
            String command = "L";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnRight(View view)
    {
        if(myThreadConnected!=null){
            String command = "R";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickFwdRight(View view)
    {
        if(myThreadConnected!=null){
            String command = "I";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickFwdLeft(View view)
    {
        if(myThreadConnected!=null){
            String command = "G";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnBackLeft(View view)
    {
        if(myThreadConnected!=null){
            String command = "H";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnBackRight(View view)
    {
        if(myThreadConnected!=null){
            String command = "J";
            myThreadConnected.write(command.getBytes());
        }

    }*/

    public void onClickBtnLights(View view)
    {
        if(myThreadConnected!=null){
            String command = "W";
            myThreadConnected.write(command.getBytes());
        }

    }

    public void onClickBtnBuzzer(View view)
    {
        if(myThreadConnected!=null){
            String command = "V";
            myThreadConnected.write(command.getBytes());
        }

    }


    /*============================================================================================*/

    private class ThreadConnectBTdevice extends Thread {

        private BluetoothSocket bluetoothSocket = null;
        private final BluetoothDevice bluetoothDevice;


        private ThreadConnectBTdevice(BluetoothDevice device) {
            bluetoothDevice = device;

            try {
                bluetoothSocket = device.createRfcommSocketToServiceRecord(myUUID);
                textStatus.setText("bluetoothSocket: \n" + bluetoothSocket);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            boolean success = false;
            try {
                bluetoothSocket.connect();
                success = true;
            } catch (IOException e) {
                e.printStackTrace();

                final String eMessage = e.getMessage();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        textStatus.setText("something wrong bluetoothSocket.connect(): \n" + eMessage);
                    }
                });

                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            if (success) {
                //connect successful
                final String msgconnected = "connect successful:\n"
                        + "BluetoothSocket: " + bluetoothSocket + "\n"
                        + "BluetoothDevice: " + bluetoothDevice;

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        textStatus.setText(msgconnected);


                        listDevicesFound.setVisibility(View.GONE);
                        //inputPane.setVisibility(View.VISIBLE);
                    }
                });

                startThreadConnected(bluetoothSocket);
            } else {
                //fail
            }
        }

        public void cancel() {

            Toast.makeText(getApplicationContext(),
                    "close bluetoothSocket",
                    Toast.LENGTH_LONG).show();

            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
    /*============================================================================================*/
    private class ThreadConnected extends Thread {
        private final BluetoothSocket connectedBluetoothSocket;
        private final InputStream connectedInputStream;
        private final OutputStream connectedOutputStream;

        public ThreadConnected(BluetoothSocket socket) {
            connectedBluetoothSocket = socket;
            InputStream in = null;
            OutputStream out = null;

            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            connectedInputStream = in;
            connectedOutputStream = out;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {
                    bytes = connectedInputStream.read(buffer);
                    String strReceived = new String(buffer, 0, bytes);
                    final String msgReceived = String.valueOf(bytes) +
                            " bytes received:\n"
                            + strReceived;

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            textStatus.setText(msgReceived);

                        }
                    });

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                    final String msgConnectionLost = "Connection lost:\n"
                            + e.getMessage();
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            textStatus.setText(msgConnectionLost);
                        }
                    });
                }
            }
        }

        public void write(byte[] buffer) {
            try {
                connectedOutputStream.write(buffer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void cancel() {
            try {
                connectedBluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
