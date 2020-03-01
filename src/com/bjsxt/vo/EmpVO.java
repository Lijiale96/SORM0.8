package com.bjsxt.vo;

public class EmpVO {
//    SELECT
//    e.id,
//    e.empname,
//    salary + bonus 'xinshui',
//    age,
//    d.dname 'deptName',d.address 'deptAddr'
//    FROM
//    emp e；
//    JOIN dept d ON e.deptId = d.id;

    private Integer id;
    private String empname;
    private String deptName;
    private String deptAddr;
    private Double xinshui;
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public Double getXinshui() {
        return xinshui;
    }

    public void setXinshui(Double xinshui) {
        this.xinshui = xinshui;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmpVO(Integer id, String empname, String deptName, String deptAddr, Double xinshui, Integer age) {
        this.id = id;
        this.empname = empname;
        this.deptName = deptName;
        this.deptAddr = deptAddr;
        this.xinshui = xinshui;
        this.age = age;
    }

    public EmpVO(){

    }
}
