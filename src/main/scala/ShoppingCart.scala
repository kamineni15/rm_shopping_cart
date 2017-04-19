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
    0.60
  }

}
