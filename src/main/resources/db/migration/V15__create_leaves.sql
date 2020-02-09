CREATE TABLE `leaves` (
  `id` varchar(36) NOT NULL,
  `modification_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  `student_id` varchar(36) DEFAULT NULL,
  `subject_id` varchar(36) DEFAULT NULL,
  `teacher_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`student_id`),
  KEY (`subject_id`),
  KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
