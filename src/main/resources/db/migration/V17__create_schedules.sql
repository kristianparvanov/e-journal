CREATE TABLE `schedules` (
  `id` varchar(36) NOT NULL,
  `term` varchar(6) NOT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
