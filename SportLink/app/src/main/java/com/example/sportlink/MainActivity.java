package com.example.sportlink;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportlink.ui.dashboard.DashboardViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sportlink.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void onClickButton(View view) {
        DashboardViewModel.onClickButton(view);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);

        TextView nameTextView = findViewById(R.id.textViewName);
        nameTextView.setText(DashboardViewModel.activePerson.getName());

        TextView ageTextView = findViewById(R.id.textViewAge);
        ageTextView.setText(DashboardViewModel.activePerson.getAge());

        TextView distanceTextView = findViewById(R.id.textViewDistance);
        distanceTextView.setText(DashboardViewModel.activePerson.getDistance() + "km away");

        TextView biographyTextView = findViewById(R.id.textViewBiographyContent);
        biographyTextView.setText(DashboardViewModel.activePerson.getBiography());

        TextView achievementsTextView = findViewById(R.id.textViewAchievementsContent);
        achievementsTextView.setText(DashboardViewModel.activePerson.getAchievements());
    }

    public void onClickRight(View view) {
        if (DashboardViewModel.currentImage + 1 < 3) {
            DashboardViewModel.currentImage++;
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
        }
    }

    public void onClickLeft(View view) {
        if (DashboardViewModel.currentImage - 1 >= 0) {
            DashboardViewModel.currentImage--;
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
        }
    }
}
