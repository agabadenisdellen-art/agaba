# Chapter 2: Architectures and Standards

## Detailed Summary

This chapter delves into the abstract but fundamental concepts of network architecture, layers, standards, and protocols. It explains how these elements work together in a structured framework to enable communication between network nodes.

### 1. Network Architectures: TCP/IP vs. OSI

A standard network architecture is a layered framework (or reference model) that defines the functions required for network communication.

-   **TCP/IP Model:** The dominant architecture of the Internet, managed by the IETF. It originally defined four layers: Application, Transport, Internet, and Network Access.
-   **OSI Model:** A seven-layer model from the ISO. It is more granular than TCP/IP, separating the Application layer into Application, Presentation, and Session, and the Network Access layer into Data Link and Physical.
-   **Hybrid 5-Layer Model:** In practice, a five-layer hybrid model is widely used, combining the strengths of both. This is the model used for explanation throughout the book:
    1.  **Application Layer (Layer 5):** Handles application-to-application communication (e.g., browser-to-server).
    2.  **Transport Layer (Layer 4):** Provides end-to-end (host-to-host) connectivity and reliability.
    3.  **Internet Layer (Layer 3):** Manages inter-networking (routing packets across different subnetworks).
    4.  **Data Link Layer (Layer 2):** Handles intra-networking (moving frames within a single subnetwork).
    5.  **Physical Layer (Layer 1):** Transports the raw bits as signals over the physical medium.

### 2. Protocol Data Units (PDUs) and Encapsulation

Each layer (except the Physical Layer) produces a discrete message unit called a **Protocol Data Unit (PDU)**. As data moves down the layers on the sending host, it undergoes **encapsulation**, where each layer adds its own header (and sometimes a trailer) to the PDU from the layer above.

-   **Application Layer PDU (APDU):** The original data from the application (e.g., an HTTP request). It has no special name.
-   **Transport Layer PDU:**
    -   **Segment (TCP):** Created when a TCP header is added to the APDU.
    -   **Datagram (UDP):** Created when a UDP header is added.
-   **Internet Layer PDU:**
    -   **Packet:** Created when an IP header is added to the segment or datagram. The primary goal of networking is the successful delivery of IP packets.
-   **Data Link Layer PDU:**
    -   **Frame:** Created when a Data Link header and trailer are added to the packet. This is the final PDU before being converted to signals.

The receiving host performs **de-encapsulation**, a reverse process where headers and trailers are stripped away at each layer as the data moves up toward the application.

### 3. Layer Functions

-   **Application Layer (Layer 5):** Client and server programs exchange data using specific protocols like HTTP (web), SMTP (email), FTP (file transfer), DNS, and DHCP.

-   **Transport Layer (Layer 4):** Establishes a logical end-to-end connection between hosts. Its two main protocols are TCP and UDP.
    -   **TCP (Transmission Control Protocol):** A **reliable**, **connection-oriented** protocol.
        -   **Reliability:** Uses **error control** (acknowledgments to ensure data arrives correctly) and **flow control** (managing transmission speed).
        -   **Connection-Oriented:** Establishes a formal session via a **three-way handshake** (SYN, SYN-ACK, ACK) before data is exchanged.
    -   **UDP (User Datagram Protocol):** An **unreliable**, **connectionless** protocol.
        -   It does not perform error/flow control or establish a session. This makes it fast and efficient, ideal for real-time applications like video streaming or VoIP where speed is more critical than perfect reliability.
    -   **Port Management:** Both TCP and UDP use 16-bit port numbers to identify the specific application a message is intended for (e.g., port 80 for HTTP). A **socket** is the combination of an IP address and a port number (e.g., `30.30.30.1:80`).

-   **Internet Layer (Layer 3):** Responsible for **inter-networking**—routing IP packets across different subnetworks.
    -   **Packet Creation:** Creates IPv4 or IPv6 packets, adding a header with source/destination IP addresses and other control information like Time To Live (TTL).
    -   **Routing Decisions:** Routers at this layer make decisions on the best path to forward a packet toward its final destination.
    -   **ICMP (Internet Control Message Protocol):** A supervisory protocol at this layer used for diagnostics, like `ping` (to test connectivity) and `traceroute` (to map the path a packet takes).

-   **Data Link Layer (Layer 2):** Responsible for **intra-networking**—transporting frames within a single subnetwork using MAC addresses.
    -   **Frame Creation:** Encapsulates IP packets into frames (e.g., Ethernet frames).
    -   **Switching:** Switches operate at this layer, using destination MAC addresses to forward frames to the correct host within a LAN.
    -   A **data link** is a single path between two nodes within a subnetwork. When a packet crosses multiple routers to reach its destination, it travels over multiple distinct data links.

-   **Physical Layer (Layer 1):** Responsible for converting the binary bits of a frame into signals (electrical, light, or radio) and transmitting them over the physical medium (e.g., copper cable, fiber optics, air).

### 4. Layer Implementation in a Host

-   **Application Layer:** Implemented in user applications (e.g., web browser, email client).
-   **Transport & Internet Layers:** Implemented within the computer's operating system (e.g., the TCP/IP stack in Windows).
-   **Data Link & Physical Layers:** Implemented in the hardware of the Network Interface Card (NIC).

