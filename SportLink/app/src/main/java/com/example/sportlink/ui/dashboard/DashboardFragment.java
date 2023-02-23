package com.example.sportlink.ui.dashboard;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportlink.R;
import com.example.sportlink.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.imageView.setImageResource(DashboardViewModel.activePerson.getImages()[DashboardViewModel.currentImage]);
        binding.textViewName.setText(DashboardViewModel.activePerson.getName());
        binding.textViewAge.setText(DashboardViewModel.activePerson.getAge());
        binding.textViewDistance.setText(DashboardViewModel.activePerson.getDistance() + "km away");
        binding.textViewBiographyContent.setText(DashboardViewModel.activePerson.getBiography());
        binding.textViewAchievementsContent.setText(DashboardViewModel.activePerson.getAchievements());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}