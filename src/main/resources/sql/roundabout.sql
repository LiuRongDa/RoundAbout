/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : roundabout

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-08-24 14:11:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(1000) NOT NULL,
  `article_content` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  `article_photo` varchar(200) DEFAULT NULL,
  `article_state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_article
-- ----------------------------

-- ----------------------------
-- Table structure for tb_article_gambit
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_gambit`;
CREATE TABLE `tb_article_gambit` (
  `article_id` int(11) NOT NULL,
  `gambit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_article_gambit
-- ----------------------------

-- ----------------------------
-- Table structure for tb_article_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_topic`;
CREATE TABLE `tb_article_topic` (
  `topic_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_article_topic
-- ----------------------------

-- ----------------------------
-- Table structure for tb_attention
-- ----------------------------
DROP TABLE IF EXISTS `tb_attention`;
CREATE TABLE `tb_attention` (
  `attention_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_idl` int(11) NOT NULL,
  PRIMARY KEY (`attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_attention
-- ----------------------------

-- ----------------------------
-- Table structure for tb_career
-- ----------------------------
DROP TABLE IF EXISTS `tb_career`;
CREATE TABLE `tb_career` (
  `career_id` int(11) NOT NULL AUTO_INCREMENT,
  `career_name` varchar(50) NOT NULL,
  `degree_id` int(11) NOT NULL,
  PRIMARY KEY (`career_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_career
-- ----------------------------

-- ----------------------------
-- Table structure for tb_collect
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect`;
CREATE TABLE `tb_collect` (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT,
  `collect_title` varchar(1000) NOT NULL,
  `collect_describe` varchar(1000) DEFAULT NULL,
  `collect_state` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_collect
-- ----------------------------

-- ----------------------------
-- Table structure for tb_collect_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect_article`;
CREATE TABLE `tb_collect_article` (
  `collect_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_collect_article
-- ----------------------------

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(1000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_degree
-- ----------------------------
DROP TABLE IF EXISTS `tb_degree`;
CREATE TABLE `tb_degree` (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `degree_name` varchar(50) NOT NULL,
  `occupation_id` int(11) NOT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_degree
-- ----------------------------

-- ----------------------------
-- Table structure for tb_education
-- ----------------------------
DROP TABLE IF EXISTS `tb_education`;
CREATE TABLE `tb_education` (
  `education_id` int(11) NOT NULL AUTO_INCREMENT,
  `education_school` varchar(50) NOT NULL,
  `education_specialty` varchar(50) DEFAULT NULL,
  `occupation_id` int(11) NOT NULL,
  `year_in_id` int(11) NOT NULL,
  `year_out_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`education_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_education
-- ----------------------------

-- ----------------------------
-- Table structure for tb_gambit
-- ----------------------------
DROP TABLE IF EXISTS `tb_gambit`;
CREATE TABLE `tb_gambit` (
  `gambit_id` int(11) NOT NULL AUTO_INCREMENT,
  `gambit_name` varchar(50) NOT NULL,
  PRIMARY KEY (`gambit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_gambit
-- ----------------------------

-- ----------------------------
-- Table structure for tb_idea
-- ----------------------------
DROP TABLE IF EXISTS `tb_idea`;
CREATE TABLE `tb_idea` (
  `idea_id` int(11) NOT NULL AUTO_INCREMENT,
  `idea_content` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  `idea_date` datetime NOT NULL,
  PRIMARY KEY (`idea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_idea
-- ----------------------------

-- ----------------------------
-- Table structure for tb_issue
-- ----------------------------
DROP TABLE IF EXISTS `tb_issue`;
CREATE TABLE `tb_issue` (
  `issue_id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_title` varchar(200) NOT NULL,
  `issue_content` varchar(2000) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_issue
-- ----------------------------

-- ----------------------------
-- Table structure for tb_issue_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_issue_article`;
CREATE TABLE `tb_issue_article` (
  `issue_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_issue_article
-- ----------------------------

-- ----------------------------
-- Table structure for tb_issue_gambit
-- ----------------------------
DROP TABLE IF EXISTS `tb_issue_gambit`;
CREATE TABLE `tb_issue_gambit` (
  `gambit_id` int(11) NOT NULL,
  `issue_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_issue_gambit
-- ----------------------------

-- ----------------------------
-- Table structure for tb_issue_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_issue_user`;
CREATE TABLE `tb_issue_user` (
  `issue_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_issue_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_liveness
-- ----------------------------
DROP TABLE IF EXISTS `tb_liveness`;
CREATE TABLE `tb_liveness` (
  `liveness_id` int(11) NOT NULL AUTO_INCREMENT,
  `liveness_endtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`liveness_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_liveness
-- ----------------------------

-- ----------------------------
-- Table structure for tb_occupation
-- ----------------------------
DROP TABLE IF EXISTS `tb_occupation`;
CREATE TABLE `tb_occupation` (
  `occupation_id` int(11) NOT NULL AUTO_INCREMENT,
  `occupation_name` varchar(20) NOT NULL,
  PRIMARY KEY (`occupation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_occupation
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pay
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay`;
CREATE TABLE `tb_pay` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_money` double NOT NULL,
  `pay_data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `pay_state` int(11) NOT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_pay
-- ----------------------------

-- ----------------------------
-- Table structure for tb_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_power`;
CREATE TABLE `tb_power` (
  `power_id` int(11) NOT NULL AUTO_INCREMENT,
  `power_name` varchar(50) NOT NULL,
  `power_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_power
-- ----------------------------

-- ----------------------------
-- Table structure for tb_praise
-- ----------------------------
DROP TABLE IF EXISTS `tb_praise`;
CREATE TABLE `tb_praise` (
  `praise_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `issue_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `reply_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`praise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_praise
-- ----------------------------

-- ----------------------------
-- Table structure for tb_profession
-- ----------------------------
DROP TABLE IF EXISTS `tb_profession`;
CREATE TABLE `tb_profession` (
  `profession_id` int(11) NOT NULL AUTO_INCREMENT,
  `profession_company` varchar(50) DEFAULT NULL,
  `profession_position` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `profession_start` datetime NOT NULL,
  `profession_end` datetime NOT NULL,
  PRIMARY KEY (`profession_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_profession
-- ----------------------------

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_content` varchar(1000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `reply_idto` int(11) DEFAULT NULL,
  `reply_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_reply
-- ----------------------------

-- ----------------------------
-- Table structure for tb_report
-- ----------------------------
DROP TABLE IF EXISTS `tb_report`;
CREATE TABLE `tb_report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `report_data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `report_content` varchar(1000) NOT NULL,
  `issue_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `reply_id` int(11) NOT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_report
-- ----------------------------

-- ----------------------------
-- Table structure for tb_reward
-- ----------------------------
DROP TABLE IF EXISTS `tb_reward`;
CREATE TABLE `tb_reward` (
  `reward_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_idl` int(11) NOT NULL,
  `reward_money` double NOT NULL,
  `reward_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_reward
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_power`;
CREATE TABLE `tb_role_power` (
  `role_id` int(11) NOT NULL,
  `power_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_role_power
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sgs
-- ----------------------------
DROP TABLE IF EXISTS `tb_sgs`;
CREATE TABLE `tb_sgs` (
  `sgs_id` int(11) NOT NULL AUTO_INCREMENT,
  `sgs_school` varchar(50) NOT NULL,
  `sgs_info` varchar(1000) NOT NULL,
  `sgs_prove` varchar(200) NOT NULL,
  `sgs_name` varchar(20) NOT NULL,
  `sgs_idcard` varchar(18) NOT NULL,
  `sgs_photo` varchar(200) NOT NULL,
  `occupation_id` int(11) NOT NULL,
  `degree_id` int(11) NOT NULL,
  `career_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sgs_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sgs_result` int(11) NOT NULL,
  PRIMARY KEY (`sgs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sgs
-- ----------------------------

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_staff`;
CREATE TABLE `tb_staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) NOT NULL,
  `staff_number` varchar(50) NOT NULL,
  `staff_pwd` varchar(200) NOT NULL,
  `staff_sex` int(11) NOT NULL,
  `staff_idcard` varchar(20) NOT NULL,
  `staff_phone` varchar(20) DEFAULT NULL,
  `staff_in` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `staff_out` datetime NOT NULL,
  `staff_state` int(11) NOT NULL DEFAULT '0',
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_topic
-- ----------------------------

-- ----------------------------
-- Table structure for tb_topic_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_user`;
CREATE TABLE `tb_topic_user` (
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_topic_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_trade
-- ----------------------------
DROP TABLE IF EXISTS `tb_trade`;
CREATE TABLE `tb_trade` (
  `trade_id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_name` varchar(50) NOT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_trade
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_photo` varchar(50) DEFAULT NULL,
  `user_backdrop` varchar(50) DEFAULT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(200) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_sign` varchar(200) DEFAULT NULL,
  `user_residence` varchar(200) DEFAULT NULL,
  `trade_id` int(11) DEFAULT NULL,
  `user_brief` varchar(200) DEFAULT NULL,
  `user_balance` double DEFAULT NULL,
  `user_count` int(11) DEFAULT NULL,
  `user_joindate` datetime NOT NULL,
  `user_state` int(11) NOT NULL,
  `user_isexpired` int(11) NOT NULL DEFAULT '1',
  `user_islocked` int(11) NOT NULL DEFAULT '1',
  `user_isCreExpired` int(11) NOT NULL DEFAULT '1',
  `user_isenable` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
