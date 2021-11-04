package com.multitenancy.app;

import javax.activation.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multitenancy.app.data.CustomRoutingDataSource;
import com.multitenancy.app.service.MasterService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.multitenancyapp")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.multitenancy.app")


public class SpringBootConfig {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args); //iniciando a aplicação
    }
    @Bean
    public DataSource dataSource(){
        CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
        return (DataSource) customDataSource;
    }
	
}
