CREATE TABLE `student_has_parents` (
  `student_id` varchar(36) NOT NULL,
  `parent_id` varchar(36) NOT NULL,
  KEY (`parent_id`),
  KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
