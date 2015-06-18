package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;

public class NotificationForm extends ActionBarActivity implements View.OnClickListener{
    private EditText date;
    private Button next1;
    private EditText case_no;
    private RadioGroup patient_type;
    private RadioGroup refered;
    private EditText firstName;
    private EditText surname;
    private RadioGroup gender;
    private RadioButton genderSelected;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   1 OUT 8");
        next1 = (Button) findViewById(R.id.next1);
        date = (EditText) findViewById(R.id.notification_date);
        date.setOnClickListener(this);



        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = new Notification();
                notification = objectBuilding(notification);

                firstName = (EditText) findViewById(R.id.fName);
                surname = (EditText) findViewById(R.id.sName);
                gender = (RadioGroup) findViewById(R.id.radioSex);
                genderSelected = (RadioButton) findViewById(gender.getCheckedRadioButtonId());


                Intent ip = new Intent(NotificationForm.this, NotificationForm2.class);
                ip.putExtra("firstName",firstName.getText().toString());
                ip.putExtra("surname", surname.getText());
                ip.putExtra("gender", genderSelected.getText().toString());
                ip.putExtra("object", notification);

                startActivity(ip);



            }
        });
    }
    public Notification objectBuilding(Notification notification)
    {


        notification.setDate(date.getText().toString());
        case_no = (EditText) findViewById(R.id.CaseCode);
        notification.setCaseNumber(Integer.parseInt(case_no.getText().toString()));
        patient_type = (RadioGroup) findViewById(R.id.radioPatient);
        refered = (RadioGroup) findViewById(R.id.radioRefered);



        //notification.setStatusPatient();
        return notification;

    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_notification, menu);
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