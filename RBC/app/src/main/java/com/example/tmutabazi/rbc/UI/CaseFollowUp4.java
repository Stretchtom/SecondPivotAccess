package com.example.tmutabazi.rbc.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tmutabazi.rbc.R;


public class CaseFollowUp4 extends ActionBarActivity {

   private ListView listOfItems;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up5);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  4 OUT OF 7");


        displayOptions();
        displaySelectedOption();


    }

   public void displayOptions ()
   {
       String [] bloodTest = {"Day 3 (following diagnosis)", "Day 14 (following diagnosis)", "Day 28 (following diagnosis)"};
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.blood_test, bloodTest);
       listOfItems = (ListView) findViewById(R.id.listView);
       listOfItems .setAdapter(adapter);
   }
   public void displaySelectedOption ()
   {
       listOfItems = (ListView) findViewById(R.id.listView);
       listOfItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){


           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent ip = new Intent(CaseFollowUp4.this, CaseFollowUp5.class);
               startActivity(ip);


           }
       });
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case_follow_up4, menu);
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
