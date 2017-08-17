package app.controller;

import app.Model.BbsComOfComResult;
import app.Model.CommonResult;
import app.entity.BbsComment;
import app.entity.BbsCommentOfCom;
import app.service.BbsCommentOfComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 青离 on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/bbs")
public class BbsCommentOfComController {
    @Autowired
    private BbsCommentOfComService bbsCommentOfComService;

    @RequestMapping(value = "/comofcom",method = RequestMethod.GET)
    public List<BbsComOfComResult> getAllCommentsOfComByCommentId(@RequestParam(value="commentid")Long commentid){
        return bbsCommentOfComService.getAllCommentsOfComByCommentId(commentid);
    }
    @RequestMapping(value = "/deletecomofcom",method = RequestMethod.GET)
    public CommonResult deleteBbsCommentById(@RequestParam(value="id")Long id,@RequestParam(value="commentid")Long commentid){
        return bbsCommentOfComService.deleteBbsComOfComById(id,commentid);
    }
    @RequestMapping(value = "/insertcomofcom",method = RequestMethod.POST)
    public CommonResult insertBbsComOfCom(@RequestParam(value="content")String content,@RequestParam(value = "username")String username,
                                          @RequestParam(value = "userhead")String userhead,@RequestParam(value = "commentid")Long commentid,
                                          @RequestParam(value = "replyname")String replyname){
        return bbsCommentOfComService.insertBbsComOfCom(content,username,userhead,commentid,replyname);
    }

}
