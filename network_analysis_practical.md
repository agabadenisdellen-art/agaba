# A Step-by-Step Guide to Practical Network Analysis

This document provides a comprehensive, practical walkthrough for the two parts of your question. Part A will cover network monitoring and attack detection using Wireshark, while Part B will focus on threat hunting and analysis using Zeek.

---

## **Part A: Network Monitoring and Port Scan Detection with Wireshark**

This section will guide you through setting up a small network, simulating a common reconnaissance attack (a port scan), capturing the traffic, and analyzing the evidence.

### **Introduction**

**Definition: What is Network Monitoring?**
Network monitoring is the process of watching the data that flows across a computer network in real-time. It is essential for ensuring the **health, performance, and security** of a network. By observing the traffic, administrators can diagnose slowdowns, troubleshoot errors, and—most importantly—detect malicious activity before it leads to a serious breach.

**Function & Importance:**
*   **Security:** It serves as a digital alarm system, helping to identify unauthorized access, malware infections, and the early stages of a cyberattack, such as an attacker surveying your network.
*   **Performance:** It helps find bottlenecks or failing devices that are slowing the network down.
*   **Troubleshooting:** When an application can't connect, analyzing the traffic provides the ground truth of what's going wrong.

**Real-Life Example:** A company's IT department continuously monitors network traffic. They notice a single computer suddenly trying to connect to hundreds of different internal servers in a matter of seconds. They can quickly identify this as a sign of a malware infection (a worm) and isolate the computer before it spreads across the entire company.

---

### **Step 1: Setting Up the Small Network**

For this practical, we will define a hypothetical 5-device network. This setup is easily replicated at home or in a lab using physical devices or virtual machines.

*   **Network Medium:** A standard Wi-Fi network.
*   **Network Address Space:** `192.168.1.0/24` (a common default for home routers).

**The Devices:**

1.  **The Monitoring Station:**
    *   **Device:** Your primary laptop or PC.
    *   **Hypothetical IP:** `192.168.1.10`
    *   **Role:** This is where you will run **Wireshark** to capture and analyze all network traffic.

2.  **The Attacker Machine:**
    *   **Device:** A second laptop or a virtual machine (e.g., Kali Linux).
    *   **Hypothetical IP:** `192.168.1.15`
    *   **Role:** This machine will be used to launch a simulated port scan using a tool called **Nmap**.

3.  **The Target Machine:**
    *   **Device:** A third computer, a virtual machine, or even a smartphone.
    *   **Hypothetical IP:** `192.168.1.20`
    *   **Role:** This is the "victim" that the Attacker will scan.

4.  **"Background Noise" Device #1:**
    *   **Device:** A smartphone.
    *   **Role:** To make the simulation realistic, use this phone to browse a website (e.g., bbc.com). This generates normal traffic.

5.  **"Background Noise" Device #2:**
    *   **Device:** A tablet or Smart TV.
    *   **Role:** Use this to stream a short video (e.g., from YouTube). This adds more legitimate traffic to the capture, which makes our analysis task more realistic.

---

### **Step 2: Installation of Tools**

You will need two key pieces of free, open-source software.

**1. Install Wireshark (on the Monitoring Station - `192.168.1.10`)**

*   **Windows:**
    1.  Go to `https://www.wireshark.org/download.html` and download the Windows Installer.
    2.  Run the installer. During the setup process, you will be prompted to install **Npcap**. **You must install this**, as it is the capture driver that allows Wireshark to access your network card.
*   **Linux (Ubuntu/Debian):**
    1.  Open a terminal and run the following commands:
        ```bash
        sudo apt-get update
        sudo apt-get install wireshark -y
        ```
    2.  A pop-up will ask if non-superusers should be able to capture packets. Select **`<Yes>`**.
    3.  Add your user to the `wireshark` group:
        ```bash
        sudo usermod -aG wireshark $USER
        ```
    4.  **Log out and log back in** for the changes to take effect.

**2. Install Nmap (on the Attacker Machine - `192.168.1.15`)**

Nmap ("Network Mapper") is the tool we will use to generate the port scan.

*   **Windows:**
    1.  Go to `https://nmap.org/download.html` and download the latest Windows setup executable.
    2.  Run the installer, accepting the default options.
