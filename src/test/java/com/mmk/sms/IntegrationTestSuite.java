package com.mmk.sms;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * @author: Nathan
 */
@Suite
@SelectPackages({"com.mmk.sms.controller","com.mmk.sms.Dto",
        "com.mmk.sms.domain","com.mmk.sms.repository",
        "com.mmk.sms.service", "com.mmk.sms.dbhealth"})
@SelectClasses({ AccountsApplication.class})
public class IntegrationTestSuite {

    //Intentionally empty - Test suite annotations set up is enough
}
