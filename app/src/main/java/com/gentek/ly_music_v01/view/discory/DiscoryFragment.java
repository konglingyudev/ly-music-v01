package com.gentek.ly_music_v01.view.discory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.gentek.lib_network.listener.DisposeDataListener;
import com.gentek.ly_music_v01.R;
import com.gentek.ly_music_v01.adapter.CommonPagerAdapter;
import com.gentek.ly_music_v01.api.RequestCenter;
import com.gentek.ly_music_v01.model.CHANNEL;
import com.gentek.ly_music_v01.model.user.User;

/**
 * 首页发现fragment
 */
public class DiscoryFragment extends Fragment implements DisposeDataListener {

    private static final CHANNEL[] DISCORY_CHANNELS = new CHANNEL[]{CHANNEL.HOT_SONG, CHANNEL.NEW_SONG};

    private Context mContext;

    private ViewPager mViewPager;
    private CommonPagerAdapter mAdapter;
    public static Fragment newInstance() {
        DiscoryFragment fragment = new DiscoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discory_layout, null);

        mViewPager=rootView.findViewById(R.id.view_pager_discory);
        mAdapter = new CommonPagerAdapter(getChildFragmentManager(), DISCORY_CHANNELS);
        mViewPager.setAdapter(mAdapter);
//        mRecyclerView = rootView.findViewById(R.id.recyclerview);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        btn=rootView.findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RequestCenter.login( DiscoryFragment.this);
//            }
//        });
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //发请求更新UI
        requestData();
    }





    //请求数据
    private void requestData() {
//        RequestCenter.requestRecommandData(new DisposeDataListener() {
//            @Override
//            public void onSuccess(Object responseObj) {
//                mRecommandData = (BaseRecommandModel) responseObj;
//                //更新UI
//                updateView();
//            }
//
//            @Override
//            public void onFailure(Object reasonObj) {
//                //显示请求失败View,显示mock数据
//                onSuccess(
//                        ResponseEntityToModule.parseJsonToModule(MockData.HOME_DATA, BaseRecommandModel.class));
//            }
//        });
    }

    @Override
    public void onSuccess(Object responseObj) {
        User user = (User) responseObj;
        Log.d("info", "onSuccess: "+user.getData().getName());
    }

    @Override
    public void onFailure(Object reasonObj) {
        Log.d("info", "onFailure: =====>");
    }


}
