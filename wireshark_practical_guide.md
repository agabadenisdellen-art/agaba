# A Practical Guide to Detecting a Port Scan with Wireshark

This document provides a detailed, step-by-step walkthrough of a practical network security exercise. We will set up a small network, simulate a common reconnaissance attack (a port scan), capture the network traffic using Wireshark, and then analyze that traffic to detect the malicious activity.

## Part 1: Introduction and Lab Setup

### Introduction

**What is Network Traffic Analysis?**
Network traffic analysis is the process of intercepting, recording, and analyzing the communication flowing across a computer network. It is a critical skill for network administrators and cybersecurity professionals. By understanding the traffic, you can troubleshoot performance issues, identify misconfigurations, and, most importantly, detect malicious activity and security threats.

**What is Wireshark?**
*   **Definition:** Wireshark is a free and open-source network protocol analyzer. It is the world's most popular tool for network analysis and is used by professionals and enthusiasts alike.
*   **Function:** Its primary function is to capture data packets traveling across a network and present them in a detailed, human-readable format. It can decode hundreds of different network protocols, allowing you to see exactly what is happening on your network at a microscopic level.
*   **Importance:** Think of Wireshark as a microscope for your network. It provides the ground truth of what is happening, making it an indispensable tool for diagnosing problems and investigating security incidents.

**What is Port Scanning?**
*   **Definition:** A port scan is a reconnaissance technique used by attackers to discover which services are running on a target computer. Every service that listens for connections on a network (like a web server or an email server) does so on a specific numbered "port." A port scan is like an attacker walking down a street and systematically checking every door and window on a house to see which ones are unlocked.
*   **Real-Life Example:** Before an attacker attempts to break into a web server, they will almost always perform a port scan to confirm that the server is running a web service (e.g., on ports 80 and 443) and to see what other potentially vulnerable services might be available. It is often the first step in a targeted attack.

### The Lab Environment

For this exercise, we will simulate a realistic small network. This could be a home Wi-Fi network or a dedicated lab environment using virtual machines.

**The Network:**
*   **Medium:** A standard Wi-Fi network.
*   **Network Address:** `192.168.1.0/24` (a very common home network setup).
*   **Gateway/Router:** `192.168.1.1`.

**The Five Interconnected Devices:**
We will define specific roles for our devices to make the scenario clear.

1.  **The Monitoring Station (Your Main Computer)**
    *   **Hypothetical IP:** `192.168.1.100`
    *   **Role:** This is the computer where you will install and run Wireshark. Its job is to capture all the traffic on the network for later analysis.

2.  **The Attacker Machine**
    *   **Hypothetical IP:** `192.168.1.101`
    *   **Role:** This computer will be used to launch the simulated attack. We will install a tool called **Nmap** on this machine to perform the port scan. This could be another physical computer or a virtual machine.

3.  **The Target Machine**
    *   **Hypothetical IP:** `192.168.1.102`
    *   **Role:** This is the "victim" computer. The Attacker will run a port scan against this machine to see what services it is running. This could also be another computer or a virtual machine.

4.  **Device #4: "Background Noise" (e.g., a Smartphone)**
    *   **Hypothetical IP:** `192.168.1.103`
    *   **Role:** This device will be used for normal, everyday activities like browsing websites or checking email.

5.  **Device #5: "Background Noise" (e.g., a Smart TV or another laptop)**
    *   **Hypothetical IP:** `192.168.1.104`
    *   **Role:** This device might be streaming a video or performing other benign network activities.

The purpose of the "Background Noise" devices is to make our simulation more realistic. A real network is never quiet; our job as analysts is to find the malicious packets hidden within all of this legitimate traffic.

## Part 2: Tool Installation Guide

Before we can begin the exercise, we need to install the necessary software on our designated machines.

### Tool 1: Wireshark (on the Monitoring Station)

Wireshark is the tool we will use to capture and analyze the network traffic.

