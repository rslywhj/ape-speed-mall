/*
Navicat MySQL Data Transfer

Source Server         : mysql8.0
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : db3

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2021-07-05 17:07:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户id',
  `product_id` bigint NOT NULL,
  `num` int NOT NULL COMMENT '购买的数量',
  `product_name` varchar(255) NOT NULL,
  `price` decimal(15,2) NOT NULL COMMENT '商品的价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('13', '12', '10002', '1', '华为 HUAWEI Mate 40 Pro+ 5G 全网通 12GB+256GB（陶瓷白2）', '7899.00');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `category_fid` int NOT NULL COMMENT '一级id',
  `category_sid` int NOT NULL COMMENT '二级id',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', '1');
INSERT INTO `category` VALUES ('2', '1', '2');
INSERT INTO `category` VALUES ('3', '1', '3');
INSERT INTO `category` VALUES ('4', '1', '4');
INSERT INTO `category` VALUES ('5', '1', '5');
INSERT INTO `category` VALUES ('6', '1', '6');
INSERT INTO `category` VALUES ('7', '1', '7');
INSERT INTO `category` VALUES ('8', '1', '8');
INSERT INTO `category` VALUES ('9', '1', '9');
INSERT INTO `category` VALUES ('10', '1', '10');
INSERT INTO `category` VALUES ('11', '2', '11');
INSERT INTO `category` VALUES ('12', '2', '12');
INSERT INTO `category` VALUES ('13', '2', '13');
INSERT INTO `category` VALUES ('14', '2', '14');
INSERT INTO `category` VALUES ('15', '2', '15');
INSERT INTO `category` VALUES ('16', '2', '16');
INSERT INTO `category` VALUES ('17', '2', '17');
INSERT INTO `category` VALUES ('18', '2', '18');
INSERT INTO `category` VALUES ('19', '2', '19');
INSERT INTO `category` VALUES ('20', '2', '20');
INSERT INTO `category` VALUES ('21', '2', '21');
INSERT INTO `category` VALUES ('22', '2', '22');
INSERT INTO `category` VALUES ('23', '3', '23');
INSERT INTO `category` VALUES ('24', '3', '24');
INSERT INTO `category` VALUES ('25', '3', '25');
INSERT INTO `category` VALUES ('26', '3', '26');
INSERT INTO `category` VALUES ('27', '3', '27');
INSERT INTO `category` VALUES ('28', '3', '28');
INSERT INTO `category` VALUES ('29', '3', '29');
INSERT INTO `category` VALUES ('30', '4', '30');
INSERT INTO `category` VALUES ('31', '7', '31');
INSERT INTO `category` VALUES ('32', '10', '32');
INSERT INTO `category` VALUES ('33', '13', '33');
INSERT INTO `category` VALUES ('34', '16', '34');
INSERT INTO `category` VALUES ('35', '16', '35');
INSERT INTO `category` VALUES ('36', '16', '36');
INSERT INTO `category` VALUES ('37', '16', '37');
INSERT INTO `category` VALUES ('38', '16', '38');
INSERT INTO `category` VALUES ('39', '19', '39');
INSERT INTO `category` VALUES ('40', '22', '40');

-- ----------------------------
-- Table structure for first_level
-- ----------------------------
DROP TABLE IF EXISTS `first_level`;
CREATE TABLE `first_level` (
  `first_id` int NOT NULL AUTO_INCREMENT COMMENT '一级表的id',
  `first_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '一级表的名字',
  PRIMARY KEY (`first_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_level
-- ----------------------------
INSERT INTO `first_level` VALUES ('1', '家电');
INSERT INTO `first_level` VALUES ('2', '数码');
INSERT INTO `first_level` VALUES ('3', '手机');
INSERT INTO `first_level` VALUES ('4', '女装');
INSERT INTO `first_level` VALUES ('5', '男装');
INSERT INTO `first_level` VALUES ('6', '穿搭');
INSERT INTO `first_level` VALUES ('7', '家具');
INSERT INTO `first_level` VALUES ('8', '家饰');
INSERT INTO `first_level` VALUES ('9', '家纺');
INSERT INTO `first_level` VALUES ('10', '运动');
INSERT INTO `first_level` VALUES ('11', '户外');
INSERT INTO `first_level` VALUES ('12', '乐器');
INSERT INTO `first_level` VALUES ('13', '游戏');
INSERT INTO `first_level` VALUES ('14', '动漫');
INSERT INTO `first_level` VALUES ('15', '影视');
INSERT INTO `first_level` VALUES ('16', '美妆');
INSERT INTO `first_level` VALUES ('17', '清洁');
INSERT INTO `first_level` VALUES ('18', '宠物');
INSERT INTO `first_level` VALUES ('19', '鞋靴');
INSERT INTO `first_level` VALUES ('20', '玩具');

-- ----------------------------
-- Table structure for ordermanagement
-- ----------------------------
DROP TABLE IF EXISTS `ordermanagement`;
CREATE TABLE `ordermanagement` (
  `oid` bigint NOT NULL AUTO_INCREMENT,
  `vid` bigint NOT NULL,
  `consignee` varchar(255) NOT NULL,
  `guest_book` varchar(255) NOT NULL,
  `total_amount` decimal(15,2) NOT NULL,
  `received_amount` decimal(15,2) NOT NULL,
  `distribution` varchar(255) NOT NULL,
  `order_data` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `refund_amount` decimal(15,2) DEFAULT NULL,
  `apply_data` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `refund_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `refund_notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordermanagement
-- ----------------------------
INSERT INTO `ordermanagement` VALUES ('1', '0', '张三', '那好', '133.00', '133.00', '包邮', '2021-11-11', '已发货', '张三', '123.00', '2021-03-03', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('2', '0', '李四', '我i返回王瑞复活复活', '422.00', '123.00', '发', '2021-09-09', '双方的', '双方的', '233.00', '2021-09-09', '无', '0', '特');
INSERT INTO `ordermanagement` VALUES ('3', '0', '34认为', '大热', '24.00', '42.00', '个人', '2021-04-09', '热', '而', '423.00', '2021-09-08', '无', '0', '幸福的');
INSERT INTO `ordermanagement` VALUES ('6', '0', '张玉佳', '尽快发货', '100.00', '100.00', '顺丰快递', '2021-07-01', '已发货', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('7', '0', '张玉佳', '请交给本人', '999.00', '999.00', '顺丰快递', '2021-07-01 20:28:53', '已发货', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('8', '0', '卢学硕', '不吃香菜', '0.66', '0.66', '申通快递', '2021-07-01 20:33:11', '已发货', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('9', '0', '卢学', '不吃香菜dyguahs n', '456.00', '456.00', '申通快递', '2021-07-01 20:36:43', '已发货', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('10', '0', '张玉佳', '不吃香菜', '45.00', '45.00', '京东', '2021-07-01 21:29:10', '待付款', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('11', '0', '张玉佳', '不吃香菜', '45.00', '45.00', '京东', '2021-07-01 21:38:32', '待付款', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('23', '0', '123', '123', '456.00', '456.00', '1231', '2021-07-01 22:20:26', '待付款', '无', '0.00', '无', '无', '0', '无');
INSERT INTO `ordermanagement` VALUES ('24', '1', '张雨佳', '张雨佳', '39850.00', '39850.00', '顺丰', '2021-07-05 01:45:16', '已收货', '无', '0.00', '无', '无', '唐山学院大学西道校区北院', '无');
INSERT INTO `ordermanagement` VALUES ('25', '1', '战于当时', '张雨佳', '39850.00', '39850.00', '顺丰', '2021-07-05 01:52:19', '已发货', '无', '0.00', '无', '无', '天津市滨海新区天滨公寓7-534', '无');
INSERT INTO `ordermanagement` VALUES ('26', '1', '撒', '打算', '39850.00', '39850.00', '顺丰', '2021-07-05 01:53:32', '退款', '撒', '39850.00', '2021-07-05 01:55:31', '已退款', '打算', '无');
INSERT INTO `ordermanagement` VALUES ('27', '1', 'zhaangyujai', 'zahuih', '40915.00', '40915.00', '圆通', '2021-07-05 09:42:50', '已发货', '无', '0.00', '无', '无', 'dafda', '无');
INSERT INTO `ordermanagement` VALUES ('28', '1', 'ddd', 'aaa', '2599.00', '2599.00', '圆通', '2021-07-05 09:56:38', '待发货', '无', '0.00', '无', '无', '天津市滨海新区天滨公寓', '无');
INSERT INTO `ordermanagement` VALUES ('29', '11', 'aaa', 'aaa', '31596.00', '31596.00', '顺丰', '2021-07-05 11:18:16', '待发货', '无', '0.00', '无', '无', 'aaa', '无');
INSERT INTO `ordermanagement` VALUES ('30', '12', 'ZHANGYUJIA', 'ZHANGYUJIA', '86889.00', '86889.00', '圆通', '2021-07-05 11:32:21', '退款', 'ZHANGYUJIA', '86889.00', '2021-07-05 11:33:35', '已退款', 'TIANJIN', '无');
INSERT INTO `ordermanagement` VALUES ('31', '12', 'QWQ', 'WE', '9968.00', '9968.00', '圆通', '2021-07-05 11:34:48', '已收货', '无', '0.00', '无', '无', 'ZHANGYUJIA', '无');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gpicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `sales_volume` bigint DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `surplus` bigint DEFAULT NULL,
  `status_id` int NOT NULL COMMENT '状态id',
  `tid` bigint DEFAULT NULL,
  `express` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` int NOT NULL COMMENT '类别id',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10045 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('10001', '华为 HUAWEI Mate 40 Pro+ 5G 全网通 12GB+256GB（陶瓷白）', '5nm麒麟9000旗舰芯片 | 超感光徕卡电影影象', 'http://localhost:8080\\my_shop_user\\img\\8.PNG', '7899.00', '13000', '14532', '100', '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10002', '华为 HUAWEI Mate 40 Pro+ 5G 全网通 12GB+256GB（陶瓷白2）', '5nm麒麟9000旗舰芯片 | 超感光徕卡电影影象', 'http://localhost:8080\\my_shop_user\\img\\9.PNG', '7899.00', '13000', '14532', '100', '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10003', 'Huawei华为Mate Xs', '现货当天发 Huawei华为Mate Xs 5G折叠手机mateX2官网正品mate/40rs保时捷官方旗舰店matexs5g二代双屏折叠', 'http://localhost:8080\\my_shop_user\\img\\10.PNG', '1.21', null, '1', null, '0', '1', null, '1');
INSERT INTO `product` VALUES ('10004', 'Huawei/华为Nova 8', '\r\n顺丰包邮 Huawei/华为Nova 8 5g手机麒麟新品66W快充nova8直降9', 'http://localhost:8080\\my_shop_user\\img\\4.PNG', '1.21', null, '1', null, '1', '1', null, '2');
INSERT INTO `product` VALUES ('10005', 'HUAWEI/华为 畅享', '【顺丰包邮】HUAWEI/华为 畅享 10S官方正品全网通手机畅享10s', 'http://localhost:8080\\my_shop_user\\img\\12.PNG', '132.00', null, '132', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10006', ' HUAWEI P30 PRO', '华为HUAWEI HUAWEI P30 PRO官方旗舰店P30降价现货曲面屏p30手机', 'http://localhost:8080\\my_shop_user\\img\\13.PNG', '123.00', null, '123', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10007', 'zhangyujkoi', '当天发【12期免息】Huawei/华为 nova 8 Pro 5G手机官方直降nova7旗舰店曲面屏nove9se官网p新款40正品', 'http://localhost:8080\\my_shop_user\\img\\5.PNG', '456.00', null, '456', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10008', '华为/ nove9se', '当天发【12期免息】Huawei/华为 nova 8 Pro 5G手机官方直降nova7旗舰店曲面屏nove9se官网p新款40正品', 'http://localhost:8080\\my_shop_user\\img\\7.PNG', '5888.00', null, '3445', null, '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10009', '华为/Huawei Mate 40E', '当天发 24期分期送好礼华为/Huawei Mate 40E 5G手机mate40pro正品官方旗舰店mate50直降折叠保时捷新品40pro', 'http://localhost:8080\\my_shop_user\\img\\6.PNG', '8198.00', null, '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10010', '工装外套', '春秋男士连帽牛仔衣休闲夹克胖子宽松加肥加大码韩版潮流工装外套', 'http://localhost:8080\\my_shop_user\\img\\2.PNG', '88.00', '123123', '12344132', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10011', '工装外套', '春秋男士连帽牛仔衣休闲夹克胖子宽松加肥加大码韩版潮流工装外套', 'http://localhost:8080\\my_shop_user\\img\\1.PNG', '88.00', '112321', '123123', null, '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10012', '罗纹夹克', '[SALE]Adidas x HUMAN MADE联名款 2021夏季男罗纹夹克netaporter', 'http://localhost:8080\\my_shop_user\\img\\3.PNG', '1490.00', '1313', '123312', '100', '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10013', '高领夹克', '[SALE]Adidas x PARLEY联名款 2021夏季男绿色高领夹克netaporter', 'http://localhost:8080\\my_shop_user\\img\\4.PNG', '2140.00', '12342', '12323', '100', '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10014', '连帽夹克', '射手无敌正品Adidas阿迪达斯男装ZNE训练外套跑步连帽夹克CY5483', 'http://localhost:8080\\my_shop_user\\img\\14.PNG', '489.00', '130000', '12345', '1000', '1', '1', '1', '1');
INSERT INTO `product` VALUES ('10015', '立领夹克', '英国代购 2021款 Adidas 男装三叶草LOGO休闲立领夹克', 'http://localhost:8080\\my_shop_user\\img\\15.PNG', '729.00', null, '12000', '100', '1', '1', null, '1');
INSERT INTO `product` VALUES ('10016', '圆领宽松纯棉印花上衣', '李宁CF牛掰短袖T恤男2021夏季新款男装圆领宽松纯棉印花上衣吸汗', 'http://localhost:8080\\my_shop_user\\img\\16.PNG', '158.00', '110000', '1', '100', '1', '1', null, '1');
INSERT INTO `product` VALUES ('10017', '长袖圆领宽松廓形提花卫衣', '李宁套头卫衣女士新款套头长袖圆领宽松廓形提花卫衣运动服蝙蝠衫', 'http://localhost:8080\\my_shop_user\\img\\17.PNG', '298.00', '110000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10018', '休闲鞋低帮鞋子', '李宁板鞋女白色女鞋2021夏季新款休闲鞋低帮鞋子运动鞋小白鞋女士', 'http://localhost:8080\\my_shop_user\\img\\18.PNG', '239.00', null, '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10019', '涮羊肉卷', '火锅涮羊肉卷高钙肥羊卷原切纯羊肉片商用内蒙古冻羊肉羔卷', 'http://localhost:8080\\my_shop_user\\img\\19.PNG', '119.90', null, '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10020', 'Apple苹果iPad', 'Apple苹果iPad平板电脑iPad第八代10.2英寸2020版新款wifi官方正品全新官网授权旗舰店国行128G', 'http://localhost:8080\\my_shop_user\\img\\20.PNG', '2699.90', '100000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10021', '佳能EOS', 'Canon/佳能EOS M50套机(15-45)数码相机m62微单vlog美颜二代m50', 'http://localhost:8080\\my_shop_user\\img\\21.PNG', '6650.00', '1500', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10022', '情侣书包', '国家地理背包女运动户外时尚电脑双肩包男旅行防水学生情侣书包大', 'http://localhost:8080\\my_shop_user\\img\\22.PNG', '4500.00', '15000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10023', '健身水壶', '运动水杯大容量男健身水壶户外2000ml超大号杯子夏季塑料便携水瓶', 'http://localhost:8080\\my_shop_user\\img\\23.PNG', '115.00', '14000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10024', '穿戴式摄像机', '专业微形录像机随身带视频户外运动相机便携式记录仪dv迷你摄影头手表无线手机小型录音神器高清穿戴式摄像机', 'http://localhost:8080\\my_shop_user\\img\\24.PNG', '328.00', '5000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10025', '男士棒球帽', '帽子男夏季薄款速干upf50+遮阳防晒鸭舌帽夏天户外运动男士棒球帽', 'http://localhost:8080\\my_shop_user\\img\\25.PNG', '288.00', '4000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10026', '保暖围脖套', '冬季保暖围脖套男面罩调节户外骑行魔术头巾运动滑雪防风防寒加绒', 'http://localhost:8080\\my_shop_user\\img\\26.PNG', '29.00', '3000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10027', '智能手表gt2', '华为手机适用智能手表gt2太空人电话运动跑步男款女款男士男生多功能华强北蓝牙户外手环电子黑科技watch新款', 'http://localhost:8080\\my_shop_user\\img\\27.PNG', '219.00', null, '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10028', '风衣外套wt', '防晒衣男夏季超薄透气UPF50+防紫外线户外钓鱼防晒服女风衣外套wt', 'http://localhost:8080\\my_shop_user\\img\\28.PNG', '369.00', null, '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10029', '射抓捕枪', '三宝爆射抓捕枪儿童玩具小男孩子5射击捕捉器抢6岁爪报7社暴裂兽', 'http://localhost:8080\\my_shop_user\\img\\29.PNG', '49.00', '8000', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10030', '大号摩托车', '灵动创想魔幻旋风轮正版玩具男孩儿童旋转陀螺新款大号摩托车回旋', 'http://localhost:8080\\my_shop_user\\img\\30.PNG', '50.00', '1500', '1', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10032', '测试', '这是测试的介绍', 'http://localhost:8080\\my_shop_user\\img\\20210704/2c0fc1f0111e412fa51bfda60e52140b.png', '1200.00', null, '10', null, '1', '1', null, '1');
INSERT INTO `product` VALUES ('10036', '纪梵希高定香榭天鹅绒唇膏306#', '(小羊皮口红 法式红 雾面哑光 持久锁色）新老包装随机发货', 'http://localhost:8080\\my_shop_user\\img\\20210704/b59fcea158c14771bf330e9659568a9d.jpg', '355.00', null, '10000', null, '1', null, null, '9');
INSERT INTO `product` VALUES ('10037', '索尼 WH-1000XM3 头戴式耳机', '高解析度无线蓝牙降噪（触控面板 智能降噪 长久续航）黑色', 'http://localhost:8080\\my_shop_user\\img\\20210705/92cb8b772a2a48c19c08fc36d76b596b.jpg', '2599.00', null, '10000', null, '1', null, null, '11');
INSERT INTO `product` VALUES ('10038', 'Apple AirPods 配充电盒', '苹果蓝牙耳机', 'http://localhost:8080\\my_shop_user\\img\\20210705/43e753d1c1d84cbba6124db95e8bd7ce.jpg', '1246.00', null, '10000', null, '1', null, null, '11');
INSERT INTO `product` VALUES ('10039', 'MAC 雾面丝绒哑光子弹头口红', '磨砂系列 3g 316 devoted to chili 泫雅色', 'http://localhost:8080\\my_shop_user\\img\\20210705/d57b16158cd941b38eca0f2271a83b7f.jpg', '165.00', null, '10000', null, '1', null, null, '9');
INSERT INTO `product` VALUES ('10040', 'Apple 2019款 MacBook Air 13.3', 'Apple 2019款 MacBook Air 13.3', 'http://localhost:8080\\my_shop_user\\img\\20210705/7174bf37f7814b7d8cb55e5f13ad3d7c.jpg', '8499.00', null, '10000', null, '1', null, null, '11');
INSERT INTO `product` VALUES ('10041', '无印良品 MUJI 塑料浴室座椅', '原色', 'http://localhost:8080\\my_shop_user\\img\\20210705/31a85753f095499291d4e94767c5fd68.jpg', '85.00', null, '10000', null, '1', null, null, '1');
INSERT INTO `product` VALUES ('10042', '测试3', '描述', 'http://localhost:8080/my_shop_user/img/20210705/8854ea463e004d6f8aecf25eeae45183.png', '120.50', null, '15', null, '1', null, null, '1');
INSERT INTO `product` VALUES ('10043', '测试4', '描述', 'http://localhost:8080/my_shop_user/img/20210705/b57aea82c1b14ca28cb8f8a7c452352d.png', '11.11', null, '11', null, '1', null, null, '11');
INSERT INTO `product` VALUES ('10044', 'zhangyujia', 'zhangyujia', 'http://localhost:8080/my_shop_user/img/20210705/4ecbcf00839f4b2c8719beaea99862c3.png', '123.00', null, '110', null, '1', null, null, '23');

-- ----------------------------
-- Table structure for second_level
-- ----------------------------
DROP TABLE IF EXISTS `second_level`;
CREATE TABLE `second_level` (
  `second_id` int NOT NULL COMMENT '二级表的id',
  `second_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二级表的名字',
  PRIMARY KEY (`second_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_level
-- ----------------------------
INSERT INTO `second_level` VALUES ('1', '生活电器');
INSERT INTO `second_level` VALUES ('2', '厨房电器');
INSERT INTO `second_level` VALUES ('3', '吸尘器');
INSERT INTO `second_level` VALUES ('4', '取暖器');
INSERT INTO `second_level` VALUES ('5', '豆浆机');
INSERT INTO `second_level` VALUES ('6', '暖风机');
INSERT INTO `second_level` VALUES ('7', '加湿器');
INSERT INTO `second_level` VALUES ('8', '蓝牙音箱');
INSERT INTO `second_level` VALUES ('9', '烤箱');
INSERT INTO `second_level` VALUES ('10', '卷发器');
INSERT INTO `second_level` VALUES ('11', '游戏主机');
INSERT INTO `second_level` VALUES ('12', '二手手机');
INSERT INTO `second_level` VALUES ('13', '数码精选');
INSERT INTO `second_level` VALUES ('14', '平板电脑');
INSERT INTO `second_level` VALUES ('15', '苹果Apple');
INSERT INTO `second_level` VALUES ('16', '电脑主机');
INSERT INTO `second_level` VALUES ('17', '数码相机');
INSERT INTO `second_level` VALUES ('18', '电玩动漫');
INSERT INTO `second_level` VALUES ('19', '单反相机');
INSERT INTO `second_level` VALUES ('20', '键盘鼠标');
INSERT INTO `second_level` VALUES ('21', '无人机');
INSERT INTO `second_level` VALUES ('22', '二手电脑');
INSERT INTO `second_level` VALUES ('23', '荣耀手机');
INSERT INTO `second_level` VALUES ('24', '华为手机');
INSERT INTO `second_level` VALUES ('25', '苹果iPhone');
INSERT INTO `second_level` VALUES ('26', '小米手机');
INSERT INTO `second_level` VALUES ('27', 'OPPO');
INSERT INTO `second_level` VALUES ('28', '一加');
INSERT INTO `second_level` VALUES ('29', 'vivo');
INSERT INTO `second_level` VALUES ('30', '外套');
INSERT INTO `second_level` VALUES ('31', '沙发');
INSERT INTO `second_level` VALUES ('32', '跑鞋');
INSERT INTO `second_level` VALUES ('33', '王者荣耀');
INSERT INTO `second_level` VALUES ('34', '口红');
INSERT INTO `second_level` VALUES ('35', '睫毛膏');
INSERT INTO `second_level` VALUES ('36', '腮红');
INSERT INTO `second_level` VALUES ('37', '粉底');
INSERT INTO `second_level` VALUES ('38', '隔离霜');
INSERT INTO `second_level` VALUES ('39', '休闲鞋');
INSERT INTO `second_level` VALUES ('40', '小玩具');

-- ----------------------------
-- Table structure for vipmanagement
-- ----------------------------
DROP TABLE IF EXISTS `vipmanagement`;
CREATE TABLE `vipmanagement` (
  `vid` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `registration_data` varchar(255) NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipmanagement
-- ----------------------------
INSERT INTO `vipmanagement` VALUES ('1', '2', 'qq123455', '123456', '张三', '13234567890', '1231@qq.com', '2121-09-08');
INSERT INTO `vipmanagement` VALUES ('2', '3', 'qq2344', '123456', '李四', '13777777777', '1313213@qq.com', '2021-09-09');
INSERT INTO `vipmanagement` VALUES ('3', '5', 'qq234234', '123456', '王五', '13666666666', '1323@qq.com', '2021-09-09');
INSERT INTO `vipmanagement` VALUES ('4', null, '132', '123456', '赵六', '13888888888', '132@163.com', '2021-07-02');
INSERT INTO `vipmanagement` VALUES ('8', null, '1234', '123456', '1234', '12341234123', '1234@126.com', '2021-07-02');
INSERT INTO `vipmanagement` VALUES ('10', null, '123', '123456', '123', '12312312312', '123@qq.com', '2021-07-03');
INSERT INTO `vipmanagement` VALUES ('11', null, '123', '123456789', null, null, null, '2021-07-05');
INSERT INTO `vipmanagement` VALUES ('12', null, '123456', '123456789', null, null, null, '2021-07-05');
