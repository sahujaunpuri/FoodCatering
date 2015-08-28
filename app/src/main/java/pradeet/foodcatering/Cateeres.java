package pradeet.foodcatering;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import pradeet.foodcatering.Adapter.CateersAdapter;


public class Cateeres extends ActionBarActivity {

    ListView cateersList;
    Toolbar toolbar;

    ArrayList<CateersSepc> CateersData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateeres);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        cateersList = (ListView) findViewById(R.id.ListView);
        CateersData = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            CateersSepc temp = new CateersSepc();
            temp.Name = "Name: " + i;
            temp.Spec = "Special: " + 1;
            temp.Rating = "Rate: " + i;
            temp.Rate = 500 + "";
            CateersData.add(temp);
        }

        CateersAdapter adapter = new CateersAdapter(this, CateersData);
        cateersList.setAdapter(adapter);
        cateersList.setDividerHeight(2);
        cateersList.setDivider(new ColorDrawable(Color.parseColor("#DADADA")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cateeres, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.LogOut) {
            setLoginStatus(false);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setLoginStatus(boolean b) {
        SharedPreferences prefs = getSharedPreferences(SplashScreen.Prefkey, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();

        edit.putBoolean(SplashScreen.LoginStatusPref, b);
        edit.commit();
    }

    @Override
    public void onBackPressed() {

        System.out.println("executed");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
