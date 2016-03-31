package controllers


import javax.inject.{Inject, Singleton}

import models.Product
import play.api.mvc.{Action, Controller}
import play.api.i18n.Messages.Implicits._
import play.api.Play.current


@Singleton
class Products @Inject() extends Controller {

	def list = Action { implicit request =>

		val products = Product.findAll

		Ok(views.html.products.list(products))
	}

  def show(ean: Long) = Action {

    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
	}
}
