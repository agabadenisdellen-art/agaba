# Zeek: A Comprehensive Guide to Network Traffic Analysis

## Introduction to Zeek

**Definition:** Zeek (formerly known as Bro) is a powerful and flexible open-source **network traffic analyzer**. It's not an active security device like a firewall or an Intrusion Prevention System (IPS); instead, it's a passive observer, like a court reporter for your network. It watches all the traffic and creates a high-level, richly detailed, and easy-to-understand transcript of everything that happens.

Think of it this way: if a tool like Wireshark gives you a recording of every single word spoken in a room, Zeek gives you a clean, organized, and searchable summary of all the conversations that took place, who was talking to whom, and what they were talking about.

**The Importance and Philosophy of Zeek:**

Zeek operates on a different philosophy from many other security tools. Traditional Intrusion Detection Systems (IDS) like Suricata are primarily **signature-based**. They have a big book of known "bad things" (signatures or rules), and they alert you if they see one of them. This is very effective, but it has a limitation: it can only find what it already knows about.

Zeek's approach is different:

*   **It Assumes You Don't Know What You're Looking For:** Zeek's primary goal is not just to find attacks but to provide you with high-quality, comprehensive data about your network. It creates detailed logs of normal activity, which is an incredibly powerful resource for security analysts.
*   **Data-Driven Security:** By having a complete record of network events, security teams can perform **threat hunting**—proactively searching for signs of malicious activity, rather than just waiting for an alarm to go off. If a new type of attack is discovered, analysts can go back through their Zeek logs to see if they were targeted in the past.
*   **Flexibility and Extensibility:** Zeek is also a powerful platform for network analysis. It has its own scripting language that allows security professionals to create custom scripts to detect new threats or enforce unique security policies. This makes it incredibly adaptable to any environment.
*   **It Complements Other Tools:** Zeek is not a replacement for an IDS or a firewall. It is designed to work alongside them. An IDS can provide the initial "smoke alarm," while Zeek provides the detailed forensic data needed to investigate what happened, how it happened, and what the impact was.

## The Core Functions of Zeek

Zeek's main function is to observe network traffic and translate it into a series of high-level, protocol-specific **transaction logs**. Unlike raw packet captures (PCAPs), which are bulky and difficult to parse, Zeek logs are compact, human-readable, and focus on the *meaning* of the communication.

### 1. Traffic Capture and Parsing

*   **Function:** Zeek listens on a network interface (just like Wireshark or Suricata) and captures a copy of every packet. It then reassembles these packets into their respective connections and protocols.
*   **How it Works:** Zeek has a deep understanding of dozens of common network protocols, including HTTP, DNS, FTP, SSL/TLS, and many more. It decodes the raw traffic and understands the specific actions being performed. For example, it doesn't just see a packet on port 80; it sees an HTTP GET request for a specific webpage and the server's response.

### 2. The Power of Transaction Logs

This is the heart of what makes Zeek so special. For every type of protocol it understands, Zeek generates a dedicated log file. These logs are typically stored in a plain text, tab-separated format that is easy to read and can be ingested into other tools like SIEMs or data analysis platforms.

Here are some of the most important logs Zeek produces:

*   **`conn.log`:** This is the master log of all connections. It records the source and destination IP addresses and ports, the protocol used, the duration of the connection, and how much data was sent and received. It gives you a high-level overview of all the traffic on your network.
*   **`http.log`:** This log contains a detailed record of every HTTP request and response. You can see which websites were visited, the type of request (GET, POST, etc.), the browser's user-agent string, and the server's response code.
*   **`dns.log`:** This records all DNS queries and their corresponding answers. This is invaluable for detecting malicious activity, as many types of malware use DNS for communication.
*   **`ssl.log`:** For encrypted traffic, this log provides details about the SSL/TLS handshake, such as the server's certificate information and the encryption cipher used. While you can't see the content of the traffic, you can still gain valuable metadata.
*   **`files.log`:** This log tracks files that are transmitted over the network. Zeek can even be configured to extract these files and calculate their MD5/SHA1 hashes, which can then be checked against threat intelligence databases.

### 3. The Zeek Scripting Engine

