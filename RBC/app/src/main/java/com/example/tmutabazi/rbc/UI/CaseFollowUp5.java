package com.example.tmutabazi.rbc.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.tmutabazi.rbc.R;


public class CaseFollowUp5 extends ActionBarActivity {
    private Spinner one;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up6);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  5 OUT OF 7");
        one = (Spinner)findViewById(R.id.spinner8);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.species, R.layout.spinner4));
        next = (Button) findViewById(R.id.button11);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(CaseFollowUp5.this, CaseFollowUp6.class);
                startActivity(ip);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case_follow_up5, menu);
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
