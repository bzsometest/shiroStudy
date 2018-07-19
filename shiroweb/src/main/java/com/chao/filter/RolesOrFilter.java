package com.chao.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RolesOrFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] roles = (String[]) mappedValue;
        if (roles == null || roles.length == 0) {//当前页面不需要任何角色
            return true;
        }
        for (String role : roles) {
            if (subject.hasRole(role)) {//用户有这个角色
                return true;
            }
        }
        return false;
    }
}
