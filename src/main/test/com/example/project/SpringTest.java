package com.example.project;

import com.example.project.common.core.web.Server;
import com.example.project.resource.constans.FileInfoConstants;
import com.example.project.resource.factory.FileInfoFactory;
import com.example.project.resource.handle.FileInfoHandle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

import java.net.UnknownHostException;

/**
 * @author chenliming
 * @date 2023/11/16 22:48
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTest {

    @Test
    public void test() throws Exception {
        Server server = new Server();
        server.copyTo();
        System.out.println(server.getCpu());
    }
    @Autowired
    FileInfoFactory fileInfoFactory;
    @Test
    public void test2(){
        FileInfoHandle handle = fileInfoFactory.getHandle(FileInfoConstants.FILE_TYPE_VIDEO);
        handle.execute();
    }
}
