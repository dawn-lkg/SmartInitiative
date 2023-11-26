package com.example.project.resource.handle;

import org.springframework.stereotype.Component;

/**
 * @author chenliming
 * @date 2023/11/25 16:44
 */
@Component
public class FileVideoHandle extends FileBaseHandle {

    @Override
    public void execute() {
        System.out.println("视频");
    }
}
