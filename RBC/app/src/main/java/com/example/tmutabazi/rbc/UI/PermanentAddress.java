package com.example.tmutabazi.rbc.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.tmutabazi.rbc.R;


public class PermanentAddress extends ActionBarActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permanent_address);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Permanent Address");
        Intent intent = getIntent();
        final String activity = intent.getStringExtra("Activity");
        next = (Button) findViewById(R.id.button3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity.equals("notification2"))
                {
                    Intent ip = new Intent(PermanentAddress.this, NotificationForm3.class);
                    startActivity(ip);
                }
                else
                {
                    Intent ip = new Intent(PermanentAddress.this, Dispatcher.class);
                    startActivity(ip);
                }



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_permanent_address, menu);
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
