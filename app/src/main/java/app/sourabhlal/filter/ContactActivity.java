package app.sourabhlal.filter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class ContactActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "app.sourabhlal.Filter";

    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // get Contact information
        String target = getIntent().getStringExtra("ContactAsString");
        Gson gS = new Gson();
        this.contact = gS.fromJson(target, Contact.class); // Converts the JSON String to an Object
        Log.d("CONTACT", contact.getName());
        final TextView name = (TextView) findViewById(R.id.conName);
        final TextView phone = (TextView) findViewById(R.id.conPhone);
        final TextView email = (TextView) findViewById(R.id.conEmail);
        final TextView website = (TextView) findViewById(R.id.conWebsite);
        final TextView address = (TextView) findViewById(R.id.conAddress);
        name.setText(this.contact.getName());
        phone.setText(this.contact.getNumber());
        email.setText(this.contact.getEmail());
        website.setText(this.contact.getWebsite());
        address.setText(this.contact.getAddress());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void editContact (View view){
        Intent intent = new Intent(this, EditContactActivity.class);
        String message = "Existing Contact Edit Screen";
        intent.putExtra(EXTRA_MESSAGE, message);
        Gson gS = new Gson();
        String target = gS.toJson(this.contact); // Converts the object to a JSON String
        intent.putExtra("ContactAsString", target );
        startActivity(intent);
    }

}
