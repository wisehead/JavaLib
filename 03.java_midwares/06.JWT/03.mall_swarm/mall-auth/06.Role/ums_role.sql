#1. ums_role

```sql
-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', '商品管理员', '只能查看及操作商品', '0', '2020-02-03 16:50:37', '1', '0');
INSERT INTO `ums_role` VALUES ('2', '订单管理员', '只能查看及操作订单', '0', '2018-09-30 15:53:45', '1', '0');
INSERT INTO `ums_role` VALUES ('5', '超级管理员', '拥有所有查看和操作功能', '0', '2020-02-02 15:11:05', '1', '0');
```