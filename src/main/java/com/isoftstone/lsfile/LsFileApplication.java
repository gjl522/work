package com.isoftstone.lsfile;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * 启动类
 *
 * @author gongjiale
 * @date 2020-8-25
 */
@SpringBootApplication(scanBasePackages = "com.isoftstone")
@EnableSwagger2
@Configuration
public class LsFileApplication {

    /**
     * 设置fastjson序列化方案
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonConfigure() {

        // 配置
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);


        // baidu：byte[]类型的消息由FastJsonHttpMessageConverter转换了所以内容乱码
        // 解决下载附件，中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);

        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

    /**
     * 启动方法
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(LsFileApplication.class, args);

    }
}
