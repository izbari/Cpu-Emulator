# Cpu-Emulator

There is an array of 8 in the cell where I got the memory as 16x16.
It makes 16x16x8 bits, that is, 256 bytes. This is how I designed it.

The value part of the instruction set (STORE 200') is converted to binary when looking at the first input and the information is made in binary.
I didn't keep an int, I kept an 8-bit binary.

I limited it because 8 bits can hold up to 255 max, it gives an error message and does System.exit().

You can run it from the command line like this;

java main inputPath
