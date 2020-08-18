package com.gentek.ly_music_v01.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gentek.ly_music_v01.model.CHANNEL;
import com.gentek.ly_music_v01.view.discory.DiscoryFragment;
import com.gentek.ly_music_v01.view.friend.FriendFragment;
import com.gentek.ly_music_v01.view.mine.MineFragment;


public class CommonPagerAdapter extends FragmentPagerAdapter {

    private CHANNEL[] mList;

    public CommonPagerAdapter(FragmentManager fm, CHANNEL[] datas) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mList = datas;
    }

    //这种方式，避免一次性创建所有的fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
            case CHANNEL.HOT_SONG_ID:
                return MineFragment.newInstance();
            case CHANNEL.NEW_SONG_ID:
                return MineFragment.newInstance();

        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}
