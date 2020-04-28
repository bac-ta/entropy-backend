ALTER TABLE `entropyb`.`category`
ADD COLUMN `created` datetime DEFAULT NULL,
ADD COLUMN `created_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
ADD COLUMN `updated` datetime DEFAULT NULL,
ADD COLUMN `updated_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL;