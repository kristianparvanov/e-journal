CREATE TABLE `schedules` (
  `id` varchar(36) NOT NULL,
  `from_date` date DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
