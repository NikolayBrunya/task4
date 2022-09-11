package com.company.task4;

import io.jmix.core.impl.UnconstrainedDataManagerImpl;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StBaseTest {

   protected final String username = "admin";

    @Qualifier("core_UnconstrainedDataManager")
    @Autowired
    protected UnconstrainedDataManagerImpl dataManager;

    protected List<Object> entitiesToRemove = new ArrayList<>();
    @Autowired
    protected SystemAuthenticator systemAuthenticator;
    @Autowired
    protected CurrentAuthentication currentAuthentication;

    @BeforeEach
    void setUp() {
        systemAuthenticator.begin(username);
    }
    @AfterEach
    void tearDown()
    {

        systemAuthenticator.end();
        //entitiesToRemove.forEach( e ->{dataManager.remove(e);});
        dataManager.remove(entitiesToRemove);
    }
}
