package com.example.sportlink.ui.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportlink.R;
import com.example.sportlink.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String[] playerTitle = new String[12];
        String[] subMessage = new String[12];
        Integer[] imgArray = new Integer[12];

        for(int i = 0; i < 12; i++){
            subMessage[i] = "This is a sample message...";
            switch ( i % 3) {
                case 0:
                    playerTitle[i] = "Testa";
                    imgArray[i] = R.drawable.pexelsphoto040881;
                    break;
                case 1:
                    playerTitle[i] = "Testo";
                    imgArray[i] = R.drawable.pexelsphoto733872;
                    break;
                case 2:
                    playerTitle[i] = "Testina";
                    imgArray[i] = R.drawable.pexelsphoto1542085;
                    break;
            }
        }
        MessageVerticalListAdapter adapter=new MessageVerticalListAdapter((Activity) super.getContext(), playerTitle, subMessage, imgArray);
        ListView list=(ListView) root.findViewById(R.id.list_vertical);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("YEEEEEET");
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}