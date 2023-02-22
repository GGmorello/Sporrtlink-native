package com.example.sportlink.ui.settings;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {
    private MutableLiveData<Settings> settings;

    public SettingsViewModel() {
        settings = new MutableLiveData<>();
        settings.setValue(new Settings(1, "Padel", "Men", 18, 100, 100));
    }

    public LiveData<Settings> getSettings() {
        return settings;
    }

    public void saveSettings(Settings newSettings) {
        settings.setValue(newSettings);
    }
}
