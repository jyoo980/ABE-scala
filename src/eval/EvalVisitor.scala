package eval

import ast._
import environment.Environment
import visitor.Visitor

class EvalVisitor extends Visitor[Value, Environment] {

  override def visit(expr: Num, env: Environment): Value = {
    new NumValue(expr.num)
  }

  override def visit(expr: If, env: Environment): Value = {
    val cond = expr.pred.accept(this, env)
    if (cond.toBool()) {
      expr.thn.accept(this, env)
    } else {
      expr.els.accept(this, env)
    }
  }

  override def visit(expr: Var, env: Environment): Value = {
    try {
      env.lookup(expr)
    } catch {
      case e: Exception => throw e
    }
  }

  override def visit(expr: Add, env: Environment): Value = {
    val lhsVal = expr.lhs.accept(this, env).toNum()
    val rhsVal = expr.rhs.accept(this, env).toNum()
    new NumValue(lhsVal + rhsVal)
  }
}
