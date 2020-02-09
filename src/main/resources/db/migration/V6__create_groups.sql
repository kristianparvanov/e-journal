CREATE TABLE `groups` (
  `id` varchar(36) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `school_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`school_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
