-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: managestage
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `core_act`
--

DROP TABLE IF EXISTS `core_act`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_act` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_name` varchar(64) NOT NULL COMMENT '活动名称',
  `asso_id` bigint DEFAULT NULL COMMENT '社团id',
  `user_id` bigint DEFAULT NULL COMMENT '申请负责人用户id',
  `act_place` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '活动地点',
  `act_nature_id` bigint DEFAULT NULL COMMENT '活动性质编码',
  `act_number` int DEFAULT NULL COMMENT '活动人数',
  `act_object_id` bigint DEFAULT NULL COMMENT '活动对象id',
  `act_fund` int DEFAULT NULL COMMENT '活动经费',
  `act_apply_date` datetime DEFAULT NULL COMMENT '申请日期',
  `act_reviewer_id` bigint DEFAULT NULL COMMENT '审核人',
  `act_reviewer_date` datetime DEFAULT NULL COMMENT '审核日期',
  `act_reviewer_staus` int DEFAULT NULL COMMENT '申请审核状态（0未审核，1活动进行报名 2，活动截止报名3、活动结束4、审核失败）',
  `act_grade_id` bigint DEFAULT NULL COMMENT '(0院级、1校级、2省级、3国家级、4国际级、5其他)',
  `review_id` bigint DEFAULT NULL COMMENT '（0人工审核、1系统通过自动审核）',
  `act_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '图片',
  `act_guide_userid` bigint DEFAULT NULL COMMENT '指导人',
  `act_duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '活动时间时长',
  `act_aim` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '活动目的',
  `act_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '活动内容',
  `act_process` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '活动流程',
  `act_warn` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '注意事项',
  `act_reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核回复',
  `act_integral` bigint DEFAULT NULL COMMENT '活动积分',
  `act_start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_act`
--

