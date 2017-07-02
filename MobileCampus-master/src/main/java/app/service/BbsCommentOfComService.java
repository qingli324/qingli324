package app.service;

import app.entity.BbsCommentOfCom;
import app.mapper.BbsCommentOfComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 青离 on 2017/6/21.
 */
@Service
public class BbsCommentOfComService {
    @Autowired
    private BbsCommentOfComMapper bbsCommentOfComMapper;

    public List<BbsCommentOfCom> getAllCommentsOfComByCommentId(Long commentid){
        List<BbsCommentOfCom> lists = bbsCommentOfComMapper.getAllCommentsOfComByCommentId(commentid);
        return lists;
    }
}
