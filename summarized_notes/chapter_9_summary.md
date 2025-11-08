# Chapter 9: Wide Area Network (WAN)

## Detailed Summary

This chapter explores Wide Area Networks (WANs), which are used to interconnect geographically dispersed LANs. Unlike LANs, which are owned by an organization, WAN infrastructure is typically owned and managed by service providers or carriers.

### 1. WAN and Enterprise Networks

WANs are essential for modern businesses to connect main offices, branch offices, remote workers, and business partners.

-   **Service-Level Agreement (SLA):** A formal contract between a WAN provider and a customer that specifies performance guarantees for data rate, latency, reliability, and availability.
-   **CPE vs. SPF:**
    -   **Customer Premises Equipment (CPE):** Networking equipment that resides at the customer's site (e.g., routers, modems, CSU/DSU).
    -   **Service Provider Facility (SPF):** The carrier's infrastructure, including local access lines and the backbone network.
-   **Demarcation Point:** The physical point where the CPE meets the SPF, defining the boundary of responsibility for maintenance.

### 2. WAN Technologies: Layers and Switching Methods

WAN standards primarily operate at the **Physical (Layer 1)** and **Data Link (Layer 2)** layers.

-   **Circuit Switching:** A dedicated end-to-end circuit with reserved bandwidth is established for the duration of a session. It's reliable but inefficient, as the capacity is reserved even when not in use. **Leased lines** are a prime example.
-   **Packet Switching:** Data is broken into packets that are transmitted independently over a shared network. It's highly efficient but offers no performance guarantees by default. This is the basis for **Packet Switched Data Networks (PSDNs)** and the Internet.
    -   **Virtual Circuit (VC):** A logical end-to-end path established through a packet-switched network. Unlike a physical circuit, it does not reserve bandwidth but predetermines the path packets will follow through the carrier's switches.

### 3. Leased Lines (Physical Layer)

A leased line is a private, point-to-point connection with dedicated bandwidth, offering high reliability and performance at a high cost.

-   **T-Carrier/E-Carrier:** Digital leased line standards.
    -   **T1 (North America):** Offers a speed of **1.544 Mbps**.
    -   **T3:** Offers a speed of **44.7 Mbps**.
-   **SONET/SDH:** A very high-speed fiber-optic leased line standard, often used for carrier backbone networks, with speeds defined by the **Optical Carrier (OC)** hierarchy (e.g., OC-3 at 155 Mbps, OC-192 at 10 Gbps).

-   **Point-to-Point Protocol (PPP):** A common Data Link layer protocol used to transport IP packets over leased lines. It includes features for router authentication using **PAP** or the more secure **CHAP**.

### 4. Packet Switched Data Networks (PSDNs) (Data Link Layer)

PSDNs offer a more flexible and cost-effective alternative to leased lines by using a shared network cloud.

-   **Frame Relay:** A popular and cost-effective PSDN technology.
    -   It uses PVCs (Permanent Virtual Circuits) to forward frames.
    -   Each VC is identified by a **Data Link Connection Identifier (DLCI)**, which is a locally significant number that tells the carrier's switches how to forward the frame to the next hop.
-   **Asynchronous Transfer Mode (ATM):** A high-speed PSDN technology that uses fixed-size 53-byte frames called **cells**. Its fixed cell size makes it very efficient for real-time traffic like voice and video, and it has strong **Quality of Service (QoS)** capabilities.
-   **Carrier Ethernet:** Extends Ethernet technology from the LAN to the WAN. It offers a cost-effective, scalable, and high-bandwidth WAN service that is familiar to network administrators.
-   **Multi-Protocol Label Switching (MPLS):** A highly popular and advanced WAN technology.
    -   It is often called a "Layer 2.5" technology. It forwards IP packets based on a short **label** attached to the packet, rather than by performing a full IP routing lookup at every hop.
    -   This "label switching" is much faster than traditional routing and allows for powerful **traffic engineering** and QoS.

### 5. Wireless WAN: Cellular Networks

Cellular networks have evolved to become a dominant platform for both voice and high-speed data.

-   **Architecture:**
    -   Service areas are divided into **cells**, each served by a **Base Station (BS)**.
    -   Base Stations connect to a **Mobile Terminal Switching Office (MTSO)**, which manages calls, handoffs, and connects to the wider telephone network and Internet.