*   **Function:** Zeek's behavior is controlled by a powerful and flexible scripting language. The default scripts that come with Zeek are what generate the standard set of logs, but users can write their own scripts to extend Zeek's functionality.
*   **What it Can Do:**
    *   **Custom Detections:** You can write a script to detect very specific, policy-violating behavior. For example, you could write a script that generates an alert if an employee from the HR department tries to connect to a server in the engineering department.
    *   **Active Responses:** While Zeek is primarily passive, its scripting engine can be used to trigger active responses. For example, you could write a script that, upon detecting a certain type of attack, automatically adds the attacker's IP address to a firewall blocklist.
    *   **New Protocol Analysis:** If you have custom or proprietary protocols on your network, you can write your own analyzer in Zeek script to decode and log this traffic.

## Real-Life Examples of Zeek in Action

Here are a few practical scenarios that demonstrate the power of Zeek's data-centric approach.

### Example 1: Investigating a Phishing Incident

*   **Scenario:** An employee reports that they may have accidentally clicked on a phishing link and entered their credentials on a fake login page.
*   **How Zeek Helps:** A signature-based IDS might not have detected this, as the initial email and website may not have matched a known malicious signature. With Zeek, the security team has a complete record of the network activity.
*   **The Investigation Process:**
    1.  The analyst filters the **`dns.log`** for the time of the incident to see what domains the employee's computer was looking up. They spot a suspicious-looking domain, like `micros0ft-login.com`.
    2.  Pivoting to the **`http.log`**, they filter for all traffic from the employee's computer to that suspicious domain. They can see the full URL of the fake login page, the user-agent of the employee's browser, and, most importantly, they can see that a `POST` request was made, which is how the credentials were likely submitted.
    3.  In the **`conn.log`**, they can see the full connection details, including the attacker's IP address, the duration of the connection, and how much data was transferred.
*   **Result:** The Zeek logs provide concrete, actionable evidence of exactly what happened. The security team can now block the malicious domain, reset the employee's password, and search the logs to see if any other employees visited the same site.

### Example 2: Threat Hunting for Data Exfiltration

*   **Scenario:** A security analyst has a hypothesis: "I believe an attacker may be slowly leaking data out of our network using DNS tunneling."
*   **How Zeek Helps:** DNS tunneling is a stealthy attack that is very difficult to detect with traditional tools. However, it creates unusual patterns in DNS traffic that can be spotted in Zeek's logs.
*   **The Hunting Process:**
    1.  The analyst starts by examining the **`dns.log`**. Instead of looking for a specific signature, they look for anomalies. They might sort the log to find which internal computers are making the highest *number* of DNS requests.
    2.  They might also look for unusually *long* DNS queries (e.g., `a73f1b9c.data.attacker.com`) or an abnormally high number of queries for `TXT` records, both of which are common indicators of DNS tunneling.
    3.  Once a suspicious internal machine is identified, the analyst can pivot to the **`conn.log`** to see where it's sending all these DNS requests. If they're all going to a single, unknown external DNS server, that's a major red flag.
*   **Result:** By analyzing the patterns and statistics in the Zeek logs, the analyst can identify a likely compromised host that would have been missed by signature-based systems.

### Example 3: Enforcing Network Security Policy

*   **Scenario:** A company has a strict policy that no unencrypted FTP should be used on its network, as it transmits usernames and passwords in cleartext.
*   **How Zeek Helps:** Zeek can be used to monitor for policy violations, not just malicious attacks.
*   **The Implementation:**
    1.  Zeek automatically generates a log called **`ftp.log`** that records all FTP sessions.
    2.  A security administrator can easily write a simple Zeek script that says: "If you see an event for a new FTP connection, and it is *not* using TLS encryption, then write a custom notice to the `notice.log`."
    3.  The `notice.log` is a special log file that Zeek uses for high-priority, human-readable alerts.
*   **Result:** The administrator can now monitor the `notice.log` to get immediate notifications of any policy violations. This allows them to identify and address insecure practices on the network before they can be exploited.

## Step-by-Step Installation Guide (for Ubuntu Server)

This guide provides the official and recommended way to install the latest version of Zeek on an Ubuntu Server (20.04 or newer), which is perfect for a virtual machine setup.

### Step 1: Update Your System

Ensure your system's package lists and installed packages are current.

