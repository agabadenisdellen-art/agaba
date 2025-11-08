# Chapter 7: Ethernet LAN

## Detailed Summary

This chapter focuses on Ethernet, the dominant wired LAN technology. It covers the structure of an Ethernet frame, modern hierarchical design principles, and advanced switching technologies like Spanning Tree Protocol (STP), Link Aggregation, and Virtual LANs (VLANs).

### 1. Standard Layers and Ethernet Frame

-   **Standard Layers:** Ethernet operates at the Physical (Layer 1) and Data Link (Layer 2) layers. The Data Link layer is subdivided into:
    -   **Logical Link Control (LLC):** Provides an interface to the network layer above (Layer 3).
    -   **Media Access Control (MAC):** Responsible for framing and media access (e.g., CSMA/CD in legacy hub networks).
-   **Ethernet Frame Structure:** An Ethernet frame encapsulates an IP packet and adds a header and trailer. Key fields include:
    -   **Preamble & Start Frame Delimiter:** Used for clock synchronization.
    -   **Source & Destination MAC Addresses:** 48-bit hardware addresses for intra-network communication.
    -   **Data:** The payload, which contains the IP packet (typically 46 to 1500 bytes).
    -   **Frame Check Sequence (FCS):** A value calculated using **Cyclic Redundancy Check (CRC)** to detect transmission errors.

### 2. Ethernet LAN Design

Modern Ethernet LANs have moved from a simple, flat design to a more scalable hierarchical model.

-   **Flat Design:** All switches are interconnected on a single tier. Simple for small networks but becomes unmanageable and inefficient as the network grows.
-   **Hierarchical Design:** A structured, multi-tiered model that improves performance, scalability, and management.
    -   **Access Layer:** The layer where end devices (PCs, printers, IP phones) connect to the network, typically via **access switches**.
    -   **Distribution Layer:** Aggregates traffic from the access layer switches and provides connectivity to the core. This is often where policy enforcement and inter-VLAN routing occur.
    -   **Core Layer:** The high-speed backbone of the network, responsible for forwarding large amounts of traffic quickly between distribution layer devices. Provides redundant paths for high availability.

### 3. Spanning Tree Protocol (STP)

-   **Problem:** In a switched network, creating redundant physical links for fault tolerance can lead to **switching loops**. A loop causes broadcast frames to circulate endlessly, leading to a "broadcast storm" that cripples the network.
-   **Solution:** STP (and its faster successor, **RSTP - Rapid Spanning Tree Protocol**) is a Layer 2 protocol that prevents switching loops.
-   **Mechanism:** STP automatically detects redundant paths and logically **blocks** one of the ports to break the loop. This creates a single, loop-free active path. If the primary path fails, STP automatically unblocks the backup port to restore connectivity.

### 4. Link Aggregation (Port Trunking/Bonding)

-   **Function:** A technology that combines multiple physical links between two devices (e.g., switch-to-switch or switch-to-server) into a single logical link.
-   **Benefits:**
    -   **Increased Bandwidth:** The capacity of the logical link is the sum of the physical links (e.g., two 1 Gbps links become one 2 Gbps link).
    -   **Load Balancing:** Traffic is distributed across the physical links.
    -   **Redundancy:** If one physical link fails, traffic continues to flow over the remaining links.
-   **Standard:** The IEEE standard for this is **LACP (Link Aggregation Control Protocol)**.

### 5. Virtual LANs (VLANs)

VLANs are one of the most powerful and common features in modern switched networks.

-   **Concept:** A VLAN is a logical grouping of network devices (like PCs and servers) that are configured to communicate as if they were on the same physical LAN, regardless of their actual physical location.
-   **Function:** VLANs logically segment a single physical LAN into multiple, separate **broadcast domains**. Traffic from one VLAN is isolated and cannot cross into another VLAN without a Layer 3 device (a router or Layer 3 switch).

-   **Key Terminology:**
    -   **Access Port:** A switch port that belongs to a single VLAN. It connects to an end device like a PC.
    -   **Trunk Port:** A switch port that can carry traffic from *multiple* VLANs simultaneously. Trunk ports are used to connect switches to other switches or to routers.

