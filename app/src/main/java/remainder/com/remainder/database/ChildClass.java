package remainder.com.remainder.database;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import remainder.com.remainder.MainActivity;
import remainder.com.remainder.Notification;
import remainder.com.remainder.R;

import static remainder.com.remainder.MainActivity.CHANNEL_ID;

public class ChildClass extends AppCompatActivity  {


          private   EditText name;
          private TextView date_tv;
          int id;
          int cYear,cMonth,cDay;
          Button confirm;
    public static final int NOTIFICATION_ID=1;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_class);

        name = findViewById(R.id.et_name);
        date_tv = findViewById(R.id.et_date);
         //set click listener
       // findViewById(R.id.button).setOnClickListener(this);
        confirm = findViewById(R.id.button);

        String todayDate = new SimpleDateFormat("MM-dd-YYYY", Locale.getDefault()).format(new Date());
        date_tv.setText(todayDate);








        date_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                cYear = year;
                cMonth = month;
                cDay = day;

               //Intent newIntent = new Intent(ChildClass.this, MainActivity.class);
                //startActivity(newIntent);



                DatePickerDialog dialog = new DatePickerDialog(
                        ChildClass.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }


        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
               // Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;

                date_tv.setText(date);
                cYear = year;
                cMonth = month;
                cDay = day;
            }

        };
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setName(name.getText().toString());
                user.setDay(cDay);
                user.setMonth(cMonth);
                user.setYear(cYear);

                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(ChildClass.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_person)
                        .setContentText("Check your vaccination time")
                        .setContentTitle("Medicinbe")
                        .setAutoCancel(true) ;

                NotificationManager notificationManager =  (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if(notificationManager!=null)
                    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());




                Toast.makeText(ChildClass.this, "Details added successfully" , Toast.LENGTH_SHORT).show();
               Intent newIntent = new Intent(ChildClass.this, MainActivity.class);
               startActivity(newIntent);

            }
        });



    }


}



