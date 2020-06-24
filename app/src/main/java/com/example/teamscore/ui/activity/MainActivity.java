package com.example.teamscore.ui.activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import com.example.teamscore.R;
import com.example.teamscore.ui.fragments.SearchFragment;
import com.example.teamscore.ui.fragments.TeamDetailsFragment;

public class MainActivity extends AppCompatActivity {
    public FragmentManager fm;
    private SearchFragment searchFragment;
    private TeamDetailsFragment teamDetailsFragment;
    private SharedPreferences sharedPreferences;
    private String userTeam = "savedTeamID";
    public String userSelectedTeam;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = this.getSharedPreferences("TeamScoreApp", Context.MODE_PRIVATE);
        userSelectedTeam = prefs.getString(userTeam, null);
        fm = getSupportFragmentManager();

        if(userSelectedTeam == null) {
            if (savedInstanceState == null) {
                searchFragment = new SearchFragment();
                fm.beginTransaction().add(R.id.main_frame, searchFragment)
                        .commit();
            }
        } else {
            if (savedInstanceState == null) {
                teamDetailsFragment = new TeamDetailsFragment();
                fm.beginTransaction().add(R.id.main_frame, teamDetailsFragment)
                        .commit();
            }
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //hide the keyboard from editText when out of focus
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
        // after writing this method here we need to put following line in every activity in menifests
        // android:windowSoftInputMode="stateHidden"
    }
}