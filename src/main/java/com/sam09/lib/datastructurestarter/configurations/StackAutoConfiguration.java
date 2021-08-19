package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.stack.Stack;
import com.sam09.lib.datastructurestarter.services.stack.StackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass
public class StackAutoConfiguration {

    @Bean(name = "sizeBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public int getSize(@Value("${ds.stack.size:50}") int size) {
      return size;
    }

    @Bean(name = "stackBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public Stack stackBean(int getSize) {
        return new StackService(getSize);
    }
}
