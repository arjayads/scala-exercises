package controllers


import javax.inject.{Inject, Singleton}

import models.Product
import play.api.Logger
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.Messages
import play.api.mvc.{Flash, Action, Controller}
import play.api.i18n.Messages.Implicits._
import play.api.Play.current


@Singleton
class Products @Inject() extends Controller {

  private val productForm: Form[Product] = Form(
    mapping(
      "ean" -> Forms.longNumber.verifying("validation.ean.duplicate", Product.findByEan(_).isEmpty),
      "name" -> Forms.nonEmptyText,
      "description" -> Forms.nonEmptyText
    )(Product.apply)(Product.unapply)
  )

	def list = Action { implicit request =>

		val products = Product.findAll

		Ok(views.html.products.list(products))
	}

  def show(ean: Long) = Action { implicit request =>

    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
	}

  def newProduct = Action { implicit request =>
    val form = if (request.flash.get("error").isDefined)
      productForm.bind(request.flash.data)
    else
      productForm

    Ok(views.html.products.editProduct(form))
  }

  def save = Action { implicit request =>
    val newProductForm = productForm.bindFromRequest

    newProductForm.fold (
      hasErrors = { form =>
        Redirect(routes.Products.newProduct).
          flashing(Flash(form.data) + ("error" -> Messages("validation.errors")))
      },

      success = { newProduct =>
        Product.add(newProduct)
        Redirect(routes.Products.show(newProduct.ean)).
          flashing("success" -> Messages("products.new.success", newProduct.name))
      }
    )
  }
}
