# Chapter 6: Fundamentals of Packet Routing

## Detailed Summary

This chapter explains the core concepts of IP packet routing, focusing on how routers make forwarding decisions. It covers the structure of a routing table, the different types of routes, and the function of dynamic routing protocols.

### 1. Routing Mechanism

Routing is the Layer 3 process of forwarding IP packets from a source network to a destination network across one or more intermediary routers.

-   **Process:** When a router receives an IP packet, it examines the packet's destination IP address and consults its **routing table** to determine the best path. It then forwards the packet out of the appropriate **exit port (interface)** toward the **next-hop router**.
-   This process is repeated at every router along the path until the packet reaches its final destination network.

### 2. The Routing Table

The routing table is the "brain" of a router, a reference table stored in memory that contains a list of known networks and the information needed to reach them.

-   **Key Elements of a Routing Table Entry:**
    -   **Destination Subnetwork and Subnet Mask:** The address of the network the router knows how to reach. Routers store network addresses, not individual host addresses.
    -   **Exit Port/Interface:** The physical port on the router that the packet should be sent out of to get to the destination.
    -   **Next-Hop IP Address:** The IP address of the next router in the path to the destination. This is the router that the current router will forward the packet to.
    -   **Metric:** A value that represents the "cost" of a particular route. Routers use this to determine the *best* path when multiple paths to the same destination exist. A lower metric is better. Metrics can be calculated based on:
        -   **Hop Count:** The number of routers a packet must cross (simplest metric).
        -   **Bandwidth:** The speed of the links in the path (higher bandwidth = lower cost).
        -   **Delay:** The time it takes to traverse the path.
        -   **Load & Reliability:** The current traffic level and stability of the links.

### 3. Packet Forwarding Decision Logic

When a router receives a packet, it applies the following logic:

1.  **Search the Routing Table:** The router compares the packet's destination IP address to all entries in its routing table.
2.  **Find the Best Match (Longest Match Rule):** If multiple entries match the destination IP, the router will always choose the **most specific route**, which is the one with the **longest subnet mask** (e.g., a `/24` route is more specific than a `/16` route).
3.  **Use the Default Route:** If no specific match is found, the router will use the **default route** (`0.0.0.0/0`). This route acts as a gateway of last resort, typically directing traffic toward the Internet.
4.  **Drop the Packet:** If there is no match and no default route, the packet is discarded.

### 4. Types of Routing Table Entries

1.  **Directly Connected Routes:** These are automatically added to the routing table when an interface on the router is configured with an IP address and activated. The router has zero cost to reach these networks because they are physically attached.
2.  **Static Routes:** These are manually configured by a network administrator. They are useful for small, stable networks or for defining a default route, but they do not adapt to network changes automatically.
3.  **Dynamic Routes:** These are learned automatically by the router through communication with other routers. This is achieved using a **dynamic routing protocol**.

### 5. Dynamic Routing Protocols

A dynamic routing protocol is a set of rules and algorithms that routers use to share information about the networks they can reach and the "cost" to get there. This allows routers to automatically build and update their routing tables.

-   **Routing Protocol vs. Routed Protocol:**
    -   **Routing Protocol** (e.g., OSPF, RIP): Used by routers to *talk to each other* and build routing tables.
    -   **Routed Protocol** (e.g., IP): The protocol for the actual user data packets that are being *forwarded* by the routers.

-   **Categories of Dynamic Routing Protocols:**
    -   **Interior Gateway Protocol (IGP):** Used for routing *within* a single **Autonomous System (AS)**—a network under a single administrative control (e.g., a corporate or university network).
        -   Examples: **RIP** (Routing Information Protocol), **OSPF** (Open Shortest Path First), **EIGRP** (Cisco proprietary).
    -   **Exterior Gateway Protocol (EGP):** Used for routing *between* different Autonomous Systems. The primary EGP of the Internet is **BGP** (Border Gateway Protocol).

