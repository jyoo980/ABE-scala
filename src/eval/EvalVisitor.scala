package eval

import ast.{If, Num, NumValue, Value}
import environment.Environment
import visitor.Visitor

class EvalVisitor extends Visitor[Value, Environment] {

  override def accept(expr: Num, param: Environment): Value = {
    new NumValue(expr.num)
  }

  override def accept(expr: If, param: Environment): Value = {
    val cond = expr.pred.accept(this, param)
    if (cond.toBool()) {
      expr.thn.accept(this, param)
    } else {
      expr.els.accept(this, param)
    }
  }
}
