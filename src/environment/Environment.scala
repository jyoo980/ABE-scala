package environment

import ast.{Value, Var}

import scala.collection.mutable

class Environment(var table: mutable.HashMap[Var, Value]) {

  def this(currentEnv: Environment, name: Var, value: Value) = this {
    val newTable = new mutable.HashMap[Var, Value]()
    for ((k, v) <- this.table) newTable.put(k, v)
    this.table = newTable
    return this
  }

  def extend(name: Var, value: Value): Environment = {
    new Environment(this, name, value)
  }

  def lookup(name: Var): Value = {
    if (this.table.contains(name)) {
      this.table.get(name)
    }
    throw new Error("Unbound identifier: " + name.name)
  }

}
