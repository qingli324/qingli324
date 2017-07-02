package app.entity;

/**
 * Created by 青离 on 2017/6/13.
 */

public class BbsTopic {
    private Long id;

    private String topiccontent;

    private String topicimg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopiccontent() {
        return topiccontent;
    }

    public void setTopiccontent(String topiccontent) {
        this.topiccontent = topiccontent == null ? null : topiccontent.trim();
    }

    public String getTopicimg() {
        return topicimg;
    }

    public void setTopicimg(String topicimg) {
        this.topicimg = topicimg == null ? null : topicimg.trim();
    }
}