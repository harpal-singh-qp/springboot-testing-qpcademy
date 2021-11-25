package com.example.training.springboottesting.config;/* harpalsingh created on 11/24/21 inside the package - com.example.training.springboottesting */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aws/aws-config.properties")
public class ElasticSearchConfig {

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
