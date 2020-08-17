package com.gentek.ly_music_v01.model.user;


import com.gentek.ly_music_v01.model.BaseModel;

/**
 * 用户数据协议
 */
public class User extends BaseModel {
  public int ecode;
  public String emsg;
  public UserContent data;

  public User() {
  }

  public void setEcode(int ecode) {
    this.ecode = ecode;
  }

  public void setEmsg(String emsg) {
    this.emsg = emsg;
  }

  public void setData(UserContent data) {
    this.data = data;
  }

  public int getEcode() {
    return ecode;
  }

  public String getEmsg() {
    return emsg;
  }

  public UserContent getData() {
    return data;
  }
}
