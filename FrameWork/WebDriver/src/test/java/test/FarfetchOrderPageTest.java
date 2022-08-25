//package test;
//
//import model.Sneakers;
//import model.User;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page.FarfetchMainPage;
//import service.SneakersCreator;
//import service.UserCreator;
//
//@Deprecated
//public class FarfetchOrderPageTest extends CommonConditions{
//
//    @Test
//    public void incorrectInputPhoneNumber(){
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                    .addSneakersToCart();
//        cartPage = searchResultPage.goToCart();
//        orderPage = cartPage.goToOrderPage();
//
//        Assert.assertEquals("Пожалуйста, введите корректный номер телефона", orderPage.getWrongNumber());
//    }
//}
