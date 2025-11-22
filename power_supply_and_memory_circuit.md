# Power Supply and Memory Circuit Explained

## Block Diagram of a Computer Power Supply

A computer power supply unit (PSU) converts the alternating current (AC) from a wall outlet to the direct current (DC) needed by the computer's components. This process can be broken down into four main stages, as shown in the block diagram below.

```
+-----------+    +-----------+    +-----------+    +------------+
|           |    |           |    |           |    |            |
| Transformer+----> Rectifier +---->  Filter   +----> Regulator  +----> To Computer Components
|           |    |           |    |           |    |            |
+-----------+    +-----------+    +-----------+    +------------+
  (Input: AC)    (Output: Pulsating DC) (Output: Smoothed DC) (Output: Regulated DC)
```

### Explanation of Each Block Stage

1.  **Transformer:** The first stage is the transformer, which steps down the high-voltage AC from the mains (e.g., 220V or 110V) to a much lower AC voltage. This is necessary because the computer's components operate on low DC voltages.

2.  **Rectifier:** The low-voltage AC is then fed into a rectifier, which converts it into a pulsating DC voltage. The most common type of rectifier is a full-wave bridge rectifier, which uses four diodes to convert both the positive and negative cycles of the AC waveform into a single DC waveform.

3.  **Filter:** The pulsating DC from the rectifier is not yet suitable for powering sensitive electronic components. The filter stage smooths out the pulsating DC into a more constant DC voltage. This is typically done using one or more large capacitors, which charge up when the voltage is high and discharge when the voltage is low, thus filling in the gaps in the waveform.

4.  **Regulator:** The final stage is the regulator, which ensures that the output DC voltage remains constant, regardless of changes in the input voltage or the load on the power supply. This is crucial for the stable operation of the computer's components.

## Vero Board Layout for the Memory Circuit

Here is a possible layout for the memory circuit on a stripped Vero board. The layout has been designed to be as compact and easy to follow as possible.

```
     1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0
   +---------------------------------------+
 A | +v o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o |
 B | o o o o o o o o o o o o o o o o o o o o |
 C | o o-o R5 o-o D3 o-o-o-o-o-o-o-o-o-o-o-o |
 D | o o o | o o | o o o o o o o o o o o o o |
 E | o o-o-o-o-o-o-o C4 o-o-o-o-o-o-o-o-o-o |
 F | o o o o o o o o | o o o o o o o o o o o |
 G | o o o-o R1 o-o D1 o-o-o-o-o-o-o-o-o-o-o |
 H | o o o o | o o | o o o o o o o o o o o o |
 I | o o-o-o C1 o-o Q1 o-o-o-o-o-o-o-o-o-o-o |
 J | o o o o | o o | o o o o o o o o o o o o |
 K | o o o-o-o-o-o-o-o R3 o-o-o-o-o-o-o-o-o-o |
 L | o o o o o o o o o | o o o o o o o o o o |
 M | o o o-o R2 o-o D2 o-o-o-o-o-o-o-o-o-o-o |
 N | o o o o | o o | o o o o o o o o o o o o |
 O | o o-o-o C2 o-o Q2 o-o-o-o-o-o-o-o-o-o-o |
 P | o o o o | o o | o o o o o o o o o o o o |
 Q | o o o-o-o-o-o-o-o R4 o-o-o-o-o-o-o-o-o-o |
 R | o o o o o o o o o | o o o o o o o o o o |
 S | 0v o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o |
   +---------------------------------------+
```

**Key:**

*   `o`: Hole in the Vero board
*   `-`: Copper track
*   `+v`: Positive voltage rail
*   `0v`: Ground rail
*   `R1-R5`: Resistors
*   `C1-C4`: Capacitors
*   `D1-D3`: Diodes/LEDs
*   `Q1-Q2`: Transistors

## Explanation of the Memory Circuit

The memory circuit is a bistable multivibrator, also known as a flip-flop. It is a circuit that has two stable states and can be used to store one bit of information. The circuit consists of two cross-coupled transistors, Q1 and Q2.

### How the Voltage Moves

1.  **Power On:** When the circuit is first powered on, one of the transistors will inevitably turn on slightly faster than the other due to small variations in the components. Let's assume that Q1 turns on first.

2.  **Q1 Turns On:** As Q1 turns on, its collector voltage drops. This drop in voltage is coupled through capacitor C1 to the base of Q2, which causes Q2 to turn off.

3.  **Q2 Turns Off:** As Q2 turns off, its collector voltage rises. This rise in voltage is coupled through capacitor C2 to the base of Q1, which causes Q1 to turn on even harder.

4.  **Stable State:** This process continues until Q1 is fully on (saturated) and Q2 is fully off. This is a stable state, and the circuit will remain in this state until it is disturbed. In this state, LED D1 will be off and LED D2 will be on.

5.  **Changing State:** The state of the circuit can be changed by applying a trigger pulse to the base of the "off" transistor. For example, if we apply a positive pulse to the base of Q2, it will start to turn on. This will cause Q1 to turn off, and the circuit will flip into the opposite stable state, with Q2 on and Q1 off. In this state, LED D1 will be on and LED D2 will be off.
