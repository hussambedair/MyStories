package com.example.android.mystories.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mystories.R;

public class StoryDialogFragment extends DialogFragment {

    String mUserName;

    View view;

    public StoryDialogFragment() {

    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story_dialog,
                container, false);

        TextView textView = view.findViewById(R.id.user_name);
        textView.setText(mUserName);


        return view;


    }
}
