package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.testng.*;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.addAttachment;
import static org.testng.ITestResult.SKIP;
import static org.testng.ITestResult.SUCCESS;

@Component
public class TestStartFinishTestNGListener implements IInvokedMethodListener, IAnnotationTransformer, ISuiteListener, ITestListener {

    private static final Logger log = LoggerFactory.getLogger(TestStartFinishTestNGListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            Method testMethod = iInvokedMethod.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(Test.class)) {
                log.info("== Test '{}' START ==", iInvokedMethod.getTestMethod().getQualifiedName());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult result) {
        if (iInvokedMethod.isTestMethod()) {
            log.info("=== Test '{}' {} ===", iInvokedMethod.getTestMethod().getQualifiedName(), getTestResult(result));
        }
    }

    private String getTestResult(ITestResult result) {
        return switch (result.getStatus()) {
            case SUCCESS -> "PASSED";
            case SKIP -> "SKIPPED";
            default -> "FAILED";
        };
    }

    @Override
    public void onTestFailure(ITestResult result) {
        addAttachment(result.getMethod().getQualifiedName(),
                new ByteArrayInputStream(((TakesScreenshot) getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)));
    }

}
