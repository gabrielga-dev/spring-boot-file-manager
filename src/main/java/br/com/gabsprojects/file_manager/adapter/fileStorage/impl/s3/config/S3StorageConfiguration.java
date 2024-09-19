package br.com.gabsprojects.file_manager.adapter.fileStorage.impl.s3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "spring.application.file.storage.technology", havingValue = "s3")
public class S3StorageConfiguration {

    @Value("${spring.application.file.storage.s3.access-key-id}")
    private String s3UserAccessKey;
    @Value("${spring.application.file.storage.s3.secret-key}")
    private String s3UserSecretKey;
    @Value("${spring.application.file.storage.s3.region}")
    private String s3Region;
    @Value("${spring.application.file.storage.s3.server}")
    private String s3Server;

    public AWSCredentials credentials() {
        return new BasicAWSCredentials(s3UserAccessKey, s3UserSecretKey);
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder
                .standard()
                .enablePathStyleAccess()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(s3Server, s3Region)
                )
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .build();
    }
}