---

## Answers to In-Chapter Exercises

### Exercise 2.1

*This exercise requires using an HTTP viewer tool. The answers below are examples based on a typical request to a standard website.*

1.  **Request Header Information:** Items include the `Host` (the website being requested), `User-Agent` (the browser and OS), `Accept` (the types of content the browser can handle), `Accept-Language`, `Accept-Encoding`, and `Connection` type.
2.  **Server Response:**
    *   **a.** The response message is divided into two parts: **Header** and **Content (or Data/Body)**.
    *   **b.** The value `200` means **"OK"**, indicating the request was successful.
    *   **c.** This depends on the server, but a common version is **HTTP/1.1**.
    *   **d.** The web server program could be **Apache**, **nginx**, or **Microsoft-IIS**.
    *   **e.** The operating system could be **Unix**, **Linux**, or **Windows**.
    *   **f.** The total size is found in the `Content-Length` header (for the content) plus the size of the header itself.
    *   **g.** The message header size varies but is typically a few hundred bytes.
    *   **h.** The content size is specified by the **`Content-Length`** header.
    *   **i.** The content type is specified by the **`Content-Type`** header (e.g., `text/html`, `image/jpeg`).

### Exercise 2.2

1.  **Trying http://11.22.33.44 and http://11.22.33.44:80:** Both URLs should load the same webpage. This is because port 80 is the default port for HTTP. When you type a URL without a port, the browser automatically connects to port 80. Explicitly adding `:80` does the same thing.
2.  **Trying http://11.22.33.44:70:** This will likely result in a "This site can’t be reached" or "Connection refused" error. This is because web servers are configured to listen for HTTP requests on port 80, not port 70 (or other random ports). The server is not running any service on that port to accept the connection.

### Exercise 2.3

*Based on the screenshot in Figure 2.10:*

1.  **Analysis of TCP Sessions:**
    *   **a. How many different sessions?** There are **seven** sessions listed (seven lines with `ESTABLISHED`).
    *   **b. How many different source sockets?** There are **seven** unique source sockets (the combination of `130.191.8.211` and a unique ephemeral port like `1341`, `1342`, etc.).
    *   **c. Port range for source sockets:** The ports range from **1341 to 1347**.
    *   **d. How many different destination sockets?** There is only **one** destination socket: `130.191.8.198:80`.
    *   **e. Server port used:** Port **80** (the standard HTTP port).
    *   **f. Server name of 130.191.8.198:** Using `nslookup 130.191.8.198` would likely resolve to a hostname associated with San Diego State University, such as `www.sdsu.edu`, based on the context of the book.

2.  **Observing `netstat -n`:** Running this command after visiting a website will show multiple TCP connections being established from your local IP (with various high-numbered ephemeral ports) to the website's server IP on port 80 (for HTTP) or 443 (for HTTPS). Each connection corresponds to a different resource (HTML file, images, scripts) being downloaded to render the page.

### Exercise 2.4

1.  **Whois Search for IPs in Figure 2.14:** This requires a live search on `arin.net`. The IPs would likely trace back through a local ISP (like Cox, Comcast), then to a larger network backbone provider (like Level 3, Cogent), and finally to the ISP hosting Yahoo's servers. The last IP, `209.131.36.158`, belongs to Yahoo.

2.  **Ping vs. Tracert Delays:** Pinging the first three routers should show round-trip times very similar to the times reported by `tracert` for those same hops, as both tools measure latency. `tracert` simply does this for every hop along the path.

### Exercise 2.5

*Referring to Figure 2.15:*

1.  **Data links from Laptop1:** There are **three** possible data links: to PC4, to Server1, and to the router R3's LAN port (Fa0/1).
2.  **Data links from PC4:** There are **three** possible data links: to Laptop1, to Server1, and to the router R3's LAN port (Fa0/1).
3.  **Data links from Laptop1 involving >1 device:** The links from Laptop1 to Server1 and to R3(Fa0/1) both involve two intermediary devices (the Wireless AP and SW3).
4.  **Data links from PC4 involving >1 device:** None. The links from PC4 to Laptop1, Server1, and R3(Fa0/1) all go through only one device, SW3.
5.  **Frame from Server1 to R3(Fa0/1):**
    -   Source MAC: Server1's MAC (`00-11-22-A4-B4-C4`)
    -   Destination MAC: R3(Fa0/1)'s MAC (`00-11-22-A5-B5-C5`)
    -   No, the addresses do not change while passing through SW3.
6.  **Frame from Laptop1 to R3(Fa0/1):**
    -   Source MAC: Laptop1's MAC (`00-11-22-A2-B2-C2`)
    -   Destination MAC: R3(Fa0/1)'s MAC (`00-11-22-A5-B5-C5`)
    -   No, the MAC addresses do not change. The AP and switch are layer 2 devices that forward the frame without altering the source/destination MACs.

### Exercise 2.6

*Referring to Figure 2.17:*

