package com.example.tmutabazi.rbc.UI;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm2 extends ActionBarActivity implements View.OnClickListener{
    private Button next;
    private RadioGroup isPregnant;
    private RadioButton isPregnantRadioButton;
    private EditText headHouseHold;
    private EditText idNumber;
    private EditText telephoneNumber;
    private Spinner residentialDistrict;
    private Spinner sector;
    private Spinner cell;


    private EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    2 OUT OF 6");
        next = (Button) findViewById(R.id.button2);
        isPregnant = (RadioGroup) findViewById(R.id.isPregnant);
        headHouseHold = (EditText) findViewById(R.id.headOfHouseholdName);
        idNumber = (EditText) findViewById(R.id.idNumber);
        idNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        telephoneNumber = (EditText) findViewById(R.id.telephoneNumber);
        telephoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        date = (EditText) findViewById(R.id.editText12);
        date.setOnClickListener(this);
        residentialDistrict = (Spinner)findViewById(R.id.residentialDistrict);
        residentialDistrict.setAdapter(ArrayAdapter.createFromResource(this, R.array.district, R.layout.fat_spinner_entry));
        sector = (Spinner)findViewById(R.id.sector);
        sector.setAdapter(ArrayAdapter.createFromResource(this, R.array.sector, R.layout.fat_spinner_entry));
        cell = (Spinner)findViewById(R.id.cell);
        cell.setAdapter(ArrayAdapter.createFromResource(this, R.array.cell, R.layout.fat_spinner_entry));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvestigationClass investigation = populateObject();
                Intent ip = new Intent(InvestigationForm2.this, InvestigationForm3.class);
                ip.putExtra("myObject", investigation);
                startActivity(ip);






            }
        });
    }
    public InvestigationClass populateObject ()
    {
        Intent intent = getIntent();
        InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");
        int selected_id = isPregnant.getCheckedRadioButtonId();
        isPregnantRadioButton = (RadioButton) findViewById( selected_id);
        String radioButtonText = isPregnantRadioButton.getText().toString();
        investigation.setIsPregnant(radioButtonText);
        String headHousehold1 = headHouseHold.getText().toString();
        investigation.setHeadOfHousehold(headHousehold1);
        String idNumber1 = idNumber.getText().toString();
        investigation.setIdNumber(idNumber1);
        return investigation;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm2.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePicker.show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form2, menu);
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
