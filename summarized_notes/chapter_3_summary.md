# Chapter 3: Intermediary Devices

## Detailed Summary

This chapter provides an in-depth look at the general-purpose intermediary devices that form the backbone of a network. It focuses on hubs, bridges, switches, and routers, explaining their functions, operational layers, and key differences.

### 1. Intermediary Devices and Operational Layers

Intermediary devices facilitate communication between end stations and operate at different layers of the hybrid 5-layer model.

-   **Hubs (Layer 1 - Physical):** Simple devices that regenerate and broadcast incoming signals to all connected ports.
-   **Switches, Bridges, Wireless APs (Layer 2 - Data Link):** Make forwarding decisions based on MAC addresses to move frames *within* a single network (intra-networking).
-   **Routers, Layer 3 Switches (Layer 3 - Internet):** Make routing decisions based on IP addresses to move packets *between* different networks (inter-networking).

These devices perform encapsulation and de-encapsulation as data passes through them. A router, for instance, will de-encapsulate a frame to inspect the IP packet, make a routing decision, and then re-encapsulate the packet into a new frame for the next data link.

### 2. Hub (Multiport Repeater)

-   **Function:** A Layer 1 device that receives a signal on one port and regenerates and broadcasts it out to all other ports.
-   **Operation:** Creates a **shared media** environment where all connected hosts are in the same **collision domain**. This means only one device can transmit at a time, otherwise, a collision occurs.
-   **Mode:** Operates in **half-duplex**.
-   **Security:** Insecure, as all traffic is broadcast, making it easy to eavesdrop with a packet sniffer.
-   **Modern Usage:** Largely obsolete and replaced by switches due to inefficiency and security risks.

### 3. Bridge and Wireless Access Point (AP)

-   **Function:** A Layer 2 device that divides a network into smaller segments to reduce traffic and collisions. It forwards or filters frames based on their destination MAC address, which it stores in a **bridge table**.
-   **Types:**
    -   **Transparent Bridge:** Connects two segments using the *same* standard (e.g., Ethernet to Ethernet).
    -   **Translational Bridge:** Connects two segments using *different* standards (e.g., Ethernet to WiFi), performing frame conversion. A **Wireless Access Point (AP)** is the most common example of a translational bridge.

### 4. Switch

The switch is the most popular intermediary device for modern wired LANs.

-   **Function:** An intelligent Layer 2 device that forwards frames only to the specific port connected to the destination host.
-   **Operation:** Each port on a switch creates a separate **collision domain**, eliminating frame collisions. It uses a **switch table** (also called a MAC address table) to map MAC addresses to specific ports.
    -   **Switch Learning:** The switch automatically builds its table by inspecting the source MAC address of incoming frames.
    -   **Aging:** Entries in the table are automatically removed after a certain period of inactivity.
-   **Mode:** Operates in **full-duplex**, allowing simultaneous two-way communication.
-   **Types:**
    -   **Managed vs. Non-managed:** Managed switches have an operating system (OS) and can be configured with advanced features (VLANs, security), while non-managed switches are simple plug-and-play devices.
    -   **Store-and-Forward vs. Cut-Through:** Store-and-forward switching waits for the entire frame to arrive before forwarding (allowing for error checking), while cut-through switching starts forwarding as soon as the destination MAC is read (faster but no error check).
    -   **Layer 2 vs. Layer 3:** A Layer 3 switch combines the functions of a switch and a router, capable of performing IP-based routing in hardware, making it faster than a traditional router for inter-VLAN routing.

### 5. Router

-   **Function:** A Layer 3 device that performs **inter-networking**, forwarding IP packets between different subnets.
-   **Operation:** Uses a **routing table** to determine the best path to forward a packet. Unlike switches, routers do not forward broadcast messages by default, thereby creating separate **broadcast domains**.
-   **Components:** A specialized computer with a CPU, memory (RAM, ROM, flash), OS (e.g., Cisco IOS), and various ports (LAN and WAN).
-   **Ports:** Each router port connects to a different subnet and must have its own unique IP address. LAN ports have both IP and MAC addresses; WAN ports typically only need an IP address.

### 6. Switching vs. Routing

