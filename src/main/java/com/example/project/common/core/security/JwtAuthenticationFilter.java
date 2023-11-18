package com.example.project.common.core.security;

import cn.hutool.core.util.StrUtil;
import com.example.project.common.core.Constants;
import com.example.project.common.core.exception.BusinessException;
import com.example.project.common.core.utils.*;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.entity.Menu;
import com.example.project.common.system.entity.User;
import com.example.project.common.system.service.MenuService;
import com.example.project.common.system.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chenliming
 * @date 2023/8/6 22:22
 */
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;
    @Autowired
    RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=JwtUtil.getAccessToken(request);
        if(StrUtil.isNotBlank(token)){
            try {
                Claims claims = JwtUtil.parseJWT(token);
                String userId = claims.getSubject();
                User user;
                user =redisCache.getCacheObject("loginUser:" + userId);
                if(Objects.isNull(user)){
                    user= userService.getById(userId);
                    List<String> menuTypeList = new ArrayList<>();
                    menuTypeList.add(Constants.MENU_TYPE_PERMISSION);
                    List<Menu> authorities = menuService.listMenuByUserId(userId, menuTypeList);
                    user.setAuthorities(authorities);
                }
                if(Objects.isNull(user)){
                    throw new BusinessException(Constants.USER_NOT_FOUND_ERROR_MSG);
                }

                UsernamePasswordAuthenticationToken usernamePasswordCredentials = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordCredentials);
            } catch (Exception e) {
                log.error(e.getMessage());
                Result<Object> objectResult = new Result<>(Constants.RESULT_ERROR_CODE,Constants.NEED_LOGIN);
                WebUtils.renderString(response, JSONUtil.toJSONString(objectResult));
                return;
            }
        }

        filterChain.doFilter(request,response);
    }
}
