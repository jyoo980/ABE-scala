package ast
import visitor.Visitor

class Num(var num: Int) extends Expr {

  override def accept[X, R](v: Visitor[X, R], p: R): X = {
    v.accept(this, p)
  }
}
