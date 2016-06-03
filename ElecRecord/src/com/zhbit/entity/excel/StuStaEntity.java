package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

/** 
 * 项目名称：ElecRecord
 * 类名称： StuStaEntity
 * 类描述：此类为StuStatus类对应的Excel实体对象类
 * 创建人：罗建鑫
 * 创建时间：2016年6月3日 上午1:49:48
 * 修改人：罗建鑫
 * 修改时间：2016年6月3日 上午1:49:48
 * 修改备注： 
 * @version 
 */ 
@ExcelVoConfig
public class StuStaEntity extends BaseExcelVo {

	@Lang(value="异动序号")
	private String transactionNo;
	@Lang(value="异动后行政班")
	private String tansactionClass;
	@Lang(value="学号")
	private String studentNo;
	@Lang(value="姓名")
	private String stuName;
	@Lang(value="性别")
	private String sex;
	@Lang(value="处理文号")
	private String processSymbols;
	@Lang(value="异动类别")
	private String tansactionType;
	@Lang(value="异动原因")
	private String tansactionReason;
	@Lang(value="异动时间")
	private String tansactionDate;
	@Lang(value="行文时间")
	private String handleDate;
	@Lang(value="撤消时间")
	private String cancelDate;
	@Lang(value="异动说明")
	private String tansactionMemo;
	@Lang(value="转学前学校名称")
	private String zxqschool;
	@Lang(value="转学前所在年级")
	private String zxqgrade;
	@Lang(value="转学前专业")
	private String zxqmajor;
	@Lang(value="异动前学院")
	private String ydqcollege;
	@Lang(value="异动前系")
	private String ydqdepartment;
	@Lang(value="异动前专业")
	private String ydqmajor;
	@Lang(value="异动前学制")
	private String ydqlength;
	@Lang(value="异动前专业方向")
	private String ydqmajorField;
	@Lang(value="异动前培养方向")
	private String ydqcultivateDirection;
	@Lang(value="异动前行政班")
	private String ydqclassName;
	@Lang(value="异动前学籍状态")
	private String ydqschoolStatus;
	@Lang(value="转出后学校名称")
	private String zchschool;
	@Lang(value="转出后年级")
	private String zchgrade;
	@Lang(value="转出后专业")
	private String zchmajor;
	@Lang(value="异动后学院")
	private String ydhcollege;
	@Lang(value="异动后系")
	private String ydhdepartment;
	@Lang(value="异动后专业")
	private String ydhmajor;
	@Lang(value="异动后学制")
	private String ydhlength;
	@Lang(value="异动后专业方向")
	private String ydhmajorField;
	@Lang(value="异动后培养方向")
	private String ydhcultivatedirection;
	@Lang(value="异动后学籍状态")
	private String ydhschoolStatus;
	@Lang(value="异动前所在年级")
	private String ydqgrade;
	@Lang(value="异动后所在年级")
	private String ydhgrade;
	@Lang(value="学年")
	private String academicYear;
	@Lang(value="学期")
	private String term;
	@Lang(value="操作人")
	private String operator;
	@Lang(value="操作日期")
	private String operatorTime;
	@Lang(value="异动前是否在校")
	private String ydqinSchool;
	@Lang(value="异动后是否在校")
	private String ydhinSchool;
	@Lang(value="异动前专业代码")
	private String ydqmajorCode;
	@Lang(value="异动后专业代码")
	private String ydhmajorCode;
	@Lang(value="异动前是否注册")
	private String ydqisRegiste;
	@Lang(value="异动后是否注册")
	private String ydhisRegiste;
	@Lang(value="备注")
	private String memo;
	@Lang(value="异动前学历层次")
	private String ydqeducation;
	@Lang(value="异动后学历层次")
	private String ydheducation;
	@Lang(value="异动前专业类别")
	private String ydqmajorCategory;
	@Lang(value="异动后专业类别")
	private String ydhmajorCategory;
	@Lang(value="异动结果")
	private String ydresult;
	@Lang(value="学生类别")
	private String studentCategory;
	@Lang(value="考生号")
	private String examinateNo;
	@Lang(value="身份证号")
	private String idCardNo;
	
	
	public StuStaEntity() {
		
	}