-   **VLAN Tagging (IEEE 802.1Q):** To identify which VLAN a frame belongs to as it crosses a trunk link, the switch inserts a **VLAN tag** into the Ethernet frame header. The tag contains the **VLAN ID**. The tag is added when a frame enters a trunk port and removed when it leaves an access port on its way to an end device.

-   **VLAN Types:**
    -   **Default VLAN (VLAN 1):** Out of the box, all ports on a switch are in the default VLAN.
    -   **Data VLAN:** A standard VLAN configured to carry user data traffic.
    -   **Voice VLAN:** A separate VLAN created specifically for Voice over IP (VoIP) traffic, which allows this time-sensitive traffic to be given a higher priority (QoS).

### 6. Inter-VLAN Routing

Since VLANs are separate broadcast domains, a Layer 3 device is needed for them to communicate. This process is called inter-VLAN routing.

-   **Method 1: Router with Separate Interfaces:** Use a physical router with a separate physical interface connected to an access port for each VLAN. This is simple but not scalable as it consumes many router ports.
-   **Method 2: Router-on-a-Stick:** Use a single physical router interface connected to a trunk port on the switch. The router interface is configured with logical **sub-interfaces**, with each sub-interface assigned an IP address for a different VLAN's subnet and configured to understand the VLAN tags. This is a highly scalable and common method.
-   **Method 3: Layer 3 Switch:** A Layer 3 switch can perform inter-VLAN routing internally at very high speeds without needing an external router. This is the most efficient solution for large campus networks.

---

## Answers to In-Chapter Exercises

### Exercise 7.1

The **Data field** of an Ethernet frame (Figure 7.2) contains the entire PDU from the layer above it, which is the **IP Packet**. As shown in Figure 2.3, this IP Packet itself contains the **TCP Segment** (or UDP Datagram), which in turn contains the **Application Data (APDU)**. So, the data field of the frame is the vessel for the entire chain of encapsulated upper-layer data.

### Exercise 7.2

This exercise involves drawing a physical layout. The key is to map the logical hierarchy to the physical building structure:
-   The **core layer switches** would be placed in the **Main Equipment Room (MDF)** on the first floor.
-   The **access (workgroup) switches** would be placed in the **Wiring Closets (IDFs)** on floors 2, 3, and 4.
-   **Backbone cabling (vertical cabling)** would connect the access switches in the IDFs down to the core switches in the MDF.
-   **Horizontal cabling** would connect the end devices (PCs, etc.) on each floor to the access switch in that floor's IDF.

### Exercise 7.3

If a host broadcasts a frame to switch D (in Figure 7.5), and all links are active, a loop occurs:
1.  D sends the broadcast to B and C.
2.  B sends it to A and F. C sends it to A and F.
3.  Now F has received two copies. It broadcasts them back to B and C. A has also received two copies, and it broadcasts them to B and C.
4.  B, C, A, and F are now caught in an endless loop, forwarding the same broadcast frame to each other, multiplying the traffic exponentially and causing a broadcast storm that crashes the network.

### Review Questions: EQUIP Co. Case

1.  **Cable:** CAT6 for trunks and servers; CAT5 for workstations and cameras.
2.  **Connection Speed:** Trunks/servers are 1 Gbps; workstations/cameras are 100 Mbps.
3.  **Connection Speeds:** Servers: 1 Gbps; Client Stations: 100 Mbps.
4.  **Capacity Doubling:** **Link Aggregation** is used on the production network trunks.
5.  **IP on L2 Switches:** For remote configuration and management.
6.  **Subnets:** Two subnets (production and surveillance). This is for security and traffic isolation.
7.  **Broadcast Domains:** Two, one for each subnet.
8.  **IP Ranges:** Production clients/servers get IPs in the `172.16.10.1 - 172.16.10.254` range.
9.  **Camera IPs:** Cameras get IPs in the `172.16.20.1 - 172.16.20.254` range.
10. **Surveillance Network Design:** Flat design (all cameras connect to a single switch). It is one tier.
11. **Production Network Design:** Hierarchical design. It is **two-tier** (Access and a combined Core/Distribution layer).
12. **Router Placement:** In the **Main Equipment Room (MDF)**. It needs to connect the two subnets and likely the external internet, making the central MDF the logical location.
13. **Adding a DMZ:** Create a new subnet (e.g., `172.16.30.0/24`) and connect it to a third port on the router. The new email/web servers would be placed on this subnet. Firewall rules on the router would then be configured to allow specific traffic (HTTP, SMTP) from the internet to this DMZ, while strictly limiting traffic from the DMZ to the internal production network.

