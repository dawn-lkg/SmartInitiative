package com.example.project.resource.factory;

import com.example.project.resource.constans.FileInfoConstants;
import com.example.project.resource.handle.FileImageHandle;
import com.example.project.resource.handle.FileInfoHandle;
import org.springframework.stereotype.Component;

/**
 * @author chenliming
 * @date 2023/11/25 16:24
 */

@Component
public class FileInfoFactory {

    public FileInfoHandle getHandle(int type){
        if (FileInfoConstants.FILE_TYPE_IMG==type){
            return new FileImageHandle();
        }

        return null;
    }
}
