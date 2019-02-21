package com.cms.sys.controller;

import com.cms.core.utils.IpGet;
import com.cms.sys.entity.SysLogEntity;
import com.cms.sys.entity.SysLogLoginEntity;
import com.cms.sys.service.SysLogLoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminLoginController
        extends AdminBaseController {
    @Resource
    SysLogLoginService sysLogLoginService;

    @RequestMapping(value = "/login", name = "访问登陆页面")
    public String login() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated() || currentUser.isRemembered()) {
            return "redirect:/admin/main";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, name = "执行登陆操作")
    /*@RequestLimit(count=2,time=60000) 请求限制demo*/
    public String fail(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Map param = new HashMap();
        param.put("IPAddress", IpGet.getIpAddress(request));
        if(getCurrentUser() != null){
            SysLogLoginEntity sysLogLoginEntity = new SysLogLoginEntity();
            sysLogLoginEntity.setRemark("登录成功");
            sysLogLoginEntity.setUsercode(getCurrentUser().getAccount());
            sysLogLoginEntity.setUsername(getCurrentUser().getRealName());
            sysLogLoginEntity.setLoginstatus(1);
            sysLogLoginService.saveLoginLog(sysLogLoginEntity);
            //重定向
            return "redirect:/admin/main";
        }
        String message;
        String loginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (loginFailure != null) {
            switch (loginFailure){
                case "org.apache.shiro.authc.pam.UnsupportedTokenException":
                    message = "验证码错误!";//验证码错误
                    break;
                case "org.apache.shiro.authc.UnknownAccountException":
                    message = "用户名或密码错误!";//用户名或密码错误
                    break;
                case "org.apache.shiro.authc.DisabledAccountException":
                    message = "该帐号已被禁用，请联系系统管理员";//此账号已被禁用
                    break;
                case "org.apache.shiro.authc.LockedAccountException":
                    message = "此账号密码输入错误已达5次被锁定，30分钟后解锁!";//此账号密码输入错误已达5次被锁定，30分钟后解锁
                    break;
                case "org.apache.shiro.authc.AuthenticationException":
                    message = "账号认证失败!";//账号认证失败
                    break;
                case "org.apache.shiro.authc.IncorrectCredentialsException":
                    message = "密码错误";//错误
                    break;
                default:
                    message = "鉴权失败";
                    break;
            }
            String loginAccount = request.getParameter(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
            if (StringUtils.isEmpty(loginAccount)){
                loginAccount="登录时账号为空";
            }

            SysLogLoginEntity sysLogLoginEntity = new SysLogLoginEntity();

            sysLogLoginEntity.setRemark("登录失败");
            sysLogLoginEntity.setUsercode(loginAccount);
            sysLogLoginEntity.setLoginstatus(0);

            sysLogLoginService.saveLoginLog(sysLogLoginEntity);
            if(!message.isEmpty())redirectAttributes.addFlashAttribute("message", message);
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/main", name = "首页")
    public String home(Model model){
        return "main";
    }

    @RequestMapping(value = "/logout", name = "登出")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/home", name = "加载系统菜单")
    public String home(HttpServletRequest req) {
        return "sys/home/index";
    }
}
