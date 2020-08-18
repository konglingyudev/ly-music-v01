package com.gentek.ly_music_v01.view.home;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.gentek.lib_audio.app.AudioHelper;
import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.gentek.lib_common_ui.base.BaseActivity;
import com.gentek.lib_common_ui.pager_indictor.ScaleTransitionPagerTitleView;
import com.gentek.lib_image_loader.app.ImageLoaderManager;
import com.gentek.ly_music_v01.R;
import com.gentek.ly_music_v01.bean.SongListBean;
import com.gentek.ly_music_v01.model.CHANNEL;
import com.gentek.ly_music_v01.model.login.LoginEvent;
import com.gentek.ly_music_v01.utils.UserManager;
import com.gentek.ly_music_v01.adapter.CommonPagerAdapter;
import com.gentek.ly_music_v01.view.login.LoginActivity;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    // 指定首页要出现的卡片
    private static final CHANNEL[] CHANNELS = new CHANNEL[]{CHANNEL.DISCORY, CHANNEL.MY, CHANNEL.FRIEND};

    private DrawerLayout mDrawerLayout;
    private View mToggleView;
    private View mSearchView;
    private ViewPager mViewPager;
    private CommonPagerAdapter mAdapter;

    private View mDrawerQrcodeView;
    private View mDrawerShareView;

    private View unLogginLayout;
    private ImageView mPhotoView;

    private ArrayList<SongBean> mLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        String res = "{\"song_list\":[{\"artist_id\":\"672865435\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2019-12-16\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/4589294157b56806f6ff597660c84329\\/672866365\\/672866365.txt\",\"copy_type\":\"1\",\"hot\":\"185951\",\"all_artist_ting_uid\":\"340615848\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"0\",\"rank\":\"1\",\"all_artist_id\":\"672865435\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":175,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u5317\\u4eac\\u4e07\\u4e0a\\u6587\\u5316\\u4f20\\u5a92\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"672865438\",\"title\":\"\\u6865\\u8fb9\\u59d1\\u5a18\",\"ting_uid\":\"340615848\",\"author\":\"\\u821e\\u8e48\\u5973\\u795e\\u8bfa\\u6db5\",\"album_id\":\"672865436\",\"album_title\":\"\\u6865\\u8fb9\\u59d1\\u5a18\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u821e\\u8e48\\u5973\\u795e\\u8bfa\\u6db5\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/b733a1a9fc0f63c7015be29b7b840b66\\/672866107\\/672866107.jpg\"},{\"artist_id\":\"674713815\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2020-03-24\",\"album_no\":\"2\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/cc8492076ab0def9daf88daf9a9b3751\\/675022268\\/675022268.txt\",\"copy_type\":\"1\",\"hot\":\"133785\",\"all_artist_ting_uid\":\"340642446\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"1\",\"rank\":\"2\",\"all_artist_id\":\"674713815\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,224,128,320,flac\",\"file_duration\":236,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"labelname_\\u5317\\u4eac\\u6b23\\u7136\\u6587\\u5316\\u4f20\\u5a92\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"675017674\",\"title\":\"\\u5c11\\u5e74\\uff08\\u7ae5\\u58f0\\u7248\\uff09\",\"ting_uid\":\"340642446\",\"author\":\"\\u5b8b\\u5c0f\\u777f\",\"album_id\":\"675017666\",\"album_title\":\"\\u5c11\\u5e74\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u5b8b\\u5c0f\\u777f\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/8b1aab6be81f10639c01c1401a20463c\\/675021896\\/675021896.jpg\"},{\"artist_id\":\"123446035\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2016-05-20\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/7a07a153b8a9a9d918bbee676b7d4118\\/603149730\\/603149730.lrc\",\"copy_type\":\"1\",\"hot\":\"180640\",\"all_artist_ting_uid\":\"164528737\",\"resource_type\":\"0\",\"is_new\":\"0\",\"rank_change\":\"1\",\"rank\":\"3\",\"all_artist_id\":\"123446035\",\"style\":\"\\u6d41\\u884c\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":313,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\\u52a8\\u753b\\u7535\\u5f71\\u300a\\u5927\\u9c7c\\u6d77\\u68e0\\u300b\\u5370\\u8c61\\u66f2\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u970d\\u5c14\\u679c\\u65af\\u9752\\u6625\\u5149\\u7ebf\\u5f71\\u4e1a\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"265715650\",\"title\":\"\\u5927\\u9c7c\",\"ting_uid\":\"164528737\",\"author\":\"\\u5468\\u6df1\",\"album_id\":\"265715651\",\"album_title\":\"\\u5927\\u9c7c\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u5468\\u6df1\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/0d359ec1be6f5365f92d4c83d3eeb022\\/603758238\\/603758238.jpg\"},{\"artist_id\":\"88\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2016-07-18\",\"album_no\":\"4\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/bed1fcb36f51259eefab8ba6d95f524f\\/672457403\\/672457403.lrc\",\"copy_type\":\"1\",\"hot\":\"138090\",\"all_artist_ting_uid\":\"2517\",\"resource_type\":\"0\",\"is_new\":\"0\",\"rank_change\":\"-2\",\"rank\":\"4\",\"all_artist_id\":\"88\",\"style\":\"\\u6d41\\u884c\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":261,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"129|-1\\\",\\\"1\\\":\\\"-1|-1\\\"}\",\"biaoshi\":\"lossless,vip,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u534e\\u5b87\\u4e16\\u535a\\u97f3\\u4e50\\u6587\\u5316\\uff08\\u5317\\u4eac\\uff09\\u6709\\u9650\\u516c\\u53f8-\\u666e\\u901a\\u4ee3\\u7406\",\"res_encryption_flag\":\"0\",\"song_id\":\"242078437\",\"title\":\"\\u6f14\\u5458\",\"ting_uid\":\"2517\",\"author\":\"\\u859b\\u4e4b\\u8c26\",\"album_id\":\"241838068\",\"album_title\":\"\\u521d\\u5b66\\u8005\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"2\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u859b\\u4e4b\\u8c26\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/49e6161afb13e3eda9d1cb4e304561a2\\/676820947\\/676820947.jpg@s_2,w_1000,h_1000\"},{\"artist_id\":\"672906440\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2019-12-18\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/bc98479f910e9d8f2fa25460aa90be84\\/672906575\\/672906575.txt\",\"copy_type\":\"1\",\"hot\":\"83162\",\"all_artist_ting_uid\":\"340616296\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"1\",\"rank\":\"5\",\"all_artist_id\":\"672906440\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":182,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u5317\\u4eac\\u4e07\\u4e0a\\u6587\\u5316\\u4f20\\u5a92\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"672906443\",\"title\":\"\\u6865\\u8fb9\\u59d1\\u5a18\",\"ting_uid\":\"340616296\",\"author\":\"\\u5782\\u8033\\u5154\",\"album_id\":\"672906441\",\"album_title\":\"\\u6865\\u8fb9\\u59d1\\u5a18\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u5782\\u8033\\u5154\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/822e11b209903ff44d67fa5148e01a84\\/672906473\\/672906473.jpg\"},{\"artist_id\":\"13911340\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2013-12-06\",\"album_no\":\"2\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/1608f69676398d1545d7e03ac52bb350\\/603149882\\/603149882.lrc\",\"copy_type\":\"1\",\"hot\":\"274737\",\"all_artist_ting_uid\":\"2319312\",\"resource_type\":\"0\",\"is_new\":\"0\",\"rank_change\":\"-1\",\"rank\":\"6\",\"all_artist_id\":\"13911340\",\"style\":\"\\u6d41\\u884c\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":125,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u5317\\u4eac\\u60e0\\u8fbe\\u5dde\\u6587\\u5316\\u4f20\\u64ad\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"106125582\",\"title\":\"\\u9006\\u6d41\\u6210\\u6cb3\",\"ting_uid\":\"2319312\",\"author\":\"\\u91d1\\u5357\\u73b2\",\"album_id\":\"106125580\",\"album_title\":\"\\u6765\\u751f\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":1,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u91d1\\u5357\\u73b2\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/106124457\\/106124457.jpg@s_2,w_1000,h_1000\"},{\"artist_id\":\"60722128\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2020-03-27\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/b5459ebbfdea9acecf2c462e9b70ce44\\/675236811\\/675236811.txt\",\"copy_type\":\"1\",\"hot\":\"79082\",\"all_artist_ting_uid\":\"209968568\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"0\",\"rank\":\"7\",\"all_artist_id\":\"60722128\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,224,128,320,flac\",\"file_duration\":279,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"129|-1\\\",\\\"1\\\":\\\"-1|-1\\\"}\",\"biaoshi\":\"lossless,vip,perm-3\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u534e\\u5b87\\u4e16\\u535a\\u97f3\\u4e50\\u6587\\u5316\\uff08\\u5317\\u4eac\\uff09\\u6709\\u9650\\u516c\\u53f8-\\u666e\\u901a\\u4ee3\\u7406\",\"res_encryption_flag\":\"0\",\"song_id\":\"675217012\",\"title\":\"\\u62e5\\u62b1\\u6625\\u5929\",\"ting_uid\":\"209968568\",\"author\":\"A\\u516c\\u9986\",\"album_id\":\"675217010\",\"album_title\":\"\\u62e5\\u62b1\\u6625\\u5929\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":1,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"2\",\"mv_provider\":\"0000000000\",\"artist_name\":\"A\\u516c\\u9986\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/d24656e3b055acb05fe096f781920016\\/675907119\\/675907119.jpg@s_2,w_1000,h_1000\"},{\"artist_id\":\"762\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2019-11-27\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/bd10eed4439097e0f7066a94528f7b2e\\/672526511\\/672526511.lrc\",\"copy_type\":\"1\",\"hot\":\"76099\",\"all_artist_ting_uid\":\"1376\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"1\",\"rank\":\"8\",\"all_artist_id\":\"762\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,224,128,320,flac\",\"file_duration\":296,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u5317\\u4eac\\u666e\\u5929\\u540c\\u4e50\\u6587\\u5316\\u4f20\\u5a92\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"672526448\",\"title\":\"\\u8bb0\\u5fc6\\u91cc\\u7684\\u96ea\",\"ting_uid\":\"1376\",\"author\":\"\\u9f99\\u6885\\u5b50\",\"album_id\":\"672526446\",\"album_title\":\"\\u8bb0\\u5fc6\\u91cc\\u7684\\u96ea\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u9f99\\u6885\\u5b50\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/28e4b596b16737fbaf54c600c19947a6\\/672527540\\/672527540.jpg@s_2,w_1000,h_1000\"},{\"artist_id\":\"14715949\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2020-03-25\",\"album_no\":\"1\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/4d34b71f289827f459aadc951b172248\\/675012957\\/675012957.txt\",\"copy_type\":\"1\",\"hot\":\"74470\",\"all_artist_ting_uid\":\"9631389,239563102\",\"resource_type\":\"0\",\"is_new\":\"1\",\"rank_change\":\"-1\",\"rank\":\"9\",\"all_artist_id\":\"14715949,267237378\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,224,128,320,flac\",\"file_duration\":290,\"has_mv_mobile\":0,\"versions\":\"\",\"bitrate_fee\":\"{\\\"0\\\":\\\"129|-1\\\",\\\"1\\\":\\\"-1|-1\\\"}\",\"biaoshi\":\"lossless,vip,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u6c38\\u7a3b\\u661f\\uff08\\u5317\\u4eac\\uff09\\u6587\\u5316\\u5a31\\u4e50\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"675012544\",\"title\":\"\\u5c71\\u6cb3\\u65e0\\u6059\\u5728\\u6211\\u80f8-\\u8521\\u5f90\\u5764+\\u4f5f\\u4e3d\\u5a05\",\"ting_uid\":\"9631389\",\"author\":\"\\u4f5f\\u4e3d\\u5a05,\\u8521\\u5f90\\u5764\",\"album_id\":\"675012542\",\"album_title\":\"\\u5c71\\u6cb3\\u65e0\\u6059\\u5728\\u6211\\u80f8\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"2\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u4f5f\\u4e3d\\u5a05,\\u8521\\u5f90\\u5764\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/bae766e5c670ca417cc433156efcb528\\/675012927\\/675012927.png@s_2,w_1000,h_1000\"},{\"artist_id\":\"10388780\",\"language\":\"\\u56fd\\u8bed\",\"pic_big\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_150,h_150\",\"pic_small\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_90,h_90\",\"country\":\"\\u5185\\u5730\",\"area\":\"0\",\"publishtime\":\"2017-06-16\",\"album_no\":\"5\",\"lrclink\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/lrc\\/c157208ccbcff03596aa1c08c246ad0f\\/614336922\\/614336922.lrc\",\"copy_type\":\"1\",\"hot\":\"82882\",\"all_artist_ting_uid\":\"556015\",\"resource_type\":\"0\",\"is_new\":\"0\",\"rank_change\":\"1\",\"rank\":\"10\",\"all_artist_id\":\"10388780\",\"style\":\"\",\"del_status\":\"0\",\"relate_status\":\"0\",\"toneid\":\"0\",\"all_rate\":\"96,128,224,320,flac\",\"file_duration\":235,\"has_mv_mobile\":0,\"versions\":\"\\u5f71\\u89c6\\u539f\\u58f0\",\"bitrate_fee\":\"{\\\"0\\\":\\\"0|0\\\",\\\"1\\\":\\\"0|0\\\"}\",\"biaoshi\":\"lossless,perm-1\",\"info\":\"\",\"has_filmtv\":\"0\",\"si_proxycompany\":\"\\u5317\\u4eac\\u542c\\u89c1\\u65f6\\u4ee3\\u5a31\\u4e50\\u4f20\\u5a92\\u6709\\u9650\\u516c\\u53f8\",\"res_encryption_flag\":\"0\",\"song_id\":\"542369506\",\"title\":\"\\u8ffd\\u5149\\u8005\",\"ting_uid\":\"556015\",\"author\":\"\\u5c91\\u5b81\\u513f\",\"album_id\":\"541982838\",\"album_title\":\"\\u590f\\u81f3\\u672a\\u81f3 \\u7535\\u89c6\\u539f\\u58f0\\u5e26\",\"is_first_publish\":0,\"havehigh\":2,\"charge\":0,\"has_mv\":0,\"learn\":0,\"song_source\":\"web\",\"piao_id\":\"0\",\"korean_bb_song\":\"0\",\"resource_type_ext\":\"0\",\"mv_provider\":\"0000000000\",\"artist_name\":\"\\u5c91\\u5b81\\u513f\",\"pic_radio\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_300,h_300\",\"pic_s500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_500,h_500\",\"pic_premium\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_500,h_500\",\"pic_huge\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_1000,h_1000\",\"album_500_500\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_500,h_500\",\"album_800_800\":\"\",\"album_1000_1000\":\"http:\\/\\/qukufile2.qianqian.com\\/data2\\/pic\\/58754f79bde49e3ee8fd6c5326e5a240\\/614336850\\/614336850.jpg@s_2,w_1000,h_1000\"}],\"billboard\":{\"billboard_type\":\"2\",\"billboard_no\":\"3118\",\"update_date\":\"2020-04-22\",\"billboard_songnum\":\"1365\",\"havemore\":1,\"name\":\"\\u70ed\\u6b4c\\u699c\",\"comment\":\"\\u8be5\\u699c\\u5355\\u662f\\u6839\\u636e\\u5343\\u5343\\u97f3\\u4e50\\u5e73\\u53f0\\u6b4c\\u66f2\\u6bcf\\u5468\\u64ad\\u653e\\u91cf\\u81ea\\u52a8\\u751f\\u6210\\u7684\\u6570\\u636e\\u699c\\u5355\\uff0c\\u7edf\\u8ba1\\u8303\\u56f4\\u4e3a\\u5343\\u5343\\u97f3\\u4e50\\u5e73\\u53f0\\u4e0a\\u7684\\u5168\\u90e8\\u6b4c\\u66f2\\uff0c\\u6bcf\\u65e5\\u66f4\\u65b0\\u4e00\\u6b21\",\"pic_s192\":\"http:\\/\\/business.cdn.qianqian.com\\/qianqian\\/pic\\/bos_client_1452f36a8dc430ccdb8f6e57be6df2ee.jpg\",\"pic_s640\":\"http:\\/\\/business.cdn.qianqian.com\\/qianqian\\/pic\\/bos_client_361aa8612dd9dd8474daf77040f7079d.jpg\",\"pic_s444\":\"http:\\/\\/hiphotos.qianqian.com\\/ting\\/pic\\/item\\/c83d70cf3bc79f3d98ca8e36b8a1cd11728b2988.jpg\",\"pic_s260\":\"http:\\/\\/hiphotos.qianqian.com\\/ting\\/pic\\/item\\/838ba61ea8d3fd1f1326c83c324e251f95ca5f8c.jpg\",\"pic_s210\":\"http:\\/\\/business.cdn.qianqian.com\\/qianqian\\/pic\\/bos_client_734232335ef76f5a05179797875817f3.jpg\",\"web_url\":\"http:\\/\\/music.baidu.com\\/top\\/dayhot\",\"color\":\"0xDC5900\",\"bg_color\":\"0xFBEFE6\",\"bg_pic\":\"http:\\/\\/business0.qianqian.com\\/qianqian\\/file\\/5bfe5026de816_689.png\"},\"error_code\":22000}";
        SongListBean songListBean = JSON.parseObject(res, SongListBean.class);
        int len=songListBean.getSong_list().size();
        Log.d("info", "len: "+len);
        for (int i=0;i<len;i++){
            mLists.add(songListBean.getSong_list().get(i));
        }
        Log.d("info", "mLists_len: "+mLists.size());
        mLists.get(0).setUrlLink("http://audio04.dmhmusic.com/71_53_T10052953671_128_4_1_0_sdk-cpm/cn/0209/M00/E1/B8/ChR47F33J_yAHE_JACrgf2qqnyQ634.mp3?xcode=066283cba84641616d12298b8e9abdf8a25d721");
        mLists.get(1).setUrlLink("http://audio04.dmhmusic.com/71_53_T10053686384_128_4_1_0_sdk-cpm/cn/0103/M00/EA/D5/ChR45V55rxWAEUidADmvhOQNekI580.mp3?xcode=1f90cc9b489ab1396d1221e48e886912b15409b");
        mLists.get(2).setUrlLink("http://audio04.dmhmusic.com/71_53_T10045984799_128_4_1_0_sdk-cpm/cn/0209/M00/63/F5/ChR47FsYfpOAa9_-AEycGK1yN2E381.mp3?xcode=7e473c82f3d0fc156d118752d3df158c3e62704");
        mLists.get(3).setUrlLink("http://audio04.dmhmusic.com/71_53_T10040589078_128_4_1_0_sdk-cpm/cn/0206/M00/90/77/ChR47F1_nqiAfD0hAD_MGBybIdk026.mp3?xcode=267f5eda921d9b966d11f275fc1d34db1c435bd");
        mLists.get(4).setUrlLink("http://audio04.dmhmusic.com/71_53_T10052963112_128_4_1_0_sdk-cpm/cn/0207/M00/AB/E6/ChR47F358H2ATBCZACyoAk8TiUM352.mp3?xcode=645121de22670c5b6d1234075b3e6a5b7f78d04");
        mLists.get(5).setUrlLink("http://audio04.dmhmusic.com/71_53_T10046233006_128_4_1_0_sdk-cpm/cn/0209/M00/66/6B/ChR461srtFyAA7LSAB6TwGxldfc228.mp3?xcode=e94f888b0f7a1a5a6d11bb3f4a62554f41d12a9");
        mLists.get(6).setUrlLink("http://audio04.dmhmusic.com/71_53_T10053704552_128_4_1_0_sdk-cpm/cn/0209/M00/FD/D2/ChR46156_RaAAPu7AEQzfIkMuII226.mp3?xcode=bd776ded105d5faa6d11a71dcc57437376009e3");
        mLists.get(7).setUrlLink("http://audio04.dmhmusic.com/71_53_T10040589078_128_4_1_0_sdk-cpm/cn/0206/M00/90/77/ChR47F1_nqiAfD0hAD_MGBybIdk026.mp3?xcode=267f5eda921d9b966d11f275fc1d34db1c435bd");
        mLists.get(8).setUrlLink("http://audio04.dmhmusic.com/71_53_T10040589078_128_4_1_0_sdk-cpm/cn/0206/M00/90/77/ChR47F1_nqiAfD0hAD_MGBybIdk026.mp3?xcode=267f5eda921d9b966d11f275fc1d34db1c435bd");
        mLists.get(9).setUrlLink("http://audio04.dmhmusic.com/71_53_T10040589078_128_4_1_0_sdk-cpm/cn/0206/M00/90/77/ChR47F1_nqiAfD0hAD_MGBybIdk026.mp3?xcode=267f5eda921d9b966d11f275fc1d34db1c435bd");


