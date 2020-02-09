CREATE TABLE `user_has_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
