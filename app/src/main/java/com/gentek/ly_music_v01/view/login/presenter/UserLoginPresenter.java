package com.gentek.ly_music_v01.view.login.presenter;


import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.gentek.lib_network.listener.DisposeDataListener;
import com.gentek.ly_music_v01.api.MockData;
import com.gentek.ly_music_v01.api.RequestCenter;
import com.gentek.ly_music_v01.model.login.LoginEvent;
import com.gentek.ly_music_v01.model.user.User;
import com.gentek.ly_music_v01.utils.UserManager;
import com.gentek.ly_music_v01.view.login.inter.IUserLoginPresenter;
import com.gentek.ly_music_v01.view.login.inter.IUserLoginView;

import org.greenrobot.eventbus.EventBus;

/**
 * 登陆页面对应Presenter
 */
public class UserLoginPresenter implements IUserLoginPresenter, DisposeDataListener {

    private IUserLoginView mIView;

    public UserLoginPresenter(IUserLoginView iView) {
        mIView = iView;
    }

    @Override
    public void login(String username, String password) {
        Log.d("info", "login:==>1 ");
        mIView.showLoadingView();
        RequestCenter.login( this);
    }

    @Override
    public void onSuccess(Object responseObj) {
        mIView.hideLoadingView();
        User user = (User) responseObj;
        UserManager.getInstance().setUser(user);
        //发送登陆Event
        EventBus.getDefault().post(new LoginEvent());
        mIView.finishActivity();
    }

    @Override
    public void onFailure(Object reasonObj) {
        mIView.hideLoadingView();
        onSuccess(JSON.parseObject(MockData.LOGIN_DATA, User.class));
        mIView.showLoginFailedView();
    }
}
