package app.service;

import app.Model.BbsCommentResult;
import app.Model.CommonResult;
import app.entity.BbsComment;
import app.mapper.BbsCommentMapper;

//import net.sf.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
@Service
public class BbsCommentService {
    @Autowired
    private BbsCommentMapper bbsCommentMapper;

    public List<BbsComment> getBbsCommentsByTitleImgId(Long topicid){
        List<BbsComment> lists = bbsCommentMapper.getAllCommentsBytitleImgId(topicid);
       return lists;
    }

    public CommonResult insertBbsComment(String content,String username,String userhead,
                                         Long topicid,String imgsurl){

        if ((content == null||"".equals(content))&&
                (imgsurl == null || "".equals(imgsurl))){
            return new CommonResult(500,"评论或评论图片不能同时为空",null);
        }else {
                BbsComment bbsComment = new BbsComment();
                bbsComment.setTopicid(topicid);
                bbsComment.setUserhead(userhead);
                bbsComment.setUsername(username);
                bbsComment.setContent(content);
                bbsComment.setImgsurl(imgsurl);
                Date date = new Date();
                long  seconds = date.getTime();
                //2、装箱： 将获得原始的毫秒数据，按照java.sql.Date形式组装
                java.sql.Date sqlDate = new java.sql.Date(seconds);
                bbsComment.setCommenttime(sqlDate);
                bbsCommentMapper.insertBbsComment(bbsComment);

                return new CommonResult(200,"BBS评论成功",null);

        }

    }



}
