package com.apirest.acme.scala.rest

import org.scalatra._
import scalate.ScalateSupport
import org.fusesource.scalate.{ TemplateEngine, Binding }
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import javax.servlet.http.HttpServletRequest
import collection.mutable


trait ScalarestwebappStack extends ScalatraServlet with ScalateSupport {

  notFound {
    status = 404
  }

}
