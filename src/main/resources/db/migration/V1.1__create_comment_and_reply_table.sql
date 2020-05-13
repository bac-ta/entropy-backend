CREATE TABLE IF NOT EXISTS `comment`
(
    `id`            varchar(45)                          NOT NULL ,
    `created`       datetime                             DEFAULT NULL,
    `created_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `updated`       datetime                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `content`       varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `file_url`      varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `user_comment_id` varchar(45)                        NOT NULL,
    `status_type`   varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ON',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS `reply`
(
    `id`            varchar(45)                          NOT NULL,
    `created`       datetime                             DEFAULT NULL,
    `created_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `updated`       datetime                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `content`       varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `comment_id`    varchar(45)                          NOT NULL,
    `file_url`      varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `user_reply_id` varchar(45)                          NOT NULL,
    `status_type`   varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ON',
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
COLLATE = utf8_unicode_ci;