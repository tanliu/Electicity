drop table if exists t_common_scholarship;

drop table if exists t_country_scholarship;

drop table if exists t_courseInfo;

drop table if exists t_courseInfo_students;

drop table if exists t_enrollTransaction;

drop table if exists t_familyInfo;

drop table if exists t_grant_scholarship;

drop table if exists t_guidanceInfo;

drop table if exists t_learningExperience;

drop table if exists t_learningGuid_info;

drop table if exists t_learningGuid_studentsList;

drop table if exists t_loan_scholarship;

drop table if exists t_politicalStatus;

drop table if exists t_postInfo;

drop table if exists t_student_dutys;

drop table if exists t_students;

drop table if exists t_subjectContest;

drop table if exists t_teacherInfo;

drop table if exists t_trainInfo_detail;

drop table if exists t_trainInfo_master;

drop table if exists tb_sys_authority;

drop table if exists tb_sys_login_log;

drop table if exists tb_sys_organization;

drop table if exists tb_sys_role;

drop table if exists tb_sys_role_authority;

drop table if exists tb_sys_user;

drop table if exists tb_sys_user_role;

/*==============================================================*/
/* Table: t_common_scholarship                                  */
/*==============================================================*/
create table t_common_scholarship
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   major                varchar(128) comment '专业',
   rewardName           varchar(20) comment '获奖名称',
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   memo                 varchar(200),
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_common_scholarship comment '普通奖学金表';

/*==============================================================*/
/* Table: t_country_scholarship                                 */
/*==============================================================*/
create table t_country_scholarship
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   sex                  varchar(2),
   grade                varchar(20) comment '年级',
   politicalStatus      varchar(20) comment '政治面貌',
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   major                varchar(100) comment '专业',
   school_scholar_info  varchar(500) comment '本校奖学金情况',
   province_scholar_iinfo varchar(500) comment '获省级及省级以上奖学金情况',
   award_info           varchar(500) comment '评优获奖情况',
   competition_info     varchar(500) comment '比赛、竞赛类获奖情况',
   duty                 varchar(200) comment '担任职务',
   rewardName           varchar(20) comment '获奖名称',
   memo                 varchar(200),
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_country_scholarship comment '国家光大奖学金表';

