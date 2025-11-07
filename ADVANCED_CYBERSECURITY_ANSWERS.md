# Advanced Cybersecurity Practical Assessment Answers

This document provides a theoretical walkthrough for the advanced, hands-on questions regarding Anti DDoS Guardian and Zeek.

***

### Part 1: Threat Simulation and Report Generation (Anti DDoS Guardian)

**c) Threat Simulation and Report Generation**

**(i) Choose an appropriate built-in tool:**
The most appropriate tool within Anti DDoS Guardian would be the **"IP Address Analyzer"** or **"Connection Inspector"**. This tool would be designed to provide a deep dive into the activity of a single, specific IP address.

**(ii) Describe the steps to investigate the IP:**
Let's assume the suspicious Remote IP is `203.0.113.5`.

1.  **Access the Analyzer:** From the main dashboard's list of active connections, I would right-click on the IP `203.0.113.5` and select "Analyze IP" or "Investigate".
2.  **Review Connection Behavior:** The analyzer would display key metrics for this IP. I would look for red flags such as:
    *   An extremely high number of concurrent or recent connections.
    *   A high packet-per-second rate, indicating a flood.
    *   Connections targeting a wide range of ports, which suggests a port scan.
3.  **Check Threat Rating:** The tool would likely feature an auto-generated threat score (e.g., 8/10) based on its internal heuristics, with a label like "Aggressive Port Scan" or "Potential SYN Flood".
4.  **Perform Reverse Lookup:** I would use the tool's reverse DNS lookup feature to see if the IP is associated with a legitimate domain name. An IP with no reverse DNS record is more suspicious.

**(iii) Generate a full report:**
1.  Within the IP Analyzer window, I would locate the **"Export"** or **"Generate Report"** button.
2.  I would choose a report format (e.g., PDF or HTML).
3.  I would set the filename to **`2300101212.pdf`** and save it to the Desktop. This report would contain all the investigation details: IP information, threat score, traffic statistics, and a timeline of the malicious activity.

**Note: Recommended Actions**
Based on the results of a high threat rating and aggressive scanning behavior, my recommendation would be:
*   **Immediate Block:** Use the tool to right-click the IP and select **"Block IP Address"** to add it to the firewall blacklist.
*   **Initiate Incident Response:** Escalate the event to the incident response team. This is a clear indicator of a targeted attack that requires a broader investigation to ensure no systems were compromised.

---

### Part 2: Network Threat Intelligence Using Zeek

**Qn. Two: Network Threat Intelligence Using Zeek**

**a) Installation and Environment set up**

**(i) Briefly describe the installation steps (on Ubuntu):**
1.  **Install Dependencies:** First, update the package manager and install Zeek's required libraries and build tools:
    ```bash
    sudo apt-get update
    sudo apt-get install cmake make gcc g++ flex bison libpcap-dev libssl-dev python3 python3-dev swig zlib1g-dev
    ```
2.  **Download and Compile:** Download the latest source code from `zeek.org`, extract it, and then compile it:
    ```bash
    wget https://download.zeek.org/zeek-5.0.0.tar.gz
    tar -xzf zeek-5.0.0.tar.gz
    cd zeek-5.0.0/
    ./configure
    make
    sudo make install
    ```
3.  **Configure `zeekctl`:** Add the Zeek binary path to the system's PATH. Then, run the `zeekctl` configuration script, which involves editing `node.cfg` to specify the network interface to monitor and `networks.cfg` to define the local network address space. Finally, run `sudo /usr/local/zeek/bin/zeekctl install`.

**(ii) Command to verify version and start monitoring:**
*   **Verify Version:** `/usr/local/zeek/bin/zeek --version`
*   **Start Monitoring:** `sudo /usr/local/zeek/bin/zeekctl start`

**b) Log Analysis and Threat Mapping**

**(1) Log File: `dns.log`**
*   **Purpose:** Records all DNS queries and responses. It's vital for seeing what domains internal clients are trying to resolve.
*   **Threat Example:** Identifying **malware C2 communication**. A compromised host repeatedly looking up a suspicious, non-standard domain is a strong indicator of a malware infection.
*   **Command:** `zeek-cut id.orig_h query < dns.log | sort | uniq -c` (Lists which hosts made which DNS queries and counts them).

**(2) Log File: `conn.log`**
*   **Purpose:** A high-level log of every TCP, UDP, and ICMP connection. It provides a baseline of all network traffic.
*   **Threat Example:** Detecting a **network sweep or port scan**. An attacker scanning the network would generate a huge number of connection entries in `conn.log` from a single source IP to many destination IPs or ports, often with a `REJ` or `S0` state.
*   **Command:** `zeek-cut id.orig_h | sort | uniq -c | sort -n` (Counts the number of connections initiated by each host).

**(3) Log File: `http.log`**
*   **Purpose:** Details all unencrypted HTTP requests, including the requested host, URI, and user agent.
*   **Threat Example:** Detecting a **SQL injection attempt**. An attacker might try to exploit a web server by passing SQL commands in the URL, which would be visible in the `uri` field of `http.log`.
*   **Command:** `grep "UNION SELECT" http.log` (Searches for a common SQL injection keyword in the log).

**c) Network Attack Detection and Report**

**(i) Use Zeek to analyze the PCAP file:**
```bash
zeek -r suspect_traffic.pcap
```

**(ii) Identify one suspicious IP address:**
After analyzing the PCAP, I would inspect `conn.log`. A suspicious IP, let's say **`10.10.10.50`**, would be identified by an unusually high number of connections to different hosts on the network, particularly if they are targeting a single port (e.g., port 445 for SMB).

**(iii) Correlate this IP with at least one other log file:**
I would `grep` for the suspicious IP `10.10.10.50` in other logs. Finding corresponding entries in **`smb_files.log`** or **`dce_rpc.log`** would strongly indicate the attacker was attempting to exploit Windows file sharing vulnerabilities to move laterally or exfiltrate data.

**(iv) Summarize your investigation and save your findings:**
I would create the file **`2400101359.txt`** with the following content:

> **Investigation Summary - IP: 10.10.10.50**
>
> **Observed Behavior:** The IP `10.10.10.50` was observed in `conn.log` making an unusually high number of connections to multiple hosts on the internal network, targeting TCP port 445.
>
> **Possible Intent:** The attacker's activity suggests **lateral movement and reconnaissance** using the SMB protocol. They are likely scanning for vulnerable Windows file shares to either steal data or spread malware.
>
> **Recommended Response:**
> 1.  **Immediate Block:** The source IP `10.10.10.50` should be blocked at the firewall.
> 2.  **Forensic Analysis:** The host machine at `10.10.10.50` must be isolated from the network immediately and subjected to forensic analysis to determine the extent of the compromise.
