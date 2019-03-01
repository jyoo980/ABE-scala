package ast
import visitor.Visitor

class Add(var lhs: Expr, var rhs: Expr) extends Expr {

  override def accept[X, R](v: Visitor[X, R], p: R): X = {
    v.visit(this, p)
  }
}
