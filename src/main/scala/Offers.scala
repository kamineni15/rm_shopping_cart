/**
  * Created by Ramu on 19/04/2017.
  */
package com.hmrc.shoppingcart

object Offers {

  //Buy one get one free (BOGOF)
  def bogof(noOfItems: Int, price: Double): Double = ((noOfItems / 2) + (noOfItems % 2)) * price

  //3 For 2 Offer
  def threeForTwo(noOfItems: Int, price: Double): Double = (2 * (noOfItems/3) + (noOfItems %3)) * price

  //Offer function where code can be changed to include above 2 offers for any products.
  //For now, apple has BOGOF offer and orange has 3For2 offer
  def offer(item: String): Int => Double = {
    val price: Double =  ShoppingCart.getPrice(item)
    item toLowerCase() match {
      case "apple" => (noOfItems:Int) => bogof(noOfItems, price)
      case "orange" => (noOfItems:Int) => threeForTwo(noOfItems, price)
      case _ => (noOfItems:Int) => noOfItems * price
    }
  }

}
