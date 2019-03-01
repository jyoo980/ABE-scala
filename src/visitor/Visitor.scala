package visitor

import ast.{Add, If, Num, Var}

trait Visitor[X, R] {

  def visit(expr: Num, param: R): X
  def visit(expr: If, param: R): X
  def visit(expr: Var, param: R): X
  def visit(expr: Add, param: R): X
}
