package com.migramcas.layaed.architecture.finsalud.config;

import com.migramcas.layaed.architecture.finsalud.jobs.JobUpdateUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Slf4j
@Configuration
public class QuartzConfiguration {

    @Value("${quartz.jobCron}")
    private String jobCron;

    @Value("${quartz.jobGroup}")
    private String jobGroup;

    @Bean
    CronTriggerFactoryBean jobTrigger() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(job().getObject());
        cronTriggerFactoryBean.setCronExpression(jobCron);
        cronTriggerFactoryBean.setGroup(jobGroup);
        return cronTriggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean job() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(JobUpdateUsers.class);
        jobDetailFactoryBean.setGroup(jobGroup);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

}
