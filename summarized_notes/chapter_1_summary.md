# Chapter 1: Fundamental Concepts

## Detailed Summary

This chapter introduces the foundational concepts of computer networking and cybersecurity. It covers the essential building blocks of a network, how they communicate, their physical and logical arrangements, and the performance metrics used to evaluate them.

### 1. Key Network Elements

A computer network is a collection of hardware and software components that work together to exchange data.

-   **Host:** A data-producing entity connected to a network, such as a computer, smartphone, or server. Hosts can operate in two primary modes:
    -   **Client-Server Mode:** A dedicated server provides resources (files, web pages, etc.) to client hosts.
    -   **Peer-to-Peer (P2P) Mode:** Each host acts as both a client and a server, sharing resources directly with others.
    -   **Network Interface Card (NIC):** A circuit board that allows a host to connect to a network, converting data into signals for transmission.

-   **Intermediary Device:** Hardware that relays data between hosts without producing user data itself. Examples include switches, routers, hubs, and modems.
    -   **Intra-networking devices** (switches, hubs) operate *within* a single network segment (subnetwork).
    -   **Inter-networking devices** (routers) connect *different* network segments together.

-   **Network Link:** The physical connection (wired or wireless) between network nodes.
    -   **Access Link:** Connects a host to an intermediary device.
    -   **Trunk Link:** Interconnects intermediary devices (e.g., switch-to-router).

-   **Application:** Software that supports user tasks over a network (e.g., web browsers, email clients).

-   **Data/Message:** Information produced by applications, packaged into discrete units called **packets** for transport.

-   **Protocol:** A set of detailed communication rules (syntactic and semantic) that govern data exchange (e.g., HTTP, TCP).

### 2. Modes of Communication

-   **Data Distribution Methods:**
    -   **Unicasting:** One-to-one communication between a single source and a single destination.
    -   **Broadcasting:** One-to-all communication, where data is sent to every node on a network.
    -   **Multicasting:** One-to-many communication, where data is sent to a select group of destinations.

-   **Directionality:**
    -   **Simplex:** Data flows in only one direction (e.g., keyboard to computer).
    -   **Half-Duplex:** Data flows in both directions, but only one way at a time (e.g., walkie-talkie).
    -   **Full-Duplex:** Data flows in both directions simultaneously (e.g., telephone call).

### 3. Network Topologies

Network topology refers to the physical layout of network nodes and links.

-   **Point-to-Point:** A direct link between two nodes.
-   **Bus:** All nodes connect to a single common line. Prone to collisions.
-   **Ring:** Nodes are connected in a circular loop.
-   **Star (Hub-and-Spoke):** All nodes connect to a central intermediary device. Easy to manage but creates a single point of failure. This is the most common topology for modern LANs.
-   **Mesh:** Provides high reliability through redundant links. A **full mesh** connects every node to every other node, while a **partial mesh** has fewer links.
-   **Tree (Hierarchical):** Nodes are arranged in a hierarchical structure, effective for interconnecting many nodes efficiently.

### 4. Classification of Networks

-   **Personal Area Network (PAN):** Covers a very small area (a few meters), typically for connecting personal devices (e.g., Bluetooth, NFC).
-   **Local Area Network (LAN):** Covers a confined area like an office, building, or campus.
-   **Metropolitan Area Network (MAN):** Spans a city, interconnecting LANs.
-   **Wide Area Network (WAN):** Covers a large geographical area (state, country, or globally), interconnecting LANs and MANs. The Internet is the largest WAN.
-   **Internet of Things (IoT):** A paradigm where everyday devices (cars, appliances) connect and communicate automatically over networks.

### 5. Subnetwork vs. Inter-network

-   **Subnetwork (Subnet):** A single network segment, typically connected by intra-networking devices like switches. Communication *within* a subnet is **intra-networking**.
-   **Inter-network:** A network composed of multiple subnetworks joined by routers. Communication *across* subnets is **inter-networking**.

### 6. Measures of Network Performance

-   **Capacity (Speed):** Measured in bits per second (bps).
    -   **Channel Capacity (Bandwidth):** The theoretical maximum data rate of a link.
    -   **Throughput:** The actual, measured data rate, which is often lower than the channel capacity.
-   **Delay (Latency):** The time it takes for data to travel between two points, measured in milliseconds (ms). Sources of delay include propagation time, processing at hosts, and queuing at intermediary devices.
-   **Reliability:** The network's ability to deliver data without corruption or loss.
-   **Quality of Service (QoS):** A network's capability to guarantee a certain level of performance (capacity, latency, reliability), which is crucial for real-time applications like video streaming.

