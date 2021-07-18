package com.entropy.backend.configurations.loggers;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import com.entropy.backend.common.constants.AppConstant;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * This class provide configuration for logger, that's mapped with logback.xml config
 *
 * @author bac-ta
 * @see LoggerConfiguration
 * @since 2021-06-16
 */
@Configuration
public class LoggerConfiguration {
    /**
     * Config logger load process + memory and query
     */
    @Bean("processLoggerConfig")
    @SneakyThrows
    public LoggerContext loadMemoryLoggerConfig() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator jc = new JoranConfigurator();
        jc.setContext(context);
        context.reset();

        //Set process logger file name
        context.putProperty("processFile", AppConstant.LOGGER_PREFIX_NAME);

        InputStream inputStream = new ClassPathResource("logback-process.xml").getInputStream();
        jc.doConfigure(inputStream);

        return context;
    }

    /**
     * Config logger error
     */
    @Lazy
    @Bean("errorLoggerConfig")
    @SneakyThrows
    public LoggerContext errorLoggerConfig() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator jc = new JoranConfigurator();
        jc.setContext(context);
        context.reset();

        //Set process logger file name
        context.putProperty("errorLoggerFile", AppConstant.LOGGER_ERROR_PREFIX_NAME);

        InputStream inputStream = new ClassPathResource("logback-error.xml").getInputStream();
        jc.doConfigure(inputStream);

        return context;
    }

}

