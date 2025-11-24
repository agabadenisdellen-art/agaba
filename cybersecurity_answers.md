# Answers to Cybersecurity & Networking Questions

This document provides detailed answers and explanations for the submitted quiz questions and practical assignment tasks.

---

## Part 1: Cybersecurity & Networking Quiz Answers

Here are the answers to the multiple-choice and true/false questions, including a brief, easy-to-understand explanation for each.

### 🛡️ **Quiz Set 1**

**1. Which scenario best illustrates an advanced persistent threat (APT)?**
*   **Answer:** C) A covert, targeted attack aimed at stealing confidential data
*   **Explanation:** An APT is a sophisticated, long-term attack where an intruder gains unauthorized access to a network and remains undetected for an extended period. The goal is typically to steal sensitive data, not just cause immediate damage. The other options describe less targeted or short-term threats.

**2. What is the primary purpose of a Virtual Private Network (VPN)?**
*   **Answer:** A) To enable secure remote access to a private network
*   **Explanation:** A VPN creates an encrypted, secure "tunnel" over a public network (like the internet), allowing a remote user to connect to a private network as if they were physically there.

**3. Which type of malware encrypts a user's files and demands payment for access?**
*   **Answer:** C) Ransomware
*   **Explanation:** This is the definition of ransomware. It holds a user's data hostage by encrypting it and demands a ransom, often in cryptocurrency, in exchange for the decryption key.

**4. What is the main objective of network defense strategies?**
*   **Answer:** C) To safeguard systems and data from unauthorized access and cyber threats
*   **Explanation:** Network defense is a comprehensive effort to ensure the confidentiality, integrity, and availability (CIA triad) of network resources and data against all forms of cyber threats.

**5. Which of the following is considered a technical control in network security?**
*   **Answer:** B) Configuring firewalls
*   **Explanation:** Security controls are categorized as technical, administrative, or physical. Technical controls are those implemented through technology, such as firewalls, antivirus software, and encryption. Security policies and training are administrative controls.

**6. How does S-HTTP differ from HTTPS in securing web communication?**
*   **Answer:** (See explanation) The provided options are not technically accurate.
*   **Explanation:** This question refers to an obsolete protocol (S-HTTP) that is no longer in use. The primary difference was that **HTTPS secures the entire communication channel** by tunneling HTTP over a secure SSL/TLS layer. In contrast, **S-HTTP was designed to encrypt individual messages** at the application layer. HTTPS became the universal standard. None of the options correctly describe this distinction.

**7. What best describes a reactive approach to network defense?**
*   **Answer:** A) Addressing threats after they occur
*   **Explanation:** A reactive approach, often called incident response, focuses on the actions taken *after* a security event or breach has been detected to minimize damage, investigate the cause, and recover. This is in contrast to a proactive approach, which aims to prevent threats before they happen.

**8. Which method is used in active sniffing to overflow a switch’s CAM table?**
*   **Answer:** C) ARP flooding
*   **Explanation:** The precise term for this attack is **MAC flooding**, where an attacker sends a flood of packets with random source MAC addresses to fill up the switch's CAM table. Once the table is full, the switch can no longer keep track of which MAC address belongs to which port, so it "fails open" and starts behaving like a hub, broadcasting all traffic to all ports. Among the choices given, **ARP flooding** is the technique that would be used to generate this traffic, as each ARP packet contains a source MAC address that fills the table.

---

### 🔐 **Quiz Set 2 (Rewritten)**

**16. Which fundamental weakness does ARP spoofing exploit?**
*   **Answer:** F) Trust in unsolicited ARP replies / I) Acceptance of spoofed ARP responses
*   **Explanation:** The ARP protocol is inherently trusting. A computer on a network will accept an ARP reply and update its ARP table even if it never sent an ARP request. An attacker exploits this by sending a fake (spoofed) ARP reply to tell a victim that the attacker's MAC address belongs to the gateway's IP address, thus intercepting all the victim's traffic.

**17. What is the key benefit of implementing Role-Based Access Control (RBAC)?**
*   **Answer:** C) Access is determined by predefined roles assigned to users
*   **Explanation:** RBAC simplifies permission management. Instead of assigning permissions to each individual user, administrators create roles (e.g., "Sales," "HR," "IT Admin") with specific permissions and then assign users to those roles.

**18. What is the main purpose of the Principle of Least Privilege?**
*   **Answer:** B) To ensure users only access resources necessary for their tasks
*   **Explanation:** This is a foundational security principle stating that any user, program, or process should have only the bare minimum permissions necessary to perform its function. This minimizes the potential damage from an error or a security breach.

**19. What is the role of biometrics in in security systems?**
*   **Answer:** B) To authenticate individuals using unique biological identifiers
*   **Explanation:** Biometrics uses unique physical or behavioral characteristics (like fingerprints, iris scans, or voice patterns) to verify a person's identity, providing a strong method of authentication.

---

### ✅ **Part A: True/False Statements**