### 7. Numbering Systems

-   **Binary (Base-2):** Uses 0s and 1s, the native language of computers.
-   **Decimal (Base-10):** The standard numbering system used by humans.
-   **Hexadecimal (Base-16):** Uses digits 0-9 and letters A-F. More compact than binary for representing large numbers and commonly used for MAC addresses.

### 8. Network Addressing

-   **MAC (Media Access Control) Address:** A unique, permanent 48-bit hardware address burned into a device's NIC. It is used for **intra-networking** (communication within a subnet).
-   **IP (Internet Protocol) Address:** A logical 32-bit (for IPv4) or 128-bit (for IPv6) address assigned to a network node. It is used for **inter-networking** (communication across subnets).
-   **Pairing:** For a host to communicate on a network, it needs both a MAC address and an IP address.

---

## Answers to In-Chapter Exercises

### Exercise 1.1

1.  **Client-Server Advantages over P2P:**
    *   **a. Easier to protect server resources:** Centralized data storage on a dedicated server makes it easier to implement robust security, access control, and monitoring.
    *   **b. Better accessibility to server resources:** A high-performance, always-on server ensures that resources are consistently available to all clients.
    *   **c. Easier to back up server resources:** Backing up a single, centralized server is simpler and more reliable than backing up data scattered across multiple peer machines.
    *   **d. More cost-effective in maintaining and upgrading:** Software updates and maintenance can be performed on one server instead of on every peer machine, saving time and effort.
    -   **e. Easier to add server resources:** Scaling is more straightforward; resources like storage or processing power can be added to the central server to meet growing demand.

2.  **P2P File Swapping:** This exercise requires a hands-on setup. The general steps on Windows would be:
    1.  Ensure both computers are on the same WiFi network.
    2.  Go to `Control Panel > Network and Sharing Center > Change advanced sharing settings`.
    3.  Turn on network discovery and file and printer sharing for the private network profile.
    4.  Create a shared folder on one computer by right-clicking it, selecting `Properties > Sharing > Advanced Sharing`, and setting permissions.
    5.  From the second computer, open File Explorer and navigate to the `Network` tab to find the first computer and access its shared folder to swap files.

### Exercise 1.2

1.  **Hosts per LAN:**
    -   Main Office LAN: 4 hosts (PC3, PC4, Server, IP Phone)
    -   Branch 1 LAN: 2 hosts (PC1, PC2)
    -   Branch 2 LAN: 1 host (Laptop)

2.  **Intermediary Devices per LAN:**
    -   Main Office LAN: 2 devices (S2, S3)
    -   Branch 1 LAN: 1 device (S1)
    -   Branch 2 LAN: 1 device (Wireless Access Point)

3.  **Access and Trunk Links per LAN:**
    -   Main Office LAN: 4 access links, 1 trunk link (between S2 and S3).
    -   Branch 1 LAN: 2 access links, 0 trunk links.
    -   Branch 2 LAN: 1 access link (wireless), 0 trunk links.

4.  **Total Access and Trunk Links:**
    -   Total Access Links: 4 + 2 + 1 = 7
    -   Total Trunk Links (including LAN and WAN): 1 (in Main Office) + 3 (WAN links) = 4 trunk links.

5.  **Total Network Nodes:** 7 hosts + 4 LAN intermediary devices + 3 routers = 14 network nodes.

6.  **Intra-networking Devices:**
    -   Main Office LAN: S2, S3
    -   Branch 1 LAN: S1
    -   Branch 2 LAN: Wireless Access Point

7.  **Inter-networking Device:** The Routers (R1, R2, R3) are used for inter-networking.

### Exercise 1.3

1.  **PAN, LAN, MAN, WAN in the IoT Scenario:**
    -   **PAN (Personal Area Network):** Laura's Apple Watch communicating with her phone, her son's health wrist device connecting to a local monitor, or her watch connecting to the shopping cart display. These are all short-range, personal-device communications.
    -   **LAN (Local Area Network):** Her car's internal network connecting various sensors (brake pads, tire pressure). The home network that synchronizes her watch and computer data with the central server is also a LAN.
    -   **MAN (Metropolitan Area Network):** Her car communicating with the city's traffic management system to get real-time accident updates. The airport's customer support system communicating with her watch as she enters could also be part of a MAN.
    -   **WAN (Wide Area Network):** Her car transmitting data to the maintenance shop, checking the Xbox delivery status with the postal office database, and connecting to her home network while she's away. These are all long-distance communications that traverse the Internet (a WAN).

