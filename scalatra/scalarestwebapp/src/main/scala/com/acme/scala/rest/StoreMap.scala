package com.apirest.acme.scala.rest

import scala.collection._

class StoreMap {

	println("StoreMap - Constructor BEGIN... ")

        var map:Map[Int, Store] = Map()


        def add(storeName:String, cnpj:String):Int = {
		println("StoreMap - ADD - Invoked")
                var c:Store = new Store(storeName, cnpj)
		println("New Store created. Id - " + c.id)
                map += (c.id -> c)
                c.id
        }
	
	def add(c:Store):Store = {
		map += (c.id -> c)
		c
	}

        def exists(id:Int):Boolean = {
                map.keySet(id)
        }

        def get(id:Int):Store = {
                map(id)
        }

        def remove(id:Int) = {
                map = map - id
        }

        def update(id:Int, c:Store) {
                map += (id -> c)
        }

        override def toString = s"Map :: ${map}"

	println("StoreMap - Constructor END....")
}

