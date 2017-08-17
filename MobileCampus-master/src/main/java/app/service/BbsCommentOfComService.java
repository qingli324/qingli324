package app.service;

import app.Model.BbsComOfComResult;
import app.Model.CommonResult;
import app.entity.BbsComment;
import app.entity.BbsCommentOfCom;
import app.mapper.BbsCommentMapper;
import app.mapper.BbsCommentOfComMapper;
import app.utils.TimeShowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/21.
 * BBS中评论的评论的一些功能实现
 */
@Service
@EnableTransactionManagement
public class BbsCommentOfComService {
    @Autowired
    private BbsCommentOfComMapper bbsCommentOfComMapper;
    @Autowired
    private BbsCommentMapper bbsCommentMapper;
    //返回所有评论的评论，其中增加了时间处理：处理的时间返回名为：time
    //时间一周之外显示日期，一周之内显示星期，昨天，几小时前，几分钟前
    public List<BbsComOfComResult> getAllCommentsOfComByCommentId(Long commentid){
        List<BbsCommentOfCom> results = bbsCommentOfComMapper.getAllCommentsOfComByCommentId(commentid);
        List<BbsComOfComResult> lists = new ArrayList<BbsComOfComResult>();
        BbsComOfComResult e = null;
        TimeShowUtil timeShowUtil = new TimeShowUtil();
        for(BbsCommentOfCom result : results){
            String time = null;
            e = new BbsComOfComResult();
            e.setBbsCommentOfCom(result);
            time = timeShowUtil.getTimePoint(result.getCommenttime().getTime());
            e.setTime(time);
            lists.add(e);
        }
        return lists;
    }
    //根据评论的评论的id删除这条评论的评论,同时对应的评论数减一
    public CommonResult deleteBbsComOfComById(long id, long commentid){
        bbsCommentOfComMapper.deleteBbsCommentById(id);
        bbsCommentMapper.updateCommentnumReduce(commentid);
        return new CommonResult(200,"评论删除成功",null);
    }
    //插入评论的评论,同时，对应的评论数加一
    public CommonResult insertBbsComOfCom(String content,String username,String userhead,
                                         Long commentid,String replyname){
        if ((content == null||"".equals(content))){
            return new CommonResult(500,"评论不能为空",null);
        }else {
            BbsCommentOfCom bbsCommentOfCom = new BbsCommentOfCom();
            bbsCommentOfCom.setCommentid(commentid);
            bbsCommentOfCom.setUserhead(userhead);
            bbsCommentOfCom.setUsername(username);
            bbsCommentOfCom.setContent(content);
            bbsCommentOfCom.setReplyname(replyname);
            Date date = new Date();
            bbsCommentOfCom.setCommenttime(date);
            bbsCommentOfComMapper.insertBbsCommentOfCom(bbsCommentOfCom);
            bbsCommentMapper.updateCommentnumAdd(commentid);
            return new CommonResult(200,"评论成功",null);
        }

    }
}
