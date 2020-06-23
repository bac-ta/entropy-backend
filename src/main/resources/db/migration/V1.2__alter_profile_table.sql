ALTER TABLE `entropyb`.`profile`
CHANGE COLUMN `user_id` `user_id` BIGINT(20) NULL,
CHANGE COLUMN `avatar` `avatar` VARCHAR(500) CHARACTER SET 'utf8' NULL DEFAULT NULL,
ADD COLUMN `oauth2_user_id` BIGINT(20) NULL,
ADD COLUMN `oauth2_avatar` VARCHAR(500) NULL AFTER `user_id`;