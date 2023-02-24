package com.example.sportlink.ui.messages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportlink.R;
import com.example.sportlink.databinding.FragmentMessagesBinding;

public class MessagesFragment extends Fragment {
    private FragmentMessagesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Messages notificationsViewModel =
                new ViewModelProvider(this).get(Messages.class);

        binding = FragmentMessagesBinding.inflate(inflater, container, false);
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
        MessagesVerticalListAdapter adapter=new MessagesVerticalListAdapter((Activity) super.getContext(), playerTitle, subMessage, imgArray);
        ListView list=(ListView) root.findViewById(R.id.list_vertical);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chatPage();
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void chatPage(){
        //Send the information to the next activity
        Intent intent = new Intent((Activity) super.getContext(), ChatPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION| Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.putExtra("profileToLoad", profile);
        startActivity(intent);
    }
}