*   **Linux (Ubuntu/Debian):**
    1.  Open a terminal and run:
        ```bash
        sudo apt-get update
        sudo apt-get install nmap -y
        ```

---

### **Step 3: Capture the Traffic and Simulate the Attack**

1.  **On the Monitoring Station (`192.168.1.10`):**
    *   Launch Wireshark.
    *   You will see a list of network interfaces (e.g., "Wi-Fi," "Ethernet"). Find the one that is actively showing traffic (it will have a moving graph next to it) and **double-click it** to start the capture.
    *   The screen will immediately fill with packets. This is normal. Let it run.

2.  **On the Attacker Machine (`192.168.1.15`):**
    *   Open a command prompt (Windows) or terminal (Linux).
    *   Type the following command to launch a **TCP SYN Scan** against the Target machine. This is a common and relatively stealthy scan type.
        ```bash
        nmap -sS 192.168.1.20
        ```
        *(Replace `192.168.1.20` with the actual IP of your target device).*
    *   The scan will take a few moments to complete.

3.  **On the Monitoring Station (`192.168.1.10`):**
    *   Once the Nmap scan is finished, go back to your Wireshark window and click the **red "Stop" button** in the top-left toolbar.

You now have a capture file containing both normal network chatter and the malicious port scan activity.

---

### **Step 4: Analyze the Capture to Identify the Attack**

The capture file contains thousands of packets. We need to use filters to find the evidence.

1.  **Apply a Display Filter:** In the filter bar at the top of Wireshark, we want to see only the traffic between the Attacker and the Target. Type the following filter and press Enter:
    ```
    ip.addr == 192.168.1.15 && ip.addr == 192.168.1.20
    ```
    This instantly hides all the "background noise" and shows you only the conversation between the two machines involved in the attack.

2.  **Describe the Attack Pattern:**
    After applying the filter, you will see a clear, repetitive pattern that is the hallmark of a port scan:
    *   You will see a long list of packets originating from the Attacker (`192.168.1.15`) going to the Target (`192.168.1.20`).
    *   For each packet sent by the attacker, the **destination port will be different** (e.g., port 80, then 22, then 443, then 25, etc.). This is the attacker systematically checking each "door."
    *   The packets from the attacker will all be **TCP packets with the SYN flag set**. Wireshark's "Info" column will show `[SYN]`. This is the attacker trying to start a connection.
    *   The Target will respond to most of these with a **`[RST, ACK]`** packet, which means "Connection Reset; the port is closed."
    *   Occasionally, if a port is open, the Target will respond with a **`[SYN, ACK]`**, meaning "I am open and ready to connect."

