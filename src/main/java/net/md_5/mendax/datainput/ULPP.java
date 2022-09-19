package net.md_5.mendax.datainput;

import java.io.DataInput;
import java.io.IOException;

/**
 * Represents a ULPPExtension segment of Packet130RosepadMeta
 *
 * @author VladTheMountain
 */
public class ULPP extends Instruction {
    void read(DataInput in, byte[] buffer) throws IOException {
        STRING.read(in, buffer); //name
        INT.read(in, buffer); //version
    }
}