### Exercise 7.4

1.  **VLAN ID:** All hosts are in the default **VLAN 1**.
2.  **Subnet IPs:** There is one subnet: `192.168.10.0/24`.
3.  **Broadcast from 192.168.10.1:** Switch B will forward it out ports `Fa0/10`, `Fa0/15`, and the trunk port `Fa0/1`.
4.  **Computers receiving broadcast:** **All six** computers will receive the frame.
5.  **Destination addresses:** Destination IP: `192.168.10.255` or `255.255.255.255`. Destination MAC: `FF-FF-FF-FF-FF-FF`.
6.  **Switch A/C Tables:** They would list all 6 MACs pointing toward their respective trunk ports. All would be in VLAN 1.
7.  **Problems:** No segmentation. All devices are in one large broadcast domain, which is inefficient and insecure. An accounting PC can directly communicate with an IT PC.
8.  **Router replacement:** No. A router requires each interface to be on a different subnet. Since all hosts are on the same subnet (`192.168.10.0/24`), a router cannot replace switch A.
9.  **Using a router:** You would need to physically regroup all hosts from a single department to be connected to the same switch, and then connect each of those switches to a separate port on a router. This is physically restrictive.
10. **Using a router in the building:** This would be a physical nightmare. You would have to run new horizontal cabling so that, for example, all marketing PCs on all floors connect to a "Marketing Switch," and all accounting PCs connect to an "Accounting Switch," etc. This is exactly the problem VLANs were designed to solve.

---

## Answers to End-of-Chapter Review Questions

1.  This is termed as **A. link aggregation**.
2.  **A. The Spanning Tree Protocol disables redundant paths in a switched Ethernet LAN, and reactivates them as needed.**
3.  The Ethernet VLAN **B. creates smaller segments of a network** (broadcast domains).
4.  Ethernet standards are defined at the **D. physical and data link layers**.
5.  Ethernet synchronizes speed using the **A. preamble**.
6.  Frame priority can be indicated using **B. tag control information** (which contains the 3-bit priority field).
7.  One benefit of VLANs is **B. reduced network congestions** (by limiting broadcasts).
8.  VLANs in Ethernet are configured on **B. switches**.
9.  All hosts belong to the **D. default** VLAN.
10. Sub-interfaces can be assigned to the **C. router port** to enable inter-VLAN routing.
11. VLANs make it **A. easier to manage internal changes (e.g., reassignment of a worker)**.
12. **E. Developing VLANs requires that the network be hierarchical...** is NOT true. VLANs can be used in a flat network.
13. **C. The layer 2 switch can be used to exchange frames between two different VLANs.** is INCORRECT. This requires a Layer 3 device.
14. The switch determines the VLAN ID from the **C. TCI** field in the 802.1Q tag.
15. **A. The data link layer is divided into the LLC and MAC sub-layers.** is CORRECT.
16. Sub-interfaces are used to **A. relay packets between VLANs**.
17. **E. A switch port may be either an access or a trunk port, but not both at the same time.** is CORRECT.
18. The CRC code is used to **B. detect transmission errors**.
19. **E. The layer 2 or 3 switch can be used at the core layer.** is an ACCURATE statement.
20. **B. The LLC sub-layer header describes the type of packet contained in the frame’s data field.** is CORRECT.
21. The length field represents the length of the **A. data field**.
22. They are typically organized in a **C. hierarchy**.
23. In Figure 7.15, Switch B is connected to 3 hosts and 1 trunk. It has **3 access ports** in use.
24. The tagged frame would only exist on the trunk links. **C. F → C, C → A, A → B, and B → D**.
25. The BPDU contains information relevant to **E. redundant path identification** for Spanning Tree Protocol.
