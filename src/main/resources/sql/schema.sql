DROP TABLE IF EXISTS `website`.`posts`;
DROP TABLE IF EXISTS `website`.`tags`;
DROP TABLE IF EXISTS `website`.`subjects`;

CREATE TABLE `website`.`subjects`
(
    `id`            INT AUTO_INCREMENT,
    `name`          VARCHAR(16) NOT NULL UNIQUE,
    `explanation`   VARCHAR(256),
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (`id`)
);

CREATE TABLE `website`.`tags`
(
    `id`            INT AUTO_INCREMENT,
    `subject_id`    INT         NOT NULL,
    `name`          VARCHAR(16) NOT NULL,
    `explanation`   VARCHAR(256),
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`subject_id`) REFERENCES `website`.`subjects` (`id`),
    UNIQUE INDEX (`subject_id`, `name`)
);

CREATE TABLE `website`.`posts`
(
    `id`            INT AUTO_INCREMENT,
    `tag_id`        INT          NOT NULL,
    `title`         VARCHAR(64)  NOT NULL,
    `brief`         VARCHAR(256) NOT NULL,
    `content`       LONGTEXT     NOT NULL,
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    `create_time`   INT(11)      NOT NULL,
    `update_time`   INT(11),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`tag_id`) REFERENCES tags (`id`),
    UNIQUE INDEX (`tag_id`, `title`)
);
