CREATE TABLE `teachers` (
  `id` varchar(36) NOT NULL,
  `school_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`school_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
