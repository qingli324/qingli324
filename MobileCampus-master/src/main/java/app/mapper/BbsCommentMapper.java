package app.mapper;

import app.Model.BbsCommentResult;
import app.entity.BbsComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 青离 on 2017/6/14.
 */
public interface BbsCommentMapper {
    //获取某一期主题的所有评论
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

    //添加一条评论
    @Insert("insert into bbs_comment(username,userhead,topicid,commenttime,content,imgsurl) " +
          "values (#{username},#{userhead},#{topicid},#{commenttime},#{content},#{imgsurl})")
    void insertBbsComment(BbsComment bbsComment);

    //删除一条评论
    @Delete("delete from bbs_comment where id=#{id}")
    void deleteBbsCommentById(long id);

    //插入一条评论的评论时，评论数加一
    @Update("update bbs_comment set commentnum=commentnum+1 where id=#{commentid}")
    void updateCommentnumAdd(long commentid);

    //删除一条评论的评论时，评论数减一
    @Update("update bbs_comment set commentnum=commentnum-1 where id=#{commentid}")
    void updateCommentnumReduce(long commentid);

    //点赞数加一
    @Update("update bbs_comment set likenum=likenum+1 where id=#{id}")
    void updateLikenumAdd(long id);

    //点赞数减一
    @Update("update bbs_comment set likenum=likenum-1 where id=#{id}")
    void updateLikenumReduce(long id);
}
