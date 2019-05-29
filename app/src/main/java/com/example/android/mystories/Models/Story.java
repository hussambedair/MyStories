package com.example.android.mystories.Models;

public class Story {

    private int mStoryImageResourceId;
    private int mPersonImageResourceId;
    private String mPersonName;

    public Story(int storyImageResourceId, int personImageResourceId, String personName) {
        mStoryImageResourceId = storyImageResourceId;
        mPersonImageResourceId = personImageResourceId;
        mPersonName = personName;
    }

    public int getStoryImageResourceId() {
        return mStoryImageResourceId;
    }

    public int getPersonImageResourceId() {
        return mPersonImageResourceId;
    }

    public String getPersonName() {
        return mPersonName;
    }
}
