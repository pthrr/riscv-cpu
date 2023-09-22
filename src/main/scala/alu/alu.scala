package alu

import chisel3._

import cpu.Constants._

class ALU(width_ops: Int, width_sel: Int) extends Module {
  val io = IO(new Bundle {
    val op1 = Input(UInt(width_ops.W))
    val op2 = Input(UInt(width_ops.W))
    val sel = Input(UInt(width_sel.W))
    val out = Output(UInt(width_ops.W))
  })

  when(io.sel === ALU_OP_ADD) {
    io.out := io.op1 + io.op2
  }.elsewhen(io.sel === ALU_OP_SUB) {
    io.out := io.op1 - io.op2
  }.elsewhen(io.sel === ALU_OP_AND) {
    io.out := io.op1 & io.op2
  }.elsewhen(io.sel === ALU_OP_OR) {
    io.out := io.op1 | io.op2
  }.elsewhen(io.sel === ALU_OP_XOR) {
    io.out := io.op1 ^ io.op2
  }.otherwise {
    io.out := DontCare
  }
}
