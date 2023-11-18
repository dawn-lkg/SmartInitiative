package com.example.project.common.core.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import java.io.File;
import java.io.IOException;

/**
 * @author chenliming
 * @date 2023/10/30 21:11
 */
public class ImageUtil {
    public static final double DEFAULT_SCALE = 0.8d;
    public static final String SUFFIX = "-thumbnail";


    public static String appendSuffix(String fileName,String suffix){
        String newFilename="";
        int lastDot=fileName.lastIndexOf(".");
        if(lastDot!=-1){
            newFilename+=fileName.substring(0,lastDot)+suffix+fileName.substring(lastDot);
        }else{
            newFilename=fileName+suffix;
        }
        return newFilename;
    }

    /**
     * 根据文件扩展名判断文件是否图片格式
     * @param extension 文件扩展名
     * @return
     */
    public static boolean isImage(String extension){
        String[] imageExtension=new String[]{"jpg","jpg","gif","bmp","png"};
        for (String e:imageExtension){
            if(extension.equals(e)){
                return true;
            }
        }
        return false;
    }

    public static String createThumbnail(String pathname,double scale,File file) throws IOException {
        String name=appendSuffix(file.getName(),SUFFIX);
        Thumbnails.of(file)
                .scale(scale)
                .toFile(new File(pathname,name));
        return name;
    }
}