1.  **Data links from IP Phone:** There are **five** possible data links: to PC1, PC2, Laptop1, Server1, and R1's port connecting to R2.
2.  **Data links from PC1:** There are **five** possible data links: to IP Phone, PC2, Laptop1, Server1, and R1's port connecting to R2.
3.  **Data links from IP Phone >1 device:** The links to PC2, Laptop1, and Server1 all involve multiple intermediary devices (switches and routers).
4.  **Data links from PC1 >1 device:** The links to PC2, Laptop1, and Server1 all involve multiple intermediary devices.
5.  **IP Phone to Laptop1 (via R1 and R3):** There are **three** data links: (1) IP Phone to R1, (2) R1 to R3, and (3) R3 to Laptop1.
6.  **Laptop1 to PC2 (via R3-R1-R2):** There are **four** data links: (1) Laptop1 to R3, (2) R3 to R1, (3) R1 to R2, and (4) R2 to PC2.
7.  **IP packet from PC1 to Server1:**
    -   Initial Frame (on LAN1): Source MAC = PC1's MAC, Destination MAC = R1's MAC.
    -   Last Frame (on LAN3): Source MAC = R3's MAC, Destination MAC = Server1's MAC.
    -   Yes, the data link addresses (MACs) change at every router hop.
8.  **IP packet from PC1 to Server1 (via R1 and R3):** **Three** different frames are formed, one for each data link (PC1->R1, R1->R3, R3->Server1).
9.  This question is ambiguously phrased. The IP packet never has a MAC address. The *final frame* that delivers the IP packet to Server1 will have Source MAC = R3's MAC and Destination MAC = Server1's MAC.
10. **IP packet from PC1 to Laptop1 (via R1 and R3):** **Three** different frames are formed. The final frame that goes from R3 to Laptop1 will be a WiFi frame, while the others will be Ethernet/WAN frames.

### Exercise 2.7

*Referring to Figure 2.17:*

1.  **LANs and WAN connections:** There are 3 LANs and 3 WAN connections.
2.  **Physical links between PC1 and Server1 (via R1, R3):**
    -   PC1 -> S1
    -   S1 -> R1
    -   R1 -> R3 (WAN link)
    -   R3 -> S3
    -   S3 -> Server1
    -   Total: **5 physical links**.
3.  **Physical links between Laptop1 and PC2 (via R3-R1-R2):**
    -   Laptop1 -> WAP
    -   WAP -> S3
    -   S3 -> R3
    -   R3 -> R1 (WAN link)
    -   R1 -> R2 (WAN link)
    -   R2 -> S2
    -   S2 -> PC2
    -   Total: **7 physical links**.
4.  **Signaling features between SW1-Hub link and R1-R2 link:** No, they will not be identical. The SW1-Hub link is a LAN link (likely Ethernet using digital signaling over a copper cable), whereas the R1-R2 link is a WAN link (e.g., a leased line using a different signaling scheme, possibly over fiber). They are different Layer 1 technologies.

---

## Answers to End-of-Chapter Review Questions

1.  The standard **B. architecture** broadly depicts necessary functions of computer networking in a layer structure.
2.  All layers have their own PDU, except the **E. physical** layer.
3.  An email message goes through encapsulations in the sequence of **A. segment–packet–frame**.
4.  **B. Transport and internet layers** are generally built into an operating system.
5.  The socket is **C. the combination of an IP address and a port number**.
6.  **D. TCP is a reliable protocol.**
7.  The TCP port is used to **B. forward a service request/response to a specific application**.
8.  The **C. SYN** bit in the TCP header is used to request handshaking.
9.  **A. Application layer—to establish sessions (or handshaking)** is NOT accurate (this is the Transport layer's job).
10. **C. Physical layer and data link layer** functions are implemented in the NIC.
11. **E. Three-way video conferencing over the Internet** most likely depends on UDP.
12. Port numbers have to be included in the header of **D. segments and datagrams**.
13. **E. Burden on the network: High (TCP) vs. Low (UDP)** is CORRECT. TCP requires acknowledgments, adding traffic.
14. The TTL value indicates the maximum number of **B. routers** a packet can go through.
15. `netstat -n` can be issued to **B. list sockets in TCP sessions**.
16. **C. The semantics of a protocol is about how to interpret PDUs exchanged.** is the CORRECT statement.
17. **B. 1** packet is produced. The packet itself is not changed, only the frame that carries it is rebuilt at each hop.
18. The IP packet is encapsulated within the **D. frame** to travel to the destination node *within a subnetwork*.
19. If a host develops a TCP segment with source port 80, it is most likely a **C. web server** (responding to a client request).
20. **D. Well-known port numbers are generally assigned to server applications.** is CORRECT.
21. The two hosts communicate based on **A. ICMP (Internet Control Message Protocol)**.
22. End-to-end error control and flow control are performed in the **C. transport** layer.
23. **E. DHCP = internet layer** is a mismatch (DHCP is an Application layer protocol).
24. **D. Frame** generally has a header and a trailer.
25. `tracert` uses **C. DNS and ICMP**. It first uses DNS to resolve the hostname (www.gmail.com) to an IP address, then uses ICMP to trace the route.
