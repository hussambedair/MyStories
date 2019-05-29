package com.example.android.mystories.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mystories.Models.Story;
import com.example.android.mystories.R;

import java.util.List;

public class StoriesRecyclerAdapter
        extends RecyclerView.Adapter<StoriesRecyclerAdapter.ViewHolder> {


    List<Story> mStories;

    OnItemClickListener onProfileClickListener;
    OnItemClickListener onStoryClickListener;

    public StoriesRecyclerAdapter(List<Story> stories) {
        mStories = stories;

    }

    public void setOnProfileClickListener(OnItemClickListener onProfileClickListener) {
        this.onProfileClickListener = onProfileClickListener;
    }

    public void setOnStoryClickListener(OnItemClickListener onStoryClickListener) {
        this.onStoryClickListener = onStoryClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final Story story = mStories.get(position);
        viewHolder.mPersonName.setText(story.getPersonName());
        viewHolder.mStoryImage.setImageResource(story.getStoryImageResourceId());
        viewHolder.mPersonImage.setImageResource(story.getPersonImageResourceId());


        if (onProfileClickListener != null) {
            //a view within the item will respond to the click
            viewHolder.mPersonImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProfileClickListener.onItemClick(position, story);
                }
            });
        }


        if (onStoryClickListener != null) {
            //a view within the item will respond to the click
            viewHolder.mStoryImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStoryClickListener.onItemClick(position, story);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }



    public interface OnItemClickListener {
        public void onItemClick(int pos, Story story);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mPersonImage;
        ImageView mStoryImage;
        TextView mPersonName;


        public ViewHolder(@NonNull View view) {
            super(view);
            mPersonImage = view.findViewById(R.id.person_image_view);
            mStoryImage = view.findViewById(R.id.story_image_view);
            mPersonName = view.findViewById(R.id.person_name_textview);

        }
    }


}
