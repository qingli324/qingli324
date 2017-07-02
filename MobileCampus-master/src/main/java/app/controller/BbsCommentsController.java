package app.controller;


import app.Model.CommonResult;
import app.Model.PictureResult;
import app.entity.BbsComment;
import app.service.BbsCommentPicturesService;
import app.service.BbsCommentService;
import app.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
@RestController
@RequestMapping(value = "/bbs")
public class BbsCommentsController {
    @Autowired
    private BbsCommentPicturesService bbsCommentPicturesService;

    @Autowired
    private PictureService pictureService;
    @Autowired
    private BbsCommentService bbsCommentService;
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<BbsComment> getBbsCommentsByTitleImgId(@RequestParam(value="id" ,required = false, defaultValue = "1") Long topicid ){
        List<BbsComment> list =  bbsCommentService.getBbsCommentsByTitleImgId(topicid);
        return list;
    }
    @RequestMapping(value = "/insertcomment", method = RequestMethod.POST)
    public CommonResult insertBbsComment(@RequestParam(value="content")String content,@RequestParam(value = "username")String username,
                                         @RequestParam(value = "userhead")String userhead,@RequestParam(value = "topicid")Long topicid,
                                         @RequestParam(value = "imgsurl",required = false)String imgsurl){
       return bbsCommentService.insertBbsComment(content, username, userhead, topicid, imgsurl);

    }
    @RequestMapping(value = "/picsupload", method = RequestMethod.POST)
    public PictureResult uploadBbsCommentPics(@RequestParam("uploadFile") MultipartFile[] pics){
        return bbsCommentPicturesService.uploadPicture(pics);

    }
}

