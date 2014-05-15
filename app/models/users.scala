package models

import com.novus.salat._
//import com.novus.salat.global._
import something.CustomPlaySalatContext._


import com.mongodb.casbah.Imports._

case class Hero(name: String, archetype: String){

	override def toString = name + " the " + archetype
}
case class Villain(name: String, empire: String){
	override def toString = name + " of " + empire
}

case class World(hero: Hero, villain: Villain){
    override def toString = hero + " fights " + villain
} 


object EntryPoint {

def addIn{
	val obj1 = Hero("Harry", "Wizard")
	val obj2 = Villain("Voldemort", "Death-Eaters")

	val world = World(obj1, obj2)

	val dbo = grater[World].asDBObject(world)

	val mongoClient = MongoClient("localhost", 27017)
	val db = mongoClient("worlds")
	val coll = db("worlds")
	coll.insert(dbo)

}

def trials(user: String):World = {
	val mongoClient = MongoClient("localhost", 27017)
	val db = mongoClient("worlds")
	val coll = db("worlds")
	val all = coll.findOne(MongoDBObject("hero.name" -> user)) /*match {
		case Some(ans) => ans
		case _ => None
	}
    */
    
    /*
    val ans = all.map{case a => grater[World].asObject(a)}
    if(ans.empty) World(Hero("None", "All"), Villain("No-one", "Nowhere")) 
    */
    
    all match {
    	case Some(a) => grater[World].asObject(a)
    	case _       => World(Hero("None", "All"), Villain("No-one", "Nowhere")) 
    }
    
    

    /*
    all match {
    	case Some(a) => Some(grater[World].asObject(a))
        case None => None
    }
    */
	//return all.map{case a => grater[World].asObject(a)}
}	

}
