-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: admage_batch_summary
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ResultSetMapper`
--

DROP TABLE IF EXISTS `ResultSetMapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ResultSetMapper` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ResultSetMapper`
--

LOCK TABLES `ResultSetMapper` WRITE;
/*!40000 ALTER TABLE `ResultSetMapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `ResultSetMapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `click_log`
--

DROP TABLE IF EXISTS `click_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `click_log` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `buyer_id` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` int NOT NULL DEFAULT '0',
  `link_id` int NOT NULL DEFAULT '0',
  `image_id` int NOT NULL DEFAULT '0',
  `keyword_id` int NOT NULL DEFAULT '0',
  `click_date` datetime DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `suid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sad` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `xuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `pack_id` int NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `app_sdk_id` int NOT NULL DEFAULT '0',
  `xuniq` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `referer` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `sad2` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_click_log_date` (`buyer_id`,`click_date`),
  KEY `idx_click_log_xuid` (`xuid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `click_log`
--

LOCK TABLES `click_log` WRITE;
/*!40000 ALTER TABLE `click_log` DISABLE KEYS */;
INSERT INTO `click_log` VALUES (1,2,1,0,0,0,1,0,1,0,'2020-12-08 15:29:24','admx7641782fc3x785',NULL,NULL,NULL,1,'xuidx7641782fc3x7e4',3,0,0,0,0,0,NULL,'',NULL),(2,2,1,0,0,0,1,0,1,0,'2020-12-08 15:30:10','admx764178e3c3xb00',NULL,NULL,NULL,1,'xuidx764178e3c3x6b2',3,0,0,0,0,0,NULL,'',NULL),(3,2,1,0,0,0,1,0,1,0,'2020-12-14 14:08:25','admx7660143568xca3',NULL,NULL,NULL,1,'xuidx766014356exf88',3,0,0,0,0,0,NULL,'',NULL),(4,2,1,0,0,0,1,0,1,0,'2020-12-14 14:12:54','admx7660184f4cx65e',NULL,NULL,NULL,1,'xuidx7660184f4cx88b',3,0,0,0,0,0,NULL,'',NULL),(5,2,1,0,0,1,1,0,1,0,'2020-12-14 14:20:16','admx76601f0ebdx9e5',NULL,NULL,NULL,1,'xuidx76601f0ec2xe5c',3,0,0,0,0,0,NULL,'',NULL),(6,2,1,0,0,2,1,0,1,0,'2020-12-14 14:21:28','admx7660202613x97e',NULL,NULL,NULL,1,'xuidx7660202618x250',3,0,0,0,0,0,NULL,'',NULL),(7,3,2,0,0,0,2,0,2,0,'2020-12-14 14:22:28','admx76602112fcxd57',NULL,NULL,NULL,1,'xuidx76602112fcx535',3,0,0,0,0,0,NULL,'',NULL),(8,3,3,0,0,0,2,0,2,0,'2020-12-14 14:23:20','admx766021ddaax473',NULL,NULL,NULL,1,'xuidx766021ddaaxdf9',3,0,0,0,0,0,NULL,'',NULL),(9,3,1,0,0,0,2,0,2,0,'2020-12-14 14:24:08','admx766022987cxe55',NULL,NULL,NULL,1,'xuidx766022987cxfb1',3,0,0,0,0,0,NULL,'',NULL),(10,3,1,0,0,0,2,0,2,0,'2020-12-14 14:24:45','admx766023273ax1fa',NULL,NULL,NULL,1,'xuidx766023273ax3be',3,0,0,0,0,0,NULL,'',NULL),(11,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:08','admx768e279827x86c',NULL,NULL,NULL,1,'xuidx768e279828x806',3,0,0,0,0,0,NULL,'',NULL),(12,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:21','admx768e27cd3cxdce',NULL,NULL,NULL,1,'xuidx768e27cd3cx350',3,0,0,0,0,0,NULL,'',NULL),(13,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:24','admx768e27d5ecx8df',NULL,NULL,NULL,1,'xuidx768e27d5ecx99c',3,0,0,0,0,0,NULL,'',NULL),(14,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:26','admx768e27de03x64a',NULL,NULL,NULL,1,'xuidx768e27de03xd37',3,0,0,0,0,0,NULL,'',NULL),(15,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:27','admx768e27e37exa1a',NULL,NULL,NULL,1,'xuidx768e27e37exc8f',3,0,0,0,0,0,NULL,'',NULL),(16,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:29','admx768e27eab9x6e7',NULL,NULL,NULL,1,'xuidx768e27eab9x330',3,0,0,0,0,0,NULL,'',NULL),(17,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:30','admx768e27f028xa62',NULL,NULL,NULL,1,'xuidx768e27f028x388',3,0,0,0,0,0,NULL,'',NULL),(18,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:32','admx768e27f5bcxd16',NULL,NULL,NULL,1,'xuidx768e27f5bcxda2',3,0,0,0,0,0,NULL,'',NULL),(19,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:33','admx768e27fb4fxed4',NULL,NULL,NULL,1,'xuidx768e27fb4fx866',3,0,0,0,0,0,NULL,'',NULL),(20,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:34','admx768e2800abxb3e',NULL,NULL,NULL,1,'xuidx768e2800abx3c5',3,0,0,0,0,0,NULL,'',NULL),(21,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:36','admx768e280616xe58',NULL,NULL,NULL,1,'xuidx768e280616xfaa',3,0,0,0,0,0,NULL,'',NULL),(22,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:37','admx768e280b45xa7d',NULL,NULL,NULL,1,'xuidx768e280b45x057',3,0,0,0,0,0,NULL,'',NULL),(23,2,1,0,0,2,1,0,1,0,'2020-12-23 12:52:39','admx768e2810fcxd21',NULL,NULL,NULL,1,'xuidx768e2810fcx75e',3,0,0,0,0,0,NULL,'',NULL);
/*!40000 ALTER TABLE `click_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_log`
--

DROP TABLE IF EXISTS `cv_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cv_log` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `hour` tinyint DEFAULT NULL,
  `cv_date` datetime DEFAULT NULL,
  `click_date` datetime DEFAULT NULL,
  `approve_date` datetime DEFAULT NULL,
  `withdraw_date` datetime DEFAULT NULL,
  `kickback_date` datetime DEFAULT NULL,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL,
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` int NOT NULL DEFAULT '0',
  `link_id` int NOT NULL DEFAULT '0',
  `image_id` int NOT NULL DEFAULT '0',
  `keyword_id` int NOT NULL DEFAULT '0',
  `member_id` int NOT NULL DEFAULT '0',
  `cv_campaign_id` int NOT NULL DEFAULT '0',
  `cv_article_id` int NOT NULL DEFAULT '0',
  `pack_id` int NOT NULL DEFAULT '0',
  `pack` tinyint NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `app_sdk_id` int NOT NULL DEFAULT '0',
  `origin_cv_id` bigint NOT NULL DEFAULT '0',
  `cvpoint_type` tinyint NOT NULL DEFAULT '0',
  `install_cv` tinyint NOT NULL DEFAULT '0',
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `suid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `buid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `xuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cgid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sad` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `xuniq` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sku_id` bigint DEFAULT NULL,
  `xtrack` bigint DEFAULT NULL,
  `certify_type` tinyint DEFAULT NULL,
  `xtid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `query_string` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `user_agent` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `history` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `attribute` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `referer` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `cost` decimal(15,2) NOT NULL DEFAULT '0.00',
  `wholesale` decimal(15,2) NOT NULL DEFAULT '0.00',
  `retail` int NOT NULL DEFAULT '0',
  `kickback_url` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `kickback_error` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `kickback_retry` smallint DEFAULT NULL,
  `kickback_status` tinyint NOT NULL DEFAULT '0',
  `reject_reason` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `remain` tinyint NOT NULL DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint NOT NULL DEFAULT '1',
  `kickback_second_date` datetime DEFAULT NULL,
  `kickback_second_status` tinyint NOT NULL DEFAULT '0',
  `kickback_second_error` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `kickback_second_retry` smallint NOT NULL DEFAULT '0',
  `kickback_approve_url` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `kickback_reject_url` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `has_kickback_second_flg` tinyint NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  `sad2` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `marginCost` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_cv_log_hour` (`buyer_id`,`date`,`hour`),
  KEY `idx_cv_log_seller` (`seller_id`,`approve_date`),
  KEY `idx_cv_log_article` (`article_id`,`approve_date`),
  KEY `idx_cv_log_xuid` (`xuid`),
  KEY `idx_cv_log_cgid` (`cgid`),
  KEY `idx_cv_log_suid` (`suid`),
  KEY `idx_cv_log_sid` (`sid`),
  KEY `idx_cv_log_uid` (`uid`,`buyer_id`,`article_id`),
  KEY `idx_cv_log_buid` (`buid`,`buyer_id`,`article_id`),
  KEY `idx_cv_log_approve` (`approve_date`),
  KEY `idx_cv_log_withdraw` (`withdraw_date`),
  KEY `idx_cv_log_click` (`click_date`),
  KEY `idx_cv_log_kickback_date` (`kickback_date`),
  KEY `idx_cv_log_cv` (`cv_date`),
  KEY `idx_cv_log_kickback` (`kickback_status`),
  KEY `test_idx_uid` (`uid`),
  KEY `test_idx_2` (`site_id`,`uid`,`pack_id`),
  KEY `idx_cv_log_xuniq` (`xuniq`,`buyer_id`,`cv_app_id`),
  KEY `idx_cv_log_cvpoint` (`cvpoint`,`cv_app_id`),
  KEY `cv_log_sad_index` (`sad`),
  KEY `cv_log_sad2_index` (`sad2`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_log`
--

LOCK TABLES `cv_log` WRITE;
/*!40000 ALTER TABLE `cv_log` DISABLE KEYS */;
INSERT INTO `cv_log` VALUES (1,'2020-12-08',15,'2020-12-08 15:29:49','2020-12-08 15:29:24','2020-12-08 15:29:49',NULL,'2020-12-08 08:29:48',1,2,2,1,3,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,'admx7641782fc3x785','','','','xuidx7641782fc3x7e4','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx7641782fc3x7e4','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',50.00,100.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-08 01:29:48',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(2,'2020-12-08',15,'2020-12-08 15:30:23','2020-12-08 15:30:10','2020-12-08 15:30:23',NULL,'2020-12-08 08:30:22',1,2,2,1,3,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,'admx764178e3c3xb00','','','','xuidx764178e3c3x6b2','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx764178e3c3x6b2','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',50.00,100.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-08 01:30:22',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(3,'2020-12-14',14,'2020-12-14 14:20:47','2020-12-14 14:20:16','2020-12-14 14:20:47',NULL,'2020-12-14 07:20:46',1,2,2,1,3,0,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,'admx76601f0ebdx9e5','','','','xuidx76601f0ec2xe5c','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=&_xuid=xuidx76601f0ec2xe5c','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',50.00,100.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-14 00:20:46',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(4,'2020-12-14',14,'2020-12-14 14:21:46','2020-12-14 14:21:28','2020-12-14 14:21:46',NULL,'2020-12-14 07:21:46',1,2,2,1,3,0,1,0,0,2,0,2,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,'admx7660202613x97e','','','','xuidx7660202618x250','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=2&_cvpoint=2&_campaign=2&_price=&_buid=&_xuid=xuidx7660202618x250','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',50.00,100.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-14 00:21:46',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(5,'2020-12-14',14,'2020-12-14 14:22:54','2020-12-14 14:22:28','2020-12-14 14:22:54',NULL,'2020-12-14 07:22:54',1,3,2,1,3,0,2,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,'admx76602112fcxd57','','','','xuidx76602112fcx535','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx76602112fcx535','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',45.00,85.00,0,'http://dimage.vn','',NULL,3,NULL,0,'2020-12-14 00:22:54',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(6,'2020-12-14',14,'2020-12-14 14:23:43','2020-12-14 14:23:20','2020-12-14 14:23:43',NULL,'2020-12-14 07:23:43',1,3,2,1,3,0,3,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,'admx766021ddaax473','','','','xuidx766021ddaaxdf9','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766021ddaaxdf9','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',45.00,85.00,0,'http://dimage.vn','',NULL,3,NULL,0,'2020-12-14 00:23:43',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(7,'2020-12-14',14,'2020-12-14 14:24:27','2020-12-14 14:24:08','2020-12-14 14:24:27',NULL,'2020-12-14 07:24:26',1,3,2,1,3,0,1,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,'admx766022987cxe55','','','','xuidx766022987cxfb1','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766022987cxfb1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',45.00,85.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-14 00:24:26',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(8,'2020-12-14',14,'2020-12-14 14:25:04','2020-12-14 14:24:45','2020-12-14 14:25:04',NULL,'2020-12-14 07:25:03',1,3,2,1,3,0,1,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,'admx766023273ax1fa','','','','xuidx766023273ax3be','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766023273ax3be','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,NULL,NULL,'',45.00,85.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-14 00:25:03',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL),(9,'2020-12-23',12,'2020-12-23 12:53:16','2020-12-23 12:52:39','2020-12-23 12:53:16',NULL,'2020-12-23 05:53:15',1,2,2,1,3,0,1,0,0,0,0,2,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,'admx768e2810fcxd21','','','','xuidx768e2810fcx75e','','',NULL,NULL,0,NULL,'','0:0:0:0:0:0:0:1','advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx768e2810fcx75e','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,NULL,NULL,'',50.00,100.00,0,'http://localhost','',NULL,3,NULL,0,'2020-12-22 22:53:15',1,NULL,0,NULL,0,NULL,NULL,0,0,'',NULL);
/*!40000 ALTER TABLE `cv_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliver_log`
--

DROP TABLE IF EXISTS `deliver_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliver_log` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `seller_id` int NOT NULL,
  `buyer_id` int NOT NULL,
  `buyer_type` tinyint NOT NULL,
  `terminal_type` tinyint NOT NULL,
  `carrier_id` int NOT NULL,
  `model_id` int NOT NULL,
  `cvpoint` int NOT NULL,
  `cvpoint_type` tinyint NOT NULL,
  `site_id` int NOT NULL,
  `item_id` int NOT NULL,
  `item_type` tinyint NOT NULL,
  `location_id` int NOT NULL,
  `campaign_id` int NOT NULL,
  `article_id` int NOT NULL,
  `link_id` int NOT NULL,
  `image_id` int NOT NULL,
  `keyword_id` int NOT NULL,
  `cv_app_id` int NOT NULL,
  `app_store_id` int NOT NULL,
  `app_sdk_id` int NOT NULL,
  `origin_cv_id` bigint NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date` datetime NOT NULL,
  `ignore_type` tinyint NOT NULL,
  `error_type` tinyint NOT NULL,
  `log_type` tinyint NOT NULL,
  `error_msg` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `query_string` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_agent` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `click_date` datetime DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `xuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cgid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `suid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sid` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `buid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cost` decimal(15,2) NOT NULL DEFAULT '0.00',
  `wholesale` decimal(15,2) NOT NULL DEFAULT '0.00',
  `retail` int NOT NULL,
  `xuniq` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sku_id` bigint DEFAULT NULL,
  `xtrack` bigint DEFAULT NULL,
  `certify_type` tinyint DEFAULT NULL,
  `xtid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `install_cv` tinyint DEFAULT NULL,
  `referer` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `margin_cost` double NOT NULL DEFAULT '0',
  `sad` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sad2` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliver_log`
--

LOCK TABLES `deliver_log` WRITE;
/*!40000 ALTER TABLE `deliver_log` DISABLE KEYS */;
INSERT INTO `deliver_log` VALUES (1,0,2,2,1,3,0,0,0,100,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-08 01:29:04','2020-12-08 15:29:05',0,2,2,'メディア主ステータスがOnでない','medium=100&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx764177e4c0x79e','xuidx764177e4c1xd1f','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(2,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-08 01:29:23','2020-12-08 15:29:24',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7641782fc3x785','xuidx7641782fc3x7e4','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(3,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-08 01:29:49','2020-12-08 15:29:49',0,1,3,NULL,'advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx7641782fc3x7e4','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-08 15:29:24','admx7641782fc3x785','xuidx7641782fc3x7e4','','','','',50.00,100.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(4,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-08 01:30:09','2020-12-08 15:30:10',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx764178e3c3xb00','xuidx764178e3c3x6b2','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(5,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-08 01:30:22','2020-12-08 15:30:23',0,1,3,NULL,'advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx764178e3c3x6b2','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-08 15:30:10','admx764178e3c3xb00','xuidx764178e3c3x6b2','','','','',50.00,100.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(6,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-14 00:08:26','2020-12-14 14:08:25',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7660143568xca3','xuidx766014356exf88','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(7,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:11:24','2020-12-14 14:11:24',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=&_xuid=xuidx766014356exf88','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx766016f042xe05','xuidx766014356exf88','',NULL,NULL,'',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(8,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:11:48','2020-12-14 14:11:48',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=&_xuid=','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7660174e2fx465','','',NULL,NULL,'',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(9,1,2,2,1,3,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,'2020-12-14 00:12:54','2020-12-14 14:12:54',0,1,2,NULL,'medium=1&ad=1&_buid=test01','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7660184f4cx65e','xuidx7660184f4cx88b','',NULL,NULL,'test01',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(10,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:13:16','2020-12-14 14:13:16',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=test01','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx766018a3b8x7b0',NULL,'',NULL,NULL,'test01',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(11,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:13:43','2020-12-14 14:13:43',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=test01&_xuid=xuidx7660184f4cx88b','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7660190f1ex893','xuidx7660184f4cx88b','',NULL,NULL,'test01',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(12,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:16:40','2020-12-14 14:15:49',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=test01&_xuid=xuidx7660184f4cx88b','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx76601af97bx823','xuidx7660184f4cx88b','',NULL,NULL,'test01',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(13,0,2,2,1,3,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,'2020-12-14 00:17:57','2020-12-14 14:17:57',0,2,3,'クリックデータなし','advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=test01&_xuid=xuidx7660184f4cx88b','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx76601cedf0xff8','xuidx7660184f4cx88b','',NULL,NULL,'test01',0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,NULL,0,NULL,NULL),(14,1,2,2,1,3,0,0,0,1,0,0,0,1,1,0,1,0,0,0,0,0,'2020-12-14 00:20:17','2020-12-14 14:20:16',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx76601f0ebdx9e5','xuidx76601f0ec2xe5c','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(15,1,2,2,1,3,0,1,0,1,0,0,0,1,1,0,1,0,0,0,0,0,'2020-12-14 00:20:47','2020-12-14 14:20:47',0,1,3,NULL,'advertiser=2&_cvpoint=1&_campaign=1&_price=&_buid=&_xuid=xuidx76601f0ec2xe5c','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:20:16','admx76601f0ebdx9e5','xuidx76601f0ec2xe5c','','','','',50.00,100.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(16,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-14 00:21:28','2020-12-14 14:21:28',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx7660202613x97e','xuidx7660202618x250','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(17,1,2,2,1,3,0,2,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-14 00:21:47','2020-12-14 14:21:46',0,1,3,NULL,'advertiser=2&_cvpoint=2&_campaign=2&_price=&_buid=&_xuid=xuidx7660202618x250','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:21:28','admx7660202613x97e','xuidx7660202618x250','','','','',50.00,100.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(18,1,3,2,1,3,0,0,0,2,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:22:29','2020-12-14 14:22:28',0,1,2,NULL,'medium=2&ad=2','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx76602112fcxd57','xuidx76602112fcx535','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(19,1,3,2,1,3,0,0,0,2,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:22:55','2020-12-14 14:22:54',0,1,3,NULL,'advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx76602112fcx535','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:22:28','admx76602112fcxd57','xuidx76602112fcx535','','','','',45.00,85.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(20,1,3,2,1,3,0,0,0,3,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:23:21','2020-12-14 14:23:20',0,1,2,NULL,'medium=3&ad=2','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx766021ddaax473','xuidx766021ddaaxdf9','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(21,1,3,2,1,3,0,0,0,3,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:23:44','2020-12-14 14:23:43',0,1,3,NULL,'advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766021ddaaxdf9','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:23:20','admx766021ddaax473','xuidx766021ddaaxdf9','','','','',45.00,85.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(22,1,3,2,1,3,0,0,0,1,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:24:09','2020-12-14 14:24:08',0,1,2,NULL,'medium=1&ad=2','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx766022987cxe55','xuidx766022987cxfb1','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(23,1,3,2,1,3,0,0,0,1,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:24:27','2020-12-14 14:24:27',0,1,3,NULL,'advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766022987cxfb1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:24:08','admx766022987cxe55','xuidx766022987cxfb1','','','','',45.00,85.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(24,1,3,2,1,3,0,0,0,1,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:24:45','2020-12-14 14:24:45',0,1,2,NULL,'medium=1&ad=2','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36',NULL,'admx766023273ax1fa','xuidx766023273ax3be','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(25,1,3,2,1,3,0,0,0,1,0,0,0,0,2,0,2,0,0,0,0,0,'2020-12-14 00:25:04','2020-12-14 14:25:04',0,1,3,NULL,'advertiser=3&ad=2&_price=&_buid=&_xuid=xuidx766023273ax3be','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36','2020-12-14 14:24:45','admx766023273ax1fa','xuidx766023273ax3be','','','','',45.00,85.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'',''),(26,0,4,2,1,3,0,0,0,100,0,0,0,0,3,0,3,0,0,0,0,0,'2020-12-22 22:51:21','2020-12-23 12:51:21',0,2,2,'メディア主ステータスがOnでない','medium=100&ad=3','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e26e2e1x18f','xuidx768e26e2e5x5db','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(27,0,4,2,1,3,0,0,0,100,0,0,0,0,3,0,3,0,0,0,0,0,'2020-12-22 22:51:30','2020-12-23 12:51:30',0,2,2,'メディア主ステータスがOnでない','medium=100&ad=3','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27067fx746','xuidx768e270680x14a','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(28,0,4,2,1,3,0,0,0,100,0,0,0,0,3,0,3,0,0,0,0,0,'2020-12-22 22:51:35','2020-12-23 12:51:35',0,2,2,'メディア主ステータスがOnでない','medium=100&ad=3','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e2717e6x647','xuidx768e2717e6xaf8','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(29,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:07','2020-12-23 12:52:08',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e279827x86c','xuidx768e279828x806','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(30,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:21','2020-12-23 12:52:21',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27cd3cxdce','xuidx768e27cd3cx350','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(31,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:24','2020-12-23 12:52:24',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27d5ecx8df','xuidx768e27d5ecx99c','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(32,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:26','2020-12-23 12:52:26',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27de03x64a','xuidx768e27de03xd37','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(33,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:28','2020-12-23 12:52:27',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27e37exa1a','xuidx768e27e37exc8f','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(34,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:29','2020-12-23 12:52:29',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27eab9x6e7','xuidx768e27eab9x330','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(35,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:31','2020-12-23 12:52:30',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27f028xa62','xuidx768e27f028x388','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(36,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:32','2020-12-23 12:52:32',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27f5bcxd16','xuidx768e27f5bcxda2','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(37,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:33','2020-12-23 12:52:33',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e27fb4fxed4','xuidx768e27fb4fx866','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(38,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:35','2020-12-23 12:52:34',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e2800abxb3e','xuidx768e2800abx3c5','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(39,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:36','2020-12-23 12:52:36',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e280616xe58','xuidx768e280616xfaa','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(40,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:37','2020-12-23 12:52:37',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e280b45xa7d','xuidx768e280b45x057','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(41,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:52:39','2020-12-23 12:52:39',0,1,2,NULL,'medium=1&ad=1','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36',NULL,'admx768e2810fcxd21','xuidx768e2810fcx75e','',NULL,NULL,NULL,0.00,0.00,0,NULL,NULL,0,NULL,NULL,0,'',0,NULL,NULL),(42,1,2,2,1,3,0,0,0,1,0,0,0,2,1,0,1,0,0,0,0,0,'2020-12-22 22:53:16','2020-12-23 12:53:16',0,1,3,NULL,'advertiser=2&ad=1&_price=&_buid=&_xuid=xuidx768e2810fcx75e','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36','2020-12-23 12:52:39','admx768e2810fcxd21','xuidx768e2810fcx75e','','','','',50.00,100.00,0,NULL,NULL,0,NULL,NULL,0,'',0,'','');
/*!40000 ALTER TABLE `deliver_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary`
--

LOCK TABLES `summary` WRITE;
/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_article`
--

DROP TABLE IF EXISTS `summary_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_article` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_article`
--

LOCK TABLES `summary_article` WRITE;
/*!40000 ALTER TABLE `summary_article` DISABLE KEYS */;
INSERT INTO `summary_article` VALUES (1,'2020-12-11 00:25:45',1,2,22,1,1,'2020-12-08',0,0,1,0,0,0,0,1,0,0,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,2,22,1,1,'2020-12-14',0,0,1,0,0,0,0,1,0,0,0,0,3,0,NULL,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,2,22,1,1,'2020-12-14',0,0,1,0,0,0,1,1,0,0,0,0,3,0,NULL,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,2,22,1,1,'2020-12-14',0,0,1,0,0,0,2,1,0,0,0,0,3,0,NULL,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(5,'2020-12-14 00:29:11',1,2,22,1,1,'2020-12-14',0,1,1,0,0,0,1,1,0,0,0,0,3,0,NULL,0,0,0,0,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(6,'2020-12-14 00:29:11',1,2,22,1,1,'2020-12-14',0,2,1,0,0,0,2,1,0,0,0,0,3,0,NULL,0,0,0,0,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(7,'2020-12-14 00:31:46',1,3,22,1,1,'2020-12-14',0,0,3,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(8,'2020-12-14 00:31:46',1,3,22,1,1,'2020-12-14',0,0,2,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(9,'2020-12-14 00:31:46',1,3,22,1,1,'2020-12-14',0,0,1,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_article_hour`
--

DROP TABLE IF EXISTS `summary_article_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_article_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_article_hour`
--

LOCK TABLES `summary_article_hour` WRITE;
/*!40000 ALTER TABLE `summary_article_hour` DISABLE KEYS */;
INSERT INTO `summary_article_hour` VALUES (26,'2020-12-15 03:12:38',1,2,22,1,4,'2020-12-14',14,0,1,0,0,0,0,1,0,0,0,0,3,0,NULL,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(27,'2020-12-15 03:12:38',1,2,22,1,4,'2020-12-14',14,0,1,0,0,0,1,1,0,0,0,0,3,0,NULL,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(28,'2020-12-15 03:12:38',1,2,22,1,4,'2020-12-14',14,0,1,0,0,0,2,1,0,0,0,0,3,0,NULL,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(29,'2020-12-15 03:12:38',1,2,22,1,4,'2020-12-14',14,1,1,0,0,0,1,1,0,0,0,0,3,0,NULL,0,0,0,0,0,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(30,'2020-12-15 03:12:38',1,2,22,1,4,'2020-12-14',14,2,1,0,0,0,2,1,0,0,0,0,3,0,NULL,0,0,0,0,0,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(31,'2020-12-15 03:12:38',1,3,22,1,4,'2020-12-14',14,0,3,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(32,'2020-12-15 03:12:38',1,3,22,1,4,'2020-12-14',14,0,2,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(33,'2020-12-15 03:12:38',1,3,22,1,4,'2020-12-14',14,0,1,0,0,0,0,2,0,0,0,0,3,0,NULL,0,0,0,2,2,2,2,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(34,'2021-02-06 13:58:59',1,2,22,1,4,'2020-12-08',15,0,1,0,0,0,0,1,0,0,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_article_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_campaign`
--

DROP TABLE IF EXISTS `summary_campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_campaign` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_campaign`
--

LOCK TABLES `summary_campaign` WRITE;
/*!40000 ALTER TABLE `summary_campaign` DISABLE KEYS */;
INSERT INTO `summary_campaign` VALUES (1,'2020-12-11 00:25:45',1,2,21,1,1,'2020-12-08',0,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,2,21,1,1,'2020-12-14',0,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,2,21,1,1,'2020-12-14',0,0,1,0,0,0,1,1,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,2,21,1,1,'2020-12-14',0,0,1,0,0,0,2,1,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(5,'2020-12-14 00:31:46',1,3,21,1,1,'2020-12-14',0,0,3,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(6,'2020-12-14 00:31:46',1,3,21,1,1,'2020-12-14',0,0,2,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(7,'2020-12-14 00:31:46',1,3,21,1,1,'2020-12-14',0,0,1,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_campaign_hour`
--

DROP TABLE IF EXISTS `summary_campaign_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_campaign_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_campaign_hour`
--

LOCK TABLES `summary_campaign_hour` WRITE;
/*!40000 ALTER TABLE `summary_campaign_hour` DISABLE KEYS */;
INSERT INTO `summary_campaign_hour` VALUES (20,'2020-12-15 03:12:38',1,2,21,1,4,'2020-12-14',14,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(21,'2020-12-15 03:12:38',1,2,21,1,4,'2020-12-14',14,0,1,0,0,0,1,1,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(22,'2020-12-15 03:12:38',1,2,21,1,4,'2020-12-14',14,0,1,0,0,0,2,1,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(23,'2020-12-15 03:12:38',1,3,21,1,4,'2020-12-14',14,0,3,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(24,'2020-12-15 03:12:38',1,3,21,1,4,'2020-12-14',14,0,2,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(25,'2020-12-15 03:12:38',1,3,21,1,4,'2020-12-14',14,0,1,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,2,2,2,2,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(26,'2021-02-06 13:58:59',1,2,21,1,4,'2020-12-08',15,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_campaign_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_cv_app`
--

DROP TABLE IF EXISTS `summary_cv_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_cv_app` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_cv_app`
--

LOCK TABLES `summary_cv_app` WRITE;
/*!40000 ALTER TABLE `summary_cv_app` DISABLE KEYS */;
INSERT INTO `summary_cv_app` VALUES (1,'2020-12-11 00:25:45',1,2,24,1,1,'2020-12-08',0,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,2,24,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,4,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(3,'2020-12-14 00:31:46',1,3,24,1,1,'2020-12-14',0,0,3,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(4,'2020-12-14 00:31:46',1,3,24,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(5,'2020-12-14 00:31:46',1,3,24,1,1,'2020-12-14',0,0,2,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_cv_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_cv_app_hour`
--

DROP TABLE IF EXISTS `summary_cv_app_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_cv_app_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_cv_app_hour`
--

LOCK TABLES `summary_cv_app_hour` WRITE;
/*!40000 ALTER TABLE `summary_cv_app_hour` DISABLE KEYS */;
INSERT INTO `summary_cv_app_hour` VALUES (14,'2020-12-15 03:12:38',1,2,24,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,4,4,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(15,'2020-12-15 03:12:38',1,3,24,1,4,'2020-12-14',14,0,3,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(16,'2020-12-15 03:12:38',1,3,24,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,2,2,2,2,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(17,'2020-12-15 03:12:38',1,3,24,1,4,'2020-12-14',14,0,2,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(18,'2021-02-06 13:59:00',1,2,24,1,4,'2020-12-08',15,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_cv_app_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_hour`
--

DROP TABLE IF EXISTS `summary_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_hour`
--

LOCK TABLES `summary_hour` WRITE;
/*!40000 ALTER TABLE `summary_hour` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_item`
--

DROP TABLE IF EXISTS `summary_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_item` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_item`
--

LOCK TABLES `summary_item` WRITE;
/*!40000 ALTER TABLE `summary_item` DISABLE KEYS */;
INSERT INTO `summary_item` VALUES (1,'2020-12-11 00:25:39',1,0,12,1,1,'2020-12-08',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,0,12,1,1,'2020-12-14',0,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,0,12,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,0,4,0,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,0,12,1,1,'2020-12-14',0,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_item_hour`
--

DROP TABLE IF EXISTS `summary_item_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_item_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_item_hour`
--

LOCK TABLES `summary_item_hour` WRITE;
/*!40000 ALTER TABLE `summary_item_hour` DISABLE KEYS */;
INSERT INTO `summary_item_hour` VALUES (11,'2020-12-15 03:12:37',1,0,12,1,4,'2020-12-14',14,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(12,'2020-12-15 03:12:37',1,0,12,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,6,4,4,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(13,'2020-12-15 03:12:37',1,0,12,1,4,'2020-12-14',14,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(14,'2021-02-06 13:59:00',1,0,12,1,4,'2020-12-08',15,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_item_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_link`
--

DROP TABLE IF EXISTS `summary_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_link` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_link`
--

LOCK TABLES `summary_link` WRITE;
/*!40000 ALTER TABLE `summary_link` DISABLE KEYS */;
INSERT INTO `summary_link` VALUES (1,'2020-12-11 00:25:45',1,2,23,1,1,'2020-12-08',0,0,1,0,0,0,0,1,0,1,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,2,23,1,1,'2020-12-14',0,0,1,0,0,0,1,1,0,1,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,2,23,1,1,'2020-12-14',0,0,1,0,0,0,2,1,0,1,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,2,23,1,1,'2020-12-14',0,0,1,0,0,0,0,1,0,1,0,0,3,0,NULL,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(5,'2020-12-14 00:31:46',1,3,23,1,1,'2020-12-14',0,0,1,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(6,'2020-12-14 00:31:46',1,3,23,1,1,'2020-12-14',0,0,2,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(7,'2020-12-14 00:31:46',1,3,23,1,1,'2020-12-14',0,0,3,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_link_hour`
--

DROP TABLE IF EXISTS `summary_link_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_link_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_link_hour`
--

LOCK TABLES `summary_link_hour` WRITE;
/*!40000 ALTER TABLE `summary_link_hour` DISABLE KEYS */;
INSERT INTO `summary_link_hour` VALUES (20,'2020-12-15 03:12:38',1,2,23,1,4,'2020-12-14',14,0,1,0,0,0,1,1,0,1,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(21,'2020-12-15 03:12:38',1,2,23,1,4,'2020-12-14',14,0,1,0,0,0,2,1,0,1,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,50,100,0,0,0,0,1,0,0,0,0,0),(22,'2020-12-15 03:12:38',1,2,23,1,4,'2020-12-14',14,0,1,0,0,0,0,1,0,1,0,0,3,0,NULL,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(23,'2020-12-15 03:12:38',1,3,23,1,4,'2020-12-14',14,0,1,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,2,2,2,2,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(24,'2020-12-15 03:12:38',1,3,23,1,4,'2020-12-14',14,0,2,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(25,'2020-12-15 03:12:38',1,3,23,1,4,'2020-12-14',14,0,3,0,0,0,0,2,0,2,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(26,'2021-02-06 13:59:00',1,2,23,1,4,'2020-12-08',15,0,1,0,0,0,0,1,0,1,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_link_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_location`
--

DROP TABLE IF EXISTS `summary_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_location` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_location`
--

LOCK TABLES `summary_location` WRITE;
/*!40000 ALTER TABLE `summary_location` DISABLE KEYS */;
INSERT INTO `summary_location` VALUES (1,'2020-12-11 00:25:39',1,0,13,1,1,'2020-12-08',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,0,13,1,1,'2020-12-14',0,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,0,13,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,0,4,0,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,0,13,1,1,'2020-12-14',0,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_location_hour`
--

DROP TABLE IF EXISTS `summary_location_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_location_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_location_hour`
--

LOCK TABLES `summary_location_hour` WRITE;
/*!40000 ALTER TABLE `summary_location_hour` DISABLE KEYS */;
INSERT INTO `summary_location_hour` VALUES (11,'2020-12-15 03:12:37',1,0,13,1,4,'2020-12-14',14,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(12,'2020-12-15 03:12:37',1,0,13,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,6,4,4,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(13,'2020-12-15 03:12:37',1,0,13,1,4,'2020-12-14',14,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(14,'2021-02-06 13:59:00',1,0,13,1,4,'2020-12-08',15,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_location_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_site`
--

DROP TABLE IF EXISTS `summary_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_site` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_site`
--

LOCK TABLES `summary_site` WRITE;
/*!40000 ALTER TABLE `summary_site` DISABLE KEYS */;
INSERT INTO `summary_site` VALUES (1,'2020-12-11 00:25:39',1,0,11,1,1,'2020-12-08',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:10',1,0,11,1,1,'2020-12-14',0,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:10',1,0,11,1,1,'2020-12-14',0,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(4,'2020-12-14 00:29:10',1,0,11,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,0,4,0,0,0,190,370,0,0,0,0,4,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_site_hour`
--

DROP TABLE IF EXISTS `summary_site_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_site_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_site_hour`
--

LOCK TABLES `summary_site_hour` WRITE;
/*!40000 ALTER TABLE `summary_site_hour` DISABLE KEYS */;
INSERT INTO `summary_site_hour` VALUES (11,'2020-12-15 03:12:37',1,0,11,1,4,'2020-12-14',14,0,3,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(12,'2020-12-15 03:12:37',1,0,11,1,4,'2020-12-14',14,0,2,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(13,'2020-12-15 03:12:37',1,0,11,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,6,6,4,4,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(14,'2021-02-06 13:58:59',1,0,11,1,4,'2020-12-08',15,0,1,0,0,0,0,0,0,0,0,0,0,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_site_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_suid`
--

DROP TABLE IF EXISTS `summary_suid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_suid` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_suid`
--

LOCK TABLES `summary_suid` WRITE;
/*!40000 ALTER TABLE `summary_suid` DISABLE KEYS */;
INSERT INTO `summary_suid` VALUES (1,'2020-12-11 00:25:39',1,0,15,1,1,'2020-12-08',0,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,2,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,0,15,1,1,'2020-12-14',0,0,3,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,0,15,1,1,'2020-12-14',0,0,1,0,0,0,0,1,0,0,0,0,0,0,NULL,0,0,0,4,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,0,15,1,1,'2020-12-14',0,0,2,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(5,'2020-12-14 00:29:11',1,0,15,1,1,'2020-12-14',0,0,1,0,0,0,0,2,0,0,0,0,0,0,NULL,0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(6,'2021-02-06 15:22:56',1,0,15,1,1,'2020-12-08',0,0,1,0,0,0,0,1,0,0,0,0,0,0,'',0,0,0,0,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(7,'2021-02-08 13:51:52',1,0,15,1,1,'2020-12-14',0,0,3,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(8,'2021-02-08 13:51:52',1,0,15,1,1,'2020-12-14',0,0,1,0,0,0,0,1,0,0,0,0,0,0,'',0,0,0,4,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(9,'2021-02-08 13:51:52',1,0,15,1,1,'2020-12-14',0,0,2,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(10,'2021-02-08 13:51:52',1,0,15,1,1,'2020-12-14',0,0,1,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,2,0,2,0,0,0,90,170,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_suid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_suid_hour`
--

DROP TABLE IF EXISTS `summary_suid_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_suid_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_suid_hour`
--

LOCK TABLES `summary_suid_hour` WRITE;
/*!40000 ALTER TABLE `summary_suid_hour` DISABLE KEYS */;
INSERT INTO `summary_suid_hour` VALUES (14,'2020-12-15 03:12:37',1,0,15,1,4,'2020-12-14',14,0,3,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(15,'2020-12-15 03:12:37',1,0,15,1,4,'2020-12-14',14,0,1,0,0,0,0,1,0,0,0,0,0,0,'',0,0,0,4,4,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(16,'2020-12-15 03:12:37',1,0,15,1,4,'2020-12-14',14,0,2,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(17,'2020-12-15 03:12:37',1,0,15,1,4,'2020-12-14',14,0,1,0,0,0,0,2,0,0,0,0,0,0,'',0,0,0,2,2,2,2,0,0,90,170,0,0,0,0,2,0,0,0,0,0),(18,'2021-02-06 13:59:00',1,0,15,1,4,'2020-12-08',15,0,1,0,0,0,0,1,0,0,0,0,0,0,'',0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_suid_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_terminal`
--

DROP TABLE IF EXISTS `summary_terminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_terminal` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_terminal`
--

LOCK TABLES `summary_terminal` WRITE;
/*!40000 ALTER TABLE `summary_terminal` DISABLE KEYS */;
INSERT INTO `summary_terminal` VALUES (1,'2020-12-11 00:25:39',1,0,14,1,1,'2020-12-08',0,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,0,0,2,0,0,0,100,200,0,0,0,0,2,0,0,0,0,0),(2,'2020-12-14 00:29:11',1,0,14,1,1,'2020-12-14',0,0,3,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(3,'2020-12-14 00:29:11',1,0,14,1,1,'2020-12-14',0,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,6,0,4,0,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(4,'2020-12-14 00:29:11',1,0,14,1,1,'2020-12-14',0,0,2,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,0,1,0,0,0,45,85,0,0,0,0,1,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_terminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_terminal_hour`
--

DROP TABLE IF EXISTS `summary_terminal_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_terminal_hour` (
  `summary_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `seller_id` int NOT NULL DEFAULT '0',
  `buyer_id` int NOT NULL DEFAULT '0',
  `summary_type` int NOT NULL,
  `terminal_type` tinyint NOT NULL DEFAULT '1',
  `span` tinyint NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint NOT NULL DEFAULT '0',
  `cvpoint` int NOT NULL DEFAULT '0',
  `site_id` int NOT NULL DEFAULT '0',
  `item_id` int NOT NULL DEFAULT '0',
  `item_type` tinyint NOT NULL DEFAULT '0',
  `location_id` int NOT NULL DEFAULT '0',
  `campaign_id` int NOT NULL DEFAULT '0',
  `article_id` bigint NOT NULL DEFAULT '0',
  `link_id` bigint NOT NULL DEFAULT '0',
  `image_id` bigint NOT NULL DEFAULT '0',
  `keyword_id` bigint NOT NULL DEFAULT '0',
  `page_id` bigint NOT NULL DEFAULT '0',
  `carrier_id` int NOT NULL DEFAULT '0',
  `model_id` int NOT NULL DEFAULT '0',
  `key_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `imp` bigint NOT NULL DEFAULT '0',
  `imp_uniq` bigint NOT NULL DEFAULT '0',
  `imp_loss` bigint NOT NULL DEFAULT '0',
  `click` int NOT NULL DEFAULT '0',
  `click_uniq` int NOT NULL DEFAULT '0',
  `cv` int NOT NULL DEFAULT '0',
  `cv_uniq` int NOT NULL DEFAULT '0',
  `cvi` int NOT NULL DEFAULT '0',
  `cvi_uniq` int NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `wholesale` double NOT NULL DEFAULT '0',
  `retail` bigint NOT NULL DEFAULT '0',
  `buyer_type` tinyint NOT NULL DEFAULT '0',
  `reject` int NOT NULL DEFAULT '0',
  `withdraw` int NOT NULL DEFAULT '0',
  `cv_req` int NOT NULL DEFAULT '0',
  `realtime_wholesale` double NOT NULL DEFAULT '0',
  `realtime_cost` double NOT NULL DEFAULT '0',
  `cv_app_id` int NOT NULL DEFAULT '0',
  `app_store_id` int NOT NULL DEFAULT '0',
  `margin_cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`summary_id`),
  KEY `idx_summary_seller` (`seller_id`,`span`,`date`,`hour`),
  KEY `idx_summary_buyer` (`buyer_id`,`span`,`date`,`hour`),
  KEY `idx_summary_site` (`site_id`,`span`,`date`),
  KEY `idx_summary_item` (`item_id`,`span`,`date`),
  KEY `idx_summary_location` (`location_id`,`span`,`date`),
  KEY `idx_summary_campaign` (`campaign_id`,`span`,`date`),
  KEY `idx_summary_article` (`article_id`,`span`,`date`),
  KEY `idx_summary_link` (`link_id`,`span`,`date`),
  KEY `idx_summary_image` (`image_id`,`span`,`date`),
  KEY `idx_summary_keyword` (`keyword_id`,`span`,`date`),
  KEY `idx_summary_page` (`page_id`,`span`,`date`),
  KEY `idx_summary_carrier` (`carrier_id`,`span`,`date`),
  KEY `idx_summary_model` (`model_id`,`span`,`date`),
  KEY `idx_summary_date` (`span`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_terminal_hour`
--

LOCK TABLES `summary_terminal_hour` WRITE;
/*!40000 ALTER TABLE `summary_terminal_hour` DISABLE KEYS */;
INSERT INTO `summary_terminal_hour` VALUES (11,'2020-12-15 03:12:37',1,0,14,1,4,'2020-12-14',14,0,3,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(12,'2020-12-15 03:12:37',1,0,14,1,4,'2020-12-14',14,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,6,6,4,4,0,0,190,370,0,0,0,0,4,0,0,0,0,0),(13,'2020-12-15 03:12:37',1,0,14,1,4,'2020-12-14',14,0,2,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,1,1,1,1,0,0,45,85,0,0,0,0,1,0,0,0,0,0),(14,'2021-02-06 13:58:59',1,0,14,1,4,'2020-12-08',15,0,1,0,0,0,0,0,0,0,0,0,3,0,NULL,0,0,0,0,0,2,2,0,0,100,200,0,0,0,0,2,0,0,0,0,0);
/*!40000 ALTER TABLE `summary_terminal_hour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-18 14:54:02
