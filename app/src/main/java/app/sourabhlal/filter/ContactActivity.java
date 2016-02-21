package app.sourabhlal.filter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // get Contact information
        String target = getIntent().getStringExtra("ContactAsString");
        Gson gS = new Gson();
        Contact contact = gS.fromJson(target, Contact.class); // Converts the JSON String to an Object
        Log.d("CONTACT", contact.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
    }

}
