import alu.ALU
import cpu.Constants._

import chiseltest._
import chiseltest.ChiselScalatestTester

import org.scalatest.flatspec.AnyFlatSpec

class ALUSpec extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ALU"

  it should "perform addition correctly" in {
    test(new ALU(32, 4)) { dut =>
      dut.io.op1.poke(5)
      dut.io.op2.poke(7)
      dut.io.sel.poke(ALU_OP_ADD)
      dut.io.out.expect(12)
    }
  }
}
