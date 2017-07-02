package app.mapper;

import app.entity.BbsComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
public interface BbsCommentMapper {
    @Select("select * from bbs_comment where topicid = #{topicid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "userhead",column = "userhead"),
            @Result(property = "topicid",column = "topicid"),
            @Result(property = "commenttime",column = "commenttime"),
            @Result(property = "content",column = "content"),
            @Result(property = "commentnum",column = "commentnum"),
            @Result(property = "likenum",column = "likenum"),
            @Result(property = "imgsurl", column = "imgsurl")
    })
    List<BbsComment> getAllCommentsBytitleImgId(Long topicid);

//    @Insert("insert into bbs_comment(username,userhead,titleimgid,commenttime,content,imgsurl) " +
//            "values (#{username},#{userhead},#{titleimgid},now(),#{content},#{imgsurl})")
//    void insertBbsComment(BbsComment bbsComment);
@Insert("insert into bbs_comment(username,userhead,topicid,commenttime,content,imgsurl) " +
        "values (#{username},#{userhead},#{topicid},#{commenttime},#{content},#{imgsurl})")
void insertBbsComment(BbsComment bbsComment);
}
