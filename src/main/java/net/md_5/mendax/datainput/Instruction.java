package net.md_5.mendax.datainput;

import java.io.DataInput;
import java.io.IOException;

abstract class Instruction {

    static final Instruction BOOLEAN = new Jump(1);
    static final Instruction BULK_CHUNK = new BulkChunk();
    static final Instruction BYTE = new Jump(1);
    // BYTE_INT moved down
    static final Instruction DOUBLE = new Jump(8);
    static final Instruction FLOAT = new Jump(4);
    static final Instruction INT = new Jump(4);
    static final Instruction INT_3 = new IntHeader(new Jump(3));
    static final Instruction INT_BYTE = new IntHeader(BYTE);
    static final Instruction ITEM = new Item();
    static final Instruction LONG = new Jump(8);
    static final Instruction METADATA = new MetaData();
    static final Instruction OPTIONAL_MOTION = new OptionalMotion();
    static final Instruction SHORT = new Jump(2);
    static final Instruction SHORT_BYTE = new ShortHeader(BYTE);
    static final Instruction SHORT_ITEM = new ShortHeader(ITEM);
    static final Instruction STRING = new ShortHeader(new Jump(2));
    static final Instruction USHORT_BYTE = new UnsignedShortByte();
    // Illegal forward references below this line
    static final Instruction BYTE_INT = new ByteHeader(INT);

    // Nebula start
    static final Instruction SHORT_SHORT = new ShortHeader(SHORT); //Short, followed by an array of shorts
    static final Instruction ULPP_EXTENSION = new ULPPExtension(); //Single ULPP Extension
    static final Instruction SHORT_ULPP = new ShortHeader(ULPP_EXTENSION); //Short, followed by an array of ULPP Extensions
    static final Instruction BYTE_BYTE = new ByteHeader(BYTE); //Byte, followed by an array of bytes
    static final Instruction NBT = new NBT(); //NBTTagCompound representation (TODO)
    static final Instruction SHORT_NBT = new ShortHeader(NBT); //Short, followed by NBTTagCompounds
    // Nebula end

    abstract void read(DataInput in, byte[] buffer) throws IOException;

    final void skip(DataInput in, byte[] buffer, int len) throws IOException {
        in.readFully(buffer, 0, len);
    }
}
