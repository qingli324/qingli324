package app.service;

import app.Model.BbsCommentResult;
import app.Model.CommonResult;
import app.entity.BbsComment;
import app.mapper.BbsCommentMapper;

import app.utils.TimeShowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
@Service
public class BbsCommentService {
    @Autowired
    private BbsCommentMapper bbsCommentMapper;

    public List<BbsCommentResult> getBbsCommentsByTitleImgId(Long topicid){
        List<BbsCommentResult> lists = new ArrayList<BbsCommentResult>();
        BbsCommentResult e = null;
        TimeShowUtil timeShowUtil = new TimeShowUtil();
        List<BbsComment> results = bbsCommentMapper.getAllCommentsBytitleImgId(topicid);
        for(BbsComment result : results){
                String time = null;
                e = new BbsCommentResult();
                e.setBbsComment(result);
                time = timeShowUtil.getTimePoint(result.getCommenttime().getTime());
                e.setTime(time);
                lists.add(e);
        }
       return lists;
    }
    public CommonResult deleteBbsCommentById(long id){
            bbsCommentMapper.deleteBbsCommentById(id);
            return new CommonResult(200,"BBS评论删除成功",null);
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
                bbsComment.setCommenttime(date);
                bbsCommentMapper.insertBbsComment(bbsComment);
                return new CommonResult(200,"BBS评论成功",null);
        }

    }

    //点赞数加一
    public CommonResult updateLikenumAdd(long id){
        try{
            bbsCommentMapper.updateLikenumAdd(id);
            return new CommonResult(200,"点赞成功",null);
        }catch (Exception e){
            return new CommonResult(500,"点赞失败",null);
        }

    }

    //点赞数减一
    public CommonResult updateLikenumReduce(long id){
        try{
            bbsCommentMapper.updateLikenumReduce(id);
            return new CommonResult(200,"取消点赞成功",null);
        }catch (Exception e){
            return new CommonResult(500,"取消点赞失败",null);
        }

    }

}
