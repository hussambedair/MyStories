package com.example.android.mystories.Activities;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.android.mystories.Adapters.StoriesRecyclerAdapter;
import com.example.android.mystories.Base.BaseActivity;
import com.example.android.mystories.Fragments.StoryDialogFragment;
import com.example.android.mystories.Models.Story;
import com.example.android.mystories.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    RecyclerView storiesRecyclerView;
    StoriesRecyclerAdapter storiesAdapter;
    RecyclerView.LayoutManager storiesLayoutManager;
    List<Story> stories;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createStories ();

        storiesRecyclerView = findViewById(R.id.stories_recycler_view);

        storiesLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false );

        storiesAdapter = new StoriesRecyclerAdapter(stories);

        storiesAdapter.setOnProfileClickListener(new StoriesRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Story story) {
                Toast.makeText(MainActivity.this
                        , "Profile image pressed!", Toast.LENGTH_SHORT).show();
            }
        });

        storiesAdapter.setOnStoryClickListener(new StoriesRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Story story) {

                StoryDialogFragment dialogFragment = new StoryDialogFragment();
                dialogFragment.setUserName(story.getPersonName());
                //dialogFragment.setCancelable(false);
                dialogFragment.show(getSupportFragmentManager(),"story");


                //Toast.makeText(MainActivity.this, "Story image pressed!", Toast.LENGTH_SHORT).show();
            }
        });


        storiesRecyclerView.setAdapter(storiesAdapter);
        storiesRecyclerView.setLayoutManager(storiesLayoutManager);







    }


    private void createStories () {
        stories = new ArrayList<Story>();

        for (int i= 0 ; i<12; i++) {

            stories.add(new Story(R.drawable.story_image,
                    R.drawable.profile_image_1,"Person "+ i) );

        }
    }


    @Override
    public void onBackPressed() {

        //showProgressBar();

        showConfirmationMessage(R.string.warning, R.string.content_message, R.string.yes, new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
                finish();
            }
        });

    }
}
