/**
  * Created by Ramu on 19/04/2017.
  */

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import com.hmrc.shoppingcart._

class ShoppingCartSuite extends FeatureSpec with GivenWhenThen with Matchers
{
  feature ("Basic Shopping Cart") {

    scenario("Testing Checkout with 1 apple and no offer") {

      Given("A shopping cart")
      val shoppingCart = ShoppingCart

      When("Add products with no offers")
      val items = Array("apple")

      Then("Total sum should be simple sum of prices")
      shoppingCart.checkout(items) should be(0.60)
    }

    scenario("Testing Checkout with 1 orange and no offer") {

      Given("A shopping cart")
      val shoppingCart = ShoppingCart

      When("Add one orange")
      val items = Array("orange");

      Then("Total sum should be price of one orange")
      shoppingCart.checkout(items) should be(0.25)
    }

    scenario("Testing Checkout with no offer and multiple items") {

      Given("A shopping cart")
      val shoppingCart = ShoppingCart

      When("Add products with no offers")
      val items = Array("apple", "orange", "orange");

      Then("Total sum should be simple sum of prices")
      shoppingCart.checkout(items) should be(1.10)
    }
  } //End of Feature with no offers

    feature ("Shopping Cart with Offers"){

      scenario("Testing Checkout BOGOF offer"){

        Given("A shopping cart")
        val shoppingCart =  ShoppingCart

        When("2 apples added to the basket")
        val items = Array("apple","apple");

        Then("Total price should be same as one apple")
        shoppingCart.checkout(items) should be (0.60)
      }

      scenario("Testing Checkout 3for2 offer"){

        Given("A shopping cart")
        val shoppingCart =  ShoppingCart

        When("3 oranges added to the basket")
        val items = Array("orange","orange","orange");

        Then("Total price should equal to prices of 2 oranges")
        shoppingCart.checkout(items) should be (0.50)
      }

      scenario("Testing Checkout both 3for2 and BOGOF offers"){

        Given("A shopping cart")
        val shoppingCart =  ShoppingCart

        When("3 oranges and 2 apples added to the basket")
        val items = Array("orange","orange","orange","apple","apple");

        Then("Total price should equal to prices of 2 oranges and 1 apple")
        shoppingCart.checkout(items) should be (1.10)
      }


      scenario("Testing Checkout with no offer"){

        Given("A shopping cart")
        val shoppingCart =  ShoppingCart

        When("2 oranges and 1 apple added to the basket")
        val items = Array("orange","orange","apple");

        Then("Total price should equal to prices of 2 oranges and 1 apple")
        shoppingCart.checkout(items) should be (1.10)
      }

    } //End of Feature with Offers

}