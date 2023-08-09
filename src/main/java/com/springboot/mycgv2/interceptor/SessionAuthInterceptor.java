package com.springboot.mycgv2.interceptor;

import com.springboot.mycgv2.dto.SessionDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Ŭ���̾�Ʈ(������)�� ��û Ȯ�� - ���� ��ü ��������
        HttpSession session = request.getSession();

        //sid Ȯ���ϱ�
        SessionDto svo = (SessionDto) session.getAttribute("svo");
        if(svo == null) {
            //�α��� �ȵǾ� �ִ� �����̹Ƿ� �α��������� ����
            response.sendRedirect("/mycgv_jsp/login.do");
            return false;
        }
        return true;
    }

}