2.  **New and Obsolete Business Models:**
    -   **New Business Models:**
        -   **Predictive Vehicle Maintenance:** Cars automatically reporting issues to service shops, enabling proactive repairs and subscription-based maintenance services.
        -   **Automated Grocery Replenishment:** A subscription service where the grocery store's system links to a customer's home network to auto-detect low inventory and deliver items.
        -   **Personalized Health Monitoring Services:** Family doctors offering remote, real-time diagnosis and monitoring services via wearable health devices.
        -   **Smart Shopping Assistants:** In-store systems that offer personalized routing, discounts, and product information based on a customer's shopping list and location.
    -   **Obsolete/Less Relevant Business Models:**
        -   **Traditional Auto Repair Shops:** The "break-fix" model may become less relevant as predictive maintenance becomes standard.
        -   **Physical Media/Game Stores:** The instant tracking and delivery information for the Xbox suggests a highly efficient e-commerce system, making physical stores less necessary.
        -   **Manual Billing for Rentals:** The rental car's automated billing system would make manual invoicing and payment processing obsolete.

### Exercise 1.4

1.  **Referring to Figure 1.6:**
    *   **a. How many subnetworks are there in each LAN?** Each LAN is a single subnetwork. Message delivery within each LAN does not require a router.
    *   **b. Is this inter-networking? (PC1 to printer in LAN1):** No, this is **intra-networking** because the communication occurs within the same subnetwork (LAN1).
    *   **c. Is this inter-networking? (PC1 in LAN1 to server in LAN3):** Yes, this is **inter-networking** because the communication crosses multiple subnetworks (LAN1, WAN link, LAN3) and requires routers.
    *   **d. Is this inter-networking? (PC1 to IP Phone in LAN1):** No, this is **intra-networking**.
    *   **e. Is this inter-networking? (PC2 in LAN3 to server in LAN3):** This is a typo in the question, assuming PC2 is in LAN1. If PC2 (in LAN1) communicates with the server (in LAN3), it is **inter-networking**. If it's a PC within LAN3 communicating with the server in LAN3, it is **intra-networking**.

2.  **Referring to Figure 1.22:**
    *   **a. How many LANs are there?** There is one LAN.
    *   **b. How many subnetworks are there?** There are **three** subnetworks, as each of the three switches connects to a different port on the border router.
    *   **c. Is this inter-networking? (PC1 to email server):** Yes, this is **inter-networking**. PC1 is on the subnet connected to the top switch, while the email server is on the subnet connected to the bottom switch. The communication must go through the router.
    *   **d. Is this inter-networking? (PC1 to file server):** No, this is **intra-networking**. Both PC1 and the file server are connected to the same switch and are therefore in the same subnetwork.
    *   **e. What is the intermediary device used for intra-networking?** Switches.

### Exercise 1.5

-   A digitized telephone call requires 8 Kbps in each direction, for a total of **16 Kbps** for a full-duplex call.
-   An HDTV channel requires **15 Mbps**, which is 15,000 Kbps.
-   Number of concurrent calls = 15,000 Kbps / 16 Kbps per call = **937.5**.
-   Therefore, you can make **937** concurrent telephone calls with the data rate required for just one HDTV channel.

### Exercise 1.6

1.  **Decimal to 8-bit Binary Conversion:**
    -   38 = **00100110**
    -   110 = **01101110**
    -   192 = **11000000**
    -   255 = **11111111**

2.  **8-bit Binary to Decimal Conversion:**
    -   01100001 = **97**
    -   11110110 = **246**
    -   11100011 = **227**
    -   10100010 = **162**

### Exercise 1.7

1.  **0x17AB to Binary:**
    -   1 = 0001, 7 = 0111, A = 1010, B = 1011
    -   Result: **0001011110101011**

2.  **Hex to Binary:**
    -   0xABCDEF = **101010111100110111101111**
    -   0x34A57 = **00110100101001010111**
    -   0x12DF01 = **000100101101111100000001**
    -   0x78ADC = **01111000101011011100**

3.  **Binary to Hex:**
    -   "10110110100011100001" -> 1011 0110 1000 1110 0001
    -   Result: **0xB68E1**

4.  **NIC Physical Address to Hex:**
    -   `001001100111100010101011010111000100100010001101` (This appears to be 52 bits, but a MAC address is 48. I will use the first 48 bits).
    -   `00100110 01111000 10101011 01011100 01001000 10001101`
    -   26 78 AB 5C 48 8D
    -   Result: **26-78-AB-5C-48-8D**