| Feature               | Switching (Layer 2)                           | Routing (Layer 3)                                    |
| --------------------- | --------------------------------------------- | ---------------------------------------------------- |
| **PDU**               | Frame                                         | Packet                                               |
| **Address Used**      | MAC Address                                   | IP Address                                           |
| **Scope**             | Intra-networking (within a single subnet)     | Inter-networking (between different subnets)         |
| **Path Determination**| Connection-Oriented (single active path)      | Connectionless (dynamic path decision at each hop)   |
| **Broadcasts**        | Forwards broadcasts by default                | Blocks broadcasts by default                         |
| **Device**            | Switch                                        | Router                                               |

### 7. Address Resolution Protocol (ARP)

-   **Function:** A protocol used by a network node to discover the MAC address associated with a specific IP address on the local network.
-   **Process:** When a host needs to send a frame to an IP address on its subnet but doesn't know the MAC address, it broadcasts an **ARP request** ("Who has this IP address?"). The device with that IP sends back an **ARP reply** containing its MAC address.
-   **ARP Cache:** The host stores the IP-to-MAC mapping in its ARP table (or cache) for future use.

### 8. Collision and Broadcast Domains

-   **Collision Domain:** A network segment where data transmissions can collide. **Switches break up collision domains** (each switch port is a separate domain). Hubs create a single, large collision domain.
-   **Broadcast Domain:** A network segment where a broadcast frame will be propagated. **Routers break up broadcast domains**. By default, an entire switched network is a single broadcast domain, but this can be segmented using VLANs.

---

## Answers to In-Chapter Exercises

### Exercise 3.1

1.  **Router De-encapsulation/Encapsulation (Ethernet to Ethernet):**
    1.  An Ethernet frame arrives at the router's first LAN port.
    2.  The router de-encapsulates the frame, removing the Ethernet header and trailer to expose the IP packet.
    3.  The router's Internet layer processes the IP packet: it reads the destination IP, consults its routing table to find the exit port, and decrements the TTL.
    4.  The router's Data Link layer re-encapsulates the IP packet into a *new* Ethernet frame, with the router's exit port MAC as the source and the next-hop device's MAC as the destination.
    5.  The new frame is sent out of the second LAN port.

2.  **Switch De-encapsulation/Encapsulation:** No. A standard Layer 2 switch only needs to read the Ethernet frame's header to find the destination MAC address. It does not de-encapsulate the frame to look at the IP packet inside. It simply forwards the original frame to the correct port.

### Exercise 3.2

| Source MAC        | Destination MAC   | Filter or Forward | Output Port | Receiving Hosts |
| ----------------- | ----------------- | ----------------- | ----------- | --------------- |
| 1100.0000.1111    | 1100.0000.2222    | **Filter**        | N/A         | 1, 2, 3         |
| 1100.0000.1111    | 1100.0000.4444    | **Forward**       | Fa0/1       | 4, 5            |
| 1100.0000.5555    | 1100.0000.4444    | **Filter**        | N/A         | 4, 5            |
| 1100.0000.3333    | FFFF.FFFF.FFFF    | **Forward**       | Fa0/1       | 1, 2, 3, 4, 5   |
| 1100.0000.4444    | 1100.2B22.4A4C    | **Forward**       | Fa0/0       | 1, 2, 3         |
| 1100.0000.5555    | FFFF.FFFF.FFFF    | **Forward**       | Fa0/0       | 1, 2, 3, 4, 5   |

### Exercise 3.3

1.  **Port Density:** 24 ports + 2 SFP ports = **26 ports** total.
2.  **Wire Speed:** The RJ-45 ports support 10/100/1000 Mbps. The SFP ports likely support 1 Gbps. So, the wire speed is **up to 1 Gbps**.
3.  **Forwarding Rate:** (24 ports * 1 Gbps) + (2 ports * 1 Gbps) = **26 Gbps**.
4.  **Aggregate Throughput:** 26 Gbps * 0.80 = **20.8 Gbps**. No, this switch is **blocking** because its aggregate throughput (20.8 Gbps) is less than its theoretical forwarding rate (26 Gbps).
5.  **Can aggregate throughput be higher?** No. Aggregate throughput is the *actual* data rate that can be pushed through, which is limited by the switch's internal architecture (backplane speed). It cannot exceed the theoretical maximum forwarding rate.

### Exercise 3.4

*SW3's Switch Table in Figure 3.10:*

