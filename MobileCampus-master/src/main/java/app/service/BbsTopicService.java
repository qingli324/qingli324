package app.service;

import app.entity.BbsTopic;
import app.mapper.BbsTopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by 青离 on 2017/6/13.
 */
@Service
public class BbsTopicService {
    @Autowired
    BbsTopicMapper bbsTopicMapper;
    BbsTopic bbsTopic = new BbsTopic();
    public BbsTopic getBbsTopic(Long id){
        bbsTopic = bbsTopicMapper.getImgUrlById(id);
        return bbsTopic;
    }
}
