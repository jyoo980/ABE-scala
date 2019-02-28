package eval

import ast._
import environment.Environment
import visitor.Visitor

class EvalVisitor extends Visitor[Value, Environment] {

  override def visit(expr: Num, param: Environment): Value = {
    new NumValue(expr.num)
  }

  override def visit(expr: If, param: Environment): Value = {
    val cond = expr.pred.accept(this, param)
    if (cond.toBool()) {
      expr.thn.accept(this, param)
    } else {
      expr.els.accept(this, param)
    }
  }

  override def visit(expr: Var, param: Environment) = ???
}
