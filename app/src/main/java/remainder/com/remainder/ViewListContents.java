package remainder.com.remainder;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView  = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if (data.getCount() == 0){
            Toast.makeText(ViewListContents.this,"database is empty",Toast.LENGTH_SHORT).show();

        }
        else{
            while(data.moveToNext()){
                thelist.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }


    }
}
