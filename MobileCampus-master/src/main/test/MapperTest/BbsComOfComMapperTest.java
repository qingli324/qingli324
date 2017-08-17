package MapperTest;

import app.BootApplication;
import app.entity.BbsCommentOfCom;
import app.mapper.BbsCommentMapper;
import app.mapper.BbsCommentOfComMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

/**
 * Created by 青离 on 2017/7/15.
 */
@EnableTransactionManagement
@SpringBootTest(classes = BootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BbsComOfComMapperTest {
    @Autowired
    private BbsCommentOfComMapper bbsCommentOfComMapper;
    @Autowired
    private BbsCommentMapper bbsCommentMapper;

    @Test
    public void insertBbsCommentOfCom(){
        BbsCommentOfCom commentOfCom = new BbsCommentOfCom();
        commentOfCom.setReplyname("青霞");
        commentOfCom.setUsername("王一顺");
        commentOfCom.setCommentid((long)1);
        commentOfCom.setContent("我是编程一哥");
        Date date = new Date();
        commentOfCom.setCommenttime(date);
        bbsCommentOfComMapper.insertBbsCommentOfCom(commentOfCom);
        bbsCommentMapper.updateCommentnumAdd((long)1);
    }

}
