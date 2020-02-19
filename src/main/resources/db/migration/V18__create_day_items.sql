CREATE TABLE `day_items` (
  `id` varchar(36) NOT NULL,
  `day_of_week` varchar(10) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `schedule_id` varchar(36) DEFAULT NULL,
  `subject_id` varchar(36) DEFAULT NULL,
  `teacher_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`schedule_id`),
  KEY (`subject_id`),
  KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
