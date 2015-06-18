package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.tmutabazi.rbc.CaseFollowupClass.CaseFollowUpClass;

import com.example.tmutabazi.rbc.R;


import java.util.Calendar;
import java.util.TimeZone;


public class CaseFollowUp1 extends ActionBarActivity implements View.OnClickListener{
    private Spinner one;
    private Button next;
    private EditText date1;
    private EditText date2;
    private Spinner district;
    private Spinner hospital;
    private Spinner healthFacility;
    private EditText nationalIdNumber;
    private EditText healthFacilityOfficer;
    private EditText caseCodeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  1 OUT OF 7");
        one = (Spinner)findViewById(R.id.spinner7);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.MethodOfDiagnosis, R.layout.spinner6));
        next = (Button) findViewById(R.id.button7);
        date1 = (EditText) findViewById(R.id.followUpDate);
        date2 = (EditText) findViewById(R.id.diagnosisDate);
        nationalIdNumber = (EditText) findViewById(R.id.nationalId);
        nationalIdNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        healthFacilityOfficer = (EditText) findViewById(R.id.healthFacilityOfficer);
        caseCodeNumber = (EditText) findViewById(R.id.caseCodeNumber);
        caseCodeNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        district = (Spinner)findViewById(R.id.district);
        district.setAdapter(ArrayAdapter.createFromResource(this, R.array.district, R.layout.spinner6));
        hospital= (Spinner)findViewById(R.id.hospital);
        hospital.setAdapter(ArrayAdapter.createFromResource(this, R.array.hospital, R.layout.spinner6));
        healthFacility = (Spinner)findViewById(R.id.healthFacility);
        healthFacility.setAdapter(ArrayAdapter.createFromResource(this, R.array.Facility, R.layout.spinner6));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaseFollowUpClass caseFollowUp = populateObject();
                Intent ip = new Intent(CaseFollowUp1.this, CaseFollowUp2.class);
                ip.putExtra("myObject", caseFollowUp);
                startActivity(ip);

            }
        });
    }
    public CaseFollowUpClass populateObject ()
    {
        CaseFollowUpClass caseFollowUp = new CaseFollowUpClass();
        String followUpDate = date1.getText().toString();
        caseFollowUp.setFollow_UpDate(followUpDate);
        String diagnoseDate = date2.getText().toString();
        caseFollowUp.setCaseDate(diagnoseDate);
        String district1 =  (district.getSelectedItem().toString());
       // Search for the correspondingID
        caseFollowUp.setDistrictId(1);
        String hospital1 =  (hospital.getSelectedItem().toString());
        // Search for the correspondingID
        caseFollowUp.setHospitalId(2);
        String healthFacility1 =  (healthFacility.getSelectedItem().toString());
        // Search for the correspondingID
        caseFollowUp.setFacilityId(3);
        String nationalIdNumber1 = nationalIdNumber.getText().toString();
        caseFollowUp.setNationalIdNumber( nationalIdNumber1);
        String healthFacilityOfficer1 = healthFacilityOfficer.getText().toString();
        caseFollowUp.setHealthFacilityOfficer(healthFacilityOfficer1);
        String diagnosisMethod =  (one.getSelectedItem().toString());
        caseFollowUp.setMethodOfDiagnosis( diagnosisMethod);
        String caseCodeNumber1 = caseCodeNumber.getText().toString();
        int caseCodeNumber2 = Integer.parseInt(caseCodeNumber1);
        caseFollowUp.setCaseCodeNumber(caseCodeNumber2);
        return caseFollowUp;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        switch (v.getId())
        {
            case R.id.followUpDate:
                DatePickerDialog datePicker=new DatePickerDialog(CaseFollowUp1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker.show();

                break;

            case R.id.diagnosisDate:
                DatePickerDialog datePicker1=new DatePickerDialog(CaseFollowUp1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date2.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker1.show();

                break;
        }







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case_follow_up, menu);
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
