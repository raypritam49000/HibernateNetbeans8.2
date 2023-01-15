package com.hibernate.model;

public class EmployeeStatistics {

    private Long totalEmp;
    private Double minSalary;
    private Double maxSalary;
    private Double avgSalary;
    private Double totalSalary;

    public EmployeeStatistics(Long totalEmp, Double maxSalary, Double minSalary, Double avgSalary, Double totalSalary) {
        this.totalEmp = totalEmp;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.avgSalary = avgSalary;
        this.totalSalary = totalSalary;
    }

    public EmployeeStatistics() {
    }

    public Long getTotalEmp() {
        return totalEmp;
    }

    public void setTotalEmp(Long totalEmp) {
        this.totalEmp = totalEmp;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

}
