package memory

import chisel3._
// import chisel3.tester._

import chiseltest._
import chiseltest.ChiselScalatestTester
// import org.scalatest._

import org.scalatest.flatspec.AnyFlatSpec

class RAMSpec extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "RAM"

  it should "read and write correctly" in {
    test(new RAM(256, 32)) { dut =>
      dut.io.writeEnable.poke(false.B)
      dut.io.addr.poke(5.U)
      dut.clock.step()

      dut.io.writeEnable.poke(true.B)
      dut.io.addr.poke(5.U)
      dut.io.writeData.poke(12345678.U)
      dut.clock.step()

      dut.io.writeEnable.poke(false.B)
      dut.clock.step()

      dut.io.readData.expect(12345678.U)
    }
  }
}
