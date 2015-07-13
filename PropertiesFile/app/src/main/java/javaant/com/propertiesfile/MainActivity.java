package javaant.com.propertiesfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // read value from properties file

        TextView txtname= (TextView) findViewById(R.id.txtname);
        TextView txtage= (TextView) findViewById(R.id.txtage);
        Button btnok= (Button) findViewById(R.id.btnok);

        try {
            txtname.setText(Util.getProperty("name",getApplicationContext()));
            txtage.setText(Util.getProperty("age",getApplicationContext()));
            btnok.setText(Util.getProperty("ok",getApplicationContext()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