**Installation Steps (for Windows):**
1.  **Navigate to the Download Page:** Open a web browser and go to the official Wireshark website: `https://www.wireshark.org/download.html`.
2.  **Download the Installer:** Select the "Windows Installer (64-bit)" for your system.
3.  **Run the Installer:** Once the download is complete, run the installer executable.
4.  **Follow the Setup Wizard:**
    *   Click "Next" on the welcome screen.
    *   Agree to the license terms.
    *   Leave the default components selected and click "Next."
    *   Choose your preferred shortcut options and click "Next."
    *   Specify an installation location (the default is usually fine) and click "Next."
    *   **Crucial Step:** When prompted, ensure that the box for **"Install Npcap"** is checked. Npcap is the library that Wireshark uses to actually capture live network data. It is essential for this exercise.
    *   Click "Install" and then "Finish" when the installation is complete.

**Installation Steps (for Ubuntu/Debian Linux):**
1.  **Open a Terminal:** Press `Ctrl+Alt+T`.
2.  **Add the Wireshark Repository:**
    ```bash
    sudo add-apt-repository ppa:wireshark-dev/stable
    sudo apt-get update
    ```
3.  **Install Wireshark:**
    ```bash
    sudo apt-get install wireshark -y
    ```
4.  **Configure Permissions:** During the installation, you will be asked a question about "non-superusers being able to capture packets." Use the arrow keys to select **"<Yes>"** and press Enter. This is important as it allows you to run Wireshark without needing to be the root user every time.
5.  **Add Your User to the `wireshark` Group:** For the permission change to take effect, you must add your user account to the new `wireshark` group.
    ```bash
    sudo usermod -aG wireshark $USER
    ```
6.  **Reboot:** The simplest way to apply the new group membership is to reboot your machine.

### Tool 2: Nmap (on the Attacker Machine)

Nmap ("Network Mapper") is a powerful open-source tool for network exploration and security auditing. We will use it to perform our simulated port scan.

**Installation Steps (for Windows):**
1.  **Navigate to the Download Page:** Open a web browser and go to the Nmap download page: `https://nmap.org/download.html`.
2.  **Download the Installer:** Find the latest stable release and download the Windows self-installer (e.g., `nmap-7.92-setup.exe`).
3.  **Run the Installer:** Run the downloaded executable.
4.  **Follow the Setup Wizard:** Agree to the license and accept the default installation options. Nmap will be installed as a command-line tool.

**Installation Steps (for Ubuntu/Debian Linux):**
1.  **Open a Terminal.**
2.  **Install Nmap:** The `nmap` package is available in the default repositories.
    ```bash
    sudo apt-get update
    sudo apt-get install nmap -y
    ```
3.  **Verify Installation:** You can verify that Nmap is installed by running:
    ```bash
    nmap --version
    ```
This should display the installed version of Nmap.

## Part 3: The Practical Exercise - Capture and Attack Simulation

Now that the lab is set up and the tools are installed, we can begin the practical part of the exercise.

### Step 1: Start the Wireshark Capture

1.  **Go to your Monitoring Station** (`192.168.1.100`), the computer with Wireshark installed.
2.  **Launch Wireshark.** You will be greeted with a welcome screen that lists all of your computer's network interfaces.
3.  **Select the Correct Interface.** You need to choose the interface that connects you to the network you want to monitor. This will typically be labeled **"Wi-Fi"** or **"Wireless Network Connection"** if you are on a Wi-Fi network, or **"Ethernet"** if you are on a wired network. You should see a sparkline graph next to it showing live traffic.
4.  **Start the Capture.** Double-click on the correct interface name to start capturing packets.

You will now see a live, scrolling feed of all the packets traveling across your local network segment. This can look overwhelming at first, but that's what we're here to learn how to analyze. Let this run.

### Step 2: Simulate the Port Scan Attack

1.  **Go to your Attacker Machine** (`192.168.1.101`), the computer with Nmap installed.
2.  **Open a Command Prompt or Terminal.**
3.  **Launch the Nmap Scan.** We will perform a **TCP SYN Scan**, which is a common and relatively stealthy type of port scan. This scan will check the most common 1,000 TCP ports on our Target machine.

    Execute the following command, replacing `192.168.1.102` with the actual IP address of your Target Machine:

    ```bash
    nmap -sS 192.168.1.102
    ```

    *   `nmap`: The command to run the Nmap program.
    *   `-sS`: This flag specifies the type of scan. `-sS` stands for "SYN Scan" (also known as a "half-open" scan).
    *   `192.168.1.102`: The IP address of our Target.

