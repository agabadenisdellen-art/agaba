# Chapter 8: Wireless LAN (WiFi)

## Detailed Summary

This chapter provides a comprehensive overview of Wireless LAN (WiFi) technology, standardized as IEEE 802.11. It covers WiFi's operational modes, the role of access points, key terminology, media access control methods, and the evolution of WiFi standards.

### 1. WiFi Setup Modes

-   **Ad Hoc Mode (Peer-to-Peer):** Wireless devices connect directly to each other without a central access point. Useful for small, temporary networks.
-   **Infrastructure Mode:** The most common setup, where wireless devices connect to a **Wireless Access Point (AP)**, which acts as a bridge to a wired network (usually Ethernet).

### 2. Wireless Access Point (AP)

An AP is a Layer 2 device that is central to an infrastructure-mode WiFi network.

-   **Primary Function:** Acts as a **translational bridge**, converting 802.11 WiFi frames to 802.3 Ethernet frames and vice versa.
-   **Other Key Functions:**
    -   **Authentication:** Verifies that a client is allowed to join the network.
    -   **Association:** Manages the list of connected clients.
    -   **Media Access Control:** Manages the shared wireless medium to prevent collisions.
-   **Operational Modes (besides standard AP mode):**
    -   **Repeater Mode:** Extends the range of a wireless network by re-broadcasting signals from another AP.
    -   **Bridge Mode:** Connects two wired networks together wirelessly.

### 3. Key WiFi Terminology

-   **SSID (Service Set Identifier):** The public name of a wireless network (e.g., "CoffeeShop_WiFi"). APs broadcast their SSID in **beacon frames** so clients can discover and connect to them.
-   **BSS (Basic Service Set):** The area of coverage provided by a single AP. It is a single **collision domain**.
-   **BSSID (Basic Service Set Identifier):** The unique, 48-bit identifier for a BSS, which is simply the **MAC address** of the access point.
-   **ESS (Extended Service Set):** A larger network formed by connecting two or more BSSs (APs) via a wired backbone, all sharing the same SSID. This allows for **roaming**, where a client can move seamlessly from one AP's coverage area to another.

### 4. Media Access Control in WiFi

Because wireless is a shared medium, a mechanism is needed to prevent multiple devices from transmitting at the same time and causing collisions.

-   **CSMA/CA (Carrier Sense Multiple Access with Collision Avoidance):** The primary MAC protocol for WiFi.
    -   **Process:**
        1.  A station "listens" to see if the channel is clear (Carrier Sense).
        2.  If it is clear, it waits for a random back-off time (Collision Avoidance).
        3.  If the channel is still clear, it transmits its frame.
        4.  The AP sends back an **Acknowledgment (ACK)** frame to confirm successful receipt. If no ACK is received, the station assumes a collision occurred and retransmits.
-   **RTS/CTS (Request to Send/Clear to Send):** An optional mechanism to solve the "hidden node" problem, where two clients can both hear the AP but cannot hear each other. The client sends an RTS, and the AP responds with a CTS, which tells all other clients to remain silent.

### 5. WiFi and Radio Frequency

-   **ISM Bands (Industrial, Scientific, and Medical):** WiFi operates in unlicensed radio frequency bands that are free for public use.
    -   **2.4 GHz Band:** Offers longer range but is more crowded (interference from microwaves, Bluetooth) and has fewer non-overlapping channels.
    -   **5.0 GHz Band:** Offers shorter range but has much higher speeds, less interference, and many more non-overlapping channels.
-   **Channels:** Each band is divided into smaller channels. To avoid interference in an ESS, adjacent APs must be set to **non-overlapping channels** (e.g., channels 1, 6, and 11 in the 2.4 GHz band).

### 6. Authentication and Association

Before a client can send data, it must go through a three-stage process:

1.  **Unauthenticated/Unassociated:** The initial state.
2.  **Authenticated/Unassociated:** The client proves its identity to the network. Methods include:
    -   **Open Authentication:** No real authentication; anyone can connect. Used on public guest networks.
    -   **Pre-Shared Key (PSK):** A password (passphrase) is shared between the AP and all clients. This is common for home and small office networks (WPA2-Personal).
    -   **Authentication Server (e.g., RADIUS):** Each user has unique credentials, which are verified by a central server. Used in enterprise environments (WPA2-Enterprise).
3.  **Authenticated/Associated:** Once authenticated, the client formally joins the network by associating with the AP.

### 7. Evolution of WiFi Standards

-   **Legacy (802.11a/b/g):** Offered speeds from 11 Mbps to 54 Mbps using **SISO (Single-Input Single-Output)**, meaning one data stream at a time.
-   **802.11n (Wi-Fi 4):** A major upgrade, introducing several key technologies:
    -   **MIMO (Multiple-Input Multiple-Output):** Uses multiple antennas to send multiple data streams simultaneously, dramatically increasing speed (up to 600 Mbps). This was **single-user MIMO**.
    -   **Channel Bonding:** Combines two adjacent 20 MHz channels into a single 40 MHz channel to double the bandwidth.
    -   **Dual-Band:** Capable of operating on both 2.4 GHz and 5.0 GHz bands.
