CREATE TABLE `teacher_has_subjects` (
  `teacher_id` varchar(36) NOT NULL,
  `subject_id` varchar(36) NOT NULL,
  KEY (`subject_id`),
  KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
