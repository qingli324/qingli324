package app.mapper;

import app.entity.BbsTopic;

import org.apache.ibatis.annotations.*;

/*import java.util.List;*/

/**
 * Created by 青离 on 2017/6/13.
 */

public interface BbsTopicMapper {
    @Select("select * from bbs_topic where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "topiccontent",column = "topiccontent"),
            @Result(property = "topicimg",column = "topicimg")
    })
    BbsTopic getImgUrlById(Long id);

  @Insert("insert into bbs_topic (id,topiccontent,topicimg)"+
          "values (#{id},#{topiccontent},#{topicimg})")
  void insert(BbsTopic bbsTopic);
}
