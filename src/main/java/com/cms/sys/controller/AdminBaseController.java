package com.cms.sys.controller;

import com.cms.core.controller.BaseController;
import com.cms.core.shiro.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminBaseController
        extends BaseController {

    public MyShiroRealm.ShiroUser getCurrentUser() {
        return (MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    public String getCurrentUserId() {
        return ((MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal()).getId();
    }
}