package service;

import model.User;
import util.TestDataReader;

public class UserCreator {
    private static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_EMAIL_WRONG = "testdata.user.email.wrong";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_NAME));
    }

    public static User withWrongCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL_WRONG), TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_NAME));
    }
}