-   **Generations:**
    -   **1G:** Analog voice.
    -   **2G:** Digital voice and slow data (GSM, CDMA).
    -   **3G:** Faster data, enabling mobile internet (UMTS).
    -   **4G (LTE - Long-Term Evolution):** A high-speed, IP-based packet-switched network for both data and, increasingly, voice (VoLTE). It uses **OFDMA** for multiple access.
-   **Future (5G):** Promises dramatically higher speeds, lower latency, and the capacity to support emerging technologies like IoT and self-driving cars.

---

## Answers to In-Chapter Exercises

### Exercise 9.1

1.  **Mapping Tables for R2 and R3:**
    -   **R2 (Branch 1) Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 10.10.10.1     | VC2         | S0/0/0.10      |
        | 192.168.10.2   | VC5         | S0/0/0.20      |
    -   **R3 (Branch 2) Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC4         | S0/0/0.10      |
        | 192.168.10.1   | VC6         | S0/0/0.20      |
2.  **Total VCs for full mesh:** To fully connect 3 locations, you need a VC in each direction between each pair. 3 pairs * 2 directions = **6 VCs**.

### Exercise 9.2

1.  **Mapping Tables for R1, R2, R3 (Single Subnet):**
    -   **R1 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.2    | VC1         | S0/0/0         |
        | 172.16.10.3    | VC3         | S0/0/0         |
    -   **R2 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC2         | S0/0/0         |
        | 172.16.10.3    | VC5         | S0/0/0         |
    -   **R3 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC4         | S0/0/0         |
        | 172.16.10.2    | VC6         | S0/0/0         |
2.  **Total VCs:** Still **6 VCs** are needed for a full mesh.

### Exercise 9.3

The physical link at the Houston location must have a data rate at least equal to the sum of the committed speeds of all the PVCs running over it.
-   Minimum Data Rate = 1.5 Mbps + 2.0 Mbps + 1.0 Mbps = **4.5 Mbps**.

---

## Answers to End-of-Chapter Review Questions

1.  An SLA may include **A. minimum latency**.
2.  **E. A carrier may offer Frame Relay service on its ATM backbone cloud.** is a CORRECT statement.
3.  The **E. border router** is a CPE.
4.  **A. While 4G uses packet switching, 2G and 3G depend on circuit switching...** is a key difference.
5.  The demarcation point is where **C. the CPE meets the SPF**.
6.  **B. The cellular network takes advantage of high radio frequency ranges such as UHF and SHF.** is CORRECT.
7.  **D. The demarcation point of the WAN service is located at the POP.** is INCORRECT. The demarcation point is at the customer premise.
8.  **C. ATM** defines several classes of QoS.
9.  Technical details of leased lines are defined in the **E. physical** layer.
10. The PVC is **E. set up by a carrier in its WAN cloud**.
11. SONET/SDH generally adopts the **B. dual-ring** architecture.
12. **B. The carrier provides VCIs (meaning DLCIs) to business customers for the customer site setup.** is CORRECT.
13. SONET determines its bandwidth according to the **D. OC** speed hierarchy.
14. An end-to-end VC is made up of multiple local VCs (DLCIs). A frame will have a different DLCI on each link: Dallas->Switch, Switch->Switch, Switch->Toronto. So, at least **C. 3** different VCIs/DLCIs would be used.
15. The DLCI is a **A. virtual circuit number**.
16. **E. MPLS supports load balancing that moves traffic from congested links to less-congested ones.** is an ACCURATE statement.
17. **B. The cell is equally sized regardless of its location...** is FALSE. Cells are smaller in cities and larger in rural areas.
18. Carriers are NOT responsible for **B. QoS guarantees for all WAN services**. QoS is a premium feature, not standard on all services.
19. Service classes of CBR and VBR are available in **C. ATM**.
20. **B. It can carry Frame Relay frames.** is CORRECT regarding the T-carrier service.
21. **B. PPP** is a point-to-point protocol for leased lines, which are circuit-switched, not packet-switched.
22. **A. Traffic engineering blocks certain IP packets...** is INCORRECT. Traffic engineering is about directing traffic along specific paths, not blocking it.
23. **A. Transmission capacity can be better tailored to client needs by the PSDN service.** is CORRECT.
24. CHAP is a part of the **B. PPP** standard.
25. For 3 sites, you need 3 pairs of connections (A-B, A-C, B-C). Each connection is a PVC. So, **C. Three** PVCs for a full mesh. If the question implies one PVC per direction, the answer would be 6. Given the options, 3 is the most likely intended answer representing the bidirectional links.
