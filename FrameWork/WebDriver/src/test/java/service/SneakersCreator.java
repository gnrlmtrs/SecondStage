package service;

import model.Sneakers;

public class SneakersCreator {
    public static final String TESTDATA_SNEAKERS_MODEL = "testdata.sneakers.model";
    public static final String TESTDATA_SNEAKERS_NAME = "testdata.sneakers.name";
    public static final String TESTDATA_SNEAKERS_SIZE = "testdata.sneakers.size";

    public static Sneakers withCredentialsFromProperty(){
        return new Sneakers(TestDataReader.getTestData(TESTDATA_SNEAKERS_MODEL),
                TestDataReader.getTestData(TESTDATA_SNEAKERS_NAME),
                TestDataReader.getTestData(TESTDATA_SNEAKERS_SIZE));
    }
}
