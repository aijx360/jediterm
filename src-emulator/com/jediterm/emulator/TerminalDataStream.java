package com.jediterm.emulator;

import java.io.IOException;

/**
 * Represents data communication interface for terminal.
 * It allows to {@link #getChar()} by one and {@link #pushChar(char)} back as well as requesting a chunk of plain ASCII
 * characters ({@link #advanceThroughASCII(int)} - for faster processing from buffer in the size <=<b>maxChars</b>).
 *
 * Also it can {@link #sendBytes(byte[])} as a response from the terminal emulator.
 *
 * @author traff
 */
public interface TerminalDataStream {
  char getChar() throws IOException;

  void pushChar(char c) throws IOException;

  CharacterUtils.CharArraySlice advanceThroughASCII(int maxChars) throws IOException;

  void sendBytes(byte[] response) throws IOException;

  void pushBackBuffer(char[] bytes, int length) throws IOException;

  class EOF extends IOException {
    public EOF() {
      super("EOF: There is no more data or connection is lost");
    }
  }
}