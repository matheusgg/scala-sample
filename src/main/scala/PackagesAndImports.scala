import users.admins.AdminUser // Import AdminUser class
import users.normal.NormalUser // Import NormalUser class

//import scala.reflect._ // Import everything from reflect package
//import scala.reflect.{Manifest, ManifestFactory} // Only imports Manifest and ManifestFactory from reflect package
//import scala.reflect.{ManifestFactory => mf} // Only import ManifestFactory and give the alias mf

// Packages can be declared using braces
package users {

  // We can nest packages and create a structure
  package admins {
    class AdminUser
  }

  package normal {
    class NormalUser
  }

}

object PackagesAndImports extends App {
  /**
   * Packages
   */
  new AdminUser
  new NormalUser

  /**
   * Imports - Packages scala, java.lang and object Predef are imported by default
   */
  import scala.reflect.{ManifestFactory => mf} // Imports can be used anywhere
  println(mf.Unit)

  import _root_.scala.reflect.{ManifestFactory => mf2} // _root_ can be used to avoid name conflict
  println(mf2.Unit)

}