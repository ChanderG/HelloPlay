package something

import com.novus.salat.Context
import play.api.Play

package object CustomPlaySalatContext {
  implicit val ctx = new Context {
    val name = "Custom_Classloader"
  }
  ctx.registerClassLoader(Play.classloader(Play.current))
}