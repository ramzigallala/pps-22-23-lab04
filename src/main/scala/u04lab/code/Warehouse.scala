package u04lab.code
import u04lab.code.List.*

import scala.::
trait Item {
  def code: Int
  def name: String
  def tags: List[String]
}

case class ItemImpl(override val code:Int,
                    override val name:String,
                   override val tags:List[String]) extends Item

object Item:
  def apply(code: Int, name: String, tags: List[String] = List.empty): Item =
    ItemImpl(code, name, tags)

/**
 * A warehouse is a place where items are stored.
 */
trait Warehouse {
  /**
   * Stores an item in the warehouse.
   * @param item the item to store
   */
  def store(item: Item): Unit
  /**
   * Searches for items with the given tag.
   * @param tag the tag to search for
   * @return the list of items with the given tag
   */
  def searchItems(tag: String): List[Item]
  /**
   * Retrieves an item from the warehouse.
   * @param code the code of the item to retrieve
   * @return the item with the given code, if present
   */
  def retrieve(code: Int): Option[Item]
  /**
   * Removes an item from the warehouse.
   * @param item the item to remove
   */
  def remove(item: Item): Unit
  /**
   * Checks if the warehouse contains an item with the given code.
   * @param itemCode the code of the item to check
   * @return true if the warehouse contains an item with the given code, false otherwise
   */
  def contains(itemCode: Int): Boolean
}

case class WarehouseImpl() extends Warehouse:
<<<<<<< HEAD
  var items: List[Item] = empty
  override def store(item: Item): Unit = items = cons(item, items)

  override def contains(itemCode: Int): Boolean = List.contains(List.map(items)(_.code), itemCode)


  override def remove(item: Item): Unit = ???

  override def retrieve(code: Int): Option[Item] = ???

  override def searchItems(tag: String): List[Item] = ???


object Warehouse {
  def apply(): Warehouse = new WarehouseImpl
=======
  var list: List[Item] = empty


  override def store(item: Item): Unit = list = append(list, cons(item, empty))
  override def searchItems(tag: String): List[Item] = filter(list)(i => List.contains(i.tags,tag))
  override def retrieve(code: Int): Option[Item] = find(list)(i => i.code==code)
  override def remove(item: Item): Unit = list = List.remove(list)(i => i==item)
  override def contains(itemCode: Int): Boolean = List.contains(map(list)(i => i.code), itemCode)

object Warehouse {
  def apply(): Warehouse = new WarehouseImpl()
>>>>>>> 8336cba94e5e35c54f9e36fca3c65e1b80195f1b
}

@main def mainWarehouse(): Unit =
  val warehouse = Warehouse()

  val dellXps = Item(33, "Dell XPS 15", cons("notebook", empty))
  val dellInspiron = Item(34, "Dell Inspiron 13", cons("notebook", empty))
  val xiaomiMoped = Item(35, "Xiaomi S1", cons("moped", cons("mobility", empty)))

  println(warehouse.contains(dellXps.code)) // false
  println(warehouse.store(dellXps)) // side effect, add dell xps to the warehouse
  println(warehouse.contains(dellXps.code)) // true
<<<<<<< HEAD

  warehouse.store(dellInspiron) // side effect, add dell inspiron to the warehouse
  warehouse.store(xiaomiMoped) // side effect, add xiaomi moped to the warehouse
  warehouse.searchItems("mobility") // List(xiaomiMoped)
  warehouse.searchItems("notebook") // List(dellXps, dellInspiron)
  warehouse.retrieve(11) // None
  warehouse.retrieve(dellXps.code) // Some(dellXps)
  warehouse.remove(dellXps) // side effect, remove dell xps from the warehouse
  warehouse.retrieve(dellXps.code) // None

=======
  println(warehouse.store(dellInspiron)) // side effect, add dell inspiron to the warehouse
  println(warehouse.store(xiaomiMoped)) // side effect, add xiaomi moped to the warehouse
  println(warehouse.searchItems("mobility")) // List(xiaomiMoped)
  println(warehouse.searchItems("notebook")) // List(dellXps, dellInspiron)
  println(warehouse.retrieve(11)) // None
  println(warehouse.retrieve(dellXps.code)) // Some(dellXps)
  println(warehouse.remove(dellXps)) // side effect, remove dell xps from the warehouse
  println(warehouse.retrieve(dellXps.code)) // None

>>>>>>> 8336cba94e5e35c54f9e36fca3c65e1b80195f1b
/** Hints:
 * - Implement the Item with a simple case class
 * - Implement the Warehouse keeping a private List of items
 * - Start implementing contains and store
 * - Implement searchItems using filter and contains
 * - Implement retrieve using find
 * - Implement remove using filter
 * - Refactor the code of Item accepting a variable number of tags (hint: use _*)
*/
