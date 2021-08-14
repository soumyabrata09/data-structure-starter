package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.SinglyList;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
public class SinglyListAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SinglyList singlyLinkedList(){
        return new SinglyLinkedList();
    }
}
