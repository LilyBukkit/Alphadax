package net.md_5.mendax.datainput;

import net.md_5.mendax.PacketDefinitions;
import net.md_5.mendax.PacketDefinitions.OpCode;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The packet reader
 */
public class DataInputPacketReader {

    /**
     * Array of possible Packet instruction combinations
     */
    private static final Instruction[][] instructions = new Instruction[256][];

    static {
        for (int i = 0; i < instructions.length; i++) {
            List<Instruction> output = new ArrayList<Instruction>();

            OpCode[] enums = PacketDefinitions.opCodes[i];
            if (enums != null) {
                for (OpCode struct : enums) {
                    try {
                        output.add((Instruction) Instruction.class.getDeclaredField(struct.name()).get(null));
                    } catch (Exception ex) {
                        throw new UnsupportedOperationException("No definition for " + struct.name());
                    }
                }

                List<Instruction> crushed = new ArrayList<Instruction>();
                int nextJumpSize = 0;
                for (Instruction child : output) {
                    if (child instanceof Jump) {
                        nextJumpSize += ((Jump) child).len;
                    } else {
                        if (nextJumpSize != 0) {
                            crushed.add(new Jump(nextJumpSize));
                        }
                        crushed.add(child);
                        nextJumpSize = 0;
                    }
                }
                if (nextJumpSize != 0) {
                    crushed.add(new Jump(nextJumpSize));
                }

                instructions[i] = crushed.toArray(new Instruction[0]);
            }
        }
    }

    /**
     * Reads a complete packet from the specified DataInput to a provided byte array
     *
     * @param in     the DataInput to read from
     * @param buffer the byte buffer to write to
     * @throws IOException if DataInput fails to read the specified {@link Instruction}
     */
    public static void readPacket(DataInput in, byte[] buffer) throws IOException {
        int packetId = in.readUnsignedByte();
        Instruction[] packetDef = instructions[packetId];

        if (packetDef == null) {
            throw new IOException("Unknown packet id " + packetId);
        }

        for (Instruction instruction : packetDef) {
            instruction.read(in, buffer);
        }
    }
}