-   **802.11ac (Wi-Fi 5):** Further improved on 802.11n:
    -   **5.0 GHz Only:** Operates exclusively in the cleaner, faster 5 GHz band.
    -   **Wider Channel Bonding:** Can bond channels up to 80 MHz or even 160 MHz wide.
    -   **MU-MIMO (Multi-User MIMO):** Allows an AP to transmit to multiple clients *at the same time*, a significant improvement in efficiency.
-   **WiFi Mesh Network (IEEE 802.11s):** A standard for creating large-scale wireless networks where APs (mesh points) can relay traffic wirelessly to each other, reducing the need for extensive wired backhaul.

### 8. WiFi Home/SOHO Network

A typical home network consists of:
-   **Broadband Modem (DSL/Cable):** Connects the home to the ISP's network.
-   **Wireless Access Router:** A single device that combines the functions of:
    -   A **Router:** To connect the home LAN to the Internet (WAN).
    -   An **AP:** To provide WiFi connectivity.
    -   A **Switch:** To provide wired Ethernet ports.
    -   A **DHCP Server:** To automatically assign private IP addresses to devices.
    -   A **NAT Gateway:** To allow all home devices to share a single public IP address from the ISP.

---

## Answers to In-Chapter Exercises

### Exercise 8.1

1.  **Bandwidth of ISM Bands:**
    -   900 MHz Band: 928 - 902 = **26 MHz**
    -   2.4 GHz Band: 2.4835 - 2.4 = **83.5 MHz**
    -   5.0 GHz Band: 5.825 - 5.180 = **645 MHz**

2.  **Relative Capacity:** The 5.0 GHz band has significantly more bandwidth (645 MHz) than the 2.4 GHz band (83.5 MHz), which in turn has more than the 900 MHz band (26 MHz). This is why 5 GHz WiFi can achieve much higher speeds.

### Exercise 8.2

-   A 2.4 GHz channel has 20 MHz (20,000 kHz) of usable bandwidth.
-   A voice call requires 4 kHz.
-   Number of calls per channel = 20,000 kHz / 4 kHz = **5,000 voice calls**.
-   The entire 2.4 GHz band has 83.5 MHz (83,500 kHz) of bandwidth.
-   Number of calls in the entire band = 83,500 kHz / 4 kHz = **20,875 voice calls**.

### Exercise 8.3

1.  **Smallest number of SSIDs:** At least **two**. One for the main corporate network and one for the guest network.
2.  **BSSs:** There are **five** APs, so there are **five** BSSs.
3.  **BSSIDs:** Each AP has a unique MAC address, so there will be **five** BSSIDs.
4.  **ESSs:** There are **two** ESSs (one for corporate, one for guest).
5.  **Repeater Mode AP:** AP2 could be in repeater mode, as it is shown without a wired connection, extending the signal from AP1.
6.  **AP4 and AP5 concurrently:** Yes. An AP can be dual-band, broadcasting an 802.11g network on 2.4 GHz and an 802.11n network on 5 GHz simultaneously.
7.  **Subnets:** There are **three** subnets (Corporate LAN, Guest LAN, and the WAN link between the Router and the Internet).
8.  **Router Port IPs:**
    -   The problem states to use the third octet for subnets. Let's assign them: Corporate = `172.16.1.0/24`, Guest = `172.16.2.0/24`.
    -   The last available IP address is `.254`.
    -   Fa0/0 (Corporate): **172.16.1.254**
    -   Fa0/1 (Guest): **172.16.2.254**
    -   Fa0/2 (Internet): This would be a public IP from the ISP.
9.  **IP Addresses:** H4, H5, H6 would be in the `172.16.1.0/24` range. H7 would be in the `172.16.2.0/24` range.
10. This requires creating hypothetical MAC addresses.
11. The switch tables would be built based on the MAC addresses of the hosts and the VLANs assigned (if any). Without VLANs, all ports would be in VLAN 1.
12. A broadcast from H4 (on the corporate LAN) would be forwarded by S2 to all other ports, reaching S3, S4, H5, H6, and the router's Fa0/0 port. It would **not** cross the router to the guest network.
13. If the corporate subnet is split into two VLANs, the link between S2 and S3, and the link between S2 and S4 would need to be configured as **trunk ports**.
14. If you create two VLANs within the corporate network and pair them to new subnets, you would now have **three** ESSs in total (one for each VLAN and one for the guest network), assuming SSID is mapped to VLAN.

### Exercise 8.4

