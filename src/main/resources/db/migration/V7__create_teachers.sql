CREATE TABLE `teachers` (
  `id` varchar(36) NOT NULL,
  `is_director` TINYINT(1) NULL DEFAULT 0,
  `school_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`school_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
