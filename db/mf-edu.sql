/*
 Navicat Premium Data Transfer

 Source Server         : Home Mysql
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : home-linux:33306
 Source Schema         : mf-edu

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 08/09/2021 23:02:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_class_room
-- ----------------------------
DROP TABLE IF EXISTS `tbl_class_room`;
CREATE TABLE `tbl_class_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `class_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `curriculum` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '班级对应的课程',
  `teacher_id` bigint(20) DEFAULT NULL,
  `class_code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL COMMENT '对应的年级',
  `course_id` bigint(20) DEFAULT NULL COMMENT '对应的科目',
  `pre_open_time` datetime DEFAULT NULL COMMENT '预计开班时间',
  `pre_close_time` datetime DEFAULT NULL COMMENT '预计关班时间',
  `open_time` datetime DEFAULT NULL COMMENT '实际开班时间',
  `close_time` datetime DEFAULT NULL COMMENT '实际关班时间',
  `type` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '教室类型：一对一，小班',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='教室表';

-- ----------------------------
-- Records of tbl_class_room
-- ----------------------------
BEGIN;
INSERT INTO `tbl_class_room` VALUES (6, 1, '2019-12-05 19:11:13', 1, '2019-12-05 19:11:13', b'0', '教室一', '数学', 1, '001', 1, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_class_room` VALUES (7, 1, '2020-02-02 20:42:01', 1, '2020-02-02 20:42:01', b'0', '0.', 'test', 1, '123', 1, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_classroom_student_ref
-- ----------------------------
DROP TABLE IF EXISTS `tbl_classroom_student_ref`;
CREATE TABLE `tbl_classroom_student_ref` (
  `id` bigint(20) NOT NULL,
  `class_id` bigint(20) DEFAULT NULL COMMENT '教室id',
  `student_id` bigint(20) DEFAULT NULL COMMENT '学生id',
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_classroom_student_ref
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_code
-- ----------------------------
DROP TABLE IF EXISTS `tbl_code`;
CREATE TABLE `tbl_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `seq_num` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `code_group_code` varchar(30) NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_code_code_group_code` (`code_group_code`) USING BTREE,
  CONSTRAINT `fk_code_code_group_code` FOREIGN KEY (`code_group_code`) REFERENCES `tbl_code_group` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_code
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code` VALUES (341, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, '1', '平台运营人员', 1, '平台运营人员', 'user_type', b'0');
INSERT INTO `tbl_code` VALUES (346, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, 'A', '有效的', 1, '有效的', 'user_status', b'0');
INSERT INTO `tbl_code` VALUES (351, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 3, 'technology', '科技', 1, '科技', 'newsFunCode', b'0');
INSERT INTO `tbl_code` VALUES (353, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, '0', '未发布', 1, '新闻未发布状态', 'newsStatus', b'0');
INSERT INTO `tbl_code` VALUES (354, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, '1', '已发布', 1, '新闻已发布状态', 'newsStatus', b'0');
INSERT INTO `tbl_code` VALUES (355, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, 'entertainment', '娱乐', 2, NULL, 'newsFunCode', b'0');
INSERT INTO `tbl_code` VALUES (356, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, 'test', '测试', 3, NULL, 'newsFunCode', b'0');
COMMIT;

-- ----------------------------
-- Table structure for tbl_code_group
-- ----------------------------
DROP TABLE IF EXISTS `tbl_code_group`;
CREATE TABLE `tbl_code_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_code_group
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code_group` VALUES (134, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 2, 'user_type', '用户类型', '用户类型', b'0');
INSERT INTO `tbl_code_group` VALUES (139, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 1, 'user_status', '用户状态', '用户状态', b'0');
INSERT INTO `tbl_code_group` VALUES (143, 1, '2019-04-23 21:18:23', 1, '2019-04-23 21:18:23', 2, 'newsFunCode', '新闻分类', '新闻分类', b'0');
INSERT INTO `tbl_code_group` VALUES (146, 1, '2018-09-13 15:47:34', 1, '2019-04-23 21:18:23', 1, 'newsStatus', '新闻状态', '新闻状态', b'0');
COMMIT;

-- ----------------------------
-- Table structure for tbl_course
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `course_name` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `course_code` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='课程表';

-- ----------------------------
-- Records of tbl_course
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_courseware
-- ----------------------------
DROP TABLE IF EXISTS `tbl_courseware`;
CREATE TABLE `tbl_courseware` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `courseware_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课件名称',
  `courseware_code` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课件代码',
  `version` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `download_times` int(10) DEFAULT NULL,
  `cover_img` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课件封面图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='课件表';

-- ----------------------------
-- Records of tbl_courseware
-- ----------------------------
BEGIN;
INSERT INTO `tbl_courseware` VALUES (7, 1, '2020-01-14 20:56:52', 1, '2020-01-14 22:13:47', b'0', '桃花模板，课件测试', '桃花模板', '123', 3, 'http://img.kimen.com.cn/1579006603184_桃花模板.pptx', 'PUBLIC', NULL, NULL, 'http://img.kimen.com.cn/1579011224913_cropped.png');
INSERT INTO `tbl_courseware` VALUES (8, 1, '2020-01-14 21:14:04', 1, '2020-01-14 21:14:04', b'0', '234', '234', '234', 1, 'http://img.kimen.com.cn/1579007596978_新建 PPTX 演示文稿.pptx', 'PUBLIC', NULL, NULL, 'http://img.kimen.com.cn/1579007641442_cropped.png');
INSERT INTO `tbl_courseware` VALUES (9, 1, '2020-01-16 21:02:31', 1, '2020-01-16 21:02:31', b'0', NULL, '测试课件名称', '455', 1, 'http://img.kimen.com.cn/1579179723632_桃花模板.pptx', 'PUBLIC', NULL, NULL, 'http://img.kimen.com.cn/1579179748006_cropped.png');
INSERT INTO `tbl_courseware` VALUES (10, 1, '2020-01-16 21:07:03', 1, '2020-01-16 21:07:03', b'0', '测试课件2', '测试课件2', NULL, 1, 'http://img.kimen.com.cn/1579180005267_桃花模板.pptx', 'PUBLIC', NULL, NULL, 'http://img.kimen.com.cn/1579180022090_cropped.png');
COMMIT;

-- ----------------------------
-- Table structure for tbl_courseware_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_courseware_user`;
CREATE TABLE `tbl_courseware_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `size` double(50,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_courseware_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_evaluation`;
CREATE TABLE `tbl_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(20) DEFAULT NULL,
  `grade` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评价等级',
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评价内容',
  `suggestion` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '意见和建议',
  `evaluator` bigint(20) DEFAULT NULL COMMENT '评价人',
  `evaluated_person` bigint(20) DEFAULT NULL COMMENT '被评价人',
  `lesson_id` bigint(20) DEFAULT NULL COMMENT '评价的课程',
  `type` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评价类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='课程评价';

-- ----------------------------
-- Records of tbl_evaluation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_grade
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `is_delete` bit(1) NOT NULL,
  `grade_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `grade_code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tbl_lesson`;
CREATE TABLE `tbl_lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `is_delete` bit(1) NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `lesson_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `lesson_code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_lesson
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tbl_news
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news`;
CREATE TABLE `tbl_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '主题',
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '概括',
  `publish_date` datetime DEFAULT NULL COMMENT '发布时间',
  `publish_user_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '封面图片',
  `detail` longtext COLLATE utf8mb4_bin COMMENT '详情',
  `status` int(1) DEFAULT '1' COMMENT '状态标志位 1 - 已发布 / 0 - 未发布',
  `recommend_ind` int(1) DEFAULT '0' COMMENT '推荐标志位（1：xxx）',
  `function_code` varchar(120) COLLATE utf8mb4_bin DEFAULT '1' COMMENT '用于哪个function',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='内容表';

-- ----------------------------
-- Records of tbl_news
-- ----------------------------
BEGIN;
INSERT INTO `tbl_news` VALUES (1, '2019-04-23 21:18:23', 0, 1, '2019-04-27 08:59:40', 37, '2019最新新闻测试', '测试简介', '2019-04-27 08:59:40', 1, 'http://img.kimen.xyz/FnXHl_UdMiHkkxOsLoF01VBF-xMz', '<p><img src=\"http://img.kimen.xyz/Fm9iKAVOtD1NaVl5UDPZp0zNZitB\" alt=\"\" width=\"400\" height=\"225\" /></p>', 1, 0, 'technology');
INSERT INTO `tbl_news` VALUES (2, '2019-04-23 21:18:23', 1, 1, '2019-04-23 21:18:23', 18, '没发新品 苹果发布四大场景应用 靠收费收割八亿用户', '没发新品 苹果发布四大场景应用 靠收费收', '2019-04-23 21:15:01', 1, 'http://img.kimen.xyz/FgluEpgEVr8KMt-z6h_b5H_kpAsw', '<p data-mpa-powered-by=\"yiban.io\"><span style=\"font-size: 12pt;\">今天凌晨，苹果春季发布会在库比蒂诺史蒂夫&middot;乔布斯剧院落下帷幕，非常遗憾，没有大家此前普遍猜测的iPhone SE2，苹果甚至没有将一款硬件设备带给我们，但作为一家一直以来以软件生态见长的品牌，苹果推出多款全新应用，覆盖了消费生活、娱乐生活等多个方面。</span></p>\n<p><img src=\"http://img.kimen.xyz/FlYE5cuMdqkiA3yf5hmF5vskVRxE\" alt=\"\" width=\"640\" height=\"480\" /></p>\n<p>恍然之间给人一种错觉，苹果似乎已先行把iOS 13展示到了我们眼前。</p>\n<p><strong>Apple News+：9.99美刀/月，畅读300+杂志</strong></p>\n<p>作为一家擅长释放人文关怀的科技企业，苹果首先带来的就是Apple News+。</p>\n<p>CEO蒂姆&middot;库克表示，Apple News目前已成为深受用户喜爱的新闻类APP，未来苹果希望通过全新升级的Apple News+为用户提供更多服务。通过这一服务，苹果将为iOS用户提供300+种杂志，包括《时代周刊》等知名杂志，并涵盖时尚、娱乐、时政等多个领域。</p>\n<p><img src=\"http://img.kimen.xyz/FkkRz0XCuh3JEzC3ZgmtE9LaFYHv\" alt=\"\" width=\"640\" height=\"669\" /></p>\n<p>Apple News+拥有更精致的排版设计，并且苹果官方表示其在iPad大屏上的体验会更加优秀。最重要的是，苹果拍胸脯保证绝不会跟踪用户的阅读内容。</p>\n<p><img src=\"http://img.kimen.xyz/FonbR4P1oSc_yhQ0AkUC8sCFsHrP\" alt=\"\" width=\"640\" height=\"510\" /></p>\n<p>作为一家支持内容付费的企业，苹果这项新服务自然不会是白吃的午餐，Apple News+的订阅费用为9.99美刀/月，首月免费。</p>\n<p><strong>Apple Card：由Apple Pay衍生，Daily Cash返现诱人</strong></p>\n<p>全新Apple Card服务可以视作Apple Pay的一项升级服务，用户可通过iPhone进行在线申请，过程简单快捷。除却消费，Apple Card还提供记账功能，能够帮助用户清晰了解自己日常的消费习惯。</p>\n<p><img src=\"http://img.kimen.xyz/FpEqcwu3spcnS41xyd0UEL740Gn3\" alt=\"\" width=\"640\" height=\"291\" /></p>\n<p>为鼓励用户使用Apple Card进行信用卡消费，苹果还推出了Daily Cash返现福利，每消费一笔可返现2%，而通过Apple Card在苹果零售店、苹果官网消费则可获得3%的返利。</p>\n<p><img src=\"http://img.kimen.xyz/FqNXFW-m7n3Ux46e0zMw9rlXtvLF\" /></p>\n<p>此外，Apple Card不仅支持手机刷卡，为照顾不同国家或地区用户的使用习惯，苹果还推出了实体卡，卡面设计保持了苹果一贯简洁的设计风格，卡上没有印着卡号、签名、安全码等内容，因此隐私安全更有保障。</p>\n<p><img src=\"http://img.kimen.xyz/Fhi-KaXiobifxBiHWLUemnhYLj0L\" /></p>\n<p>苹果官方表示，Apple Card服务将会在今年夏季正式上线，目前具体时间还未公布。</p>\n<p><strong>Apple Arcade：订阅即享100+专属游戏，且无广告</strong></p>\n<p>根据苹果官方公布的数据，目前App Store已有10亿游戏玩家，为了给手游爱好者提供更加深入的服务，苹果此次推出了Apple Arcade游戏订阅服务。</p>\n<p><img src=\"http://img.kimen.xyz/FlmGL8i4rrjXbf5fN5LaFS-gOsTt\" /></p>\n<p>苹果以《Alto\'s Adventure》等付费游戏为例，称Apple Arcade游戏订阅服务是世界上第一款覆盖手机、电脑以及客厅游戏订阅服务的游戏订阅平台。</p>\n<p>据悉，目前Apple Arcade已拥有超过100款新游戏，且全部游戏支持离线使用，同时没有广告。此外，苹果表示未来将会和迪士尼等知名手游开发商展开合作，为用户提供更多的游戏资源。</p>\n<p><img src=\"http://img.kimen.xyz/FmFIvuyp5svgHJUMAwJt9wdbWTB6\" /></p>\n<p>值得一提的是，Apple Arcade支持家人共享，并且不会收集个人数据，根据官方时间表，这项服务将于2019年秋正式上线。</p>\n<p><strong>Apple TV channels：一个APP看多个平台内容</strong></p>\n<p>今天凌晨的发布会上，苹果还推出了Apple TV channels服务，并发布了全新的Apple TV APP。简言之，这项新服务就是让用户在一个APP内即可观看各大视频平台的内容，并且无需跳转。</p>\n<p><img src=\"http://img.kimen.xyz/FpLksReDTbsHLve8UtK-PEBVTOjw\" /></p>\n<p>根据官方介绍，Apple TV channels没有广告，并且支持离线观看，还支持在家人间进行共享。</p>\n<p>Apple TV channels将在今年5月获得更新，后续还将适配Mac和iPad，以及三星、LG、索尼等品牌的智能电视。</p>\n<p><img src=\"http://img.kimen.xyz/FviJV_-ogBidcEjHfyaX29XRhkTr\" /></p>\n<p><strong>Apple TV+：向原创视频致敬</strong></p>\n<p>在发布会结尾，苹果为大家介绍了全新的Apple TV+服务，将于今年秋季上线，支持100+国家/地区，无广告，用户可通过其观看苹果的原创视频内容。</p>\n<p>不难发现，相较传统的资源聚合，Apple TV+是苹果自己的视频内容服务，内容包括早间秀、综艺、电影等。</p>\n<p><img src=\"http://img.kimen.xyz/FhIcE6rsLSwvAhLx6L0p9lALSj-8\" /></p>\n<p>值得关注的是，发布会现场苹果特别邀请了知名导演斯皮尔伯格、&ldquo;海王&rdquo;扮演者杰森&middot;莫玛等为Apple TV+站台。</p>\n<p><strong>硬件虽未登上发布会，但苹果已经&ldquo;挤出了牙膏&rdquo;</strong></p>\n<p>如我们前面所说，虽然今天凌晨的发布会上苹果没有介绍一款新的硬件产品，但近段时间以来，苹果官方已陆续更新多款硬件产品。</p>\n<p>3月18日，苹果悄然发布了两款新iPad&mdash;&mdash;售价499美元的iPad Air和售价399美元的iPad Mini。值得期待的亮点是，这两款新品均配有Apple Pencil及A12处理器。</p>\n<p><img src=\"http://img.kimen.xyz/FrucmsumjUiXE5neG34FL4feVswd\" /></p>\n<p><img src=\"http://img.kimen.xyz/FidAWNCtPNxlENKxXTMBItcvB3R0\" /></p>\n<p>起价499美元的新iPad Air是介于去年&ldquo;廉价版&rdquo;9.7英寸iPad（起价329美元）和10.5英寸iPad Pro（起价799美元）之间的一款新平板，各方面表现也介于两者之间。399美元的新ipad mini，则是iPad mini 4的升级替代品。</p>\n<p>此外，新iPad Air配备了10.5英寸的视网膜显示屏（2224x1668像素分辨率500 nits），新ipad mini则具有7.9英寸显示屏（2048x1536像素分辨率）+宽边框。</p>\n<p>相同之处在于：两款新iPad都搭载了iPhone XS同款A12仿生处理器+M12协处理器，64GB/256GB存储空间；后置800万+700万像素FaceTime摄像头，保留了3.5毫米耳机插孔，且支持原来的旧版Apple Pencil（而不是去年10月发布的新Pencil），有灰色、银色和金色可选。</p>\n<p>两者区别在于，新iPad Air配备智能键盘Keyboard，让&ldquo;生产力&rdquo;加倍，且额定电池续航为10小时，支持指纹识别，整机体验感增强。</p>\n<p>同时，苹果还更新4K视网膜屏幕的21.5英寸iMac和5K视网膜屏幕的27英寸iMac，以及强劲的iMac Pro。这也是距上一次2017年WWDC苹果推出新款iMac以来，再一次更新。</p>\n<p><img src=\"http://img.kimen.xyz/FlObh6CYVvIuGj2CCM-TTo1aK6ZC\" /></p>\n<p>21.5英寸iMac升级了第八代四核处理器（最高六核），最高可选配到32GB DDR4内存，性能提升近60%；而27英寸 iMac配备了最高达第九代六核及八核处理器，最高可选配64GB的DDR4内存，性能提升最高达2.4倍。</p>\n<p>同时，新款的iMac显卡全线升级了新款Radeon Pro 500X 系列图形处理器，且可选配Radeon Pro Vega图形处理器，搭载了更快的2666MHz DDR4内存，更适合三维渲染即复杂视频特效等图形密集型工作。</p>\n<p>值得注意的是，两个版本的新款iMac外观几乎没变，在大家都关心的价格方面，新4K屏21.5英寸iMac起售价为10,199元；新5K屏27英 iMac起售价为14,199元。两款新iMac现已可通过苹果官网订购。</p>\n<p>继推出新iPad mini/iPad Air和全新iMac之后，苹果公司20号继续通过其官网更新了万众期待的苹果耳机&mdash;&mdash;AirPods Ⅱ。</p>\n<p><img src=\"http://img.kimen.xyz/Fg0JnnLRcdOBHNvPc6qCDokS7EZs\" /></p>\n<p>更新之后的AirPods Ⅱ配备了全新 Apple H1 耳机芯片，内置光学传感器和运动加速感应器，可以自动检测你是否已将它们戴入耳中。</p>\n<p>另外，据苹果官方介绍，新AirPods Ⅱ支持更长的通话时间：搭配无线充电盒使用聆听时间可超过24小时，通话时间最长可达18小时；单次充电/聆听时间最长可达 5 小时，通话时间最长可达3小时；放入充电盒中15分钟即可获得最长可达3小时的聆听时间或最长可达2小时的通话时间。</p>\n<p>无论是双耳同时使用还是仅佩戴其中一只，新AirPods Ⅱ的H1 芯片都能够自动传送音频和激活麦克风。当你在打电话或与 Siri 交谈时，额外的语音识别加速感应器与采用波束成形技术的麦克风默契协作，可过滤掉外界噪音，清晰锁定你的声音。</p>\n<p><strong>一场没有硬件的发布会，释放出怎样的信号？</strong></p>\n<p>回顾过往，除了一年一度的WWDC全球开发者大会，苹果往往会在发布会上展示硬件新品，甚至是多款产品，此次却一反常态只以软件服务示人，让人不难猜测，苹果正在对外释放着一个信号，那就是未来苹果的发展重心将逐步由硬件研发向软件服务方面转型。</p>\n<p>苹果的这一转变，很难说事出无因。</p>\n<p>据市场调研机构IDC此前公布的数据显示，2019财年第一季度（2018财年第四季度）iPhone出货量在假日季度下降了11%，在整个智能手机市场下降了5%，这也是连续第五个季度出货量下降。全年共出货14亿部智能手机，较2017年下降4.1%。</p>\n<p>而在刚刚过去的2018年全年，iPhone总销量下降3.2%，考虑到其两大市场（美国和中国）都经历了有史以来智能手机最平淡的一年，这是可以理解的。苹果当然不会退出游戏，但2019年缺席5G的iPhone，可能意味着必须亮出更强大的iPhone以及一个更完善生态系统，才能扳回一局。但当面对所有其他市场下行压力时，IDC认为，苹果在2019年将面临一条艰难的道路。&nbsp;</p>\n<p><img src=\"http://img.kimen.xyz/Ft2vXiwyT1WtOh34B_Be7HR_vh60\" /></p>\n<p><img src=\"http://img.kimen.xyz/FoB0zA9qhqvUIU6nqfbKXzSfeGwE\" /></p>\n<p>当然，硬件方面除了iPhone外，ipad ，imac的销量也在这几年大幅下跌。据IDC数据显示，2018Q3季度iPad同比为附赠长-6.1%，尽管iPad系列市场占比依然排名第一。同时，PC方面，IDC数据显示，全球市场占比仅排名第5的苹果，2018年Q3同比依然为负增长-11.6%。</p>\n<p>由此观之，未来硬件已难以成为苹果的主要盈利方式，因此苹果后续极有可能会转型成为一家软件服务提供商。</p>\n<p><strong>布局无人驾驶，苹果或许在筹谋一盘更大的棋</strong></p>\n<p>众所周知，早在2014年，苹果就开始了名为&ldquo;Project&nbsp;Titan&rdquo;的项目，甚至曾有外媒报道，有多达1000名苹果员工在库比蒂诺总部附近的秘密地点开发电动汽车。但后来由于各种问题影响到了苹果汽车项目，因此在2016年苹果曾短暂&ldquo;搁浅&rdquo;了这一造车计划。</p>\n<p>而近来，随着iPhone等硬件产品销量渐颓，外界又纷纷猜测苹果的汽车项目似乎再次暗自启动。尽管苹果暂时错过了5G的起步阶段，不过相信接下来，苹果会在5G上有所动作。不同的是，相比之前传闻中的Apple Car，苹果如今已转入到开发无人驾驶软件，而不是实际的车。</p>\n<p><img src=\"http://img.kimen.xyz/FhquHH8dH58I7K_ybOrFGuLNn44_\" /></p>\n<p>但也有人有不同猜测，比如2017年苹果CEO库克公开讨论了苹果在无人驾驶软件方面的工作，而2018年8月又返聘特斯拉工程师Doug Field，（此人曾在Tesla工作过3年，负责监管Model 3的生产。Field曾任苹果Mac硬件工程副总裁，直到2013年的时候才离开苹果去了Tesla）。这种种迹象都让人怀疑苹果做实体车的项目可能仍在进行，且预计会跟iOS深度整合，并且已经收到DMV的自动测试许可，目前正在测试无人驾驶软件。</p>\n<p>从苹果造车的时间线来看，未来一段时期，苹果或将乘着新机遇为全球科技领域带来更多贡献，大家不妨静待。</p>', 1, 0, 'technology');
INSERT INTO `tbl_news` VALUES (3, '2019-04-23 21:18:23', 1, 1, '2019-04-23 21:18:23', 17, '测试', '周二天气晴', '2019-04-16 15:05:59', 1, 'http://qiniu.heidongtech.com/FlppwXnbafZn9PuWFFQwwc2Uizlo', '<p style=\"text-align: left;\"><span style=\"background-color: #ccffff; color: #000000;\"><strong><em>周二天气晴</em></strong></span><span style=\"color: #000000;\"><strong><em><img src=\"http://qiniu.heidongtech.com/Fu3cLJ4vJu9DjpuR5xvvRW47Jcln\" alt=\"\" width=\"493\" height=\"436\" /></em></strong></span></p>', 0, 0, 'entertainment');
COMMIT;

-- ----------------------------
-- Table structure for tbl_permission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_permission`;
CREATE TABLE `tbl_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `can_delete` bit(1) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `display_sort` int(11) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `permission_code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `permission_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `reource_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `resource_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `parent_permission_id` bigint(20) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=201912086 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限表';

-- ----------------------------
-- Records of tbl_permission
-- ----------------------------
BEGIN;
INSERT INTO `tbl_permission` VALUES (201912004, 1, '2019-12-10 16:14:17', 1, '2019-12-13 08:46:05', b'0', NULL, '周二狗的逆袭123123', 0, NULL, '1-2', '一级权限', 'menu', '123123', 0, 11);
INSERT INTO `tbl_permission` VALUES (201912065, 1, '2019-12-11 17:52:55', 1, '2019-12-11 17:54:22', b'0', NULL, '新建权限', NULL, NULL, '1-1-1', '1-1-1', '', '', 201912064, 3);
INSERT INTO `tbl_permission` VALUES (201912081, 1, '2019-12-13 08:44:10', 1, '2019-12-13 08:45:39', b'0', NULL, '新建权限', 0, NULL, '0', '二级权限', '', '', 0, 2);
INSERT INTO `tbl_permission` VALUES (201912082, 1, '2019-12-13 08:45:46', 1, '2019-12-13 08:45:55', b'0', NULL, '新建权限', 0, NULL, '0', '1-1-2', '', '', 201912064, 2);
INSERT INTO `tbl_permission` VALUES (201912084, 1, '2019-12-13 08:46:23', 1, '2019-12-13 08:47:09', b'0', NULL, '新建权限', 0, NULL, '0', '1-2-1', '', '', 201912083, 2);
INSERT INTO `tbl_permission` VALUES (201912085, 1, '2019-12-13 08:47:37', 1, '2019-12-13 08:47:59', b'0', NULL, '新建权限', 0, NULL, '2-1', '2-1', '', '', 201912081, 3);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  `can_delete` bit(1) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role` VALUES (1, 'ROLE_ADMIN', '超级管理员', '系统超级管理员', 0, NULL, 1, '2019-12-20 16:46:29', b'0', NULL, NULL, 4);
INSERT INTO `tbl_role` VALUES (28, 'ROLE_NEWS', '新闻管理员', '管理新闻以及发布新闻', 0, NULL, 1, '2019-12-20 16:46:23', b'0', NULL, NULL, 8);
INSERT INTO `tbl_role` VALUES (30, 'ROLE_USER', '普通用户', '普通用户', 1, '2019-12-04 21:15:06', 1, '2019-12-20 16:46:12', b'0', NULL, NULL, 4);
INSERT INTO `tbl_role` VALUES (31, 'admin_gangtie', '钢铁战士黄瓜斌', '宇宙终极无敌用户黄瓜斌大傻逼', 0, NULL, 1, '2019-12-20 16:46:03', b'0', NULL, NULL, 32);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role_permission_ref
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_permission_ref`;
CREATE TABLE `tbl_role_permission_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_role_permission_ref
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role_permission_ref` VALUES (28, 1, '2019-12-20 16:18:41', 1, '2019-12-20 16:46:12', b'1', 30, 201912085, 2);
INSERT INTO `tbl_role_permission_ref` VALUES (29, 1, '2019-12-20 16:19:47', 1, '2019-12-20 16:33:31', b'1', 31, 201912085, 2);
INSERT INTO `tbl_role_permission_ref` VALUES (30, 1, '2019-12-20 16:30:28', 1, '2019-12-20 16:46:29', b'1', 1, 201912085, 2);
INSERT INTO `tbl_role_permission_ref` VALUES (31, 1, '2019-12-20 16:44:56', 1, '2019-12-20 16:46:04', b'1', 31, 201912004, 2);
INSERT INTO `tbl_role_permission_ref` VALUES (32, 1, '2019-12-20 16:46:04', 1, '2019-12-20 16:46:04', b'0', 31, 201912004, 1);
INSERT INTO `tbl_role_permission_ref` VALUES (33, 1, '2019-12-20 16:46:04', 1, '2019-12-20 16:46:04', b'0', 31, 201912085, 1);
INSERT INTO `tbl_role_permission_ref` VALUES (34, 1, '2019-12-20 16:46:12', 1, '2019-12-20 16:46:12', b'0', 30, 201912004, 1);
INSERT INTO `tbl_role_permission_ref` VALUES (35, 1, '2019-12-20 16:46:23', 1, '2019-12-20 16:46:23', b'0', 28, 201912085, 1);
INSERT INTO `tbl_role_permission_ref` VALUES (36, 1, '2019-12-20 16:46:29', 1, '2019-12-20 16:46:29', b'0', 1, 201912004, 1);
COMMIT;

-- ----------------------------
-- Table structure for tbl_student
-- ----------------------------
DROP TABLE IF EXISTS `tbl_student`;
CREATE TABLE `tbl_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `real_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `is_use` bit(1) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `mobile_phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `image_url` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `version` int(11) NOT NULL,
  `signature` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='学生表';

-- ----------------------------
-- Records of tbl_student
-- ----------------------------
BEGIN;
INSERT INTO `tbl_student` VALUES (5, 1, '2019-12-04 21:22:00', 5, '2020-01-06 21:14:46', b'0', 'Alfred', '周二狗', NULL, '', 1, '123', '', '$2a$10$k8yeDdaxmRS/kyR9ElRL0OjjBn89T64chwOJIx3wZRnt7U0a4l5vS', 0, 'http://img.kimen.com.cn/FpFercQOurA09DimF9NySxIznPLc', 37, '奥8877');
INSERT INTO `tbl_student` VALUES (6, 1, '2019-12-05 13:25:48', 1, '2019-12-05 13:25:48', b'0', '冬泳怪鸽', '巨魔蘸酱', NULL, '15157', 0, '18871', NULL, '$2a$10$k8yeDdaxmRS/kyR9ElRL0OjjBn89T64chwOJIx3wZRnt7U0a4l5vS', NULL, 'http://img.kimen.com.cn/Ftic0qljygGgKHWIUegas4s9Ind6', 1, NULL);
INSERT INTO `tbl_student` VALUES (7, 1, '2019-12-05 13:32:45', 1, '2019-12-05 13:32:45', b'0', 'hhh', '奥利给', NULL, NULL, 0, NULL, NULL, '$2a$10$AqY4TZmkaBrFvu/5.G8vB.UmnVQMrPw53OD.ylgdtuFd5y.w71dvS', NULL, 'http://img.kimen.com.cn/Ftic0qljygGgKHWIUegas4s9Ind6', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teacher`;
CREATE TABLE `tbl_teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `real_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `is_use` bit(1) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `job_number` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile_phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `office_phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `image_url` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='教师表';

-- ----------------------------
-- Records of tbl_teacher
-- ----------------------------
BEGIN;
INSERT INTO `tbl_teacher` VALUES (1, 1, '2019-12-04 21:54:43', 1, '2019-12-05 19:08:33', b'0', 'Kimen', '汤金梦', NULL, '', 0, '', '', '', '', '$2a$10$ZMu0mUi2REg67fwrDAPogOa4TEEiBoxsZQ5SpDHvtMj4x2a9T88ii', 'http://img.kimen.com.cn/FqACmLJtSCfBz_ejCEUXJyrIdSww', 2);
COMMIT;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(50) DEFAULT NULL,
  `login_name` varchar(50) NOT NULL COMMENT '默认为员工的工号',
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(500) DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'backend' COMMENT '0: 平台用户，1:公司用户',
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `is_delete` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `login` (`login_name`) USING BTREE,
  UNIQUE KEY `idx_user_login` (`login_name`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE,
  UNIQUE KEY `idx_user_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES (1, '18550653265', 'admin', 'admin', '1797788139@qq.com', 'http://img.kimen.com.cn/FqACmLJtSCfBz_ejCEUXJyrIdSww', 'A', '$2a$10$EBmte/A/eqDARqgvh7zpGu7SVsg0jyZUWl/IKeHgD3ROjDVF7oHFO', '1', 1, '2019-04-23 21:18:23', 1, '2020-01-02 19:27:49', 26, b'0');
INSERT INTO `tbl_user` VALUES (279, '18550653265', 'test', 'test', '179778813@qq.com', 'http://img.kimen.com.cn/FqACmLJtSCfBz_ejCEUXJyrIdSww', 'A', '$2a$10$7IIPuSSHcbkcSR02pnxr4OT/EF/0FFjHAMzDLEO7BSS1PC8B3Dhwe', '1', 1, '2019-04-23 21:18:23', 1, '2019-12-04 22:02:10', 27, b'1');
COMMIT;

-- ----------------------------
-- Table structure for tbl_user_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role_ref`;
CREATE TABLE `tbl_user_role_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_user_role_ref
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user_role_ref` VALUES (3, 1, '2019-12-04 21:57:08', 1, '2019-12-04 21:57:08', b'0', 1, 1, 1);
INSERT INTO `tbl_user_role_ref` VALUES (7, 1, '2019-12-04 22:02:10', 1, '2019-12-04 22:02:10', b'0', 279, 30, 1);
COMMIT;

-- ----------------------------
-- Table structure for tbl_version
-- ----------------------------
DROP TABLE IF EXISTS `tbl_version`;
CREATE TABLE `tbl_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version_no` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '版本号，如v1.0.1',
  `res_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源地址，由前台上传，保存七牛云外链',
  `res_hash` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源hash值，判断文件是否损坏，后台定义',
  `update_log` text COLLATE utf8mb4_bin COMMENT '更新日志，使用富文本',
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区分教师端更新还是学生端更新',
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `description` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_version
-- ----------------------------
BEGIN;
INSERT INTO `tbl_version` VALUES (6, 'v0.1.1', 'http://img.kimen.com.cn/1580460039177_app.asar', '276c279512a93c1f71aea1f84e267bf7', '<p>第一个小版本更新</p>', 'TEACHER', 1, '2020-01-13 21:30:43', 1, '2020-01-31 16:47:01', b'0', '第一个小版本更新', 9);
INSERT INTO `tbl_version` VALUES (8, 'v0.1.1', 'http://img.kimen.com.cn/1580442199140_app.asar', '3156c282f680ef389c9a0fa2a2cc925b', NULL, 'STUDENT', 1, '2020-01-31 11:49:04', 1, '2020-01-31 11:49:04', b'0', '学生的第一个小版本更新', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
