# android-properties-file
##What is properties file?

Properties files are mainly used for configuration of applications. Android uses 
the same java properties file which is mainly java.util.Properties. Properties 
class extends Hashtable. So it is mainly key value pairs. The key and value must 
be string. By using key we can get the value.

Now follow the below steps to configure and get the value from properties file.

##Step 1

Create a new project. If you don’t know how to create project please read [another post](http://javaant.com/hello-world-using-android-studio-1-0/#.VaM_1fmqqko).

##Step 2

Create a .properties file in assets folder, if you don’t have assets folder please create one under main.

##Step 3

Crate Util.java to read the properties file.

####Util.java
```java
package javaant.com.propertiesfile;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Nirmal Dhara on 12-07-2015.
 */
public class Util {

    public static String getProperty(String key,Context context) throws IOException {
    
        Properties properties = new Properties();;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }
}
```
MainActivity.java

```java 
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
```
config.properties

name=User Name
age=User Age
ok=Click
