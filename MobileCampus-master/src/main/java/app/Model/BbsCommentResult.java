package app.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
public class BbsCommentResult {
    private Integer id;

    private Integer commentnum;

    private String content;

    private Date commenttime;

    private String userhead;

    private String username;

    private Integer titleimgid;

    private Integer likenum;
    private String imgurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTitleimgid() {
        return titleimgid;
    }

    public void setTitleimgid(Integer titleimgid) {
        this.titleimgid = titleimgid;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String  imgurl) {
        this.imgurl = imgurl;
    }
}
