package com.hmall.order.interceptors;

import com.hmall.order.utils.JwtUtil;
import com.hmall.order.utils.UserThrealLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class MvcHandleInterceptor implements HandlerInterceptor {
    /**
     * 执行前拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    private static ThreadLocal<Map> threadLocal = new ThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.从请求头对象中获取值
        String authorization = request.getHeader("authorization");
        if (StringUtils.isEmpty(authorization)) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", 5);
            threadLocal.set(map);
            log.warn("非法用户访问！请求路径：{}", request.getRequestURI());
            //如果为空，表示非法登录
            //response.setStatus(HttpStatus.SC_FORBIDDEN);
            //return false;
            return true;
        }
        Map<String, Object> dataMap = JwtUtil.parse(authorization);
        //2.存入ThreadLocal中
        threadLocal.set(dataMap);
        //放行
        return true;
    }

    /**
     * 执行后拦截
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        threadLocal.remove();
    }

    public Map get() {
        return threadLocal.get();
    }

    public <T> T get(String key) {
        Map map = get();
        return (T) map.get(key);
    }
}
