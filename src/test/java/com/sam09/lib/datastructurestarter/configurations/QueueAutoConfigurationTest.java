package com.sam09.lib.datastructurestarter.configurations;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class QueueAutoConfigurationTest {

    private static final Logger log = LoggerFactory.getLogger(QueueAutoConfigurationTest.class);
    AnnotationConfigApplicationContext context;
    String[] Declared_bean = {"queueBean","capacityBean","priorityQueueBean"};

    private void scanProperties(AnnotationConfigApplicationContext configApplicationContext) {
        configApplicationContext.register(QueueAutoConfiguration.class);
        configApplicationContext.refresh();
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
    }

    @Test
    public void getBeanContextTest() {
        scanProperties(context);
        assertNotNull(context.getBean(Declared_bean[0]));
        assertNotNull(context.getBean(Declared_bean[1]));
        assertNotNull(context.getBean(Declared_bean[2]));
    }
}