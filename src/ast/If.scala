package ast
import visitor.Visitor

class If(var pred: Expr, var thn: Expr, var els: Expr) extends Expr {

  override def accept[X, R](v: Visitor[X, R], p: R): X = {
    v.visit(this, p)
  }
}
