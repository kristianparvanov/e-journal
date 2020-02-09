CREATE TABLE `marks` (
  `id` varchar(36) NOT NULL,
  `modification_date` date DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `student_id` varchar(36) DEFAULT NULL,
  `subject_id` varchar(36) DEFAULT NULL,
  `teacher_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`student_id`),
  KEY (`subject_id`),
  KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
