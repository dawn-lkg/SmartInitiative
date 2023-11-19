package com.example.project.common.core;

/**
 * @author chenliming
 * @date 2023/8/6 0:47
 */
public class Constants {
    /**
     * 默认成功码
     */
    public static final int RESULT_OK_CODE=0;

    /**
     * 默认失败码
     */
    public static final int RESULT_ERROR_CODE=1;
    /**
     * 默认成功信息
     */
    public static final String RESULT_OK_MSG="操作成功";
    /**
     * 默认失败信息
     */
    public static final String RESULT_ERROR_MSG="操作失败";
    /**
     * token通过header传递的名称
     */
    public static final String TOKEN_HEADER_NAME = "Authorization";
    /**
     * 无权限错误码
     */
    public static final int UNAUTHORIZED_CODE = 403;
    /**
     * 无权限提示信息
     */
    public static final String UNAUTHORIZED_MSG = "没有访问权限";
    /**
     * token通过参数传递的名称
     */
    public static final String TOKEN_PARAM_NAME = "access_token";

    /**
     * token认证类型
     */
    public static final String TOKEN_TYPE = "Bearer";

    /**
     * 没有当前用户
     */
    public static final String USER_NOT_FOUND_ERROR_MSG = "没有当前用户";

    /**
     * 顶级菜单
     */
    public static final String TOP_LEVEL_MENU="";
    /**
     * 菜单类型 目录
     */
    public static final String MENU_TYPE_CATALOGUE="2";
    /**
     * 菜单类型 菜单
     */
    public static final String MENU_TYPE_MENU="0";

    /**
     * 菜单类型 权限
     */
    public static final String MENU_TYPE_PERMISSION="1";

    /**
     * 组件类型 自己
     */
    public static final String COMPONENT_SELF="self";

    /**
     * 组件类型 基础
     */
    public static final String COMPONENT_BASIC="basic";
    /**
     * 组件类型 空白
     */
    public static final String COMPONENT_BLANK="blank";
    /**
     * 是否单页面 是
     */
    public static final String SINGLE_RIGHT="0";
    /**
     * 是否单页面 不是
     */
    public static final String SINGLE_NOT="1";
    /**
     * 是否隐藏 隐藏
     */
    public static final String HIDE="1";
    /**
     * 没有登录提示
     */
    public static final String NEED_LOGIN="请先登录";
    /**
     * 系统日志 正常
     */
    public static final String SYSTEM_RECORD_SUCCESS="0";
    /**
     * 系统日志 失败
     */
    public static final String SYSTEM_RECORD_FAIL="1";
    /**
     * 删除状态 正常
     */
    public static final String REMOVE_NORMAL="0";
    /**
     * 请求类型 post
     */
    public static final String REQUEST_TYPE_POST="POST";
    /**
     * 请求类型 GET
     */
    public static final String REQUEST_TYPE_GET="GET";

    /**
     * 操作类型 正常操作
     */
    public static final String OPERATOR_TYPE_NORMAL="0";
    /**
     * 操作类型 登录操作
     */
    public static final String OPERATOR_TYPE_LOGIN="1";

}
