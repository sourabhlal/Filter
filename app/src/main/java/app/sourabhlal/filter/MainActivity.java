package app.sourabhlal.filter;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yahoo.squidb.data.SquidCursor;
import com.yahoo.squidb.sql.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    public final static String EXTRA_MESSAGE = "app.sourabhlal.Filter";

    private TextView selection;
    private Contact[] items={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        MyDataBase db = new MyDataBase(getApplicationContext());
        Query selectAll = Query.select();
        SquidCursor<Contact> c = db.query(Contact.class, selectAll);
        List<Contact> contacts = new ArrayList<>();

        try {
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                Contact p = new Contact();
                p.readPropertiesFromCursor(c);
                Log.i("success", p.getName() + " HAS NUMBER " + p.getNumber());
                contacts.add(p);
            }
        } finally {
            c.close();
        }

        Contact[] array = contacts.toArray(new Contact[contacts.size()]);
        items = array;

/*        SquidCursor<Label> l = db.query(Label.class, selectAll);
        List<String> labels = new ArrayList<>();

        try {
            for (l.moveToFirst(); !l.isAfterLast(); l.moveToNext()) {
                Label q = new Label();
                q.readPropertiesFromCursor(l);
                Log.i("success", q.getLabels());
                labels.add(q.getLabels());
            }
        } finally {
            l.close();
        }

        String[] labelsList = labels.toArray(new String[labels.size()]);


        //Creating the instance of ArrayAdapter containing list of language names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,labelsList);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.filter);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(getResources().getColor(R.color.colorAccent));
*/
        setListAdapter(new AccountAdapter());
        //selection=(TextView)findViewById(R.id.selection);
    }

    class AccountAdapter extends ArrayAdapter<Contact> {

        AccountAdapter() {
            super(MainActivity.this, R.layout.contact_list_item, R.id.label, items);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=super.getView(position, convertView, parent);
            TextView name = (TextView)row.findViewById(R.id.label);
            name.setText(items[position].getName());

            ImageView icon=(ImageView)row.findViewById(R.id.icon);
            icon.setImageResource(R.drawable.ic_input_add);

            TextView size=(TextView)row.findViewById(R.id.size);
            size.setText(items[position].getNumber());

            return(row);
        }
    }

    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        //selection.setText(items[position].getName());
        Contact contact=(Contact)getListView().getItemAtPosition(position);
        Gson gS = new Gson();
        String target = gS.toJson(contact); // Converts the object to a JSON String
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("ContactAsString", target );
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**Called whenever the user clicks the Send button */
    public void addContact (View view){
        Intent intent = new Intent(this, AddContactActivity.class);
        String message = "New Contact Add Screen";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
