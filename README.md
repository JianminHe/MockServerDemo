# MockServerDemo
This project demo how to use Servlet to create a Mock server.  

当前项目采用Servlet 2.5 + Hibernate + tomcat 8.0 + MySQL 5.0 
数据库使用MySQL

src\main\java\hibernate.cfg.xml文件，是数据库配置文件。定义了访问MySQL具体信息。以下是部分的配置信息，需要结合用户的实际情况修改

<hibernate-configuration>
	<session-factory>
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:3306/testdb</property>
		<property name="connection.username">root</property>
		<property name="connection.password">123456</property>
			<property name="connection.pool_size">10</property>
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="current_session_context_class">thread</property>
		<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>
		<property name="show_sql">false</property>
		<property name="hbm2ddl.auto">update</property>
		
		
		connection.url 
		数据库地址。默认使用localhost下 testdb
		connection.username
		数据库用户名
		connection.password
		数据库密码
		
	  请用户自行创建数据库表和演示数据，具体的建表语句如下：
	  /*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-22 15:32:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mock
-- ----------------------------
DROP TABLE IF EXISTS `mock`;
CREATE TABLE `mock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `StatusCode` varchar(255) DEFAULT NULL,
  `RequestBody` varchar(255) DEFAULT NULL,
  `RequestHeader` varchar(255) DEFAULT NULL,
  `RequestMethod` int(11) NOT NULL,
  `RequestParameters` varchar(255) DEFAULT NULL,
  `RequestUrl` varchar(255) DEFAULT NULL,
  `ResponseBody` varchar(255) DEFAULT NULL,
  `ResponseDelay` int(11) DEFAULT NULL,
  `ResponseFormat` varchar(255) DEFAULT NULL,
  `ResponseHeader` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mock
-- ----------------------------
INSERT INTO `mock` VALUES ('1', '200', null, '', '0', 'name=中国', '/b/getAll', '{\"name\":\"hjm\",\"country\":\"中国\"}', '0', 'text/html;charset=utf-8', '{\"Server\":\"Apache/1.3.14(Unix)\"}');
INSERT INTO `mock` VALUES ('2', '200', 'name=hjm&age=38&gender=4', null, '1', null, '/b/z', '{\"ddddd\"\"}', '0', 'text/html;charset=utf-8', '{\"Server\":\"Apache/1.3.14(Unix)\"}');


导入项目以后，在eclipse中使用run on server,输入
http://localhost:8080/MockServerDemo/b/getAll, 浏览器会返回 get请求对应的响应数据。

post请求请自行定义post请求体,请求的formdata = 'name=hjm&age=38&gender=4', 请求地址http://localhost:8080/MockServerDemo/b/z

其他具体情况，请参考代码。


		
