package com.sam09.lib.datastructurestarter.configurations;

import com.sam09.lib.datastructurestarter.services.queues.AbstractPriorityQueue;
import com.sam09.lib.datastructurestarter.services.queues.PriorityQueue;
import com.sam09.lib.datastructurestarter.services.queues.Queue;
import com.sam09.lib.datastructurestarter.services.queues.QueueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = true)
@ConditionalOnClass
public class QueueAutoConfiguration {

    @Bean(name = "capacityBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public int getCapacity(@Value("${ds.queue.capacity:10}") int capacity) {
        return capacity;
    }

    @Bean(name = "queueBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public Queue getQueueServiceBean(int getCapacity) {
        return new QueueService(getCapacity);
    }

    @Bean(name = "priorityQueueBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnMissingBean
    public AbstractPriorityQueue getPriorityQueue(int getCapacity) {
        return new PriorityQueue(getCapacity);
    }
}
