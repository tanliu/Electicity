package com.zhbit.entity;
// default package

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TEnrolltransaction entity. @author MyEclipse Persistence Tools
 */

public class StuStatus implements java.io.Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	@Transform(name="异动序号")
	private String transactionNo;//异动序号
	private String stuId;
	@Transform(name="学号")
	private String studentNo;//学号
	@Transform(name="姓名")
	private String stuName;//姓名
	@Transform(name="性别")
	private String sex;//性别
	@Transform(name="学年")
	private String academicYear;//学年
	@Transform(name="学期")
	private String term;//学期
	@Transform(name="异动后行政班")
	private String tansactionClass;//异动后行政班
	@Transform(name="处理文号")
	private String processSymbols;//处理文号
	@Transform(name="异动类别")
	private String tansactionType;//异动类型
	@Transform(name="异动原因")
	private String tansactionReason;//异动原因
	@Transform(name="异动时间")
	private Timestamp tansactionDate;//异动时间
	@Transform(name="行文时间")
	private Timestamp handleDate;//行文时间
	@Transform(name="撤消时间")
	private Timestamp cancelDate;//撤消时间
	@Transform(name="异动说明")
	private String tansactionMemo;
	@Transform(name="转学前学校名称")
	private String zxqschool;//转学前学校名称
	@Transform(name="转学前所在年级")
	private String zxqgrade;//转学前所在年级
	@Transform(name="转学前专业")
	private String zxqmajor;//转学前专业
	@Transform(name="异动前学院")
	private String ydqcollege;//异动前学院
	@Transform(name="异动前系")
	private String ydqdepartment;//异动前系
	@Transform(name="异动前专业")
	private String ydqmajor;//异动前专业
	@Transform(name="异动前学制")
	private String ydqlength;//异动前学制
	@Transform(name="异动前专业方向")
	private String ydqmajorField;//异动前专业方向
	@Transform(name="异动前培养方向")
	private String ydqcultivateDirection;//异动前培养方向
	@Transform(name="异动前所在年级")
	private String ydqgrade;//异动前所在年级
	@Transform(name="异动前行政班")
	private String ydqclassName;//异动前行政班
	@Transform(name="异动前学籍状态")
	private String ydqschoolStatus;//异动前学籍状态
	@Transform(name="转出后学校名称")
	private String zchschool;//转出后学校名称
	@Transform(name="转出后年级")
	private String zchgrade;//转出后年级
	@Transform(name="转出后专业")
	private String zchmajor;//转出后专业
	@Transform(name="异动后学院")
	private String ydhcollege;//异动后学院
	@Transform(name="异动后系")
	private String ydhdepartment;//异动后系
	@Transform(name="异动后专业")
	private String ydhmajor;//异动后专业
	@Transform(name="异动后学制")
	private String ydhlength;//异动后学制
	@Transform(name="异动后专业方向")
	private String ydhmajorField;//异动后专业方向
	@Transform(name="异动后培养方向")
	private String ydhcultivatedirection;//异动后培养方向
	@Transform(name="异动后所在年级")
	private String ydhgrade;//异动后所在年级
	@Transform(name="异动后所在班级")
	private String ydhclassName;//异动后所在班级
	@Transform(name="异动后学籍状态")
	private String ydhschoolStatus;//异动后学籍状态
	@Transform(name="操作人")
	private String operator;//操作人
	@Transform(name="操作日期")
	private Timestamp operatorTime;//操作日期
	@Transform(name="异动前是否在校")
	private String ydqinSchool;//异动前是否在校
	@Transform(name="异动后是否在校")
	private String ydhinSchool;//异动后是否在校
	@Transform(name="异动前专业代码")
	private String ydqmajorCode;//异动前专业代码
	@Transform(name="异动后专业代码")
	private String ydhmajorCode;//异动后专业代码
	@Transform(name="异动前是否注册")
	private String ydqisRegiste;//异动前是否注册
	@Transform(name="异动后是否注册")
	private String ydhisRegiste;//异动后是否注册
	@Transform(name="/备注")
	private String memo;//备注
	@Transform(name="异动前学历层次")
	private String ydqeducation;//异动前学历层次
	@Transform(name="异动后学历层次")
	private String ydheducation;//异动后学历层次
	@Transform(name="异动前专业类别")
	private String ydqmajorCategory;//异动前专业类别
	@Transform(name="异动后专业类别")
	private String ydhmajorCategory;//异动后专业类别
	@Transform(name="异动结果")
	private String ydresult;//异动结果
	@Transform(name="学生类别")
	private String studentCategory;//学生类别
	@Transform(name="考生号")
	private String examinateNo;//考生号
	@Transform(name="身份证号")
	private String idCardNo;//身份证号码
	private Timestamp createTime;//创建时间
	private String creator;//创建者

	
	
	
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	// Constructors
	/** default constructor */
	public StuStatus() {
	}

	/** minimal constructor */
	public StuStatus(String stuId, Timestamp operatorTime) {
		this.stuId = stuId;
		this.operatorTime = operatorTime;
	}

	/** full constructor */
	public StuStatus(String transactionNo, String stuId,
			String studentNo, String stuName, String sex, String academicYear,
			String term, String tansactionClass, String processSymbols,
			String tansactionType, String tansactionReason,
			Timestamp tansactionDate, Timestamp handleDate,
			Timestamp cancelDate, String tansactionMemo, String zxqschool,
			String zxqgrade, String zxqmajor, String ydqcollege,
			String ydqdepartment, String ydqmajor, String ydqlength,
			String ydqmajorField, String ydqcultivateDirection,
			String ydqgrade, String ydqclassName, String ydqschoolStatus,
			String zchschool, String zchgrade, String zchmajor,
			String ydhcollege, String ydhdepartment, String ydhmajor,
			String ydhlength, String ydhmajorField,
			String ydhcultivatedirection, String ydhgrade, String ydhclassName,
			String ydhschoolStatus, String operator, Timestamp operatorTime,
			String ydqinSchool, String ydhinSchool, String ydqmajorCode,
			String ydhmajorCode, String ydqisRegiste, String ydhisRegiste,
			String memo, String ydqeducation, String ydheducation,
			String ydqmajorCategory, String ydhmajorCategory, String ydresult,
			String studentCategory, String examinateNo, String idCardNo,
			Timestamp createTime, String creator) {
		this.transactionNo = transactionNo;
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.academicYear = academicYear;
		this.term = term;
		this.tansactionClass = tansactionClass;
		this.processSymbols = processSymbols;
		this.tansactionType = tansactionType;
		this.tansactionReason = tansactionReason;
		this.tansactionDate = tansactionDate;
		this.handleDate = handleDate;
		this.cancelDate = cancelDate;
		this.tansactionMemo = tansactionMemo;
		this.zxqschool = zxqschool;
		this.zxqgrade = zxqgrade;
		this.zxqmajor = zxqmajor;
		this.ydqcollege = ydqcollege;
		this.ydqdepartment = ydqdepartment;
		this.ydqmajor = ydqmajor;
		this.ydqlength = ydqlength;
		this.ydqmajorField = ydqmajorField;
		this.ydqcultivateDirection = ydqcultivateDirection;
		this.ydqgrade = ydqgrade;
		this.ydqclassName = ydqclassName;
		this.ydqschoolStatus = ydqschoolStatus;
		this.zchschool = zchschool;
		this.zchgrade = zchgrade;
		this.zchmajor = zchmajor;
		this.ydhcollege = ydhcollege;
		this.ydhdepartment = ydhdepartment;
		this.ydhmajor = ydhmajor;
		this.ydhlength = ydhlength;
		this.ydhmajorField = ydhmajorField;
		this.ydhcultivatedirection = ydhcultivatedirection;
		this.ydhgrade = ydhgrade;
		this.ydhclassName = ydhclassName;
		this.ydhschoolStatus = ydhschoolStatus;
		this.operator = operator;
		this.operatorTime = operatorTime;
		this.ydqinSchool = ydqinSchool;
		this.ydhinSchool = ydhinSchool;
		this.ydqmajorCode = ydqmajorCode;
		this.ydhmajorCode = ydhmajorCode;
		this.ydqisRegiste = ydqisRegiste;
		this.ydhisRegiste = ydhisRegiste;
		this.memo = memo;
		this.ydqeducation = ydqeducation;
		this.ydheducation = ydheducation;
		this.ydqmajorCategory = ydqmajorCategory;
		this.ydhmajorCategory = ydhmajorCategory;
		this.ydresult = ydresult;
		this.studentCategory = studentCategory;
		this.examinateNo = examinateNo;
		this.idCardNo = idCardNo;
		this.createTime = createTime;
		this.creator = creator;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransactionNo() {
		return this.transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTansactionClass() {
		return this.tansactionClass;
	}

	public void setTansactionClass(String tansactionClass) {
		this.tansactionClass = tansactionClass;
	}

	public String getProcessSymbols() {
		return this.processSymbols;
	}

	public void setProcessSymbols(String processSymbols) {
		this.processSymbols = processSymbols;
	}

	public String getTansactionType() {
		return this.tansactionType;
	}

	public void setTansactionType(String tansactionType) {
		this.tansactionType = tansactionType;
	}

	public String getTansactionReason() {
		return this.tansactionReason;
	}

	public void setTansactionReason(String tansactionReason) {
		this.tansactionReason = tansactionReason;
	}

	public Timestamp getTansactionDate() {
		return this.tansactionDate;
	}

	public void setTansactionDate(Timestamp tansactionDate) {
		this.tansactionDate = tansactionDate;
	}

	public Timestamp getHandleDate() {
		return this.handleDate;
	}

	public void setHandleDate(Timestamp handleDate) {
		this.handleDate = handleDate;
	}

	public Timestamp getCancelDate() {
		return this.cancelDate;
	}

	public void setCancelDate(Timestamp cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getTansactionMemo() {
		return this.tansactionMemo;
	}

	public void setTansactionMemo(String tansactionMemo) {
		this.tansactionMemo = tansactionMemo;
	}

	public String getZxqschool() {
		return this.zxqschool;
	}

	public void setZxqschool(String zxqschool) {
		this.zxqschool = zxqschool;
	}

	public String getZxqgrade() {
		return this.zxqgrade;
	}

	public void setZxqgrade(String zxqgrade) {
		this.zxqgrade = zxqgrade;
	}

	public String getZxqmajor() {
		return this.zxqmajor;
	}

	public void setZxqmajor(String zxqmajor) {
		this.zxqmajor = zxqmajor;
	}

	public String getYdqcollege() {
		return this.ydqcollege;
	}

	public void setYdqcollege(String ydqcollege) {
		this.ydqcollege = ydqcollege;
	}

	public String getYdqdepartment() {
		return this.ydqdepartment;
	}

	public void setYdqdepartment(String ydqdepartment) {
		this.ydqdepartment = ydqdepartment;
	}

	public String getYdqmajor() {
		return this.ydqmajor;
	}

	public void setYdqmajor(String ydqmajor) {
		this.ydqmajor = ydqmajor;
	}

	public String getYdqlength() {
		return this.ydqlength;
	}

	public void setYdqlength(String ydqlength) {
		this.ydqlength = ydqlength;
	}

	public String getYdqmajorField() {
		return this.ydqmajorField;
	}

	public void setYdqmajorField(String ydqmajorField) {
		this.ydqmajorField = ydqmajorField;
	}

	public String getYdqcultivateDirection() {
		return this.ydqcultivateDirection;
	}

	public void setYdqcultivateDirection(String ydqcultivateDirection) {
		this.ydqcultivateDirection = ydqcultivateDirection;
	}

	public String getYdqgrade() {
		return this.ydqgrade;
	}

	public void setYdqgrade(String ydqgrade) {
		this.ydqgrade = ydqgrade;
	}

	public String getYdqclassName() {
		return this.ydqclassName;
	}

	public void setYdqclassName(String ydqclassName) {
		this.ydqclassName = ydqclassName;
	}

	public String getYdqschoolStatus() {
		return this.ydqschoolStatus;
	}

	public void setYdqschoolStatus(String ydqschoolStatus) {
		this.ydqschoolStatus = ydqschoolStatus;
	}

	public String getZchschool() {
		return this.zchschool;
	}

	public void setZchschool(String zchschool) {
		this.zchschool = zchschool;
	}

	public String getZchgrade() {
		return this.zchgrade;
	}

	public void setZchgrade(String zchgrade) {
		this.zchgrade = zchgrade;
	}

	public String getZchmajor() {
		return this.zchmajor;
	}

	public void setZchmajor(String zchmajor) {
		this.zchmajor = zchmajor;
	}

	public String getYdhcollege() {
		return this.ydhcollege;
	}

	public void setYdhcollege(String ydhcollege) {
		this.ydhcollege = ydhcollege;
	}

	public String getYdhdepartment() {
		return this.ydhdepartment;
	}

	public void setYdhdepartment(String ydhdepartment) {
		this.ydhdepartment = ydhdepartment;
	}

	public String getYdhmajor() {
		return this.ydhmajor;
	}

	public void setYdhmajor(String ydhmajor) {
		this.ydhmajor = ydhmajor;
	}

	public String getYdhlength() {
		return this.ydhlength;
	}

	public void setYdhlength(String ydhlength) {
		this.ydhlength = ydhlength;
	}

	public String getYdhmajorField() {
		return this.ydhmajorField;
	}

	public void setYdhmajorField(String ydhmajorField) {
		this.ydhmajorField = ydhmajorField;
	}

	public String getYdhcultivatedirection() {
		return this.ydhcultivatedirection;
	}

	public void setYdhcultivatedirection(String ydhcultivatedirection) {
		this.ydhcultivatedirection = ydhcultivatedirection;
	}

	public String getYdhgrade() {
		return this.ydhgrade;
	}

	public void setYdhgrade(String ydhgrade) {
		this.ydhgrade = ydhgrade;
	}

	public String getYdhclassName() {
		return this.ydhclassName;
	}

	public void setYdhclassName(String ydhclassName) {
		this.ydhclassName = ydhclassName;
	}

	public String getYdhschoolStatus() {
		return this.ydhschoolStatus;
	}

	public void setYdhschoolStatus(String ydhschoolStatus) {
		this.ydhschoolStatus = ydhschoolStatus;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Timestamp getOperatorTime() {
		return this.operatorTime;
	}

	public void setOperatorTime(Timestamp operatorTime) {
		this.operatorTime = operatorTime;
	}

	public String getYdqinSchool() {
		return this.ydqinSchool;
	}

	public void setYdqinSchool(String ydqinSchool) {
		this.ydqinSchool = ydqinSchool;
	}

	public String getYdhinSchool() {
		return this.ydhinSchool;
	}

	public void setYdhinSchool(String ydhinSchool) {
		this.ydhinSchool = ydhinSchool;
	}

	public String getYdqmajorCode() {
		return this.ydqmajorCode;
	}

	public void setYdqmajorCode(String ydqmajorCode) {
		this.ydqmajorCode = ydqmajorCode;
	}

	public String getYdhmajorCode() {
		return this.ydhmajorCode;
	}

	public void setYdhmajorCode(String ydhmajorCode) {
		this.ydhmajorCode = ydhmajorCode;
	}

	public String getYdqisRegiste() {
		return this.ydqisRegiste;
	}

	public void setYdqisRegiste(String ydqisRegiste) {
		this.ydqisRegiste = ydqisRegiste;
	}

	public String getYdhisRegiste() {
		return this.ydhisRegiste;
	}

	public void setYdhisRegiste(String ydhisRegiste) {
		this.ydhisRegiste = ydhisRegiste;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getYdqeducation() {
		return this.ydqeducation;
	}

	public void setYdqeducation(String ydqeducation) {
		this.ydqeducation = ydqeducation;
	}

	public String getYdheducation() {
		return this.ydheducation;
	}

	public void setYdheducation(String ydheducation) {
		this.ydheducation = ydheducation;
	}

	public String getYdqmajorCategory() {
		return this.ydqmajorCategory;
	}

	public void setYdqmajorCategory(String ydqmajorCategory) {
		this.ydqmajorCategory = ydqmajorCategory;
	}

	public String getYdhmajorCategory() {
		return this.ydhmajorCategory;
	}

	public void setYdhmajorCategory(String ydhmajorCategory) {
		this.ydhmajorCategory = ydhmajorCategory;
	}

	public String getYdresult() {
		return this.ydresult;
	}

	public void setYdresult(String ydresult) {
		this.ydresult = ydresult;
	}

	public String getStudentCategory() {
		return this.studentCategory;
	}

	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}

	public String getExaminateNo() {
		return this.examinateNo;
	}

	public void setExaminateNo(String examinateNo) {
		this.examinateNo = examinateNo;
	}

	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}