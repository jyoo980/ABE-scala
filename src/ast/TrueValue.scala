package ast

class TrueValue extends Value {

  override def toNum() = throw new Error("TrueValue cannot be unboxed to an Int")

  override def toBool() = true
}
