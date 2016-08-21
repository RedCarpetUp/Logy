package co.logy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import co.balrampandey.logy.Logy;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logy.setEnable(true);
                Logy.e("Logy Error", "error");
                Logy.d("Logy Debug", "Debug");
                Logy.v("Logy VERBOSE", "VERBOSE");
                Logy.i("Logy INFO", "INFO");
                Logy.w("Logu WARN", "WARN");
                checkMethodDebug();
                    showLogyJson();

                Snackbar.make(view, "Check Logcat", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void checkMethodDebug()
    {
        Logy.d("Hello this is Debug");
    }
    public void showLogyJson() {
        String json="{\"phonetype\":\"N95\",\"cat\":\"WP\"}\n";
        try {
        JSONObject jsonObj = new JSONObject(json);
     Logy.json("Logy JSON",jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
}
