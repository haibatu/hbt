package com.hbt.project.ability.service;

import com.hbt.project.ability.domain.bo.UserSvc;

public interface DroolsEngineService {

    public void executeAddRule(UserSvc param);

    public void executeRemoveRule(UserSvc param);
}
