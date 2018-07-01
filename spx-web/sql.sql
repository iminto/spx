CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'name',
  `password` varchar(60) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `salt` varchar(16) DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(64) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号',
  `reg_time` int(11) NOT NULL COMMENT '注册时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `address` varchar(100) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