	public StuStaEntity(String transactionNo, String tansactionClass, String studentNo, String stuName, String sex,
			String processSymbols, String tansactionType, String tansactionReason, String tansactionDate,
			String handleDate, String cancelDate, String tansactionMemo, String zxqschool, String zxqgrade,
			String zxqmajor, String ydqcollege, String ydqdepartment, String ydqmajor, String ydqlength,
			String ydqmajorField, String ydqcultivateDirection, String ydqclassName, String ydqschoolStatus,
			String zchschool, String zchgrade, String zchmajor, String ydhcollege, String ydhdepartment,
			String ydhmajor, String ydhlength, String ydhmajorField, String ydhcultivatedirection,
			String ydhschoolStatus, String ydqgrade, String ydhgrade, String academicYear, String term, String operator,
			String operatorTime, String ydqinSchool, String ydhinSchool, String ydqmajorCode, String ydhmajorCode,
			String ydqisRegiste, String ydhisRegiste, String memo, String ydqeducation, String ydheducation,
			String ydqmajorCategory, String ydhmajorCategory, String ydresult, String studentCategory,
			String examinateNo, String idCardNo) {
		super();
		this.transactionNo = transactionNo;
		this.tansactionClass = tansactionClass;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
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
		this.ydhschoolStatus = ydhschoolStatus;
		this.ydqgrade = ydqgrade;
		this.ydhgrade = ydhgrade;
		this.academicYear = academicYear;
		this.term = term;
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
	}


