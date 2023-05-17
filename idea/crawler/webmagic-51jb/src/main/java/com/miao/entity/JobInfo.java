package com.miao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "job_info")
@Data
public class JobInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_addr")
    private String companyAddr;

    @Column(name = "company_info")
    private String companyInfo;
    @Column(name = "salary_min")
    private int salaryMin;
    @Column(name = "salary_max")
    private int salaryMax;
    @Column(name = "url")
    private String url;

    @Column(name = "time")
    private String time;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_addr")
    private String jobAddr;

    @Column(name = "job_info")
    private String jobInfo;
}
