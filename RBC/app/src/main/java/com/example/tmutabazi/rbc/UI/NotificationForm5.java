package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class NotificationForm5 extends ActionBarActivity  implements View.OnClickListener{

    private Button next5;
    private EditText date;
    private EditText country;
    private EditText District;
    private RadioGroup TravelOutRwanda;
    private RadioButton TravelOutRwandaSelected;
    private RadioGroup TravelFortyTwoDays;
    private RadioButton TravelFortyTwoDaysSelected;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification5);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   5 OUT 8");
        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");

        next5 = (Button) findViewById(R.id.next5);
        date = (EditText) findViewById(R.id.dateofreturn);
        date.setOnClickListener(this);
       // country = (EditText) findViewById(R.id.countryOut);
        //District = (EditText) findViewById(R.id.districtOut);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               notification = objectBuilding(notification);
                Intent ip = new Intent(NotificationForm5.this, NotificationForm6.class);
                ip.putExtra("object",  notification);
                startActivity(ip);

            }
        });
    }
    public Notification objectBuilding(Notification notification)
    {
        TravelOutRwanda = (RadioGroup) findViewById(R.id.radioOuttravel);
        TravelOutRwandaSelected = (RadioButton) findViewById(TravelOutRwanda.getCheckedRadioButtonId());
        TravelFortyTwoDays = (RadioGroup) findViewById(R.id.radionextravel);
        TravelFortyTwoDaysSelected = (RadioButton) findViewById(TravelFortyTwoDays.getCheckedRadioButtonId());
        notification.setTravelledOutForteenDays(TravelOutRwandaSelected.getText().toString());
       // notification.setOutTravelOutformation(date.getText().toString(),country.getText().toString(),District.getText().toString());
        notification.travelWithInFortyTwoDays(TravelFortyTwoDaysSelected.getText().toString());
        return notification;
    }

    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm5.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_notification5, menu);
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
