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
	  account_status_id VARCHAR(4) NOT NULL COMMENT '账号状态',
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

* 创建请假表

```
CREATE TABLE holiday(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	holiday_no VARCHAR(20) NOT NULL COMMENT '请假编号',
	holiday_user VARCHAR(20) NOT NULL COMMENT '申请人',
	holiday_type VARCHAR(5) NOT NULL COMMENT '请假类型',
	holiday_bz  VARCHAR(100) NOT NULL COMMENT '请假事由',
	start_time date NOT NULL COMMENT '开始时间',
	end_time date NOT NULL COMMENT '结束时间',
	holiday_status VARCHAR(20) NOT NULL COMMENT '申请状态',
	create_time date NOT NULL COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
```

* 插入数据

```
INSERT INTO holiday (holiday_no,holiday_user,holiday_type,holiday_bz,start_time,end_time,holiday_status,create_time)
values('QJ2','bb','2','回家',curdate(),curdate(),'2',curdate());
```


* 创建配置表

```

CREATE TABLE sys_config(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
	config_type VARCHAR(20) NOT NULL COMMENT '配置类型',
	config_key VARCHAR(20) NOT NULL COMMENT '配置值',
	config_page_value VARCHAR(20) NOT NULL COMMENT '页面值',
	create_time DATE COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
```

* 配置表插入值

```
INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'role_id',
	'1',
	'管理员'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'role_id',
	'2',
	'普通用户'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'role_id',
	'3',
	'人事专员'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'account_status_id',
	'1',
	'正常'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'account_status_id',
	'2',
	'注销'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'1',
	'事假'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'2',
	'婚假'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'3',
	'年假'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'4',
	'调休'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'5',
	'病假'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_type',
	'6',
	'丧假'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_status',
	'1',
	'草稿'
);

INSERT INTO sys_config (config_type,config_key,config_page_value) values(
	'holiday_status',
	'2',
	'提交'
);

```

* 创建用户表(User)和配置表(sys_config)的视图

```
CREATE VIEW v_account AS 
	 select 
	 t3.id,t3.user_account,t3.emp_name,t3.emp_no,t4.config_page_value as account_status,t3.role_name
	 from (
			select t1.id,t1.user_account,t1.emp_name,t1.emp_no,t1.account_status_id,t2.config_page_value as role_name
					from user t1 inner join sys_config t2 
					 on role_id=t2.config_key 
					 where t2.config_type='role_id'
			)t3 
			inner join sys_config t4 
			on t3.account_status_id = t4.config_key 
			where config_type='account_status_id';
```

* 创建请假表(holiday）和配置表(sys_config)的视图

```
CREATE VIEW v_holiday AS
			select
					t3.id,t3.holiday_no,t3.holiday_user,t3.holiday_type,t3.holiday_bz,t3.start_time,t3.end_time,
					t4.config_page_value as holiday_status,t3.create_time
			from (
					select 
							t1.id,holiday_no,holiday_user,t2.config_page_value as 							holiday_type,holiday_bz,start_time,end_time,
							holiday_status,t1.create_time
							from 
							holiday t1 inner join sys_config t2
							on holiday_type=t2.config_key 
							where t2.config_type='holiday_type'
			)t3 
			inner join sys_config t4  
			on t3.holiday_status=t4.config_key
			where t4.config_type='holiday_status'; 

```