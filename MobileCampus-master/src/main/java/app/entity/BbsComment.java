package app.entity;

import java.util.Date;
/**
 * Created by 青离 on 2017/6/13.
 */
public class BbsComment {
    private Long id;

    private Integer commentnum;

    private String content;

    private Date commenttime;

    private String userhead;

    private String username;

    private Long topicid;

    private Integer likenum;

    private String imgsurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        this.content = content == null ? null : content.trim();
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
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getTopicid() {
        return topicid;
    }

    public void setTopicid(Long topicid) {
        this.topicid = topicid;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public String getImgsurl() {
        return imgsurl;
    }

    public void setImgsurl(String imgsurl) {
        this.imgsurl = imgsurl == null ? null : imgsurl.trim();
    }

}