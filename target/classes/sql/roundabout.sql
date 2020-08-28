/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : roundabout

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-08-28 08:53:59
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('1', '', '孩子玩手机到底对不对？', '1', 'null', '0');
INSERT INTO `tb_article` VALUES ('2', '', '睡前多喝水好不好', '2', 'null', '0');
INSERT INTO `tb_article` VALUES ('3', '', '多吃水果有什么好处?', '3', 'null', '0');
INSERT INTO `tb_article` VALUES ('4', '老鼠吃盐会变成蝙蝠吗', '我是老鼠，我今天吃了盐，为什么还没有变在线等，急！！！', '4', 'null', '0');

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
INSERT INTO `tb_article_gambit` VALUES ('1', '1');
INSERT INTO `tb_article_gambit` VALUES ('2', '2');
INSERT INTO `tb_article_gambit` VALUES ('3', '3');
INSERT INTO `tb_article_gambit` VALUES ('4', '4');

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
INSERT INTO `tb_article_topic` VALUES ('1', '1');
INSERT INTO `tb_article_topic` VALUES ('2', '2');
INSERT INTO `tb_article_topic` VALUES ('3', '3');
INSERT INTO `tb_article_topic` VALUES ('4', '4');

-- ----------------------------
-- Table structure for tb_attention
-- ----------------------------
DROP TABLE IF EXISTS `tb_attention`;
CREATE TABLE `tb_attention` (
  `attention_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_idl` int(11) NOT NULL,
  PRIMARY KEY (`attention_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_attention
-- ----------------------------
INSERT INTO `tb_attention` VALUES ('1', '1', '1');
INSERT INTO `tb_attention` VALUES ('2', '2', '2');
INSERT INTO `tb_attention` VALUES ('3', '3', '3');
INSERT INTO `tb_attention` VALUES ('4', '4', '4');

-- ----------------------------
-- Table structure for tb_career
-- ----------------------------
DROP TABLE IF EXISTS `tb_career`;
CREATE TABLE `tb_career` (
  `career_id` int(11) NOT NULL AUTO_INCREMENT,
  `career_name` varchar(50) NOT NULL,
  `degree_id` int(11) NOT NULL,
  PRIMARY KEY (`career_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_career
-- ----------------------------
INSERT INTO `tb_career` VALUES ('1', '计算机', '1');
INSERT INTO `tb_career` VALUES ('2', '土木工程系', '2');
INSERT INTO `tb_career` VALUES ('3', '医学', '3');
INSERT INTO `tb_career` VALUES ('4', '服装设计', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_collect
-- ----------------------------
INSERT INTO `tb_collect` VALUES ('1', '孩子玩手机到底对不对', '充分了解孩子的心理', '0', '1');
INSERT INTO `tb_collect` VALUES ('2', '睡前多喝水好不好', '了解多喝水对身体的危害', '0', '2');
INSERT INTO `tb_collect` VALUES ('3', '多吃水果有什么好处?', '了解水果富含丰富的维生素，增强人体免疫力', '0', '3');
INSERT INTO `tb_collect` VALUES ('4', '老鼠吃盐会变成蝙蝠吗', '了解老鼠和蝙蝠的区别', '0', '4');

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
INSERT INTO `tb_collect_article` VALUES ('1', '1');
INSERT INTO `tb_collect_article` VALUES ('2', '2');
INSERT INTO `tb_collect_article` VALUES ('3', '3');
INSERT INTO `tb_collect_article` VALUES ('4', '4');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(1000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1', '淘米水根本就不能美白，用淘米谁做面膜只能是暂时性的使皮肤变白，一般来说5分钟之后就变回原来的肤色了，因为那只是相当于在脸上涂了一层白色的物质，根本就没用。', '1', '2020-08-24 18:59:09', '1');
INSERT INTO `tb_comment` VALUES ('2', '不建议晚上睡前喝水。晚上喝水以后，人处于睡眠状态是属于相对静止的状态，血液循环，体内代谢都比较缓慢，水湿停留于体内时间长容易加重脏腑的功能负担。如果水湿不能够及时排出体外，也会出现颜面浮肿等现象；如果体内水湿，及时排出体外，晚上小便次数过多，又会影响人体正常的睡眠时间，不能够保证睡眠质量。如果天气炎热，房间内温度比较高，比较干燥，体内出现口干口渴缺水的状态，在睡觉前半个小时可以适当的喝少量的水以补充体液，可以稀释血液，促进血液循环，有利于心脑血管的健康。 ', '2', '2020-08-24 19:00:11', '1');
INSERT INTO `tb_comment` VALUES ('3', '水果中含有非常丰富的果酸、果糖、纤维素、维生素等成分，经常吃水果，可以有效地吸收其中的微量元素，不但可以促进食欲，增加饱腹感，还可以加速肠道蠕动，改善便秘现象。\r\n对于咽喉肿痛、口舌生疮有改善功效，还可以补充丰富的维生素C和维生素E，起到美白皮肤的作用。但是需要注意，水果吃得太多，也有可能升高体内的酸性，对于胃粘膜溃疡的人群不利。\r\n', '3', '2020-08-24 19:54:36', '1');
INSERT INTO `tb_comment` VALUES ('4', '蝙蝠和老鼠都是哺乳动物，前者是翼手目，后者是啮齿目，所以演化路径不同。那么蝙蝠究竟是什么动物呢？其实它既不和老鼠同类，也不和鸟同类，而是独霸了翼手目这一个类目，是哺乳动物中仅次于啮齿目动物的第二大类群。蝙蝠它可以像鸟一样鼓翼飞行，这一点是其他任何哺乳动物所不具备的，据生物学家考证翼手目很可能和灵长目有着共同的祖先，可见蝙蝠和老鼠并没有多么亲近的血缘关系，而大家一直相信传说，也不过是因为二者长得像声音像而已。', '4', '2020-08-24 19:56:34', '1');

-- ----------------------------
-- Table structure for tb_degree
-- ----------------------------
DROP TABLE IF EXISTS `tb_degree`;
CREATE TABLE `tb_degree` (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `degree_name` varchar(50) NOT NULL,
  `occupation_id` int(11) NOT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_degree
-- ----------------------------
INSERT INTO `tb_degree` VALUES ('1', '学士', '1');
INSERT INTO `tb_degree` VALUES ('2', '博士', '2');
INSERT INTO `tb_degree` VALUES ('3', '硕士', '3');

-- ----------------------------
-- Table structure for tb_education
-- ----------------------------
DROP TABLE IF EXISTS `tb_education`;
CREATE TABLE `tb_education` (
  `education_id` int(11) NOT NULL AUTO_INCREMENT,
  `education_school` varchar(50) NOT NULL,
  `education_specialty` varchar(50) DEFAULT NULL,
  `education_occupation` varchar(20) NOT NULL,
  `education_inyear` int(11) NOT NULL,
  `education_outyear` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`education_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_education
-- ----------------------------
INSERT INTO `tb_education` VALUES ('1', '河南致远', '软件开发', '1', '2000', '2004', '1');
INSERT INTO `tb_education` VALUES ('2', '郑州大学', '土木工程', '2', '2000', '2004', '2');
INSERT INTO `tb_education` VALUES ('3', '郑州工商', '金融管理', '3', '2000', '2004', '3');
INSERT INTO `tb_education` VALUES ('4', '郑州铁路', '铁路管理', '4', '2000', '2004', '4');

-- ----------------------------
-- Table structure for tb_gambit
-- ----------------------------
DROP TABLE IF EXISTS `tb_gambit`;
CREATE TABLE `tb_gambit` (
  `gambit_id` int(11) NOT NULL AUTO_INCREMENT,
  `gambit_name` varchar(50) NOT NULL,
  PRIMARY KEY (`gambit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_gambit
-- ----------------------------
INSERT INTO `tb_gambit` VALUES ('1', '孩子玩手机到底对不对');
INSERT INTO `tb_gambit` VALUES ('2', '熬夜对身体的危害');
INSERT INTO `tb_gambit` VALUES ('3', '论对熊孩子淘气的100惩罚');
INSERT INTO `tb_gambit` VALUES ('4', '夏天多泡脚的好处');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_idea
-- ----------------------------
INSERT INTO `tb_idea` VALUES ('1', '通过《孩子玩手机到底对不对》这篇文章，让我了解到了孩子的心理。', '1', '2020-08-24 18:49:24');
INSERT INTO `tb_idea` VALUES ('2', '通过《熬夜对身体的危害》了解到早休息的好处', '2', '2020-08-25 08:35:31');
INSERT INTO `tb_idea` VALUES ('3', '通过《论熊孩子淘气的100种惩罚》了解到熊孩子的心理', '3', '2020-08-25 08:39:05');
INSERT INTO `tb_idea` VALUES ('4', '通过《夏天多泡脚的好处》了解泡脚的好处，知道养生的重要性', '4', '2020-08-25 08:41:01');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_issue
-- ----------------------------
INSERT INTO `tb_issue` VALUES ('1', '用淘米水洗脸真的能美白吗？', '淘米水是可以美白的，它里面富含丰富的蛋白质和微量元素，还有维生素等等，能够防止紫外线，减少黑色素再生，从而达到美白的功效，且不会对皮肤产生刺激性，敏感肌也能使用。', '1');
INSERT INTO `tb_issue` VALUES ('2', '睡前喝水到底好不好', '晚上9点以后最好不要再喝水了，尤其是晚上容易起夜的人，在晚上起来上厕所会对睡眠造成影响，同时也会对家人的睡眠造成影响，假如是在口渴可以少喝一些。', '2');
INSERT INTO `tb_issue` VALUES ('3', '多吃水果到底好不好', '新鲜水果中含丰富多彩的抗氧化性物质维生素E和营养元素，能够滋润皮肤，其美容护肤实际效果并不是一般的护肤品相比的。', '3');
INSERT INTO `tb_issue` VALUES ('4', '老鼠吃盐会变成蝙蝠吗', '蝙蝠和老鼠不是近亲，它们最近的关系也得追溯到大约2亿年前，之所以会产生“蝙蝠和老鼠是近亲”的想法，源于民间一种根深蒂固的观念，即根据长相判断起源或亲缘关系，但是这种判断是没有科学依据的，大部分情况下都是错的。', '4');

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
INSERT INTO `tb_issue_article` VALUES ('1', '1');
INSERT INTO `tb_issue_article` VALUES ('2', '2');
INSERT INTO `tb_issue_article` VALUES ('3', '3');

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
INSERT INTO `tb_issue_gambit` VALUES ('1', '1');
INSERT INTO `tb_issue_gambit` VALUES ('2', '2');
INSERT INTO `tb_issue_gambit` VALUES ('3', '3');
INSERT INTO `tb_issue_gambit` VALUES ('4', '4');

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
INSERT INTO `tb_issue_user` VALUES ('1', '1');
INSERT INTO `tb_issue_user` VALUES ('2', '2');
INSERT INTO `tb_issue_user` VALUES ('3', '3');
INSERT INTO `tb_issue_user` VALUES ('4', '4');

-- ----------------------------
-- Table structure for tb_liveness
-- ----------------------------
DROP TABLE IF EXISTS `tb_liveness`;
CREATE TABLE `tb_liveness` (
  `liveness_id` int(11) NOT NULL AUTO_INCREMENT,
  `liveness_endtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`liveness_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_liveness
-- ----------------------------
INSERT INTO `tb_liveness` VALUES ('1', '2020-08-24 18:29:12', '1');
INSERT INTO `tb_liveness` VALUES ('2', '2020-08-25 08:53:28', '2');
INSERT INTO `tb_liveness` VALUES ('3', '2020-08-25 08:53:36', '3');
INSERT INTO `tb_liveness` VALUES ('4', '2020-08-25 08:53:44', '4');

-- ----------------------------
-- Table structure for tb_occupation
-- ----------------------------
DROP TABLE IF EXISTS `tb_occupation`;
CREATE TABLE `tb_occupation` (
  `occupation_id` int(11) NOT NULL AUTO_INCREMENT,
  `occupation_name` varchar(20) NOT NULL,
  PRIMARY KEY (`occupation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_occupation
-- ----------------------------
INSERT INTO `tb_occupation` VALUES ('1', '专科教育');
INSERT INTO `tb_occupation` VALUES ('2', '本科教育');
INSERT INTO `tb_occupation` VALUES ('3', '研究生教育');
INSERT INTO `tb_occupation` VALUES ('4', '高中');
INSERT INTO `tb_occupation` VALUES ('5', '初中');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_pay
-- ----------------------------
INSERT INTO `tb_pay` VALUES ('1', '10', '2020-08-24 19:06:44', '1', '0');
INSERT INTO `tb_pay` VALUES ('2', '10', '2020-08-25 08:54:48', '2', '0');
INSERT INTO `tb_pay` VALUES ('3', '10', '2020-08-25 08:55:23', '3', '0');
INSERT INTO `tb_pay` VALUES ('4', '10', '2020-08-25 08:55:39', '4', '0');

-- ----------------------------
-- Table structure for tb_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_power`;
CREATE TABLE `tb_power` (
  `power_id` int(11) NOT NULL AUTO_INCREMENT,
  `power_name` varchar(50) NOT NULL,
  `power_url` varchar(220) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_power
-- ----------------------------
INSERT INTO `tb_power` VALUES ('1', '用户管理', '#', '0', 'el-icon-loading');
INSERT INTO `tb_power` VALUES ('2', '员工管理', '#1', '0', 'el-icon-monitor');
INSERT INTO `tb_power` VALUES ('3', '财务中心', '#2', '0', 'el-icon-bank-card');
INSERT INTO `tb_power` VALUES ('4', '权限管理', '#3', '0', 'el-icon-mobile');
INSERT INTO `tb_power` VALUES ('5', '申诉管理', '#4', '0', 'el-icon-message');
INSERT INTO `tb_power` VALUES ('6', '个人中心', 'personal', '0', 'el-icon-user-solid');
INSERT INTO `tb_power` VALUES ('7', '用户详情', 'dashboard', '1', null);
INSERT INTO `tb_power` VALUES ('8', '员工详情', 'staff', '2', null);
INSERT INTO `tb_power` VALUES ('9', '统计', '#6', '3', null);
INSERT INTO `tb_power` VALUES ('10', '报表', '#7', '3', null);
INSERT INTO `tb_power` VALUES ('11', '设置权限', '#8', '4', null);
INSERT INTO `tb_power` VALUES ('12', '查看详情', '#9', '5', null);
INSERT INTO `tb_power` VALUES ('13', '申诉', '#10', '5', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_praise
-- ----------------------------
INSERT INTO `tb_praise` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `tb_praise` VALUES ('2', '2', '2', '2', '2', '2');
INSERT INTO `tb_praise` VALUES ('3', '3', '3', '3', '3', '3');
INSERT INTO `tb_praise` VALUES ('4', '4', '4', '4', '4', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_profession
-- ----------------------------
INSERT INTO `tb_profession` VALUES ('1', 'AAA软件教育', '程序猿', '1', '2020-08-24 18:31:31', '2020-08-24 18:31:36');
INSERT INTO `tb_profession` VALUES ('2', '半亩花田', '人事经理', '2', '2020-08-25 08:58:06', '2020-08-25 08:58:10');
INSERT INTO `tb_profession` VALUES ('3', '双汇', '销售员', '3', '2020-08-25 08:58:37', '2020-08-25 08:58:41');
INSERT INTO `tb_profession` VALUES ('4', '阿里巴巴', '淘宝商家', '4', '2020-08-25 08:59:08', '2020-08-25 08:59:13');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_reply
-- ----------------------------
INSERT INTO `tb_reply` VALUES ('1', '每天早晚用第一次的淘米水洗脸，轻轻按摩和拍打面部，使淘米水里的营养成分渗入皮肤，最后用清水洗净。敏感皮肤也可以用哦。', '1', '1', '1', '2020-08-24 19:02:08');
INSERT INTO `tb_reply` VALUES ('2', '晚上9点以后最好不要再喝水了，尤其是晚上容易起夜的人，在晚上起来上厕所会对睡眠造成影响，同时也会对家人的睡眠造成影响，假如是在口渴可以少喝一些。', '2', '2', '2', '2020-08-25 09:01:22');
INSERT INTO `tb_reply` VALUES ('3', '新鲜水果中含丰富多彩的抗氧化性物质维生素E和营养元素，能够滋润皮肤，其美容护肤实际效果并不是一般的护肤品相比的。', '3', '3', '3', '2020-08-25 09:01:55');
INSERT INTO `tb_reply` VALUES ('4', '蝙蝠和老鼠不是近亲，它们最近的关系也得追溯到大约2亿年前，之所以会产生“蝙蝠和老鼠是近亲”的想法，源于民间一种根深蒂固的观念，即根据长相判断起源或亲缘关系，但是这种判断是没有科学依据的，大部分情况下都是错的', '4', '4', '4', '2020-08-25 09:02:39');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_report
-- ----------------------------
INSERT INTO `tb_report` VALUES ('1', '1', '2020-08-24 19:04:44', '这是谣言。不信谣，不传谣', '1', '1', '1', '1');
INSERT INTO `tb_report` VALUES ('2', '2', '2020-08-25 09:03:09', '涉嫌色情', '2', '2', '2', '2');
INSERT INTO `tb_report` VALUES ('3', '3', '2020-08-25 09:03:56', '发表不文明帖子', '3', '3', '3', '3');
INSERT INTO `tb_report` VALUES ('4', '4', '2020-08-25 09:04:29', '涉及人身攻击', '4', '4', '4', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_reward
-- ----------------------------
INSERT INTO `tb_reward` VALUES ('1', '1', '1', '10', '2020-08-24 19:08:13');
INSERT INTO `tb_reward` VALUES ('2', '2', '2', '10', '2020-08-25 09:06:07');
INSERT INTO `tb_reward` VALUES ('3', '3', '3', '10', '2020-08-25 09:06:18');
INSERT INTO `tb_reward` VALUES ('4', '4', '4', '10', '2020-08-25 09:06:31');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  `role_admin_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员', 'ROLE_ADMIN');
INSERT INTO `tb_role` VALUES ('2', '财务', 'ROLE_FINANCE');
INSERT INTO `tb_role` VALUES ('3', '申诉', 'ROLE_APPEAL');

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
INSERT INTO `tb_role_power` VALUES ('1', '7');
INSERT INTO `tb_role_power` VALUES ('1', '2');
INSERT INTO `tb_role_power` VALUES ('1', '1');
INSERT INTO `tb_role_power` VALUES ('1', '5');
INSERT INTO `tb_role_power` VALUES ('1', '4');
INSERT INTO `tb_role_power` VALUES ('1', '6');
INSERT INTO `tb_role_power` VALUES ('1', '3');
INSERT INTO `tb_role_power` VALUES ('1', '8');
INSERT INTO `tb_role_power` VALUES ('1', '9');
INSERT INTO `tb_role_power` VALUES ('1', '10');
INSERT INTO `tb_role_power` VALUES ('1', '11');
INSERT INTO `tb_role_power` VALUES ('1', '12');
INSERT INTO `tb_role_power` VALUES ('1', '13');
INSERT INTO `tb_role_power` VALUES ('2', '3');
INSERT INTO `tb_role_power` VALUES ('2', '6');
INSERT INTO `tb_role_power` VALUES ('2', '9');
INSERT INTO `tb_role_power` VALUES ('2', '10');
INSERT INTO `tb_role_power` VALUES ('3', '5');
INSERT INTO `tb_role_power` VALUES ('3', '6');
INSERT INTO `tb_role_power` VALUES ('3', '12');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_sgs
-- ----------------------------
INSERT INTO `tb_sgs` VALUES ('1', 'AAA软件教育', 'AAA教育根据高校培养方案和教学计划，筛选优秀学生参与兴趣班，由AAA软件教育A级讲师带领中原工学院学生共同参与项目研发与新技术点的拓展学习，综合提升学生技术能力以及项目动手能力。', 'null', '林黛玉', '412983200312155923', 'null', '1', '1', '1', '1', '2020-08-24 19:33:20', '0');
INSERT INTO `tb_sgs` VALUES ('2', '郑州大学', '郑州大学（Zhengzhou University，简称“郑大”），于1956年始建，坐落于河南省会郑州，是中华人民共和国教育部与河南省人民政府“部省合作共建高校”，国家“世界一流大学建设高校”“211工程”“一省一校”重点建设高校。其于2000年7月由原郑州大学、郑州工业大学、河南医科大学合并组建新郑州大学。', 'null', '贾宝玉', '412821199707186012', 'null', '2', '2', '2', '2', '2020-08-25 09:12:47', '0');
INSERT INTO `tb_sgs` VALUES ('3', '郑州工商', '郑州工商学院（简称郑商院，Zhengzhou Technology and Business University），于2002年始建，位于河南省郑州市，是经教育部批准设立的一所全日制民办普通本科院校，前身为河南理工大学万方科技学院。', 'null', '薛宝钗', '412921200011236914', 'null', '3', '3', '3', '3', '2020-08-25 09:15:31', '0');
INSERT INTO `tb_sgs` VALUES ('4', '郑州铁路', '郑州铁路职业技术学院创建于1951年，是经教育部批准的全日制普通高等学校，也是全国铁路第一所独立设置的高等职业技术学院。[1]\r\n其由郑州铁路机械学校、郑州铁路卫生学校、郑州铁路教育学院和郑州铁路师范学校合并而成[2]。2010年，入选国家骨干高职院校立项单位。2017年，入选河南省国家级优质高等职业院校建设项目。', 'null', '王熙凤', '418421199803156012', 'null', '4', '4', '4', '4', '2020-08-25 09:17:52', '0');

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
  `staff_out` datetime DEFAULT NULL,
  `staff_state` int(11) NOT NULL DEFAULT '0',
  `role_id` int(11) NOT NULL,
  `user_isexpired` int(11) NOT NULL DEFAULT '1',
  `user_islocked` int(11) NOT NULL DEFAULT '1',
  `user_isCreExpired` int(11) NOT NULL DEFAULT '1',
  `user_isenable` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
INSERT INTO `tb_staff` VALUES ('1', 'zss', 'zs', '$2a$10$6dIwfb97VItaWsu12W3zme34QoV7EKQW1vJO4dtfF7nIIf72hctiu', '0', '412821200837165012', '12345678910', '2020-08-24 19:22:29', '2020-08-24 19:22:47', '0', '1', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('2', '刘备', 'liu123456', '$2a$10$SDzTDQZnT8fk69Qqoqlos..hxblvDwkfw2/mg7yH1igmeOYobpT/S', '0', '412743188612126012', '10987654321', '2020-08-25 09:19:17', '2020-08-25 09:19:20', '0', '2', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('3', '大乔', 'qiao123456', '$2a$10$SDzTDQZnT8fk69Qqoqlos..hxblvDwkfw2/mg7yH1igmeOYobpT/S', '1', '427361199611156022', '98765432110', '2020-08-25 09:21:08', '2020-08-25 09:21:11', '0', '3', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('4', '孙尚香', 'sun123456', 'sun123456', '1', '431862200207156842', '10293847561', '2020-08-25 09:22:38', '2020-08-25 09:22:41', '0', '1', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('6', '123', '123', '123', '1', '123', '123', '2020-08-26 19:18:59', null, '0', '2', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('7', 'aa', 'aaa', 'a', '1', '123', '123', '2020-08-26 19:24:46', null, '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_staff` VALUES ('10', 'ww', '123', '$2a$10$QwA/XvBsuwV.k7fv6ljy8./ZhKt3h/q1SNbvqLPdwrXY3RU5pu3Hi', '1', '123', '123', '2020-08-27 09:59:48', null, '0', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_topic
-- ----------------------------
INSERT INTO `tb_topic` VALUES ('1', '孩子玩手机到底对不对', '1');
INSERT INTO `tb_topic` VALUES ('2', '睡前多喝水到底好不好', '2');
INSERT INTO `tb_topic` VALUES ('3', '多吃水果有没有好处', '3');
INSERT INTO `tb_topic` VALUES ('4', '老鼠吃盐会变成蝙蝠吗', '4');

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
INSERT INTO `tb_topic_user` VALUES ('1', '1');

-- ----------------------------
-- Table structure for tb_trade
-- ----------------------------
DROP TABLE IF EXISTS `tb_trade`;
CREATE TABLE `tb_trade` (
  `trade_id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_name` varchar(50) NOT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_trade
-- ----------------------------
INSERT INTO `tb_trade` VALUES ('1', '2020');
INSERT INTO `tb_trade` VALUES ('2', '2021');
INSERT INTO `tb_trade` VALUES ('3', '2022');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_photo` varchar(50) DEFAULT NULL,
  `user_backdrop` varchar(50) DEFAULT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(200) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_sign` varchar(200) DEFAULT NULL,
  `user_residence` varchar(200) DEFAULT NULL,
  `user_trade` varchar(200) DEFAULT NULL,
  `user_brief` varchar(200) DEFAULT NULL,
  `user_balance` double DEFAULT NULL,
  `user_count` int(11) DEFAULT NULL,
  `user_joindate` datetime NOT NULL,
  `user_state` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zs', 'null', 'null', '12345678910', '12345@qq.com', '$2a$10$Iqq0rAnbwVrBpo4V7DNWueQVUe3FsoEmZT3lrJHtTDpJv0w7CROBq', '0', '个性签名', '河南郑州', '1', '个人简介', '0', '0', '2020-08-24 18:27:30', '0');
INSERT INTO `tb_user` VALUES ('2', '李四', 'null', 'null', '66666666666', '23456@qq.com', '$2a$10$6HdiJ6f/kTvzliZWpzyp/e41TW1AnyYyfHP/8Ik3Bu5vjldrVxF0a', '0', '因为不个性，所以不签名', '河南南阳', '2', '个人简介', '0', '0', '2020-08-25 09:28:25', '0');
INSERT INTO `tb_user` VALUES ('3', '王五', 'null', 'null', '77777777777', '34567@qq.com', '$2a$10$ejYT9Csh.X32FAZhgzHDBuwxaTwNDb7xyvWKcPr.oKm1sE/9rUlVm', '0', '个性签名', '河南信阳', '3', '个人简介', '0', '0', '2020-08-25 09:30:50', '0');
INSERT INTO `tb_user` VALUES ('4', '赵六', 'null', 'null', '99999999999', '45678@qq.com', 'admin', '0', '个性签名', '河南濮阳', '2', '个人简介', '0', '0', '2020-08-25 09:31:32', '0');
