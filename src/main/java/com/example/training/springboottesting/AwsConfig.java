package com.example.training.springboottesting;/* harpalsingh created on 11/24/21 inside the package - com.example.training.springboottesting */

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
@PropertySource("classpath:aws/aws-config.properties")
public class AwsConfig {

    @Autowired
    private Environment env;



    public String getRegionName() {
        return env.getProperty("aws.region.name");
    }

    public String getBucketName() {
        return env.getProperty("aws.bucket.name");
    }

    public String getS3Path() {
        return env.getProperty("aws.s3.folder.path");
    }

}
