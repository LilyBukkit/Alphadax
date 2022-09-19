package net.md_5.mendax.datainput;

import java.io.DataInput;
import java.io.IOException;

/**
 * Represents a segment that starts with a short (usually indicating the incoming array size) followed by an array of "child" segments
 */
class ShortHeader extends Instruction {

    private final Instruction child;

    ShortHeader(Instruction child) {
        this.child = child;
    }

    @Override
    void read(DataInput in, byte[] buffer) throws IOException {
        short size = in.readShort();
        for (short s = 0; s < size; s++) {
            child.read(in, buffer);
        }
    }
}
