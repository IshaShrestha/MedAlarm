package remainder.com.remainder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import remainder.com.remainder.database.ChildClass;
import remainder.com.remainder.database.User;

public class Pregnant extends AppCompatActivity {

    private EditText name;
    private TextView date;
    int pYear,pMonth,pDay;
    Button confirm;

 private DatePickerDialog.OnDateSetListener mDateSetListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant);
        name = findViewById(R.id.user_name);
        date= findViewById(R.id.user_date);
        confirm= findViewById(R.id.confirm1);

        String todayDate = new SimpleDateFormat("MM-dd-YYYY", Locale.getDefault()).format(new Date());
        date.setText(todayDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day =cal.get(Calendar.DAY_OF_MONTH);
                pYear = year;
                pMonth = month;
                pDay = day;

                DatePickerDialog dialog = new DatePickerDialog(
                        Pregnant.this,
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

                String dates = month + "/" + day + "/" + year;

                date.setText(dates);
                pYear = year;
                pMonth = month;
                pDay = day;

            }
        };

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setName(name.getText().toString());
                user.setDay(pDay);
                user.setMonth(pMonth);
                user.setYear(pYear);

                MainActivity.database.databaseObject().addUser(user);
                Toast.makeText(Pregnant.this, "Details added Successfully" , Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(Pregnant.this, MainActivity.class);
                startActivity(newIntent);

            }
        });
    }
}
