package com.sam09.lib.datastructurestarter.configurations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class StackAutoConfigurationTest {

    AnnotationConfigApplicationContext context;
    String[] Declared_beans = {"sizeBean","stackBean"};

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
    }
    private void scanProperties(AnnotationConfigApplicationContext configApplicationContext) {
        configApplicationContext.register(StackAutoConfiguration.class);
        configApplicationContext.refresh();
    }

    @Test
    public void getBeanContextTest() {
        scanProperties(context);
        assertNotNull(context.getBean(Declared_beans[0]));
        assertNotNull(context.getBean(Declared_beans[1]));
    }
}