package app.controller;

import app.entity.BbsTopic;
import app.service.BbsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 青离 on 2017/6/13.
 */
@RestController
@RequestMapping(value = "/bbs")
public class BbsTopicController {
    @Autowired
    BbsTopicService bbsTopicService;
    BbsTopic bbsTopic = new BbsTopic();
    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public BbsTopic getBbsTopic(@RequestParam(value="id" ,required = false, defaultValue = "1") Long id){
        bbsTopic = bbsTopicService.getBbsTopic(id);
        return bbsTopic;
    }
}
