##管理系统
### 模式
* 采用MVC模式
### 功能
1. 用户登录
2. 部门的显示
3. 部门的添加、删除、修改
4. 部门的分页显示
### 数据库
* 采用MySQL
#### 创建部门表格
***
CREATE TABLE dept(
   dept_id varchar(11) NOT NULL,
   dept_name varchar(20) DEFAULT NULL,
   dept_loc varchar(10) DEFAULT NULL,
   dept_leader varchar(20) DEFAULT NULL,
   PRIMARY KEY (dept_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#### 插入数据
***
INSERT INTO dept VALUES('A0001','总经办','101室','李雷');
INSERT INTO dept VALUES('A0002','渠道部','102室','韩梅梅');
INSERT INTO dept VALUES('A0003','市场营销部','103室','张三丰');
INSERT INTO dept VALUES('A0004','教质部','104室','李莫愁');
INSERT INTO dept VALUES('A0005','教学部','105室','白字画');
INSERT INTO dept VALUES('A0006','就业部','106室','花千骨');
#### 用户表
CREATE TABLE user(
  username varchar(20) NOT NULL,
  password varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#### 插入数据
INSERT INTO user VALUES('admin','admin');
INSERT INTO user VALUES('test','test');
