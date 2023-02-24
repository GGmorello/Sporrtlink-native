package com.example.sportlink.ui.dashboard;

import static android.util.Log.println;

import androidx.lifecycle.ViewModel;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.sportlink.R;

public class DashboardViewModel extends ViewModel {


    static Person erik = new Person("Erik", "28", new int[]{R.drawable.erik1, R.drawable.erik2, R.drawable.erik3},"5",  new InterestTag[]{new InterestTag("Padel", R.drawable.tennis_racket)}, "I’m an extrovert who enjoys doing sports with other people. I wish to find a running partner so we can motivate each other, and a padel partner to team with for an upcoming tournament (medium level).", "2nd place local padel tournament in Stockholm");
    static Person mick = new Person("Mick", "28", new int[]{R.drawable.mick1, R.drawable.mick2, R.drawable.mick3},"10", new InterestTag[]{new InterestTag("Padel", R.drawable.tennis_racket), new InterestTag("Jogging", R.drawable.runicon)}, "I’m an extrovert who enjoys doing sports with other people. I wish to find a running partner so we can motivate each other, and a padel partner to team with for an upcoming tournament (medium level).", "Together with my partner, we placed second in a local padel tournament here in Stockholm.\n" +
            "Have also ran multiple marathons. Personal best time is 3 hours and 37 minutes.");
    public static Person activePerson = erik;
    public static int currentImage = 0;
    public DashboardViewModel() {

    }

    public static void setMick() {
        activePerson = mick;
    }

    public static void onClickButton(View view) {
        setMick();
        DashboardViewModel.currentImage = 0;
    }
}