| Destination MAC | Exit Port |
| --------------- | --------- |
| A1B1.1111.5555  | Fa0/15    |
| A1B1.1111.6666  | Fa0/20    |
| A1B1.1111.1111  | Fa0/1     |
| A1B1.1111.2222  | Fa0/1     |
| A1B1.1111.3333  | Fa0/1     |
| A1B1.1111.4444  | Fa0/1     |

### Exercise 3.5

*(This requires creating hypothetical MAC and port assignments for Figure 3.11).* An example for SW1's table:

| Destination MAC | Exit Port |
| --------------- | --------- |
| MAC of Host 1   | Fa0/4     |
| MAC of Host 2   | Fa0/5     |
| MAC of Host 3   | Fa0/1     |
| MAC of Host 4   | Fa0/1     |
| ... all other hosts | Fa0/1     |

### Exercise 3.6

1.  **LAN Ports:** Three FastEthernet ports. Their speed is likely 100 Mbps ("FastEthernet").
2.  **WAN Ports:** Two Serial ports.
3.  **Ready for Networking:** One LAN port (Fa0/0) and one WAN port (Serial 0/0) are "Up".
4.  **Why no MAC for serial port?** Serial WAN links are typically point-to-point connections. There is only one possible destination, so a Layer 2 MAC address is not needed to identify the next device.
5.  **Can Fa0/1 have IP 192.168.2.1/24?** No. Fa0/0 is already on the 192.168.2.0/24 subnet. A router cannot have two different interfaces on the same subnet.
6.  **Can Fa0/2 have IP 192.168.4.1/24?** Yes. This is a different subnet, so it is a valid configuration.
7.  **Subnets Interconnected:** Two (192.168.2.0/24 and 192.168.5.0/24).
8.  **Max Subnets:** Up to five (3 LAN + 2 WAN).

### Exercise 3.7

1.  **Difference in ARP tables:** The router's ARP table includes an **Interface** column, specifying which of its network ports the IP/MAC pair is reachable on. A host's table does not need this, as it typically has only one active connection to a single subnet.
2.  **Broadcast entries:**
    -   `192.168.1.255 ff-ff-ff-ff-ff-ff`: This is the **directed broadcast** address for the 192.168.1.0 subnet, mapped to the broadcast MAC address.
    -   `255.255.255.255 ff-ff-ff-ff-ff-ff`: This is the **limited broadcast** address for the local network, also mapped to the broadcast MAC address.
3.  **Router's ARP Table (Figure 3.19b):**
    *   **a. Subnets interconnected:** Two (192.168.10.0 and 192.168.20.0).
    *   **b. WAN connection?** No, you cannot tell from the ARP table. The table only shows Layer 2 (MAC) to Layer 3 (IP) mappings for devices on its connected LAN segments.
4.  **Layer 2 Switch ARP Table?** No. A standard Layer 2 switch operates only at the Data Link layer. It makes forwarding decisions using its MAC address table (switch table), not an ARP table. It does not process IP addresses.

### Exercise 3.8

1.  PC's browser produces an HTTP request.
2.  PC sends an inquiry to a designated **DNS** server.
3.  The **DNS** server returns the IP address of the **web** server.
4.  PC creates a packet with sender's IP (**192.168.1.1**) and receiver's IP (**123.45.67.89**).
5.  PC realizes the target is not on its subnet.
6.  Packet delivery between the PC and default gateway is an **intra-networking** activity.
7.  PC must use the **MAC** address of the default gateway.
8.  PC does not know the default gateway's **MAC address**. This triggers broadcasting of an **ARP** inquiry.
9.  The default gateway responds by sending its **MAC** address.
10. PC updates its **ARP** table. It creates a **frame** and sends it to the default gateway.

### Exercise 3.9

1.  **Relationships:**
    *   **a. Subnetwork and Collision Domain:** They can be equal in scope (e.g., a single segment connected by a hub), but typically a subnetwork contains *multiple* collision domains (one for each switch port).
    *   **b. Subnetwork and Broadcast Domain:** Yes, by default, the scope of a subnetwork is identical to the scope of a broadcast domain.
    *   **c. Collision and Broadcast Domain:** They can be equivalent in a hub-based network, but in a switched network, a single broadcast domain is made up of many smaller collision domains.

