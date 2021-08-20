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

/**
 * @author soumyabrata09
 */
@Configuration(proxyBeanMethods = true)
@ConditionalOnClass
public class LinkedListAutoConfiguration {

    /**
     * @return Returns a bean of type SinglyLinkedList
     */
    @Bean(name = "singlyList")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public SinglyList singlyLinkedListBean(){
        return new SinglyLinkedList();
    }

    /**
     * @return Returns a bean of type DoublyLinkedList
     */
    @Bean(name = "doublyList")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public DoublyList doublyLinkedListBean(){
        return new DoublyLinkedList();
    }
}
