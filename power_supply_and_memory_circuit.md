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

## Explanation of the Oscillator (Blinking LED) Circuit

The circuit shown is an **astable multivibrator**, which means it has no stable state and continuously oscillates. This oscillation is what causes the two LEDs (D1 and D2) to blink on and off alternately. It is not a memory circuit (a bistable multivibrator), which would have two stable states.

### How the Voltage Moves

1.  **Power On & Initial State:** When the circuit is first powered with 10V DC from the power supply section, tiny manufacturing differences in the components mean one of the two identical transistors (Q1 and Q2) will turn on slightly faster than the other. Let's assume Q1 turns on first.

2.  **Q1 Turns ON, Q2 Turns OFF:**
    *   As Q1 turns on, current flows through resistor R1 and LED D1, causing **D1 to light up**.
    *   The voltage at the collector of Q1 drops to nearly 0V. This sharp drop in voltage is transferred through capacitor C1 to the base of transistor Q2. This negative-going voltage pulse forces Q2 to turn **OFF**.
    *   Since Q2 is off, no current can flow through R2 and D2, so **D2 remains off**.

3.  **Capacitor Charging & The Switch:**
    *   While Q2 is off, its collector voltage is high (close to 10V). Capacitor C2 begins to charge up through resistor R4. The current flowing through R4 to charge C2 also flows into the base of Q1, keeping it firmly turned on.
    *   At the same time, capacitor C1, which is holding Q2 off, starts to charge through resistor R3 from the 10V supply line. As C1 charges, the voltage at the base of Q2 slowly rises from a negative value.
    *   Once the voltage at the base of Q2 reaches about 0.7V (the turn-on voltage for a transistor), Q2 suddenly switches **ON**.

4.  **The Flip:** The circuit now flips its state.
    *   As Q2 turns on, current flows through R2 and **D2 lights up**.
    *   The voltage at the collector of Q2 drops to near 0V. This voltage drop is passed through capacitor C2 to the base of Q1, forcing **Q1 to turn OFF**.
    *   Since Q1 is now off, **D1 turns off**.

5.  **Cycle Repeats:** The circuit is now in the opposite state (Q1 is off, Q2 is on). The process repeats in reverse: C1 charges through R3, C2 charges through R4, and eventually, the voltage at the base of Q1 will rise enough to turn it on again, forcing Q2 off.

This cycle of flipping between states continues indefinitely, causing the voltage to shift back and forth between the two transistors and making the LEDs blink on and off alternately. The speed of the blinking is determined by the values of the resistors (R3, R4) and capacitors (C1, C2).
