package memory

import common.Constants._

import chiseltest._
import chiseltest.ChiselScalatestTester
import chisel3._
// import chisel3.tester._
// import org.scalatest._

import org.scalatest.flatspec.AnyFlatSpec

class ROMSpec extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ROM"

  it should "provide correct data for given address" in {
    test(new ROM(4, 32, Seq(10.U, 20.U, 30.U, 40.U))) { dut =>
      dut.io.addr.poke(1.U)
      dut.clock.step()
      dut.io.readData.expect(20.U)

      dut.io.addr.poke(2.U)
      dut.clock.step()
      dut.io.readData.expect(30.U)
    }
  }
}
