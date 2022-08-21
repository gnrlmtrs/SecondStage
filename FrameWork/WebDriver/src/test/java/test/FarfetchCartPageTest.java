package test;

import model.Sneakers;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import service.SneakersCreator;
import service.UserCreator;

public class FarfetchCartPageTest extends CommonConditions{

//    @Test
//    public void addGoodsToCart() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                    .addSneakersToCart();
//        cartPage = searchResultPage.goToCart();
//
//        Assertions.assertEquals(testSneakers.getSneakersName(), cartPage.getSneakerNumber());
//    }
//
//    @Test
//    public void deleteGoodsFromCart() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                .addSneakersToCart();
//        cartPage = searchResultPage.goToCart()
//                .deleteGoodsFromCart();
//
//        Assertions.assertEquals("Корзина пуста", cartPage.checkedOnEmptyBasket());
//    }
//
//    @Test
//    public void changeSizeOfSneakers() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                    .addSneakersToCart();
//        cartPage = searchResultPage.goToCart();
//
//        Assertions.assertEquals(testSneakers.getSneakersSize(), cartPage.changeSizeOfSneakers());
//    }
//
//    @Test
//    public void addGoodsToCartFromFavourite() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                .addToFavourite();
//        favouritePage = searchResultPage.goToFavouritePage();
//        cartPage = favouritePage.goToCartPage();
//
//        Assertions.assertEquals(testSneakers.getSneakersName(), cartPage.getSneakerNumber());
//    }
}
