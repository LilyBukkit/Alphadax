package net.md_5.mendax;

import static net.md_5.mendax.PacketDefinitions.OpCode.*;

public class PacketDefinitions {

    /**
     * An array of existing packets and their Instructions
     */
    public static final OpCode[][] opCodes = new OpCode[256][];

    public enum OpCode {

        BOOLEAN, BULK_CHUNK, BYTE, BYTE_INT, DOUBLE, FLOAT, INT, INT_3, INT_BYTE, ITEM, LONG, METADATA, OPTIONAL_MOTION, SHORT, SHORT_BYTE, SHORT_ITEM, STRING, USHORT_BYTE
    }

    static {
        opCodes[0x00] = new OpCode[]{}; // Packet0KeepAlive
        opCodes[0x01] = new OpCode[]{STRING, STRING, INT}; // Packet1Login
        opCodes[0x02] = new OpCode[]{STRING}; // Packet2Handshake
        opCodes[0x03] = new OpCode[]{STRING}; // Packet3Chat
        opCodes[0x04] = new OpCode[]{SHORT_ITEM}; // Packet5PlayerInventory
        opCodes[0x06] = new OpCode[]{INT, INT, INT}; // Packet6SpawnPosition
        //
        //
        // 0x07 -> 0x09 Do not exist
        //
        //
        opCodes[0x0A] = new OpCode[]{INT}; // Packet10Flying
        opCodes[0x0B] = new OpCode[]{DOUBLE, DOUBLE, DOUBLE, DOUBLE}; // Packet11PlayerPosition
        opCodes[0x0C] = new OpCode[]{FLOAT, FLOAT}; // Packet12PlayerLook
        opCodes[0x0D] = new OpCode[]{DOUBLE, DOUBLE, DOUBLE, DOUBLE, FLOAT, FLOAT}; // Packet13PlayerLookMove
        opCodes[0x0E] = new OpCode[]{INT, INT, INT, INT, INT}; // Packet14BlockDig
        opCodes[0x0F] = new OpCode[]{SHORT, INT, INT, INT, INT}; // Packet15Place
        opCodes[0x10] = new OpCode[]{INT, SHORT}; // Packet16BlockItemSwitch
        opCodes[0x11] = new OpCode[]{SHORT, BYTE, SHORT}; // Packet17AddToInventory
        opCodes[0x12] = new OpCode[]{INT, BYTE}; // Packet18ArmAnimation
        //
        // 0x13 Does not exist
        //
        opCodes[0x14] = new OpCode[]{INT, STRING, INT, INT, INT, BYTE, BYTE, SHORT}; // Packet20NamedEntitySpawn
        opCodes[0x15] = new OpCode[]{INT, SHORT, BYTE, INT, INT, INT, BYTE, BYTE, BYTE}; // Packet21PickupSpawn
        opCodes[0x16] = new OpCode[]{INT, INT}; // Packet22Collect
        opCodes[0x17] = new OpCode[]{INT, BYTE, INT, INT, INT}; // Packet23VehicleSpawn
        opCodes[0x18] = new OpCode[]{INT, BYTE, INT, INT, INT, BYTE, BYTE}; // Packet24MobSpawn
        //
        //
        // 0x19 -> 0x1C Do not exist
        //
        //
        opCodes[0x1D] = new OpCode[]{INT}; // Packet29DestroyEntity
        opCodes[0x1E] = new OpCode[]{INT}; // Packet30Entity
        opCodes[0x1F] = new OpCode[]{INT, BYTE, BYTE, BYTE}; // Packet31RelEntityMove
        opCodes[0x20] = new OpCode[]{INT, BYTE, BYTE}; // Packet32EntityLook
        opCodes[0x21] = new OpCode[]{INT, BYTE, BYTE, BYTE, BYTE, BYTE}; // Packet33RelEntityMoveLook
        opCodes[0x22] = new OpCode[]{INT, INT, INT, INT, BYTE, BYTE}; // Packet34EntityTeleport
        opCodes[0x23] = new OpCode[]{INT, INT, BOOLEAN}; // Packet35EntityDamage
        //
        //
        // 0x24 -> 0x31 Do not exist
        //
        //
        opCodes[0x32] = new OpCode[]{INT, INT, INT}; // Packet50PreChunk
        opCodes[0x33] = new OpCode[]{INT, SHORT, INT, INT, INT, INT, INT}; // Packet51MapChunk
        opCodes[0x34] = new OpCode[]{INT, INT, SHORT, SHORT/*ARRAY*/, BYTE/*ARRAY*/, METADATA}; // Packet52MultiBlockChange
        opCodes[0x35] = new OpCode[]{INT, INT, INT, INT, METADATA}; // Packet53BlockChange
        //
        //
        // 0x36 -> 0x3A Do not exist
        //
        //
        opCodes[0x3B] = new OpCode[]{INT, SHORT, INT, SHORT, BYTE/*ARRAY*/}; // Packet59ComplexEntity
        //
        //
        // 0x3C -> 0x80 Do not exist
        //
        //
        opCodes[0x81] = new OpCode[]{}; // Packet129ULPPLoggedIn
        opCodes[0x82] = new OpCode[]{STRING, STRING, STRING, SHORT_HEADER, /*ULPP_EXTENSION_ARRAY,*/ LONG}; // Packet130RosepadMeta
        //
        //
        // 0x83 -> 0xFE Do not exist
        //
        //
        opCodes[0xFF] = new OpCode[]{STRING}; // Packet255KickDisconnect
    }
}
