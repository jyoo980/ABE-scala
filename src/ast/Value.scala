package ast

abstract class Value {

  abstract def toNum(): Int
  abstract def toBool(): Boolean
}
