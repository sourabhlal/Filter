package app.sourabhlal.filter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    public final static String EXTRA_MESSAGE = "app.sourabhlal.Filter";

    private TextView selection;
    private static final String[] items={"contact 1","contact 2","contact 3","contact 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setListAdapter(new AccountAdapter());
        selection=(TextView)findViewById(R.id.selection);
    }

    class AccountAdapter extends ArrayAdapter<String> {
        AccountAdapter() {
            super(MainActivity.this, R.layout.contact_list_item, R.id.label, items);
        }
        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row=super.getView(position, convertView, parent);
            ImageView icon=(ImageView)row.findViewById(R.id.icon);
            if (items[position].length()>4) {
                icon.setImageResource(R.drawable.ic_input_add);
            }
            else {
                icon.setImageResource(R.drawable.ic_delete);
            }
            TextView size=(TextView)row.findViewById(R.id.size);
            size.setText("Hello");
            return(row);
        }
    }

    @Override
    public void onListItemClick(ListView parent, View v, int position,
                                long id) {
        selection.setText(items[position]);
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
    public void addAccount (View view){
        Intent intent = new Intent(this, AddContactActivity.class);
        String message = "New Account Add Screen";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
