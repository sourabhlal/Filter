package app.sourabhlal.filter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class EditContactActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "app.sourabhlal.Filter";
    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String target = getIntent().getStringExtra("ContactAsString");
        Gson gS = new Gson();
        this.contact = gS.fromJson(target, Contact.class); // Converts the JSON String to an Object
        Log.d("CONTACT", contact.getName());
        final EditText name = (EditText) findViewById(R.id.updateName);
        final EditText phone = (EditText) findViewById(R.id.updatePhone);
        final EditText email = (EditText) findViewById(R.id.updateEmail);
        final EditText website = (EditText) findViewById(R.id.updateWebsite);
        final EditText address = (EditText) findViewById(R.id.updateAddress);
        if (this.contact.getName() != ""){
            name.setText(this.contact.getName());
        }
        if (this.contact.getNumber() != ""){
            phone.setText(this.contact.getNumber());
        }
        if (this.contact.getEmail() != ""){
            email.setText(this.contact.getEmail());
        }
        if (this.contact.getAddress() != ""){
            address.setText(this.contact.getAddress());
        }
        if (this.contact.getWebsite() != ""){
            website.setText(this.contact.getWebsite());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void updateContact(View view){
        Intent intent = new Intent(this, MainActivity.class);
        MyDataBase db = new MyDataBase(getApplicationContext());
        String name = ((EditText)findViewById(R.id.updateName)).getText().toString();

        this.contact.setName(name);
        this.contact.setNumber(((EditText) findViewById(R.id.updatePhone)).getText().toString());
        this.contact.setEmail(((EditText) findViewById(R.id.updateEmail)).getText().toString());
        this.contact.setAddress(((EditText) findViewById(R.id.updateAddress)).getText().toString());
        this.contact.setWebsite(((EditText) findViewById(R.id.updateWebsite)).getText().toString());

        Log.d("Contact: ", this.contact.getName() + " " + this.contact.getNumber());

        db.persist(this.contact);

        String message = "Save Account";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
