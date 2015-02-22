package es.admobile.o.inwatchz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class InWatchZ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_watch_z);
//        setTitle("iR");
        setupActionBar();
        ArrayList<String> names = new ArrayList<String>();
        names.clear();
        names.add(0, "IBUPROFEN");
        names.add(1, "VITAMIN C");
        names.add(2, "EBASTINE");
        names.add(3, "ESOMEPRAZOLE");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mytextview, names);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v,int position, long id)
            {
                Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_LONG).show();
            }
        });

        ArrayList<String> past_names = new ArrayList<String>();
        past_names.clear();
        past_names.add(0, "OMEPRAZOLE");
        past_names.add(1, "VITAMIN C");
        past_names.add(2, "CHOLESTEROL LOWERING");
        past_names.add(3, "ORAL ASTHMA");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.mytextview, past_names);
        ListView past_lv = (ListView) findViewById(R.id.listView2);
        past_lv.setAdapter(adapter2);
        past_lv.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v,int position, long id)
            {
                Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_in_watch_z, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.emergency:
                emergencyCall();
                return true;
            case R.id.camera:
                takePhoto();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void emergencyCall()
    {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 934101024));
        startActivity(intent);
    }

    private void takePhoto()
    {
        Intent intent = new Intent(this, CreateReminder.class);
        startActivity(intent);
    }

    private void setupActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
//        ActionBar ab = getSupportActionBar();
////        ab.setTitle("HOLA");
////        Log.e("TEST", ab.toString());
//        ab.setDisplayShowTitleEnabled(false);
        /*
        ab.setIcon(R.mipmap.ic_launcher);

        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflator.inflate(R.layout.activity_in_watch_z, null);

        TextView titleTV = new TextView.appp("HOLA");
        Typeface font = Typeface.createFromAsset(getAssets(),
                "fonts/your_custom_font.ttf");
        titleTV.setTypeface(font);

        ab.setCustomView(v);

        ab.setHomeButtonEnabled(true);
        */
    }
}
