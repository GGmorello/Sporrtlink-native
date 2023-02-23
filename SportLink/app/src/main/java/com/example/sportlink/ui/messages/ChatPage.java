package com.example.sportlink.ui.messages;

import android.os.Bundle;
import android.view.View;

import com.example.sportlink.R;
import com.example.sportlink.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class ChatPage extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(R.layout.activity_chat);


    }
}