```bash
sudo apt-get update
sudo apt-get upgrade -y
```

### Step 2: Add the Official Zeek Repository

Zeek provides its own repository to ensure you can easily install the latest version. First, you need to install the necessary tools to add a new repository.

```bash
sudo apt-get install curl lsb-release gnupg -y
```

Next, add Zeek's GPG key to verify the package's authenticity.

```bash
curl -fsSL https://download.opensuse.org/repositories/security:zeek/xUbuntu_22.04/Release.key | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/security_zeek.gpg > /dev/null
```
*(**Note:** If you are using a different version of Ubuntu, like 20.04, replace `xUbuntu_22.04` in the URL accordingly.)*

Now, add the repository itself to your system's sources list.

```bash
echo 'deb http://download.opensuse.org/repositories/security:/zeek/xUbuntu_22.04/ /' | sudo tee /etc/apt/sources.list.d/security:zeek.list
```

### Step 3: Install Zeek

With the repository added, update your package list again and then install Zeek.

```bash
sudo apt-get update
sudo apt-get install zeek -y
```

This command will install the core Zeek engine and all its required dependencies. It will also install `zeekctl`, the command-line tool used to manage the Zeek installation.

### Step 4: Configure Zeek's Environment Path

For convenience, add the Zeek binary directory to your system's PATH. This allows you to run Zeek commands from anywhere.

```bash
echo 'export PATH=$PATH:/opt/zeek/bin' >> ~/.bashrc
source ~/.bashrc
```

### Step 5: Verify the Installation

Check that Zeek has been installed correctly by checking its version.

```bash
zeek --version
```

This should output the version of Zeek that was just installed. You are now ready to configure and run Zeek.

## Running and Using Zeek on a Virtual Machine

The `zeekctl` tool is the primary way to manage a Zeek installation. It handles starting, stopping, and configuring the Zeek processes.

### Step 1: Initial Configuration

Before you can start Zeek, you need to tell it which network interface to monitor and what IP ranges are part of your local network.

First, find your network interface name:
```bash
ip a
```
Look for the primary interface, which is often named `eth0` or `ens33`.

Next, open the `node.cfg` file. This file tells Zeek which interface to listen on.
```bash
sudo nano /opt/zeek/etc/node.cfg
```
Change the line `interface=eth0` to match your interface name.

Then, open the `networks.cfg` file. This file tells Zeek which IP ranges are "local" to your network. This is the most important setting to configure correctly.
```bash
sudo nano /opt/zeek/etc/networks.cfg
```
By default, it includes private IP address ranges like `192.168.0.0/16`. Make sure the IP range of your virtual machine and local network is included here.

### Step 2: Start Zeek with `zeekctl`

Now you can use `zeekctl` to perform a first-time setup and start the Zeek service.

```bash
sudo zeekctl install
sudo zeekctl start
```

The `install` command will prepare Zeek's environment, and `start` will launch the Zeek processes in the background.

You can check the status at any time:
```bash
sudo zeekctl status
```
It should show that a Zeek instance is running.

### Step 3: Exploring the Logs

Zeek's logs are the most valuable output. By default, they are stored in `/opt/zeek/logs/current/`.

Navigate to the directory:
```bash
cd /opt/zeek/logs/current/
ls -l
```
You will see a list of log files, such as `conn.log`, `dns.log`, `http.log`, and many others.

These logs are standard text files, so you can view them with tools like `cat`, `less`, or `tail`. However, they are formatted to be easily parsed by scripts and command-line tools. The `zeek-cut` tool is particularly useful for this.

**Example: Viewing the `conn.log`**

To see the source IP, destination IP, and service for all connections, you can use `zeek-cut`:

```bash
cat conn.log | zeek-cut id.orig_h id.resp_h service
```

**Example: Monitoring DNS Queries in Real-Time**

To watch new DNS queries as they happen, you can use `tail -f`:
```bash
tail -f dns.log | zeek-cut query answers
```
This will show you the domain being looked up and the answers provided by the DNS server.

### Step 4: Stopping Zeek

When you are finished, you can stop the Zeek service using `zeekctl`:
```bash
sudo zeekctl stop
```
This will gracefully shut down all Zeek processes.
