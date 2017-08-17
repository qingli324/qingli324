package MapperTest;

import app.BootApplication;
import app.Model.BbsCommentResult;
import app.entity.BbsComment;
import app.mapper.BbsCommentMapper;
import app.service.BbsCommentService;
import app.utils.TimeShowUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/7/15.
 */
@SpringBootTest(classes = BootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BbsCommentsTest {
    @Autowired
    private BbsCommentMapper bbsCommentMapper;

    @Test
    public void insertBbsComment_Mapper(){
        BbsComment bbsComment = new BbsComment();
        bbsComment.setContent("感冒了，难受");
        bbsComment.setUsername("李青");
        bbsComment.setTopicid((long)1);
        Date date = new Date();
        bbsComment.setCommenttime(date);
        bbsCommentMapper.insertBbsComment(bbsComment);
    }
    @Test
    public void updateLikenumAdd(){
        bbsCommentMapper.updateLikenumReduce(2);
    }
}
