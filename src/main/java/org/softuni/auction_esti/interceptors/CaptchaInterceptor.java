package org.softuni.auction_esti.interceptors;

import org.softuni.auction_esti.config.NoCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Component
public class CaptchaInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equals("POST")) {


            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getMethod().isAnnotationPresent(NoCaptcha.class)) {
                return  true;
            }


            String sum = request.getParameter("sum");
            if (sum == null || sum.isEmpty()) {
// TODO: 2019-03-18 EXCEPTION
                return false;
            }
            long sumNUmber = Long.parseLong(sum);

            //tr da gi izvadim ot session
            Long num1 = (long) request.getSession().getAttribute("num1");
            Long num2 = (long) request.getSession().getAttribute("num2");


            if (num1 == null || num2 == null) {
                return false;
            }
            if (sumNUmber != (num1 + num2)) {
                return false;
            }
        }

        Long num1 = Long.valueOf(new Random().nextInt());
        Long num2 = Long.valueOf(new Random().nextInt());

        //dob kum attr, za da mogat da se rendirat
        // i session-a, za da mogat da se izpolzvat i v slev6tiq
        //req ako e post

        request.getSession().setAttribute("num1", num1);
        request.getSession().setAttribute("num2", num2);

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//tochno predi da se renderira 6te my gi dabavim da gi ima
        if (request.getMethod().equals("GET") && modelAndView != null) {
            modelAndView.addObject("num1", request.getSession().getAttribute("num1"));
            modelAndView.addObject("num2", request.getSession().getAttribute("num2"));
        }
        // super.postHandle(request, response, handler, modelAndView);
    }
}

