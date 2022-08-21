//package test;
//
//import model.Sneakers;
//import model.User;
//import org.junit.jupiter.api.Assertions;
//import org.testng.annotations.Test;
//import page.FarfetchMainPage;
//import service.SneakersCreator;
//import service.UserCreator;
//
//public class FarfetchSearchPageTest extends CommonConditions {
//
//    @Test
//    public void searchGoodsTest() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel());
//
//        Assertions.assertEquals(testSneakers.getSneakersName(), searchResultPage.getSneakersName());
//    }
//}
