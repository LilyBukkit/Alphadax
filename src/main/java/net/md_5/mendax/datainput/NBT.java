package net.md_5.mendax.datainput;

import java.io.DataInput;
import java.io.IOException;

public class NBT extends Instruction {
    void read(DataInput in, byte[] buffer) throws IOException {
        skip(in, buffer, 1);
    }
}