4.  **Wait for the Scan to Complete.** The scan will take a few moments. Nmap will print a report to your screen when it is finished, showing which ports it found to be open, closed, or filtered.

### Step 3: Stop the Wireshark Capture

1.  **Return to your Monitoring Station.**
2.  **Stop the Capture.** In the Wireshark window, click the red square **"Stop"** button in the top-left corner of the toolbar.

You now have a static file containing all the network traffic that occurred during our exercise, including the normal "background noise" and our simulated attack. The capture is complete. In the next section, we will analyze this data to find the evidence of the port scan.

## Part 4: Analysis - Detecting the Port Scan

This is the core of the exercise. We have a large capture file, and we need to find the needle in the haystack that represents our port scan.

### Step 1: Apply a Display Filter

The key to making sense of a large capture is to use **display filters**. These allow you to hide all the packets you don't care about and focus only on the ones that are relevant to your investigation.

We know the IP addresses of our Attacker (`192.168.1.101`) and our Target (`192.168.1.102`). Let's start by filtering for all traffic between these two hosts.

In the **"Apply a display filter..."** bar at the top of the Wireshark window, type the following and press Enter:

```
ip.addr == 192.168.1.101 && ip.addr == 192.168.1.102
```

This will instantly hide all the "background noise" from our other devices and only show packets that were sent between the Attacker and the Target.

### Step 2: Describe the Attack Pattern

Even with the filter, you will see a lot of packets. But now, a clear pattern should emerge. This is the **attack pattern** for a TCP SYN scan.

**What you will see:**
You will see a very long list of packets, almost all of which are coming from the source IP `192.168.1.101` and going to the destination IP `192.168.1.102`. The key characteristics to note are:

1.  **A Single Source, Many Destination Ports:** The source port on the attacker's side might change, but the source IP will always be the same. The destination port, however, will be different in almost every packet (e.g., 21, 22, 23, 25, 80, 110, 135, 139, 443, 445, etc.). This is the classic sign of a scan.
2.  **Only SYN Packets Sent:** The packets from the attacker will all be TCP packets with the **SYN** flag set. In the "Info" column, Wireshark will show this as `[SYN]`. The attacker is trying to initiate a connection but doesn't intend to complete it.
3.  **Responses are RST or SYN, ACK:** The Target machine will respond in one of two ways:
    *   If the port is **closed**, it will send back a packet with the **RST** (Reset) and **ACK** (Acknowledgment) flags set. Wireshark will show this as `[RST, ACK]`. You will see many of these.
    *   If the port is **open**, it will send back a **SYN, ACK** packet. Wireshark will show this as `[SYN, ACK]`. You will likely only see a few of these, corresponding to the services that are actually running on the target.

### "Screenshot" of Packet Headers (Textual Representation)

Since we cannot provide a real screenshot, here is a detailed textual representation of what the Wireshark packet list and packet detail panes would look like.

**Packet List Pane (Filtered):**
```
No.  Time      Source          Destination     Protocol Length Info
--------------------------------------------------------------------------------------------------
101  5.123     192.168.1.101   192.168.1.102   TCP      74     55462 → 22 [SYN] Seq=0 Win=64240 Len=0
102  5.124     192.168.1.102   192.168.1.101   TCP      74     22 → 55462 [SYN, ACK] Seq=0 Ack=1...
105  5.125     192.168.1.101   192.168.1.102   TCP      74     55464 → 23 [SYN] Seq=0 Win=64240 Len=0
106  5.126     192.168.1.102   192.168.1.101   TCP      66     23 → 55464 [RST, ACK] Seq=1 Ack=1...
109  5.127     192.168.1.101   192.168.1.102   TCP      74     55466 → 80 [SYN] Seq=0 Win=64240 Len=0
110  5.128     192.168.1.102   192.168.1.101   TCP      74     80 → 55466 [SYN, ACK] Seq=0 Ack=1...
...  ...       ...             ...             ...      ...    ...
```

