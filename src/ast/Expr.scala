package ast

import visitor.Visitor

abstract class Expr {

  abstract def accept[X, R](v: Visitor[X, R], p: R): X
}
