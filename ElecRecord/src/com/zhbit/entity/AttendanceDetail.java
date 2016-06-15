package com.zhbit.entity;

import java.sql.Timestamp;


/**
 * TAttendanceDetail entity. @author MyEclipse Persistence Tools
 */

public class AttendanceDetail  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
     private String selectedcourseno;
     private String stuId;
     private String studentno;
     private String stuname;
     private String sex;
     private String classname;
     private String attendanceStatus;
     private Timestamp attendanceTime;
     private Timestamp createTime;
     private String creator;
     private String parentOrgId;


    // Constructors

    /** default constructor */
    public AttendanceDetail() {
    }

	/** minimal constructor */
    public AttendanceDetail(String stuId, String studentno) {
        this.stuId = stuId;
        this.studentno = studentno;
    }
    
    /** full constructor */
    public AttendanceDetail(String selectedcourseno, String stuId, String studentno, String stuname, String sex, String classname, String attendanceStatus, Timestamp attendanceTime, Timestamp createTime, String creator, String parentOrgId) {
        this.selectedcourseno = selectedcourseno;
        this.stuId = stuId;
        this.studentno = studentno;
        this.stuname = stuname;
        this.sex = sex;
        this.classname = classname;
        this.attendanceStatus = attendanceStatus;
        this.attendanceTime = attendanceTime;
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

    public String getSelectedcourseno() {
        return this.selectedcourseno;
    }
    
    public void setSelectedcourseno(String selectedcourseno) {
        this.selectedcourseno = selectedcourseno;
    }

    public String getStuId() {
        return this.stuId;
    }
    
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStudentno() {
        return this.studentno;
    }
    
    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getStuname() {
        return this.stuname;
    }
    
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassname() {
        return this.classname;
    }
    
    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getAttendanceStatus() {
        return this.attendanceStatus;
    }
    
    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Timestamp getAttendanceTime() {
        return this.attendanceTime;
    }
    
    public void setAttendanceTime(Timestamp attendanceTime) {
        this.attendanceTime = attendanceTime;
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