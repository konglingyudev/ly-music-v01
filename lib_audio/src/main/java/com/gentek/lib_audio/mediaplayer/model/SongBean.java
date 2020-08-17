package com.gentek.lib_audio.mediaplayer.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class SongBean  implements Serializable {
    private static final long serialVersionUID = 4372075791352098987L;
    /**
     * artist_id : 672865435
     * language : 国语
     * pic_big : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_150,h_150
     * pic_small : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_90,h_90
     * country : 内地
     * area : 0
     * publishtime : 2019-12-16
     * album_no : 1
     * lrclink : http://qukufile2.qianqian.com/data2/lrc/4589294157b56806f6ff597660c84329/672866365/672866365.txt
     * copy_type : 1
     * hot : 185951
     * all_artist_ting_uid : 340615848
     * resource_type : 0
     * is_new : 1
     * rank_change : 0
     * rank : 1
     * all_artist_id : 672865435
     * style :
     * del_status : 0
     * relate_status : 0
     * toneid : 0
     * all_rate : 96,128,224,320,flac
     * file_duration : 175
     * has_mv_mobile : 0
     * versions :
     * bitrate_fee : {"0":"0|0","1":"0|0"}
     * biaoshi : lossless,perm-1
     * info :
     * has_filmtv : 0
     * si_proxycompany : 北京万上文化传媒有限公司
     * res_encryption_flag : 0
     * song_id : 672865438
     * title : 桥边姑娘
     * ting_uid : 340615848
     * author : 舞蹈女神诺涵
     * album_id : 672865436
     * album_title : 桥边姑娘
     * is_first_publish : 0
     * havehigh : 2
     * charge : 0
     * has_mv : 0
     * learn : 0
     * song_source : web
     * piao_id : 0
     * korean_bb_song : 0
     * resource_type_ext : 0
     * mv_provider : 0000000000
     * artist_name : 舞蹈女神诺涵
     * pic_radio : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_300,h_300
     * pic_s500 : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500
     * pic_premium : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500
     * pic_huge : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg
     * album_500_500 : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500
     * album_800_800 :
     * album_1000_1000 : http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg
     */
    @Id
    private String song_id;
    //地址
    private String urlLink;
    private String lrclink;//后续

    //歌名
    @NotNull
    private String title;

    //作者
    @NotNull
    private String author;

    //所属专辑
    @NotNull
    private String album_title;

    //专辑封面
    @NotNull
    private String pic_premium;

    //时长
    private int file_duration;//

    private String artist_id;
    private String language;
    private String pic_big;
    private String pic_small;
    private String country;
    private String area;
    private String publishtime;
    private String album_no;

    private String copy_type;
    private String hot;
    private String all_artist_ting_uid;
    private String resource_type;
    private String is_new;
    private String rank_change;
    private String rank;
    private String all_artist_id;
    private String style;
    private String del_status;
    private String relate_status;
    private String toneid;
    private String all_rate;

    private int has_mv_mobile;
    private String versions;
    private String bitrate_fee;
    private String biaoshi;
    private String info;
    private String has_filmtv;
    private String si_proxycompany;
    private String res_encryption_flag;
    private String ting_uid;

    private String album_id;

    private int is_first_publish;
    private int havehigh;
    private int charge;
    private int has_mv;
    private int learn;
    private String song_source;
    private String piao_id;
    private String korean_bb_song;
    private String resource_type_ext;
    private String mv_provider;
    private String artist_name;
    private String pic_radio;
    private String pic_s500;

    private String pic_huge;
    private String album_500_500;
    private String album_800_800;
    private String album_1000_1000;


    @Generated(hash = 33410560)
    public SongBean(String song_id, String urlLink, String lrclink, @NotNull String title, @NotNull String author, @NotNull String album_title,
            @NotNull String pic_premium, int file_duration, String artist_id, String language, String pic_big, String pic_small, String country,
            String area, String publishtime, String album_no, String copy_type, String hot, String all_artist_ting_uid, String resource_type,
            String is_new, String rank_change, String rank, String all_artist_id, String style, String del_status, String relate_status,
            String toneid, String all_rate, int has_mv_mobile, String versions, String bitrate_fee, String biaoshi, String info,
            String has_filmtv, String si_proxycompany, String res_encryption_flag, String ting_uid, String album_id, int is_first_publish,
            int havehigh, int charge, int has_mv, int learn, String song_source, String piao_id, String korean_bb_song,
            String resource_type_ext, String mv_provider, String artist_name, String pic_radio, String pic_s500, String pic_huge,
            String album_500_500, String album_800_800, String album_1000_1000) {
        this.song_id = song_id;
        this.urlLink = urlLink;
        this.lrclink = lrclink;
        this.title = title;
        this.author = author;
        this.album_title = album_title;
        this.pic_premium = pic_premium;
        this.file_duration = file_duration;
        this.artist_id = artist_id;
        this.language = language;
        this.pic_big = pic_big;
        this.pic_small = pic_small;
        this.country = country;
        this.area = area;
        this.publishtime = publishtime;
        this.album_no = album_no;
        this.copy_type = copy_type;
        this.hot = hot;
        this.all_artist_ting_uid = all_artist_ting_uid;
        this.resource_type = resource_type;
        this.is_new = is_new;
        this.rank_change = rank_change;
        this.rank = rank;
        this.all_artist_id = all_artist_id;
        this.style = style;
        this.del_status = del_status;
        this.relate_status = relate_status;
        this.toneid = toneid;
        this.all_rate = all_rate;
        this.has_mv_mobile = has_mv_mobile;
        this.versions = versions;
        this.bitrate_fee = bitrate_fee;
        this.biaoshi = biaoshi;
        this.info = info;
        this.has_filmtv = has_filmtv;
        this.si_proxycompany = si_proxycompany;
        this.res_encryption_flag = res_encryption_flag;
        this.ting_uid = ting_uid;
        this.album_id = album_id;
        this.is_first_publish = is_first_publish;
        this.havehigh = havehigh;
        this.charge = charge;
        this.has_mv = has_mv;
        this.learn = learn;
        this.song_source = song_source;
        this.piao_id = piao_id;
        this.korean_bb_song = korean_bb_song;
        this.resource_type_ext = resource_type_ext;
        this.mv_provider = mv_provider;
        this.artist_name = artist_name;
        this.pic_radio = pic_radio;
        this.pic_s500 = pic_s500;
        this.pic_huge = pic_huge;
        this.album_500_500 = album_500_500;
        this.album_800_800 = album_800_800;
        this.album_1000_1000 = album_1000_1000;
    }

    @Generated(hash = 680878972)
    public SongBean() {
    }


    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPic_big() {
        return pic_big;
    }

    public void setPic_big(String pic_big) {
        this.pic_big = pic_big;
    }

    public String getPic_small() {
        return pic_small;
    }

    public void setPic_small(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getAlbum_no() {
        return album_no;
    }

    public void setAlbum_no(String album_no) {
        this.album_no = album_no;
    }

    public String getLrclink() {
        return lrclink;
    }

    public void setLrclink(String lrclink) {
        this.lrclink = lrclink;
    }

    public String getCopy_type() {
        return copy_type;
    }

    public void setCopy_type(String copy_type) {
        this.copy_type = copy_type;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getAll_artist_ting_uid() {
        return all_artist_ting_uid;
    }

    public void setAll_artist_ting_uid(String all_artist_ting_uid) {
        this.all_artist_ting_uid = all_artist_ting_uid;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getRank_change() {
        return rank_change;
    }

    public void setRank_change(String rank_change) {
        this.rank_change = rank_change;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAll_artist_id() {
        return all_artist_id;
    }

    public void setAll_artist_id(String all_artist_id) {
        this.all_artist_id = all_artist_id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDel_status() {
        return del_status;
    }

    public void setDel_status(String del_status) {
        this.del_status = del_status;
    }

    public String getRelate_status() {
        return relate_status;
    }

    public void setRelate_status(String relate_status) {
        this.relate_status = relate_status;
    }

    public String getToneid() {
        return toneid;
    }

    public void setToneid(String toneid) {
        this.toneid = toneid;
    }

    public String getAll_rate() {
        return all_rate;
    }

    public void setAll_rate(String all_rate) {
        this.all_rate = all_rate;
    }

    public int getFile_duration() {
        return file_duration;
    }

    public void setFile_duration(int file_duration) {
        this.file_duration = file_duration;
    }

    public int getHas_mv_mobile() {
        return has_mv_mobile;
    }

    public void setHas_mv_mobile(int has_mv_mobile) {
        this.has_mv_mobile = has_mv_mobile;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getBitrate_fee() {
        return bitrate_fee;
    }

    public void setBitrate_fee(String bitrate_fee) {
        this.bitrate_fee = bitrate_fee;
    }

    public String getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(String biaoshi) {
        this.biaoshi = biaoshi;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHas_filmtv() {
        return has_filmtv;
    }

    public void setHas_filmtv(String has_filmtv) {
        this.has_filmtv = has_filmtv;
    }

    public String getSi_proxycompany() {
        return si_proxycompany;
    }

    public void setSi_proxycompany(String si_proxycompany) {
        this.si_proxycompany = si_proxycompany;
    }

    public String getRes_encryption_flag() {
        return res_encryption_flag;
    }

    public void setRes_encryption_flag(String res_encryption_flag) {
        this.res_encryption_flag = res_encryption_flag;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTing_uid() {
        return ting_uid;
    }

    public void setTing_uid(String ting_uid) {
        this.ting_uid = ting_uid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public int getIs_first_publish() {
        return is_first_publish;
    }

    public void setIs_first_publish(int is_first_publish) {
        this.is_first_publish = is_first_publish;
    }

    public int getHavehigh() {
        return havehigh;
    }

    public void setHavehigh(int havehigh) {
        this.havehigh = havehigh;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getHas_mv() {
        return has_mv;
    }

    public void setHas_mv(int has_mv) {
        this.has_mv = has_mv;
    }

    public int getLearn() {
        return learn;
    }

    public void setLearn(int learn) {
        this.learn = learn;
    }

    public String getSong_source() {
        return song_source;
    }

    public void setSong_source(String song_source) {
        this.song_source = song_source;
    }

    public String getPiao_id() {
        return piao_id;
    }

    public void setPiao_id(String piao_id) {
        this.piao_id = piao_id;
    }

    public String getKorean_bb_song() {
        return korean_bb_song;
    }

    public void setKorean_bb_song(String korean_bb_song) {
        this.korean_bb_song = korean_bb_song;
    }

    public String getResource_type_ext() {
        return resource_type_ext;
    }

    public void setResource_type_ext(String resource_type_ext) {
        this.resource_type_ext = resource_type_ext;
    }

    public String getMv_provider() {
        return mv_provider;
    }

    public void setMv_provider(String mv_provider) {
        this.mv_provider = mv_provider;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getPic_radio() {
        return pic_radio;
    }

    public void setPic_radio(String pic_radio) {
        this.pic_radio = pic_radio;
    }

    public String getPic_s500() {
        return pic_s500;
    }

    public void setPic_s500(String pic_s500) {
        this.pic_s500 = pic_s500;
    }

    public String getPic_premium() {
        return pic_premium;
    }

    public void setPic_premium(String pic_premium) {
        this.pic_premium = pic_premium;
    }

    public String getPic_huge() {
        return pic_huge;
    }

    public void setPic_huge(String pic_huge) {
        this.pic_huge = pic_huge;
    }

    public String getAlbum_500_500() {
        return album_500_500;
    }

    public void setAlbum_500_500(String album_500_500) {
        this.album_500_500 = album_500_500;
    }

    public String getAlbum_800_800() {
        return album_800_800;
    }

    public void setAlbum_800_800(String album_800_800) {
        this.album_800_800 = album_800_800;
    }

    public String getAlbum_1000_1000() {
        return album_1000_1000;
    }

    public void setAlbum_1000_1000(String album_1000_1000) {
        this.album_1000_1000 = album_1000_1000;
    }
}