*This is a hands-on exercise. The expected results would be:*
-   **Vistumbler/`netsh`:** You would see a list of nearby WiFi networks, their SSIDs, MAC addresses (BSSIDs), signal strength (RSSI), channel, and security type (e.g., WPA2).
-   **Attacker Use:** An attacker would find this information useful to identify weakly secured networks (e.g., those using WEP or Open authentication) or to plan an "evil twin" attack by mimicking a legitimate network's SSID and channel.

### Exercise 8.5

If the router is bundled with the modem, the topology changes:
1.  The **Router/Modem combo** device connects directly to the ISP line (phone/cable).
2.  Its LAN port connects via an Ethernet cable to the WAN/Internet port of the separate **Wireless Access Router**.
3.  The Wireless Access Router's WAN port would get a private IP from the Router/Modem combo's DHCP server (e.g., `192.168.0.100`).
4.  The Wireless Access Router would then perform a *second* NAT (this is called double NAT) and provide a different private IP range to the home devices (e.g., `192.168.1.x`).

### Exercise 8.6

1.  **Public IP:** `24.18.21.15`
2.  **Who provides it?** The **ISP's DHCP server**.
3.  **Subnet of public IP:** `24.18.16.0` (based on the `/21` mask, or `255.255.248.0`).
4.  **ISP DHCP server:** `68.87.73.242`
5.  **ISP DNS servers:** `68.87.73.242` and `68.87.75.242`.
6.  **Home network subnet:** `192.168.1.0`.
7.  **Default gateway for home computers:** `192.168.1.1` (the router's LAN IP).
8.  **Hosts on home network:** `/24` mask means 8 host bits, so 2⁸ - 2 = **254** hosts.
9.  **NAT:** Yes. It's translating the private `192.168.1.x` addresses to the single public `24.18.21.15` address.
10. **Internal DHCP:** Yes, it is enabled and is assigning IPs in the range `192.168.1.100` to `192.168.1.149`.

### Exercise 8.7

To separate guest and internal traffic, the best solution is to use **VLANs**:
1.  **Create two VLANs** on the switch: VLAN 10 for "Internal" and VLAN 20 for "Guest".
2.  Assign the switch ports connected to the internal workstations and server to **VLAN 10**.
3.  Assign the switch port connected to the Wireless AP to **VLAN 20**.
4.  Connect the router to a **trunk port** on the switch.
5.  Configure the router with **sub-interfaces** (Router-on-a-Stick):
    -   One sub-interface for the Internal VLAN (`192.168.50.1/24`).
    -   One sub-interface for the Guest VLAN (`192.168.60.1/24`).
6.  Create **Access Control Lists (ACLs)** on the router to block traffic between the two VLANs. Specifically, create a rule that **denies** any traffic sourced from the Guest subnet (`192.168.60.0/24`) destined for the Internal subnet (`192.168.50.0/24`).
7.  Allow both subnets to access the Internet. This design securely isolates the two networks while allowing both to have internet access through a single router.

---

## Answers to End-of-Chapter Review Questions

1.  An AP in **D. repeater** mode can extend the range of a WiFi network.
2.  With **D. Request to Send/Clear to Send**, a station must obtain permission before transmitting.
3.  An ACK is delivered in a **A. control** frame.
4.  A home wireless router does NOT have a **E. CSU/DSU** function.
5.  The 2.4 GHz band supports **B. 3** non-overlapping channels in North America.
6.  **D. At a home network, the pre-shared key is derived from the password/passphrase.** is CORRECT.
7.  The two authentication solutions are open and **A. pre-shared key**.
8.  Bluetooth is a standard for **B. PAN**.
9.  5.0 GHz band (645 MHz) vs 2.4 GHz band (83.5 MHz). The 5.0 GHz band is roughly 7.7 times larger. The closest answer is **D. The bandwidth of the 5.0 GHz band is roughly eight times larger...**.
10. Laptops avoid collisions by **C. Using random back-off time even when the network is quiet**.
11. Key functions of the AP do NOT include: **C. Dynamic allocation of radio transmission channels to neighboring wireless access points.** (Channels are typically configured manually to avoid interference).
12. **B. association request—management frame** is ACCURATE.
13. **C. Radio waves used for WiFi are in the frequency range of microwaves.** is CORRECT.
14. **D. The ad hoc mode is more popular than the infrastructure mode...** is NOT true. Infrastructure mode is far more common.
15. A **D. service set identifier** is sometimes all it takes to join a network (in open authentication).
16. The MAC layer of 802.11 does all except **E. choosing a transmission channel randomly.** (The channel is pre-configured).
17. **E. It supports QoS to deliver time-sensitive frames without delays.** is a CORRECT statement about 802.11n.
18. WiFi details are defined at the **B. physical and data link layers only**.
19. **B. evil twin** is a security threat where a hacker sets up a fake AP.
20. **D. DOS** can result from a continuous stream of CTS frames.
21. **A. MITM attack** describes setting up a rogue DHCP server to intercept traffic.
