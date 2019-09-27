package com.apirest.acme.scala.rest

import org.scalatra._



//JSON related libraries
import org.json4s.{DefaultFormats, Formats}

//JSON handling support from Scalatra
import org.scalatra.json._

class MyScalatraServlet extends ScalarestwebappStack with JacksonJsonSupport  {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format
  before() {
    contentType = formats("json")
    
  }
  
  var storeMap = new StoreMap() 

  get("/") {
    
  }

  get("/store") {
	  storeMap.map
  }

  get("/store/:Id") {
  	var IdInt = Integer.parseInt(params("Id"))  
    if(storeMap.exists(IdInt)==true){
        storeMap.get(IdInt)
    }else{
        status = 204
    }
  }

  post("/store") {
    var store = parsedBody.extract[Store]
    storeMap.add(store)
    status = 201
  }

  put("/store/:Id") {
    var IdInt = Integer.parseInt(params("Id"))
    var store = parsedBody.extract[Store]
    storeMap.update(IdInt, store)
  }

  delete("/store/:Id") {
  	var IdInt = Integer.parseInt(params("Id"))
	  storeMap.remove(IdInt)
  	storeMap.map
  }
}