2.  **Identifying Domains in Figure 3.27:**
    *   **Network (a):** 1 Collision Domain, 1 Broadcast Domain. (Hub creates one large domain for both).
    *   **Network (b):** 4 Collision Domains (one for each switch port), 1 Broadcast Domain.
    *   **Network (c):** 4 Collision Domains (one for each switch port connected to a host/router), 2 Broadcast Domains (the router separates the network into two).
    *   **Network (d):** 7 Collision Domains (one for each switch port), 3 Broadcast Domains (the router separates the network into three).

---

## Answers to End-of-Chapter Review Questions

1.  The wireless access point is a type of **C. bridge** (specifically, a translational bridge).
2.  A host NIC connected to a hub must use **A. half duplex** transmission.
3.  **C. bridge: layer 2 device** is correctly paired.
4.  **C. ARP (Address Resolution Protocol)** is used to find a MAC address from an IP address.
5.  **E. Automatic assignment of an IP address to the router port (interface)** is NOT an advanced function (it's a basic, manual configuration).
6.  **D. Serial0/0** is an adequate naming for a router's WAN port.
7.  **C. The switch port mostly operates in the full-duplex mode.** is a CORRECT statement.
8.  The **D. router** defines the boundary of a broadcast domain.
9.  **B. Networks relying on switching can be more vulnerable to a single point of failure than those relying on routing.** (Because switching has only one active path, a failure on that path can cut off a segment, whereas routing can use alternate paths).
10. CSMA/CD is activated when connected to a **B. hub**.
11. Aggregate throughput needed for 100% nonblocking: 8 ports * 1 Gbps/port = **B. 8.0 Gbps**.
12. The screenshot shows a mapping of MAC addresses to exit ports, so it is a **E. a switch’s switch table**.
13. **D. Address resolution protocol (ARP)** uses broadcasting.
14. The router uses ARP **E. when it needs to forward an IP packet to another router whose MAC address is not available** (on the same LAN segment).
15. Wire Speed = 1 Gbps; Forwarding Rate = 8 * 1 Gbps = 8 Gbps; 80% nonblocking aggregate throughput = 8 Gbps * 0.8 = 6.4 Gbps. Correct answer: **A. 1 Gbps, 8 Gbps, 6.4 Gbps**.
16. Cut-through switching is when **C. the switch forwards a frame without waiting for its arrival in its entirety.**
17. The difference is judged by **B. available port speeds**.
18. The **B. switch** restricts frame delivery to a single path (by using Spanning Tree Protocol).
19. Source `1100.0000.3333` (on Port 0) to destination `FFFF.FFFF.FFFF` (broadcast) must be forwarded out all other ports. The only other port is Port 1. This would be a **Forward** action. Therefore, **(D) Filter** is incorrect. Let's check A: Source `1100.0000.1111` (Port 0) to `1100.0000.2222` (Port 0) is a **Filter** action. So (A) is incorrect. Let's check B: Source `1100.0000.1111` (Port 0) to `1100.0000.4444` (Port 1) is a **Forward**. (B) is incorrect. Let's re-examine D: Source `1100.0000.3333` (Port 0) to `FFFF.FFFF.FFFF` (broadcast). This must be forwarded out Port 1. The table states it is Filtered. This is **incorrect**. The table seems to have a typo. Let's assume the question asks which entry is correct. `1100.0000.1111` to `1100.0000.4444` is Forward. `1100.0000.1111` to `1100.0000.2222` is Filter. `1100.0000.5555` to `1100.0000.4444` is Filter. Based on standard bridge logic, **C. Forward** for the broadcast is the only one that makes logical sense, but the table in the question has it as Filter. There appears to be an error in the question's provided table. The most likely intended correct answer based on elimination is that a broadcast must be forwarded.
20. The node has both FastEthernet (LAN) and Serial (WAN) interfaces, which is characteristic of a **A. router**.
21. **D. 0001.3412.B23A** must be an INCORRECT one, because a Serial (WAN) interface does not have a MAC address.
22. **D. The router’s OS is generally stored in the nonvolatile flash memory.** is a CORRECT statement.
23. 24 ports * 100 Mbps = 2400 Mbps. 50% of that is **D. 1200 Mbps**.
24. **D. The layer 3 switch port can be either a switch port or a router port.** is the key difference.
25. There are **D. 5** collision domains: one for each host directly connected to the switch, and one larger one for the three hosts connected to the hub. Total = 2 + 1 + 1 + 1 = 5.
