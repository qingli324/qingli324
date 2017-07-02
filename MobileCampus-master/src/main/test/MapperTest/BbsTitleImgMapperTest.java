package MapperTest;

import app.BootApplication;
import app.entity.BbsComment;
import app.entity.BbsCommentOfCom;
import app.entity.BbsTopic;
import app.mapper.BbsCommentMapper;
import app.mapper.BbsCommentOfComMapper;
import app.mapper.BbsTopicMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by 青离 on 2017/6/13.
 */
@SpringBootTest(classes = BootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BbsTitleImgMapperTest {
    /*@Autowired
    private BbsTopicMapper bbsTitleImgMapper;
    @Autowired
    private BbsCommentMapper bbsCommentMapper;
    @Autowired
    private BbsCommentOfComMapper bbsCommentOfComMapper;
    BbsTopic bbsTitleImg = new BbsTopic();
    String img = null;

    @Test
    public void getImgUrlById(){
        bbsTitleImg = bbsTitleImgMapper.getImgUrlById(1);
        img = bbsTitleImg.getImgUrl();
        System.out.println(img);

    }
    @Test
    public void insertBbsTitleImg(){
        BbsTopic bbsTitleImg = new BbsTopic();
        bbsTitleImg.setId(3);
        bbsTitleImg.setImgUrl("http://192.168.36.136/group1/M00/00/00/wKgkiFk_U7GAHrJaAABGnhpCKEc168.jpg");
        bbsTitleImgMapper.insert(bbsTitleImg);
    }

    @Test
    public void insertBbsComment(){
        BbsComment bbsComment = new BbsComment();
        bbsComment.setContent("我是一名好学生");
        bbsComment.setTitleimgid(1);
        bbsComment.setUsername("杨洋");
        bbsComment.setUserhead("https://ps.ssl.qhimg.com/t016fba19a080d968f5.jpg");
        bbsCommentMapper.insertBbsComment(bbsComment);
    }

    @Test
    public void timeType(){
        Date date = new Date();
        long  seconds = date.getTime();
        //2、装箱： 将获得原始的毫秒数据，按照java.sql.Date形式组装
        java.sql.Date sqlDate = new java.sql.Date(seconds);
        System.out.println("------"+date.getTime());
        System.out.print("-----"+sqlDate);
    }
    @Test
    public void getAllCommentsBytitleImgIdTest(){
        List<BbsComment> lists = bbsCommentMapper.getAllCommentsBytitleImgId(1);


        for(BbsComment list : lists){
            System.out.println(list.getUsername());
            System.out.println(list.getCommenttime());


        }
    }
    @Test
    public void getAllCommentsOfComByCommentId(){
        List <BbsCommentOfCom> lists = bbsCommentOfComMapper.getAllCommentsOfComByCommentId((long) 1);
        for(BbsCommentOfCom list : lists){
            System.out.println(list.getUsername());
            System.out.println(list.getCommenttime());
            System.out.println(list.getCommenttime());


        }
    }

*/
}
