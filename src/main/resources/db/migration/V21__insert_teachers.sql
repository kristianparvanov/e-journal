INSERT INTO `ejournal`.`users` (`id`, `email`, `first_name`, `middle_name`, `last_name`, `username`, `password`)
VALUES
('ccf411b3-4ed9-4689-abe6-a49dd392ef49', 'admin@admin.admin', 'Админ', 'Админов', 'Админов', 'admin', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),

('df1225ad-308b-406e-9299-87357d25b75f', 'ivan@gmail.com', 'Иван', 'Иванов', 'Иванов', 'ivan.ivanov', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', 'georgi@gmail.com', 'Георти', 'Георгиев', 'Георгиев', 'goergi.georgiev', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),

('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'alexandra@gmail.com', 'Александра', 'Александрова', 'Александрова', 'alexandra.alexandrova', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'petya@gmail.com', 'Петя', 'Петьова', 'Петьова', 'petya.petyova', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),

('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', 'todor@gmail.com', 'Тодор', 'Тодоров', 'Тодоров', 'todor.todorov', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', 'misho@gmail.com', 'Мишо', 'Мишев', 'Мишев', 'misho.mishev', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),

('9010478c-9c92-4a27-b569-a0206edd57ec', 'boris@gmail.com', 'Борис', 'Борисов', 'Борисов', 'boris.borisov', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 'ceko@gmail.com', 'Цеко', 'Цеков', 'Цеков', 'ceko.cekov', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),

('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 'stavri@gmail.com', 'Ставри', 'Ставриев', 'Ставриев', 'stavri.stavriev', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', 'rada@gmail.com', 'Рада', 'Радова', 'Радова', 'rada.radova', '$2a$10$h8GW9Ff7oK8I0wuK39XXYenJvbaRNwQYNN8GUnmabmsNqaT3e9DmG');

INSERT INTO `ejournal`.`user_has_roles` (`user_id`, `role_id`)
VALUES
('ccf411b3-4ed9-4689-abe6-a49dd392ef49', 'eaaca79b-cc71-45cc-9faa-2c7ed6ea6927'), -- admin

('df1225ad-308b-406e-9299-87357d25b75f', '2fb145de-92ee-418d-84a0-371c523fd3e9'), -- director
('df1225ad-308b-406e-9299-87357d25b75f', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher

('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '2fb145de-92ee-418d-84a0-371c523fd3e9'), -- director
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher

('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '2fb145de-92ee-418d-84a0-371c523fd3e9'), -- director
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher

('9010478c-9c92-4a27-b569-a0206edd57ec', '2fb145de-92ee-418d-84a0-371c523fd3e9'), -- director
('9010478c-9c92-4a27-b569-a0206edd57ec', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher

('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '2fb145de-92ee-418d-84a0-371c523fd3e9'), -- director
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'), -- teacher
('60dca729-ec40-4e0b-b775-c3e782e78fda', '667b5822-dab3-4fea-ab3d-1b0efb224a8d'); -- teacher

INSERT INTO `ejournal`.`teachers` (`id`, `is_director`, `school_id`)
VALUES
('df1225ad-308b-406e-9299-87357d25b75f', 1, '39a321bb-2575-41d5-bd7b-91d32b07944f'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', 0, '39a321bb-2575-41d5-bd7b-91d32b07944f'),

('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 1, '7346052e-b2a7-4a62-9139-d8f3556ea220'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 0, '7346052e-b2a7-4a62-9139-d8f3556ea220'),

('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', 1, '001c1088-1ae0-4638-aa13-1b54831659f6'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', 0, '001c1088-1ae0-4638-aa13-1b54831659f6'),

('9010478c-9c92-4a27-b569-a0206edd57ec', 1, '77264868-479c-4065-8701-55ee55dba88d'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 0, '77264868-479c-4065-8701-55ee55dba88d'),

('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 1, '9c73d511-af3e-4adc-a5dd-48312613c523'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', 0, '9c73d511-af3e-4adc-a5dd-48312613c523');

INSERT INTO `ejournal`.`teacher_has_groups` (`teacher_id`, `group_id`)
VALUES
('df1225ad-308b-406e-9299-87357d25b75f', '31eb4b61-2ff4-452c-baad-5f4b2202f227'),
('df1225ad-308b-406e-9299-87357d25b75f', 'eb91b738-6afd-436c-89d6-5cef53eac26c'),
('df1225ad-308b-406e-9299-87357d25b75f', '8ae79193-ebf6-4a91-b006-8f49447e3286'),
('df1225ad-308b-406e-9299-87357d25b75f', '3c96d6b7-1e38-4d71-bbdf-a5c50ffb5f86'),
('df1225ad-308b-406e-9299-87357d25b75f', '992125bd-68cc-4048-be18-f0b44b74e18f'),
('df1225ad-308b-406e-9299-87357d25b75f', '7301db36-8d16-4efc-8b61-15d925a2a164'),
('df1225ad-308b-406e-9299-87357d25b75f', 'eb181ec2-8f04-4a7d-8c78-641890d6c852'),
('df1225ad-308b-406e-9299-87357d25b75f', 'e6aadbaa-d81a-4bed-8e22-69202b9e3575'),
('df1225ad-308b-406e-9299-87357d25b75f', '3ce45e05-742b-4b12-b5c9-3a0179c78188'),
('df1225ad-308b-406e-9299-87357d25b75f', '38ff7dd0-bff6-4e89-a741-6ac0ceb2e268'),

('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '31eb4b61-2ff4-452c-baad-5f4b2202f227'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', 'eb91b738-6afd-436c-89d6-5cef53eac26c'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '8ae79193-ebf6-4a91-b006-8f49447e3286'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '3c96d6b7-1e38-4d71-bbdf-a5c50ffb5f86'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '992125bd-68cc-4048-be18-f0b44b74e18f'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '7301db36-8d16-4efc-8b61-15d925a2a164'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', 'eb181ec2-8f04-4a7d-8c78-641890d6c852'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', 'e6aadbaa-d81a-4bed-8e22-69202b9e3575'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '3ce45e05-742b-4b12-b5c9-3a0179c78188'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '38ff7dd0-bff6-4e89-a741-6ac0ceb2e268'),

('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '948c21ed-59d7-4bd3-9627-16b6bb516e2b'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '915f8f41-e6c0-4c9a-ae7a-2cd46f327bd7'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'b2641e0a-4531-4636-a1a7-1e48b818da66'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '74ab49c6-9010-4332-bf3c-88bcf22844a1'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'd753592d-7ab6-4ae8-88fc-00e04de196f0'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '2d1adc86-a237-4707-b032-b661f156c0fe'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'fb7063c4-077d-45e3-985d-3816ea1dedc3'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'c23481a4-a8d8-4798-8c5b-785a8d5a73d1'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', 'e34593fa-4a14-41a9-937a-5b56fc718ada'),
('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '501bbc6d-f3cd-45ea-afd8-8e2b9f54b454'),

('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '948c21ed-59d7-4bd3-9627-16b6bb516e2b'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '915f8f41-e6c0-4c9a-ae7a-2cd46f327bd7'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'b2641e0a-4531-4636-a1a7-1e48b818da66'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '74ab49c6-9010-4332-bf3c-88bcf22844a1'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'd753592d-7ab6-4ae8-88fc-00e04de196f0'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '2d1adc86-a237-4707-b032-b661f156c0fe'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'fb7063c4-077d-45e3-985d-3816ea1dedc3'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'c23481a4-a8d8-4798-8c5b-785a8d5a73d1'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'e34593fa-4a14-41a9-937a-5b56fc718ada'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', '501bbc6d-f3cd-45ea-afd8-8e2b9f54b454'),

('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '4acab691-2163-48c4-acbb-be40ce64f815'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '3eb1e1b6-c1d0-41f3-a4b0-e5b2cec68103'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', 'b526ac0f-7555-4286-a42d-3f579cab90d0'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', 'fba947da-6e92-4e57-8d8a-72b12893a9c6'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '8af83b2b-c0fe-4814-be04-2e230c2eaa10'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '3e5c7e2e-c330-4141-b4fa-74523b5888fb'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', 'e3baf5b5-aab6-4812-9389-9abab0156571'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '58bd07b3-b0a8-4a5d-9fc9-2165264e0c74'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '2869f2c6-ce40-46ba-b984-7e6fd7f99179'),
('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '6fffa711-7dd7-41c2-9131-8a7dd527e336'),

('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '4acab691-2163-48c4-acbb-be40ce64f815'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '3eb1e1b6-c1d0-41f3-a4b0-e5b2cec68103'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', 'b526ac0f-7555-4286-a42d-3f579cab90d0'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', 'fba947da-6e92-4e57-8d8a-72b12893a9c6'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '8af83b2b-c0fe-4814-be04-2e230c2eaa10'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '3e5c7e2e-c330-4141-b4fa-74523b5888fb'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', 'e3baf5b5-aab6-4812-9389-9abab0156571'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '58bd07b3-b0a8-4a5d-9fc9-2165264e0c74'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '2869f2c6-ce40-46ba-b984-7e6fd7f99179'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '6fffa711-7dd7-41c2-9131-8a7dd527e336'),

('9010478c-9c92-4a27-b569-a0206edd57ec', 'e7110b2d-1ccd-433f-a739-0cce0906b8b4'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '0b568432-7071-4247-9a1d-3ac04eed13f7'),
('9010478c-9c92-4a27-b569-a0206edd57ec', 'e8d14996-db58-4566-a934-5d43846b3177'),
('9010478c-9c92-4a27-b569-a0206edd57ec', 'd40f5150-6d92-41aa-9277-1e717205990e'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '271b9269-c0e1-46b8-aa9c-8dbbc42d0e69'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '2465d438-0910-42d2-aae6-d09a74eb8d1a'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '712cfea9-c9e0-41e7-80f8-e970e0ca20c0'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '9062240b-d591-4018-ad6e-413740a6491e'),
('9010478c-9c92-4a27-b569-a0206edd57ec', '66f6e99a-2ac1-480e-a791-b16b4d2440dd'),
('9010478c-9c92-4a27-b569-a0206edd57ec', 'f8079578-5bd6-48bc-a358-efe1c8a70858'),

('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 'e7110b2d-1ccd-433f-a739-0cce0906b8b4'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '0b568432-7071-4247-9a1d-3ac04eed13f7'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 'e8d14996-db58-4566-a934-5d43846b3177'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 'd40f5150-6d92-41aa-9277-1e717205990e'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '271b9269-c0e1-46b8-aa9c-8dbbc42d0e69'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '2465d438-0910-42d2-aae6-d09a74eb8d1a'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '712cfea9-c9e0-41e7-80f8-e970e0ca20c0'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '9062240b-d591-4018-ad6e-413740a6491e'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '66f6e99a-2ac1-480e-a791-b16b4d2440dd'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', 'f8079578-5bd6-48bc-a358-efe1c8a70858'),

('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 'ea9ae684-81d2-47af-9922-07bfbf0de0ef'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 'd5c2bf1a-4deb-4adb-8e7e-8f4a7fb4fc01'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 'e854b944-9b98-4d08-ad13-b2eb40a2d070'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '2f3e682e-8d04-4440-b0c3-ed1d8e833a41'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '28782af1-ef00-4877-b68d-1a58052dcb65'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '885c44fb-90de-4864-85d3-cfcef1303ef3'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', 'd0404164-29d8-465b-a9b2-e4c7f6046f25'),
('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '33c4d1cf-57d1-4480-af70-484b07e18966'),

('60dca729-ec40-4e0b-b775-c3e782e78fda', 'ea9ae684-81d2-47af-9922-07bfbf0de0ef'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', 'd5c2bf1a-4deb-4adb-8e7e-8f4a7fb4fc01'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', 'e854b944-9b98-4d08-ad13-b2eb40a2d070'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', '2f3e682e-8d04-4440-b0c3-ed1d8e833a41'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', '28782af1-ef00-4877-b68d-1a58052dcb65'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', '885c44fb-90de-4864-85d3-cfcef1303ef3'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', 'd0404164-29d8-465b-a9b2-e4c7f6046f25'),
('60dca729-ec40-4e0b-b775-c3e782e78fda', '33c4d1cf-57d1-4480-af70-484b07e18966');

INSERT INTO `ejournal`.`teacher_has_subjects` (`teacher_id`, `subject_id`)
VALUES
('df1225ad-308b-406e-9299-87357d25b75f', '350c9335-7499-46ec-b782-0dae6fa50c4f'),
('61a6b62a-b41a-4d67-8aa4-a6cdb2d49147', '9d048602-9fd6-47dc-b4a1-ae1371f92d7e'),

('c081c3ca-b3e9-4258-bec1-d4d2cac6870a', '43238990-2645-4f97-b64b-0471fb65d95c'),
('a82e84d4-31ce-4a00-9211-f75ceddab7a6', 'b9a2d055-3c78-48e6-afe0-b30c003a61bf'),

('ed3e1b0d-3278-4bf0-a364-5fb04482c83a', '385695ce-2e77-4765-a785-485c591d9138'),
('d20b0feb-87b1-41aa-b7db-5c4b645fb61b', '00001b87-4ef2-45d6-97c8-882e9b98696f'),

('9010478c-9c92-4a27-b569-a0206edd57ec', 'f95f73c2-3e2a-4edc-98d2-cabd2d9efa1b'),
('d2e8a8fe-2c7f-4d85-9666-257b7644252e', '43238990-2645-4f97-b64b-0471fb65d95c'),

('d00c39e8-d59e-49b7-8f24-25b0214c4c4b', '350c9335-7499-46ec-b782-0dae6fa50c4f'),
('c72640e3-f2b8-41b6-9ffa-98ad24616b92', '43238990-2645-4f97-b64b-0471fb65d95c');