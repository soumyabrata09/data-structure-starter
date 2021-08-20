package com.sam09.lib.datastructurestarter.configurations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class TreeAutoConfigurationTest {
    private static final String[] Declared_bean = {"binaryTreeBean","binarySearchTreeBean"};
    AnnotationConfigApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
    }

    private void scanProperties(AnnotationConfigApplicationContext applicationContext) {
        applicationContext.register(TreeAutoConfiguration.class);
        applicationContext.refresh();
    }

    @Test
    public void getBeanContextTest() {
        scanProperties(context);
        assertNotNull(context.getBean(Declared_bean[0]));
        assertNotNull(context.getBean(Declared_bean[1]));
    }
}