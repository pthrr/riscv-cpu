package memory

import chisel3._
import chisel3.util._

class ROM(depth: Int, width: Int, content: Seq[UInt]) extends Module {
    val io = IO(new Bundle {
        val addr = Input(UInt(log2Ceil(depth).W))
        val readData = Output(UInt(width.W))
    })

    val rom = VecInit(content)
    io.readData := rom(io.addr)
}