	public String getTransactionNo() {
		return transactionNo;
	}


	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}


	public String getTansactionClass() {
		return tansactionClass;
	}


	public void setTansactionClass(String tansactionClass) {
		this.tansactionClass = tansactionClass;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getProcessSymbols() {
		return processSymbols;
	}


	public void setProcessSymbols(String processSymbols) {
		this.processSymbols = processSymbols;
	}


	public String getTansactionType() {
		return tansactionType;
	}


	public void setTansactionType(String tansactionType) {
		this.tansactionType = tansactionType;
	}


	public String getTansactionReason() {
		return tansactionReason;
	}


	public void setTansactionReason(String tansactionReason) {
		this.tansactionReason = tansactionReason;
	}


	public String getTansactionDate() {
		return tansactionDate;
	}


	public void setTansactionDate(String tansactionDate) {
		this.tansactionDate = tansactionDate;
	}


	public String getHandleDate() {
		return handleDate;
	}


	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}


	public String getCancelDate() {
		return cancelDate;
	}


	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}


	public String getTansactionMemo() {
		return tansactionMemo;
	}


	public void setTansactionMemo(String tansactionMemo) {
		this.tansactionMemo = tansactionMemo;
	}


	public String getZxqschool() {
		return zxqschool;
	}


	public void setZxqschool(String zxqschool) {
		this.zxqschool = zxqschool;
	}


	public String getZxqgrade() {
		return zxqgrade;
	}


	public void setZxqgrade(String zxqgrade) {
		this.zxqgrade = zxqgrade;
	}


	public String getZxqmajor() {
		return zxqmajor;
	}


	public void setZxqmajor(String zxqmajor) {
		this.zxqmajor = zxqmajor;
	}


	public String getYdqcollege() {
		return ydqcollege;
	}


	public void setYdqcollege(String ydqcollege) {
		this.ydqcollege = ydqcollege;
	}


	public String getYdqdepartment() {
		return ydqdepartment;
	}


	public void setYdqdepartment(String ydqdepartment) {
		this.ydqdepartment = ydqdepartment;
	}


	public String getYdqmajor() {
		return ydqmajor;
	}


	public void setYdqmajor(String ydqmajor) {
		this.ydqmajor = ydqmajor;
	}


	public String getYdqlength() {
		return ydqlength;
	}


	public void setYdqlength(String ydqlength) {
		this.ydqlength = ydqlength;
	}


	public String getYdqmajorField() {
		return ydqmajorField;
	}


	public void setYdqmajorField(String ydqmajorField) {
		this.ydqmajorField = ydqmajorField;
	}


	public String getYdqcultivateDirection() {
		return ydqcultivateDirection;
	}


	public void setYdqcultivateDirection(String ydqcultivateDirection) {
		this.ydqcultivateDirection = ydqcultivateDirection;
	}


	public String getYdqclassName() {
		return ydqclassName;
	}


	public void setYdqclassName(String ydqclassName) {
		this.ydqclassName = ydqclassName;
	}


	public String getYdqschoolStatus() {
		return ydqschoolStatus;
	}


	public void setYdqschoolStatus(String ydqschoolStatus) {
		this.ydqschoolStatus = ydqschoolStatus;
	}


	public String getZchschool() {
		return zchschool;
	}


	public void setZchschool(String zchschool) {
		this.zchschool = zchschool;
	}


	public String getZchgrade() {
		return zchgrade;
	}


	public void setZchgrade(String zchgrade) {
		this.zchgrade = zchgrade;
	}


	public String getZchmajor() {
		return zchmajor;
	}


	public void setZchmajor(String zchmajor) {
		this.zchmajor = zchmajor;
	}


	public String getYdhcollege() {
		return ydhcollege;
	}


	public void setYdhcollege(String ydhcollege) {
		this.ydhcollege = ydhcollege;
	}


	public String getYdhdepartment() {
		return ydhdepartment;
	}


	public void setYdhdepartment(String ydhdepartment) {
		this.ydhdepartment = ydhdepartment;
	}


	public String getYdhmajor() {
		return ydhmajor;
	}


	public void setYdhmajor(String ydhmajor) {
		this.ydhmajor = ydhmajor;
	}


	public String getYdhlength() {
		return ydhlength;
	}


	public void setYdhlength(String ydhlength) {
		this.ydhlength = ydhlength;
	}


	public String getYdhmajorField() {
		return ydhmajorField;
	}


	public void setYdhmajorField(String ydhmajorField) {
		this.ydhmajorField = ydhmajorField;
	}


	public String getYdhcultivatedirection() {
		return ydhcultivatedirection;
	}


	public void setYdhcultivatedirection(String ydhcultivatedirection) {
		this.ydhcultivatedirection = ydhcultivatedirection;
	}


	public String getYdhschoolStatus() {
		return ydhschoolStatus;
	}


	public void setYdhschoolStatus(String ydhschoolStatus) {
		this.ydhschoolStatus = ydhschoolStatus;
	}


	public String getYdqgrade() {
		return ydqgrade;
	}


	public void setYdqgrade(String ydqgrade) {
		this.ydqgrade = ydqgrade;
	}


	public String getYdhgrade() {
		return ydhgrade;
	}


	public void setYdhgrade(String ydhgrade) {
		this.ydhgrade = ydhgrade;
	}


	public String getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public String getOperatorTime() {
		return operatorTime;
	}


	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}


	public String getYdqinSchool() {
		return ydqinSchool;
	}


	public void setYdqinSchool(String ydqinSchool) {
		this.ydqinSchool = ydqinSchool;
	}


	public String getYdhinSchool() {
		return ydhinSchool;
	}


	public void setYdhinSchool(String ydhinSchool) {
		this.ydhinSchool = ydhinSchool;
	}


	public String getYdqmajorCode() {
		return ydqmajorCode;
	}


	public void setYdqmajorCode(String ydqmajorCode) {
		this.ydqmajorCode = ydqmajorCode;
	}


	public String getYdhmajorCode() {
		return ydhmajorCode;
	}


	public void setYdhmajorCode(String ydhmajorCode) {
		this.ydhmajorCode = ydhmajorCode;
	}


	public String getYdqisRegiste() {
		return ydqisRegiste;
	}


	public void setYdqisRegiste(String ydqisRegiste) {
		this.ydqisRegiste = ydqisRegiste;
	}


	public String getYdhisRegiste() {
		return ydhisRegiste;
	}


	public void setYdhisRegiste(String ydhisRegiste) {
		this.ydhisRegiste = ydhisRegiste;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getYdqeducation() {
		return ydqeducation;
	}


	public void setYdqeducation(String ydqeducation) {
		this.ydqeducation = ydqeducation;
	}


	public String getYdheducation() {
		return ydheducation;
	}


	public void setYdheducation(String ydheducation) {
		this.ydheducation = ydheducation;
	}


	public String getYdqmajorCategory() {
		return ydqmajorCategory;
	}


	public void setYdqmajorCategory(String ydqmajorCategory) {
		this.ydqmajorCategory = ydqmajorCategory;
	}


	public String getYdhmajorCategory() {
		return ydhmajorCategory;
	}


	public void setYdhmajorCategory(String ydhmajorCategory) {
		this.ydhmajorCategory = ydhmajorCategory;
	}


	public String getYdresult() {
		return ydresult;
	}


	public void setYdresult(String ydresult) {
		this.ydresult = ydresult;
	}


	public String getStudentCategory() {
		return studentCategory;
	}


	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}


	public String getExaminateNo() {
		return examinateNo;
	}


	public void setExaminateNo(String examinateNo) {
		this.examinateNo = examinateNo;
	}


	public String getIdCardNo() {
		return idCardNo;
	}


	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}


	@Override
	public int getHashVal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
