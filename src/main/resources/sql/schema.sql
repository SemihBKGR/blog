DROP TABLE IF EXISTS `blog`.`posts`;
DROP TABLE IF EXISTS `blog`.`categories`;
DROP TABLE IF EXISTS `blog`.`subjects`;

CREATE TABLE `blog`.`subjects`
(
    `id`            INT AUTO_INCREMENT,
    `name`          VARCHAR(16) NOT NULL,
    `explanation`   VARCHAR(256),
    `url_endpoint`  VARCHAR(32) NOT NULL,
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE INDEX (name),
    UNIQUE INDEX (url_endpoint)
);

CREATE TABLE `blog`.`categories`
(
    `id`            INT AUTO_INCREMENT,
    `name`          VARCHAR(32) NOT NULL,
    `explanation`   VARCHAR(256),
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE INDEX (name)
);

CREATE TABLE `blog`.`posts`
(
    `id`            INT AUTO_INCREMENT,
    `subject_id`    INT         NOT NULL,
    `category_id`   INT         NOT NULL,
    `title`         VARCHAR(64) NOT NULL,
    `brief`         MEDIUMTEXT    NOT NULL,
    `content`       LONGTEXT    NOT NULL,
    `url_endpoint`  VARCHAR(64) NOT NULL,
    `image_url`     VARCHAR(256),
    `display_order` INT UNSIGNED DEFAULT 0,
    `create_time`   INT(11)     NOT NULL,
    `update_time`   INT(11),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`subject_id`) REFERENCES subjects (`id`),
    FOREIGN KEY (`category_id`) REFERENCES categories (`id`),
    UNIQUE INDEX (`subject_id`, `url_endpoint`),
    UNIQUE INDEX (`subject_id`, `title`)
);
