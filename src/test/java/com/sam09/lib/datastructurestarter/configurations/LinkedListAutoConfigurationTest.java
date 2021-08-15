package com.sam09.lib.datastructurestarter.configurations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class LinkedListAutoConfigurationTest {

    private static final Logger log = LoggerFactory.getLogger(LinkedListAutoConfigurationTest.class);
    AnnotationConfigApplicationContext context;
    String[] Declared_beans = {"singlyLinkedListBean", "doublyLinkedListBean"};
    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
    }
    private void scanProperties(AnnotationConfigApplicationContext configApplicationContext){
        configApplicationContext.register(LinkedListAutoConfiguration.class);
        configApplicationContext.refresh();
    }

    @Test
    public void getBeanContextTest() {
        scanProperties(context);
        assertNotNull(context.getBean(Declared_beans[0]));
        assertNotNull(context.getBean(Declared_beans[1]));
    }
}