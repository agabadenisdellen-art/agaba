# Part A: Network Monitoring with Wireshark

## Introduction to Network Monitoring

**Definition:** Network monitoring is the process of continuously overseeing a computer network's performance, traffic, and health to detect and resolve issues. It's like having a security guard who constantly watches over the network to ensure everything is running smoothly and securely.

**Importance:**
*   **Security:** It helps in identifying suspicious activities, such as unauthorized access, malware infections, and cyberattacks like port scanning.
*   **Performance:** It allows administrators to track network speed, latency, and uptime, ensuring that the network is performing optimally for its users.
*   **Troubleshooting:** When network problems occur, monitoring provides the necessary data to diagnose the root cause quickly and efficiently.

**Real-Life Example:** A large e-commerce company continuously monitors its network to ensure its website is always available, especially during peak shopping seasons. If they detect a sudden spike in traffic from a suspicious source, they can investigate it as a potential DDoS attack and take action to block it, preventing the website from going down.

## Wireshark: The Network Protocol Analyzer

**Definition:** Wireshark is a free and open-source packet analyzer. It is used for network troubleshooting, analysis, software and communications protocol development, and education. It captures network traffic and presents it in a human-readable format, allowing you to see what's happening on your network at a microscopic level.

**Function:** Wireshark captures data packets traveling across the network and allows you to inspect their contents, including their source, destination, and the protocols they use.

**Steps for Installation:**
1.  **Download:** Visit the official Wireshark website (`wireshark.org`) and download the installer for your operating system (Windows, macOS, or Linux).
2.  **Install:** Run the installer and follow the on-screen instructions. On Windows, it will ask to install `Npcap`, which is the library required to capture live network data. On Linux, you may need to grant permissions to non-root users to capture packets.

## Hypothetical Network Setup and Attack Scenario

Let's imagine a small Wi-Fi network in a home or small office.

*   **Network:** A standard Wi-Fi router with the IP address `192.168.1.1`.
*   **Interconnected Devices:**
    *   A Desktop PC (`192.168.1.100`)
    *   A Laptop (`192.168.1.101`) - This will be our target.
    *   Two Smartphones (`192.168.1.102`, `192.168.1.103`)
    *   A Smart TV (`192.168.1.104`)
*   **Attacker:** An unauthorized user connects to the Wi-Fi and gets an IP address (`192.168.1.150`).

The attacker decides to perform a **port scan** on the Laptop (`192.168.1.101`) to find open ports and potential vulnerabilities.

## Malicious Packets and Port Scanning

**Malicious Packets:** These are data packets crafted to cause harm to a network or device. They can be used to exploit vulnerabilities, launch denial-of-service attacks, or, in this case, gather information.

**Port Scanning:** This is a technique used by attackers to discover which ports on a host are open. An "open port" is a network port that is configured to accept incoming packets. Attackers scan for open ports to identify running services (like web servers, email servers, etc.) that they can potentially exploit.

**Attack Pattern: TCP SYN Scan**
The attacker (`192.168.1.150`) will send a flood of TCP packets with the `SYN` (synchronize) flag set to a range of ports on the target Laptop (`192.168.1.101`).

*   If a port is **open**, the Laptop will respond with a `SYN-ACK` packet.
*   If a port is **closed**, the Laptop will respond with a `RST` (reset) packet.

By observing the responses, the attacker can map out the open ports on the target. In Wireshark, this activity would appear as a large number of packets from the attacker's IP to the victim's IP, with many different destination ports, happening in a very short amount of time.

### Screenshot of Packet Headers (Textual Representation)

Here is a simplified text representation of what the packet headers would look like in Wireshark during a port scan.

**1. Attacker's SYN Packet (Probing Port 80 - HTTP)**
```
--------------------------------------------------
| Frame 1234                                     |
| Ethernet II Header                             |
|   Source MAC:      Attacker_MAC_Address        |
|   Destination MAC: Laptop_MAC_Address         |
| Internet Protocol Version 4 (IPv4)             |
|   Source IP:       192.168.1.150 (Attacker)    |
|   Destination IP:  192.168.1.101 (Laptop)      |
| Transmission Control Protocol (TCP)            |
|   Source Port:     54321 (Random)              |
|   Destination Port: 80 (HTTP)                  |
|   [Flags]                                      |
|     .... 0001 0... = SYN: Set                  |
--------------------------------------------------
```
**Wireshark Display Filter to find this:** `ip.src == 192.168.1.150 and ip.dst == 192.168.1.101 and tcp.flags.syn == 1`

