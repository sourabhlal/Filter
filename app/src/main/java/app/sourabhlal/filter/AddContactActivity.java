package app.sourabhlal.filter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "app.sourabhlal.Filter";

    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating the instance of ArrayAdapter containing list of language names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.editTags);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                saveContact(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    public void saveContact (View view){
        Intent intent = new Intent(this, MainActivity.class);
        DBHelper dh = new DBHelper(view.getContext());
        String name = ((EditText)findViewById(R.id.editName)).getText().toString();
        Contact newCon = new Contact(name);
        newCon.setNumber(((EditText)findViewById(R.id.editPhone)).getText().toString());
        newCon.setEmail(((EditText)findViewById(R.id.editEmail)).getText().toString());
        newCon.setAddress(((EditText)findViewById(R.id.editAddress)).getText().toString());
        newCon.setWebsite(((EditText)findViewById(R.id.editWebsite)).getText().toString());
        dh.addContact(newCon);
        String message = "Save Account";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
