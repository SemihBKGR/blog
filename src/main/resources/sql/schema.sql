CREATE TABLE `website`.`posts`
(
    `id`          INT AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(64) NOT NULL UNIQUE,
    `content`     LONGTEXT    NOT NULL,
    `create_time` INT(11)     NOT NULL,
    `update_time` INT(11),
    `view_count`  INT(9)      NOT NULL DEFAULT 0
);