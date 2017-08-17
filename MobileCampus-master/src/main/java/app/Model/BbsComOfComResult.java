package app.Model;

import app.entity.BbsCommentOfCom;

/**
 * Created by 青离 on 2017/7/20.
 */
public class BbsComOfComResult {
    private BbsCommentOfCom bbsCommentOfCom;
    private String time;

    public BbsCommentOfCom getBbsCommentOfCom() {
        return bbsCommentOfCom;
    }

    public void setBbsCommentOfCom(BbsCommentOfCom bbsCommentOfCom) {
        this.bbsCommentOfCom = bbsCommentOfCom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
