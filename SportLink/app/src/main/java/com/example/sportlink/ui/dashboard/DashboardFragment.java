package com.example.sportlink.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportlink.EditProfile;
import com.example.sportlink.R;
import com.example.sportlink.databinding.FragmentDashboardBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        binding.imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
        binding.textViewName.setText(DashboardViewModel.activePerson.getName());
        binding.textViewAge.setText(DashboardViewModel.activePerson.getAge());
        binding.textViewDistance.setText(DashboardViewModel.activePerson.getDistance() + "km away");
        binding.textViewBiographyContent.setText(DashboardViewModel.activePerson.getBiography());
        binding.textViewAchievementsContent.setText(DashboardViewModel.activePerson.getAchievements());

        addListenerOnButton();
        setOnClickLeft(root);
        onClickButton(root);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClickButton(View view) {

        FloatingActionButton[] floatingActionButtons = new FloatingActionButton[]{root.findViewById(R.id.approveButton), root.findViewById(R.id.rejectButton)};

        for (FloatingActionButton floatingActionButton : floatingActionButtons) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    DashboardViewModel.onClickButton(view);

                    ImageView imageView = root.findViewById(R.id.imageView);
                    imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);

                    TextView nameTextView = root.findViewById(R.id.textViewName);
                    nameTextView.setText(DashboardViewModel.activePerson.getName());

                    TextView ageTextView = root.findViewById(R.id.textViewAge);
                    ageTextView.setText(DashboardViewModel.activePerson.getAge());

                    TextView distanceTextView = root.findViewById(R.id.textViewDistance);
                    distanceTextView.setText(DashboardViewModel.activePerson.getDistance() + "km away");

                    TextView biographyTextView = root.findViewById(R.id.textViewBiographyContent);
                    biographyTextView.setText(DashboardViewModel.activePerson.getBiography());

                    TextView achievementsTextView = root.findViewById(R.id.textViewAchievementsContent);
                    achievementsTextView.setText(DashboardViewModel.activePerson.getAchievements());
                }
            });
        }
    }

    public void addListenerOnButton() {

        FloatingActionButton floatingActionButtonRight = root.findViewById(R.id.nextImage);

        floatingActionButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (DashboardViewModel.currentImage + 1 < 3) {
                    DashboardViewModel.currentImage++;
                    ImageView imageView = root.findViewById(R.id.imageView);
                    imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
                }
            }
        });
    }

    public void setOnClickLeft(View view) {

        FloatingActionButton floatingActionButtonLeft = root.findViewById(R.id.previousImage);

        floatingActionButtonLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (DashboardViewModel.currentImage - 1 >= 0) {
                    DashboardViewModel.currentImage--;
                    ImageView imageView = root.findViewById(R.id.imageView);
                    imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
                }
            }
        });
    }
}