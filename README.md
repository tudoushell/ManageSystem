## 管理系统

### 模式

* 采用MVC模式

### 功能

1. 用户登录
2. 部门的显示
3. 部门的添加、删除、修改
4. 部门的分页显示

### 数据库

* 采用MySQL

* 部门表格

```
CREATE TABLE dept(
   dept_id VARCHAR(11) NOT NULL,
   dept_name VARCHAR(20) DEFAULT NULL,
   dept_loc VARCHAR(10) DEFAULT NULL,
   dept_leader VARCHAR(20) DEFAULT NULL,
   PRIMARY KEY (dept_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

* 部门表插入数据

```
INSERT INTO dept VALUES('A0001','总经办','101室','李雷');
INSERT INTO dept VALUES('A0002','渠道部','102室','韩梅梅');
INSERT INTO dept VALUES('A0003','市场营销部','103室','张三丰');
INSERT INTO dept VALUES('A0004','教质部','104室','李莫愁');
INSERT INTO dept VALUES('A0005','教学部','105室','白字画');
INSERT INTO dept VALUES('A0006','就业部','106室','花千骨');
```
* 用户表

```
CREATE TABLE user(
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	  user_account VARCHAR(20) NOT NULL COMMENT '登录账号',
	  user_pwd  VARCHAR(20) NOT NULL COMMENT '登录密码',
	  emp_no VARCHAR(20) COMMENT '所属员工编号',
	  emp_Name VARCHAR(10) NOT NULL COMMENT '员工姓名',
	  role_id VARCHAR(10) NOT NULL COMMENT '角色',
	  create_time DATE NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

* 用户表插入数据

```
INSERT INTO user VALUES('admin','admin','1','1','2019-3-4');
INSERT INTO user VALUES('test','test');
```
* 角色表

```
CREATE TABLE role(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	role_name VARCHAR(10) NOT NULL COMMENT '角色名称',
	create_time DATE NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

* 角色表插入数据

```
INSERT INTO role (role_name,create_time) VALUES(
	'管理员',
	 curdate()
); 

INSERT INTO role (role_name,create_time) VALUES(
	'普通用户',
	 curdate()
); 

INSERT INTO role (role_name,create_time) VALUES(
	'人事专员',
	 curdate()
); 
```

* 员工表

```
CREATE TABLE employee(
		id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
		emp_no VARCHAR(20) NOT NULL COMMENT '员工编号',
		emp_name VARCHAR(20) NOT NULL COMMENT '员工姓名',
		emp_dept VARCHAR(20) NOT NULL COMMENT '部门名称',
		sex VARCHAR(10) NOT NULL COMMENT '性别',
		education VARCHAR(10) COMMENT '学历',
		email VARCHAR(20) COMMENT '邮箱',
		phone VARCHAR(20) NOT NULL COMMENT '联系方式',
		entry_time DATE NOT NULL COMMENT '入职时间',
		create_time DATE NOT NULL COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
* 员工表插入数据

```
INSERT INTO employee(emp_no,emp_name,emp_dept,sex,phone,entry_time,create_time) values(
	'E0001',
	'李雷',
	'总经办',
	'男',
	'13888888888',
	'2018-10-2',
	'2018-10-15'
);

INSERT INTO employee(emp_no,emp_name,emp_dept,sex,phone,entry_time,create_time) values(
	'E0002',
	'韩梅梅',
	'渠道部',
	'女',
	'13999999999',
	'2018-10-2',
	'2018-10-15'
);

INSERT INTO employee(emp_no,emp_name,emp_dept,sex,phone,entry_time,create_time) values(
	'E0003',
	'王左',
	'就业部',
	'女',
	'13111111111',
	'2018-10-3',
	'2018-10-14'
);

INSERT INTO employee(emp_no,emp_name,emp_dept,sex,phone,entry_time,create_time) values(
	'E0004',
	'小明',
	'就业部',
	'男',
	'18111111111',
	'2018-10-4',
	'2018-10-15'
);
```
* 报销表

```
CREATE TABLE reimburse(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	reim_no VARCHAR(10) NOT NULL COMMENT '报销编号',
	reim_name VARCHAR(10) NOT NULL COMMENT '申请人',
	reim_type VARCHAR(10) NOT NULL COMMENT '报销类型',
	reim_money DECIMAL(6,2) NOT NULL COMMENT '金额',
	reim_create_time DATE NOT NULL COMMENT '申请时间',
	reim_status VARCHAR(10) NOT NULL COMMENT '申请状态',
	reim_abstract VARCHAR(30) NOT NULL COMMENT '摘要'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
* 菜单表

```
CREATE TABLE menu(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	menu_name VARCHAR(10) NOT NULL COMMENT '菜单名称',
	href_url VARCHAR(40) NOT NULL COMMENT '提交URL',
	parent_id VARCHAR(10)  COMMENT '父子点',
	create_time DATE NOT NULL COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
* 菜单表插入数据

```
INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'人事管理',
	'*',
	null,
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'财务管理',
	'*',
	null,
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'系统管理',
	'*',
	null,
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'部门管理',
	'list.do?page=1',
	'1',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'员工管理',
	'empList.do?page=1',
	'1',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'请假管理',
	'*',
	'1',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'报销管理',
	'listReimburse.do?page=1',
	'2',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'账户维护',
	'*',
	'3',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'角色管理',
	'*',
	'3',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'权限管理',
	'*',
	'3',
	curdate()
);

INSERT INTO menu(menu_name,href_url,parent_id,create_time) VALUES(
	'密码重置',
	'/web/system/recovery.jsp',
	'3',
	curdate()
);

```

* 权限表

```
CREATE TABLE permissions(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	role_id VARCHAR(10) NOT NULL COMMENT '角色ID',
	menu_id VARCHAR(10) NOT NULL COMMENT '菜单ID',
	create_time DATE NOT NULL COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
```

* 权限表插入数据

```
INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'1',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'2',
	'1',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'1',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'2',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'2',
	'2',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'2',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'3',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'2',
	'3',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'3',
	curdate()
);


INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'4',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'5',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'6',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'7',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'8',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'9',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'1',
	'10',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'2',
	'6',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'2',
	'7',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'4',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'5',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'6',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'7',
	curdate()
);

INSERT INTO permissions (role_id,menu_id,create_time) VALUES(
	'3',
	'4',
	curdate()
);

select role.id,role_name,permissions.menu_id,menu.menu_name from role,permissions,menu  where role.id=role_id and permissions.menu_id=menu.id;

```

* 创建权限视图

```
	CREATE VIEW user_privileges as 
	SELECT permissions.id ,role.id as role_id,role_name,permissions.menu_id,menu.menu_name 
	FROM role,permissions,menu  
	WHERE role.id=role_id AND permissions.menu_id=menu.id;

```