/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : managestage

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 02/10/2022 07:38:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for core_act
-- ----------------------------
DROP TABLE IF EXISTS `core_act`;
CREATE TABLE `core_act`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动名称',
  `asso_id` bigint NULL DEFAULT NULL COMMENT '社团id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '申请负责人用户id',
  `act_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动地点',
  `act_nature_id` bigint NULL DEFAULT NULL COMMENT '活动性质编码',
  `act_number` int NULL DEFAULT NULL COMMENT '活动人数',
  `act_object_id` bigint NULL DEFAULT NULL COMMENT '活动对象id',
  `act_fund` int NULL DEFAULT NULL COMMENT '活动经费',
  `act_apply_date` datetime NULL DEFAULT NULL COMMENT '申请日期',
  `act_reviewer_id` bigint NULL DEFAULT NULL COMMENT '审核人',
  `act_reviewer_date` datetime NULL DEFAULT NULL COMMENT '审核日期',
  `act_reviewer_staus` int NULL DEFAULT NULL COMMENT '申请审核状态（0未审核，1活动进行报名 2，活动截止报名3、活动结束4、审核失败）',
  `act_grade_id` bigint NULL DEFAULT NULL COMMENT '(0院级、1校级、2省级、3国家级、4国际级、5其他)',
  `review_id` bigint NULL DEFAULT NULL COMMENT '（0人工审核、1系统通过自动审核）',
  `act_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '图片',
  `act_guide_userid` bigint NULL DEFAULT NULL COMMENT '指导人',
  `act_duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动时间时长',
  `act_aim` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '活动目的',
  `act_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '活动内容',
  `act_process` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '活动流程',
  `act_warn` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '注意事项',
  `act_reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核回复',
  `act_integral` bigint NULL DEFAULT NULL COMMENT '活动积分',
  `act_start_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_act
