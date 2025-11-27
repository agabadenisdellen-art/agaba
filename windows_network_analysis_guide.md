# A Practical Guide to Network Analysis on Windows

This guide provides a comprehensive, Windows-focused walkthrough for your practical assignment. Part A covers network monitoring with Wireshark, and Part B explains how to install and use Zeek on Windows via the Windows Subsystem for Linux (WSL).

---

## **Part A: Network Monitoring and Port Scan Detection with Wireshark on Windows**

This section guides you through setting up a small network, installing the necessary tools on Windows, simulating a port scan, and analyzing the captured traffic to find the evidence.

### **Introduction**

**What is Network Monitoring?**
Network monitoring is the act of observing the data flowing across a computer network. For a security analyst, it is the most critical skill for understanding what is happening in your digital environment. By capturing and analyzing this traffic, you can diagnose technical problems and, more importantly, find the digital footprints of a cyberattack.

**Why Use Wireshark?**
Wireshark is the world's most popular network traffic analyzer. It captures the raw data packets from your network card and translates them into a human-readable format, giving you a microscopic view of every connection. It is an essential tool for any cybersecurity professional.

---

### **Step 1: Setting Up the Network (Windows Environment)**

This practical can be performed on a simple home Wi-Fi network. All you need are a few Windows-based devices.

*   **Network Medium:** A standard Wi-Fi or Ethernet network.
*   **Network Address Space:** `192.168.1.0/24` (This is a common example; yours may be different).

**The Devices:**

1.  **The Monitoring Station (Your Main PC):**
    *   **OS:** Windows 10 or 11.
    *   **Hypothetical IP:** `192.168.1.10`
    *   **Role:** This is where you will install and run **Wireshark**.

2.  **The Attacker Machine:**
    *   **OS:** Any Windows PC (this can be the same as the Monitoring Station).
    *   **Hypothetical IP:** `192.168.1.15`
    *   **Role:** This machine will launch the simulated port scan using **Nmap**.

3.  **The Target Machine:**
    *   **OS:** Any other Windows PC on your network.
    *   **Hypothetical IP:** `192.168.1.20`
    *   **Role:** This is the "victim" that the Attacker will scan.

4.  **Two Other Devices (Background Noise):**
    *   **Examples:** A smartphone, a tablet, a smart TV.
    *   **Role:** Use these for normal internet activity (browsing, streaming) during the capture. This creates realistic network "noise" that you will have to filter through during your analysis.

---

### **Step 2: Tool Installation on Windows**

**1. Install Wireshark (on the Monitoring Station)**

*   **Code/Steps:**
    1.  Open your web browser and go to the official download page: `https://www.wireshark.org/download.html`.
    2.  Download the **"Windows Installer (64-bit)."**
    3.  Run the downloaded `.exe` file.
    4.  Click "Next" through the setup wizard, leaving the default components selected.
    5.  **Crucial Step:** When you get to the "Install Npcap" screen, **ensure the checkbox is ticked**. Npcap is the essential driver that allows Wireshark to capture live network traffic. Click "Install."
    6.  Click "Finish" to complete the installation.

*   **How to Know It's Functioning Properly:**
    *   Launch Wireshark from your Start Menu.
    *   On the welcome screen, you should see a list of your network interfaces (e.g., "Wi-Fi," "Ethernet"). Next to the active one, you will see a **sparkline graph with moving lines**, indicating that Wireshark can see live traffic. This confirms it is working.

**2. Install Nmap (on the Attacker Machine)**

*   **Code/Steps:**
    1.  Open your web browser and go to the Nmap download page: `https://nmap.org/download.html`.
    2.  Download the latest **"Windows self-installer,"** which will be a file like `nmap-x.xx-setup.exe`.
    3.  Run the installer. Agree to the license and click "Next" through the prompts, accepting the default options.
    4.  Nmap is a command-line tool, so it will not create a desktop icon.

*   **How to Know It's Functioning Properly:**
    1.  Open the **Command Prompt** (search for `cmd` in the Start Menu).
    2.  Type the command `nmap --version` and press Enter.
    3.  If it is installed correctly, it will print the Nmap version information. If you get an error that the command is not recognized, you may need to restart your computer.

---

### **Step 3: Capture, Attack, and Analyze**

**1. Start the Capture (on the Monitoring Station):**
*   Launch Wireshark.
*   From the welcome screen, **double-click on your active network interface** (e.g., "Wi-Fi").
*   The capture will begin immediately. You will see packets scrolling by.

**2. Launch the Scan (on the Attacker Machine):**
*   Open a **Command Prompt**.
*   Type the following command to perform a TCP SYN scan, replacing the IP address with your target's actual IP:
    ```cmd
    nmap -sS 192.168.1.20
    ```
*   Wait for the scan to finish.

**3. Stop the Capture (on the Monitoring Station):**
*   Go back to Wireshark and click the **red square "Stop" button**.

