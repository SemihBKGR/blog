INSERT INTO `website`.`subjects` (`id`, `name`, `explanation`, `url_endpoint`,`image_url`, `display_order`)
VALUES (1, 'subject-01', 'subject-01 explanation', 'subject-01','/static/images/blue.png', 1),
       (2, 'subject-02', 'subject-02 explanation', 'subject-02','/static/images/blue.png', 2),
       (3, 'subject-03', 'subject-03 explanation', 'subject-03','/static/images/blue.png', 3);

INSERT INTO website.tags (`id`, `subject_id`, `name`, `explanation`, `display_order`)
VALUES (1, 1, 'tag-01', 'tag-01 explanation', 1),
       (2, 2, 'tag-02', 'tag-02 explanation', 1),
       (3, 3, 'tag-03', 'tag-03 explanation', 1),
       (4, 1, 'tag-04', 'tag-04 explanation', 2),
       (5, 2, 'tag-05', 'tag-05 explanation', 2),
       (6, 3, 'tag-06', 'tag-06 explanation', 2),
       (7, 1, 'tag-07', 'tag-07 explanation', 3),
       (8, 2, 'tag-08', 'tag-08 explanation', 3),
       (9, 3, 'tag-09', 'tag-09 explanation', 3);

INSERT INTO website.posts(`tag_id`, `title`, `brief`, `content`, `url_endpoint`, `display_order`, `create_time`)
VALUES (1, 'post-01', 'post-01 brief', 'post-01 content', 'post-01', 1, UNIX_TIMESTAMP()),
       (2, 'post-02', 'post-02 brief', 'post-02 content', 'post-02', 1, UNIX_TIMESTAMP()),
       (3, 'post-03', 'post-03 brief', 'post-03 content', 'post-03', 1, UNIX_TIMESTAMP()),
       (4, 'post-04', 'post-04 brief', 'post-04 content', 'post-04', 1, UNIX_TIMESTAMP()),
       (5, 'post-05', 'post-05 brief', 'post-05 content', 'post-05', 1, UNIX_TIMESTAMP()),
       (6, 'post-06', 'post-06 brief', 'post-06 content', 'post-06', 1, UNIX_TIMESTAMP()),
       (7, 'post-07', 'post-07 brief', 'post-07 content', 'post-07', 1, UNIX_TIMESTAMP()),
       (8, 'post-08', 'post-08 brief', 'post-08 content', 'post-08', 1, UNIX_TIMESTAMP()),
       (9, 'post-09', 'post-09 brief', 'post-09 content', 'post-09', 1, UNIX_TIMESTAMP()),
       (1, 'post-10', 'post-10 brief', 'post-10 content', 'post-10', 2, UNIX_TIMESTAMP()),
       (2, 'post-11', 'post-11 brief', 'post-11 content', 'post-11', 2, UNIX_TIMESTAMP()),
       (3, 'post-12', 'post-12 brief', 'post-12 content', 'post-12', 2, UNIX_TIMESTAMP()),
       (4, 'post-13', 'post-13 brief', 'post-13 content', 'post-13', 2, UNIX_TIMESTAMP()),
       (5, 'post-14', 'post-14 brief', 'post-14 content', 'post-14', 2, UNIX_TIMESTAMP()),
       (6, 'post-15', 'post-15 brief', 'post-15 content', 'post-15', 2, UNIX_TIMESTAMP()),
       (7, 'post-16', 'post-16 brief', 'post-16 content', 'post-16', 2, UNIX_TIMESTAMP()),
       (8, 'post-17', 'post-17 brief', 'post-17 content', 'post-17', 2, UNIX_TIMESTAMP()),
       (9, 'post-18', 'post-18 brief', 'post-18 content', 'post-18', 2, UNIX_TIMESTAMP()),
       (1, 'post-19', 'post-19 brief', 'post-19 content', 'post-19', 3, UNIX_TIMESTAMP()),
       (2, 'post-20', 'post-20 brief', 'post-20 content', 'post-20', 3, UNIX_TIMESTAMP()),
       (3, 'post-21', 'post-21 brief', 'post-21 content', 'post-21', 3, UNIX_TIMESTAMP()),
       (4, 'post-22', 'post-22 brief', 'post-22 content', 'post-22', 3, UNIX_TIMESTAMP()),
       (5, 'post-23', 'post-23 brief', 'post-23 content', 'post-23', 3, UNIX_TIMESTAMP()),
       (6, 'post-24', 'post-24 brief', 'post-24 content', 'post-24', 3, UNIX_TIMESTAMP()),
       (7, 'post-25', 'post-25 brief', 'post-25 content', 'post-25', 3, UNIX_TIMESTAMP()),
       (8, 'post-26', 'post-26 brief', 'post-26 content', 'post-26', 3, UNIX_TIMESTAMP()),
       (9, 'post-27', 'post-27 brief', 'post-27 content', 'post-27', 3, UNIX_TIMESTAMP());