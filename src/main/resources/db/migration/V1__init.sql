

--
-- Table structure for table `category`
--

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `category`
(
    `id`            int(11)                              NOT NULL AUTO_INCREMENT,
    `created`       datetime                             DEFAULT NULL,
    `created_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `updated`       datetime                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `category_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `status_type`   varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `category`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `post`
(
    `id`           int(11)                              NOT NULL AUTO_INCREMENT,
    `created`      datetime                                      DEFAULT NULL,
    `created_by`   varchar(255) COLLATE utf8_unicode_ci          DEFAULT NULL,
    `updated`      datetime                                      DEFAULT NULL,
    `updated_by`   varchar(255) COLLATE utf8_unicode_ci          DEFAULT NULL,
    `author`       varchar(255) COLLATE utf8_unicode_ci          DEFAULT NULL,
    `content`      mediumtext COLLATE utf8_unicode_ci   NOT NULL,
    `image_title`  varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `publish_type` varchar(45) COLLATE utf8_unicode_ci  NOT NULL DEFAULT 'WATTING',
    `status_type`  varchar(45) COLLATE utf8_unicode_ci  NOT NULL DEFAULT 'ON',
    `title`        varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `user_id`      int(11)                              NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK2jm25hjrq6iv4w8y1dhi0d9p4` (`title`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `post`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_category`
--


/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `post_category`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `created`     datetime                             DEFAULT NULL,
    `created_by`  varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `updated`     datetime                             DEFAULT NULL,
    `updated_by`  varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `category_id` int(11)                              DEFAULT NULL,
    `post_id`     int(11)                              DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_category`
--

LOCK TABLES `post_category` WRITE;
/*!40000 ALTER TABLE `post_category`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `post_category`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `profile`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `avatar`      varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `user_id`     bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `profile`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `user`
(
    `id`            bigint(20)                           NOT NULL AUTO_INCREMENT,
    `created`       datetime                             DEFAULT NULL,
    `created_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `updated`       datetime                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `approve_type`  varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `date_of_birth` datetime                             NOT NULL,
    `email`         varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `first_name`    varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `gender_type`   varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `last_name`     varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `password`      varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `phone_number`  varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `status_type`   varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `user_name`     varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `user_type`     varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKc9miph0xbb4t9lvb0l2je3ndx` (`email`, `user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
