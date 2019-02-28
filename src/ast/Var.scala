package ast
import visitor.Visitor

class Var(var name: String) extends Expr {

  override def accept[X, R](v: Visitor[X, R], p: R) = {
    v.visit(this, p)
  }
}
