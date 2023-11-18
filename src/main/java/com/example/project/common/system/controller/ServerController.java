package com.example.project.common.system.controller;

import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.core.web.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenliming
 * @date 2023/11/18 12:45
 */

@RestController
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {


    @OperationLog(module = "服务监控",operator = "服务信息")
    @GetMapping
    public Result<Server> getSystemInfo() throws Exception{
        Server server = new Server();
        server.copyTo();
        return success(server);
    }
}
