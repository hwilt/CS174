
/**
 * Purpose: To encrypt/decrypt text by XORing with a long
 *          stream of pseudorandom bits generated by an LFSR
 *
 * Author: @ctralie
 */
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.charset.*;

public class LFSR {

    public static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Load in a text file as a string. Use efficient reader with a particular
     * encoding
     *
     * @param filename Path to the file
     * @return A string with the file's contents
     */
    public static String loadFile(String filename) {
        String str = "";
        try {
            FileInputStream inputStream = new FileInputStream(filename);
            InputStreamReader reader = new InputStreamReader(inputStream, ENCODING);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder b = new StringBuilder();
            int c;
            while ((c = bufferedReader.read()) != -1) {
                b.append((char) c);
            }
            reader.close();
            str = b.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Save a string to a text file with a particular encoding
     *
     * @param filename Path to which to save the file
     * @param data The string to save
     */
    public static void saveToFile(String filename, String data) {
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, ENCODING);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert an into a string representing its bits
     *
     * @param x A 32-bit int
     * @return A 32-element binary string corresponding to this int
     */
    public static String getIntBitString(int x) {
        String answer = "";
        int count = 0;
        do {
            int temp = x & 1;
            answer = answer + temp;
            x = x >>> 1;
            count++;
        } while (x > 0);
        do {
            answer = "0" + answer;
        } while (answer.length() < 32);
        return answer;
    }

    /**
     * Convert an into a string representing its bits. This is an overloaded
     * version that takes only the first nbits bits
     *
     * @param x A 32-bit int
     * @param nbits The number of bits to take, starting at the right
     * @return An nbits-element binary string corresponding to this int
     */
    public static String getIntBitString(int x, int nbits) {
        int mask = 0;
        for (int place = 0; place < nbits; place++) {
            mask = mask | (1 << place);
        }
        String fmt = "%" + nbits + "s";
        return String.format(fmt, Integer.toBinaryString(x & mask)).replace(' ', '0');
    }

    /**
     * Pack groups of 4 bytes into an array of ints in little endian order
     *
     * @param barray
     * @return An int array with all of the info in the byte array
     */
    public static int[] byteArrayToIntArray(byte[] barray) {
        int N = (int) (Math.ceil(barray.length / 4.0));
        int[] iarray = new int[N];
        for (int i = 0; i < N; i++) {
            int x = 0;
            for (int k = 0; k < 4; k++) {
                int idx = i * 4 + k;
                if (idx < barray.length) {
                    x = x | (barray[idx] << (8 * k));
                }
            }
            iarray[i] = x;
        }
        return iarray;
    }

    /**
     * Extract the bytes from an int array in little endian order and copy them
     * over to a byte array
     *
     * @param iarray Array of ints
     * @return The corresponding byte array
     */
    public static byte[] intArrayToByteArray(int[] iarray) {
        int N = 4 * iarray.length;
        byte[] barray = new byte[N];
        for (int i = 0; i < iarray.length; i++) {
            for (int k = 0; k < 4; k++) {
                barray[i * 4 + k] = (byte) (iarray[i] >> (8 * k));
            }
        }
        return barray;
    }

    /**
     * Given the current state of a 32-bit LFSR and an array of the taps to use,
     * generate the next bit that will be generated by this LFSR
     *
     * @param lfsr The current state of the LFSR
     * @param taps The locations of the taps
     * @return Either a 1 or a 0
     */
    public static int getLFSRBit(int lfsr, int[] taps) {
        int bit = 0;
        // TODO: Fill this in
        for (int i = 0; i < taps.length; i++) {
            int nextNum = lfsr >>> taps[i] - 1;
            int bitEx = nextNum & 1;
            bit = (bit + bitEx) % 2;
        }

        return bit;
    }

    /**
     * Return the state of an LFSR after 32 new bits have been generated
     *
     * @param initial The state of the LFSR before this method
     * @param taps The locations of the taps
     * @return The LFSR after 32 new bits are generated
     */
    public static int cycleLFSRBy32Bits(int initial, int[] taps) {
        int lfsr = initial;
        // TODO: Fill this in
        for (int i = 0; i < 32; i++) {
            int bit = getLFSRBit(lfsr, taps);
            int numReplace = bit;
            lfsr = lfsr << 1;
            lfsr = lfsr | numReplace;
        }
        return lfsr;
    }

    /**
     * This method applies XOR encryption/decryption to all of the 32-bit
     * integer values in an input array Given the initial state of an LFSR and
     * the taps, generate a sequence of random ints that are XORed with each
     * input int and store that in an output array
     *
     * @param initial The state of the LFSR before this method
     * @param taps The locations of the taps
     * @param input An array of ints representing the message to encrypt or
     * decrypt
     * @return An array of ints representing the encrypted or decrypted message
     */
    public static int[] encryptDecryptIntArray(int initial, int[] taps, int[] input) {
        int[] output = new int[input.length];
        // TODO: Fill this in
        int newNum = cycleLFSRBy32Bits(initial, taps);
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i] ^ newNum;
            newNum = cycleLFSRBy32Bits(newNum, taps);
        }

        return output;
    }

    /**
     * This is a wrapper function that takes in a string, converts it to a
     * sequence of unicode bytes, converts those bytes to an int array, and
     * calls the student method for XOR encryption
     *
     * @param initial The state of the LFSR before this method
     * @param taps The locations of the taps
     * @param s The string to encrypt or decrypt
     * @return The encrypted or decrypted string
     */
    public static String encryptDecryptString(int initial, int[] taps, String s) {
        byte[] b = s.getBytes(ENCODING);
        int[] input = byteArrayToIntArray(b);
        int[] output = encryptDecryptIntArray(initial, taps, input);
        for (int i = 0; i < output.length; i++) {
            // To make sure unicode doesn't expand the byte count,
            // we insist that the 8th bit of every byte is zero
            output[i] = output[i] & 0x7F7F7F7F;
        }
        byte[] b2 = intArrayToByteArray(output);
        String res = new String(b2, ENCODING);
        return res;
    }

    /**
     * This is a wrapper function that reads in a text file as a string and
     * passes it along to the encryptDecryptString function
     *
     * @param filename Path to the file to encrypt/decrypt
     * @param initial The state of the LFSR before this method
     * @param taps The locations of the taps
     * @return
     */
    public static String decryptFile(String filename, int initial, int[] taps) {
        String s = loadFile(filename);
        return encryptDecryptString(initial, taps, s);
    }

    /**
     * This is a wrapper function that takes in a string and encrypts/decrypts
     * the result, and saves it to a file
     *
     * @param s The string to encrypt/decrypt
     * @param filename The path to which to save the result
     * @param initial The state of the LFSR before this method
     * @param taps The locations of the taps
     * @return The encrypted string
     */
    public static String encryptDecryptStringAndSave(String s, String filename, int initial, int[] taps) {
        String encrypted = encryptDecryptString(initial, taps, s);
        saveToFile(filename, encrypted);
        return encrypted;
    }

    public static void main(String[] args) {
        int[] taps = {1, 3, 5, 6, 7, 9, 10, 32};
        int initial = 174;
        String encrypted = "YI9Y=^\\:Vp*;y0W\\-^Aly4/";
        System.out.println(encryptDecryptString(initial, taps, encrypted));
    }
}
