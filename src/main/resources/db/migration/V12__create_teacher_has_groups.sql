CREATE TABLE `teacher_has_groups` (
  `teacher_id` varchar(36) NOT NULL,
  `group_id` varchar(36) NOT NULL,
  PRIMARY KEY (`teacher_id`,`group_id`),
  KEY (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