-   **How They Work (OSPF Example):**
    1.  Routers discover their neighbors running the same protocol.
    2.  Each router advertises information about its directly connected links (its **link-state**) to all other routers in the AS.
    3.  Each router collects all the link-state advertisements to build a complete map of the entire network topology.
    4.  Using this map, each router independently calculates the shortest (lowest cost) path to every destination network using an algorithm (like Dijkstra's algorithm).
    5.  The best paths are then installed into the routing table.

### 6. Inter-Domain Routing (BGP)

Routing between large networks on the Internet (between different ASs) is handled by BGP. BGP doesn't focus on speed or the shortest path in the same way an IGP does. Instead, it makes routing decisions based on policy, relationships between ISPs, and the path of Autonomous Systems a packet must cross.

---

## Answers to In-Chapter Exercises

### Exercise 6.1

1.  **R2's Routing Table (Figure 6.2):**
    | Destination Subnet | Subnet Mask     | Exit Port |
    | ------------------ | --------------- | --------- |
    | 172.20.2.0         | 255.255.255.0   | Fa0/1     |
    | 172.20.3.0         | 255.255.255.0   | Fa0/0     |
    | 172.20.1.0         | 255.255.255.0   | Fa0/1     |

### Exercise 6.2

1.  **Based on Figure 6.2:**
    *   **a. R2's routing table with next-hop and metric:**
        | Destination | Mask            | Exit Port | Next-Hop IP   | Metric (Hops) |
        | ----------- | --------------- | --------- | ------------- | ------------- |
        | 172.20.3.0  | 255.255.255.0   | Fa0/0     | N/A           | 0             |
        | 172.20.2.0  | 255.255.255.0   | Fa0/1     | N/A           | 0             |
        | 172.20.1.0  | 255.255.255.0   | Fa0/1     | 172.20.2.253  | 1             |
    *   **b. R1's next-hop to Server:** N/A (Server is on a directly connected network for R1).
    *   **c. R2's next-hop to Server:** `172.20.2.253`
    *   **d. R1's exit port to Server:** `Fa0/1`
    *   **e. R2's exit port from Server to PC1:** `Fa0/1`
    *   **f. R2's next-hop from Server to PC2:** N/A (PC2 is on a directly connected network for R2).
    *   **g. R2's next-hop from Server to PC1:** `172.20.2.253`

2.  **Based on Figure 6.3:**
    -   **R1 Routing Table:**
        | Destination     | Mask            | Exit Port | Next-Hop IP    | Hops |
        | --------------- | --------------- | --------- | -------------- | ---- |
        | 10.10.1.0       | 255.255.255.0   | Fa0/0     | N/A            | 0    |
        | 192.168.10.0    | 255.255.255.0   | S0/0/1    | N/A            | 0    |
        | 172.16.1.0      | 255.255.255.0   | S0/0/1    | 192.168.10.2   | 1    |
    -   **R2 Routing Table:**
        | Destination     | Mask            | Exit Port | Next-Hop IP    | Hops |
        | --------------- | --------------- | --------- | -------------- | ---- |
        | 172.16.1.0      | 255.255.255.0   | Fa0/0     | N/A            | 0    |
        | 192.168.10.0    | 255.255.255.0   | S0/0/0    | N/A            | 0    |
        | 10.10.1.0       | 255.255.255.0   | S0/0/0    | 192.168.10.1   | 1    |

### Exercise 6.3

1.  **Matching `100.50.30.10`:**
    -   `100.50.30.0/16`: Match (Incorrect mask notation for the network, but matches the first 16 bits).
    -   `100.40.30.0/16`: No Match.
    -   `100.50.30.0/8`: Match.
    -   `100.50.30.0/25`: No Match (The 25th bit doesn't match).
    -   `100.50.15.0/16`: Match.
    -   `100.50.30.0/24`: **Match (Longest Match)**.
    -   `100.50.10.0/24`: No Match.
    -   `100.50.0.0/24`: No Match.
    -   `100.0.0.0/16`: No Match.
    -   `100.50.0.0/18`: Match.
    -   `100.48.30.0/21`: Match.
    -   `100.27.0.0/15`: No Match.

2.  **Exit Port Decisions:**
    *   **a. Dest: 172.164.32.25:** Matches `172.164.32.0/20` (not listed, but would). The longest match in the list is `/21` for `172.164.32.0`. So, exit port is **S0/0/0**.
    *   **b. Dest: 142.66.39.125:** The longest match is `142.66.39.64/25`. Exit port is **Fa0/1**.
    *   **c. Dest: 11.87.234.111:** The longest match is `11.87.234.60/27`. Exit port is **S0/0/0**.

### Exercise 6.4

1.  **Commands for R1's Fa0/1 (Figure 6.1):**
    ```
    R1(config)# interface Fastethernet0/1
    R1(config-if)# ip address 172.20.2.254 255.255.255.0
    R1(config-if)# no shutdown
    ```
2.  **Directly connected routes for R1 (Figure 6.3):** Two (10.10.1.0/24 and 192.168.10.0/24).
3.  **Commands for R1's S0/0/1 (Figure 6.3):**
    ```
    R1(config)# interface Serial0/0/1
    R1(config-if)# ip address 192.168.10.1 255.255.255.0
    R1(config-if)# no shutdown
    ```

### Exercise 6.6

1.  **Based on Figure 6.4:**
    *   a. Default gateway for PC1: `192.168.1.254` (R1's IP). For PC2: `172.20.1.254` (R2's IP). For Server 1: `10.10.1.254` (R3's IP).
    *   b. Yes, PC1 will receive the response. Server 1 doesn't need a default gateway to respond to a ping from PC1, because PC1 is on a known network in R3's routing table. R3 knows how to route the reply back to the `192.168.1.0` network via R1.
    *   c. No, PC1 will not receive the response. PC1 needs a default gateway to send the initial ping packet to Server 1, which is on a different network. Without it, PC1 will drop the packet.

### Exercise 6.8

1.  **Commands for R2 (Figure 6.13):**
    ```
    R2(config)# router rip
    R2(config-router)# network 172.20.2.0
    R2(config-router)# network 172.20.3.0
    R2(config-router)# end
    ```
2.  **Commands for Figure 6.4:**
    -   **R1:** `router rip`, `network 192.168.1.0`, `network 192.168.10.0`
    -   **R2:** `router rip`, `network 172.20.1.0`, `network 192.168.10.0`
    -   **R3:** `router rip`, `network 10.10.1.0`, `network 192.168.10.0`

---

## Answers to End-of-Chapter Review Questions

1.  The decision is based on the packet's **B. destination IP address**.
2.  The protocol is using the **B. reliability** factor.
3.  The router forwards the packet to the path with the **B. longest match**.
4.  Entries are divided into **C. directly connected routes, static routes, and dynamic routes**.
5.  The **D. default gateway** relays packets beyond the subnet boundary.
6.  Border routers use **A. exterior gateway protocol (EGP)**.
7.  **E. 0.0.0.0/0** is a static default route, not a dynamic route.
8.  **C. border gateway protocol (BGP)** is the most popular EGP.
9.  The router makes a decision **A. Once for each packet that it receives**.
10. **A. RIP** is a good choice for a relatively small network.
11. Routers use the **B. dynamic routing protocol** to share information.
12. **D. A university can have several internal routers that run the same interior gateway routing protocol.** is CORRECT.
13. Destination `183.69.53.151`. The longest match is `/22` (`183.69.52.0`). Exit port is **D. Fa0/1**.
14. Destination `200.100.150.140`. The longest match is `/24` (`200.100.150.0`). Exit port is **A. S0/0/0**.
15. The router **E. selects the matching row with the highest or the lowest value depending on the metric.** (For metrics like bandwidth, higher is better, which translates to a lower cost. For metrics like hop count, lower is better).
16. **E. physical distance to the next router** is LEAST used.
17. R1 has **C. 3** links (to PC1, to R2, to R3).
18. **E. Operating system of the router** would not be included in a link-state advertisement.
19. There are 3 LANs + 4 WAN links = **D. 7** subnets.
20. The common bits for `165`, `145`, `185` are `10`. So the prefix is 16+2=18. Supernet is **E. 10.30.192.0/18**. (This is incorrect, let's re-calculate). `165`=`10100101`, `145`=`10010001`, `185`=`10111001`. The common prefix is just `10`. So it's `/18`. The network would be `10.30.128.0/18`. None of the answers seem correct based on the text's method. Let's assume the question meant `10.30.160.0/24`, `10.30.144.0/24`, and `10.30.176.0/24`. The common prefix would be `/20`. `10.30.160.0/20`. Let's stick with the original question; the closest common ancestor is `10.30.128.0/17`. The question is likely flawed, but `10.30.128.0/18` is the most plausible intended answer structure.
21. The default gateway for PC2 must be on its own subnet (`10.30.20.0`). The only valid IP is **E. 10.30.20.254** (R3's IP on that subnet).
22. Server 1's default gateway is `10.30.6.254`, which is on a different subnet. This is a misconfiguration. **D. The ping request is delivered to Server 1, but PC2 will not receive the ping response.** because Server 1 does not know how to route the reply back.
23. Server 2 has no default gateway. **C. The ping request is delivered to Server 2, but PC1 will not receive the ping response.** because Server 2 doesn't know how to send a reply to a different network.
24. This command creates a **B. Static route** (specifically, a default route).
25. OSPF advertisement from R3 would not include **E. Fa0/0/0’s MAC address is...**. OSPF is a Layer 3 protocol and does not operate with MAC addresses.
