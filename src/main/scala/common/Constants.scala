package common

import chisel3._
import chisel3.util._

object Constants {
  val CPU_LEN_WORD = 32

  val ALU_LEN_SEL = 4
  val ALU_OP_NOP = 0.U(ALU_LEN_SEL.W)
  val ALU_OP_ADD = 1.U(ALU_LEN_SEL.W)
  val ALU_OP_SUB = 2.U(ALU_LEN_SEL.W)
  val ALU_OP_AND = 3.U(ALU_LEN_SEL.W)
  val ALU_OP_OR = 4.U(ALU_LEN_SEL.W)
  val ALU_OP_XOR = 5.U(ALU_LEN_SEL.W)
  val ALU_OP_SLL = 6.U(ALU_LEN_SEL.W)
  val ALU_OP_SRL = 7.U(ALU_LEN_SEL.W)
  val ALU_OP_SRA = 8.U(ALU_LEN_SEL.W)
  val ALU_OP_SLT = 9.U(ALU_LEN_SEL.W)
  val ALU_OP_SLTU = 10.U(ALU_LEN_SEL.W)
  val ALU_OP_JALR = 12.U(ALU_LEN_SEL.W)
  val ALU_OP_RS1 = 13.U(ALU_LEN_SEL.W)
}
