package app.controller;

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
    public List<BbsCommentOfCom> getAllCommentsOfComByCommentId(@RequestParam(value="commentid")Long commentid){
        return bbsCommentOfComService.getAllCommentsOfComByCommentId(commentid);
    }

}
