package com.zhbit.entity;

import java.sql.Timestamp;


/**
 * TAttendanceMaster entity. @author MyEclipse Persistence Tools
 */

public class AttendanceMaster  implements java.io.Serializable {

    // Fields    

     /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private String id;
     private String term;
     private String coursename;
     private String selectedcourseno;
     private String employNo;
     private String employName;
     private String academicyear;
     private String orgId;
     private String orgName;
     private String schooltime;
     private String address;
     private String sourceFile;
     private String memo;
     private Timestamp createTime;
     private String creator;
     private String parentOrgId;


    // Constructors

    /** default constructor */
    public AttendanceMaster() {
    }

    
    /** full constructor */
    public AttendanceMaster(String term, String coursename, String selectedcourseno, String employNo, String employName, String academicyear, String orgId, String orgName, String schooltime, String address, String sourceFile, String memo, Timestamp createTime, String creator, String parentOrgId) {
        this.term = term;
        this.coursename = coursename;
        this.selectedcourseno = selectedcourseno;
        this.employNo = employNo;
        this.employName = employName;
        this.academicyear = academicyear;
        this.orgId = orgId;
        this.orgName = orgName;
        this.schooltime = schooltime;
        this.address = address;
        this.sourceFile = sourceFile;
        this.memo = memo;
        this.createTime = createTime;
        this.creator = creator;
        this.parentOrgId = parentOrgId;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return this.term;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }

    public String getCoursename() {
        return this.coursename;
    }
    
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSelectedcourseno() {
        return this.selectedcourseno;
    }
    
    public void setSelectedcourseno(String selectedcourseno) {
        this.selectedcourseno = selectedcourseno;
    }

    public String getEmployNo() {
        return this.employNo;
    }
    
    public void setEmployNo(String employNo) {
        this.employNo = employNo;
    }

    public String getEmployName() {
        return this.employName;
    }
    
    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public String getAcademicyear() {
        return this.academicyear;
    }
    
    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSchooltime() {
        return this.schooltime;
    }
    
    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceFile() {
        return this.sourceFile;
    }
    
    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getParentOrgId() {
        return this.parentOrgId;
    }
    
    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
   








}