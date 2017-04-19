/**
  * Created by Ramu on 19/04/2017.
  */
package com.hmrc.shoppingcart

import scala.math.BigDecimal.RoundingMode

object ShoppingCart {

  // Each Item price..
  private val itemsPriceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  //Basic Checkout
  def checkout(items: Array[String]): Double = {
    val total = items.flatMap(price).sum
    BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

  def getPrice(item: String): Double = {
    itemsPriceList.getOrElse(item toLowerCase, 0)
  }

  def price(item: String): Option[Double] = itemsPriceList.get(item toLowerCase)

}
