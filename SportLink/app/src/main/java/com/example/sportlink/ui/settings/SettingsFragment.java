package com.example.sportlink.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportlink.R;


public class SettingsFragment extends Fragment {
    private RadioGroup sportRadioGroup;
    private RadioButton matchingSportsRadioButton;
    private RadioButton allSportsRadioButton;
    private RadioButton customSportsRadioButton;
    private Button saveCustomSportButton;
    private TextView savedCustomSportTextView;
    private EditText customSportView;
    private RadioGroup genderRadioGroup;
    private SeekBar minAgeSeekBar;
    private SeekBar maxAgeSeekBar;
    private SeekBar distanceSeekBar;
    private TextView distanceTextView;
    private Button saveButton;
    private SettingsViewModel viewModel;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Find views by ID
        sportRadioGroup = view.findViewById(R.id.sport_radio_group);
        customSportView = view.findViewById(R.id.custom_sport_view);
        matchingSportsRadioButton = view.findViewById(R.id.matching_sports_radio_button);
        allSportsRadioButton = view.findViewById(R.id.all_sports_radio_button);
        customSportsRadioButton = view.findViewById(R.id.custom_sports_radio_button);
        saveCustomSportButton = view.findViewById(R.id.save_custom_sport_button);
        savedCustomSportTextView = view.findViewById(R.id.saved_custom_sport_text_view);
        genderRadioGroup = view.findViewById(R.id.gender_radio_group);
        distanceSeekBar = view.findViewById(R.id.distance_seek_bar);
        distanceTextView = view.findViewById(R.id.distance_text_view);
        saveButton = view.findViewById(R.id.save_button);
        minAgeSeekBar = view.findViewById(R.id.min_age_seekbar);
        maxAgeSeekBar = view.findViewById(R.id.max_age_seekbar);


        // Set up the custom sport edit text
        sportRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.custom_sports_radio_button) {
                    customSportView.setVisibility(View.VISIBLE);

                    // Show save button
                    saveCustomSportButton.setVisibility(View.VISIBLE);

                    // Set click listener for save button
                    saveCustomSportButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Get the text entered by the user
                            String customSport = customSportView.getText().toString();

                            // Save the custom sport to SharedPreferences
                            SharedPreferences.Editor editor = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
                            editor.putString("custom_sport", customSport);
                            editor.apply();

                            // Show the saved custom sport in a TextView
                            String savedCustomSport = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).getString("custom_sport", "");
                            savedCustomSportTextView.setText(savedCustomSport);
                            savedCustomSportTextView.setVisibility(View.VISIBLE);
                        }
                    });
                } else {
                    customSportView.setVisibility(View.GONE);
                    saveCustomSportButton.setVisibility(View.GONE);

                }
            }
        });

        // Set up the age seek bar
        //
        final TextView ageRangeTextView = view.findViewById(R.id.age_range_textview);

        minAgeSeekBar.setMax(99);
        maxAgeSeekBar.setMax(100);

        minAgeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minAge = progress;
                int maxAge = maxAgeSeekBar.getProgress();
                if (minAge > maxAge) {
                    maxAgeSeekBar.setProgress(minAge);
                    maxAge = minAge;
                }
                ageRangeTextView.setText(getString(R.string.age_range, minAge, maxAge));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        maxAgeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minAge = minAgeSeekBar.getProgress();
                int maxAge = progress;
                if (maxAge < minAge) {
                    minAgeSeekBar.setProgress(maxAge);
                    minAge = maxAge;
                }
                ageRangeTextView.setText(getString(R.string.age_range, minAge, maxAge));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        minAgeSeekBar.setProgress(20);
        maxAgeSeekBar.setProgress(80);
        ageRangeTextView.setText(getString(R.string.age_range, 20, 80));


        // Set up the distance seek bar
        distanceSeekBar.setMax(1000);
        distanceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distanceTextView.setText(getString(R.string.distance_range, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
        distanceSeekBar.setProgress(500);

        // Set up the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettings();
            }
        });

        // Set up the ViewModel
        viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        viewModel.getSettings().observe(getViewLifecycleOwner(),
                new Observer<Settings>() {
                    @Override
                    public void onChanged(Settings settings) {
                        // Update the UI with the current settings
                        if (settings.getGender().equals(getString(R.string.men))) {
                            genderRadioGroup.check(R.id.men_radio_button);
                        } else if (settings.getGender().equals(getString(R.string.women))) {
                            genderRadioGroup.check(R.id.women_radio_button);
                        } else {
                            genderRadioGroup.check(R.id.both_radio_button);
                        }
                        minAgeSeekBar.setProgress(settings.getMinAge());
                        maxAgeSeekBar.setProgress(settings.getMaxAge());
                        distanceSeekBar.setProgress(settings.getDistance());
                    }
                });

        return view;
    }

    private void saveSettings() {
        int selectedSport;
        String customSport;
        if (matchingSportsRadioButton.isChecked()) {
            selectedSport = Settings.MATCHING_SPORTS;
            customSport = "";
        } else if (allSportsRadioButton.isChecked()) {
            selectedSport = Settings.ALL_SPORTS;
            customSport = "";
        } else {
            selectedSport = Settings.CUSTOM_SPORT;
            customSport = customSportView.getText().toString();
        }
        String selectedGender;
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedGenderId == R.id.men_radio_button) {
            selectedGender = getString(R.string.men);
        } else if (selectedGenderId == R.id.women_radio_button) {
            selectedGender = getString(R.string.women);
        } else {
            selectedGender = getString(R.string.both);
        }
        int selectedMinAge = minAgeSeekBar.getProgress();
        int selectedMaxAge = maxAgeSeekBar.getProgress();
        int selectedDistance = distanceSeekBar.getProgress();

        // Save the settings to the ViewModel
        viewModel.saveSettings(new Settings(selectedSport, customSport, selectedGender,
                selectedMinAge, selectedMaxAge, selectedDistance));

        // Return to the calling activity
        requireActivity().onBackPressed();
    }
}
