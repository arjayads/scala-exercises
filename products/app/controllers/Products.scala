package controllers


import javax.inject.{Inject, Singleton}

import play.api.Logger
import models.Product
import play.api.mvc.{Action, Controller}
import play.api.i18n.Messages.Implicits._
import play.api.Play.current


@Singleton
class Products @Inject() extends Controller {

	def list = Action { implicit request =>

		val products = Product.findAll

		Logger.info(products.toString())

		Ok(views.html.products.list(products))
	}
}
