package com.springBoot.entity;

/**
 * 商业证书实体类
 */
public class CertificateVo {

    // 建表数
    private String tableCount;
    // 功能数
    private String funcCount;
    // 可用工作流数
    private String flowCount;
    // 使用用户数
    private String userCount;
    //机器数
    private String machineCount;

    //顶部显示字
    private String topWord;
    //顶部链接
    private String toplink;
    // 数据加载字样
    private String dataWord;
    // 公司信息字样
    private String companyInfo;

    public String getTableCount() {
        return tableCount;
    }

    public void setTableCount(String tableCount) {
        this.tableCount = tableCount;
    }

    public String getFuncCount() {
        return funcCount;
    }

    public void setFuncCount(String funcCount) {
        this.funcCount = funcCount;
    }

    public String getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(String flowCount) {
        this.flowCount = flowCount;
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public String getMachineCount() {
        return machineCount;
    }

    public void setMachineCount(String machineCount) {
        this.machineCount = machineCount;
    }

    public String getTopWord() {
        return topWord;
    }

    public void setTopWord(String topWord) {
        this.topWord = topWord;
    }

    public String getToplink() {
        return toplink;
    }

    public void setToplink(String toplink) {
        this.toplink = toplink;
    }

    public String getDataWord() {
        return dataWord;
    }

    public void setDataWord(String dataWord) {
        this.dataWord = dataWord;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }
}
