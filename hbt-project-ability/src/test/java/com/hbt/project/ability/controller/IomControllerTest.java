package com.hbt.project.ability.controller;

import com.hbt.project.ability.domain.bo.UserSvc;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IomControllerTest {

    @Autowired
    private KieSession session;

    @Autowired
    private KieBase kieBase;


    @Test
    public void iomTest() {

        UserSvc userSvc = new UserSvc();
        assertNull(userSvc);
        userSvc.setServiceId("50000");

        // 插入
        session.insert(userSvc);
        // 执行规则
        session.fireAllRules();


    }



    @AfterEach
    public void runDispose() {
        session.dispose();

    }
}