**4. Filtering and Analyzing Logs in Wireshark:**
You now have the raw evidence. Let's find the attack.

*   **Code (Wireshark Filter):** In the "Apply a display filter..." bar, type this filter to isolate the conversation between the attacker and the target. Use their actual IP addresses.
    ```
    ip.addr == 192.168.1.15 && ip.addr == 192.168.1.20
    ```
*   **Analyzing the Filtered Logs:**
    *   **Attack Pattern:** You will see a large number of packets in a very short time. The `Source` IP will consistently be your attacker (`192.168.1.15`), and the `Destination` will be your target (`192.168.1.20`).
    *   The most telling sign is in the `Info` column. You will see the attacker sending a packet with `[SYN]` to a specific destination port, and the target replying with `[RST, ACK]` (meaning the port is closed). This pattern will repeat for dozens or hundreds of different ports.
    *   If a port is open, the target will reply with `[SYN, ACK]`.

*   **"Screenshot" of Packet Headers (Textual Representation):**
    This is what the filtered log will look like in Wireshark's main window.

    ```
    No.  Source          Destination     Protocol Info
    -----------------------------------------------------------------------------------
    123  192.168.1.15    192.168.1.20    TCP      [SYN] Dst Port: 443
    124  192.168.1.20    192.168.1.15    TCP      [SYN, ACK] Dst Port: 443
    125  192.168.1.15    192.168.1.20    TCP      [SYN] Dst Port: 444
    126  192.168.1.20    192.168.1.15    TCP      [RST, ACK] Dst Port: 444
    127  192.168.1.15    192.168.1.20    TCP      [SYN] Dst Port: 445
    128  192.168.1.20    192.168.1.15    TCP      [SYN, ACK] Dst Port: 445
    ```
    This clearly shows a scan in progress.

---

### **Step 4: Recommended Mitigation Measures**

1.  **Configure Windows Defender Firewall (Host-Based Firewall):**
    *   **Explanation:** Your Windows PC has a powerful built-in firewall. You should configure it to block all incoming connections except for the ones you explicitly need. This is known as a "default deny" policy.
    *   **How it Mitigates:** If a port is blocked, the Windows firewall will not send a `[RST, ACK]` response. It will simply drop the packet. The attacker's Nmap scan will report the port as "Filtered," which gives them less information and slows them down.

2.  **Implement an Intrusion Prevention System (IPS):**
    *   **Explanation:** An IPS is a more advanced tool (like Snort or Suricata) that can be installed on a dedicated network device. It is designed to recognize *patterns* of malicious behavior.
    *   **How it Mitigates:** An IPS rule can be written to detect a port scan (e.g., "one IP sends SYN packets to 20+ different ports on one host in 1 second"). When the rule is triggered, the IPS can automatically block the attacker's IP address, stopping the scan and any further attacks.

---

## **Part B: DNS Tunneling Analysis with Zeek on Windows (via WSL)**

This section explains how to install and run Zeek, a powerful network analysis tool, on your Windows machine to detect a stealthy attack like DNS tunneling.

### **Introduction to Zeek and WSL**

**What is Zeek?**
Unlike Wireshark, which shows you raw packets, Zeek is a network *analyzer*. It watches traffic and creates high-level, easy-to-read summary logs of what happened (e.g., a log of all connections, a log of all DNS queries, a log of all files transferred). This is extremely powerful for threat hunting.

**What is WSL (Windows Subsystem for Linux)?**
Zeek is designed to run on Linux. To use it on Windows, we use WSL. WSL is a free feature from Microsoft that lets you run a full Linux operating system (like Ubuntu) directly on your Windows machine, without needing a separate virtual machine. We will install Ubuntu inside WSL and then install Zeek onto Ubuntu.

---

### **Step 1: Install WSL and Ubuntu on Windows**

*   **Code/Steps:**
    1.  Open **PowerShell as an Administrator** (search for `PowerShell` in the Start Menu, right-click, and select "Run as administrator").
    2.  Run the following command to enable WSL and install the default Ubuntu distribution. This single command handles everything.
        ```powershell
        wsl --install
        ```
    3.  **Restart your computer** when prompted.
    4.  After restarting, an Ubuntu terminal window will open to complete the setup. You will be asked to create a **username and password**. These are for the Linux environment only and do not need to match your Windows password.

*   **How to Know It's Functioning Properly:**
    *   After setup, you will see a new application in your Start Menu called **"Ubuntu"**.
    *   Open it. You will be greeted with a Linux command prompt (e.g., `username@YourPC:~$`). This confirms WSL is working correctly.

---

### **Step 2: Install and Run Zeek inside WSL**

**Important:** All the following commands must be run inside the **Ubuntu terminal window**, not the Windows Command Prompt or PowerShell.

