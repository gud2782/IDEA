package com.likeadog.idea.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskImplementingLogoutHandler implements LogoutHandler {

    Logger logger = LoggerFactory.getLogger(TaskImplementingLogoutHandler.class);
    @Override
    public void logout(HttpServletRequest req, HttpServletResponse res,
                       Authentication authentication) {

        logger.info("로그아웃 되었습니다.");
    }
}