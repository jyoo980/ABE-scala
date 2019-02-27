package visitor

import ast.{If, Num}

trait Visitor[X, R] {

  def accept(expr: Num, param: R): X
  def accept(expr: If, param: R): X
}
