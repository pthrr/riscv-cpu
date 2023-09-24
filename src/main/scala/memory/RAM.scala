package memory

import chisel3._
import chisel3.util._

class RAM(depth: Int, width: Int) extends Module {
    val io = IO(new Bundle {
        val addr = Input(UInt(log2Ceil(depth).W))
        val writeData = Input(UInt(width.W))
        val writeEnable = Input(Bool())
        val readData = Output(UInt(width.W))
    })

    val mem = SyncReadMem(depth, UInt(width.W))

    when(io.writeEnable) {
        mem.write(io.addr, io.writeData)
    }

    io.readData := mem.read(io.addr, io.writeEnable)
}
