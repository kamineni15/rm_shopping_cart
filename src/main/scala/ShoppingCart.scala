/**
  * Created by Ramu on 19/04/2017.
  */
package com.hmrc.shoppingcart

import scala.math.BigDecimal.RoundingMode

object ShoppingCart {

  // Each Item price..
  private val itemsPriceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  //Checkout with or with out offers
  def checkout(items: Array[String]): Double = {
    val noOfApples: Int = items.count(p => p.equalsIgnoreCase("apple"))
    val noOfOranges: Int = items.count(p => p.equalsIgnoreCase("orange"))

    // To calculate total items price based on offers
    val totalPrice = Offers.offer("apple")(noOfApples) + Offers.offer("orange")(noOfOranges)

    // To round total price to half even
    BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

  def getPrice(item: String): Double = {
    itemsPriceList.getOrElse(item toLowerCase, 0)
  }

  def price(item: String): Option[Double] = itemsPriceList.get(item toLowerCase)

}
