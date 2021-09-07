package com.hbt.project.ability.service.impl;

import com.hbt.project.ability.domain.bo.UserSvc;
import com.hbt.project.ability.service.DroolsEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service

public class DroolsEngineServiceImpl implements DroolsEngineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroolsEngineServiceImpl.class);

    @Override
    public void executeAddRule(UserSvc userSvc) {
        
    }

    @Override
    public void executeRemoveRule(UserSvc param) {

    }
}
