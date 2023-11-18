package com.example.project.common.core.server;

import cn.hutool.json.JSONObject;
import com.example.project.common.core.web.SocketEntity;
import com.example.project.common.system.service.UserService;
import com.example.project.common.system.service.impl.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 陈黎明
 * @since 2022/10/26 14:08
 */
@Component
@Slf4j
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {

    @Autowired
    UserService userService;

    private Session session;
    /**
     * 用户ID
     */
    private String userId;

    @Autowired
    ServiceInfo serviceInfo;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
    //  注：底下WebSocket是当前类名
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    // 用来存在线连接用户信息
    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<String,Session>();

    /**
     * 链接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId")String userId) {
        try {
            this.session = session;
            this.userId = userId;
            webSockets.add(this);
            sessionPool.put(userId, session);
            sendUserList();
            log.info("【websocket消息】有新的连接，总数为:"+webSockets.size());
        } catch (Exception e) {
        }
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.userId);
            sendUserList();
            log.info("【websocket消息】连接断开，总数为:"+webSockets.size());
        } catch (Exception e) {
        }
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        for(WebSocket webSocket:webSockets){
            try {
                if(this.userId!=webSocket.userId){
                    webSocket.session.getAsyncRemote().sendText(message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.info("【websocket消息】收到客户端消息:"+message);
    }

    /** 发送错误时的处理
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

        log.error("用户错误,原因:"+error.getMessage());
        error.printStackTrace();
    }


    // 此为广播消息
    public void sendAllMessage(String message) {
        log.info("【websocket消息】广播消息:"+message);
        for(WebSocket webSocket : webSockets) {
            try {
                if(webSocket.session.isOpen()) {
                    webSocket.session.getAsyncRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //发送用户列表
    public void sendUserList(){
        List<String> collect = new ArrayList<>();
        for (WebSocket webSocket:webSockets){
            collect.add(webSocket.userId);
        }
        SocketEntity socketEntity=new SocketEntity();
        socketEntity.setUserList(collect);;
        for (WebSocket webSocket:webSockets){
            webSocket.session.getAsyncRemote().sendText(new JSONObject(socketEntity).toString());
        }
    }

    // 此为单点消息
    public void sendOneMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        if (session != null&&session.isOpen()) {
            try {
                log.info("【websocket消息】 单点消息:"+message);
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息(多人)
    public void sendMoreMessage(String[] userIds, String message) {
        for(String userId:userIds) {
            Session session = sessionPool.get(userId);
            if (session != null&&session.isOpen()) {
                try {
                    log.info("【websocket消息】 单点消息:"+message);
                    session.getAsyncRemote().sendText(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
