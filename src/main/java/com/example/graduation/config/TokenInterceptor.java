package com.example.graduation.config;

import com.example.graduation.util.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <h3>graduation</h3>
 * <p>Token验证拦截器</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 11:25
 **/

@Component
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("正在执行前置拦截");

        //异步提交时，浏览器会先发一次OPTIONS请求
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        System.out.println("请求地址"+request.getRequestURI());
        response.setCharacterEncoding("utf-8");
        //获取请求头的token Authorization属性
        String token = request.getHeader("Authorization");
        if(token != null){
            boolean result = JWTUtil.verify(token);
            if(result){
                System.out.println("通过拦截器，token有效");
                return true;
            }
        }
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out = null;
//        try{
//            Result result = ResultFactory.buildFailResult("token认证失败");
//            response.getWriter().append(JsonUtils.toJson(result));
//            System.out.println("认证失败,未通过拦截器");
//        }catch (Exception e){
//            e.printStackTrace();
//            response.sendError(500);
//            return false;
//        }
        System.out.println("已拦截--前置拦截");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
