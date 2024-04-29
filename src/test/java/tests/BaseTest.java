package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import pages.MainPage;

@SpringBootTest(classes = {ApplicationTestRunner.class})
@EnableConfigurationProperties
public abstract class BaseTest
        extends AbstractTestNGSpringContextTests
        implements TestInit {

    @Autowired
    protected MainPage mainPage;

}
