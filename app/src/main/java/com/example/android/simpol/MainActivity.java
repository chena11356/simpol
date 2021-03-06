package com.example.android.simpol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.android.simpol.Issues.Issues;
import com.example.android.simpol.Politicians.Politicians;

//TO-DO: https://stackoverflow.com/questions/23421701/how-to-apply-a-fade-in-fade-out-animation-when-replacing-a-fragment
public class MainActivity extends AppCompatActivity implements Me.OnFragmentInteractionListener {

    private static Context context;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected;
            switch (item.getItemId()) {
                case R.id.navigation_politicians:
                    selected = new Politicians();
                    break;
                case R.id.navigation_issues:
                    selected = new Issues();
                    break;
                case R.id.navigation_me:
                    selected = new Me();
                    break;
                case R.id.navigation_voting:
                    selected = new Voting();
                    break;
                case R.id.navigation_setting:
                    selected = new Settings();
                    break;
                default:
                    return false;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();
        // navigation bar
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public static Context getAppContext(){
        return MainActivity.context;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        /*
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        ft.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        ft.replace(android.R.id.realtabcontent, fragment);
        ft.commit();
        */
    }
}
