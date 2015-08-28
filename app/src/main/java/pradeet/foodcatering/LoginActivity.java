package pradeet.foodcatering;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    EditText EmailField;
    EditText PasswordField;
    Button Loginbtn;

    String Email;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailField = (EditText) findViewById(R.id.LoginEmail);
        PasswordField = (EditText) findViewById(R.id.LoginPsw);
        Loginbtn = (Button) findViewById(R.id.Loginbtn);

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = EmailField.getText().toString();
                Password = PasswordField.getText().toString();

                setLoginStatus(true);

                Intent intent = new Intent(LoginActivity.this, Cateeres.class);
                intent.putExtra("Name", Email);
                intent.putExtra("Email", Email);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setLoginStatus(boolean b) {
        SharedPreferences prefs = getSharedPreferences(SplashScreen.Prefkey, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();

        edit.putBoolean(SplashScreen.LoginStatusPref, b);
        edit.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
