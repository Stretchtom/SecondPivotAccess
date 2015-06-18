package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm6 extends ActionBarActivity implements View.OnClickListener {

    private EditText date1;
    private EditText date2;
    private EditText date3;
    private EditText date4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form6);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    6 OUT OF 6");
        date1 = (EditText) findViewById(R.id.editText38);
        date2 = (EditText) findViewById(R.id.editText42);
        date3 = (EditText) findViewById(R.id.editText44);
        date4 = (EditText) findViewById(R.id.editText45);
        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        date3.setOnClickListener(this);
        date4.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form6, menu);
        return true;
    }
    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        switch (v.getId()) {
            case R.id.editText38:
                DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker.show();

                break;

            case R.id.editText42:
                DatePickerDialog datePicker1=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date2.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker1.show();

                break;
            case R.id.editText44 :
                DatePickerDialog datePicker2=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date3.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker2.show();
                break;
            case R.id.editText45 :
                DatePickerDialog datePicker3=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date4.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker3.show();

                break;


        }





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