**Packet Header Details Pane (for packet #105):**
Clicking on packet #105 from the list above would show the following details.

```
▼ Frame 105: 74 bytes on wire (592 bits), 74 bytes captured (592 bits)
▼ Ethernet II, Src: Attacker_MAC (0a:0b:0c:0d:0e:0f), Dst: Target_MAC (1a:1b:1c:1d:1e:1f)
▼ Internet Protocol Version 4, Src: 192.168.1.101, Dst: 192.168.1.102
▼ Transmission Control Protocol, Src Port: 55464, Dst Port: 23, Seq: 0, Len: 0
    Source Port: 55464
    Destination Port: 23  <-- This is the port being scanned (Telnet)
    [Stream index: 8]
    [TCP Segment Len: 0]
    ▼ Flags: 0x002 (SYN)
        000. .... .... = Reserved: Not set
        ...0 .... .... = Nonce: Not set
        .... 0... .... = Congestion Window Reduced: Not set
        .... .0.. .... = ECN-Echo: Not set
        .... ..0. .... = Urgent: Not set
        .... ...0 .... = Acknowledgment: Not set
        .... .... 0... = Push: Not set
        .... .... .0.. = Reset: Not set
        .... .... ..1. = Syn: Set  <-- The SYN flag is the only one set
        .... .... ...0 = Fin: Not set
```

This detailed view confirms that the packet from the attacker is a TCP packet with only the SYN flag set, directed at port 23 of the target, which is the defining characteristic of this type of scan.

## Part 5: Mitigation and Recommendations

Detecting an attack is only the first step. The ultimate goal is to prevent them. Here are two key mitigation measures to protect against port scanning.

### Mitigation Measure 1: Configure a Host-Based Firewall

*   **What it is:** A host-based firewall is a software application that runs on an individual computer (the "host") and controls the network traffic that is allowed to enter and leave that specific machine. Modern operating systems like Windows, macOS, and Linux all include a powerful built-in firewall.
*   **How it works:** A firewall works by enforcing a set of rules. The best practice is to use a **"default deny"** policy. This means the firewall blocks *all* incoming connections by default and only allows traffic to specific ports that you explicitly open. This dramatically reduces the "attack surface" of the computer. If a port is not open, it cannot be attacked.
*   **Practical Implementation:**
    *   **On Windows:** Use the "Windows Defender Firewall with Advanced Security" tool. You can create rules that block all incoming connections except for those on ports that you need (e.g., allowing inbound connections on port 443 for a web server). For any port that doesn't have an "Allow" rule, the firewall will silently drop the packet. The attacker's Nmap scan would report these ports as "Filtered" and would not be able to determine if they are open or closed.
    *   **On Linux:** Use the `ufw` (Uncomplicated Firewall) tool. The commands are very simple:
        ```bash
        sudo ufw default deny incoming  # Block all incoming traffic by default
        sudo ufw allow ssh              # Allow incoming SSH connections (port 22)
        sudo ufw allow http             # Allow incoming web traffic (port 80)
        sudo ufw enable                 # Turn the firewall on
        ```

### Mitigation Measure 2: Implement an Intrusion Prevention System (IPS)

*   **What it is:** An Intrusion Prevention System (IPS) is a more advanced security tool that actively monitors network traffic for malicious *patterns*. Unlike a simple firewall that just looks at individual packets, an IPS is stateful and can analyze sequences of traffic.
*   **How it works:** An IPS like Suricata or Snort can be configured with rules specifically designed to identify port scans. The rule would look for a pattern like "a single source IP sending a large number of SYN packets to many different destination ports on a single host in a short amount of time." When this pattern is detected, the IPS can be configured to take automatic action.
*   **Practical Implementation:**
    1.  An IPS is placed "inline" on the network, meaning all traffic must pass through it.
    2.  When the IPS detects the port scanning pattern from the Attacker's IP (`192.168.1.101`), its rules engine is triggered.
    3.  The IPS automatically adds a temporary rule to its internal firewall to **drop all traffic** originating from `192.168.1.101`.
    4.  This action effectively blocks the scan from continuing and prevents the attacker from launching any follow-up attacks from that IP address. The IPS will also log the event and send an alert to a security administrator.