/*==============================================================*/
/* Table: t_courseInfo                                          */
/*==============================================================*/
create table t_courseInfo
(
   id                   varchar(32) not null,
   courseCode           varchar(20) comment '课程代码',
   courseName           varchar(100) comment '课程名称',
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   employ_no            varchar(10) comment '教师工号',
   employ_name          varchar(64) comment '教师姓名',
   selectedCourseNo     varchar(50) comment '选课课号
            ',
   courseType           varchar(20) comment '课程性质',
   totalHours           int comment '总学时',
   labHours             int comment '实验学时',
   classInfo            varchar(200) comment '教学班组成',
   studentNum           int comment '选课人数',
   credit               numeric(4,2) comment '学分：可根据总学时除以16进行换算得到该值',
   belongTo             varchar(100) comment '课程归属：该值在导入的学生成绩明细中',
   memo                 varchar(200),
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_courseInfo comment '开课课程信息表';

/*==============================================================*/
/* Table: t_courseInfo_students                                 */
/*==============================================================*/
create table t_courseInfo_students
(
   id                   varchar(32) not null,
   stu_id               varchar(32),
   studentNo            varchar(16) not null comment '学号',
   stuName              varchar(20),
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   className            varchar(100) comment '班级',
   majorCode            varchar(10) comment '专业代码',
   major                varchar(100) comment '专业',
   retakeFlag           varchar(2),
   usualScore           numeric(5,2) comment '平时成绩',
   middleScore          numeric(5,2) comment '期中成绩',
   endScore             numeric(5,2) comment '期末成绩',
   labScore             numeric(5,2) comment '实验成绩',
   finalScore           numeric(5,2) comment '总评成绩',
   convertScore         numeric(5,2) comment '折算成绩',
   resitScore           numeric(5,2) comment '补考成绩',
   resitMemo            varchar(200) comment '补考成绩备注',
   repairScore          numeric(5,2) comment '重修成绩',
   gradePoint           numeric(5,2) comment '绩点',
   memo                 varchar(200),
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_courseInfo_students comment '学生选课明细表，该表是开课课程信息表的从表，是一对多的关系；该表包含选课的学生信息，以及学生的考核成绩信息。';

/*==============================================================*/
/* Table: t_enrollTransaction                                   */
/*==============================================================*/
create table t_enrollTransaction
(
   id                   varchar(32) not null,
   transactionNo        varchar(32) comment '异动编号',
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   sex                  varchar(2),
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   tansactionClass      varchar(50) comment '异动后行政班',
   processSymbols       varchar(20) comment '处理文号',
   tansactionType       varchar(20),
   tansactionReason     varchar(50) comment '异动原因',
   tansactionDate       datetime comment '异动时间',
   handleDate           datetime,
   cancelDate           datetime,
   tansactionMemo       varchar(100),
   ZXQschool            varchar(100) comment '转学前学校名称',
   ZXQgrade             varchar(20) comment '转学前所在年级',
   ZXQmajor             varchar(50) comment '转学前专业',
   YDQcollege           varchar(50) comment '异动前学院',
   YDQdepartment        varchar(50) comment '异动前系',
   YDQmajor             varchar(50) comment '异动前专业',
   YDQlength            varchar(10) comment '异动前学制',
   YDQmajorField        varchar(100) comment '异动前专业方向',
   YDQcultivateDirection varchar(100) comment '异动前培养方向',
   YDQgrade             varchar(10) comment '异动前所在年级',
   YDQclassName         varchar(100) comment '异动前行政班',
   YDQschoolStatus      varchar(20) comment '异动前学籍状态',
   ZCHschool            varchar(100) comment '转出后学校名称',
   ZCHgrade             varchar(20) comment '转出后年级',
   ZCHmajor             varchar(50) comment '转出后专业',
   YDHcollege           varchar(50) comment '异动后学院',
   YDHdepartment        varchar(50) comment '异动后系',
   YDHmajor             varchar(50) comment '异动后专业',
   YDHlength            varchar(10) comment '异动后学制',
   YDHmajorField        varchar(100) comment '异动后专业方向',
   YDHcultivatedirection varchar(100) comment '异动后培养方向',
   YDHgrade             varchar(10) comment '异动后所在年级',
   YDHclassName         varchar(100) comment '异动后所在班级：预留字段，导入表中无该字段',
   YDHschoolStatus      varchar(20) comment '异动后学籍状态',
   operator             varchar(20) comment '操作人',
   operatorTime         timestamp comment '操作日期',
   YDQinSchool          varchar(2) comment '异动前是否在校',
   YDHinSchool          varchar(2) comment '异动后是否在校',
   YDQmajorCode         varchar(10) comment '异动前专业代码',
   YDHmajorCode         varchar(10) comment '异动后专业代码',
   YDQisRegiste         varchar(2) comment '异动前是否注册',
   YDHisRegiste         varchar(2) comment '异动后是否注册',
   memo                 varchar(200) comment '备注',
   YDQeducation         varchar(20) comment '异动前学历层次',
   YDHeducation         varchar(20) comment '异动后学历层次',
   YDQmajorCategory     varchar(20) comment '异动前专业类别',
   YDHmajorCategory     varchar(20) comment '异动后专业类别',
   YDresult             varchar(20) comment '异动结果',
   studentCategory      varchar(20) comment '学生类别',
   examinateNo          varchar(20) comment '考生号',
   IdCardNo             varchar(18) comment '身份证号码',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_enrollTransaction comment '学籍异动表';

/*==============================================================*/
/* Table: t_familyInfo                                          */
/*==============================================================*/
create table t_familyInfo
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   relation               varchar(20) comment '称呼',
   name                 varchar(20) comment '家庭成员姓名',
   politicalStatus      varchar(20) comment '政治面貌',
   jobDuty              varchar(20) comment '职务',
   TelNo                varchar(20) comment '电话号码',
   company              varchar(200) comment '家庭成员单位',
   companyAddress       varchar(200) comment '单位地址',
   postCode             varchar(6) comment '邮政编码',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_familyInfo comment '学生家庭信息表';

/*==============================================================*/
/* Table: t_grant_scholarship                                   */
/*==============================================================*/
create table t_grant_scholarship
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   sex                  varchar(2),
   politicalStatus      varchar(20) comment '政治面貌',
   nation               varchar(50) comment '民族',
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   major                varchar(100) comment '专业',
   acceptanceDate       varchar(20) comment '入学年月',
   familyEconomic       varchar(20) comment '家庭经济困难程度',
   memo                 varchar(200),
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   reportDate           datetime comment '制表日期',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_grant_scholarship comment '助学金表';

/*==============================================================*/
/* Table: t_guidanceInfo                                        */
/*==============================================================*/
create table t_guidanceInfo
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   className            varchar(200) comment '班级',
   guidDate             datetime,
   guidContent          varchar(500),
   guidAddress          varchar(200),
   counselor            varchar(20),
   docPath              varchar(200) comment '电子文档',
   mediaPath            varchar(200) comment '多媒体文件路径',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_guidanceInfo comment '辅导记录表';

/*==============================================================*/
/* Table: t_learningExperience                                  */
/*==============================================================*/
create table t_learningExperience
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   duration             varchar(50) comment '学习期间',
   schoolName           varchar(200) comment '学校名称',
   duty                 varchar(20) comment '担任职务',
   witness              varchar(20) comment '证明人',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_learningExperience comment '学习经历表';

/*==============================================================*/
/* Table: t_learningGuid_info                                   */
/*==============================================================*/
create table t_learningGuid_info
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   guidDate             datetime comment '导学时间',
   guidContent          varchar(500) comment '导学内容',
   guidAddress          varchar(200) comment '导学地点',
   docPath              varchar(200) comment '电子文档',
   memo                 varchar(200) comment '备注',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_learningGuid_info comment '导学内容表';

/*==============================================================*/
/* Table: t_learningGuid_studentsList                           */
/*==============================================================*/
create table t_learningGuid_studentsList
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   className            varchar(100) comment '班级',
   teacherNo            varchar(5) comment '导师工号',
   teacherName          varchar(20) comment '导师姓名',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_learningGuid_studentsList comment '导学学生名单';

/*==============================================================*/
/* Table: t_loan_scholarship                                    */
/*==============================================================*/
create table t_loan_scholarship
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   sex                  varchar(2),
   IdCardNo             varchar(18) comment '身份证号码',
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   major                varchar(100) comment '专业',
   className            varchar(100) comment '班级',
   grade                varchar(20) comment '年级',
   loanAmount           numeric(7,2) comment '贷款金额',
   censoredFlag         varchar(2) comment '是否通过专业学院资格审核',
   refuseReason         varchar(200) comment '被拒绝原因',
   memo                 varchar(200),
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   repayFlag            varchar(2) comment '预留字段：还贷标志',
   repayAmount          numeric(7,2) comment '预留字段：还贷金额',
   repayDate            datetime comment '预留字段：还贷日期',
   modifyDate           datetime comment '修改日期：还贷使用',
   modifier             varchar(32) comment '修改时间：还贷使用',
   primary key (id)
);

alter table t_loan_scholarship comment '学生贷款表';

/*==============================================================*/
/* Table: t_politicalStatus                                     */
/*==============================================================*/
create table t_politicalStatus
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   joinDate             datetime comment '入党团时间',
   politicalStatus      varchar(20) comment '政治面貌',
   memo                 varchar(200),
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_politicalStatus comment '学生党团关系表';

/*==============================================================*/
/* Table: t_postInfo                                            */
/*==============================================================*/
create table t_postInfo
(
   id                   varchar(32) not null,
   EMSNo                varchar(30) comment 'EMS编号',
   schoolNo             varchar(30) comment '北理工编号',
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   major                varchar(100) comment '专业',
   sex                  varchar(2),
   dispatchType         varchar(20) comment '派遣性质',
   chargeUnit           varchar(100) comment '主管单位',
   mailNo               varchar(30) comment '邮件号*',
   memo                 varchar(200) comment '备注',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_postInfo comment '学生档案邮寄信息表';

/*==============================================================*/
/* Table: t_student_dutys                                       */
/*==============================================================*/
create table t_student_dutys
(
   id                   varchar(32) not null,
   grade                varchar(40) comment '年级',
   className            varchar(100) comment '班级',
   stu_id               varchar(32) not null,
   studentNo            varchar(16) not null comment '学号',
   stuName              varchar(20),
   sex                  varchar(2) comment '性别',
   telNo                varchar(16) comment '电话号码',
   shortTelNo           varchar(16) comment '短号',
   duty                 varchar(20) comment '职务',
   address              varchar(100) comment '宿舍',
   memo                 varchar(200),
   primary key (id)
);

alter table t_student_dutys comment '学生职务信息表';

/*==============================================================*/
/* Table: t_students                                            */
/*==============================================================*/
create table t_students
(
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   sex                  varchar(2),
   birthday             datetime,
   politicalStatus      varchar(20) comment '政治面貌',
   nation               varchar(50) comment '民族',
   nativePlace          varchar(20) comment '籍贯',
   from_place           varchar(100) comment '来源地区',
   IdCardNo             varchar(18) comment '身份证号码',
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   department           varchar(100) comment '系',
   major                varchar(100) comment '专业',
   majorField           varchar(100) comment '专业方向',
   majorCategories      varchar(100) comment '专业类别',
   cultivateDirection   varchar(100) comment '培育方向',
   className            varchar(100) comment '班级',
   educationSystem      int comment '学制',
   schoolingLength      int comment '学习年限',
   acceptanceDate       datetime comment '入学日期',
   middleSchool         varchar(100) comment '毕业中学',
   mobileNo             varchar(11) comment '本人电话',
   familyTelNo          varchar(20),
   postCode             varchar(6) comment '邮政编码',
   travelRange          varchar(50) comment '乘车区间',
   address              varchar(200) comment '家庭地址',
   skill                varchar(500) comment '特长',
   SelfDescription      varchar(500),
   awards               varchar(500) comment '所获奖励',
   schoolStatus         varchar(20) comment '学籍状态',
   DQSZJ                varchar(20),
   photoPath            varchar(200),
   graduateFlag         varchar(2) comment '毕业审核标志：
            Y：毕业审核通过
            N：审核不通过',
   alumniFlag           varchar(2) comment '导入校友会标志：预留字段
            Y：已导入
            N：未导入',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   password             varchar(50) comment '登录密码 （默认123456）',
   primary key (stu_id)
);

alter table t_students comment '学生信息表';

/*==============================================================*/
/* Table: t_subjectContest                                      */
/*==============================================================*/
create table t_subjectContest
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20) comment '获奖者姓名',
   academicYear         varchar(20) comment '学年',
   term                 varchar(20) comment '学期',
   rewardName           varchar(50) comment '奖励名称',
   rewardLevel          varchar(50) comment '获奖级别',
   rewardGrade          varchar(50) comment '获奖等级',
   grantUnits           varchar(100) comment '授予单位',
   rewardProject        varchar(100) comment '获奖项目',
   guidTeacher          varchar(20) comment '指导老师',
   rewardDate           datetime comment '获奖时间',
   memo                 varchar(200) comment '备注',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_subjectContest comment '学生学科竞赛获奖表';

/*==============================================================*/
/* Table: t_teacherInfo                                         */
/*==============================================================*/
create table t_teacherInfo
(
   id                   varchar(32) not null,
   employ_no            varchar(10) comment '教师工号',
   employ_name          varchar(64) comment '教师姓名',
   sex                  varchar(2) comment '性别',
   birthday             datetime comment '出生日期',
   org_id               varchar(32) comment '学院id',
   org_name             varchar(100) comment '学院名称',
   department           varchar(100) comment '系（科室）',
   TelNo                varchar(20) comment '联系电话',
   email                varchar(50) comment 'E_mail地址',
   address              varchar(200) comment '联系地址',
   category             varchar(20) comment '教职工类别',
   education            varchar(20) comment '学历',
   degree               varchar(20) comment '学位',
   duty                 varchar(20) comment '职务',
   acdemicTitle         varchar(20) comment '职称',
   invigilatorFlag      varchar(2) comment '可否监考：T：可以；F：不可以',
   researchDirection    varchar(100) comment '研究方向',
   summary              varchar(500) comment '教师简介',
   major                varchar(100) comment '专业',
   graduate             varchar(100) comment '毕业院校',
   qualificationFlag    varchar(2) comment '教师资格标志：Y:有；N：无',
   jobStatus            varchar(2) comment '在职状态：Y:在职；N：离职',
   level                varchar(20) comment '教师级别',
   isLab                varchar(2) comment '是否实验室人员：Y：是；N：否',
   isOutHire            varchar(2) comment '是否外聘',
   politicalStatus      varchar(20) comment '政治面貌',
   nation               varchar(50) comment '民族',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_teacherInfo comment '教师基本信息表';

/*==============================================================*/
/* Table: t_trainInfo_detail                                    */
/*==============================================================*/
create table t_trainInfo_detail
(
   id                   varchar(32) not null,
   stu_id               varchar(32) not null,
   studentNo            varchar(16) comment '学号',
   stuName              varchar(20),
   trainsResult         varchar(100) comment '培训结果',
   memo                 varchar(200),
   primary key (id)
);

alter table t_trainInfo_detail comment '学生培训情况明细表';

/*==============================================================*/
/* Table: t_trainInfo_master                                    */
/*==============================================================*/
create table t_trainInfo_master
(
   id                   varchar(32) not null,
   trainsDate           datetime comment '培训日期',
   trainsGrade          varchar(40) comment '培训对象年级',
   manager              varchar(20) comment '负责人',
   trainsTopic          varchar(200) comment '培训主题',
   trainsContent        varchar(500) comment '培训内容',
   trainsAddress        varchar(200) comment '培训地点',
   memo                 varchar(200) comment '备注',
   create_time          datetime comment '创建时间',
   creator              varchar(32) comment '创建者',
   primary key (id)
);

alter table t_trainInfo_master comment '学生培训情况主表';

/*==============================================================*/
/* Table: tb_sys_authority                                      */
/*==============================================================*/
create table tb_sys_authority
(
   authority_id         varchar(32) not null comment '权限ID',
   parent_id            varchar(32) comment '父级权限ID',
   parent_ids           varchar(1000) comment '所有父级权限ID',
   authority_name       varchar(64) not null comment '权限名称',
   authority_type       int not null comment '权限类型 0-菜单 1-新增 2-修改 3-查询 4-删除 5-导出 6-导入 7-授权',
   module_name          varchar(64) comment '模块名称',
   url                  varchar(200) comment '访问地址',
   operation            varchar(32) comment '操作',
   menu_no              varchar(32) comment '菜单排序号',
   memo                 varchar(200) comment '备注',
   primary key (authority_id)
);

/*==============================================================*/
/* Table: tb_sys_login_log                                      */
/*==============================================================*/
create table tb_sys_login_log
(
   logic_id             varchar(32) not null comment '逻辑ID',
   employ_no            varchar(32) comment '用户账号',
   login_time           datetime comment '登入时间',
   login_ip             varchar(100) comment '客户端IP',
   if_success           int comment '是否成功',
   primary key (logic_id)
);

/*==============================================================*/
/* Table: tb_sys_organization                                   */
/*==============================================================*/
create table tb_sys_organization
(
   org_id               varchar(32) not null comment '标识ID',
   org_name             varchar(128) comment '机构名称',
   parent_id            varchar(32) comment '父级机构ID',
   parent_ids           varchar(1000) comment '所有父级机构ID',
   address              varchar(128) comment '详细地址',
   post_code            varchar(16) comment '邮编',
   contact_man          varchar(32) comment '联系人（负责人）',
   tell                 varchar(16) comment '联系电话',
   fax                  varchar(16) comment '传真',
   email                varchar(32) comment 'Email',
   state                varchar(16) comment '0停用;1启用',
   primary key (org_id)
);

/*==============================================================*/
/* Table: tb_sys_role                                           */
/*==============================================================*/
create table tb_sys_role
(
   role_id              varchar(32) not null comment '主键ID',
   role_name            varchar(64) comment '角色名称',
   create_time          datetime comment '创建时间',
   role_no              varchar(32) comment '排序号',
   memo                 varchar(200) comment '备注',
   primary key (role_id)
);

/*==============================================================*/
/* Table: tb_sys_role_authority                                 */
/*==============================================================*/
create table tb_sys_role_authority
(
   id                   varchar(32) not null comment '主键标识',
   role_id              varchar(32) comment '主键ID',
   authority_id         varchar(32) comment '权限ID',
   primary key (id)
);

/*==============================================================*/
/* Table: tb_sys_user                                           */
/*==============================================================*/
create table tb_sys_user
(
   user_id              varchar(32) not null comment '标识ID',
   org_id               varchar(32) comment '标识ID',
   employ_no            varchar(10) comment '用户编号',
   employ_name          varchar(64) comment '用户名称',
   create_time          datetime comment '创建时间',
   sex                  int comment '性别 0-男 1-女',
   tell                 varchar(20) comment '联系电话',
   status               int comment '状态 0-启用 1-禁用',
   address              varchar(200) comment '联系地址',
   email                varchar(50) comment '电子邮箱',
   password             varchar(50) comment '密码',
   user_type            varchar(2) comment '用户类型',
   primary key (user_id)
);

/*==============================================================*/
/* Table: tb_sys_user_role                                      */
/*==============================================================*/
create table tb_sys_user_role
(
   id                   varchar(32) not null comment '主键标识ID',
   user_id              varchar(32) comment '标识ID',
   role_id              varchar(32) comment '主键ID',
   primary key (id)
);
drop table if exists t_system_dll;

/*==============================================================*/
/* Table: system_dll  数据字典                                                                                          */
/*==============================================================*/
create table t_system_dll
(
   seqID                varchar(32) not null,
   keyword              varchar(20),
   ddl_code             int,
   ddl_name             varchar(32),
   primary key (seqID)
);


alter table tb_sys_user_role comment '一个用户可以有多个角色';

alter table tb_sys_role_authority add constraint FK_Reference_3 foreign key (authority_id)
      references tb_sys_authority (authority_id) on delete restrict on update restrict;

alter table tb_sys_role_authority add constraint FK_Reference_4 foreign key (role_id)
      references tb_sys_role (role_id) on delete restrict on update restrict;

alter table tb_sys_user add constraint FK_Reference_7 foreign key (org_id)
      references tb_sys_organization (org_id) on delete restrict on update restrict;

alter table tb_sys_user_role add constraint FK_Reference_5 foreign key (role_id)
      references tb_sys_role (role_id) on delete restrict on update restrict;

alter table tb_sys_user_role add constraint FK_Reference_6 foreign key (user_id)
      references tb_sys_user (user_id) on delete restrict on update restrict;
