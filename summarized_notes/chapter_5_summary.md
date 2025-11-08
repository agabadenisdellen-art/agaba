# Chapter 5: IP Address Planning and Management

## Detailed Summary

This chapter covers the fundamentals of IP addressing using the IPv4 standard. It explains the structure of an IP address, the legacy and modern allocation schemes, special address ranges, and the critical concepts of subnetting and supernetting for effective network management.

### 1. Governance of IP Address Space

-   The global allocation of IP addresses is managed by the **Internet Assigned Numbers Authority (IANA)**.
-   IANA delegates blocks of addresses to five **Regional Internet Registries (RIRs)** (e.g., ARIN for North America).
-   RIRs, in turn, allocate smaller blocks to large **Internet Service Providers (ISPs)**, who then assign addresses to their customers (organizations and individuals).

### 2. Structure of an IP Address

An IPv4 address is a 32-bit number, typically written in dotted-decimal format (e.g., 129.131.12.10).

-   It is composed of two main parts: a **Network ID** (identifies the organization's network) and a **Host ID** (identifies a specific device on that network).
-   For better management, the Host ID portion can be further divided to create a **Subnet ID**, resulting in a three-level hierarchy: Network ID | Subnet ID | Host ID.

### 3. Classful vs. Classless IP Addressing

-   **Classful IP (Legacy):** An early, inefficient system that divided the IP address space into rigid classes:
    -   **Class A:** 8-bit network ID, 24-bit host ID. For very large networks. (e.g., `10.x.x.x`)
    -   **Class B:** 16-bit network ID, 16-bit host ID. For large networks. (e.g., `172.16.x.x`)
    -   **Class C:** 24-bit network ID, 8-bit host ID. For small networks. (e.g., `192.168.1.x`)
    -   This system was wasteful and has been replaced.

-   **Classless IP (Modern):** Known as **Classless Inter-Domain Routing (CIDR)**, this system allows the boundary between the network and host portions to be set anywhere.
    -   It uses a **prefix** (e.g., `/24`) to denote the number of bits used for the network/subnet portion. This is also represented by a **subnet mask**. For example, a `/24` prefix is equivalent to a subnet mask of `255.255.255.0`.

### 4. Special IP Address Ranges

-   **Loopback Address (127.0.0.0/8):** `127.0.0.1` (`localhost`) is a special address a host uses to send packets to itself. It's used for testing the internal TCP/IP stack and running local applications.
-   **Broadcasting:** Sending a packet to all hosts on a subnet.
    -   **Limited Broadcast (`255.255.255.255`):** Sent to all hosts on the *local* subnet. Blocked by routers.
    -   **Directed Broadcast:** Sent to all hosts on a *remote* subnet (e.g., `192.168.200.255`). This is a security risk and is disabled by default on modern routers.
-   **Multicasting (224.0.0.0 to 239.255.255.255):** Sending a packet to a select group of hosts that have joined a "multicast group." Used for applications like video streaming and online gaming.
-   **Private IP Addresses:** Ranges reserved for use within private networks (LANs). These addresses are not routable on the public Internet.
    -   `10.0.0.0` – `10.255.255.255` (/8)
    -   `172.16.0.0` – `172.31.255.255` (/12)
    -   `192.168.0.0` – `192.168.255.255` (/16)

### 5. Network Address Translation (NAT)

Since private IP addresses cannot be used on the Internet, a process called NAT is used by border routers or firewalls to translate private IPs into a public IP.

-   **One-to-One Mapping:** Each private IP is mapped to a unique public IP.
-   **Many-to-One Mapping (NAPT/PAT):** Multiple private IP hosts share a single public IP. The router uses the **port number** in addition to the IP address (the socket) to keep track of different internal conversations. This is the most common form of NAT.
-   **Benefits:** Conserves public IPv4 addresses, adds a layer of security by hiding internal network structure.

### 6. Subnetting

Subnetting is the process of dividing a single large network into multiple smaller subnetworks (subnets). This is done by "borrowing" bits from the host portion of the address to create a subnet ID.

-   **Benefits:**
    -   **Improved Security:** Segments the network to control access (e.g., creating a DMZ).
    -   **Better Performance:** Reduces the size of broadcast domains, minimizing unnecessary traffic.
    -   **Simplified Management:** Organizes the network along logical or physical boundaries.
-   **Subnet Mask:** A 32-bit number that defines which part of the IP address is the network/subnet and which part is the host. It's represented by a series of 1s (network/subnet part) followed by 0s (host part). For example, `255.255.255.0` in decimal is `11111111.11111111.11111111.00000000` in binary, indicating a `/24` prefix.

### 7. Supernetting (Route Summarization or CIDR)

Supernetting is the opposite of subnetting. It combines multiple smaller, contiguous subnets into a single, larger network representation (a "supernet").

-   **Process:** Find the longest common string of bits from the left among all the subnet addresses to be summarized. This common string becomes the new, shorter network prefix.
-   **Benefit:** Reduces the size of routing tables on routers. Instead of listing many specific routes, a router can have a single summary route, which makes the routing process faster and more efficient.

### 8. Managing IP Address Space

Proper IP planning is crucial for a scalable and manageable network.

-   **Determine Nodes:** Identify all devices that need an IP address (PCs, servers, printers, router interfaces, etc.) and decide whether they need a static (permanent) or dynamic (temporary, via DHCP) address. Servers and network devices typically get static IPs.
-   **Determine Subnets:** Divide the network into subnets based on physical location, department, or security needs. A common practice is to place public-facing servers (like web and email servers) in a separate, firewalled subnet called a **DMZ (Demilitarized Zone)**.
-   **Develop an IP Assignment Policy:** Create a consistent, documented plan for assigning IP addresses. For example, always assign the first usable IP in a subnet to the router, assign a specific range to servers, another to printers, etc. This simplifies troubleshooting and management.

---

## Answers to In-Chapter Exercises

### Review Exercise 5.1

-   101.150.11.51 = `01100101.10010110.00001011.00110011`
-   156.230.15.251 = `10011100.11100110.00001111.11111011`
-   22.131.49.31 = `00010110.10000011.00110001.00011111`
-   223.100.31.76 = `11011111.01100100.00011111.01001100`
-   11001010.10001010.00110110.11110000 = `202.138.54.240`
-   10010010.11001101.10111110.00000011 = `146.205.190.3`
-   11001000.00011000.11101011.10101010 = `200.24.235.170`
-   10100000.01111000.11000001.00110011 = `160.120.193.51`

### Exercise 5.2

1.  **Network Addresses:**
    -   `123.45.56.89` (14-bit network ID): `01111011.001011`|`01.00111000.01011001`. Network address is `01111011.00101100.00000000.00000000` = **123.44.0.0**
    -   `123.45.56.89` (18-bit network ID): Network address is `01111011.00101101.00`|`111000.01011001`. Network address is `01111011.00101101.00000000.00000000` = **123.45.0.0**
    -   `123.45.56.89` (19-bit network ID): Network address is `123.45.32.0`
    -   `123.45.56.89` (21-bit network ID): Network address is `123.45.56.0`

2.  **Max Hosts:**
    -   14-bit network ID -> 18 host bits -> 2¹⁸ - 2 = **262,142 hosts**
    -   18-bit network ID -> 14 host bits -> 2¹⁴ - 2 = **16,382 hosts**
    -   19-bit network ID -> 13 host bits -> 2¹³ - 2 = **8,190 hosts**
    -   21-bit network ID -> 11 host bits -> 2¹¹ - 2 = **2,046 hosts**

### Exercise 5.3

1.  Pinging `127.0.0.1` should succeed, confirming the local TCP/IP stack is working.
2.  Pinging `127.123.123.123` has the same effect. Any IP address within the `127.0.0.0/8` range is treated as a loopback address and will be routed back to the local host.

### Exercise 5.4

1.  Pinging `255.255.255.255` sends a broadcast to all hosts on the local `192.168.1.0` subnet. Every active host on that subnet should respond to the ping.
2.  Pinging `192.168.1.255` is a directed broadcast to the `192.168.1.0` subnet. Since the PC is *on* that subnet, this has the same effect as a limited broadcast: all hosts on the subnet will receive and respond to the ping.
3.  A broadcast domain defines the scope where a broadcast packet (like one sent to `255.255.255.255`) will be forwarded. A limited broadcast is confined to the local broadcast domain.

### Exercise 5.5

When the external servers respond, their packets will have the public IP `137.42.61.33` as the destination. The router receives these packets and consults its NAT table to perform the reverse translation:
1.  A packet arrives for `137.42.61.33` on port `4000`. The router looks this up and finds it maps to the internal private IP `192.168.1.1`. It changes the destination IP to `192.168.1.1`, keeps the destination port as `4000`, and forwards the packet to PC1.
2.  A packet for port `4001` is translated to destination `192.168.1.2`.
3.  A packet for port `4002` is translated to destination `192.168.1.3`.

### Exercise 5.6

There are **8 subnets** in Figure 5.11: 5 LAN subnets and 3 WAN links between the routers.

### Exercise 5.7

1.  Host: `195.112.36.59`. Subnet portion is the first 24 bits.
    -   Subnet Address: **195.112.36.0**
    -   Subnet Mask: **255.255.255.0** (`11111111.11111111.11111111.00000000`)
2.  Host: `207.34.15.187`. Subnet portion is the first 24 bits.
    -   Subnet Address: **207.34.15.0**
    -   Subnet Mask: **255.255.255.0** (`11111111.11111111.11111111.00000000`)
3.  Subnet Addresses and Masks:
    -   `195.205.36.5/13`: Subnet Address **195.200.0.0**, Mask **255.248.0.0**
    -   `192.168.36.5/21`: Subnet Address **192.168.32.0**, Mask **255.255.248.0**
    -   `10.11.46.51/15`: Subnet Address **10.10.0.0**, Mask **255.254.0.0**
4.  Subnet Addresses and Masks:
    -   `10.15.123.50/8`: Subnet **10.0.0.0**, Mask **255.0.0.0**
    -   `17.100.222.15/13`: Subnet **17.96.0.0**, Mask **255.248.0.0**
    -   `128.100.54.11/24`: Subnet **128.100.54.0**, Mask **255.255.255.0**
    -   `141.131.75.162/13`: Subnet **141.128.0.0**, Mask **255.248.0.0**
    -   `115.125.129.22`: Requires a mask. Assuming class B (/16), Subnet **115.125.0.0**, Mask **255.255.0.0**.

### Exercise 5.8

-   **Subnet 2 (130.191.64.0/18):** Range is `130.191.64.1` to `130.191.127.254`.
-   **Subnet 3 (130.191.128.0/18):** Range is `130.191.128.1` to `130.191.191.254`.
-   **Subnet 4 (130.191.192.0/18):** Range is `130.191.192.1` to `130.191.255.254`.

### Exercise 5.9

1.  Network: `130.190.0.0`, 4 bits borrowed.
    *   a. 2⁴ = **16 subnets**.
    *   b. Subnet mask is /20 or **255.255.240.0**.
    *   c. Subnets: `130.190.0.0`, `130.190.16.0`, `130.190.32.0`, ..., `130.190.240.0`.
2.  Network: `172.191.183.0/24`, 4 bits borrowed.
    *   a. Subnet mask is /28 or **255.255.255.240**.
    *   b. Subnets: `172.191.183.0`, `172.191.183.16`, ..., `172.191.183.240`.
    *   c. First subnet host range: **172.191.183.1** to **172.191.183.14**.
3.  Network `230.195.10.0/24`, needs 6 subnets.
    *   a. Need 2³ = 8 subnets, so borrow **3 bits**.
    *   b. Subnet mask is /27 or **255.255.255.224**.
    *   c. Subnets: `230.195.10.0`, `230.195.10.32`, ..., `230.195.10.224`.
    *   d. Last subnet (`.224`) host range: **230.195.10.225** to **230.195.10.254**.

### Exercise 5.10

1.  **Broadcast Addresses:**
    -   `130.191.0.0/18` -> Broadcast **130.191.63.255**
    -   `130.191.64.0/18` -> Broadcast **130.191.127.255**
    -   `130.191.128.0/18` -> Broadcast **130.191.191.255**
    -   `130.191.192.0/18` -> Broadcast **130.191.255.255**
2.  **Broadcast Addresses:**
    -   `192.168.150.121/17` -> Subnet `192.168.128.0`, Broadcast **192.168.255.255**
    -   `172.57.237.200/13` -> Subnet `172.56.0.0`, Broadcast **172.63.255.255**
3.  **Host 130.191.31.21/28:**
    *   a. 2⁴ = **16 subnets**.
    *   b. 4 host bits.
    *   c. 2⁴ - 2 = **14 hosts**.
    *   d. Subnet address is **130.191.31.16**.
    *   e. Broadcast address is **130.191.31.31**.
    *   f. First host is **130.191.31.17**.
    *   g. Last host is **130.191.31.30**.
4.  **Network 192.10.10.0/24, 14 subnets:**
    *   a. Need 2⁴ = 16 subnets, so borrow **4 bits**.
    *   b. Mask is /28 or **255.255.255.240**.
    *   c. **16 subnets**.
    *   d. `192.10.10.0`, `192.10.10.16`, etc.
    *   e. **14 usable hosts**.
    *   f. Range for `.16` subnet: **192.10.10.17** to **192.10.10.30**.
    *   g. Broadcast for `.16` subnet: **192.10.10.31**.

### Exercise 5.11

1.  Subnets `192.168.1.0`, `192.168.2.0`, `192.168.4.0`. In binary, the first 16 bits (`192.168`) are common. Looking at the third octet: `00000001`, `00000010`, `00000100`. The longest common prefix is `00000`. So, the prefix length is 16 + 5 = 21.
    -   Supernet Address: **192.168.0.0/21**
2.  This is a more complex mix. `129` is `10000001`. `130` is `10000010`. `132` is `10000100`. `145` is `10010001`. The longest common prefix is just `100`. So, the prefix length is 16 + 3 = 19.
    -   Supernet Address: **192.168.128.0/19**

### Exercise 5.12

1.  This is tricky because the masks are different. Let's find the range each covers.
    -   `172.16.163.0/20` -> `10101100.00010000.1010`|`0011.0...` -> Net is `172.16.160.0/20`
    -   `172.16.167.0/22` -> `...101001`|`11.0...` -> Net is `172.16.164.0/22`
    -   `172.16.159.0/23` -> `...1001111`|`1.0...` -> Net is `172.16.158.0/23`
    The common bits are `10101100.00010000.100`. Prefix is 19.
    -   Supernet Address: **172.16.128.0/19**
2.  The common bits are `00001010.00010100` (`10.20`). Looking at the third octet: `00011110`(.30), `01000001`(.65), `01011111`(.95), `10100000`(.160). There are no common bits in the third octet.
    -   Supernet Address: **10.20.0.0/16**

### Exercise 5.13

1.  `192.168.44.16`: Subnet `44` is **Student labs**. Host ID `16` is a **Server**.
2.  `192.168.54.50`: Subnet `54` is **Athletics**. Host ID `50` is a **General user station**.
3.  `192.168.4.4`: Subnet `4` is **University administration**. Host ID `4` is a **Managed switch**.
4.  `192.168.53.11`: Subnet `53` is **Campus safety and security**. Host ID `11` is a **Managed wireless device**.

---

## Answers to End-of-Chapter Review Questions

1.  **B. Regional Internet Registry** allocates IP address blocks to large ISPs.
2.  The largest decimal value is **C. 255**.
3.  An IP address must have at least **D. network ID and host ID** parts.
4.  A class C network (/24) using 4 bits for the subnet ID leaves 4 bits for the host ID. 2⁴ - 2 = **A. 14** hosts.
5.  This is **D. directed** broadcasting.
6.  **A. private IPs** are used only internally.
7.  The packet is **E. delivered to all hosts that are in the same subnet as the source host.** (This is a limited broadcast).
8.  NAPT changes the **D. source IP address and maybe source port number**.
9.  `175.140.115.255` with an 8-bit subnet ID means the host part is all 1s. This is a broadcast. **C. The packet is delivered to all hosts within the subnet, 175.140.115.0.**
10. The network plus subnet parts are **C. 10.7.12**. (The question implies the mask is /24).
11. A mask of `255.255.255.0` on a class A network means 16 bits are used for the subnet ID, leaving **D. Eight bits are used to indicate the host identification.**
12. The broadcast address is **A. 65.10.255.255**.
13. Need 14 subnets, so need 4 bits (2⁴=16). Need 14 hosts, so need 4 bits (2⁴-2=14). This works perfectly. The mask is /28 or **C. 255.255.255.240**.
14. For subnet `...16` (/28), the first usable host IP is **B. 192.168.125.17**.
15. For subnet `...32` (/28), the range is `.33` to `.46`. The last usable host IP is **B. 192.168.125.46**.
16. For subnet `...128` (/28), the range is `.128` to `.143`. The broadcast IP is **E. 192.168.125.143**.
17. A `/28` subnet has 4 host bits, so 2⁴ - 2 = **C. 14** usable addresses.
18. **C. 192.168.0.1** is a private IP and needs NAT.
19. The screenshot shows a successful ping to the loopback address. **E. I just tested my computer’s TCP/IP protocol stack.**
20. **A. It is implemented in layer 2 switches.** is INCORRECT. NAT is a Layer 3 function.
21. An address starting with 127 is a loopback address, which can be used for **E. off-line testing of web server pages.**
22. Class B networks use **C. 16** bits for the host ID.
23. A class B network (/16) with a `/24` mask means 8 bits have been borrowed for subnets. 2⁸ = **B. 256** subnets can be created.
24. **C. Reliance on switches than routers...** does not extend IPv4's life.
25. The general delegation process is **C. IANA → Regional Registry → ISPs**.
