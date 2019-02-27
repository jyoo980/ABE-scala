package ast

class NumValue(num: Int) extends Value {

  override def toNum(): Int = this.num

  override def toBool() = throw new Error("NumValue cannot be unboxed to a boolean")
}
