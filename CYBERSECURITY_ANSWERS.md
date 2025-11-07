# Cybersecurity Questions and Answers

Here are the answers and explanations for the questions in the provided image.

***

### True/False Questions (25-30)

**25. Network Address Translation (NAT) does not modify packets as they pass through the router.**
*   **Answer: B) False.**
*   **Explanation:** The core function of NAT is to modify the IP headers of packets. It translates the private source IP address to a public IP address for outgoing packets and vice-versa for incoming packets.

**26. NAT allows private IP addresses to communicate with external networks by replacing them with a valid public IP address.**
*   **Answer: A) True.**
*   **Explanation:** This is the primary purpose of NAT. It enables devices on a private network to share a single public IP address for external communication.

**27. One of the functions of NAT is to limit the number of public IP addresses an organization needs.**
*   **Answer: A) True.**
*   **Explanation:** NAT was developed as a key strategy to conserve the limited global supply of IPv4 addresses by allowing an organization to use many private IPs internally while only needing a few public IPs.

**28. Physical security controls include preventive, detective, deterrent, compensating, and recovery mechanisms.**
*   **Answer: A) True.**
*   **Explanation:** Physical security relies on a layered defense model that includes all these types of controls to protect assets.

**29. Backup power systems are classified as preventive controls rather than compensating controls.**
*   **Answer: B) False.**
*   **Explanation:** A backup power system is a *recovery* or *compensating* control. It activates *after* a power failure occurs to restore or maintain functionality. It does not prevent the power failure itself.

**30. A mantrap security system allows multiple doors to be opened simultaneously for ease of access.**
*   **Answer: B) False.**
*   **Explanation:** A mantrap's security relies on an interlocking mechanism that *prevents* doors from being open at the same time, thereby stopping unauthorized individuals from tailgating.

***

### Part B: Practical Questions

This section provides a theoretical walkthrough, as I cannot download or run software.

**Qn. One: Hands-On Assessment Using Anti DDoS Guardian**

**a) Installation and Configuration**

*   **Step-by-Step Process:**
    1.  **Download:** Use a web browser to go to `http://www.beethink.com/download/`. Find the link for "Anti DDoS Guardian v6.1" and save the installer file.
    2.  **Installation:** Double-click the downloaded `.exe` file to start the installation wizard. Accept the EULA, select an installation location, and complete the setup.
    3.  **Launch:** Open the application from the Start Menu or a desktop shortcut.
*   **Initial Configuration & Permissions:**
    *   The application would require **Administrator privileges** to monitor network interfaces and apply firewall rules. A Windows UAC prompt would need to be accepted.
    *   It would likely prompt you to select which network interface card (NIC) to monitor (e.g., your primary Ethernet or Wi-Fi adapter).

**b) Practical Toolset Exploration**

Here are six likely tools within Anti DDoS Guardian's dashboard:

1.  **Tool:** **Live Traffic Monitor**
    *   **Function:** Visualizes real-time network traffic volume (packets/sec, bandwidth).
    *   **Response to Test:** During a DDoS simulation (e.g., **spoofed IPs**), this graph would show a massive, immediate spike in inbound traffic, alerting the administrator to an attack.

2.  **Tool:** **Connection Table**
    *   **Function:** Shows a list of all active TCP/UDP connections to and from the machine, including source/destination IPs and ports.
    *   **Response to Test:** A **port scan** would cause a rapid succession of new, short-lived connections from a single IP to many different ports on the host machine to appear in this table.

3.  **Tool:** **IP Blacklist**
    *   **Function:** A list of IP addresses that are automatically and permanently blocked by the firewall.
    *   **Response to Test:** When the software detects a port scan or attack from a specific IP, it would automatically add the offending IP to this blacklist, dropping all further communication.

4.  **Tool:** **Packet Filter Rules**
    *   **Function:** An interface for creating custom rules to block traffic based on criteria like IP address, port number, protocol, or even packet content.
    *   **Response to Test:** In response to a **spoofed IP** attack that uses a specific protocol (like ICMP), a temporary rule could be created here to block all incoming ICMP traffic to mitigate the attack.

5.  **Tool:** **Log Viewer**
    *   **Function:** A detailed log of all detected events, actions taken, and system notifications.
    *   **Response to Test:** After a simulated attack, the log would contain entries detailing the event, such as "Port Scan detected from 1.2.3.4," and the corresponding action, "IP 1.2.3.4 has been blocked."

6.  **Tool:** **TCP/UDP Flow Control**
    *   **Function:** Sets thresholds for the number of new connections or packets per second allowed from a single IP.
    *   **Response to Test:** During a **port scan**, the attacker's IP would quickly exceed the configured threshold for new connections, triggering the system to automatically block it.
