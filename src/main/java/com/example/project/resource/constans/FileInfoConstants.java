package com.example.project.resource.constans;

/**
 * @author chenliming
 * @date 2023/10/29 12:41
 */
public class FileInfoConstants {
    /**
     * 目录类型 0文件
     */
    public static final int FILE=0;
    /**
     * 目录类型 1目录
     */
    public static final int DIRECTORY=1;
    /**
     * 文件类型 视频
     */
    public static final int FILE_TYPE_VIDEO=1;
    /**
     * 文件类型 音频
     */
    public static final int FILE_TYPE_AUDIO=2;
    /**
     * 文件类型 图片
     */
    public static final int FILE_TYPE_IMG=3;
    /**
     * 文件类型 pdf
     */
    public static final int FILE_TYPE_PDF=4;
    /**
     * 文件类型 doc
     */
    public static final int FILE_TYPE_DOC=5;
    /**
     * 文件类型 excel
     */
    public static final int FILE_TYPE_EXCEL=6;
    /**
     * 文件类型 文本
     */
    public static final int FILE_TYPE_TXT=7;
    /**
     * 文件类型 代码
     */
    public static final int FILE_TYPE_CODE=8;
    /**
     * 文件类型 压缩文件
     */
    public static final int FILE_TYPE_ZIP=9;
    /**
     * 文件类型 其他
     */
    public static final int FILE_TYPE_OTHER=10;
    /**
     * 文件删除状态 回收站
     */
    public static final int RECYCLE_STATUS=2;
    /**
     * 文件类别 文档
     */
    public static final int FILE_CATEGORY_DOCUMENT=4;
    /**
     *
     */
    public static final int FILE_CATEGORY_OTHER=5;
    /**
     * 获取文件类别
     * @param value
     * @return
     */
    public static final int getFileCategory(int value){
        if(FileInfoConstants.FILE_TYPE_VIDEO==value){
            return FileInfoConstants.FILE_TYPE_VIDEO;
        }else if(FILE_TYPE_AUDIO==value){
            return FILE_TYPE_AUDIO;
        }else if(FILE_TYPE_IMG==value){
            return FILE_TYPE_IMG;
        }else if(FILE_TYPE_DOC==value){
            return FILE_CATEGORY_DOCUMENT;
        }else{
            return FILE_CATEGORY_OTHER;
        }
    }
}