**2. Laptop's RST Packet (Because Port 4444 is Closed)**
```
--------------------------------------------------
| Frame 1235                                     |
| Ethernet II Header                             |
|   Source MAC:      Laptop_MAC_Address          |
|   Destination MAC: Attacker_MAC_Address       |
| Internet Protocol Version 4 (IPv4)             |
|   Source IP:       192.168.1.101 (Laptop)      |
|   Destination IP:  192.168.1.150 (Attacker)    |
| Transmission Control Protocol (TCP)            |
|   Source Port:     4444                        |
|   Destination Port: 54321 (Matches attacker's src)|
|   [Flags]                                      |
|     .... 0100 1... = RST, ACK: Set             |
--------------------------------------------------
```
**Wireshark Display Filter to find this:** `ip.src == 192.168.1.101 and tcp.flags.reset == 1`

## Mitigation Measures

Here are two recommended measures to protect against port scanning:

1.  **Firewall with Strict Rules:**
    *   **How it works:** A firewall acts as a barrier between your network and the outside world. You can configure it with a "default deny" policy, which means all incoming traffic is blocked unless it is explicitly allowed. For a personal laptop, a host-based firewall (like Windows Defender Firewall or `ufw` on Linux) can be configured to drop unsolicited incoming packets, making it appear as if the ports are closed or non-existent.
    *   **Implementation:** Configure the firewall to only allow incoming connections on ports that are necessary for your work (e.g., port 443 for web browsing). Block all other ports. Advanced firewalls can also detect port scanning patterns and temporarily block the source IP address.

2.  **Intrusion Prevention System (IPS):**
    *   **How it works:** An IPS actively monitors network traffic for malicious patterns. Unlike a simple firewall, an IPS is "stateful" and can recognize sequences of events. It can identify a port scan by detecting a single IP address trying to connect to many different ports in a short period.
    *   **Implementation:** When the IPS detects a port scan, it can be configured to automatically take action, such as logging the event, sending an alert to the administrator, and, most importantly, blocking all traffic from the attacker's IP address for a certain period. This stops the scan and prevents any follow-up attacks.

# Part B: Intrusion Detection with Suricata and Zeek

## Introduction to Intrusion Detection Systems (IDS)

**Definition:** An Intrusion Detection System (IDS) is a device or software application that monitors a network or systems for malicious activity or policy violations. Any detected activity or violation is typically reported either to an administrator or collected centrally using a security information and event management (SIEM) system.

**Importance:**
*   **Threat Visibility:** An IDS provides visibility into the internal workings of a network, allowing you to see threats that might otherwise go unnoticed.
*   **Early Warning:** It can detect the early stages of an attack, such as reconnaissance and exploitation, giving security teams time to respond before significant damage is done.
*   **Compliance:** Many industry regulations (like PCI DSS and HIPAA) require organizations to have an IDS in place to protect sensitive data.

## Suricata and Zeek

**Suricata:**
*   **Definition:** Suricata is a high-performance, open-source Network Intrusion Detection System (IDS), Intrusion Prevention System (IPS), and Network Security Monitoring (NSM) engine.
*   **Function:** It inspects network traffic using a powerful rule-based language. When traffic matches a rule, it can generate an alert, drop the packet (in IPS mode), or log the event.
*   **Installation:** On a Debian-based Linux system (like Ubuntu), you can install it with `sudo apt-get install suricata`. Configuration involves editing a YAML file (`suricata.yaml`) and adding rule sets.

**Zeek (formerly Bro):**
*   **Definition:** Zeek is a passive network traffic analyzer. It is primarily a network security monitor that inspects all traffic on a link in-depth for signs of suspicious activity.
*   **Function:** Unlike Suricata, which is heavily rule-based, Zeek is script-based. It generates high-level, richly annotated transaction logs of all network activity. These logs are much easier to analyze than raw packet captures. For example, Zeek will create a `dns.log` file with all DNS queries and responses.
*   **Installation:** Zeek can be installed from source or via package managers. For example, on Ubuntu: `sudo apt-get install zeek`.

