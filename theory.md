# Software Development Practice

## Session 1
10.04.2025

- Introduction
- CORE
- Knowledge Quiz
- Setup IDE
    - Visual Studio Code (https://code.visualstudio.com/Download)
    - Java Development Kit (https://www.oracle.com/java/technologies/downloads/#java21)
    - Version Control System (https://git-scm.com/downloads)
    - Starting Visual Studio Code and installing Java Extensions
    - git clone https://github.com/hshdacs/SDP_S_2025_04
    - Open Folder SDP_S_2025_04
    - Open file Test.java and run (above main)

## Session 2
17.04.2025

- Fundamentals (of Programming)
    - Bit (Binary Digit, smallest representation of data)
    - Sequence of bits
        - Byte (8 bits, smallest element of a storage device, e.g. memory)
        - Word (16 bits)
        - Doubleword (32 bits)
        - Quadword (64 bits)
    - Capacity
        - Bytes
        - Kilobyte (1'024 bytes, because 2^10)
        - Megabyte (1'048'576 bytes, because 2^20)
        - Gigabyte (1'073'741'824 bytes, because 2^30)
        - Terabyte (2^40)
        - Petabyte (2^50)
        - Exabyte (2^60)
        - Zetabye (2^70)
    - Agreements of data to obtain information (Code)
        - ASCII (7 bit code) -> ANSI
        - ISO Latin-1 (8 bit code, but codepage required)
        - Unicode (16 bits, or 32 bits)
        - UTF-8 (variable length encoding)
    - Data types
        - boolean: true/false (1 bit, in real 32 bits)
        - byte (char C/C++): 8 bits
        - short (char Java, wchar_t C/C++): 16 bits
        - Integer (int): 32 bits
        - long: 64 bits
        - float (floating point): 32 bits
            (compound data type: significand precision:23, exponent:8, sign:1)
        - double: 64 bits (sp:52, exponent:11, sign:1)
    - Operation
        ```
        =,
        +, -, *, /, %,
        ++, --,
        += (a += 7 ==> a = a + 7), -=, ...
        &, |, ^, !, &&, ||,
        ==, !=, <=, >=,
        <<, >>
        ```
    - Some weirds thing in programming
        limited space for numbers, e.g. byte
        byte is a signed value of 8 bits,
        highest positive value is 0b0111'1111 (127)
        lowest negative value is  0b1000'0000 (-128)
    - Algorithm
        - Elements
            - Sequence
            - Condition (if, switch)
            - Loop (for, while, do-while)
        - Formalism
            - Pseudo Code
            - Flowchart
            - Nassi-Schneiderman Diagram
        - Example (Euclid, GCD)
            When (c,d) is not (a,b), and taken alternating (a,b) or (c,d) the
            smallest from the tallest, then it will eventually remain a number
            that measures both of the previous.