package com.gentek.ly_music_v01.model.user;


import com.gentek.ly_music_v01.model.BaseModel;

/**
 * 用户真正实体数据
 */
public class UserContent extends BaseModel {

  public String userId; //用户唯一标识符
  public String photoUrl;
  public String name;
  public String tick;
  public String mobile;
  public String platform;

  public UserContent() {
  }

  public String getName() {
    return name;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTick() {
    return tick;
  }

  public void setTick(String tick) {
    this.tick = tick;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }
}
