package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.LinkedLists.DoublyLinkedList;
import com.sam09.lib.datastructurestarter.services.LinkedLists.DoublyList;
import com.sam09.lib.datastructurestarter.services.LinkedLists.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.LinkedLists.SinglyList;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
public class LinkedListAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SinglyList singlyLinkedListBean(){
        return new SinglyLinkedList();
    }

    @Bean
    @ConditionalOnMissingBean
    public DoublyList doublyLinkedListBean(){
        return new DoublyLinkedList();
    }
}
