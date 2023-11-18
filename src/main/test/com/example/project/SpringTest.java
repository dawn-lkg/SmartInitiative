package com.example.project;

import com.example.project.common.core.web.Server;
import org.junit.jupiter.api.Test;
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
}