## DNS Tunneling and Data Exfiltration

**DNS Tunneling:**
*   **Definition:** This is a cyberattack technique where the Domain Name System (DNS) protocol is used to communicate non-DNS traffic. Attackers can embed data from other programs or protocols into DNS queries and responses, effectively creating a hidden communication channel.
*   **How it works:** Since most networks allow DNS traffic to pass through their firewalls (as it's essential for internet access), attackers exploit this to bypass security measures. A compromised machine can send data (e.g., sensitive files) by encoding it into a series of DNS queries for long, specially crafted domain names (e.g., `<encoded_data>.attacker.com`). The attacker's malicious DNS server receives these queries, decodes the data, and sends a response.

**Data Exfiltration:**
*   **Definition:** This is the unauthorized transfer of data from a computer or network. It is a broad term that can describe any unauthorized data movement, but in this context, we're focusing on using DNS tunneling as the method.
*   **Real-Life Example:** A piece of malware on a corporate laptop could steal a list of customer email addresses. It could then use DNS tunneling to slowly leak this data out to an external server controlled by the attacker, without setting off traditional firewall alarms.

## Technical Report: Detecting DNS Tunneling

**Title:** Detection of DNS Tunneling for Data Exfiltration

**1. Detection of the Intrusion:**
Upon analyzing the network logs from our Zeek instance, specifically the `dns.log` file, we observed a significant anomaly associated with the host at `192.168.1.100`. The following indicators were noted:

*   **High Volume of DNS Queries:** The host was generating an unusually high number of DNS queries—several hundred per minute—to a single external domain: `bad-actor.net`.
*   **Unusually Long Subdomains:** The DNS queries were for extremely long and seemingly random subdomains, such as `ZjBjM2EwYjcuYWNjb3VudC5iYWQtYWN0b3IubmV0`. This is a classic sign of data being encoded into the subdomain.
*   **Use of TXT Records:** In addition to A records, many queries were for TXT records, which are often used in DNS tunneling to carry larger payloads of data.

**2. Rule Signatures that Triggered Alerts:**
Using Suricata with the Emerging Threats rule set, the following rule signatures were triggered, which corroborated the findings from the Zeek logs:

*   **Signature 1: `ET POLICY DNS Query for a suspicious .info / .biz / .top / .xyz domain`**
    *   Although our domain was `.net`, this rule is often part of a broader category looking for queries to non-standard or suspicious TLDs often used by attackers. A custom rule could be more specific.

*   **Signature 2 (Custom Rule Example):** A custom rule was written to detect the specific characteristics of this attack.
    ```
    alert dns $HOME_NET any -> any 53 (msg:"DNS Tunneling - Unusually Long Subdomain Query"; content:"|01 00 00 01 00 00 00 00 00 00|"; depth:11; offset:2; content:".bad-actor.net"; distance:0; nocase; classtype:trojan-activity; sid:1000001; rev:1;)
    ```
    *   **Explanation of the Rule:** This rule looks for DNS queries (`dns`) originating from our internal network (`$HOME_NET`) going to any DNS server (port `53`). It specifically looks for queries to the domain `.bad-actor.net` and would typically be combined with a length check on the subdomain part of the query to identify the unusually long hostnames.

**3. Remediation Steps:**

1.  **Isolate the Infected Host:** The first and most critical step is to disconnect the compromised machine (`192.168.1.100`) from the network to prevent further data exfiltration and lateral movement by the attacker.
2.  **Block the Malicious Domain:** The domain `bad-actor.net` should be blocked at the network's DNS firewall or web proxy. This will sever the command-and-control channel for the malware.
3.  **Investigate and Re-image the Host:** The infected machine needs to be forensically analyzed to understand the scope of the compromise (what malware was installed, what data was accessed). After the investigation, the machine should be wiped and re-imaged from a known-good source to ensure all traces of the malware are removed.
4.  **Strengthen DNS Security:**
    *   Implement a DNS filtering service (like Cisco Umbrella or Quad9) that blocks requests to known malicious domains.
    *   Configure internal DNS servers to log all queries and use DNS analytics tools to establish a baseline of normal activity, making it easier to spot future anomalies.
