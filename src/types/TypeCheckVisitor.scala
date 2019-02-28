package types

import ast.{If, Num, Var}
import environment.Environment
import types.Type.Type
import visitor.Visitor

class TypeCheckVisitor extends Visitor[Type, Environment] {

  override def visit(expr: Num, param: Environment): Type = {
    Type.INT
  }

  override def visit(expr: If, param: Environment): Type = {
    val predType = expr.pred.accept(this, param)
    if (predType != Type.BOOL) {
      throw new Error("Predicate is not of Type BOOL")
    }
    val thnType = expr.thn.accept(this, param)
    val elsType = expr.thn.accept(this, param)
    if (thnType == elsType) {
       return thnType
    }
    throw new Error("Branch Types Mismatch")
  }

  override def visit(expr: Var, param: Environment) = ???
}