### Exercise 1.8

-   **OUIs of Tech Companies (example search results):**
    -   **Cisco:** 00-00-0C, 00-01-42, 00-01-63, etc. (They own many)
    -   **Apple:** 00-03-93, 00-0A-95, 00-16-CB, etc.
    -   **Intel:** 00-02-B3, 00-04-23, 00-07-E9, etc.
    -   **Microsoft:** 00-0D-3A, 00-12-5A, 00-15-5D, etc.
    -   Companies own many OUIs to account for the vast number of network devices they manufacture.

### Exercise 1.9

1.  **Smartphone MAC/IP:** This requires checking the phone's settings (`Settings > About Phone > Status`). A phone will have a WiFi MAC address and potentially a Bluetooth MAC address.

2.  **IMEI (International Mobile Equipment Identifier):**
    -   **What it is:** A unique 15-digit number that identifies a specific mobile device on a cellular network. It is different from a MAC address (which is for LANs like WiFi/Bluetooth) and an IP address (which is for network connections).
    -   **How it's different:** IMEI is tied to the cellular radio hardware. A phone has one IMEI but can have multiple MAC addresses.
    -   **What you can do with it:** If your phone is stolen, you can report the IMEI to your cellular carrier. They can blacklist the device, preventing it from being used on their network (and often partner networks), effectively making it a brick.

3.  **Computer MAC/IP Addresses from `ipconfig /all` on Figure 1.24:**
    *   **a. Current IP address:** 192.128.1.2
    *   **b. How many NICs and MAC addresses:** Two NICs are shown (Ethernet and Wireless LAN), so there are two MAC addresses.
    *   **c. Their MAC addresses:**
        -   Ethernet: `00-1A-92-A7-87-95`
        -   Wireless LAN: `00-1E-E5-91-B7-89`
        -   There is more than one MAC address because the computer has separate hardware for connecting to wired (Ethernet) and wireless (WiFi) networks.
    *   **d. Manufacturers of the NICs:**
        -   Ethernet (OUI: 00-1A-92): Intel Corporate
        -   Wireless LAN (OUI: 00-1E-E5): Azurewave Technologies, Inc.
    *   **e. WiFi MAC bound to IP 192.128.1.2:** This means the computer is currently connected to the network using its wireless adapter, and that specific wireless connection has been assigned the IP address 192.128.1.2. The Ethernet adapter is shown as "Media disconnected," so it is not in use.

---

## Answers to End-of-Chapter Review Questions

1.  The **C. network topology** represents the layout of network nodes and links.
2.  **E. Network nodes include intermediary devices and hosts.**
3.  **B. partial mesh** topology is used widely when network redundancy is important.
4.  Star topology is also known as **E. hub-and-spoke**.
5.  A **D. web server–switch link** is an access link.
6.  The organizationally unique identifier (OUI) is an element of **A. MAC addresses**.
7.  The throughput of a network **E. represents its actual speed**.
8.  Messages are produced and exchanged according to rules implemented in **A. protocols**.
9.  **C. Creating a computer network needs to have at least one trunk link.** (A small network with one switch doesn't need a trunk link).
10. The campus network is a type of **A. local area network**.
11. The binary correspondence of hex digits “B301” is **B. 1011001100000001**.
12. **E. A host station should have an MAC and an IP address for networking.**
13. **A. It is a permanent address.** is TRUE regarding the MAC address.
14. **D. channel capacity, bandwidth, rated speed** are used interchangeably.
15. When nearby devices exchange data, a **B. PAN (personal area network)** standard is used.
16. **A. ab-01-cd-ef-23-45** is a legitimate MAC address (12 hex digits).
17. Switches within a network are interconnected by **C. trunk links**.
18. Network nodes include **B. intermediary devices and end stations**.
19. **C. It always operates in the full-duplex mode.** is NOT NECESSARILY an accurate description (e.g., a switch port connected to a hub would be half-duplex).
20. The right sequence of data rate metrics is **D. Kbps—Mbps—Gbps—Tbps—Pbps**.
21. Audio or video streaming services generally rely on the **C. multicasting** technology.
22. The three main sources of network latency include **B. propagation delay, delay at hosts, and delay at intermediary devices**.
23. The primary dimensions of network performance include **D. delay, capacity, and reliability**.
24. The message is produced by the web browser according to the **C. syntactic rule** of the HTTP protocol.
25. **D. Star: All locations connect to a central site, and thus the network is susceptible to a single point of failure.** correctly describes a network topology.
