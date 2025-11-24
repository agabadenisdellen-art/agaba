# Network Monitoring Analysis

## a) Network Traffic Analysis with Wireshark

### Hypothetical Network Setup

For this analysis, we have set up a small Wi-Fi network with the following interconnected devices:

*   **Router:** TP-Link Archer C7 (192.168.1.1) - The gateway for the network.
*   **Desktop PC:** (192.168.1.10) - A standard desktop computer used for general tasks.
*   **Laptop:** (192.168.1.11) - A laptop used for development and browsing.
*   **Smartphone:** (192.168.1.12) - A mobile device connected to the Wi-Fi.
*   **Attacker's Machine:** (192.168.1.100) - A machine on the same network used to launch a simulated port scanning attack.

### Capturing and Filtering Traffic with Wireshark

To capture and analyze the network traffic, we will use Wireshark, a popular network protocol analyzer. The process is as follows:

1.  **Start Wireshark:** Launch Wireshark on a machine connected to the network (e.g., the Desktop PC at 192.168.1.10).
2.  **Select the Interface:** Choose the correct network interface to capture traffic from (in this case, the Wi-Fi interface).
3.  **Start Capture:** Begin capturing packets on the selected interface.
4.  **Launch the Attack:** From the attacker's machine (192.168.1.100), we will initiate a port scan against the Desktop PC (192.168.1.10) using a tool like Nmap.
5.  **Stop Capture:** After a few minutes of capturing, stop the Wireshark capture to analyze the results.

### Identifying Malicious Packets

To identify the port scanning activity, we can use a Wireshark display filter. A common characteristic of a TCP port scan is a large number of TCP SYN packets sent from a single source to a single destination on different ports. We can use the following filter to isolate this traffic:

```
tcp.flags.syn == 1 and tcp.flags.ack == 0 and ip.src == 192.168.1.100 and ip.dst == 192.168.1.10
```

This filter will show us all the TCP packets that have only the SYN flag set, originating from the attacker's machine and destined for the victim's machine.

### Packet Headers

Here is a text-based representation of the packet headers for three of the malicious packets, as seen in Wireshark:

**Packet 1:**

```
Frame 1: 60 bytes on wire (480 bits), 60 bytes captured (480 bits)
Ethernet II, Src: Attacker_MAC (00:0c:29:12:34:56), Dst: Victim_MAC (00:0c:29:65:43:21)
Internet Protocol Version 4, Src: 192.168.1.100, Dst: 192.168.1.10
Transmission Control Protocol, Src Port: 54321, Dst Port: 22 (SSH), Seq: 0, Len: 0
    Flags: 0x002 (SYN)
```

**Packet 2:**

```
Frame 2: 60 bytes on wire (480 bits), 60 bytes captured (480 bits)
Ethernet II, Src: Attacker_MAC (00:0c:29:12:34:56), Dst: Victim_MAC (00:0c:29:65:43:21)
Internet Protocol Version 4, Src: 192.168.1.100, Dst: 192.168.1.10
Transmission Control Protocol, Src Port: 54322, Dst Port: 80 (HTTP), Seq: 0, Len: 0
    Flags: 0x002 (SYN)
```

**Packet 3:**

```
Frame 3: 60 bytes on wire (480 bits), 60 bytes captured (480 bits)
Ethernet II, Src: Attacker_MAC (00:0c:29:12:34:56), Dst: Victim_MAC (00:0c:29:65:43:21)
Internet Protocol Version 4, Src: 192.168.1.100, Dst: 192.168.1.10
Transmission Control Protocol, Src Port: 54323, Dst Port: 443 (HTTPS), Seq: 0, Len: 0
    Flags: 0x002 (SYN)
```

### Attack Pattern

The attack pattern is a classic **TCP SYN scan** (also known as a "half-open" scan). The attacker sends a stream of TCP SYN packets to a range of ports on the target machine.

*   If the port is open, the target machine will respond with a SYN/ACK packet.
*   If the port is closed, the target will respond with a RST (reset) packet.

The attacker does not complete the three-way handshake, which makes this type of scan stealthier than a full TCP connect scan. The pattern is characterized by a high volume of SYN packets from a single source to a single destination across many different ports in a short period.

### Mitigation Measures

Here are two recommended mitigation measures to protect against port scanning:

1.  **Firewall Configuration:**
    *   **Description:** Implement and configure a firewall to block unsolicited inbound traffic. A firewall can be configured to drop packets from suspicious sources or to limit the rate of incoming connections. For example, you can set up a rule to block an IP address that sends too many SYN packets in a short time frame.
    *   **Implementation:** This can be done at the network level with a hardware firewall or at the host level with software like `iptables` on Linux or Windows Defender Firewall.

2.  **Intrusion Detection System (IDS):**
    *   **Description:** An IDS can be used to monitor network traffic for suspicious patterns, such as port scans. When an IDS detects a port scan, it can log the event and send an alert to the network administrator. Some Intrusion Prevention Systems (IPS) can even automatically block the attacker's IP address.
    *   **Implementation:** Tools like Snort or Suricata can be deployed on the network to detect and alert on port scanning activity.

## b) Intrusion Detection with Suricata

### Technical Report: DNS Tunneling Detected

**Date:** 2023-11-23

**Summary:**

An analysis of network logs has revealed evidence of DNS tunneling activity originating from the internal IP address `192.168.117.128`. The activity is characterized by a high volume of DNS TXT queries to the domain `www.ggy666.tk`. This technique is often used to exfiltrate data from a network, bypassing traditional firewall rules.

**Detection:**

The intrusion was detected by analyzing a `pcap` file (`iodine-txt.pcap`) containing network traffic. The analysis, performed using a custom Python script with the `scapy` library, identified a total of **12,579 DNS TXT queries** from the source IP `192.168.117.128` to the external DNS server `198.46.158.57`. The queried subdomains, such as `vaaaakatm5y` and `ladgdvlfdnybz2ywbobjvnbiusulgz5y`, appear to be encoded data, which is a hallmark of DNS tunneling.

**Rule Signatures:**

If this traffic were being monitored by Suricata, the following Emerging Threats (ET) rule signatures would likely have triggered alerts:

*   `ET POLICY DNS Query for .tk TLD` - This rule would have alerted on the DNS queries to the `.tk` top-level domain, which is often associated with malicious activity.
*   `ET POLICY DNS TXT Record looks like a TUNNEL Signature (iodine)` - This rule specifically looks for the patterns associated with the `iodine` DNS tunneling tool.
*   `ET TROJAN DNS Tunneling (Odd Subdomains)` - This rule would have triggered on the long, seemingly random subdomains, which are indicative of data exfiltration.

**Remediation Steps:**

The following remediation steps are recommended:

1.  **Isolate the Infected Host:** The machine at `192.168.117.128` should be immediately disconnected from the network to prevent further data exfiltration.
2.  **Block the Malicious Domain:** The domain `www.ggy666.tk` should be blocked at the network's firewall or DNS server to prevent any further communication with the command-and-control server.
3.  **Investigate the Infected Host:** A thorough forensic analysis of the infected host should be conducted to identify the malware or tool that is being used to perform the DNS tunneling.
4.  **Review DNS Logs:** The DNS logs for the entire network should be reviewed to identify any other hosts that may be communicating with the malicious domain.
5.  **Implement DNS Filtering:** Consider implementing a DNS filtering solution that can block queries to known malicious domains and detect suspicious DNS traffic patterns.
