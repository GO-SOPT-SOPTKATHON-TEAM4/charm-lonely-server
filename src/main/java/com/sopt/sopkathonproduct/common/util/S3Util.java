package com.sopt.sopkathonproduct.common.util;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sopt.sopkathonproduct.config.AwsS3Config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.InputStream;
import java.net.URLDecoder;

@Configuration
@RequiredArgsConstructor
public class S3Util {

    private final Environment env;

    private final AwsS3Config awsS3Config;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    // 파일 업로드
    public String upload(InputStream file, String fileName, ObjectMetadata objectMetadata) {
        awsS3Config.amazonS3Client().putObject(bucket, fileName, file, objectMetadata);
        return awsS3Config.amazonS3Client().getUrl(bucket, fileName).toString();
    }

    // 파일 삭제
    public void delete(String fileName) {
        String key = URLDecoder.decode(fileName.split("/")[3]);
        awsS3Config.amazonS3Client().deleteObject(bucket, key);
    }

    public String getImageUrl(String filePath) {
        return awsS3Config.amazonS3Client().getUrl(bucket, filePath).toString();
    }
}
