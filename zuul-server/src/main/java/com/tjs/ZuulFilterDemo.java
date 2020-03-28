package com.tjs;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 可以用作登录拦截
 */
@Component
public class ZuulFilterDemo extends ZuulFilter {
    /**
     * 路由类型
     * 1.pre 路由之前
     * 2.routing 路由之时
     * 3.post 路由之后
     * 4.error 三者中发生错误时
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，数字越小，越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String token = request.getParameter("token");
        //解决中文乱码
        rc.getResponse().setContentType("text/html;charset=UTF-8");
        if (StringUtils.isEmpty(token)) {
            //不进行路由
            rc.setSendZuulResponse(false);
            //设置状态码
            rc.setResponseStatusCode(401);
            //设置返回体
            rc.setResponseBody("无权限访问");
            //自定义键值对
            rc.set("isSuccess",false);
        }else {
            rc.setSendZuulResponse(true);
            rc.setResponseStatusCode(HttpStatus.OK.value());
        }
        return null;
    }
}
