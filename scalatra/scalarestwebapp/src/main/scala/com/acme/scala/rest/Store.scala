
package com.apirest.acme.scala.rest

//JSON related libraries
import org.json4s.{DefaultFormats, Formats}

//JSON handling support from Scalatra
import org.scalatra.json._

// JSON library for converting the POJO toString as Json
import org.json4s.native.Json

class Store(val id:Int, var storeName:String, var cnpj:String) {                                   
                                                                                              
        println("Store - Constructor  BEGIN .... ")

	def this(storeName:String, cnpj:String) {
		this(Store.inc, storeName, cnpj)
	}
                                                                                              
    //override def toString = s"Store [Id=$id, StoreName=$storeName, cnpj=$cnpj]"

	override def toString = Json(DefaultFormats).write(this) 

	println("Store - Constructor END .... ")
}                                                                                             
                                                                                              
object Store {                                                                             
	private var id = 0                                                                    
                                                                                              
        private def inc = {   
	       println(" ****** Inc method called, id = " + id)
       	        id += 1;                                                                      
               	id                                                                            
        }                                                                                     
}                                                                                              
