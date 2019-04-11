package remainder.com.remainder;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.content.ClipData;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import remainder.com.remainder.database.DatabaseAccess;
import remainder.com.remainder.database.User;
import remainder.com.remainder.database.database;

import static android.os.Build.VERSION_CODES.M;

public class EditActivity extends AppCompatActivity {


    public static database database;

    //private TextView tv, cName, dob;


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.longclick_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteRecord:
                Toast.makeText(this, "delete record item clicked", Toast.LENGTH_SHORT).show();


                return true;
            case R.id.renameRecord:
                Toast.makeText(this, "rename record item clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
         /*tv = findViewById(R.id.text);
         cName = findViewById(R.id.tv_name);
         dob = findViewById(R.id.tv_dob);

        LinearLayout layout = findViewById(R.id.record);

        registerForContextMenu(layout);

        
        
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // opens new activity
                Toast.makeText(EditActivity.this, "you clicked this record!", Toast.LENGTH_SHORT).show();
            }
        });

        List<User> users = MainActivity.database.databaseObject().readUser();

        for(User usr: users){
            int id = usr.getId();
            String name = usr.getName();
            String bday = usr.getDay() + "/" + usr.getMonth() + "/" + usr.getYear();
            cName.setText("  " +name);
            dob.setText("   DOB: " + bday);
        }
        
        





    }*/
    }
}
