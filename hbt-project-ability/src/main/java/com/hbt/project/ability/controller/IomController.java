package com.hbt.project.ability.controller;


import com.hbt.project.ability.domain.bo.UserSvc;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/iom")
@RestController
public class IomController {
    Logger logger = LoggerFactory.getLogger(IomController.class);

    @Autowired
    private KieSession session;

    @Autowired
    private KieBase kieBase;

    @GetMapping("/webservice/{id}")
    public String call(
            @PathVariable String id
    ) {
        UserSvc userSvc = new UserSvc();
        userSvc.setServiceId("50000");
        userSvc.setServiceName("主体服务");



        // 插入
        session.insert(userSvc);
        // 执行规则
        session.fireAllRules();

        return "SUCCESS";
    }
}