//
        AudioHelper.startMusicService(mLists);

    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggleView = findViewById(R.id.toggle_view);
        mToggleView.setOnClickListener(this);
        mSearchView = findViewById(R.id.search_view);

        mViewPager = findViewById(R.id.view_pager);
        mAdapter = new CommonPagerAdapter(getSupportFragmentManager(), CHANNELS);
        mViewPager.setAdapter(mAdapter);
        initMagicIndicator();


        mDrawerQrcodeView = findViewById(R.id.home_qrcode);
        mDrawerQrcodeView.setOnClickListener(this);
        mDrawerShareView = findViewById(R.id.home_music);
        mDrawerShareView.setOnClickListener(this);
        findViewById(R.id.online_music_view).setOnClickListener(this);
        findViewById(R.id.check_update_view).setOnClickListener(this);

        // 登录相关的UI
        unLogginLayout = findViewById(R.id.unloggin_layout);
        unLogginLayout.setOnClickListener(this);
        mPhotoView = findViewById(R.id.avatr_view);
        findViewById(R.id.exit_layout).setOnClickListener(this);

    }


    // 初始化指示器
    private void initMagicIndicator() {
        MagicIndicator magicIndicator = findViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return CHANNELS == null ? 0 : CHANNELS.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(CHANNELS[index].getKey());
                simplePagerTitleView.setTextSize(19);
                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#333333"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                return 1.0f;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.unloggin_layout:
                if (!UserManager.getInstance().hasLogined()) {
                    LoginActivity.start(this);
                } else {
                    mDrawerLayout.closeDrawer(Gravity.START);
                }
                break;
            case R.id.toggle_view:
                if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
                    mDrawerLayout.closeDrawer(Gravity.START);
                } else {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
                break;
            case R.id.exit_layout:
                Log.d("info", "onClick: 退出！ ");
                finish();
                System.exit(0);
                break;
            case R.id.home_qrcode:
//                if (hasPermission(Constant.HARDWEAR_CAMERA_PERMISSION)) {
//                    doCameraPermission();
//                } else {
//                    requestPermission(Constant.HARDWEAR_CAMERA_CODE, Constant.HARDWEAR_CAMERA_PERMISSION);
//                }
                break;
            case R.id.home_music:
                //shareFriend();
//                goToMusic();
                break;
            case R.id.online_music_view:
                //跳到指定webactivity
//                gotoWebView("https://www.imooc.com");
                break;
            case R.id.check_update_view:
//                checkUpdate();
                break;

        }
    }

    /**
     * 处理登陆事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {
        Log.d("info", "onLoginEvent: ");
        unLogginLayout.setVisibility(View.GONE);
        mPhotoView.setVisibility(View.VISIBLE);
        ImageLoaderManager.getInstance()
                .displayImageForCircle(mPhotoView, UserManager.getInstance().getUser().data.photoUrl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //退出不销毁task中activity
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}