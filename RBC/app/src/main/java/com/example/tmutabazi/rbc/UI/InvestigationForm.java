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
import android.widget.Toast;


import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;


import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm extends ActionBarActivity implements View.OnClickListener {
    private Button next;
    private EditText date;
    private EditText district;
    private EditText nameOfFacility;
    private EditText hospital;
    private EditText indexCaseCodeNumber;
    private EditText investigationCaseNo;
    private EditText firstNameOfPatient;
    private EditText surnameOfPatient;
    private EditText age;
    private Spinner districtSpinner;
    private Spinner facilitySpinner;
    private Spinner hospitalSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    1 OUT OF 6");
        next = (Button) findViewById(R.id.button);
        date = (EditText) findViewById(R.id.dateOfInvestigation);
        district= (EditText) findViewById(R.id.district);
       // nameOfFacility = (EditText) findViewById(R.id.nameOfFacility);
        hospital= (EditText) findViewById(R.id.hospital);
        indexCaseCodeNumber = (EditText) findViewById(R.id.indexCaseCodeeNumbero);
        indexCaseCodeNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        investigationCaseNo = (EditText) findViewById(R.id.investigationCaseNumber);
        investigationCaseNo.setInputType(InputType.TYPE_CLASS_NUMBER);
        firstNameOfPatient = (EditText) findViewById(R.id.FirstnameOfPatient);
        surnameOfPatient = (EditText) findViewById(R.id.surnameOfPatient);
        age = (EditText) findViewById(R.id.age);
        age.setInputType(InputType.TYPE_CLASS_NUMBER);
        date.setOnClickListener(this);
        districtSpinner = (Spinner)findViewById(R.id.districtSpinner);
        facilitySpinner = (Spinner)findViewById(R.id.facilitySpinner);
        hospitalSpinner = (Spinner)findViewById(R.id.hospitalSpinner);
        districtSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.district, R.layout.fat_spinner_entry));
        facilitySpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.Facility, R.layout.fat_spinner_entry));
        hospitalSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.hospital, R.layout.fat_spinner_entry));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvestigationClass investigation = populateObject();
                if (firstNameOfPatient.getText().length()!=0 && indexCaseCodeNumber.getText().length()!=0 &&
                        investigationCaseNo.getText().length()!=0 && age.getText().length()!=0 ) {
                    Intent ip = new Intent(InvestigationForm.this, InvestigationForm2.class);
                    ip.putExtra("myObject", investigation);
                    startActivity(ip);

                }
                else
                {
                    String message = "All fields must be filled";
                    Toast.makeText(getApplicationContext(),

                            message,

                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public InvestigationClass populateObject ()
    {
        InvestigationClass investigation = new InvestigationClass();
        if (indexCaseCodeNumber.getText().length()!=0 && investigationCaseNo.getText().length()!=0 && age.getText().length()!=0 ) {

            String investigationDate = date.getText().toString();
            investigation.setInvestigationDate(investigationDate);
            String district1 = (districtSpinner.getSelectedItem().toString());
            // Search for the corresponding id
            investigation.setInvestigationDistrictId(1);
            String nameOfFacility1 =(facilitySpinner.getSelectedItem().toString());
            // search for the corresponding id
            investigation.setInvestigationFacilityId(2);
            String hospital1 = (hospitalSpinner.getSelectedItem().toString());
            // search for the corresponding id
            investigation.setInvestigationHospitalId(3);
            String indexCaseCodeNumber1 = indexCaseCodeNumber.getText().toString();
            int indexCaseCodeNumber2 = Integer.parseInt(indexCaseCodeNumber1);

            investigation.setIndexCaseCodeNumber(indexCaseCodeNumber2);
            String investigationCaseNo1 = investigationCaseNo.getText().toString();
            int investigationCaseNo2 = Integer.parseInt(investigationCaseNo1);
            investigation.setInvestigationCaseNumber(investigationCaseNo2);
            String firstNameOfPatient1 = firstNameOfPatient.getText().toString();
            String surnameOfPatient1 = surnameOfPatient.getText().toString();
            investigation.setPatientName(firstNameOfPatient1, surnameOfPatient1);
            String age1 = age.getText().toString();
            int age2 = Integer.parseInt(age1);
            investigation.setPatientAge(age2);


        }
        else
        {
            String message = "Missing fields";
            Toast.makeText(getApplicationContext(),

                    message,

                    Toast.LENGTH_SHORT).show();

        }
        return investigation;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




                DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_investigation_form1, menu);
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