*   **Code: Step-by-Step Installation Commands:**
    1.  **Update Ubuntu:**
        ```bash
        sudo apt-get update && sudo apt-get upgrade -y
        ```
    2.  **Install Zeek Dependencies:**
        ```bash
        sudo apt-get install curl lsb-release gnupg -y
        ```
    3.  **Add Zeek's Official Repository:**
        ```bash
        curl -fsSL https://download.opensuse.org/repositories/security:zeek/xUbuntu_22.04/Release.key | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/security_zeek.gpg > /dev/null
        echo 'deb http://download.opensuse.org/repositories/security:/zeek/xUbuntu_22.04/ /' | sudo tee /etc/apt/sources.list.d/security:zeek.list
        ```
    4.  **Install Zeek:**
        ```bash
        sudo apt-get update
        sudo apt-get install zeek -y
        ```
    5.  **Add Zeek to your PATH** (for convenience):
        ```bash
        echo 'export PATH=$PATH:/opt/zeek/bin' >> ~/.bashrc
        source ~/.bashrc
        ```

*   **How to Know It's Functioning Properly (Installation):**
    *   In the Ubuntu terminal, run `zeek --version`. It should print the installed version number.

*   **Code: Running Zeek:**
    1.  **Configure Zeek:**
        *   Find your Windows network interface name. You can see this in Wireshark (e.g., "Wi-Fi").
        *   Edit Zeek's config file: `sudo nano /opt/zeek/etc/node.cfg`. Change the `interface=` line to match your Windows interface name.
        *   Edit Zeek's network list: `sudo nano /opt/zeek/etc/networks.cfg`. Make sure your local network IP range (e.g., `192.168.1.0/24`) is listed.
    2.  **Start the Zeek service:**
        ```bash
        sudo zeekctl install
        sudo zeekctl start
        ```
*   **How to Know It's Functioning Properly (Running):**
    *   Run the command `sudo zeekctl status`. The output should say **`Status: running`**.
    *   Wait a minute for some traffic to be logged, then run `ls /opt/zeek/logs/current`. You should see a list of log files like `conn.log`, `dns.log`, and `http.log`. This confirms Zeek is actively monitoring your Windows network traffic.

---

### **Step 3: Filtering and Analyzing Zeek Logs on Windows**

You do not need to stay in the Ubuntu terminal to view the logs. You can access them directly from Windows File Explorer.

1.  **Accessing Logs from Windows:**
    *   Open File Explorer.
    *   In the address bar, type `\\wsl.localhost\Ubuntu` and press Enter.
    *   This will open the Linux file system. Navigate to `/opt/zeek/logs/current`.
    *   You can open any of the `.log` files with a text editor like Notepad.

2.  **Filtering and Analysis (Simulated Scenario):**
    *   **The Goal:** We are looking for DNS tunneling. The key indicators are an unusually high number of DNS requests from one host, and/or DNS queries for very long, strange-looking domain names.
    *   **Analysis Steps:**
        1.  Open the `dns.log` file from the directory above.
        2.  Scan through the file. Instead of normal queries like `www.google.com`, you might see a suspicious pattern like this:
            ```
            #Fields  ts      uid     id.orig_h     id.orig_p  id.resp_h   id.resp_p   proto   query
            ...
            16378...  Cxyz... 192.168.1.55    54321      8.8.8.8     53          udp     NzE2NDc0Nm...ZXhhbXBsZQ==.malicious-site.com
            16378...  Abcd... 192.168.1.55    54322      8.8.8.8     53          udp     Y29tL3NlY3...JldC1maWxlLnBkZg==.malicious-site.com
            ...
            ```
        3.  **Detection:** You can immediately see that the host `192.168.1.55` is sending queries for extremely long, random-looking subdomains. This is the **evidence of DNS tunneling**. The attacker is encoding stolen data into these subdomains.

---

### **Step 4: Technical Report and Remediation**

(This section is the same as the previous guide, as the analysis and response are universal).

**Report Title:** Intrusion Analysis Report: DNS Tunneling for Data Exfiltration

**1. How the Intrusion Was Detected:**
The intrusion was identified by analyzing Zeek's `dns.log` for anomalies. The key indicators were a high volume of DNS queries from a single host (`192.168.1.55`) and the use of unusually long, encoded subdomains pointing to a single parent domain (`malicious-site.com`).

**2. Rule Signatures Triggered Alerts:**
While not a traditional signature, a custom Zeek script or a simple log analysis query acts as a rule. A query for "DNS queries longer than 50 characters" would have immediately triggered an alert on this activity.

**3. Remediation Steps Required:**
1.  **Containment:** Disconnect the compromised host (`192.168.1.55`) from the network immediately.
2.  **Blocking:** Block the malicious domain (`malicious-site.com`) and any associated IP addresses at the network firewall.
3.  **Eradication:** The compromised machine must be wiped and reinstalled from a trusted source.
4.  **Recovery:** Restore user data from a clean backup and conduct a network-wide sweep to ensure no other devices are compromised.
