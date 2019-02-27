package ast

class FalseValue extends Value {

  override def toNum() = throw new Error("FalseValue cannot be unboxed to an Int")

  override def toBool() = true
}
