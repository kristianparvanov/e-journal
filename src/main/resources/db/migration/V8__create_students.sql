CREATE TABLE `students` (
  `id` varchar(36) NOT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `school_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`group_id`),
  KEY (`school_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
