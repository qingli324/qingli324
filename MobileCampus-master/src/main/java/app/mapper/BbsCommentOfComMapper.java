package app.mapper;

import app.entity.BbsComment;
import app.entity.BbsCommentOfCom;
import org.apache.ibatis.annotations.*;

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
            @Result(property = "replyname",column = "replyname"),
    })
    List<BbsCommentOfCom> getAllCommentsOfComByCommentId(Long commentid);

    //插入一条评论的评论，对应的评论数加一
    @Insert("insert into bbs_comment_of_com(username,userhead,commentid,commenttime,content,replyname) " +
            "values (#{username},#{userhead},#{commentid},#{commenttime},#{content},#{replyname})")
    void insertBbsCommentOfCom (BbsCommentOfCom bbsCommentOfCom);

    //删除一条评论的评论，对应的评论数减一
    @Delete("delete from bbs_comment_of_com where id=#{id}")
    void deleteBbsCommentById(long id);
}