LOCK TABLES `core_act` WRITE;
/*!40000 ALTER TABLE `core_act` DISABLE KEYS */;
INSERT INTO `core_act` VALUES (1,'周末文化集市',1,1,'艺术礼堂前',2,2,0,2000,'2022-09-06 22:44:33',1,'2022-09-06 22:44:38',3,1,1,'https://imgsa.baidu.com/forum/w%3D580/sign=554a3a167b8b4710ce2ffdc4f3cfc3b2/5f955566d016092444f3602cdd0735fae7cd3498.jpg',1,'5小时','宣传校园文化','进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动进入摊位参与活动','1，进入摊位参与活动','注意安全','同意',10,'2022-09-01 11:15:35'),(2,'草地音乐节',1,4,'新操场',2,1,2,2000,'2022-10-05 15:24:53',4,'2022-10-05 15:25:52',3,1,1,'https://img0.baidu.com/it/u=1405467168,4161234044&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313',1,'4小时','激发学生的参与热情，有利于校园文化“百花齐放”氛围格局的形成，同时还有效促进学生综合素质的养成，让更多的学生从活动中受益.','“周末文化集市”的前身是“周末文化大舞台”。“不论才艺是否出众，只要有热情，只要有意愿，就可以登台展风采”——这是“周末文化大舞台”打出的旗号；让更多普通同学有机会表现和锻炼自己，成为校园文化活动的“主角”，是“周末文化大舞台”的初衷。“周末文化大舞台”主动降低舞台高度，淡化演员与观众的界限，提倡“全民参与”的活动形式，激发了广大同学的参与热情，自2008年开办以来，已先后举办了近80场文艺专场活动，内容涵盖了歌唱、舞蹈、话剧、朗诵、器乐、礼仪表演等一系列内容丰富多彩的活动。“周末文化大舞台”别具一格的活动形式为广大同学提供了一个展示与锻炼自我的广阔空间、一个可以尽情挥洒青春风采的“亲民舞台”，它以其独特的魅力得到广大学生的喜爱和好评，成为厦门理工学院校园文化活动的一道动人风景线。','第一，形式更灵活，不再设置“舞台”，取而代之的是以不同文化元素为表现主题的多个摊位组成，不再设置舞台。第二，内容更丰富，有手工制作展示、文化民俗体验、能力与极限挑战、美食风情荟萃等多种类型的摊位与展区，不再局限于歌舞乐器。第三，集市的参与面更广泛，所有摊位都面向全校学生招标，因此每个学生都有机会参与到其中，今天你是逛集市的“游客”，明天你可能就是摊位的“主人”。第四，创意更足，所有的摊位都由学生自己装饰、布置，由学生自己确定展示内容和展示方式，学生的创意得到极大的释放和激发。','新的学期已经开始，希望有更多的同学能参与到集市进来，让“阳光雨露计划”真正惠及每一位学生。','重新审核中，请等待。',100,'2023-11-01 21:15:39'),(3,'蓝桥杯',1,1,'精工1',1,1,0,2000,'2022-09-10 11:05:23',4,'2022-09-25 16:13:36',1,1,1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fxxgk.shnu.edu.cn%2F_upload%2Farticle%2Fimages%2Fb9%2Fbd%2F274a0bac4b2b908ddd8b798ad541%2Ff104d142-3e59-423e-b942-09205d47ba62.jpg&refer=http%3A%2F%2Fxxgk.shnu.edu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666412&t=0b808e9b5d20432fbb72e8ff1b26ff14',1,'5小时','编程','1','1','1','重新审核中，请等待。',20,'2022-10-29 11:15:40'),(12,'摄影大赛',3,4,'无限制',6,2,0,NULL,'2022-10-04 14:51:04',NULL,NULL,0,NULL,NULL,'https://img2.baidu.com/it/u=443077659,3222854101&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',NULL,'9个月','为了丰富大学生的校园生活，展示假期多姿多彩的生活，增强大学生艺术与审美的交流，也为诸多摄影爱好者提供一个展示自我的平台，以此激发大学生对摄影的兴趣和爱好，更加关心、了解校园生活体验校园文化，记载激动人心，感人至深的瞬间、留住温馨的欢笑回忆，分享快乐美好大学生活，同时为扩大我社的影响力与活力，以此体现协和的活力，展现协和的辉煌!','十、比赛规定:\n1.)作品为投稿人原创,由单反相机印放的黑白，彩色作品均可\n2.)作品形式风格不限，不得添加边框、签名、水纹等修饰，否则视为弃权\n3.)所有参赛作品不能改变原始影像仅可做色彩、色调、亮度适当调整，不收创意电脑合成照片4.）投稿作品要注明作品的标题，拍摄时间，拍摄的地点，真实姓名，联系方式，文字叙述分别写在纸上不得写在照片的背面\n5.)不得剽窃、借助他人作品，冒名顶替','1、撰写申请书、策划书\n2、组织活动，做好社内工作，进行广播宣传，张贴海报等宣传工作3、工作人员分配及任务:\n1.)编辑组:负责人:负责撰写活动后的总结2.)宣传组:负责人:\n负责活动的展板设计、海报等设计工作3.)机动组:负责人:负责活动现场纪律的维持、会场的划分、后勤保障，对本次活动参赛者解析说明以及处理应急事件\n4.)摄影组:负责人:\n负责本次活动作品的筛选,现场的摄影以及后期影像资料的保存','无','重新审核中，请等待。',10,'2022-12-01 16:00:00'),(13,'辩论赛',12,4,'预赛:205教室15日上午8：00开始（15日六场，16日一场）\n\n11月15日早上 A组B组（8：20—9：20）\n\n11月15日早上 C组D组（9：40—10：40）\n\n11月15日下午 E组F组（14：00—15：00）\n\n11月15日下午 G组H组（15：20—16：20）\n\n11月15日晚上 I组J组（18: 20—19: 20）\n\n11月15日晚上 K组L组（19：40—20：40）\n\n11月16日晚上 M组N组（18：20—19：20）\n\n晋级赛：205教室18日晚上开始\n\n11月18日晚上（18: 20—19: 20）\n\n11月18日晚上（19：40—20：40）\n\n11月19日晚上（18：20—19：20）',1,0,2,NULL,'2022-10-04 15:13:19',NULL,NULL,0,NULL,NULL,'https://img0.baidu.com/it/u=2559875851,2401474173&fm=253&fmt=auto&app=138&f=JPEG?w=700&h=394',NULL,'2天','举办辩论赛是为了发扬艺术与旅游学院的浓厚艺术气息，加强校园文化建设。提高学生的应变能力和表达能力，以及综合文化素质。培养学生的创新能力和逻辑思维能力。全面展示我们的素质教育成人。','辩论赛是我们XXX学院每年针对大一新生展开的一项比赛，此次比赛为我系学生提供了一个充分展示个人能力，提高口才表达能力和交际水平的平台。我们希望通过此次辩论赛可以提高学生的自我应变能力以及辩论水平。','活动流程:(具体事项如有改动将另行通知)\n\n(一)辩论资格赛：\n\n在资格赛中获胜的辩论队于隔天抽取复赛辩题\n\n(二)复赛:\n\n在复赛中获胜的辩论队于隔天抽取半决赛赛辩题\n\n(三)半决赛：\n\n在半决赛中获胜的辩论队于隔天抽取决赛辩题\n\n(四)决赛:\n\n注：每场比赛有一位点评嘉宾作现场点评，点评嘉宾由评委中产生。','参赛队伍：XXX学院大一新生\n\n辩手要求：每支队伍由7人组成（1名的责任人，4名辩手，2名替补）。要求辩手口齿清晰，思维敏捷，赛前做好充分准备\n\n主持人要求：外型仪表端正，口齿清晰，开朗大方','重新审核中，请等待。',10,'2022-12-01 16:02:00'),(14,'123',1,4,'123',0,1,0,NULL,'2022-10-09 12:15:56',4,'2022-10-09 12:18:36',1,NULL,NULL,'http://localhost:18888/product/act/493b60b0325c49b78f7e4d0b8dbdc225.png',NULL,'123','123123','123123','123123123','123123','同意举办',123123,'2027-08-13 16:00:00');
/*!40000 ALTER TABLE `core_act` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_act_grade`
--

DROP TABLE IF EXISTS `core_act_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_act_grade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_grade_name` varchar(64) NOT NULL COMMENT '活动级别名称',
  `act_grade_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_act_grade`
--

LOCK TABLES `core_act_grade` WRITE;
/*!40000 ALTER TABLE `core_act_grade` DISABLE KEYS */;
INSERT INTO `core_act_grade` VALUES (0,'院级','无'),(1,'校级','无'),(2,'省级','无'),(3,'国家级','无'),(4,'国际级','无'),(5,'其他','无');
/*!40000 ALTER TABLE `core_act_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_act_nature`
--

DROP TABLE IF EXISTS `core_act_nature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_act_nature` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `act_nature_name` varchar(255) NOT NULL COMMENT '活动性质名称',
  `act_review_id` bigint NOT NULL COMMENT '审核级别 ',
  `act_nature_remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_act_nature`
--

LOCK TABLES `core_act_nature` WRITE;
/*!40000 ALTER TABLE `core_act_nature` DISABLE KEYS */;
INSERT INTO `core_act_nature` VALUES (0,'综合',1,'多项性质'),(1,'学习',1,'学习活动'),(2,'文化',1,'文化活动'),(3,'健康',1,'健康活动'),(4,'运动',1,'运动活动'),(5,'志愿',1,'志愿活动'),(6,'其他',1,'其他活动');
/*!40000 ALTER TABLE `core_act_nature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_asso`
--

DROP TABLE IF EXISTS `core_asso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_asso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asso_name` varchar(64) NOT NULL COMMENT '协会名称',
  `assotype_id` bigint NOT NULL COMMENT '协会类型',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '协会人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_asso`
--

LOCK TABLES `core_asso` WRITE;
/*!40000 ALTER TABLE `core_asso` DISABLE KEYS */;
INSERT INTO `core_asso` VALUES (0,'无',0,'1892'),(1,'周末文化集市运营部',2,'100'),(2,'学习部',1,'132'),(3,'宣传部',1,'232'),(4,'文体部',1,'98'),(6,'主席团',9,'13'),(7,'组织部',9,'134'),(8,'办公室',9,'21'),(9,'财务部',9,NULL),(10,'生活部',0,NULL),(11,'网络信息部',9,NULL),(12,'策划部',9,NULL);
/*!40000 ALTER TABLE `core_asso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_asso_type`
--

DROP TABLE IF EXISTS `core_asso_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_asso_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asso_type_name` varchar(64) NOT NULL COMMENT ' 社团类型名称',
  `asso_type_remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_asso_type`
--

LOCK TABLES `core_asso_type` WRITE;
/*!40000 ALTER TABLE `core_asso_type` DISABLE KEYS */;
INSERT INTO `core_asso_type` VALUES (0,'其他类','其他类型、包括无部门'),(1,'学习类','学习类'),(2,'文化类','文化类'),(3,'科技类','科技类'),(4,'创新类','创新类'),(5,'志愿类','志愿类'),(6,'体育类','体育类'),(7,'竞赛类','竞赛类部门'),(8,'政治类','政治类型'),(9,'综合类','综合类型'),(11,'其他类','其他类型、包括无部门123'),(13,'创新创业','创新创业部门'),(14,'其他类','其他类型、包括无部门，，，');
/*!40000 ALTER TABLE `core_asso_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_object`
--

DROP TABLE IF EXISTS `core_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_object` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `object_name` varchar(64) NOT NULL COMMENT '对象名称',
  `object_remark` int DEFAULT NULL COMMENT '备注(0全体成员，1是部门内学生参加 2，全体学生参加 3是老师参加)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_object`
--

LOCK TABLES `core_object` WRITE;
/*!40000 ALTER TABLE `core_object` DISABLE KEYS */;
INSERT INTO `core_object` VALUES (0,'全体师生',0),(1,'部门内学生参加',1),(2,'全体学生参加',2),(3,'老师参加',3),(4,'其他',NULL);
/*!40000 ALTER TABLE `core_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_review`
--

DROP TABLE IF EXISTS `core_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `review_name` varchar(64) NOT NULL COMMENT '审核级别名',
  `review_remark` varchar(255) NOT NULL COMMENT '备注 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_review`
--

LOCK TABLES `core_review` WRITE;
/*!40000 ALTER TABLE `core_review` DISABLE KEYS */;
INSERT INTO `core_review` VALUES (0,'自动通过审核','1'),(1,'人工审核','1');
/*!40000 ALTER TABLE `core_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_user_act`
--

DROP TABLE IF EXISTS `core_user_act`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `core_user_act` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `act_id` bigint NOT NULL,
  `user_act_review` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '报名审核内容\r\n',
  `user_act_review_date` datetime DEFAULT NULL COMMENT '审核时间',
  `user_act_statu` int NOT NULL COMMENT '0表示报名未通过审核，1表示通过报名未参加，2表示报名后被取消，3表示通过报名并参加活动存档。',
  `user_act_create_time` datetime DEFAULT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_user_act`
--

LOCK TABLES `core_user_act` WRITE;
/*!40000 ALTER TABLE `core_user_act` DISABLE KEYS */;
INSERT INTO `core_user_act` VALUES (1,1,1,'同意你参加活动',NULL,0,NULL),(2,2,1,'同意你参加活动',NULL,0,NULL),(3,3,1,'同意你参加活动',NULL,0,NULL),(5,5,1,'不同意你参加活动',NULL,2,NULL),(42,4,1,NULL,NULL,3,NULL),(46,4,2,'通过，同意你参加活动','2022-10-09 12:17:12',1,'2022-09-20 14:43:29'),(47,1,3,NULL,NULL,0,'2022-09-20 19:44:31');
/*!40000 ALTER TABLE `core_user_act` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_certification`
--

DROP TABLE IF EXISTS `expansion_certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_certification` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `certification_Code` varchar(20) NOT NULL COMMENT '认证码',
  `user_id` bigint DEFAULT NULL COMMENT '用户',
  `role_id` bigint DEFAULT NULL COMMENT '认证对象类型',
  `certification_statu` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_certification`
--

LOCK TABLES `expansion_certification` WRITE;
/*!40000 ALTER TABLE `expansion_certification` DISABLE KEYS */;
INSERT INTO `expansion_certification` VALUES (1,'2010824132',1,1,1),(2,'2010824131',2,1,1),(3,'2010715320',NULL,NULL,NULL),(4,'2010715308',NULL,NULL,NULL),(5,'2013203112',NULL,NULL,NULL);
/*!40000 ALTER TABLE `expansion_certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_collection`
--

DROP TABLE IF EXISTS `expansion_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_collection` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户',
  `act_id` bigint NOT NULL COMMENT '活动',
  `collection_date` datetime DEFAULT NULL COMMENT '收藏日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_collection`
--

LOCK TABLES `expansion_collection` WRITE;
/*!40000 ALTER TABLE `expansion_collection` DISABLE KEYS */;
INSERT INTO `expansion_collection` VALUES (1,1,1,'2022-09-10 21:55:14'),(48,4,2,'2022-09-20 14:43:26'),(50,1,3,'2022-09-20 19:44:31'),(61,4,3,'2022-10-08 20:41:02'),(62,4,12,'2022-10-09 11:04:39');
/*!40000 ALTER TABLE `expansion_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_comment`
--

DROP TABLE IF EXISTS `expansion_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户',
  `act_id` bigint NOT NULL COMMENT '评论活动',
  `user_comment` text COMMENT '用户评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_comment`
--

LOCK TABLES `expansion_comment` WRITE;
/*!40000 ALTER TABLE `expansion_comment` DISABLE KEYS */;
INSERT INTO `expansion_comment` VALUES (1,1,1,'新时代赋予新使命，新学期开启新征程。');
/*!40000 ALTER TABLE `expansion_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_notice`
--

DROP TABLE IF EXISTS `expansion_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_notice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(255) NOT NULL COMMENT '公告名',
  `notice_message` text NOT NULL COMMENT '公告内容',
  `notice_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_notice`
--

LOCK TABLES `expansion_notice` WRITE;
/*!40000 ALTER TABLE `expansion_notice` DISABLE KEYS */;
INSERT INTO `expansion_notice` VALUES (1,'汲取精神伟力 奋进未来之路','新时代赋予新使命，新学期开启新征程。伴随着秋季新学期师生员工顺利返校返岗，菁菁校园喜迎2022级新生。为激励广大师生奋进新征程，争创新业绩，9月5日上午，朱文章校长以《汲取精神伟力 奋进未来之路》为题，在信息中心报告厅为全校师生讲授秋季学期“开学第一课”。全体校领导、中层干部在主会场参加“开学第一课”，其他教职工和学生通过网络在线直播同步收听收看。开学第一课由校党委林志成副书记主持。\r\n\r\n“刚过去的一学年，全校上下持续深入学习贯彻党的十九届六中全会精神，持续深化党史学习教育，开启学校‘主动服务厦门发展年’，慎终如始抓好常态化疫情防控工作，共同见证我校学科和学位点建设取得新突破，教育教学和人才培养水平迈上新台阶，学校社会声誉和形象得到新提升。”朱文章校长带领大家简要回顾了上个学年全校上下凝心聚力，深入开展党史学习教育、做好常态化疫情防控和推动学校事业发展所取得的一系列可喜成绩。他表示，当前，学校正处在高质量发展的关键时期，面临接受新一轮本科教育教学审核评估、更名大学、博士点培育项目建设“三大任务”，站在“重整行装再出发”的新起点上，希望全体师生员工都能以实干创造非凡业绩，用勤奋和智慧书写新学期的满意答卷。\r\n\r\n结合新学期学校的重点工作，朱文章校长对全体师生提出了三点希望和要求。一是认清复杂形势，绷紧疫情防控之弦不放松。“当前，校园疫情防控工作依然面临着严峻挑战，丝毫不能放松。”朱校长表示，全校师生要以“时时放心不下”的责任感和“处处如履薄冰”的紧迫感，配合做好健康管理工作，坚持每日微哨打卡；加强体育锻炼、增强个人防护意识、养成良好生活习惯；按要求做好核酸检测和疫苗接种工作，携手筑牢疫情防控的安全屏障，织密校园疫情防控安全网。同时要尽快“收心”进入学习工作状态，用积极的心态去面对问题和挑战，努力做好新学期各项工作。二是汲取精神伟力，涵养爱国情怀，激发干事创业热情。“你们生在盛世，应不负盛世。”朱校长要求广大青年学生，要从百年党史中汲取“愿得此生长报国”的信仰之力、“天工人巧日争新”的创新之力、“后天下之乐而乐”的奉献之力，珍惜大学时光，牢记学习本职，胸怀“两个大局”、心系“国之大者”，发扬主人翁精神，争当文明的践行者和示范者，以行胜于言的方式肩负时代重任，把个人理想自觉融入到国家、社会、学校的建设中去，做走在时代前列的奋进者、开拓者、奉献者，为开创学校高质量发展新局面砥砺奋进。“教师们从事的教育工作是一项功在当代、利在千秋的伟大事业。”朱校长强调，广大教职工要时刻牢记立德树人初心，坚持以德立身、以德立学、以德施教，努力成为塑造学生品格、品行、品味的“大先生”。同时，要积极发挥“传帮带”作用，提升教学科研、成果转化和服务社会能力，为学校“十四五”高质量发展赋能添彩。三是构建安全校园，为新学期打好安全底色。朱校长强调，全校师生员工要时刻牢记“安全无小事”，切实增强防范化解重大风险的责任感和紧迫感；要防范于未然，增强忧患意识，严格遵守学校安全管理各项规定，当好自身安全的“第一责任人”；要重视“心理健康”，养成健康的生活作息习惯，提高应对挫折和逆境的能力，保持乐观心态，懂得让自己的心灵“软着陆”。\r\n\r\n百舸争流千帆竞，乘风破浪正远航。面对新学期新征程，朱文章校长亲切勉励同学们要努力学好专业知识，练就过硬本领，锤炼意志品质，成为一名新时代大有可为的“硬核”大学生，以实际行动书写求知求学路的新篇章。他同时号召全校广大教职工要勇担育人使命，涵养高尚师德，以舍我其谁的责任感、勇毅前行的昂扬斗志为把早日把学校建设成为国内一流的高水平应用技术大学争献韶华，以优异成绩迎接党的二十大胜利召开。\r\n\r\n朱文章校长讲授的开学第一课饱含期许，催人奋进，让师生们深受激励和鼓舞。“开学第一课是凝心聚力、振奋人心的一堂课！”机汽学院杨旸老师表示，作为一名行政管理人员，要立足新起点，勇于担当作为，围绕学校中心工作，尽心尽责做好服务质量提升，为学校早日建成国内一流高水平应用技术大学不懈奋斗。“朱校长的开学第一课，让我更加坚定了在教书育人道路上不懈努力的信心和决心。”经管学院薛绍杰老师表示，作为一名教育工作者，要不断充实自身，在传授专业知识的同时，积极帮助学生树立正确的人生观、价值观和世界观，为学生成长成才夯实基础。影传学院2021级网络与新媒体2班的游思婕同学对朱校长强调的创新精神深有感触，她表示，作为厦理工学生要充分发扬“明理精工、与时偕行”的校训精神，刻苦学好专业知识，增强创新意识，提升创新能力，用拼搏奋斗成就自己的青春梦想。光电学院2021级微电子2班何杰同学坚定地表示，作为当代大学生，要珍惜韶华，刻苦学习，争做新时代有志青年，努力成为堪当民族复兴重任的时代新人。\r\n\r\n奋进新征程，建功新时代。2022年秋季学期已拉开序幕，全校师生员工将按照学校的部署要求，把“开学第一课”的精神落实到日常学习、工作中，以更加昂扬的斗志、更加饱满的热情、更加过硬的作风和更加务实的举措，为推进学校内涵式高质量发展贡献智慧和力量，以实际行动迎接党的二十大胜利召开。（宣传部） ','2022-09-06 21:19:51');
/*!40000 ALTER TABLE `expansion_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_rotationchart`
--

DROP TABLE IF EXISTS `expansion_rotationchart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_rotationchart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rotationchart_name` varchar(64) NOT NULL COMMENT '轮播图名称',
  `act_id` bigint DEFAULT NULL COMMENT '活动',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_rotationchart`
--

LOCK TABLES `expansion_rotationchart` WRITE;
/*!40000 ALTER TABLE `expansion_rotationchart` DISABLE KEYS */;
INSERT INTO `expansion_rotationchart` VALUES (2,'互联网',1,'https://pic2.zhimg.com/v2-9e4011abd56290ee683b96d29534161c_r.jpg?source=172ae18b'),(3,'蓝桥杯全国软件和信息技术专业人才大赛',3,'http://cdn1.52jingsai.com/portal/202207/12/104154k8r8p2k6lperr5ds.png'),(4,'ACM',1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fss.csdn.net%2Fp%3Fhttps%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_png%2FNVvB3l3e9aGsMZAZWmev1yeo3moljx8A8FWEvuKJCaN3HE0KPWpwXXtrAj8nbPzVvCb1QqkqKlazbibcsIExLWA%2F0%3Fwx_fmt%3Dpng&refer=http%3A%2F%2Fss.csdn.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666855&t=02ef95d2354db585a618c97affcc7493'),(6,'计算机程序设计大赛',1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.mnu.cn%2F__local%2F5%2F06%2FF4%2FE703492A46027A82B6C321DA2EF_E5A7D44E_43D08.jpg&refer=http%3A%2F%2Fwww.mnu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665667379&t=caa590b54367e6fa6975336016116716'),(7,'信息安全',1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwx2.sinaimg.cn%2Flarge%2F6f5fb5a2ly1fryz0fpuxij20jr0b4k43.jpg&refer=http%3A%2F%2Fwx2.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665666615&t=1227f5ade78796e77bc13da6a591926d'),(8,'智汇厦门 梦想起航',1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn5.haitou.cc%2Fsp0%2Fhfut.ahbys.com%2FConsole%2Fueditor%2Fnet%2Fupload%2Fimage%2F20191202%2F6371090064233866093866861.png&refer=http%3A%2F%2Fcdn5.haitou.cc&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665667209&t=bdc75a898104b9421d0d0845ebc6a1bb');
/*!40000 ALTER TABLE `expansion_rotationchart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expansion_system_log`
--

DROP TABLE IF EXISTS `expansion_system_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expansion_system_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  `visited_time` datetime NOT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expansion_system_log`
--

LOCK TABLES `expansion_system_log` WRITE;
/*!40000 ALTER TABLE `expansion_system_log` DISABLE KEYS */;
INSERT INTO `expansion_system_log` VALUES (1,1,1,1,'2022-09-06 21:18:54'),(2,2,1,2,'2022-09-08 07:27:15');
/*!40000 ALTER TABLE `expansion_system_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_backup`
--

DROP TABLE IF EXISTS `sys_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_backup` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件类型',
  `size` bigint DEFAULT NULL COMMENT '文件大小',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件MD5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '备份时间',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_backup`
--

LOCK TABLES `sys_backup` WRITE;
/*!40000 ALTER TABLE `sys_backup` DISABLE KEYS */;
INSERT INTO `sys_backup` VALUES (145,'time_2022-10-10_15-03-01.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-03-01.sql',NULL,1,'2022-10-10 15:03:01',1),(146,'time_2022-10-10_15-04-20.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-04-20.sql',NULL,1,'2022-10-10 15:04:21',1),(147,'time_2022-10-10_15-06-00.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-06-00.sql',NULL,1,'2022-10-10 15:06:01',1),(148,'WeChat.exe','exe',610696,'http://localhost:18888/product/backup/WeChat.exe','cf20b907d9073b45dacb7b8db326b449',1,NULL,1),(149,'time_2022-10-10_15-52-17.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-52-17.sql',NULL,1,'2022-10-10 15:52:17',1),(150,'time_2022-10-10_15-52-17.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-52-17.sql',NULL,1,'2022-10-10 15:52:18',1),(151,'time_2022-10-10_15-52-20.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_15-52-20.sql',NULL,1,'2022-10-10 15:52:21',1),(152,'time_2022-10-10_16-54-48.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_16-54-48.sql',NULL,1,'2022-10-10 16:54:49',1),(153,'time_2022-10-10_17-01-21.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_17-01-21.sql',NULL,1,'2022-10-10 17:01:22',1),(154,'time_2022-10-10_17-01-35.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_17-01-35.sql',NULL,1,'2022-10-10 17:01:36',1),(155,'time_2022-10-10_17-02-08.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_17-02-08.sql',NULL,1,'2022-10-10 17:02:09',1),(156,'time_2022-10-10_17-02-22.sql','sql',NULL,'http://localhost:18888/product/backup/time_2022-10-10_17-02-22.sql',NULL,1,'2022-10-10 17:02:23',1);
/*!40000 ALTER TABLE `sys_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
  `syscode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '系统编码',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `usercode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'活动表模版名称','厦门理工学院活动登记卡.xlsx','打印模版名称','aaa.xlsx'),(2,'活动证明表模版','活动证明.xlsx','打印模版名称','活动证明.xlsx'),(3,'软件工程书','软件工程书.xlsx','打印模版名称','软件工程书.xlsx'),(4,'历史活动','历史活动.xls','打印模版名称','历史活动.xls'),(5,'部门名称','assoName','打印变量','assoNameSS'),(6,'申请人姓名','applyUserame','打印变量','applyUserame'),(7,'申请人电话','applyUserPhone','打印变量','applyUserPhone'),(8,'活动地点','place','打印变量','place'),(9,'审核人、指导人姓名','reviewUsername','打印变量','reviewUsername'),(10,'审核人电话','reviewPhone','打印变量','reviewPhone'),(11,'活动对象','actObjectName','打印变量','actObjectName'),(12,'活动编号','actNumberName','打印变量','actNumberName'),(13,'部门类型','assoType','打印变量','assoType'),(14,'活动开始时间','actStartDate','打印变量','actStartDate'),(15,'活动名称','actName','打印变量','actName'),(16,'活动目的','actAim','打印变量','actAim'),(17,'活动流程','actProcess','打印变量','actProcess'),(18,'活动信息','actMessage','打印变量','actMessage'),(19,'活动注意事项','actWarn','打印变量','actWarn'),(20,'活动经费','actFund','打印变量','actFund'),(21,'活动申请日期','actApplyDate','打印变量','actApplyDate'),(22,'活动审核日期','actReviewerDate','打印变量','actReviewerDate'),(23,'审核回复','actReply','打印变量','actReply');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_file`
--

DROP TABLE IF EXISTS `sys_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_file` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `size` bigint DEFAULT NULL COMMENT '文件大小',
  `url` varchar(255) DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) DEFAULT NULL COMMENT '文件MD5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_file`
--

LOCK TABLES `sys_file` WRITE;
/*!40000 ALTER TABLE `sys_file` DISABLE KEYS */;
INSERT INTO `sys_file` VALUES (10,'loginBackground.jpg','jpg',16964,'http://localhost:18888/product/file/66a250127e644879a83444d200c0debf.jpg','ae8d3eee8734b54582392b52fcdd6c6f',0,1),(11,'xmut4.jpg','jpg',59308,'http://localhost:18888/product/file/1ca21ead305f403d966bca9fb07a5338.jpg','8f8c471afbee6c9fe0eb636ec0351d99',1,1),(12,'活动证明.xlsx','xlsx',9913,'http://localhost:18888/product/活动证明.xlsx','e0aac83b347a58eb38ebabaa7becda84',1,1),(13,'历史活动.xls','xls',19456,'http://localhost:18888/product/历史活动.xls','bb33ff869f6a13bf918681dee0a63db9',0,1),(14,'厦门理工学院活动登记卡.xlsx','xlsx',10606,'http://localhost:18888/product/厦门理工学院活动登记卡.xlsx','10cb2fd976b05bc1b1908a500fda30c2',0,1),(15,'软件工程书.xlsx','xlsx',16245,'http://localhost:18888/product/软件工程书.xlsx','8768382152bc8d9637aacc1d90ed2dc7',0,1),(16,'屏幕截图(1).png','png',1041497,'http://localhost:18888/product/屏幕截图(1).png','647427e38b7da9e341af48eb94dc856a',1,1),(17,'屏幕截图(1).png','png',1041497,'http://localhost:18888/product/屏幕截图(1).png','647427e38b7da9e341af48eb94dc856a',0,1),(18,'屏幕截图(1).png','png',1041497,'http://localhost:18888/product/屏幕截图(1).png','647427e38b7da9e341af48eb94dc856a',1,1),(19,'eclipse.exe','exe',320008,'http://localhost:18888/product/eclipse.exe','d0706146376a20c4fef185ad1c44fb6a',1,1),(20,'QQ截图20221007170245.jpg','jpg',87029,'http://localhost:18888/product/QQ截图20221007170245.jpg','09539bda9ff0e3ab9382c589271d0d25',0,1),(21,'managestage.sql','sql',46948,'http://localhost:18888/product/managestage.sql','84c1fe05e708ee917b141e41d8f217bd',0,1),(22,'新建文本文档.txt','txt',130,'http://localhost:18888/product/新建文本文档.txt','00ccf44eec2759c75a61fccb43f7d8ee',0,1),(23,'活动证明.xlsx','xlsx',9919,'http://localhost:18888/product/活动证明.xlsx','7d75fbf39e71598e6d2b9c1e44c31697',0,1),(24,'aaa.xlsx','xlsx',10606,'http://localhost:18888/product/厦门理工学院活动登记卡.xlsx','10cb2fd976b05bc1b1908a500fda30c2',1,1),(25,'aaa.xlsx','xlsx',10582,'http://localhost:18888/product/aaa.xlsx','65f95731d6772f83cd19fa7aa45a57be',0,1);
/*!40000 ALTER TABLE `sys_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '菜单URL',
  `menu_perms` varchar(255) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `menu_component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `menu_type` int NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `menu_icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `menu_orderNum` int DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `menu_statu` int NOT NULL COMMENT '菜单状态（0启用，1禁用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_name` (`menu_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'权限管理','无','sys:manage','无',0,'el-icon-s-grid',9,'2022-07-16 21:44:28','2022-09-28 18:30:22',1),(2,1,'用户管理','/user','sys:user:list','/Manage/Main/Sys/User',1,'el-icon-user-solid',1,'2022-07-16 21:44:28','2022-09-28 18:28:45',1),(3,1,'角色管理','/role','sys:role:list','/Manage/Main/Sys/Role',1,'el-icon-s-custom',2,'2022-07-16 21:46:55','2022-09-28 18:28:53',1),(4,1,'菜单管理','/menu','sys:menu:list','/Manage/Main/Sys/Menu',1,'el-icon-menu',3,'2022-07-18 16:32:50','2022-09-28 18:28:56',1),(5,0,'系统工具','无','sys:tools','无',0,'el-icon-s-tools',10,'2022-07-18 16:37:16','2022-09-29 13:38:16',1),(6,5,'数字字典','/dataDictionary','sys:dict:list','/Manage/DataDictionary',1,'el-icon-collection',1,'2022-07-18 16:48:49','2022-09-28 07:23:37',1),(7,3,'添加角色','无','sys:role:save','无',2,'无',1,'2022-07-18 16:48:49','2022-09-28 18:58:12',1),(9,2,'添加用户','无','sys:user:save','无',2,'无',1,'2022-07-18 16:48:49','2022-09-28 18:57:56',1),(10,2,'修改用户','无','sys:user:update','无',2,'无',2,'2022-07-18 16:48:49','2022-09-28 18:57:59',1),(11,2,'删除用户','无','sys:user:delete','无',2,'无',3,'2022-07-18 16:48:49','2022-09-28 18:58:01',1),(12,2,'分配角色','无','sys:user:role','无',2,'无',4,'2022-07-18 16:48:49','2022-09-28 18:58:03',1),(13,2,'重置密码','无','sys:user:repass','无',2,'无',5,'2022-07-18 16:48:49','2022-09-28 18:58:05',1),(14,3,'修改角色','无','sys:role:update','无',2,'无',2,'2022-07-18 16:48:49','2022-09-28 18:58:14',1),(15,3,'删除角色','无','sys:role:delete','无',2,'无',3,'2022-07-18 16:48:49','2022-09-28 18:58:16',1),(16,3,'分配权限','无','sys:role:perm','无',2,'无',5,'2022-07-18 16:48:49','2022-09-28 18:58:19',1),(17,4,'添加菜单','无','sys:menu:save','无',2,'无',1,'2022-07-18 16:48:49','2022-09-28 18:58:28',1),(18,4,'修改菜单','无','sys:menu:update','无',2,'无',2,'2022-07-18 16:48:49','2022-09-28 18:58:30',1),(19,4,'删除菜单','无','sys:menu:delete','无',2,'无',3,'2022-07-18 16:48:49','2022-09-28 18:58:32',1),(32,0,'活动负责管理','无','core:lead','无',0,'el-icon-s-claim',1,'2022-10-05 11:05:18','2022-10-10 16:51:50',1),(34,32,'管理我的活动','/manageMyActivity',NULL,NULL,0,'el-icon-menu',NULL,'2022-10-05 11:05:18','2022-10-05 11:05:20',1),(35,0,'活动申请管理','无','core:apply','无',0,'el-icon-chat-line-round',2,'2022-10-05 11:05:18','2022-10-05 14:58:16',1),(37,35,'审核申请活动','/reviewApplicationActivity','core:apply:list',NULL,1,'el-icon-menu',1,'2022-10-05 11:05:18','2022-10-05 15:01:18',1),(38,0,'部门管理','无','core:asso','无',0,'el-icon-office-building',3,'2022-10-05 11:05:18','2022-10-05 14:58:51',1),(39,38,'部门类型列表','/deptType','core:assotype:list','',1,'el-icon-menu',1,'2022-10-05 11:05:18','2022-10-05 15:00:31',1),(40,38,'部门列表','/deptList','core:asso:list',NULL,1,'el-icon-menu',1,'2022-10-05 11:05:18','2022-10-05 15:00:44',1),(41,0,'打印管理','无','sys:print','无',0,'el-icon-printer',1,'2022-10-05 11:05:18','2022-10-05 14:57:49',1),(42,41,'文件列表','/file','sys:file:list','/Manage/Main/Print/File',1,'el-icon-menu',1,'2022-10-05 11:09:48','2022-10-05 15:01:35',1),(43,0,'备份管理','无','sys:backup','无',0,'el-icon-menu',4,'2022-10-05 11:10:24','2022-10-05 14:48:19',1),(44,43,'备份列表','/backupAndRestore','sys:backup:list','/Main/BackupAndRestore',1,'el-icon-refresh-left',1,'2022-10-05 11:10:53','2022-10-05 14:59:51',1);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL COMMENT '角色名',
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  `role_remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `role_statu` int NOT NULL COMMENT '角色状态（0启用，1禁用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`) USING BTREE,
  UNIQUE KEY `role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (0,'系统管理员','sysadmin','最高权限','2022-09-06 21:14:08','2022-09-06 21:14:04',1),(1,'普通学生','student','可以参加收藏活动','2022-09-08 07:23:57','2022-09-08 07:24:01',1),(2,'部门学生','assoStudent','参与部门的学生','2022-09-08 07:24:47','2022-09-08 12:12:29',1),(3,'普通老师','teacher','与学生参与活动','2022-09-08 07:25:45','2022-09-08 07:25:48',1),(4,'系统管理老师','sysTeacher','参与管理系统','2022-09-08 07:26:43','2022-09-08 07:26:48',1),(5,'审核老师','assoTeacher','参与审核','2022-09-08 07:31:45','2022-09-08 07:31:48',1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (85,3,2),(86,3,9),(87,3,10),(88,3,11),(89,3,12),(90,3,13),(91,3,3),(227,0,32),(228,0,34),(229,0,41),(230,0,42),(231,0,35),(232,0,37),(233,0,38),(234,0,39),(235,0,40),(236,0,43),(237,0,44),(238,0,1),(239,0,2),(240,0,9),(241,0,10),(242,0,11),(243,0,12),(244,0,13),(245,0,3),(246,0,7),(247,0,14),(248,0,15),(249,0,16),(250,0,4),(251,0,17),(252,0,18),(253,0,19),(254,0,5),(255,0,6),(256,2,32),(257,2,34),(258,4,1),(259,4,2),(260,4,9),(261,4,10),(262,4,11),(263,4,12),(264,4,13),(265,4,3),(266,4,7),(267,4,14),(268,4,15),(269,4,16),(270,4,4),(271,4,17),(272,4,18),(273,4,19),(274,5,32),(275,5,34),(276,5,35),(277,5,37);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `asso_id` bigint DEFAULT NULL COMMENT '部门协会id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `user_integral` bigint DEFAULT '0' COMMENT '用户积分',
  `user_autograph` varchar(255) DEFAULT NULL COMMENT '用户签名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login` datetime DEFAULT NULL COMMENT '最后登入',
  `user_statu` int DEFAULT NULL COMMENT '（0无认证状态，1认证过，2审核状态，3禁用、4注销）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'GitXulti','13178017923','$2a$10$9eQmfoPak50JIUheCPYCoupsomKJxscbWSg8iRI34iIJH8tW9rzhK',0,'http://localhost:18888/product/headImage/users/GitXulti/1_45371516d719451f.png','1449903582@qq.com','厦门',9999,'好像做一个基于NLP和过滤协同的大学生活动管理与推荐的前后端分离系统呀','2022-09-02 21:07:45','2022-10-09 14:43:11','2022-09-02 21:07:51',1),(2,'ZhiKun','12351','$2a$10$3uZPRrBu6K0K2ik4q734iusfybCFClaKYn3zvAVrOowuBiv4oKW..',0,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','4857@qq.com','泉州',880,'纸上学来总觉浅，还是没有舍友卷','2022-09-06 23:19:32','2022-09-06 23:19:35','2022-09-06 23:19:37',1),(3,'JinPo','18250629765','$2a$10$09DJhCPBIpDZbHxeAdwzQei6h.QKotBurceO1UnJOQ.mMMZ6iNfyu',0,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','412312857@qq.com','泉州',500,'幸好我偷偷滴学了Spring+SpringMVC+Mybatis。','2022-09-07 09:42:33','2022-09-08 09:52:24','2022-09-07 09:42:39',1),(4,'admin','86+771238673','$2a$10$LrrMw37yK4e7./tNRpXaDu70y858X5C6Fmk2kPoC6G0k7PFzcdGry',0,'http://localhost:18888/product/headImage/users/admin/4_1e6d280a234e4e6c.png','2376928623@qq.com','福建省厦门市集美区厦门理工学院知行苑4-401',11110,'还好我是管理员呀23412312312321','2022-09-07 11:18:09','2022-09-19 18:53:27','2022-09-07 11:18:15',1),(5,'test','1312563','$2a$10$ZijLZFWNmDgdYkw9DKrjqO0UwdBoLiSMfJS6spREi0VszdZjRzwrO',1,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','1112316557@qq.com','漳州',1,'关于我做项目，舍友偷偷卷我这件事','2022-09-08 09:03:35','2022-09-08 10:22:42','2022-09-08 09:03:40',1),(7,'myname','131313','111',1,'png','1231@qq.com','XiaMen',999,'nong','2022-09-09 10:56:22','2022-09-09 10:56:22','2022-09-09 10:56:22',1),(9,'123123','123','$2a$10$hnope5huu9MZT143Q/8wHOel5TFxlPsdkCaLUsP3w3wHiDPiRBdXC',NULL,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','123',NULL,0,NULL,'2022-10-09 10:57:17',NULL,NULL,1),(10,'test1','12314123','$2a$10$/d8YAzpBGOliqYljq/lyye.HKLcHYSRhMSeffCyHrmCAta8jPo2h2',NULL,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','131798213@163.com',NULL,0,NULL,'2022-10-09 14:43:35',NULL,NULL,1),(11,'test122','12314123','$2a$10$bO4RQszo3877lHuAioPvoOnCyscBQgj42ngaZSsiyr89hAxaNTqEG',NULL,'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png','131798213@163.com',NULL,0,NULL,'2022-10-09 14:43:44',NULL,NULL,1);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (40,5,0),(41,5,5),(51,2,2),(52,2,3),(53,2,5),(57,3,1),(58,3,2),(59,3,3),(60,3,4),(73,7,1),(80,4,0),(81,4,1),(82,4,2),(83,4,3),(84,4,4),(85,4,5),(87,1,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 17:13:40
