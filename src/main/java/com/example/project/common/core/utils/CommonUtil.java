package com.example.project.common.core.utils;

import com.example.project.common.core.Constants;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chenliming
 * @date 2023/8/6 16:07
 */
public class CommonUtil {
    /**
     * 支持跨域
     *
     * @param response HttpServletResponse
     */
    public static void addCrossHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", Constants.TOKEN_HEADER_NAME);
    }

    /**
     * 获取文件后缀
     * @param fileName 文件名
     * @return
     */
    public static String getFileExtension(String fileName){
        int lastDotIndex=fileName.lastIndexOf(".");
        if(lastDotIndex>=0){
            return fileName.substring(lastDotIndex+1).toLowerCase();
        }
        return "";
    }
}