-- ----------------------------
INSERT INTO `core_act` VALUES (1, '周末文化集市', 1, 1, '艺术礼堂前', 2, 2, 0, 2000, '2022-09-06 22:44:33', 1, '2022-09-06 22:44:38', 3, 1, 1, 'https://imgsa.baidu.com/forum/w%3D580/sign=554a3a167b8b4710ce2ffdc4f3cfc3b2/5f955566d016092444f3602cdd0735fae7cd3498.jpg', 1, '5小时', '宣传校园文化', '进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动', '1，进入摊位参与活动', '注意安全', '同意', 10, '2022-09-01 11:15:35');
INSERT INTO `core_act` VALUES (2, '草地音乐节', 1, 4, '新操场', 2, 2, 2, 2000, '2022-09-25 14:55:39', 4, '2022-09-25 16:13:31', 1, 1, 1, 'https://img0.baidu.com/it/u=1405467168,4161234044&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313', 1, '4小时', '激发学生的参与热情，有利于校园文化“百花齐放”氛围格局的形成，同时还有效促进学生综合素质的养成，让更多的学生从活动中受益.', '“周末文化集市”的前身是“周末文化大舞台”。“不论才艺是否出众，只要有热情，只要有意愿，就可以登台展风采”——这是“周末文化大舞台”打出的旗号；让更多普通同学有机会表现和锻炼自己，成为校园文化活动的“主角”，是“周末文化大舞台”的初衷。“周末文化大舞台”主动降低舞台高度，淡化演员与观众的界限，提倡“全民参与”的活动形式，激发了广大同学的参与热情，自2008年开办以来，已先后举办了近80场文艺专场活动，内容涵盖了歌唱、舞蹈、话剧、朗诵、器乐、礼仪表演等一系列内容丰富多彩的活动。“周末文化大舞台”别具一格的活动形式为广大同学提供了一个展示与锻炼自我的广阔空间、一个可以尽情挥洒青春风采的“亲民舞台”，它以其独特的魅力得到广大学生的喜爱和好评，成为厦门理工学院校园文化活动的一道动人风景线。', '第一，形式更灵活，不再设置“舞台”，取而代之的是以不同文化元素为表现主题的多个摊位组成，不再设置舞台。第二，内容更丰富，有手工制作展示、文化民俗体验、能力与极限挑战、美食风情荟萃等多种类型的摊位与展区，不再局限于歌舞乐器。第三，集市的参与面更广泛，所有摊位都面向全校学生招标，因此每个学生都有机会参与到其中，今天你是逛集市的“游客”，明天你可能就是摊位的“主人”。第四，创意更足，所有的摊位都由学生自己装饰、布置，由学生自己确定展示内容和展示方式，学生的创意得到极大的释放和激发。', '新的学期已经开始，希望有更多的同学能参与到集市进来，让“阳光雨露计划”真正惠及每一位学生。', '同意举办', 100, '2023-11-01 21:15:39');
INSERT INTO `core_act` VALUES (3, '蓝桥杯', 1, 1, '精工1', 1, 1, 0, 2000, '2022-09-10 11:05:23', 4, '2022-09-25 16:13:36', 1, 1, 1, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fxxgk.shnu.edu.cn%2F_upload%2Farticle%2Fimages%2Fb9%2Fbd%2F274a0bac4b2b908ddd8b798ad541%2Ff104d142-3e59-423e-b942-09205d47ba62.jpg&refer=http%3A%2F%2Fxxgk.shnu.edu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666412&t=0b808e9b5d20432fbb72e8ff1b26ff14', 1, '5小时', '编程', '1', '1', '1', '重新审核中，请等待。', 20, '2022-10-29 11:15:40');

-- ----------------------------
-- Table structure for core_act_grade
-- ----------------------------
DROP TABLE IF EXISTS `core_act_grade`;
CREATE TABLE `core_act_grade`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_grade_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动级别名称',
  `act_grade_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_act_grade
-- ----------------------------
INSERT INTO `core_act_grade` VALUES (0, '院级', '无');
INSERT INTO `core_act_grade` VALUES (1, '校级', '无');
INSERT INTO `core_act_grade` VALUES (2, '省级', '无');
INSERT INTO `core_act_grade` VALUES (3, '国家级', '无');
INSERT INTO `core_act_grade` VALUES (4, '国际级', '无');
INSERT INTO `core_act_grade` VALUES (5, '其他', '无');

-- ----------------------------
-- Table structure for core_act_nature
-- ----------------------------
DROP TABLE IF EXISTS `core_act_nature`;
CREATE TABLE `core_act_nature`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_nature_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动性质名称',
  `act_review_id` bigint NOT NULL COMMENT '审核级别 ',
  `act_nature_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_act_nature
-- ----------------------------
INSERT INTO `core_act_nature` VALUES (0, '综合', 1, '多项性质');
INSERT INTO `core_act_nature` VALUES (1, '学习', 1, '学习活动');
INSERT INTO `core_act_nature` VALUES (2, '文化', 1, '文化活动');
INSERT INTO `core_act_nature` VALUES (3, '健康', 1, '健康活动');
INSERT INTO `core_act_nature` VALUES (4, '运动', 1, '运动活动');
INSERT INTO `core_act_nature` VALUES (5, '志愿', 1, '志愿活动');
INSERT INTO `core_act_nature` VALUES (6, '其他', 1, '其他活动');

-- ----------------------------
-- Table structure for core_asso
-- ----------------------------
DROP TABLE IF EXISTS `core_asso`;
CREATE TABLE `core_asso`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asso_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '协会名称',
  `assotype_id` bigint NOT NULL COMMENT '协会类型',
  `asso_number` int NULL DEFAULT NULL COMMENT '协会人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_asso
-- ----------------------------
INSERT INTO `core_asso` VALUES (0, '无', 0, 1892);
INSERT INTO `core_asso` VALUES (1, '周末文化集市运营部', 2, 100);
INSERT INTO `core_asso` VALUES (2, '学习部', 1, 132);
INSERT INTO `core_asso` VALUES (3, '宣传部', 1, 232);
INSERT INTO `core_asso` VALUES (4, '文体部', 1, 98);
INSERT INTO `core_asso` VALUES (5, '无', 0, 1892);

-- ----------------------------
-- Table structure for core_asso_type
-- ----------------------------
DROP TABLE IF EXISTS `core_asso_type`;
CREATE TABLE `core_asso_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asso_type_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT ' 社团类型名称',
  `asso_type_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_asso_type
-- ----------------------------
INSERT INTO `core_asso_type` VALUES (0, '其他类', '其他类型、包括无部门');
INSERT INTO `core_asso_type` VALUES (1, '学习类', '学习类');
INSERT INTO `core_asso_type` VALUES (2, '文化类', '文化类');
INSERT INTO `core_asso_type` VALUES (3, '科技类', '科技类');
INSERT INTO `core_asso_type` VALUES (4, '创新类', '创新类');
INSERT INTO `core_asso_type` VALUES (5, '志愿类', '志愿类');
INSERT INTO `core_asso_type` VALUES (6, '体育类', '体育类');

-- ----------------------------
-- Table structure for core_object
-- ----------------------------
DROP TABLE IF EXISTS `core_object`;
CREATE TABLE `core_object`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `object_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '对象名称',
  `object_remark` int NULL DEFAULT NULL COMMENT '备注(0全体成员，1是部门内学生参加 2，全体学生参加 3是老师参加)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_object
-- ----------------------------
INSERT INTO `core_object` VALUES (0, '全体师生', 0);
INSERT INTO `core_object` VALUES (1, '部门内学生参加', 1);
INSERT INTO `core_object` VALUES (2, '全体学生参加', 2);
INSERT INTO `core_object` VALUES (3, '老师参加', 3);
INSERT INTO `core_object` VALUES (4, '其他', NULL);

-- ----------------------------
-- Table structure for core_review
-- ----------------------------
DROP TABLE IF EXISTS `core_review`;
CREATE TABLE `core_review`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `review_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '审核级别名',
  `review_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_review
-- ----------------------------
INSERT INTO `core_review` VALUES (0, '自动通过审核', '1');
INSERT INTO `core_review` VALUES (1, '人工审核', '1');

-- ----------------------------
-- Table structure for core_user_act
-- ----------------------------
DROP TABLE IF EXISTS `core_user_act`;
CREATE TABLE `core_user_act`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `act_id` bigint NOT NULL,
  `user_act_review` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '报名审核内容\r\n',
  `user_act_review_date` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `user_act_statu` int NOT NULL COMMENT '0表示报名未通过审核，1表示通过报名未参加，2表示报名后被取消，3表示通过报名并参加活动存档。',
  `user_act_create_time` datetime NULL DEFAULT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_user_act
-- ----------------------------
INSERT INTO `core_user_act` VALUES (1, 1, 1, '同意你参加活动', NULL, 0, NULL);
INSERT INTO `core_user_act` VALUES (2, 2, 1, '同意你参加活动', NULL, 0, NULL);
INSERT INTO `core_user_act` VALUES (3, 3, 1, '同意你参加活动', NULL, 0, NULL);
INSERT INTO `core_user_act` VALUES (5, 5, 1, '不同意你参加活动', NULL, 2, NULL);
INSERT INTO `core_user_act` VALUES (42, 4, 1, NULL, NULL, 3, NULL);
INSERT INTO `core_user_act` VALUES (46, 4, 2, '不通过', '2022-09-25 16:03:13', 2, '2022-09-20 14:43:29');
INSERT INTO `core_user_act` VALUES (47, 1, 3, NULL, NULL, 0, '2022-09-20 19:44:31');
INSERT INTO `core_user_act` VALUES (48, 4, 3, NULL, NULL, 0, '2022-09-21 14:19:36');

-- ----------------------------
-- Table structure for expansion_certification
-- ----------------------------
DROP TABLE IF EXISTS `expansion_certification`;
CREATE TABLE `expansion_certification`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `certification_Code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '认证码',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户',
  `role_id` bigint NULL DEFAULT NULL COMMENT '认证对象类型',
  `certification_statu` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_certification
-- ----------------------------
INSERT INTO `expansion_certification` VALUES (1, '2010824132', 1, 1, 1);
INSERT INTO `expansion_certification` VALUES (2, '2010824131', 2, 1, 1);
INSERT INTO `expansion_certification` VALUES (3, '2010715320', NULL, NULL, NULL);
INSERT INTO `expansion_certification` VALUES (4, '2010715308', NULL, NULL, NULL);
INSERT INTO `expansion_certification` VALUES (5, '2013203112', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for expansion_collection
-- ----------------------------
DROP TABLE IF EXISTS `expansion_collection`;
CREATE TABLE `expansion_collection`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户',
  `act_id` bigint NOT NULL COMMENT '活动',
  `collection_date` datetime NULL DEFAULT NULL COMMENT '收藏日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_collection
-- ----------------------------
INSERT INTO `expansion_collection` VALUES (1, 1, 1, '2022-09-10 21:55:14');
INSERT INTO `expansion_collection` VALUES (47, 4, 1, '2022-09-20 14:43:14');
INSERT INTO `expansion_collection` VALUES (48, 4, 2, '2022-09-20 14:43:26');
INSERT INTO `expansion_collection` VALUES (50, 1, 3, '2022-09-20 19:44:31');
INSERT INTO `expansion_collection` VALUES (58, 4, 3, '2022-09-25 16:06:21');

-- ----------------------------
-- Table structure for expansion_comment
-- ----------------------------
DROP TABLE IF EXISTS `expansion_comment`;
CREATE TABLE `expansion_comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户',
  `act_id` bigint NOT NULL COMMENT '评论活动',
  `user_comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户评论',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_comment
-- ----------------------------
INSERT INTO `expansion_comment` VALUES (1, 1, 1, '新时代赋予新使命，新学期开启新征程。');

-- ----------------------------
-- Table structure for expansion_notice
-- ----------------------------
DROP TABLE IF EXISTS `expansion_notice`;
CREATE TABLE `expansion_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告名',
  `notice_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告内容',
  `notice_time` datetime NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_notice
-- ----------------------------
INSERT INTO `expansion_notice` VALUES (1, '汲取精神伟力 奋进未来之路', '新时代赋予新使命，新学期开启新征程。伴随着秋季新学期师生员工顺利返校返岗，菁菁校园喜迎2022级新生。为激励广大师生奋进新征程，争创新业绩，9月5日上午，朱文章校长以《汲取精神伟力 奋进未来之路》为题，在信息中心报告厅为全校师生讲授秋季学期“开学第一课”。全体校领导、中层干部在主会场参加“开学第一课”，其他教职工和学生通过网络在线直播同步收听收看。开学第一课由校党委林志成副书记主持。\r\n\r\n“刚过去的一学年，全校上下持续深入学习贯彻党的十九届六中全会精神，持续深化党史学习教育，开启学校‘主动服务厦门发展年’，慎终如始抓好常态化疫情防控工作，共同见证我校学科和学位点建设取得新突破，教育教学和人才培养水平迈上新台阶，学校社会声誉和形象得到新提升。”朱文章校长带领大家简要回顾了上个学年全校上下凝心聚力，深入开展党史学习教育、做好常态化疫情防控和推动学校事业发展所取得的一系列可喜成绩。他表示，当前，学校正处在高质量发展的关键时期，面临接受新一轮本科教育教学审核评估、更名大学、博士点培育项目建设“三大任务”，站在“重整行装再出发”的新起点上，希望全体师生员工都能以实干创造非凡业绩，用勤奋和智慧书写新学期的满意答卷。\r\n\r\n结合新学期学校的重点工作，朱文章校长对全体师生提出了三点希望和要求。一是认清复杂形势，绷紧疫情防控之弦不放松。“当前，校园疫情防控工作依然面临着严峻挑战，丝毫不能放松。”朱校长表示，全校师生要以“时时放心不下”的责任感和“处处如履薄冰”的紧迫感，配合做好健康管理工作，坚持每日微哨打卡；加强体育锻炼、增强个人防护意识、养成良好生活习惯；按要求做好核酸检测和疫苗接种工作，携手筑牢疫情防控的安全屏障，织密校园疫情防控安全网。同时要尽快“收心”进入学习工作状态，用积极的心态去面对问题和挑战，努力做好新学期各项工作。二是汲取精神伟力，涵养爱国情怀，激发干事创业热情。“你们生在盛世，应不负盛世。”朱校长要求广大青年学生，要从百年党史中汲取“愿得此生长报国”的信仰之力、“天工人巧日争新”的创新之力、“后天下之乐而乐”的奉献之力，珍惜大学时光，牢记学习本职，胸怀“两个大局”、心系“国之大者”，发扬主人翁精神，争当文明的践行者和示范者，以行胜于言的方式肩负时代重任，把个人理想自觉融入到国家、社会、学校的建设中去，做走在时代前列的奋进者、开拓者、奉献者，为开创学校高质量发展新局面砥砺奋进。“教师们从事的教育工作是一项功在当代、利在千秋的伟大事业。”朱校长强调，广大教职工要时刻牢记立德树人初心，坚持以德立身、以德立学、以德施教，努力成为塑造学生品格、品行、品味的“大先生”。同时，要积极发挥“传帮带”作用，提升教学科研、成果转化和服务社会能力，为学校“十四五”高质量发展赋能添彩。三是构建安全校园，为新学期打好安全底色。朱校长强调，全校师生员工要时刻牢记“安全无小事”，切实增强防范化解重大风险的责任感和紧迫感；要防范于未然，增强忧患意识，严格遵守学校安全管理各项规定，当好自身安全的“第一责任人”；要重视“心理健康”，养成健康的生活作息习惯，提高应对挫折和逆境的能力，保持乐观心态，懂得让自己的心灵“软着陆”。\r\n\r\n百舸争流千帆竞，乘风破浪正远航。面对新学期新征程，朱文章校长亲切勉励同学们要努力学好专业知识，练就过硬本领，锤炼意志品质，成为一名新时代大有可为的“硬核”大学生，以实际行动书写求知求学路的新篇章。他同时号召全校广大教职工要勇担育人使命，涵养高尚师德，以舍我其谁的责任感、勇毅前行的昂扬斗志为把早日把学校建设成为国内一流的高水平应用技术大学争献韶华，以优异成绩迎接党的二十大胜利召开。\r\n\r\n朱文章校长讲授的开学第一课饱含期许，催人奋进，让师生们深受激励和鼓舞。“开学第一课是凝心聚力、振奋人心的一堂课！”机汽学院杨旸老师表示，作为一名行政管理人员，要立足新起点，勇于担当作为，围绕学校中心工作，尽心尽责做好服务质量提升，为学校早日建成国内一流高水平应用技术大学不懈奋斗。“朱校长的开学第一课，让我更加坚定了在教书育人道路上不懈努力的信心和决心。”经管学院薛绍杰老师表示，作为一名教育工作者，要不断充实自身，在传授专业知识的同时，积极帮助学生树立正确的人生观、价值观和世界观，为学生成长成才夯实基础。影传学院2021级网络与新媒体2班的游思婕同学对朱校长强调的创新精神深有感触，她表示，作为厦理工学生要充分发扬“明理精工、与时偕行”的校训精神，刻苦学好专业知识，增强创新意识，提升创新能力，用拼搏奋斗成就自己的青春梦想。光电学院2021级微电子2班何杰同学坚定地表示，作为当代大学生，要珍惜韶华，刻苦学习，争做新时代有志青年，努力成为堪当民族复兴重任的时代新人。\r\n\r\n奋进新征程，建功新时代。2022年秋季学期已拉开序幕，全校师生员工将按照学校的部署要求，把“开学第一课”的精神落实到日常学习、工作中，以更加昂扬的斗志、更加饱满的热情、更加过硬的作风和更加务实的举措，为推进学校内涵式高质量发展贡献智慧和力量，以实际行动迎接党的二十大胜利召开。（宣传部） ', '2022-09-06 21:19:51');

-- ----------------------------
-- Table structure for expansion_rotationchart
-- ----------------------------
DROP TABLE IF EXISTS `expansion_rotationchart`;
CREATE TABLE `expansion_rotationchart`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rotationchart_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '轮播图名称',
  `act_id` bigint NULL DEFAULT NULL COMMENT '活动',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_rotationchart
-- ----------------------------
INSERT INTO `expansion_rotationchart` VALUES (2, '互联网', 1, 'https://pic2.zhimg.com/v2-9e4011abd56290ee683b96d29534161c_r.jpg?source=172ae18b');
INSERT INTO `expansion_rotationchart` VALUES (3, '蓝桥杯全国软件和信息技术专业人才大赛', 3, 'http://cdn1.52jingsai.com/portal/202207/12/104154k8r8p2k6lperr5ds.png');
INSERT INTO `expansion_rotationchart` VALUES (4, 'ACM', 1, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fss.csdn.net%2Fp%3Fhttps%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_png%2FNVvB3l3e9aGsMZAZWmev1yeo3moljx8A8FWEvuKJCaN3HE0KPWpwXXtrAj8nbPzVvCb1QqkqKlazbibcsIExLWA%2F0%3Fwx_fmt%3Dpng&refer=http%3A%2F%2Fss.csdn.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666855&t=02ef95d2354db585a618c97affcc7493');
INSERT INTO `expansion_rotationchart` VALUES (6, '计算机程序设计大赛', 1, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.mnu.cn%2F__local%2F5%2F06%2FF4%2FE703492A46027A82B6C321DA2EF_E5A7D44E_43D08.jpg&refer=http%3A%2F%2Fwww.mnu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665667379&t=caa590b54367e6fa6975336016116716');
INSERT INTO `expansion_rotationchart` VALUES (7, '信息安全', 1, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwx2.sinaimg.cn%2Flarge%2F6f5fb5a2ly1fryz0fpuxij20jr0b4k43.jpg&refer=http%3A%2F%2Fwx2.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666615&t=1227f5ade78796e77bc13da6a591926d');
INSERT INTO `expansion_rotationchart` VALUES (8, '智汇厦门 梦想起航', 1, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn5.haitou.cc%2Fsp0%2Fhfut.ahbys.com%2FConsole%2Fueditor%2Fnet%2Fupload%2Fimage%2F20191202%2F6371090064233866093866861.png&refer=http%3A%2F%2Fcdn5.haitou.cc&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665667209&t=bdc75a898104b9421d0d0845ebc6a1bb');

-- ----------------------------
-- Table structure for expansion_system_log
-- ----------------------------
DROP TABLE IF EXISTS `expansion_system_log`;
CREATE TABLE `expansion_system_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  `visited_time` datetime NOT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expansion_system_log
-- ----------------------------
INSERT INTO `expansion_system_log` VALUES (1, 1, 1, 1, '2022-09-06 21:18:54');
INSERT INTO `expansion_system_log` VALUES (2, 2, 1, 2, '2022-09-08 07:27:15');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `menu_perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `menu_component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `menu_type` int NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `menu_icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_orderNum` int NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `menu_statu` int NOT NULL COMMENT '菜单状态（0启用，1禁用）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `menu_name`(`menu_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (2, 0, '用户管理', '/sys/users', 'sys:manage', 'sys/User', 0, 'avatar', 1, '2022-07-16 21:44:28', '2022-09-09 19:08:34', 1);
INSERT INTO `sys_menu` VALUES (3, 0, '角色管理', '/sys/roles', 'sys:role:list', 'sys/Role', 1, 'fold', 2, '2022-07-16 21:46:55', '2022-07-16 21:46:57', 1);
INSERT INTO `sys_menu` VALUES (4, 0, '菜单管理', '/sys/menus', 'sys:menu:list', 'sys/Menu', 1, 'grid', 3, '2022-07-18 16:32:50', '2022-07-18 16:32:53', 1);
INSERT INTO `sys_menu` VALUES (5, 0, '系统工具', NULL, 'sys:tools', NULL, 0, 'setting', 2, '2022-07-18 16:37:16', '2022-07-18 16:37:16', 1);
INSERT INTO `sys_menu` VALUES (6, 5, '数字字典', '/sys/menus', 'sys:dict:list', 'sys/Dict', 1, 'collection', 1, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (7, 3, '添加角色', NULL, 'sys:role:save', NULL, 2, NULL, 1, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 0);
INSERT INTO `sys_menu` VALUES (9, 2, '添加用户', NULL, 'sys:tools', NULL, 2, NULL, 1, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (10, 2, '修改用户', NULL, 'sys:tools', NULL, 2, NULL, 2, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (11, 2, '删除用户', NULL, 'sys:tools', NULL, 2, NULL, 3, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (12, 2, '分配角色', NULL, 'sys:tools', NULL, 2, NULL, 4, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (13, 2, '重置密码', NULL, 'sys:tools', NULL, 2, NULL, 5, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (14, 3, '修改角色', NULL, 'sys:tools', NULL, 2, NULL, 2, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (15, 3, '删除角色', NULL, 'sys:tools', NULL, 2, NULL, 3, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (16, 3, '分配权限', NULL, 'sys:tools', NULL, 2, NULL, 5, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (17, 4, '添加菜单', NULL, 'sys:tools', NULL, 2, NULL, 1, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (18, 4, '修改菜单', NULL, 'sys:menu:update', NULL, 2, NULL, 2, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);
INSERT INTO `sys_menu` VALUES (19, 4, '删除菜单', NULL, 'sys:menu:delete', NULL, 0, NULL, 3, '2022-07-18 16:48:49', '2022-07-18 16:48:49', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `role_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `role_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `role_statu` int NOT NULL COMMENT '角色状态（0启用，1禁用）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE,
  UNIQUE INDEX `role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (0, '系统管理员', 'sysadmin', '最高权限', '2022-09-06 21:14:08', '2022-09-06 21:14:04', 1);
INSERT INTO `sys_role` VALUES (1, '普通学生', 'student', '可以参加收藏活动', '2022-09-08 07:23:57', '2022-09-08 07:24:01', 1);
INSERT INTO `sys_role` VALUES (2, '部门学生', 'assoStudent', '参与部门的学生', '2022-09-08 07:24:47', '2022-09-08 12:12:29', 1);
INSERT INTO `sys_role` VALUES (3, '普通老师', 'teacher', '与学生参与活动', '2022-09-08 07:25:45', '2022-09-08 07:25:48', 1);
INSERT INTO `sys_role` VALUES (4, '系统管理老师', 'sysTeacher', '参与管理系统', '2022-09-08 07:26:43', '2022-09-08 07:26:48', 1);
INSERT INTO `sys_role` VALUES (5, '审核老师', 'assoTeacher', '参与审核', '2022-09-08 07:31:45', '2022-09-08 07:31:48', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (4, 1, 3);
INSERT INTO `sys_role_menu` VALUES (5, 1, 3);
INSERT INTO `sys_role_menu` VALUES (85, 3, 2);
INSERT INTO `sys_role_menu` VALUES (86, 3, 9);
INSERT INTO `sys_role_menu` VALUES (87, 3, 10);
INSERT INTO `sys_role_menu` VALUES (88, 3, 11);
INSERT INTO `sys_role_menu` VALUES (89, 3, 12);
INSERT INTO `sys_role_menu` VALUES (90, 3, 13);
INSERT INTO `sys_role_menu` VALUES (91, 3, 3);
INSERT INTO `sys_role_menu` VALUES (92, 0, 2);
INSERT INTO `sys_role_menu` VALUES (93, 0, 9);
INSERT INTO `sys_role_menu` VALUES (94, 0, 10);
INSERT INTO `sys_role_menu` VALUES (95, 0, 11);
INSERT INTO `sys_role_menu` VALUES (96, 0, 12);
INSERT INTO `sys_role_menu` VALUES (97, 0, 13);
INSERT INTO `sys_role_menu` VALUES (98, 0, 3);
INSERT INTO `sys_role_menu` VALUES (99, 0, 7);
INSERT INTO `sys_role_menu` VALUES (100, 0, 14);
INSERT INTO `sys_role_menu` VALUES (101, 0, 15);
INSERT INTO `sys_role_menu` VALUES (102, 0, 16);
INSERT INTO `sys_role_menu` VALUES (103, 0, 5);
INSERT INTO `sys_role_menu` VALUES (104, 0, 6);
INSERT INTO `sys_role_menu` VALUES (105, 0, 4);
INSERT INTO `sys_role_menu` VALUES (106, 0, 17);
INSERT INTO `sys_role_menu` VALUES (107, 0, 18);
INSERT INTO `sys_role_menu` VALUES (108, 0, 19);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `asso_id` bigint NULL DEFAULT NULL COMMENT '部门协会id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `user_integral` bigint NULL DEFAULT 0 COMMENT '用户积分',
  `user_autograph` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户签名',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `last_login` datetime NULL DEFAULT NULL COMMENT '最后登入',
  `user_statu` int NULL DEFAULT NULL COMMENT '（0无认证状态，1认证过，2审核状态，3禁用、4注销）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'GitXulti', '13178017923', '$2a$10$8jXPK5DSpKPV9xqKAxvhPObEq6U6iVawl1JUk4W41LTOsYxVqWnlC', 0, 'http://localhost:18888/product/headImage/users/GitXulti/1_45371516d719451f.png', '1449903582@qq.com', '厦门', 9999, '好像做一个基于NLP和过滤协同的大学生活动管理与推荐的前后端分离系统呀', '2022-09-02 21:07:45', '2022-09-23 16:47:02', '2022-09-02 21:07:51', 1);
INSERT INTO `sys_user` VALUES (2, 'ZhiKun', '12351', '$2a$10$3uZPRrBu6K0K2ik4q734iusfybCFClaKYn3zvAVrOowuBiv4oKW..', 0, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '4857@qq.com', '泉州', 880, '纸上学来总觉浅，还是没有舍友卷', '2022-09-06 23:19:32', '2022-09-06 23:19:35', '2022-09-06 23:19:37', 1);
INSERT INTO `sys_user` VALUES (3, 'JinPo', '18250629765', '$2a$10$09DJhCPBIpDZbHxeAdwzQei6h.QKotBurceO1UnJOQ.mMMZ6iNfyu', 0, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '412312857@qq.com', '泉州', 500, '幸好我偷偷滴学了Spring+SpringMVC+Mybatis。', '2022-09-07 09:42:33', '2022-09-08 09:52:24', '2022-09-07 09:42:39', 1);
INSERT INTO `sys_user` VALUES (4, 'admin', '86+771238673', '$2a$10$LrrMw37yK4e7./tNRpXaDu70y858X5C6Fmk2kPoC6G0k7PFzcdGry', 0, 'http://localhost:18888/product/headImage/users/admin/4_0de067ebc2ce40b5.png', '2376928623@qq.com', '福建省厦门市集美区厦门理工学院知行苑4-401', 11110, '还好我是管理员呀', '2022-09-07 11:18:09', '2022-09-19 18:53:27', '2022-09-07 11:18:15', 1);
INSERT INTO `sys_user` VALUES (5, 'test', '1312563', '$2a$10$ZijLZFWNmDgdYkw9DKrjqO0UwdBoLiSMfJS6spREi0VszdZjRzwrO', 1, 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '1112316557@qq.com', '漳州', 1, '关于我做项目，舍友偷偷卷我这件事', '2022-09-08 09:03:35', '2022-09-08 10:22:42', '2022-09-08 09:03:40', 1);
INSERT INTO `sys_user` VALUES (7, 'myname', '131313', '111', 1, 'png', '1231@qq.com', 'XiaMen', 999, 'nong', '2022-09-09 10:56:22', '2022-09-09 10:56:22', '2022-09-09 10:56:22', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (40, 5, 0);
INSERT INTO `sys_user_role` VALUES (41, 5, 5);
INSERT INTO `sys_user_role` VALUES (44, 4, 4);
INSERT INTO `sys_user_role` VALUES (45, 4, 5);
INSERT INTO `sys_user_role` VALUES (51, 2, 2);
INSERT INTO `sys_user_role` VALUES (52, 2, 3);
INSERT INTO `sys_user_role` VALUES (53, 2, 5);
INSERT INTO `sys_user_role` VALUES (57, 3, 1);
INSERT INTO `sys_user_role` VALUES (58, 3, 2);
INSERT INTO `sys_user_role` VALUES (59, 3, 3);
INSERT INTO `sys_user_role` VALUES (60, 3, 4);
INSERT INTO `sys_user_role` VALUES (73, 7, 1);
INSERT INTO `sys_user_role` VALUES (74, 1, 0);
INSERT INTO `sys_user_role` VALUES (75, 1, 1);
INSERT INTO `sys_user_role` VALUES (76, 1, 2);
INSERT INTO `sys_user_role` VALUES (77, 1, 3);
INSERT INTO `sys_user_role` VALUES (78, 1, 4);
INSERT INTO `sys_user_role` VALUES (79, 1, 5);

-- ----------------------------
-- Table structure for top_host
-- ----------------------------
DROP TABLE IF EXISTS `top_host`;
CREATE TABLE `top_host`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主机名',
  `host_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主机ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_host
-- ----------------------------
INSERT INTO `top_host` VALUES (1, '本地主机', '120.41.16.89');

-- ----------------------------
-- Table structure for top_host_log
-- ----------------------------
DROP TABLE IF EXISTS `top_host_log`;
CREATE TABLE `top_host_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_id` bigint NOT NULL COMMENT '主机',
  `server_id` bigint NOT NULL COMMENT '服务器',
  `serve_date` datetime NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_host_log
-- ----------------------------
INSERT INTO `top_host_log` VALUES (1, 1, 1, '2022-09-06 21:12:11');

-- ----------------------------
-- Table structure for top_host_type
-- ----------------------------
DROP TABLE IF EXISTS `top_host_type`;
CREATE TABLE `top_host_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_id` bigint NOT NULL COMMENT '主机',
  `host_name_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主机名',
  `host_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_host_type
-- ----------------------------
INSERT INTO `top_host_type` VALUES (1, 1, '0', '中央主机、服务主机');
INSERT INTO `top_host_type` VALUES (2, 2, '1', '服务主机');
INSERT INTO `top_host_type` VALUES (3, 3, '1', '服务主机');

-- ----------------------------
-- Table structure for top_server_connect
-- ----------------------------
DROP TABLE IF EXISTS `top_server_connect`;
CREATE TABLE `top_server_connect`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_id_1` bigint NOT NULL COMMENT '服务器',
  `host_id_2` bigint NOT NULL COMMENT '服务器',
  `host_connect_staus` int NULL DEFAULT NULL COMMENT '关联状态',
  `server_connect_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_server_connect
-- ----------------------------
INSERT INTO `top_server_connect` VALUES (1, 1, 2, 1, '集美区互联通道');
INSERT INTO `top_server_connect` VALUES (2, 1, 3, 1, '思明-集美互联通道');

-- ----------------------------
-- Table structure for top_server_log
-- ----------------------------
DROP TABLE IF EXISTS `top_server_log`;
CREATE TABLE `top_server_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `server_id` bigint NOT NULL COMMENT '主机',
  `server_log_average` double NOT NULL COMMENT '平均负载百分比',
  `server_log_date` datetime NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_server_log
-- ----------------------------
INSERT INTO `top_server_log` VALUES (1, 1, 50, '2022-09-06 21:07:43');
INSERT INTO `top_server_log` VALUES (2, 1, 70, '2022-09-06 21:07:58');
INSERT INTO `top_server_log` VALUES (3, 1, 55, '2022-09-06 21:08:26');

-- ----------------------------
-- Table structure for top_sever
-- ----------------------------
DROP TABLE IF EXISTS `top_sever`;
CREATE TABLE `top_sever`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sever_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主机名',
  `sever_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主机ip地址',
  `sever_cpu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'CPU核心',
  `sever_memory` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内存大小',
  `sever_region` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主机地区',
  `sever_host_type_id` bigint NULL DEFAULT NULL COMMENT '主机类型',
  `sever_port` int NOT NULL COMMENT '主机端口',
  `x_position` double NOT NULL COMMENT 'x坐标',
  `y_position` double NOT NULL COMMENT 'y坐标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of top_sever
-- ----------------------------
INSERT INTO `top_sever` VALUES (1, '厦门理工学院（集美校区）', '120.41.16.89', 'i7-10875', '2T', '厦门集美区', 1, 80, 118.093221, 24.630356);
INSERT INTO `top_sever` VALUES (2, '厦门理工学院（厦软校区）', '120.41.16.89', 'R5-4800', '1T', '厦门集美区', 1, 80, 118.080766, 24.622277);
INSERT INTO `top_sever` VALUES (3, '厦门理工学院（思明校区）', '120.41.16.89', 'i7-10750', '1T', '厦门思明区', 1, 80, 118.09682, 24.444742);

SET FOREIGN_KEY_CHECKS = 1;
