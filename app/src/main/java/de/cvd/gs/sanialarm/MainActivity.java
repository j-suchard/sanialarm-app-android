package de.cvd.gs.sanialarm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.toolbox.Volley;

import de.cvd.gs.sanialarm.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    public static ApplicationViewModel applicationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bind the Main view model
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        // Create an global request queue for Volley
        applicationViewModel.setVolleyRequestQueue(Volley.newRequestQueue(this));
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}