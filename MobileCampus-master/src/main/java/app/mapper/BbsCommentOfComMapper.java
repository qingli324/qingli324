package app.mapper;

import app.entity.BbsComment;
import app.entity.BbsCommentOfCom;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/21.
 */
public interface BbsCommentOfComMapper {
    @Select("select * from bbs_comment_of_com where commentid = #{commentid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "userhead",column = "userhead"),
            @Result(property = "commenttime",column = "commenttime"),
            @Result(property = "content",column = "content"),
            @Result(property = "commentid",column = "commentid"),
            @Result(property = "replyid",column = "replyid"),
    })
    List<BbsCommentOfCom> getAllCommentsOfComByCommentId(Long commentid);
}
