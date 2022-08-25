//package test;
//
//import model.Sneakers;
//import model.User;
//import org.testng.annotations.Test;
//import page.FarfetchMainPage;
//import service.SneakersCreator;
//import service.UserCreator;
//
//public class FarfetchFavoritePageTest extends CommonConditions{
//
//    @Test
//    public void addGoodsToFavourite() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                    .addToFavourite();
//        favouritePage = searchResultPage.goToFavouritePage();
//
//        Assertions.assertEquals(testSneakers.getSneakersName(), favouritePage.getSneakerName());
//    }
//
//    @Test
//    public void deleteGoodsFromFavourite() throws InterruptedException {
//        User testUser = UserCreator.withCredentialsFromProperty();
//        Sneakers testSneakers = SneakersCreator.withCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        searchResultPage = mainPage.searchGoods(testSneakers.getSneakersModel())
//                .addToFavourite();
//        favouritePage = searchResultPage.goToFavouritePage()
//                .deleteGoodsFromFavourite();
//
//        Assertions.assertEquals("Здесь будут собраны товары, которые вы добавите в Избранное.",
//                favouritePage.favouriteIsEmpty());
//    }
//}
