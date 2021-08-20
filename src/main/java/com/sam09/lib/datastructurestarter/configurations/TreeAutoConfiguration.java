package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.trees.BinaryTree;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = true)
@ConditionalOnClass
public class TreeAutoConfiguration {

    @Bean(name = "binaryTreeBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public BinaryTree getBinaryTreeBean() {
        return new BinaryTree();
    }
}
