/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : localhost:3306
 Source Schema         : my_blog

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 23/09/2023 10:37:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章标题',
  `category_id` int(20) NULL DEFAULT NULL COMMENT '分类id',
  `summary` varchar(140) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章摘要',
  `cover` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '封面图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '文章内容',
  `view_count` int(10) NULL DEFAULT 0 COMMENT '文章预览量',
  `comment_count` int(10) NULL DEFAULT 0 COMMENT '评论数量',
  `sort` tinyint(1) NULL DEFAULT NULL COMMENT '文章排序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '状态（0已发布，1草稿）',
  `is_comment` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否允许评论（0允许，1不允许）',
  `is_recommend` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '是否推荐（0推荐，1不推荐）',
  `public_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `create_by` int(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES (1, 'title', NULL, NULL, NULL, NULL, 0, NULL, NULL, '0', '0', '1', '2023-09-17 14:39:27', NULL, '2023-09-17 14:39:27', '2023-09-17 14:50:18', 0);

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_by` int(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES (1, 'java', 1, 1, '2023-09-18 21:26:56', '2023-09-18 21:27:02', 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int(20) NULL DEFAULT 0 COMMENT '父ID',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单组件地址',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单状态 正常 1停用',
  `menu_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单类型 0菜单 1按钮',
  `sort` int(64) NULL DEFAULT NULL COMMENT '排序',
  `authority` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单图标',
  `hide` int(1) NULL DEFAULT 0 COMMENT '是否隐藏 0否 1是',
  `meta` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路由元信息',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '是否删除 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, '/system/', NULL, '0', '0', 1, 'system:dept', 'email', 0, '', 1, '2023-08-05 23:09:13', '2023-09-23 10:32:29', 0);
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, '/system/user', '/system/user', '1', '0', 1, 'menu1', 'peoples', 0, NULL, 1, '2023-08-12 20:01:28', '2023-09-23 10:25:06', 0);
INSERT INTO `sys_menu` VALUES (3, '角色管理', 1, '/system/roles', '/system/roles', '1', '0', 2, 'menu2', 'component', 0, NULL, 1, '2023-08-12 20:01:28', '2023-09-23 10:25:08', 0);
INSERT INTO `sys_menu` VALUES (4, '菜单管理', 1, '/system/menu', '/system/menu', '1', '0', 1, 'submenu1', 'education', 0, NULL, 1, '2023-08-12 20:01:28', '2023-09-23 10:25:11', 0);
INSERT INTO `sys_menu` VALUES (5, 'Submenu 2', 1, '/submenu2', '/system/user', '1', '0', 2, 'submenu2', 'component', 0, NULL, 1, '2023-08-12 20:01:28', '2023-09-11 23:33:06', 1);
INSERT INTO `sys_menu` VALUES (6, 'Menu 1', 0, '/menu1-1', '/system/user', '1', '0', 1, 'menu1_authority', 'icon-menu1', 0, 'meta-menu1', 1, '2023-08-19 20:31:07', '2023-09-10 20:14:04', 1);
INSERT INTO `sys_menu` VALUES (7, 'Menu 2', 0, '/menu3', '/system/roles', '1', '0', 2, 'menu2_authority', 'icon-menu2', 0, 'meta-menu2', 1, '2023-08-19 20:31:07', '2023-09-11 23:29:46', 1);
INSERT INTO `sys_menu` VALUES (8, 'Button 1', 1, '/menu1/button1', '/system/user', '1', '1', 1, 'button1_authority', 'icon-button1', 0, 'meta-button1', 1, '2023-08-19 20:31:07', '2023-09-11 23:33:03', 1);
INSERT INTO `sys_menu` VALUES (9, 'Button 2', 1, '/menu1/button2', '/system/user', '1', '1', 2, 'button2_authority', 'icon-button2', 0, 'meta-button2', 1, '2023-08-19 20:31:07', '2023-09-11 23:33:01', 1);
INSERT INTO `sys_menu` VALUES (10, 'Button 19', 2, '/menu2/button19', '/system/user', '1', '1', 19, 'button19_authority', 'icon-button19', 0, 'meta-button19', 1, '2023-08-19 20:31:07', '2023-09-11 23:33:11', 1);
INSERT INTO `sys_menu` VALUES (11, 'Button 20', 2, '/menu2/button20', '/system/user', '1', '1', 20, 'button20_authority', 'icon-button20', 0, 'meta-button20', 1, '2023-08-19 20:31:07', '2023-09-11 23:33:13', 1);
INSERT INTO `sys_menu` VALUES (12, 'button21', 6, '/menu2/button20', '/system/user', '1', '1', 12, 'button21authority', 'icon-button20', 0, NULL, 1, '2023-08-22 22:25:55', '2023-09-10 20:14:02', 1);
INSERT INTO `sys_menu` VALUES (13, 'Menu2', 7, '/button1', NULL, NULL, '0', 2, NULL, NULL, 0, NULL, 1, '2023-09-10 21:03:04', '2023-09-11 23:29:44', 1);
INSERT INTO `sys_menu` VALUES (14, 'test', 0, '/test', NULL, '0', '0', 2, NULL, NULL, 0, NULL, 1, '2023-09-10 22:00:41', '2023-09-11 23:29:37', 1);
INSERT INTO `sys_menu` VALUES (15, 'test', 14, '/test1/index', '/test1/index', '0', '0', 2, NULL, NULL, 0, NULL, 1, '2023-09-10 21:17:40', '2023-09-11 23:29:35', 1);
INSERT INTO `sys_menu` VALUES (17, 'list', 14, '/test1/list/index', '/test1/list/index', '0', '0', 3, NULL, NULL, 0, NULL, 1, '2023-09-10 21:56:45', '2023-09-11 23:29:23', 1);
INSERT INTO `sys_menu` VALUES (18, 'button2', 15, NULL, NULL, NULL, '1', 2, 'system:user', NULL, 0, NULL, NULL, '2023-09-11 22:03:26', '2023-09-11 23:29:29', 1);
INSERT INTO `sys_menu` VALUES (19, '博客', 0, '/blog', '', NULL, '0', 2, NULL, 'example', 0, NULL, NULL, '2023-09-11 22:05:40', '2023-09-17 15:04:29', 0);
INSERT INTO `sys_menu` VALUES (20, 'test3', 15, '/test3', NULL, NULL, '0', 4, NULL, NULL, 0, NULL, NULL, '2023-09-11 22:50:07', '2023-09-11 23:29:31', 1);
INSERT INTO `sys_menu` VALUES (21, 'system_menu', 19, '/blog/index', '/blog/index', NULL, '0', 3, NULL, NULL, 0, NULL, NULL, '2023-09-11 23:31:10', '2023-09-23 09:51:21', 1);
INSERT INTO `sys_menu` VALUES (22, '测试', 0, '/test2', '/test2', NULL, '0', 3, NULL, 'component', 0, NULL, NULL, '2023-09-13 23:00:00', '2023-09-14 22:25:53', 1);
INSERT INTO `sys_menu` VALUES (23, '博客管理', 19, '/blog/manage/index', '/blog/manage/index', NULL, '0', 2, NULL, 'skill', 0, NULL, NULL, '2023-09-17 15:04:12', '2023-09-23 10:25:38', 0);
INSERT INTO `sys_menu` VALUES (24, '分类管理', 19, '/blog/category/index', '/blog/category/index', NULL, '0', 3, NULL, 'form', 0, NULL, NULL, '2023-09-17 15:07:47', '2023-09-23 10:25:41', 0);
INSERT INTO `sys_menu` VALUES (25, '评论管理', 19, '/blog/comment/index', '/blog/comment/index', NULL, '0', 2, NULL, 'nested', 0, NULL, NULL, '2023-09-17 15:09:42', '2023-09-23 10:25:44', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色权限字符串',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '角色状态 0正常 1停用',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '是否删除 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', '0', '2023-08-12 20:07:58', '2023-09-10 01:35:13', 0);
INSERT INTO `sys_role` VALUES (2, '普通用户', 'user', '0', '2023-08-19 11:51:25', '2023-09-03 11:44:29', 0);
INSERT INTO `sys_role` VALUES (3, '测试2', 'test1', '1', '2023-09-10 02:07:18', '2023-09-10 02:12:00', 0);
INSERT INTO `sys_role` VALUES (4, '测试11', 'test1', '0', '2023-09-10 02:07:46', '2023-09-10 18:11:19', 1);
INSERT INTO `sys_role` VALUES (5, '测试3', 'test3', '0', '2023-09-10 18:09:18', '2023-09-10 18:09:18', 0);
INSERT INTO `sys_role` VALUES (6, '测试3', 'test3', '0', '2023-09-10 18:23:04', '2023-09-10 18:23:04', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1705410803461922819 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1702323985787006977, 3, 2);
INSERT INTO `sys_role_menu` VALUES (1702323985787006978, 3, 3);
INSERT INTO `sys_role_menu` VALUES (1702323985787006979, 3, 19);
INSERT INTO `sys_role_menu` VALUES (1702323985787006981, 3, 1);
INSERT INTO `sys_role_menu` VALUES (1702324079051550721, 6, 19);
INSERT INTO `sys_role_menu` VALUES (1703305264066105346, 1, 1);
INSERT INTO `sys_role_menu` VALUES (1703305264066105347, 1, 2);
INSERT INTO `sys_role_menu` VALUES (1703305264066105348, 1, 3);
INSERT INTO `sys_role_menu` VALUES (1703305264066105349, 1, 4);
INSERT INTO `sys_role_menu` VALUES (1703305264066105350, 1, 19);
INSERT INTO `sys_role_menu` VALUES (1703305264066105351, 1, 23);
INSERT INTO `sys_role_menu` VALUES (1703305264066105352, 1, 24);
INSERT INTO `sys_role_menu` VALUES (1703305264066105353, 1, 25);
INSERT INTO `sys_role_menu` VALUES (1705410765608329218, 2, 4);
INSERT INTO `sys_role_menu` VALUES (1705410765608329219, 2, 1);
INSERT INTO `sys_role_menu` VALUES (1705410803394813954, 5, 25);
INSERT INTO `sys_role_menu` VALUES (1705410803461922818, 5, 19);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名密码',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '账号状态 0正常 1删除',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别 0男 1女',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `user_type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户类型（0管理员 1普通用户）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新成功',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '是否删除 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$2Vi7eL0JViMXtzlm5alfxODr/dHdwyZxnKINDwK8PpDt3NLDew7J6', '管理员', '0', '0', '2360187899@qq.com', '18827574648', '513b9313-4b5c-458c-9d32-c680db2693de.png', '0', 1, '2023-08-05 10:26:01', '2023-09-17 15:05:58', 0);
INSERT INTO `sys_user` VALUES (2, 'user2', 'password2', 'User 2', '0', '0', 'user2@example.com', '1234567890', 'avatar2.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (3, 'user3', 'password3', 'User 3', '0', '1', 'user3@example.com', '1234567890', 'avatar3.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-04 22:59:15', 0);
INSERT INTO `sys_user` VALUES (4, 'user4', 'password4', 'User 4', '0', '0', 'user4@example.com', '1234567890', 'avatar4.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (5, 'user5', 'password5', 'User 5', '1', '0', 'user5@example.com', '1234567890', 'avatar5.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-09 01:32:28', 1);
INSERT INTO `sys_user` VALUES (6, 'user6', 'password6', 'User 6', '0', '1', 'user6@example.com', '1234567890', 'avatar6.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-09 01:33:51', 1);
INSERT INTO `sys_user` VALUES (7, 'user7', 'password7', 'User 7', '0', '0', 'user7@example.com', '1234567890', 'avatar7.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-07 23:54:16', 1);
INSERT INTO `sys_user` VALUES (8, 'user8', 'password8', 'User 8', '0', '0', 'user8@example.com', '1234567890', 'avatar8.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-07 23:53:56', 1);
INSERT INTO `sys_user` VALUES (9, 'user9', 'password9', 'User 9', '0', '0', 'user9@example.com', '1234567890', 'avatar9.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (10, 'user10', 'password10', 'User 10', '0', '1', 'user10@example.com', '1234567890', 'avatar10.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-07 23:54:36', 1);
INSERT INTO `sys_user` VALUES (11, 'user11', 'password11', 'User 11', '0', '0', 'user11@example.com', '1234567890', 'avatar11.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (12, 'user12', 'password12', 'User 12', '0', '1', 'user12@example.com', '1234567890', 'avatar12.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-04 22:59:18', 0);
INSERT INTO `sys_user` VALUES (13, 'user13', 'password13', 'User 13', '0', '0', 'user13@example.com', '1234567890', 'avatar13.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (14, 'user14', 'password14', 'User 14', '0', '0', 'user14@example.com', '1234567890', 'avatar14.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (15, 'user15', 'password15', 'User 15', '0', '1', 'user15@example.com', '1234567890', 'avatar15.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-04 22:59:19', 0);
INSERT INTO `sys_user` VALUES (16, 'user16', 'password16', 'User 16', '0', '0', 'user16@example.com', '1234567890', 'avatar16.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (17, 'user17', 'password17', 'User 17', '0', '0', 'user17@example.com', '1234567890', 'avatar17.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (18, 'user18', 'password18', 'User 18', '0', '1', 'user18@example.com', '1234567890', 'avatar18.jpg', '1', 1, '2023-08-20 22:09:36', '2023-09-04 22:59:20', 0);
INSERT INTO `sys_user` VALUES (19, 'user19', 'password19', 'User 19', '0', '0', 'user19@example.com', '1234567890', 'avatar19.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (20, 'user20', 'password20', 'User 20', '0', '0', 'user20@example.com', '1234567890', 'avatar20.jpg', '1', 1, '2023-08-20 22:09:36', '2023-08-20 22:09:36', 0);
INSERT INTO `sys_user` VALUES (1699801322854182914, 'zhangsan', '$2a$10$XVzD0sDZ9jWP.WY2oPjVpOaGoqTOVx1BOxbkD36F.o5AXQdHp0u8G', '张三', '0', '0', '123@163.com', '12355789', NULL, NULL, NULL, '2023-09-07 23:06:30', '2023-09-07 23:11:44', 0);
INSERT INTO `sys_user` VALUES (1699801579147128834, 'zhangsan', '$2a$10$Nw3ckoef49vhcDTR1knsOeiFOZWz4Ah2Lsla/Dx1nJACAnZaziy9S', '张三', '0', '0', '123@163.com', '12355789', NULL, NULL, NULL, '2023-09-07 23:07:31', '2023-09-07 23:11:45', 0);
INSERT INTO `sys_user` VALUES (1699802013161218049, 'zhangsan', '$2a$10$l2XSU8YYf.JMXePO4xSiKOas06BfYtHSjwBKK09ZYo.IqTyuDfj/.', '张三', '0', '0', '123@163.com', '12355789', NULL, NULL, NULL, '2023-09-07 23:09:15', '2023-09-07 23:11:50', 0);
INSERT INTO `sys_user` VALUES (1700139010438381569, '测试', '$2a$10$UxFNhDRr0N8.wcf7iWnUhO0n/CyF.J84pGJxnxObV8A7nIm8g1kDm', '测试', '0', '0', '123123', '123123', NULL, NULL, NULL, '2023-09-08 21:28:21', '2023-09-08 21:28:21', 0);
INSERT INTO `sys_user` VALUES (1700139067623522305, '测试', '$2a$10$Aj1FP.BhF0L7ifz2185lsu/ts4OCNo5DmE1Cgo8dBNq98nVn9boc6', '测试', '0', '0', '123123', '123123', NULL, NULL, NULL, '2023-09-08 21:28:35', '2023-09-08 21:28:35', 0);
INSERT INTO `sys_user` VALUES (1700150528626311169, 'test123', '$2a$10$/qaiQdRAk2IuIXDRLZxTmexjzs1jJHSb4mpZjqc2EpH2RUVT7BA.K', '测试', '0', '0', '1234@qq.com', '123567', NULL, NULL, NULL, '2023-09-08 22:14:07', '2023-09-14 20:50:15', 0);
INSERT INTO `sys_user` VALUES (1700814452405174273, '测试', '$2a$10$G0nUEihT64H/bIjBbN3lQ.FHodxB6gXnSpYKnBv29.o.kNLTfZu1G', 'test', '0', '1', '123123', '1231231', NULL, NULL, NULL, '2023-09-10 18:12:19', '2023-09-10 18:12:24', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(20) NULL DEFAULT NULL COMMENT '角色ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2, 2);
INSERT INTO `sys_user_role` VALUES (1699802013161218049, 2, 3);
INSERT INTO `sys_user_role` VALUES (1700139010438381569, 1, 4);
INSERT INTO `sys_user_role` VALUES (1700139010438381569, 2, 5);
INSERT INTO `sys_user_role` VALUES (1700139067623522305, 1, 6);
INSERT INTO `sys_user_role` VALUES (2, 2, 8);
INSERT INTO `sys_user_role` VALUES (3, 2, 9);
INSERT INTO `sys_user_role` VALUES (11, 3, 10);
INSERT INTO `sys_user_role` VALUES (14, 3, 12);
INSERT INTO `sys_user_role` VALUES (15, 3, 13);
INSERT INTO `sys_user_role` VALUES (1700814452405174273, 2, 15);
INSERT INTO `sys_user_role` VALUES (1700150528626311169, 2, 17);
INSERT INTO `sys_user_role` VALUES (4, 2, 18);

SET FOREIGN_KEY_CHECKS = 1;
