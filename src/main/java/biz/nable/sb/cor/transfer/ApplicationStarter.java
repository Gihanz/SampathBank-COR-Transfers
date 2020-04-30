/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */
package biz.nable.sb.cor.transfer;

import biz.nable.sb.cor.transfer.bean.RetrieveFinacleBean;
import biz.nable.sb.cor.transfer.soap.schemas.IIBRequestComponent;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryRequestType;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryResponseType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/*
 **
 */
@ComponentScan(basePackages = {"biz.nable.sb.cor"})
@SpringBootApplication
@EntityScan(basePackages = {"biz.nable.sb.cor"})
@EnableJpaRepositories(basePackages = {"biz.nable.sb.cor"})
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableConfigurationProperties(RetrieveFinacleBean.class)
public class ApplicationStarter extends SpringBootServletInitializer {
    @Autowired
    IIBRequestComponent iibRequestComponent;
    @Autowired
    RetrieveFinacleBean retrieveFinacleBean;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }
    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationStarter.class);
    }
}