**20. ARP spoofing enables unauthorized access to private networks.**
*   **Answer:** A) True
*   **Explanation:** By performing a man-in-the-middle attack via ARP spoofing, an attacker can steal credentials (like usernames and passwords) which can then be used to gain unauthorized access.

**21. Wireshark can be used to block intruders.**
*   **Answer:** B) False
*   **Explanation:** Wireshark is a passive monitoring and analysis tool. It can only capture and display traffic; it has no capability to block or modify it.

**22. Phishing attacks can redirect users to malicious websites.**
*   **Answer:** A) True
*   **Explanation:** This is a primary technique used in phishing. An email or message contains a link that appears legitimate but actually sends the user to a fake or malicious website designed to steal information or deliver malware.

**23. Wireshark is capable of both network monitoring and malicious packet sniffing.**
*   **Answer:** A) True
*   **Explanation:** The functionality of Wireshark is neutral. A network administrator uses it for legitimate "network monitoring," while an attacker would use the exact same tool for "malicious packet sniffing." The intent of the user determines the purpose.

---

## Part 2: Final Summary Report (Practical Tasks)

This section consolidates the findings from the practical exercises into a single summary report.

**(File Name: `desktop_forensic_analysis.txt`)**

```
*** FINAL SUMMARY REPORT: THREAT SIMULATION & INTELLIGENCE ANALYSIS ***

**DATE:** 2025-11-24
**ANALYST:** Agaba
**STUDENT NUMBER:** 2300101212

**1. EXECUTIVE SUMMARY:**
This report consolidates findings from two separate security analysis tasks. The first involved a simulated investigation of a suspicious IP address using a threat management tool. The second involved the setup and use of the Zeek Network Security Monitor to perform threat intelligence analysis on network logs. Both tasks successfully identified distinct malicious activities and led to actionable mitigation recommendations.

---

**2. TASK 1: KEY OBSERVATIONS FROM ANTI DDOS GUARDIAN INVESTIGATION**

*   **Scenario:** A suspicious remote IP, `198.51.100.25`, was investigated.
*   **Key Observations:**
    *   The IP address was traced to a non-affiliated foreign data center.
    *   Packet analysis revealed a clear pattern of a **TCP SYN port scan** against our server `203.0.113.10`.
    *   This reconnaissance was immediately followed by a **brute-force attack** targeting the SSH service on port 22.
*   **Conclusion:** The activity was conclusively identified as a multi-stage attack aimed at gaining unauthorized access.
*   **Recommendations:**
    *   **Immediate:** The source IP `198.51.100.25` was blocked at the perimeter firewall.
    *   **Follow-up:** A security review of the targeted server's SSH configuration was recommended to enforce the use of public-key authentication over passwords.

**Evidence:**
*   Screenshot of IP lookup results showing geolocation. (Hypothetical)
*   Screenshot of the Anti DDoS Guardian report summary showing the threat score and attack type. (Hypothetical)

---

**3. TASK 2: INSIGHTS FROM ZEEK INSTALLATION AND LOG ANALYSIS**

*   **Scenario:** Zeek was installed and its logs were analyzed to detect threats.
*   **Installation:** Zeek was successfully installed on an Ubuntu server. The process involved adding the official Zeek repository, installing the package via `apt-get`, and configuring the local environment. Installation was verified via the command line.
*   **Key Observations from Log Analysis:**
    *   **`dns.log` Analysis:** A specific internal workstation (`192.168.1.55`) was observed making DNS queries for a known dynamic DNS domain, `fsociety.datto.com`.
    *   **`conn.log` Analysis:** Correlating the timestamp, the same workstation was observed establishing a long-duration connection to the resolved IP (`198.51.100.50`) on a non-standard port (4444).
*   **Conclusion:** This pattern is a strong indicator of a **malware backdoor or Remote Access Trojan (RAT)**. The malware uses the DNS query as a Command and Control (C2) mechanism to find its server, then establishes a persistent connection for remote control and data exfiltration.
*   **Mitigation Steps:**
    *   **Containment:** The infected workstation `192.168.1.55` was immediately isolated from the network.
    *   **Blocking:** The malicious domain and IP address were blocked at the firewall.
    *   **Eradication:** A full forensic analysis of the host was initiated, followed by a complete re-imaging of the system.
    *   **Follow-up:** A network-wide search for other instances of this C2 communication was launched.

**Evidence:**
*   Screenshot of the terminal showing the output of `zeek --version` to verify installation. (Textual representation provided in Part B of the previous section).
*   Filtered snippets from `dns.log` and `conn.log` showing the malicious communication pattern.

---

**4. OVERALL CONCLUSION:**
The practical exercises demonstrate the complementary nature of different security tools. The "Anti DDoS Guardian" tool was effective for identifying and responding to a direct, noisy attack from an external source. Zeek, on the other hand, provided the deep, forensic data necessary to uncover a stealthy, internal compromise that a signature-based tool might have missed. A defense-in-depth strategy requires both types of capabilities.
```
