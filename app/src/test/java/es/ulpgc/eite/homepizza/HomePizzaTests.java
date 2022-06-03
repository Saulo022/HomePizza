package es.ulpgc.eite.homepizza;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Luis on mayo, 2022
 */
@RunWith(RobolectricTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePizzaTests {

  HomePizzaSteps steps = new HomePizzaSteps();


  @Test
  public void T01ChooseCheesePizza() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 1);
    steps.appShowTextOnSection("Cart",0,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",0,"Price", 10);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);

    steps.resetTest();
  }


  @Test
  public void T02ChooseCheeseAndVeggiePizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 1);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",2 );
    steps.appShowTextOnSection("Cart", 0,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart", 0,"Price",10);
    steps.appShowNumOnSection("Cart", 0,"Amount", 1);
    steps.appShowTextOnSection("Cart", 1,"Pizza", "Veggie" );
    steps.appShowNumOnSection("Cart", 1,"Price", 9);
    steps.appShowNumOnSection("Cart", 1,"Amount", 1);

    steps.resetTest();
  }


  @Test
  public void T03ChooseBuffaloAndSupremePizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.appShowNumOfItems("Store", 9);
    steps.userPressItem("Store", 7);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 8);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.appShowTextOnSection("Cart", 0,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 0,"Price",15);
    steps.appShowNumOnSection("Cart", 0,"Amount",1);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Supreme");
    steps.appShowNumOnSection("Cart", 1,"Price",16);
    steps.appShowNumOnSection("Cart", 1,"Amount",1);

    steps.resetTest();
  }


  @Test
  public void T04ChooseSupremeAndBuffaloPizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.appShowNumOfItems("Store", 9);
    steps.userPressItem("Store", 8);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 7);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.appShowTextOnSection("Cart", 0,"Pizza", "Supreme");
    steps.appShowNumOnSection("Cart", 0,"Price",16);
    steps.appShowNumOnSection("Cart", 0,"Amount",1);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 1,"Price",15);
    steps.appShowNumOnSection("Cart", 1,"Amount",1);

    steps.resetTest();
  }



  @Test
  public void T05ChooseCheeseAndCheesePizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 1);
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.appShowTextOnSection("Cart", 0,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart", 0,"Price", 10);
    steps.appShowNumOnSection("Cart", 0,"Amount",1);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart", 1,"Price",10);
    steps.appShowNumOnSection("Cart", 1,"Amount",1);

    steps.resetTest();
  }


  @Test
  public void T06ChooseTwoCheesePizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 1);
    steps.userPressItem("Cart", 0);

    steps.appStartScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 10);
    steps.appShowNumOnSection("Amount","Total", 10);
    steps.userPressButton("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 20);
    steps.appShowNumOnSection("Amount","Total", 20);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.appShowTextOnSection("Cart",0,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",0,"Price", 10);
    steps.appShowNumOnSection("Cart",0,"Amount", 2);

    steps.resetTest();
  }


  @Test
  public void T07ChooseThreeSupremeAndTwoBuffaloPizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 8);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 7);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.appShowTextOnSection("Cart",0,"Pizza","Supreme");
    steps.appShowNumOnSection("Cart",0,"Price", 16);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart",1,"Price", 15);
    steps.appShowNumOnSection("Cart",1,"Amount", 1);
    steps.userPressItem("Cart", 0);

    steps.appStartScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Supreme");
    steps.appShowNumOnSection("Amount","Price", 16);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 16);
    steps.appShowNumOnSection("Amount","Total", 31);
    steps.userPressButton("Amount");
    steps.userPressButton("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Supreme");
    steps.appShowNumOnSection("Amount","Price", 16);
    steps.appShowNumOnSection("Amount","Amount", 3);
    steps.appShowNumOnSection("Amount","Subtotal", 48);
    steps.appShowNumOnSection("Amount","Total", 63);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.appShowTextOnSection("Cart", 0,"Pizza", "Supreme");
    steps.appShowNumOnSection("Cart", 0,"Price",16);
    steps.appShowNumOnSection("Cart", 0,"Amount",3);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 1,"Price",15);
    steps.appShowNumOnSection("Cart", 1,"Amount",1);
    steps.userPressItem("Cart", 1);

    steps.appStartScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Buffalo");
    steps.appShowNumOnSection("Amount","Price", 15);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 15);
    steps.appShowNumOnSection("Amount","Total", 63);
    steps.userPressButton("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Buffalo");
    steps.appShowNumOnSection("Amount","Price", 15);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 30);
    steps.appShowNumOnSection("Amount","Total", 78);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.appShowTextOnSection("Cart", 0,"Pizza", "Supreme");
    steps.appShowNumOnSection("Cart", 0,"Price",16);
    steps.appShowNumOnSection("Cart", 0,"Amount",3);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 1,"Price",15);
    steps.appShowNumOnSection("Cart", 1,"Amount",2);

    steps.resetTest();
  }


  @Test
  public void T08ChooseTwoVeggieAndOneCheeseAndTwoMargheritaPizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 1);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.userPressItem("Cart", 0);

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 4);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 3);
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 1);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 1);
    steps.userPressItem("Cart", 1);

    steps.appStartScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 10);
    steps.appShowNumOnSection("Amount","Total", 27);
    steps.userPressButton("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 20);
    steps.appShowNumOnSection("Amount","Total", 37);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 2);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 1);
    steps.userPressItem("Cart", 2);

    steps.appStartScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Margherita");
    steps.appShowNumOnSection("Amount","Price", 8);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 8);
    steps.appShowNumOnSection("Amount","Total", 37);
    steps.userPressButton("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Margherita");
    steps.appShowNumOnSection("Amount","Price", 8);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 16);
    steps.appShowNumOnSection("Amount","Total", 45);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 2);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 2);

    steps.resetTest();
  }


  @Test
  public void T09ChooseThreeSupremeAndTwoBuffaloPizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 8);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 7);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.appShowTextOnSection("Cart",0,"Pizza","Supreme");
    steps.appShowNumOnSection("Cart",0,"Price", 16);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart",1,"Price", 15);
    steps.appShowNumOnSection("Cart",1,"Amount", 1);
    steps.userRotateScreen("Cart");
    steps.userPressItem("Cart", 0);

    steps.appStartScreen("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Supreme");
    steps.appShowNumOnSection("Amount","Price", 16);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 16);
    steps.appShowNumOnSection("Amount","Total", 31);
    steps.userPressButton("Amount");
    steps.userPressButton("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Supreme");
    steps.appShowNumOnSection("Amount","Price", 16);
    steps.appShowNumOnSection("Amount","Amount", 3);
    steps.appShowNumOnSection("Amount","Subtotal", 48);
    steps.appShowNumOnSection("Amount","Total", 63);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.userRotateScreen("Cart");
    steps.appShowTextOnSection("Cart", 0,"Pizza", "Supreme");
    steps.appShowNumOnSection("Cart", 0,"Price",16);
    steps.appShowNumOnSection("Cart", 0,"Amount",3);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 1,"Price",15);
    steps.appShowNumOnSection("Cart", 1,"Amount",1);
    steps.userPressItem("Cart", 1);

    steps.appStartScreen("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Buffalo");
    steps.appShowNumOnSection("Amount","Price", 15);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 15);
    steps.appShowNumOnSection("Amount","Total", 63);
    steps.userPressButton("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Buffalo");
    steps.appShowNumOnSection("Amount","Price", 15);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 30);
    steps.appShowNumOnSection("Amount","Total", 78);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.userRotateScreen("Cart");
    steps.appShowTextOnSection("Cart", 0,"Pizza", "Supreme");
    steps.appShowNumOnSection("Cart", 0,"Price",16);
    steps.appShowNumOnSection("Cart", 0,"Amount",3);
    steps.appShowTextOnSection("Cart", 1,"Pizza","Buffalo");
    steps.appShowNumOnSection("Cart", 1,"Price",15);
    steps.appShowNumOnSection("Cart", 1,"Amount",2);

    steps.resetTest();
  }


  @Test
  public void T10ChooseTwoVeggieAndOneCheeseAndTwoMargheritaPizzas() {

    steps.appStartScreen("Cart");
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 1);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart",1 );
    steps.userPressButton("Store");

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 0);

    steps.appResumeScreen("Cart");
    steps.appShowNumOfItems("Cart", 2);
    steps.userPressItem("Cart", 0);

    steps.appStartScreen("Store");
    steps.userPressItem("Store", 4);

    steps.appResumeScreen("Cart");
    steps.userRotateScreen("Cart");
    steps.appShowNumOfItems("Cart", 3);
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 1);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 1);
    steps.userPressItem("Cart", 1);

    steps.appStartScreen("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 10);
    steps.appShowNumOnSection("Amount","Total", 27);
    steps.userPressButton("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Cheese");
    steps.appShowNumOnSection("Amount","Price", 10);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 20);
    steps.appShowNumOnSection("Amount","Total", 37);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.userRotateScreen("Cart");
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 2);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 1);
    steps.userPressItem("Cart", 2);

    steps.appStartScreen("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Margherita");
    steps.appShowNumOnSection("Amount","Price", 8);
    steps.appShowNumOnSection("Amount","Amount", 1);
    steps.appShowNumOnSection("Amount","Subtotal", 8);
    steps.appShowNumOnSection("Amount","Total", 37);
    steps.userPressButton("Amount");
    steps.userRotateScreen("Amount");
    steps.appShowTextOnSection("Amount","Pizza","Margherita");
    steps.appShowNumOnSection("Amount","Price", 8);
    steps.appShowNumOnSection("Amount","Amount", 2);
    steps.appShowNumOnSection("Amount","Subtotal", 16);
    steps.appShowNumOnSection("Amount","Total", 45);
    steps.userPressBackOnScreen("Amount");

    steps.appResumeScreen("Cart");
    steps.userRotateScreen("Cart");
    steps.appShowTextOnSection("Cart",0,"Pizza","Veggie");
    steps.appShowNumOnSection("Cart",0,"Price", 9);
    steps.appShowNumOnSection("Cart",0,"Amount", 1);
    steps.appShowTextOnSection("Cart",1,"Pizza","Cheese");
    steps.appShowNumOnSection("Cart",1,"Price", 10);
    steps.appShowNumOnSection("Cart",1,"Amount", 2);
    steps.appShowTextOnSection("Cart",2,"Pizza","Margherita");
    steps.appShowNumOnSection("Cart",2,"Price", 8);
    steps.appShowNumOnSection("Cart",2,"Amount", 2);

    steps.resetTest();
  }
}
