package remainder.com.remainder;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.arch.persistence.room.Room;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import remainder.com.remainder.database.ChildClass;
import remainder.com.remainder.database.database;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";
    public static final String CHANNEL_ID = "hello";

    public static database database;
    private SQLiteDatabase mDatabase;

    private TextView tv_child, tv_preg;
    DatabaseHelper myDb;
    Button btnAdd,btnView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(getApplicationContext(), database.class, "userinfo").allowMainThreadQueries().build();

       // tv_view = findViewById(R.id.view);
        tv_child = findViewById(R.id.child);
        tv_preg = findViewById(R.id.preg);
        btnAdd = (Button) findViewById(R.id.add);
        btnView = (Button) findViewById(R.id.view);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        tv_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, ChildClass.class);
                startActivity(newIntent);
            }
        });


       /* tv_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(newIntent);
            }
        });*/

        tv_preg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, Pregnant.class);
                startActivity(newIntent);
            }
        });

        createNotificationChannel();

    }

   /* private void insertData() {
        String vacc_name = "BCG";
        int month = 1;
        String table_name = "vaccination";
        ContentValues contentValues = new ContentValues();
        contentValues.put("vacc_name",vacc_name);
        contentValues.put("month",month);
                mDatabase.insert(table_name,null,contentValues);
    }*/

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "channel1", importance);
            channel.setDescription("Hellloooo");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
