package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.lists.DoublyLinkedList;
import com.sam09.lib.datastructurestarter.services.lists.DoublyList;
import com.sam09.lib.datastructurestarter.services.lists.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.lists.SinglyList;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = true)
@ConditionalOnClass
public class LinkedListAutoConfiguration {

    @Bean(name = "singlyList")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public SinglyList singlyLinkedListBean(){
        return new SinglyLinkedList();
    }

    @Bean(name = "doublyList")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public DoublyList doublyLinkedListBean(){
        return new DoublyLinkedList();
    }
}