3.  **"Screenshot" of Packet Headers (Textual Representation):**
    Here is what you would see in the Wireshark display, representing the packet capture.

    **Wireshark Packet List:**
    ```
    No.  Time      Source          Destination     Protocol Info
    -----------------------------------------------------------------------------------
    541  10.112    192.168.1.15    192.168.1.20    TCP      [SYN] Seq=0, Dst Port: 22
    542  10.113    192.168.1.20    192.168.1.15    TCP      [RST, ACK] Seq=1, Ack=1
    545  10.115    192.168.1.15    192.168.1.20    TCP      [SYN] Seq=0, Dst Port: 23
    546  10.116    192.168.1.20    192.168.1.15    TCP      [RST, ACK] Seq=1, Ack=1
    549  10.118    192.168.1.15    192.168.1.20    TCP      [SYN] Seq=0, Dst Port: 80
    550  10.119    192.168.1.20    192.168.1.15    TCP      [SYN, ACK] Seq=0, Ack=1
    ```
    *In this example, we can clearly see the attacker scanning ports 22, 23, and 80. The target responded that 22 and 23 were closed (`RST, ACK`) but that port 80 was open (`SYN, ACK`).*

    **Detailed Header View for a Malicious Packet (Packet #545):**
    ```
    ▼ Transmission Control Protocol, Src Port: 51234, Dst Port: 23, Seq: 0, Len: 0
        Source Port: 51234
        Destination Port: 23  <-- The port being scanned (Telnet)
        ...
        ▼ Flags: 0x002 (SYN)
            .... .... ..1. = Syn: Set  <-- This flag indicates a new connection attempt.
            .... .... ...0 = Fin: Not set
    ```

---

### **Step 5: Recommended Mitigation Measures**

Detecting the scan is good, but preventing it is better. Here are two essential mitigation measures.

**1. Use a Host-Based Firewall:**
*   **Explanation:** A firewall acts as a security guard for a computer or network. The most basic and effective strategy is a **"default deny"** rule. This means the firewall blocks *all* incoming connections by default, and you must create specific rules to allow only the connections you need. For example, a web server should only allow incoming connections on ports 80 and 443. All other ports (like 22, 23, etc.) should be blocked.
*   **How it Mitigates the Scan:** When Nmap sends a `[SYN]` packet to a port that is blocked by the firewall, the firewall simply drops the packet and does not respond. The attacker's Nmap tool will report the port as "Filtered" instead of "Closed," giving them less information and making the scan much slower and less effective.

**2. Implement an Intrusion Prevention System (IPS):**
*   **Explanation:** An IPS is a smarter, more active form of security monitoring. While a firewall looks at individual packets, an IPS analyzes **patterns of behavior**.
*   **How it Mitigates the Scan:** An IPS can be configured with a rule like: "If a single IP address sends connection requests to more than 20 different ports on the same host in under one second, it is a port scan." When this rule is triggered, the IPS can be programmed to automatically take action, such as **temporarily blocking all traffic from the attacker's IP address**. This not only stops the scan in its tracks but also prevents the attacker from trying any other attacks from that IP.

---

## **Part B: DNS Tunneling and Data Exfiltration Analysis with Zeek**

This section will guide you through installing, running, and using Zeek to analyze network logs for evidence of a stealthy attack known as DNS tunneling.

### **Introduction**

**Definition: What is DNS Tunneling?**
DNS Tunneling is a cyberattack technique that hides malicious data within legitimate-looking DNS (Domain Name System) queries. DNS is the "phone book" of the internet; its job is to translate human-readable domain names (like `www.google.com`) into computer-readable IP addresses. Because DNS traffic is essential for internet access, it is almost always allowed through firewalls. Attackers exploit this trust.

**Function & Importance (of the Attack):**
*   **Data Exfiltration:** An attacker can use this technique to steal data from a compromised computer. They encode the stolen data into a series of long, unique DNS queries (e.g., `[stolen-data-chunk-1].attacker.com`).
*   **Command and Control (C2):** It can also be used to create a hidden control channel, allowing an attacker to send commands to the infected machine.
*   **Why it's Dangerous:** It is very difficult to detect. To a normal firewall, it just looks like a lot of DNS queries, which can be normal. It requires a more intelligent tool like Zeek to spot the malicious pattern.

**Real-Life Example:** A compromised server inside a company network contains a sensitive customer database. The malware on the server uses DNS tunneling to slowly leak the entire database, piece by piece, over several days. Each piece of the database is encoded as a long subdomain and sent as a DNS query to a server controlled by the attacker.

---

### **Step 1: Zeek Installation and Setup (on a Linux VM)**

For this practical, we will install and run Zeek on an Ubuntu Linux virtual machine.

**Code: Step-by-Step Installation Commands:**
1.  **Update your system:**
    ```bash
    sudo apt-get update && sudo apt-get upgrade -y
    ```
2.  **Install dependencies:**
    ```bash
    sudo apt-get install curl lsb-release gnupg -y
    ```
3.  **Add Zeek's GPG key and repository** (for Ubuntu 22.04):
    ```bash
    curl -fsSL https://download.opensuse.org/repositories/security:zeek/xUbuntu_22.04/Release.key | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/security_zeek.gpg > /dev/null
    echo 'deb http://download.opensuse.org/repositories/security:/zeek/xUbuntu_22.04/ /' | sudo tee /etc/apt/sources.list.d/security:zeek.list
    ```
4.  **Install Zeek:**
    ```bash
    sudo apt-get update
    sudo apt-get install zeek -y
    ```
5.  **Add Zeek to your PATH:**
    ```bash
    echo 'export PATH=$PATH:/opt/zeek/bin' >> ~/.bashrc
    source ~/.bashrc
    ```

---

### **Step 2: Running Zeek and Analyzing Logs**

**Code: Configuration and Execution:**
1.  **Configure Zeek:**
    *   Find your network interface name (e.g., `eth0` or `ens33`): `ip a`
    *   Edit `/opt/zeek/etc/node.cfg` and set the `interface` to your network interface name.
    *   Edit `/opt/zeek/etc/networks.cfg` and ensure your local IP range (e.g., `192.168.1.0/24`) is listed.
2.  **Run Zeek:** Use the `zeekctl` tool to start the service.
    ```bash
    sudo zeekctl install
    sudo zeekctl start
    ```
    Zeek is now running in the background, monitoring your network interface and writing logs to `/opt/zeek/logs/current/`.

**How to Filter and Analyze Logs:**
Since we do not have pre-provided logs, we will simulate a scenario. Imagine you are looking at the `dns.log` file. Zeek's logs are plain text and can be easily filtered with command-line tools.

*   **Go to the log directory:** `cd /opt/zeek/logs/current/`
*   **To view the DNS log:** `cat dns.log`
*   **To view only the domain query and its answers:**
    ```bash
    cat dns.log | zeek-cut query answers
    ```

---

### **Step 3: Technical Report on DNS Tunneling Detection**

**Report Title:** Intrusion Analysis Report: DNS Tunneling for Data Exfiltration

**1. How the Intrusion Was Detected:**
The intrusion was detected by analyzing Zeek's `dns.log` for statistical anomalies. While a traditional signature-based IDS looks for known bad patterns, this investigation focused on identifying behavior that falls outside of a normal baseline. The following key indicators were identified:

*   **High Volume of Queries from a Single Host:** A workstation with the IP `192.168.1.75` was found to be generating over 1,000 DNS queries per minute, a number far exceeding any other host on the network.
*   **Unusually Long Domain Names:** The queries were not for common domains. Instead, they were for extremely long, randomized-looking subdomains, all belonging to the same parent domain (`corp-data.net`).
    *   **Example Log Entry:** `b64-ZXhhbXBsZS1kYXRhLXNlZ21lbnQtMDE.corp-data.net`
*   **Calculation:** The average length of a legitimate domain query on our network is 15 characters. The queries from this host averaged over 60 characters. This suggests that data is being encoded *into* the subdomain itself.

**2. Rule Signatures That Triggered Alerts:**
Zeek does not use "signatures" in the same way as a traditional IDS. Instead, its event-driven scripting engine can be used to create notices that function like alerts. A custom script, `detect-long-domains.zeek`, was active, which contained the following logic (this is a simplified example):

```zeek
@load base/frameworks/notice
event dns_request(c: connection, msg: dns_msg, query: string) {
    if ( |query| > 50 ) {
        NOTICE([$note=DNS::LONG_QUERY, $msg=fmt("Extremely long DNS query observed: %s", query), $sub=c$id$orig_h]);
    }
}
```
This script acts as our "rule." It triggered a **`DNS::LONG_QUERY`** notice for every one of the suspicious queries, filling our `notice.log` with alerts pointing directly to the compromised host.

**3. Remediation Steps Required:**

1.  **Containment (Immediate):**
    *   **Action:** Disconnect the compromised host (`192.168.1.75`) from the network by shutting down its switch port or disabling its network adapter.
    *   **Purpose:** This immediately severs the attacker's command and control channel and stops the data exfiltration.

2.  **Blocking (Network-wide):**
    *   **Action:** Add the malicious parent domain (`corp-data.net`) to the internal DNS server's blocklist and the attacker's IP to the firewall blocklist.
    *   **Purpose:** This prevents this host (if reconnected) or any other potentially compromised hosts from communicating with the attacker.

3.  **Eradication (Host-level):**
    *   **Action:** Take a forensic image of the compromised host's hard drive for later investigation. After imaging, the machine must be completely wiped and reinstalled from a known-good operating system image.
    *   **Purpose:** This ensures all traces of the malware are removed.

4.  **Recovery and Follow-up:**
    *   **Action:** Restore user data from a clean backup. Monitor Zeek and firewall logs network-wide for any other hosts attempting to contact `corp-data.net`. Investigate the initial point of compromise (e.g., a phishing email) and provide targeted security awareness training.
    *   **Purpose:** Return the system to a secure, operational state and learn from the incident to prevent recurrence.
