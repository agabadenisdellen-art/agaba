# Chapter 10: The Internet and Client–Server Systems

## Detailed Summary

This chapter explores the architecture of the public Internet, key technologies used for secure communication over it (VPN, IPv6), and fundamental client-server applications like DNS and DHCP that make it all work. It also introduces the concept of server virtualization.

### 1. Internet Architecture

The Internet is not a single network but a massive, global network of interconnected networks.

-   **Internet Service Providers (ISPs):** Provide Internet access to customers. They are organized in a hierarchy:
    -   **Tier 1 (National ISPs):** Own and operate the major backbone networks of the Internet. They interconnect with each other via peering agreements.
    -   **Tier 2 (Regional ISPs):** Connect to Tier 1 providers and serve a specific region.
    -   **Tier 3 (Local ISPs):** Connect to Tier 2 providers and serve a local area.
-   **Internet Exchange Points (IXPs):** Physical locations where different ISPs connect their networks to exchange traffic. This is a primary way the "network of networks" is formed.
-   **Autonomous System (AS):** A large network or group of networks under a single administration that presents a common routing policy to the Internet (e.g., an ISP, a large university). Each AS is identified by a unique **ASN (Autonomous System Number)**. Routing *within* an AS is done by an **IGP** (like OSPF), while routing *between* ASs is done by an **EGP** (specifically, **BGP**).
-   **World Wide Web (WWW):** A system of interconnected public web pages and other resources, accessible via the Internet. It is powered by **search engines** (like Google) that use "spiders" to crawl and index web content.

### 2. Virtual Private Network (VPN)

A VPN creates a secure, private connection over a public network like the Internet.

-   **Technology:** It uses **tunneling**, which encapsulates an encrypted IP packet inside another IP packet for secure transport.
-   **Benefits:** Cost-effective, highly accessible, and flexible for connecting remote users and sites.
-   **Risks:** Relies on the public Internet, which can have unpredictable performance and inherent security risks compared to a private WAN.
-   **Types of VPN:**
    -   **Remote-Access VPN:** Connects an individual remote user (e.g., a telecommuter) to the corporate network.
    -   **Site-to-Site VPN:** Connects two entire networks (e.g., a headquarters and a branch office).
-   **VPN Protocols:**
    -   **IPSec (IP Security):** A highly secure Layer 3 protocol. It operates in two modes:
        -   **Tunnel Mode:** Encrypts the *entire* original IP packet and adds a new IP header. Used for site-to-site VPNs.
        -   **Transport Mode:** Encrypts only the *payload* of the original IP packet, leaving the original header intact. Used for end-to-end security between hosts.
    -   **SSL/TLS (Secure Socket Layer/Transport Layer Security):** A Layer 4 protocol built into web browsers (`https`). It's very easy to use for remote access VPNs, as no special client software is needed.

### 3. IPv6 (IP Next Generation)

IPv6 is the successor to IPv4, designed to solve the problem of IPv4 address exhaustion.

-   **IP Addressing:** Uses a **128-bit** address (vs. 32-bit for IPv4), providing a virtually limitless number of addresses. It is written in hexadecimal format (e.g., `2001:0db8:85a3:0000:0000:8a2e:0370:7334`). Address abbreviation rules are used to simplify them.
-   **Packet Structure:** Features a simplified header with fewer fields for more efficient router processing. It removes the header checksum, relying on higher-layer protocols for error checking.
-   **Transition from IPv4:** Since the world cannot switch to IPv6 overnight, several transition mechanisms are used:
    -   **Dual IP Stacks:** A device runs both IPv4 and IPv6 simultaneously.
    -   **Packet Tunneling:** Encapsulating an IPv6 packet inside an IPv4 packet to traverse an IPv4-only part of the network (or vice-versa).
    -   **Direct Address Conversion (NAT64):** A gateway translates between IPv6 and IPv4 addresses.

### 4. Key Client-Server Applications

-   **Domain Name System (DNS):** The "phonebook" of the Internet. It is an application-layer protocol that translates human-readable **domain names** (e.g., `www.google.com`) into machine-readable **IP addresses** (e.g., `172.217.6.196`).
    -   **Process (Name Resolution):** When a user enters a domain name, their computer queries a **local DNS server**. If the local server doesn't know the IP, it queries a **root DNS server**, which directs it to the correct **authoritative DNS server** for that domain, which provides the final answer.
-   **Dynamic Host Configuration Protocol (DHCP):** An application-layer protocol that automatically assigns IP addresses and other network configuration information (subnet mask, default gateway, DNS server) to hosts on a network.
    -   **Process:** A client broadcasts a DHCP request, and a DHCP server on the network "leases" it an IP address for a specific period of time.

### 5. Server Virtualization

Virtualization is a technology that allows a single physical server to run multiple independent "virtual machines" (VMs).

-   **Concept:** Each VM acts like a complete, stand-alone computer with its own operating system and applications.
-   **Approaches:**
    -   **Hosted Virtualization:** Virtualization software runs on top of a standard host operating system (e.g., running VirtualBox on a Windows machine).
    -   **Hypervisor-Based Virtualization:** A lightweight software layer called a **hypervisor** runs directly on the hardware, managing the VMs. This is more efficient and is the standard for data centers.
-   **Benefits:**
    -   **Server Consolidation:** Reduces the number of physical servers needed, saving costs on hardware, power, and cooling.
    -   **High Efficiency:** Greatly improves the utilization of hardware resources.
    -   **Flexibility:** VMs can be easily moved, copied, and backed up.
-   **Cloud Computing:** Server virtualization is the foundational technology that enables cloud computing, allowing providers to pool and dynamically allocate resources to many customers.

---

## Answers to In-Chapter Exercises

### Exercise 10.1

*This is a hands-on exercise using the `tracert` command. A typical result would show:*
1.  The packet first hops through the local router (default gateway).
2.  It then hops through several routers within the local ISP's network.
3.  Next, it hops across one or more Tier 1 or Tier 2 backbone provider networks.
4.  Finally, it enters the network of the ISP hosting the destination website and reaches the server.
5.  Using a `whois` tool (like on arin.net) on the router IP addresses would reveal the names of the different ISPs involved in the path.

### Exercise 10.2

1.  **ASN Search (examples):**
    -   Google: AS15169
    -   Facebook: AS32934
    -   MIT: AS3
    -   Stanford: AS32
2.  **ISP Search:**
    -   Proctor and Gamble (AS3561): **AT&T**
    -   Toyota (AS3549): **AT&T**
    -   BusinessWeek (AS7843): **Bloomberg LP** (self-hosted)
    -   McDonald (AS3707): **AT&T**

### Exercise 10.3

No, subnet masks are not needed in IPv6 in the same way. The first 64 bits are fixed as the network/subnet prefix, and the last 64 bits are for the host. The `/64` prefix is standard and implied.

### Exercise 10.4

-   **ARIN (North America):** Starts with `2000::/3` (specifically, `2600::/8` range is common).
-   **RIPE NCC (Europe):** Starts with `2000::/3` (specifically, `2a00::/8` range is common).
-   **APNIC (Asia/Pacific):** Starts with `2000::/3` (specifically, `2400::/8` range is common).
-   *(And so on for LACNIC and AfriNIC, all part of the `2000::/3` global unicast block)*

### Exercise 10.5

1.  **Abbreviate:**
    *   a. `AD89:C0:204::ABC0:B:20`
    *   b. `::D89:EC0:204:FB:A20`
    *   c. `D89:C0:204::B:0`
2.  **Restore:**
    *   a. `0089:00CD:0004:0000:0000:0000:000B:0020`
    *   b. `000B:00FD:0003:0F98:0000:0000:0D0B:0F20`
    *   c. `00CB:0001:0003:0008:0000:0000:000B:0000`

### Exercise 10.6

1.  `ipconfig /all` would show the IP address of the DNS server(s) your computer is configured to use.
2.  `ipconfig /displaydns` shows the computer's local DNS cache.
3.  The benefit of the cache is speed. If you revisit a site, your computer already knows the IP address and doesn't have to perform a full DNS lookup again.
4.  `ipconfig /flushdns` clears this cache.
5.  When you visit a single modern website, your browser may have to resolve dozens of domain names for ads, trackers, content delivery networks (CDNs), and embedded resources, which is why many new entries appear in the DNS cache.
6.  `nslookup` sends its query to the configured **local DNS server**.

### Exercise 10.7

1.  `ipconfig /all` will show you the configured DNS server. If this IP is unfamiliar or suspicious, it may have been changed.
2.  Editing the `hosts` file to map `www.crcpress.com` to your ISP's IP address would cause your browser to load your ISP's homepage when you try to visit `www.crcpress.com`. This is because the `hosts` file is checked *before* a DNS query is made.
3.  Mapping `ad.doubleclick.net` to `127.0.0.1` (the loopback address) means that whenever your browser tries to fetch an ad from that domain, the request is redirected to your own computer, where no ad server is running. The request fails instantly, effectively blocking the ad and preventing the ad server from placing any tracking cookies.

---

## Answers to End-of-Chapter Review Questions

1.  **E. Many web servers obtain their IP addresses from DHCP servers.** is INCORRECT. Servers need stable, permanent IP addresses and are configured with static IPs.
2.  **A. .com** is a top-level domain.
3.  **E. TTL prefix** is NOT part of the IPv6 network address. TTL (Hop Limit) is a separate field in the packet header.
4.  **B. National ISP networks form the Internet backbone.** is CORRECT.
5.  This arrangement is called **E. Peering**.
6.  The junction point is a **C. internet exchange point**.
7.  **C. IPv6 supports broadcasting of IP packets as IPv4 does.** is INCORRECT. IPv6 eliminates broadcast in favor of more efficient multicast.
8.  **A. VPN performance is not affected by Internet congestion.** is NOT a benefit. VPN performance is directly subject to the performance of the underlying public Internet.
9.  **B. IPSec in the transport mode** requires software on each user computer for end-to-end security.
10. **C. IPv6 packets have a simpler header structure than IPv4 packets.** is a true statement.
11. **E. IPSec: internet, SSL: transport** is the correct pairing.
12. This process is called **C. Tunneling**.
13. **A. The host machine needs its own host operating system ONLY when “hosted virtualization” is used.** is the key difference.
14. The correct conversion is **A. 0000:0000:0000:0000:0000:ffff:123.45.67.89**.
15. **A. The top-level domain includes university names.** is WRONG. University names (like `stanford`) are second-level domains under the `.edu` TLD.
16. **B. The number of servers an IT professional can manage declines...** is INCORRECT. Virtualization dramatically increases the number of servers a single admin can manage.
17. **C. SSL** is the security standard built into web browsers.
18. This information is kept in the **D. host computers**' local `hosts` file.
19. **E. The data field of an IP packet is protected by encryption, but not the IP header.** describes the transport mode of IPSec.
20. **B. The IPSec’s tunnel mode is more cost-effective to implement than the transport mode.** is CORRECT because it only requires configuration on the gateway/router, not on every individual client computer.
# Chapter 11: Cybersecurity: Threats

## Detailed Summary

This chapter introduces the most common types of cybersecurity attacks, explaining the methods perpetrators use to compromise systems, steal information, and disrupt services. The focus is on understanding the nature of these threats.

### 1. Malicious Codes (Malware)

Malware is software designed to cause damage to a system or steal information.

-   **Virus:** An executable program that attaches itself to a host program. When the host is run, the virus executes, spreading to other programs and potentially damaging files or system performance. **Ransomware** is a type of virus that encrypts a victim's files and demands a ransom for the decryption key.
-   **Worm:** A standalone program that can replicate itself and spread to other computers over a network, often without any human intervention. Worms consume bandwidth and can carry destructive payloads.
-   **Trojan Horse (Trojan):** Malware disguised as a legitimate program. When run, it creates a **backdoor**, allowing an attacker to gain unauthorized remote access to the victim's system to steal data, install other malware, or use the system in a botnet.
-   **Bot:** A program that turns a computer into a "zombie," which can be remotely controlled by an attacker. A network of these zombie computers is called a **botnet**, and it can be used to launch large-scale attacks like DDOS or spam campaigns.
-   **Other Types:**
    -   **Rootkit:** Malware designed to hide its own presence (and the presence of other malware) from the user and antivirus software.
    -   **Spyware:** Secretly gathers information about the user, such as keystrokes (keystroke logger) and browsing habits.
    -   **Adware:** Displays unwanted advertisements.

### 2. Password Cracking

This is the process of recovering passwords from a system's stored password file (which contains hashed or encrypted passwords).

-   **Brute Force Method:** The attacker's software tries every possible combination of characters until it finds a match. This is effective against short or simple passwords.
-   **Dictionary Method:** The software tries words from a dictionary, a more efficient method since many people use common words as passwords.

### 3. Spoofing (Masquerading)

Spoofing is the act of faking an identity to deceive a system or user.

-   **IP Spoofing:** Hiding the true source IP address of a packet. Used to conceal the origin of an attack.
-   **MAC Spoofing:** Altering a device's MAC address. Can be used to bypass MAC-based access controls or to launch a **MAC address flooding** attack, which overwhelms a switch's MAC table and forces it to act like a hub, broadcasting all frames.
-   **Email Spoofing:** Faking the sender's email address. Commonly used in phishing and spam.
-   **Web (HTTP) Spoofing:** Creating a fraudulent website that looks identical to a legitimate one to trick users into entering their credentials.

### 4. Denial of Service (DoS) Attack

A DoS attack aims to make a system or network resource unavailable to legitimate users.

-   **Method:** The attacker floods the target (usually a server) with a massive amount of bogus traffic or requests.
-   **Types of Floods:**
    -   **Ping Flood:** Overwhelming the target with ICMP echo requests.
    -   **SYN Flood:** Sending a high volume of TCP SYN requests (the first step of a handshake), which forces the server to keep connections open and eventually exhausts its resources.
-   **Distributed Denial of Service (DDoS):** A much more powerful attack where the flood of traffic comes from a **botnet**—a large number of compromised computers (zombies) controlled by the attacker.

### 5. Packet Sniffing

The act of intercepting and inspecting data packets as they travel across a network. This is equivalent to wiretapping. It is most effective on insecure networks (like open WiFi or old hub-based LANs) where data is broadcast. Tools like **Wireshark** are commonly used for packet sniffing.

### 6. Port Scanning

The process of systematically scanning a target host's ports to see which ones are open. This is a reconnaissance technique used by attackers to find vulnerable services to exploit. Tools like **Zenmap (Nmap)** are used for this purpose.

### 7. Social Engineering

The art of manipulating people to get them to divulge confidential information (like passwords) or perform actions that compromise security.

-   **Phishing:** The most common form of social engineering. It involves sending deceptive emails that appear to be from a legitimate source (e.g., a bank) to trick the recipient into clicking a malicious link or revealing sensitive information.

### 8. Man-in-the-Middle (MITM) Attack

An attack where the perpetrator secretly intercepts and relays communications between two parties who believe they are communicating directly with each other. This allows the attacker to eavesdrop on or alter the conversation. A common example is an **evil twin AP**, a fraudulent WiFi access point that mimics a legitimate one to intercept users' traffic.

### 9. Spam

Unsolicited commercial email. While often just an annoyance, spam is a primary delivery vehicle for phishing attacks and malware.

### 10. Poisoning

The act of injecting false information into a system's cache or table to redirect traffic or subvert security.

-   **ARP Poisoning (ARP Spoofing):** An attacker sends forged ARP messages onto a LAN to link their MAC address with the IP address of a legitimate device (like the default gateway router). This allows the attacker to intercept traffic intended for that device (an MITM attack).
-   **DNS Poisoning (DNS Spoofing):** An attacker corrupts a DNS server's cache, causing it to return an incorrect IP address for a domain, thereby redirecting users to a malicious website.

### 11. Zero-Day Attack

An attack that exploits a previously unknown vulnerability in a software application or operating system. Because the vendor is unaware of the flaw, no patch is available, making the attack highly effective until it is discovered and fixed.

---

## Answers to In-Chapter Exercises

### Exercise 11.1

1.  **Lesson 1: Password Length is Critical.** The time to crack a password increases exponentially with each character added. A 9-character password is exponentially harder to crack than a 7-character one.
2.  **Lesson 2: Character Complexity Matters.** Using a mix of uppercase letters, lowercase letters, numbers, and special characters dramatically increases the search space for a brute-force attack, making the password much stronger than one using only lowercase letters.

### Exercise 11.2

*This is a hands-on exercise.*
1.  **Web Proxy:** Using a web proxy would show that the websites you visit see the IP address of the proxy server, not your own. Pros: Anonymity, bypassing geo-restrictions. Cons: The proxy provider can see all your traffic; they can be slow and are often blocked.
2.  **Web VPN:** A VPN does the same thing but encrypts your traffic from your computer to the VPN server, making it much more secure than a simple web proxy.

### Exercise 11.3

*This is a hands-on exercise with Zenmap (Nmap).*
-   **Ping Scan (`-sP`):** This scan would reveal the IP and MAC addresses of all active devices on the local network (PCs, router, phones, etc.). It scans all possible IPs in the subnet (254 for a `/24`).
-   **TCP SYN Scan (`-sS`):** Scanning the router (`192.168.1.1`) would likely reveal open ports like 80 (HTTP for web management), 443 (HTTPS), and 53 (DNS).
-   **Intense Scan:** This would provide more detailed information, including the OS of the target device, the specific versions of the services running on the open ports, and possibly script-based vulnerability checks.

### Exercise 11.4

*This is a hands-on exercise taking a phishing quiz.* The key takeaways are learning to identify tell-tale signs of phishing, such as:
-   Spelling and grammar mistakes.
-   A sense of urgency or threats.
-   Mismatched links (hovering over a link shows a different URL than the text).
-   Suspicious sender email addresses that don't match the company's official domain.

### Exercise 11.5

1.  **Whitelisting vs. Blacklisting:**
    -   **Whitelisting:** (Allow only from approved list). Pros: Very secure, blocks all unknown senders. Cons: Inflexible, may block legitimate new senders, high management overhead.
    -   **Blacklisting:** (Block known spam senders). Pros: Flexible, allows emails from new senders. Cons: Ineffective against new or constantly changing spam sources.
2.  **Graylisting:** When an email arrives from an unknown sender/IP/recipient combination, the server temporarily rejects it with a "try again later" message. A legitimate mail server *will* try again, and when it does, the graylisting server accepts it and whitelists the combination. A simple spam bot often will *not* bother to retry, so the spam is blocked. It is effective but can cause delays in email delivery.

---

## Answers to End-of-Chapter Review Questions

1.  This is a **B. Trojan**, as it was hidden in a seemingly legitimate program and changed the system configuration.
2.  This is a **A. worm**, because it self-replicates and spreads via email.
3.  Flooding **C. SYN request** packets is a popular DoS attack.
4.  **D. port scanning** can be done remotely without planting any malware.
5.  This is a form of **C. spoofing** (IP spoofing).
6.  A NIC in promiscuous mode can perform **D. packet sniffing** better.
7.  DoS attacks compromise a system's **B. availability**.
8.  This is a **A. brute force attack**.
9.  The email is an example of **A. phishing**.
10. The evil twin AP is a form of **A. MITM attack**.
11. A **B. rogue AP** is a hazard an employee can create unintentionally.
12. Wireshark is a popular tool for **B. packet sniffing**.
13. **B. port scanning** is least relevant for stealing a password (it's for finding vulnerable services).
14. Phishing is a form of **A. social engineering**.
15. **E. fingerprinting** is a general term and not a specific threat to WiFi in the same way as the others.
16. The **C. dictionary attack** relies on a computer's powerful processing to try combinations of words.
17. A continuous stream of CTS frames would result in a **D. DOS attack**.
18. **A. An attacker sends “ARP replies” to a target computer...** correctly describes ARP poisoning.
19. **B. MAC spoofing is damaging because it shuts down WiFi NICs.** is INCORRECT. MAC spoofing is used for other attacks, like MAC flooding or bypassing filters; it doesn't shut down the NIC itself.
20. Setting up a rogue DHCP server is a type of **A. MITM** security threat.
# Chapter 12: Cybersecurity: Defenses

## Detailed Summary

This chapter shifts from threats to solutions, introducing the core technologies and principles used to defend networks and computer systems against cybersecurity attacks.

### 1. Security Requirements and Defense Principles

-   **Core Security Requirements:**
    -   **Confidentiality:** Preventing unauthorized disclosure of information (achieved with encryption).
    -   **Data Integrity:** Ensuring data is not altered or tampered with (achieved with hashing and digital signatures).
    -   **Authentication:** Verifying the identity of a user or system (achieved with passwords, digital certificates, biometrics).
    -   **Access Control/Authorization:** Granting or denying access to resources based on identity (achieved with firewalls, ACLs).
    -   **Availability:** Ensuring that systems and data are accessible to authorized users when needed.
-   **Principles for Architecting Defense:**
    -   **Layering (Defense-in-Depth):** Implementing multiple layers of security controls, so that if one layer fails, another can still provide protection.
    -   **Limiting (Principle of Least Privilege):** Granting users and systems only the minimum level of access and permissions necessary to perform their duties.
    -   **Simplicity:** Keeping security measures as simple and transparent as possible to reduce the chance of misconfiguration and make them easier to manage.

### 2. Firewall

A firewall is a network security device (hardware or software) that monitors and controls incoming and outgoing network traffic based on a set of security rules.

-   **Placement:** Can be a **border firewall** (protecting the entire network perimeter), an internal firewall (segmenting the network), or a **host-based firewall** (protecting a single computer).
-   **DMZ (Demilitarized Zone):** A special, isolated subnet created by a firewall to house public-facing servers (like web and email servers). This protects the internal production network by separating it from servers that are more exposed to attack.
-   **Filtering Methods:**
    -   **Stateless Filtering:** Examines each packet in isolation and makes a decision based on static rules (e.g., block all traffic from a specific IP). It's fast but not very sophisticated.
    -   **Stateful Filtering:** Tracks the state of active connections. It only allows incoming packets that are part of a previously established session initiated from inside the network, making it much more secure.

### 3. Access Control List (ACL)

An ACL is a set of rules, typically applied to a router's interface, that controls which packets are permitted or denied. ACLs perform stateless filtering based on:
-   Source and destination IP addresses.
-   Source and destination TCP/UDP port numbers.
-   Protocol type (e.g., TCP, UDP, ICMP).

### 4. Cryptography

Cryptography is the science of secure communication, transforming readable data (**plaintext**) into an unreadable format (**ciphertext**).

-   **Symmetric-Key Cryptography:** Uses a **single, shared secret key** for both encryption and decryption. It is very fast and efficient. Examples: **DES, 3DES, AES**.
-   **Asymmetric-Key (Public-Key) Cryptography:** Uses a **key pair**: a **public key** (shared with everyone) for encryption and a **private key** (kept secret) for decryption. It is slower but more secure for key exchange and authentication. Example: **RSA**.
-   **Hybrid Approach:** In practice, both are used together. Asymmetric encryption is used to securely exchange a temporary symmetric key (a **session key**), and then the fast symmetric encryption is used to protect the actual data for the duration of the session.
-   **Hashing:** A one-way function that takes an input and produces a fixed-size string of characters called a **hash value** or **message digest**. It is used to verify **data integrity**. Examples: **MD5, SHA-1**.

### 5. Digital Signature

A digital signature provides **authentication** (proof of sender's identity) and **integrity** (proof the message hasn't been altered).

-   **How it works:**
    1.  A hash of the original message is created.
    2.  The hash is encrypted with the sender's **private key**. This encrypted hash is the digital signature.
    3.  The receiver decrypts the signature with the sender's **public key** to get the original hash, and then computes their own hash of the message. If the two hashes match, the signature is valid.

### 6. Digital Certificate

A digital certificate is a digital ID card that binds a public key to a specific identity (a person or an organization).

-   **Function:** It is used to prove the authenticity of a public key, preventing man-in-the-middle attacks where an attacker might substitute their own public key.
-   **Certificate Authority (CA):** A trusted third party (like VeriSign) that issues and manages digital certificates through a system called a **Public Key Infrastructure (PKI)**. Web browsers have a pre-installed list of trusted CAs.
-   **Standard:** The most common format for digital certificates is **X.509**.

### 7. WiFi Security Standards

These protocols are designed to secure wireless networks.

-   **WEP (Wired Equivalent Privacy):** The original, now obsolete and highly insecure standard. It uses a weak, static shared key that is easily cracked.
-   **WPA (WiFi Protected Access):** An interim standard created to replace WEP. It introduced key improvements, most notably the **Temporal Key Integrity Protocol (TKIP)**, which dynamically changes the encryption key, making it much more secure than WEP.
-   **WPA2 (IEEE 802.11i):** The current, fully secure standard. It replaces TKIP with the much stronger **AES (Advanced Encryption Standard)** encryption algorithm.
-   **Operational Modes:**
    -   **Personal Mode (WPA2-PSK):** Uses a **pre-shared key** (a password/passphrase) for authentication. Ideal for home and small office networks.
    -   **Enterprise Mode:** Does not use a shared password. Instead, each user authenticates against a central **RADIUS server** with unique credentials, providing much stronger security for corporate environments.

---

## Answers to In-Chapter Exercises

### Exercise 12.1 (XYZ Company Firewall Rules)

*Here is a possible stateless rule set based on the requirements:*

| Rule Name         | Direction | Action | Protocol | Source IP      | Source Port | Destination IP | Destination Port |
| ----------------- | --------- | ------ | -------- | -------------- | ----------- | -------------- | ---------------- |
| Allow Remote 1    | Inbound   | Allow  | TCP      | *IP_of_Remote1*| 8724        | *Web_Server_IP*| 80               |
| Allow Remote 2    | Inbound   | Allow  | TCP      | *IP_of_Remote2*| 7323        | *Web_Server_IP*| 80               |
| Deny ICMP Out     | Outbound  | Deny   | ICMP     | Any            | Any         | Any            | Any              |
| Allow POP3 Out    | Outbound  | Allow  | TCP      | *Email_Server* | 110         | Any            | Any              |
| Allow SMTP In     | Inbound   | Allow  | TCP      | Any            | Any         | *Email_Server* | 25               |
| Allow SMTP Out    | Outbound  | Allow  | TCP      | *Email_Server* | Any         | Any            | 25               |
| **Default Deny**  | Inbound   | **Deny**   | Any      | Any            | Any         | Any            | Any              |
| **Default Allow** | Outbound  | **Allow**  | Any      | Any            | Any         | Any            | Any              |

*(Note: The final rules depend on the default policy. The above assumes a "default deny" for inbound and "default allow" for outbound, with specific exceptions).*

### Exercise 12.2

*This is a hands-on exercise using an online hash generator and cracker.*
-   **Expected Result:** You would find that short, simple, dictionary-word passwords (even their hash values) are cracked almost instantly. However, long, complex passwords that include a mix of uppercase, lowercase, numbers, and symbols will be reported as "Not found" by the online cracker, demonstrating that password complexity is highly effective at resisting hash-cracking attempts.

### Exercise 12.3

1.  **WEP vs. WPA/WPA2:** WEP uses a static, unchanging encryption key. WPA/WPA2 use a dynamic key that changes periodically (TKIP in WPA, AES in WPA2), making them much more secure.
2.  **Personal vs. Enterprise Mode:** Personal mode uses a single pre-shared key (password) for everyone. Enterprise mode uses a central RADIUS server to authenticate each user individually with unique credentials.
3.  **WPA2 vs. WPA:** WPA2 is more secure because it mandates the use of the stronger AES encryption algorithm, whereas WPA uses the older RC4 algorithm (via TKIP).
4.  **WEP's critical problem:** Its use of a short, static encryption key that is easily broken with readily available software tools.
5.  **Open Authentication:** The SSID and the client's MAC address.
6.  **RADIUS:** A centralized authentication server used in enterprise networks to verify user credentials.
7.  **PSK Derivation:** The PSK is derived from a user-provided **password or passphrase**.
8.  **Nodes configured with password:** The **access point** and all **client stations**.
9.  **Two key functions of WPA2:** **Authentication** (ensuring only authorized users can connect) and **Confidentiality/Privacy** (encrypting the wireless traffic).

---

## Answers to End-of-Chapter Review Questions

1.  **A. If source and destination sockets are in the connection table, then PASS the packet.** is a stateful firewall rule.
2.  An ACL does not typically examine **D. DNS** layer information.
3.  **D. authentication _____ digital signature** is correctly paired.
4.  **C. WPA’s encryption key in a WiFi network changes periodically.** is CORRECT.
5.  The PKI is maintained and operated by **B. certificate authorities**.
6.  A session key can be used to **B. encrypt the original message and digital signature**.
7.  **E. Asymmetric key encryption is slower than symmetric key encryption.** is ACCURATE.
8.  The verifier uses the **D. public key of the applicant** to decrypt the digital signature.
9.  PKI and X.509 are elements of **B. digital certificate** technology.
10. A digital certificate **B. validates the owner of a particular public key**.
11. A digital signature authenticates **A. both the message sender and message itself** (via integrity check).
12. **A. Wired equivalent privacy (WEP)** is a security standard for WiFi.
13. Improving host security is known as **C. host hardening**.
14. A digital signature is created by **E. encrypting the message digest with her own private key**.
15. **E. ACL** is a technology for access control, not authentication.
16. Cryptography can be a tool for **D. confidentiality, authentication, and integrity**.
17. **B. SMTP email and HTTP web servers are frequently placed in the DMZ.** is CORRECT.
18. Firewalls do NOT typically perform **E. provision of digital certificates**.
19. WPA's advantage is **C. Wireless NICs that support WEP can be upgraded to WPA, but not to WPA2** (via a firmware update, because both use RC4).
20. A digital certificate does NOT include the **A. Owner’s private key**.
# Chapter 1: Fundamental Concepts

## Detailed Summary

This chapter introduces the foundational concepts of computer networking and cybersecurity. It covers the essential building blocks of a network, how they communicate, their physical and logical arrangements, and the performance metrics used to evaluate them.

### 1. Key Network Elements

A computer network is a collection of hardware and software components that work together to exchange data.

-   **Host:** A data-producing entity connected to a network, such as a computer, smartphone, or server. Hosts can operate in two primary modes:
    -   **Client-Server Mode:** A dedicated server provides resources (files, web pages, etc.) to client hosts.
    -   **Peer-to-Peer (P2P) Mode:** Each host acts as both a client and a server, sharing resources directly with others.
    -   **Network Interface Card (NIC):** A circuit board that allows a host to connect to a network, converting data into signals for transmission.

-   **Intermediary Device:** Hardware that relays data between hosts without producing user data itself. Examples include switches, routers, hubs, and modems.
    -   **Intra-networking devices** (switches, hubs) operate *within* a single network segment (subnetwork).
    -   **Inter-networking devices** (routers) connect *different* network segments together.

-   **Network Link:** The physical connection (wired or wireless) between network nodes.
    -   **Access Link:** Connects a host to an intermediary device.
    -   **Trunk Link:** Interconnects intermediary devices (e.g., switch-to-router).

-   **Application:** Software that supports user tasks over a network (e.g., web browsers, email clients).

-   **Data/Message:** Information produced by applications, packaged into discrete units called **packets** for transport.

-   **Protocol:** A set of detailed communication rules (syntactic and semantic) that govern data exchange (e.g., HTTP, TCP).

### 2. Modes of Communication

-   **Data Distribution Methods:**
    -   **Unicasting:** One-to-one communication between a single source and a single destination.
    -   **Broadcasting:** One-to-all communication, where data is sent to every node on a network.
    -   **Multicasting:** One-to-many communication, where data is sent to a select group of destinations.

-   **Directionality:**
    -   **Simplex:** Data flows in only one direction (e.g., keyboard to computer).
    -   **Half-Duplex:** Data flows in both directions, but only one way at a time (e.g., walkie-talkie).
    -   **Full-Duplex:** Data flows in both directions simultaneously (e.g., telephone call).

### 3. Network Topologies

Network topology refers to the physical layout of network nodes and links.

-   **Point-to-Point:** A direct link between two nodes.
-   **Bus:** All nodes connect to a single common line. Prone to collisions.
-   **Ring:** Nodes are connected in a circular loop.
-   **Star (Hub-and-Spoke):** All nodes connect to a central intermediary device. Easy to manage but creates a single point of failure. This is the most common topology for modern LANs.
-   **Mesh:** Provides high reliability through redundant links. A **full mesh** connects every node to every other node, while a **partial mesh** has fewer links.
-   **Tree (Hierarchical):** Nodes are arranged in a hierarchical structure, effective for interconnecting many nodes efficiently.

### 4. Classification of Networks

-   **Personal Area Network (PAN):** Covers a very small area (a few meters), typically for connecting personal devices (e.g., Bluetooth, NFC).
-   **Local Area Network (LAN):** Covers a confined area like an office, building, or campus.
-   **Metropolitan Area Network (MAN):** Spans a city, interconnecting LANs.
-   **Wide Area Network (WAN):** Covers a large geographical area (state, country, or globally), interconnecting LANs and MANs. The Internet is the largest WAN.
-   **Internet of Things (IoT):** A paradigm where everyday devices (cars, appliances) connect and communicate automatically over networks.

### 5. Subnetwork vs. Inter-network

-   **Subnetwork (Subnet):** A single network segment, typically connected by intra-networking devices like switches. Communication *within* a subnet is **intra-networking**.
-   **Inter-network:** A network composed of multiple subnetworks joined by routers. Communication *across* subnets is **inter-networking**.

### 6. Measures of Network Performance

-   **Capacity (Speed):** Measured in bits per second (bps).
    -   **Channel Capacity (Bandwidth):** The theoretical maximum data rate of a link.
    -   **Throughput:** The actual, measured data rate, which is often lower than the channel capacity.
-   **Delay (Latency):** The time it takes for data to travel between two points, measured in milliseconds (ms). Sources of delay include propagation time, processing at hosts, and queuing at intermediary devices.
-   **Reliability:** The network's ability to deliver data without corruption or loss.
-   **Quality of Service (QoS):** A network's capability to guarantee a certain level of performance (capacity, latency, reliability), which is crucial for real-time applications like video streaming.

### 7. Numbering Systems

-   **Binary (Base-2):** Uses 0s and 1s, the native language of computers.
-   **Decimal (Base-10):** The standard numbering system used by humans.
-   **Hexadecimal (Base-16):** Uses digits 0-9 and letters A-F. More compact than binary for representing large numbers and commonly used for MAC addresses.

### 8. Network Addressing

-   **MAC (Media Access Control) Address:** A unique, permanent 48-bit hardware address burned into a device's NIC. It is used for **intra-networking** (communication within a subnet).
-   **IP (Internet Protocol) Address:** A logical 32-bit (for IPv4) or 128-bit (for IPv6) address assigned to a network node. It is used for **inter-networking** (communication across subnets).
-   **Pairing:** For a host to communicate on a network, it needs both a MAC address and an IP address.

---

## Answers to In-Chapter Exercises

### Exercise 1.1

1.  **Client-Server Advantages over P2P:**
    *   **a. Easier to protect server resources:** Centralized data storage on a dedicated server makes it easier to implement robust security, access control, and monitoring.
    *   **b. Better accessibility to server resources:** A high-performance, always-on server ensures that resources are consistently available to all clients.
    *   **c. Easier to back up server resources:** Backing up a single, centralized server is simpler and more reliable than backing up data scattered across multiple peer machines.
    *   **d. More cost-effective in maintaining and upgrading:** Software updates and maintenance can be performed on one server instead of on every peer machine, saving time and effort.
    -   **e. Easier to add server resources:** Scaling is more straightforward; resources like storage or processing power can be added to the central server to meet growing demand.

2.  **P2P File Swapping:** This exercise requires a hands-on setup. The general steps on Windows would be:
    1.  Ensure both computers are on the same WiFi network.
    2.  Go to `Control Panel > Network and Sharing Center > Change advanced sharing settings`.
    3.  Turn on network discovery and file and printer sharing for the private network profile.
    4.  Create a shared folder on one computer by right-clicking it, selecting `Properties > Sharing > Advanced Sharing`, and setting permissions.
    5.  From the second computer, open File Explorer and navigate to the `Network` tab to find the first computer and access its shared folder to swap files.

### Exercise 1.2

1.  **Hosts per LAN:**
    -   Main Office LAN: 4 hosts (PC3, PC4, Server, IP Phone)
    -   Branch 1 LAN: 2 hosts (PC1, PC2)
    -   Branch 2 LAN: 1 host (Laptop)

2.  **Intermediary Devices per LAN:**
    -   Main Office LAN: 2 devices (S2, S3)
    -   Branch 1 LAN: 1 device (S1)
    -   Branch 2 LAN: 1 device (Wireless Access Point)

3.  **Access and Trunk Links per LAN:**
    -   Main Office LAN: 4 access links, 1 trunk link (between S2 and S3).
    -   Branch 1 LAN: 2 access links, 0 trunk links.
    -   Branch 2 LAN: 1 access link (wireless), 0 trunk links.

4.  **Total Access and Trunk Links:**
    -   Total Access Links: 4 + 2 + 1 = 7
    -   Total Trunk Links (including LAN and WAN): 1 (in Main Office) + 3 (WAN links) = 4 trunk links.

5.  **Total Network Nodes:** 7 hosts + 4 LAN intermediary devices + 3 routers = 14 network nodes.

6.  **Intra-networking Devices:**
    -   Main Office LAN: S2, S3
    -   Branch 1 LAN: S1
    -   Branch 2 LAN: Wireless Access Point

7.  **Inter-networking Device:** The Routers (R1, R2, R3) are used for inter-networking.

### Exercise 1.3

1.  **PAN, LAN, MAN, WAN in the IoT Scenario:**
    -   **PAN (Personal Area Network):** Laura's Apple Watch communicating with her phone, her son's health wrist device connecting to a local monitor, or her watch connecting to the shopping cart display. These are all short-range, personal-device communications.
    -   **LAN (Local Area Network):** Her car's internal network connecting various sensors (brake pads, tire pressure). The home network that synchronizes her watch and computer data with the central server is also a LAN.
    -   **MAN (Metropolitan Area Network):** Her car communicating with the city's traffic management system to get real-time accident updates. The airport's customer support system communicating with her watch as she enters could also be part of a MAN.
    -   **WAN (Wide Area Network):** Her car transmitting data to the maintenance shop, checking the Xbox delivery status with the postal office database, and connecting to her home network while she's away. These are all long-distance communications that traverse the Internet (a WAN).

2.  **New and Obsolete Business Models:**
    -   **New Business Models:**
        -   **Predictive Vehicle Maintenance:** Cars automatically reporting issues to service shops, enabling proactive repairs and subscription-based maintenance services.
        -   **Automated Grocery Replenishment:** A subscription service where the grocery store's system links to a customer's home network to auto-detect low inventory and deliver items.
        -   **Personalized Health Monitoring Services:** Family doctors offering remote, real-time diagnosis and monitoring services via wearable health devices.
        -   **Smart Shopping Assistants:** In-store systems that offer personalized routing, discounts, and product information based on a customer's shopping list and location.
    -   **Obsolete/Less Relevant Business Models:**
        -   **Traditional Auto Repair Shops:** The "break-fix" model may become less relevant as predictive maintenance becomes standard.
        -   **Physical Media/Game Stores:** The instant tracking and delivery information for the Xbox suggests a highly efficient e-commerce system, making physical stores less necessary.
        -   **Manual Billing for Rentals:** The rental car's automated billing system would make manual invoicing and payment processing obsolete.

### Exercise 1.4

1.  **Referring to Figure 1.6:**
    *   **a. How many subnetworks are there in each LAN?** Each LAN is a single subnetwork. Message delivery within each LAN does not require a router.
    *   **b. Is this inter-networking? (PC1 to printer in LAN1):** No, this is **intra-networking** because the communication occurs within the same subnetwork (LAN1).
    *   **c. Is this inter-networking? (PC1 in LAN1 to server in LAN3):** Yes, this is **inter-networking** because the communication crosses multiple subnetworks (LAN1, WAN link, LAN3) and requires routers.
    *   **d. Is this inter-networking? (PC1 to IP Phone in LAN1):** No, this is **intra-networking**.
    *   **e. Is this inter-networking? (PC2 in LAN3 to server in LAN3):** This is a typo in the question, assuming PC2 is in LAN1. If PC2 (in LAN1) communicates with the server (in LAN3), it is **inter-networking**. If it's a PC within LAN3 communicating with the server in LAN3, it is **intra-networking**.

2.  **Referring to Figure 1.22:**
    *   **a. How many LANs are there?** There is one LAN.
    *   **b. How many subnetworks are there?** There are **three** subnetworks, as each of the three switches connects to a different port on the border router.
    *   **c. Is this inter-networking? (PC1 to email server):** Yes, this is **inter-networking**. PC1 is on the subnet connected to the top switch, while the email server is on the subnet connected to the bottom switch. The communication must go through the router.
    *   **d. Is this inter-networking? (PC1 to file server):** No, this is **intra-networking**. Both PC1 and the file server are connected to the same switch and are therefore in the same subnetwork.
    *   **e. What is the intermediary device used for intra-networking?** Switches.

### Exercise 1.5

-   A digitized telephone call requires 8 Kbps in each direction, for a total of **16 Kbps** for a full-duplex call.
-   An HDTV channel requires **15 Mbps**, which is 15,000 Kbps.
-   Number of concurrent calls = 15,000 Kbps / 16 Kbps per call = **937.5**.
-   Therefore, you can make **937** concurrent telephone calls with the data rate required for just one HDTV channel.

### Exercise 1.6

1.  **Decimal to 8-bit Binary Conversion:**
    -   38 = **00100110**
    -   110 = **01101110**
    -   192 = **11000000**
    -   255 = **11111111**

2.  **8-bit Binary to Decimal Conversion:**
    -   01100001 = **97**
    -   11110110 = **246**
    -   11100011 = **227**
    -   10100010 = **162**

### Exercise 1.7

1.  **0x17AB to Binary:**
    -   1 = 0001, 7 = 0111, A = 1010, B = 1011
    -   Result: **0001011110101011**

2.  **Hex to Binary:**
    -   0xABCDEF = **101010111100110111101111**
    -   0x34A57 = **00110100101001010111**
    -   0x12DF01 = **000100101101111100000001**
    -   0x78ADC = **01111000101011011100**

3.  **Binary to Hex:**
    -   "10110110100011100001" -> 1011 0110 1000 1110 0001
    -   Result: **0xB68E1**

4.  **NIC Physical Address to Hex:**
    -   `001001100111100010101011010111000100100010001101` (This appears to be 52 bits, but a MAC address is 48. I will use the first 48 bits).
    -   `00100110 01111000 10101011 01011100 01001000 10001101`
    -   26 78 AB 5C 48 8D
    -   Result: **26-78-AB-5C-48-8D**

### Exercise 1.8

-   **OUIs of Tech Companies (example search results):**
    -   **Cisco:** 00-00-0C, 00-01-42, 00-01-63, etc. (They own many)
    -   **Apple:** 00-03-93, 00-0A-95, 00-16-CB, etc.
    -   **Intel:** 00-02-B3, 00-04-23, 00-07-E9, etc.
    -   **Microsoft:** 00-0D-3A, 00-12-5A, 00-15-5D, etc.
    -   Companies own many OUIs to account for the vast number of network devices they manufacture.

### Exercise 1.9

1.  **Smartphone MAC/IP:** This requires checking the phone's settings (`Settings > About Phone > Status`). A phone will have a WiFi MAC address and potentially a Bluetooth MAC address.

2.  **IMEI (International Mobile Equipment Identifier):**
    -   **What it is:** A unique 15-digit number that identifies a specific mobile device on a cellular network. It is different from a MAC address (which is for LANs like WiFi/Bluetooth) and an IP address (which is for network connections).
    -   **How it's different:** IMEI is tied to the cellular radio hardware. A phone has one IMEI but can have multiple MAC addresses.
    -   **What you can do with it:** If your phone is stolen, you can report the IMEI to your cellular carrier. They can blacklist the device, preventing it from being used on their network (and often partner networks), effectively making it a brick.

3.  **Computer MAC/IP Addresses from `ipconfig /all` on Figure 1.24:**
    *   **a. Current IP address:** 192.128.1.2
    *   **b. How many NICs and MAC addresses:** Two NICs are shown (Ethernet and Wireless LAN), so there are two MAC addresses.
    *   **c. Their MAC addresses:**
        -   Ethernet: `00-1A-92-A7-87-95`
        -   Wireless LAN: `00-1E-E5-91-B7-89`
        -   There is more than one MAC address because the computer has separate hardware for connecting to wired (Ethernet) and wireless (WiFi) networks.
    *   **d. Manufacturers of the NICs:**
        -   Ethernet (OUI: 00-1A-92): Intel Corporate
        -   Wireless LAN (OUI: 00-1E-E5): Azurewave Technologies, Inc.
    *   **e. WiFi MAC bound to IP 192.128.1.2:** This means the computer is currently connected to the network using its wireless adapter, and that specific wireless connection has been assigned the IP address 192.128.1.2. The Ethernet adapter is shown as "Media disconnected," so it is not in use.

---

## Answers to End-of-Chapter Review Questions

1.  The **C. network topology** represents the layout of network nodes and links.
2.  **E. Network nodes include intermediary devices and hosts.**
3.  **B. partial mesh** topology is used widely when network redundancy is important.
4.  Star topology is also known as **E. hub-and-spoke**.
5.  A **D. web server–switch link** is an access link.
6.  The organizationally unique identifier (OUI) is an element of **A. MAC addresses**.
7.  The throughput of a network **E. represents its actual speed**.
8.  Messages are produced and exchanged according to rules implemented in **A. protocols**.
9.  **C. Creating a computer network needs to have at least one trunk link.** (A small network with one switch doesn't need a trunk link).
10. The campus network is a type of **A. local area network**.
11. The binary correspondence of hex digits “B301” is **B. 1011001100000001**.
12. **E. A host station should have an MAC and an IP address for networking.**
13. **A. It is a permanent address.** is TRUE regarding the MAC address.
14. **D. channel capacity, bandwidth, rated speed** are used interchangeably.
15. When nearby devices exchange data, a **B. PAN (personal area network)** standard is used.
16. **A. ab-01-cd-ef-23-45** is a legitimate MAC address (12 hex digits).
17. Switches within a network are interconnected by **C. trunk links**.
18. Network nodes include **B. intermediary devices and end stations**.
19. **C. It always operates in the full-duplex mode.** is NOT NECESSARILY an accurate description (e.g., a switch port connected to a hub would be half-duplex).
20. The right sequence of data rate metrics is **D. Kbps—Mbps—Gbps—Tbps—Pbps**.
21. Audio or video streaming services generally rely on the **C. multicasting** technology.
22. The three main sources of network latency include **B. propagation delay, delay at hosts, and delay at intermediary devices**.
23. The primary dimensions of network performance include **D. delay, capacity, and reliability**.
24. The message is produced by the web browser according to the **C. syntactic rule** of the HTTP protocol.
25. **D. Star: All locations connect to a central site, and thus the network is susceptible to a single point of failure.** correctly describes a network topology.
# Chapter 2: Architectures and Standards

## Detailed Summary

This chapter delves into the abstract but fundamental concepts of network architecture, layers, standards, and protocols. It explains how these elements work together in a structured framework to enable communication between network nodes.

### 1. Network Architectures: TCP/IP vs. OSI

A standard network architecture is a layered framework (or reference model) that defines the functions required for network communication.

-   **TCP/IP Model:** The dominant architecture of the Internet, managed by the IETF. It originally defined four layers: Application, Transport, Internet, and Network Access.
-   **OSI Model:** A seven-layer model from the ISO. It is more granular than TCP/IP, separating the Application layer into Application, Presentation, and Session, and the Network Access layer into Data Link and Physical.
-   **Hybrid 5-Layer Model:** In practice, a five-layer hybrid model is widely used, combining the strengths of both. This is the model used for explanation throughout the book:
    1.  **Application Layer (Layer 5):** Handles application-to-application communication (e.g., browser-to-server).
    2.  **Transport Layer (Layer 4):** Provides end-to-end (host-to-host) connectivity and reliability.
    3.  **Internet Layer (Layer 3):** Manages inter-networking (routing packets across different subnetworks).
    4.  **Data Link Layer (Layer 2):** Handles intra-networking (moving frames within a single subnetwork).
    5.  **Physical Layer (Layer 1):** Transports the raw bits as signals over the physical medium.

### 2. Protocol Data Units (PDUs) and Encapsulation

Each layer (except the Physical Layer) produces a discrete message unit called a **Protocol Data Unit (PDU)**. As data moves down the layers on the sending host, it undergoes **encapsulation**, where each layer adds its own header (and sometimes a trailer) to the PDU from the layer above.

-   **Application Layer PDU (APDU):** The original data from the application (e.g., an HTTP request). It has no special name.
-   **Transport Layer PDU:**
    -   **Segment (TCP):** Created when a TCP header is added to the APDU.
    -   **Datagram (UDP):** Created when a UDP header is added.
-   **Internet Layer PDU:**
    -   **Packet:** Created when an IP header is added to the segment or datagram. The primary goal of networking is the successful delivery of IP packets.
-   **Data Link Layer PDU:**
    -   **Frame:** Created when a Data Link header and trailer are added to the packet. This is the final PDU before being converted to signals.

The receiving host performs **de-encapsulation**, a reverse process where headers and trailers are stripped away at each layer as the data moves up toward the application.

### 3. Layer Functions

-   **Application Layer (Layer 5):** Client and server programs exchange data using specific protocols like HTTP (web), SMTP (email), FTP (file transfer), DNS, and DHCP.

-   **Transport Layer (Layer 4):** Establishes a logical end-to-end connection between hosts. Its two main protocols are TCP and UDP.
    -   **TCP (Transmission Control Protocol):** A **reliable**, **connection-oriented** protocol.
        -   **Reliability:** Uses **error control** (acknowledgments to ensure data arrives correctly) and **flow control** (managing transmission speed).
        -   **Connection-Oriented:** Establishes a formal session via a **three-way handshake** (SYN, SYN-ACK, ACK) before data is exchanged.
    -   **UDP (User Datagram Protocol):** An **unreliable**, **connectionless** protocol.
        -   It does not perform error/flow control or establish a session. This makes it fast and efficient, ideal for real-time applications like video streaming or VoIP where speed is more critical than perfect reliability.
    -   **Port Management:** Both TCP and UDP use 16-bit port numbers to identify the specific application a message is intended for (e.g., port 80 for HTTP). A **socket** is the combination of an IP address and a port number (e.g., `30.30.30.1:80`).

-   **Internet Layer (Layer 3):** Responsible for **inter-networking**—routing IP packets across different subnetworks.
    -   **Packet Creation:** Creates IPv4 or IPv6 packets, adding a header with source/destination IP addresses and other control information like Time To Live (TTL).
    -   **Routing Decisions:** Routers at this layer make decisions on the best path to forward a packet toward its final destination.
    -   **ICMP (Internet Control Message Protocol):** A supervisory protocol at this layer used for diagnostics, like `ping` (to test connectivity) and `traceroute` (to map the path a packet takes).

-   **Data Link Layer (Layer 2):** Responsible for **intra-networking**—transporting frames within a single subnetwork using MAC addresses.
    -   **Frame Creation:** Encapsulates IP packets into frames (e.g., Ethernet frames).
    -   **Switching:** Switches operate at this layer, using destination MAC addresses to forward frames to the correct host within a LAN.
    -   A **data link** is a single path between two nodes within a subnetwork. When a packet crosses multiple routers to reach its destination, it travels over multiple distinct data links.

-   **Physical Layer (Layer 1):** Responsible for converting the binary bits of a frame into signals (electrical, light, or radio) and transmitting them over the physical medium (e.g., copper cable, fiber optics, air).

### 4. Layer Implementation in a Host

-   **Application Layer:** Implemented in user applications (e.g., web browser, email client).
-   **Transport & Internet Layers:** Implemented within the computer's operating system (e.g., the TCP/IP stack in Windows).
-   **Data Link & Physical Layers:** Implemented in the hardware of the Network Interface Card (NIC).

---

## Answers to In-Chapter Exercises

### Exercise 2.1

*This exercise requires using an HTTP viewer tool. The answers below are examples based on a typical request to a standard website.*

1.  **Request Header Information:** Items include the `Host` (the website being requested), `User-Agent` (the browser and OS), `Accept` (the types of content the browser can handle), `Accept-Language`, `Accept-Encoding`, and `Connection` type.
2.  **Server Response:**
    *   **a.** The response message is divided into two parts: **Header** and **Content (or Data/Body)**.
    *   **b.** The value `200` means **"OK"**, indicating the request was successful.
    *   **c.** This depends on the server, but a common version is **HTTP/1.1**.
    *   **d.** The web server program could be **Apache**, **nginx**, or **Microsoft-IIS**.
    *   **e.** The operating system could be **Unix**, **Linux**, or **Windows**.
    *   **f.** The total size is found in the `Content-Length` header (for the content) plus the size of the header itself.
    *   **g.** The message header size varies but is typically a few hundred bytes.
    *   **h.** The content size is specified by the **`Content-Length`** header.
    *   **i.** The content type is specified by the **`Content-Type`** header (e.g., `text/html`, `image/jpeg`).

### Exercise 2.2

1.  **Trying http://11.22.33.44 and http://11.22.33.44:80:** Both URLs should load the same webpage. This is because port 80 is the default port for HTTP. When you type a URL without a port, the browser automatically connects to port 80. Explicitly adding `:80` does the same thing.
2.  **Trying http://11.22.33.44:70:** This will likely result in a "This site can’t be reached" or "Connection refused" error. This is because web servers are configured to listen for HTTP requests on port 80, not port 70 (or other random ports). The server is not running any service on that port to accept the connection.

### Exercise 2.3

*Based on the screenshot in Figure 2.10:*

1.  **Analysis of TCP Sessions:**
    *   **a. How many different sessions?** There are **seven** sessions listed (seven lines with `ESTABLISHED`).
    *   **b. How many different source sockets?** There are **seven** unique source sockets (the combination of `130.191.8.211` and a unique ephemeral port like `1341`, `1342`, etc.).
    *   **c. Port range for source sockets:** The ports range from **1341 to 1347**.
    *   **d. How many different destination sockets?** There is only **one** destination socket: `130.191.8.198:80`.
    *   **e. Server port used:** Port **80** (the standard HTTP port).
    *   **f. Server name of 130.191.8.198:** Using `nslookup 130.191.8.198` would likely resolve to a hostname associated with San Diego State University, such as `www.sdsu.edu`, based on the context of the book.

2.  **Observing `netstat -n`:** Running this command after visiting a website will show multiple TCP connections being established from your local IP (with various high-numbered ephemeral ports) to the website's server IP on port 80 (for HTTP) or 443 (for HTTPS). Each connection corresponds to a different resource (HTML file, images, scripts) being downloaded to render the page.

### Exercise 2.4

1.  **Whois Search for IPs in Figure 2.14:** This requires a live search on `arin.net`. The IPs would likely trace back through a local ISP (like Cox, Comcast), then to a larger network backbone provider (like Level 3, Cogent), and finally to the ISP hosting Yahoo's servers. The last IP, `209.131.36.158`, belongs to Yahoo.

2.  **Ping vs. Tracert Delays:** Pinging the first three routers should show round-trip times very similar to the times reported by `tracert` for those same hops, as both tools measure latency. `tracert` simply does this for every hop along the path.

### Exercise 2.5

*Referring to Figure 2.15:*

1.  **Data links from Laptop1:** There are **three** possible data links: to PC4, to Server1, and to the router R3's LAN port (Fa0/1).
2.  **Data links from PC4:** There are **three** possible data links: to Laptop1, to Server1, and to the router R3's LAN port (Fa0/1).
3.  **Data links from Laptop1 involving >1 device:** The links from Laptop1 to Server1 and to R3(Fa0/1) both involve two intermediary devices (the Wireless AP and SW3).
4.  **Data links from PC4 involving >1 device:** None. The links from PC4 to Laptop1, Server1, and R3(Fa0/1) all go through only one device, SW3.
5.  **Frame from Server1 to R3(Fa0/1):**
    -   Source MAC: Server1's MAC (`00-11-22-A4-B4-C4`)
    -   Destination MAC: R3(Fa0/1)'s MAC (`00-11-22-A5-B5-C5`)
    -   No, the addresses do not change while passing through SW3.
6.  **Frame from Laptop1 to R3(Fa0/1):**
    -   Source MAC: Laptop1's MAC (`00-11-22-A2-B2-C2`)
    -   Destination MAC: R3(Fa0/1)'s MAC (`00-11-22-A5-B5-C5`)
    -   No, the MAC addresses do not change. The AP and switch are layer 2 devices that forward the frame without altering the source/destination MACs.

### Exercise 2.6

*Referring to Figure 2.17:*

1.  **Data links from IP Phone:** There are **five** possible data links: to PC1, PC2, Laptop1, Server1, and R1's port connecting to R2.
2.  **Data links from PC1:** There are **five** possible data links: to IP Phone, PC2, Laptop1, Server1, and R1's port connecting to R2.
3.  **Data links from IP Phone >1 device:** The links to PC2, Laptop1, and Server1 all involve multiple intermediary devices (switches and routers).
4.  **Data links from PC1 >1 device:** The links to PC2, Laptop1, and Server1 all involve multiple intermediary devices.
5.  **IP Phone to Laptop1 (via R1 and R3):** There are **three** data links: (1) IP Phone to R1, (2) R1 to R3, and (3) R3 to Laptop1.
6.  **Laptop1 to PC2 (via R3-R1-R2):** There are **four** data links: (1) Laptop1 to R3, (2) R3 to R1, (3) R1 to R2, and (4) R2 to PC2.
7.  **IP packet from PC1 to Server1:**
    -   Initial Frame (on LAN1): Source MAC = PC1's MAC, Destination MAC = R1's MAC.
    -   Last Frame (on LAN3): Source MAC = R3's MAC, Destination MAC = Server1's MAC.
    -   Yes, the data link addresses (MACs) change at every router hop.
8.  **IP packet from PC1 to Server1 (via R1 and R3):** **Three** different frames are formed, one for each data link (PC1->R1, R1->R3, R3->Server1).
9.  This question is ambiguously phrased. The IP packet never has a MAC address. The *final frame* that delivers the IP packet to Server1 will have Source MAC = R3's MAC and Destination MAC = Server1's MAC.
10. **IP packet from PC1 to Laptop1 (via R1 and R3):** **Three** different frames are formed. The final frame that goes from R3 to Laptop1 will be a WiFi frame, while the others will be Ethernet/WAN frames.

### Exercise 2.7

*Referring to Figure 2.17:*

1.  **LANs and WAN connections:** There are 3 LANs and 3 WAN connections.
2.  **Physical links between PC1 and Server1 (via R1, R3):**
    -   PC1 -> S1
    -   S1 -> R1
    -   R1 -> R3 (WAN link)
    -   R3 -> S3
    -   S3 -> Server1
    -   Total: **5 physical links**.
3.  **Physical links between Laptop1 and PC2 (via R3-R1-R2):**
    -   Laptop1 -> WAP
    -   WAP -> S3
    -   S3 -> R3
    -   R3 -> R1 (WAN link)
    -   R1 -> R2 (WAN link)
    -   R2 -> S2
    -   S2 -> PC2
    -   Total: **7 physical links**.
4.  **Signaling features between SW1-Hub link and R1-R2 link:** No, they will not be identical. The SW1-Hub link is a LAN link (likely Ethernet using digital signaling over a copper cable), whereas the R1-R2 link is a WAN link (e.g., a leased line using a different signaling scheme, possibly over fiber). They are different Layer 1 technologies.

---

## Answers to End-of-Chapter Review Questions

1.  The standard **B. architecture** broadly depicts necessary functions of computer networking in a layer structure.
2.  All layers have their own PDU, except the **E. physical** layer.
3.  An email message goes through encapsulations in the sequence of **A. segment–packet–frame**.
4.  **B. Transport and internet layers** are generally built into an operating system.
5.  The socket is **C. the combination of an IP address and a port number**.
6.  **D. TCP is a reliable protocol.**
7.  The TCP port is used to **B. forward a service request/response to a specific application**.
8.  The **C. SYN** bit in the TCP header is used to request handshaking.
9.  **A. Application layer—to establish sessions (or handshaking)** is NOT accurate (this is the Transport layer's job).
10. **C. Physical layer and data link layer** functions are implemented in the NIC.
11. **E. Three-way video conferencing over the Internet** most likely depends on UDP.
12. Port numbers have to be included in the header of **D. segments and datagrams**.
13. **E. Burden on the network: High (TCP) vs. Low (UDP)** is CORRECT. TCP requires acknowledgments, adding traffic.
14. The TTL value indicates the maximum number of **B. routers** a packet can go through.
15. `netstat -n` can be issued to **B. list sockets in TCP sessions**.
16. **C. The semantics of a protocol is about how to interpret PDUs exchanged.** is the CORRECT statement.
17. **B. 1** packet is produced. The packet itself is not changed, only the frame that carries it is rebuilt at each hop.
18. The IP packet is encapsulated within the **D. frame** to travel to the destination node *within a subnetwork*.
19. If a host develops a TCP segment with source port 80, it is most likely a **C. web server** (responding to a client request).
20. **D. Well-known port numbers are generally assigned to server applications.** is CORRECT.
21. The two hosts communicate based on **A. ICMP (Internet Control Message Protocol)**.
22. End-to-end error control and flow control are performed in the **C. transport** layer.
23. **E. DHCP = internet layer** is a mismatch (DHCP is an Application layer protocol).
24. **D. Frame** generally has a header and a trailer.
25. `tracert` uses **C. DNS and ICMP**. It first uses DNS to resolve the hostname (www.gmail.com) to an IP address, then uses ICMP to trace the route.
# Chapter 3: Intermediary Devices

## Detailed Summary

This chapter provides an in-depth look at the general-purpose intermediary devices that form the backbone of a network. It focuses on hubs, bridges, switches, and routers, explaining their functions, operational layers, and key differences.

### 1. Intermediary Devices and Operational Layers

Intermediary devices facilitate communication between end stations and operate at different layers of the hybrid 5-layer model.

-   **Hubs (Layer 1 - Physical):** Simple devices that regenerate and broadcast incoming signals to all connected ports.
-   **Switches, Bridges, Wireless APs (Layer 2 - Data Link):** Make forwarding decisions based on MAC addresses to move frames *within* a single network (intra-networking).
-   **Routers, Layer 3 Switches (Layer 3 - Internet):** Make routing decisions based on IP addresses to move packets *between* different networks (inter-networking).

These devices perform encapsulation and de-encapsulation as data passes through them. A router, for instance, will de-encapsulate a frame to inspect the IP packet, make a routing decision, and then re-encapsulate the packet into a new frame for the next data link.

### 2. Hub (Multiport Repeater)

-   **Function:** A Layer 1 device that receives a signal on one port and regenerates and broadcasts it out to all other ports.
-   **Operation:** Creates a **shared media** environment where all connected hosts are in the same **collision domain**. This means only one device can transmit at a time, otherwise, a collision occurs.
-   **Mode:** Operates in **half-duplex**.
-   **Security:** Insecure, as all traffic is broadcast, making it easy to eavesdrop with a packet sniffer.
-   **Modern Usage:** Largely obsolete and replaced by switches due to inefficiency and security risks.

### 3. Bridge and Wireless Access Point (AP)

-   **Function:** A Layer 2 device that divides a network into smaller segments to reduce traffic and collisions. It forwards or filters frames based on their destination MAC address, which it stores in a **bridge table**.
-   **Types:**
    -   **Transparent Bridge:** Connects two segments using the *same* standard (e.g., Ethernet to Ethernet).
    -   **Translational Bridge:** Connects two segments using *different* standards (e.g., Ethernet to WiFi), performing frame conversion. A **Wireless Access Point (AP)** is the most common example of a translational bridge.

### 4. Switch

The switch is the most popular intermediary device for modern wired LANs.

-   **Function:** An intelligent Layer 2 device that forwards frames only to the specific port connected to the destination host.
-   **Operation:** Each port on a switch creates a separate **collision domain**, eliminating frame collisions. It uses a **switch table** (also called a MAC address table) to map MAC addresses to specific ports.
    -   **Switch Learning:** The switch automatically builds its table by inspecting the source MAC address of incoming frames.
    -   **Aging:** Entries in the table are automatically removed after a certain period of inactivity.
-   **Mode:** Operates in **full-duplex**, allowing simultaneous two-way communication.
-   **Types:**
    -   **Managed vs. Non-managed:** Managed switches have an operating system (OS) and can be configured with advanced features (VLANs, security), while non-managed switches are simple plug-and-play devices.
    -   **Store-and-Forward vs. Cut-Through:** Store-and-forward switching waits for the entire frame to arrive before forwarding (allowing for error checking), while cut-through switching starts forwarding as soon as the destination MAC is read (faster but no error check).
    -   **Layer 2 vs. Layer 3:** A Layer 3 switch combines the functions of a switch and a router, capable of performing IP-based routing in hardware, making it faster than a traditional router for inter-VLAN routing.

### 5. Router

-   **Function:** A Layer 3 device that performs **inter-networking**, forwarding IP packets between different subnets.
-   **Operation:** Uses a **routing table** to determine the best path to forward a packet. Unlike switches, routers do not forward broadcast messages by default, thereby creating separate **broadcast domains**.
-   **Components:** A specialized computer with a CPU, memory (RAM, ROM, flash), OS (e.g., Cisco IOS), and various ports (LAN and WAN).
-   **Ports:** Each router port connects to a different subnet and must have its own unique IP address. LAN ports have both IP and MAC addresses; WAN ports typically only need an IP address.

### 6. Switching vs. Routing

| Feature               | Switching (Layer 2)                           | Routing (Layer 3)                                    |
| --------------------- | --------------------------------------------- | ---------------------------------------------------- |
| **PDU**               | Frame                                         | Packet                                               |
| **Address Used**      | MAC Address                                   | IP Address                                           |
| **Scope**             | Intra-networking (within a single subnet)     | Inter-networking (between different subnets)         |
| **Path Determination**| Connection-Oriented (single active path)      | Connectionless (dynamic path decision at each hop)   |
| **Broadcasts**        | Forwards broadcasts by default                | Blocks broadcasts by default                         |
| **Device**            | Switch                                        | Router                                               |

### 7. Address Resolution Protocol (ARP)

-   **Function:** A protocol used by a network node to discover the MAC address associated with a specific IP address on the local network.
-   **Process:** When a host needs to send a frame to an IP address on its subnet but doesn't know the MAC address, it broadcasts an **ARP request** ("Who has this IP address?"). The device with that IP sends back an **ARP reply** containing its MAC address.
-   **ARP Cache:** The host stores the IP-to-MAC mapping in its ARP table (or cache) for future use.

### 8. Collision and Broadcast Domains

-   **Collision Domain:** A network segment where data transmissions can collide. **Switches break up collision domains** (each switch port is a separate domain). Hubs create a single, large collision domain.
-   **Broadcast Domain:** A network segment where a broadcast frame will be propagated. **Routers break up broadcast domains**. By default, an entire switched network is a single broadcast domain, but this can be segmented using VLANs.

---

## Answers to In-Chapter Exercises

### Exercise 3.1

1.  **Router De-encapsulation/Encapsulation (Ethernet to Ethernet):**
    1.  An Ethernet frame arrives at the router's first LAN port.
    2.  The router de-encapsulates the frame, removing the Ethernet header and trailer to expose the IP packet.
    3.  The router's Internet layer processes the IP packet: it reads the destination IP, consults its routing table to find the exit port, and decrements the TTL.
    4.  The router's Data Link layer re-encapsulates the IP packet into a *new* Ethernet frame, with the router's exit port MAC as the source and the next-hop device's MAC as the destination.
    5.  The new frame is sent out of the second LAN port.

2.  **Switch De-encapsulation/Encapsulation:** No. A standard Layer 2 switch only needs to read the Ethernet frame's header to find the destination MAC address. It does not de-encapsulate the frame to look at the IP packet inside. It simply forwards the original frame to the correct port.

### Exercise 3.2

| Source MAC        | Destination MAC   | Filter or Forward | Output Port | Receiving Hosts |
| ----------------- | ----------------- | ----------------- | ----------- | --------------- |
| 1100.0000.1111    | 1100.0000.2222    | **Filter**        | N/A         | 1, 2, 3         |
| 1100.0000.1111    | 1100.0000.4444    | **Forward**       | Fa0/1       | 4, 5            |
| 1100.0000.5555    | 1100.0000.4444    | **Filter**        | N/A         | 4, 5            |
| 1100.0000.3333    | FFFF.FFFF.FFFF    | **Forward**       | Fa0/1       | 1, 2, 3, 4, 5   |
| 1100.0000.4444    | 1100.2B22.4A4C    | **Forward**       | Fa0/0       | 1, 2, 3         |
| 1100.0000.5555    | FFFF.FFFF.FFFF    | **Forward**       | Fa0/0       | 1, 2, 3, 4, 5   |

### Exercise 3.3

1.  **Port Density:** 24 ports + 2 SFP ports = **26 ports** total.
2.  **Wire Speed:** The RJ-45 ports support 10/100/1000 Mbps. The SFP ports likely support 1 Gbps. So, the wire speed is **up to 1 Gbps**.
3.  **Forwarding Rate:** (24 ports * 1 Gbps) + (2 ports * 1 Gbps) = **26 Gbps**.
4.  **Aggregate Throughput:** 26 Gbps * 0.80 = **20.8 Gbps**. No, this switch is **blocking** because its aggregate throughput (20.8 Gbps) is less than its theoretical forwarding rate (26 Gbps).
5.  **Can aggregate throughput be higher?** No. Aggregate throughput is the *actual* data rate that can be pushed through, which is limited by the switch's internal architecture (backplane speed). It cannot exceed the theoretical maximum forwarding rate.

### Exercise 3.4

*SW3's Switch Table in Figure 3.10:*

| Destination MAC | Exit Port |
| --------------- | --------- |
| A1B1.1111.5555  | Fa0/15    |
| A1B1.1111.6666  | Fa0/20    |
| A1B1.1111.1111  | Fa0/1     |
| A1B1.1111.2222  | Fa0/1     |
| A1B1.1111.3333  | Fa0/1     |
| A1B1.1111.4444  | Fa0/1     |

### Exercise 3.5

*(This requires creating hypothetical MAC and port assignments for Figure 3.11).* An example for SW1's table:

| Destination MAC | Exit Port |
| --------------- | --------- |
| MAC of Host 1   | Fa0/4     |
| MAC of Host 2   | Fa0/5     |
| MAC of Host 3   | Fa0/1     |
| MAC of Host 4   | Fa0/1     |
| ... all other hosts | Fa0/1     |

### Exercise 3.6

1.  **LAN Ports:** Three FastEthernet ports. Their speed is likely 100 Mbps ("FastEthernet").
2.  **WAN Ports:** Two Serial ports.
3.  **Ready for Networking:** One LAN port (Fa0/0) and one WAN port (Serial 0/0) are "Up".
4.  **Why no MAC for serial port?** Serial WAN links are typically point-to-point connections. There is only one possible destination, so a Layer 2 MAC address is not needed to identify the next device.
5.  **Can Fa0/1 have IP 192.168.2.1/24?** No. Fa0/0 is already on the 192.168.2.0/24 subnet. A router cannot have two different interfaces on the same subnet.
6.  **Can Fa0/2 have IP 192.168.4.1/24?** Yes. This is a different subnet, so it is a valid configuration.
7.  **Subnets Interconnected:** Two (192.168.2.0/24 and 192.168.5.0/24).
8.  **Max Subnets:** Up to five (3 LAN + 2 WAN).

### Exercise 3.7

1.  **Difference in ARP tables:** The router's ARP table includes an **Interface** column, specifying which of its network ports the IP/MAC pair is reachable on. A host's table does not need this, as it typically has only one active connection to a single subnet.
2.  **Broadcast entries:**
    -   `192.168.1.255 ff-ff-ff-ff-ff-ff`: This is the **directed broadcast** address for the 192.168.1.0 subnet, mapped to the broadcast MAC address.
    -   `255.255.255.255 ff-ff-ff-ff-ff-ff`: This is the **limited broadcast** address for the local network, also mapped to the broadcast MAC address.
3.  **Router's ARP Table (Figure 3.19b):**
    *   **a. Subnets interconnected:** Two (192.168.10.0 and 192.168.20.0).
    *   **b. WAN connection?** No, you cannot tell from the ARP table. The table only shows Layer 2 (MAC) to Layer 3 (IP) mappings for devices on its connected LAN segments.
4.  **Layer 2 Switch ARP Table?** No. A standard Layer 2 switch operates only at the Data Link layer. It makes forwarding decisions using its MAC address table (switch table), not an ARP table. It does not process IP addresses.

### Exercise 3.8

1.  PC's browser produces an HTTP request.
2.  PC sends an inquiry to a designated **DNS** server.
3.  The **DNS** server returns the IP address of the **web** server.
4.  PC creates a packet with sender's IP (**192.168.1.1**) and receiver's IP (**123.45.67.89**).
5.  PC realizes the target is not on its subnet.
6.  Packet delivery between the PC and default gateway is an **intra-networking** activity.
7.  PC must use the **MAC** address of the default gateway.
8.  PC does not know the default gateway's **MAC address**. This triggers broadcasting of an **ARP** inquiry.
9.  The default gateway responds by sending its **MAC** address.
10. PC updates its **ARP** table. It creates a **frame** and sends it to the default gateway.

### Exercise 3.9

1.  **Relationships:**
    *   **a. Subnetwork and Collision Domain:** They can be equal in scope (e.g., a single segment connected by a hub), but typically a subnetwork contains *multiple* collision domains (one for each switch port).
    *   **b. Subnetwork and Broadcast Domain:** Yes, by default, the scope of a subnetwork is identical to the scope of a broadcast domain.
    *   **c. Collision and Broadcast Domain:** They can be equivalent in a hub-based network, but in a switched network, a single broadcast domain is made up of many smaller collision domains.

2.  **Identifying Domains in Figure 3.27:**
    *   **Network (a):** 1 Collision Domain, 1 Broadcast Domain. (Hub creates one large domain for both).
    *   **Network (b):** 4 Collision Domains (one for each switch port), 1 Broadcast Domain.
    *   **Network (c):** 4 Collision Domains (one for each switch port connected to a host/router), 2 Broadcast Domains (the router separates the network into two).
    *   **Network (d):** 7 Collision Domains (one for each switch port), 3 Broadcast Domains (the router separates the network into three).

---

## Answers to End-of-Chapter Review Questions

1.  The wireless access point is a type of **C. bridge** (specifically, a translational bridge).
2.  A host NIC connected to a hub must use **A. half duplex** transmission.
3.  **C. bridge: layer 2 device** is correctly paired.
4.  **C. ARP (Address Resolution Protocol)** is used to find a MAC address from an IP address.
5.  **E. Automatic assignment of an IP address to the router port (interface)** is NOT an advanced function (it's a basic, manual configuration).
6.  **D. Serial0/0** is an adequate naming for a router's WAN port.
7.  **C. The switch port mostly operates in the full-duplex mode.** is a CORRECT statement.
8.  The **D. router** defines the boundary of a broadcast domain.
9.  **B. Networks relying on switching can be more vulnerable to a single point of failure than those relying on routing.** (Because switching has only one active path, a failure on that path can cut off a segment, whereas routing can use alternate paths).
10. CSMA/CD is activated when connected to a **B. hub**.
11. Aggregate throughput needed for 100% nonblocking: 8 ports * 1 Gbps/port = **B. 8.0 Gbps**.
12. The screenshot shows a mapping of MAC addresses to exit ports, so it is a **E. a switch’s switch table**.
13. **D. Address resolution protocol (ARP)** uses broadcasting.
14. The router uses ARP **E. when it needs to forward an IP packet to another router whose MAC address is not available** (on the same LAN segment).
15. Wire Speed = 1 Gbps; Forwarding Rate = 8 * 1 Gbps = 8 Gbps; 80% nonblocking aggregate throughput = 8 Gbps * 0.8 = 6.4 Gbps. Correct answer: **A. 1 Gbps, 8 Gbps, 6.4 Gbps**.
16. Cut-through switching is when **C. the switch forwards a frame without waiting for its arrival in its entirety.**
17. The difference is judged by **B. available port speeds**.
18. The **B. switch** restricts frame delivery to a single path (by using Spanning Tree Protocol).
19. Source `1100.0000.3333` (on Port 0) to destination `FFFF.FFFF.FFFF` (broadcast) must be forwarded out all other ports. The only other port is Port 1. This would be a **Forward** action. Therefore, **(D) Filter** is incorrect. Let's check A: Source `1100.0000.1111` (Port 0) to `1100.0000.2222` (Port 0) is a **Filter** action. So (A) is incorrect. Let's check B: Source `1100.0000.1111` (Port 0) to `1100.0000.4444` (Port 1) is a **Forward**. (B) is incorrect. Let's re-examine D: Source `1100.0000.3333` (Port 0) to `FFFF.FFFF.FFFF` (broadcast). This must be forwarded out Port 1. The table states it is Filtered. This is **incorrect**. The table seems to have a typo. Let's assume the question asks which entry is correct. `1100.0000.1111` to `1100.0000.4444` is Forward. `1100.0000.1111` to `1100.0000.2222` is Filter. `1100.0000.5555` to `1100.0000.4444` is Filter. Based on standard bridge logic, **C. Forward** for the broadcast is the only one that makes logical sense, but the table in the question has it as Filter. There appears to be an error in the question's provided table. The most likely intended correct answer based on elimination is that a broadcast must be forwarded.
20. The node has both FastEthernet (LAN) and Serial (WAN) interfaces, which is characteristic of a **A. router**.
21. **D. 0001.3412.B23A** must be an INCORRECT one, because a Serial (WAN) interface does not have a MAC address.
22. **D. The router’s OS is generally stored in the nonvolatile flash memory.** is a CORRECT statement.
23. 24 ports * 100 Mbps = 2400 Mbps. 50% of that is **D. 1200 Mbps**.
24. **D. The layer 3 switch port can be either a switch port or a router port.** is the key difference.
25. There are **D. 5** collision domains: one for each host directly connected to the switch, and one larger one for the three hosts connected to the hub. Total = 2 + 1 + 1 + 1 = 5.
# Chapter 4: Elements of Data Transmissions

## Detailed Summary

This chapter focuses on the Physical Layer (Layer 1) of the network model, explaining the technologies and standards required to physically transmit data-carrying signals across wired and wireless media.

### 1. Data and Signal Encoding

-   **Data Encoding (Application Layer):** The process of converting source data (like text, images, or audio) into a binary bit stream (0s and 1s).
-   **Signal Encoding (Physical Layer):** The process of converting that binary bit stream into a physical signal (electrical, light, or radio wave) that can be transmitted over a network medium.

### 2. Digital Signaling

Digital signaling represents binary bits using a finite number of discrete states. It is widely used in wired networking.

-   **On/Off Signaling:** Used for fiber-optic cables, where the presence of a light pulse represents a '1' and the absence of light represents a '0'.
-   **Voltage Signaling:** Used for copper wires (like twisted-pair), where different voltage levels represent binary bits. More advanced schemes use multiple voltage states to represent more than one bit per clock cycle, increasing efficiency.

### 3. Analog Signaling

Analog signaling uses a continuously varying electromagnetic wave to carry data. This is common in wireless communications. The process of embedding digital data onto an analog wave is called **modulation**.

-   **Properties of an Analog Signal:**
    -   **Amplitude:** The strength or intensity of the signal (height of the wave).
    -   **Frequency:** The number of cycles the wave completes per second, measured in Hertz (Hz).
    -   **Phase:** The relative position of a point within a single wave cycle.
-   **Modulation Techniques:**
    -   **Amplitude Modulation (AM):** Varies the amplitude of the wave to represent 0s and 1s.
    -   **Frequency Modulation (FM):** Varies the frequency of the wave.
    -   **Phase Modulation (PM):** Varies the phase of the wave.

### 4. Signaling Devices

-   **Modem (Modulator/Demodulator):** A device that performs **analog signaling**. It modulates digital signals from a computer into analog signals for transmission over an analog line (like a telephone or cable line) and demodulates incoming analog signals back into digital. DSL and Cable modems are common examples.
-   **CSU/DSU (Channel Service Unit/Data Service Unit):** A device that performs **digital signaling**. It converts digital signals from a router into the appropriate format for a digital WAN link, such as a T-1 line.

### 5. Bandwidth, Baseband, and Broadband

-   **Bandwidth:** The technical definition is the range between the highest and lowest frequencies a channel can support (measured in Hz). In practice, it is used interchangeably with **data rate** or **channel capacity** (measured in bps), as a wider frequency range allows for a higher data rate.
-   **Baseband Transmission:** Uses **digital signaling** where the entire bandwidth of the medium is used to transmit a single data stream at a time. This is the standard for modern wired Ethernet.
-   **Broadband Transmission:** Uses **analog signaling** to divide the medium's bandwidth into multiple, separate frequency channels, allowing several data streams to be transmitted simultaneously (e.g., TV, internet, and phone over a single cable).

### 6. Synchronous vs. Asynchronous Transmission

-   **Asynchronous Transmission:** Transmits data one character at a time. Each character is framed with start and stop bits. It is simple but inefficient due to high overhead.
-   **Synchronous Transmission:** Transmits data in large blocks called frames. It is highly efficient and is the method used by modern computer networks like Ethernet.

### 7. Multiplexing

Multiplexing combines signals from multiple sources for transmission over a single shared line or circuit, dramatically increasing efficiency.

-   **Frequency Division Multiplexing (FDM):** Used with **broadband (analog) signaling**. The total bandwidth is divided into separate, non-overlapping frequency channels, with each channel carrying a different signal. (e.g., ADSL).
-   **Time Division Multiplexing (TDM):** Used with **baseband (digital) signaling**. The entire bandwidth is used, but time is divided into repeating slots. Each data source is assigned a time slot to transmit its data. The T-1 line is a classic example, combining 24 voice/data channels into a single stream.
-   **Spread Spectrum:** An advanced multiplexing technique used in wireless networking (e.g., WiFi, cellular) that spreads a signal over a wide frequency band to increase speed and reduce interference.

### 8. Digital Speed Hierarchies

-   **Digital Signal (DS) Hierarchy:** A standard for digital circuit speeds, primarily over copper wires. The base unit is **DS0 (64 kbps)**, the data rate for a single digitized phone call. Higher levels are multiples of DS0 (e.g., **DS1/T-1 = 24 x DS0 = 1.544 Mbps**).
-   **Optical Carrier (OC)/Synchronous Transport Module (STM):** A speed hierarchy for fiber-optic networks. The base speed is **OC-1 (51.84 Mbps)**.

### 9. Networking Media

-   **Propagation Effects:**
    -   **Attenuation:** The natural weakening of a signal as it travels over distance.
    -   **Distortion:** The change in the shape of a signal due to noise and interference.
-   **Twisted-Pair Cable:** The most common wired medium for LANs. Consists of pairs of copper wires twisted together to reduce electromagnetic interference (EMI).
    -   **UTP (Unshielded Twisted-Pair):** Standard cable for most LANs.
    -   **STP (Shielded Twisted-Pair):** Has extra shielding for better noise protection, used in high-speed or noisy environments.
    -   **Categories:** Rated from CAT5 to CAT7a, with higher categories supporting higher bandwidth and data rates.
-   **Optical Fiber:** Transmits data using light pulses through a thin glass or plastic core.
    -   **Advantages:** Huge bandwidth, high security, low interference, and very low attenuation (can travel for miles).
    -   **Single-mode:** Has a very thin core, allowing light to travel in a straight line. Used for long-distance WANs.
    -   **Multimode:** Has a wider core, allowing light to travel in multiple modes (angles). Cheaper but limited to shorter distances (used in LANs) due to **modal dispersion**.

### 10. Structured Cabling

Structured cabling is a standardized, organized approach to network cabling within a building, which simplifies management, troubleshooting, and future upgrades. The EIA/TIA-568 standard defines six subsystems:

1.  **Work Area:** Cabling from the wall plate to end devices (PC, phone).
2.  **Horizontal Cabling:** Permanent cabling running from the work area wall plates to a central wiring closet on the same floor.
3.  **Wiring Closet (IDF - Intermediate Distribution Facility):** A room on each floor that houses access switches and **patch panels**, serving as a connection point.
4.  **Backbone Cabling (Vertical Cabling):** High-speed cabling (often fiber) that connects the wiring closets on different floors to the main equipment room.
5.  **Main Equipment Room (MDF - Main Distribution Facility):** A central room housing core switches, routers, and servers for the entire building.
6.  **Building Entrance Facility:** The point where the building's internal network connects to external services from a WAN carrier or ISP.

---

## Answers to In-Chapter Exercises

### Exercise 4.1

-   If a signal state carries **3 bits**, you need **2³ = 8** different voltage states.
-   For **4 bits**, you need **2⁴ = 16** different voltage states.
-   For **5 bits**, you need **2⁵ = 32** different voltage states.

### Challenge Question (Figure 4.4)

-   **NRZ (Non-Return to Zero):** A '1' is represented by one voltage level and a '0' by another. The signal does not return to a zero-volt state between bits.
-   **Manchester Encoding:** A '1' is a high-to-low voltage transition in the middle of the clock cycle, and a '0' is a low-to-high transition. This ensures a transition for every bit, which helps with clock synchronization.
-   **Differential Manchester Encoding:** A '0' is indicated by a transition at the beginning of the clock cycle. A '1' is indicated by the absence of a transition at the beginning of the clock cycle.

### Exercise 4.2

-   **Asynchronous Overhead:** 3 overhead bits (start, stop, parity) for every 7 data bits = 3 / (7+3) = **30% overhead**.
-   **Ethernet Overhead:** Max overhead is 26 bytes. Max data payload is 1500 bytes.
    -   Overhead percentage = 26 / (26 + 1500) = 26 / 1526 ≈ **1.7% overhead**.
-   Synchronous transmission (Ethernet) is vastly more efficient.

### Exercise 4.3

1.  **Data rate per source (T-1 line):** The T-1 line has 24 time slots (channels). The total data rate is 1.544 Mbps.
    -   Data rate per channel = 1,544,000 bps / 24 channels = **64,333 bps**, which is essentially the **64 kbps** of a DS0 channel.

2.  **Time interval of each frame (T-1 line):** 8,000 frames are produced per second.
    -   Time interval = 1 second / 8,000 frames = **0.000125 seconds** or **125 microseconds**.

### Exercise 4.4

*Referring to Figure 4.21:*

-   **PC to Switch:** Straight-through
-   **Server to Switch:** Straight-through
-   **Switch to Switch:** **Crossover**
-   **Switch to Router:** Straight-through
-   **Router to Router:** **Crossover**

---

## Answers to End-of-Chapter Review Questions

1.  The **D. it is generally located on the bottom floor of a building** is FALSE regarding the wiring closet (IDF). The main equipment room (MDF) is typically on the bottom floor; wiring closets are on each floor.
2.  The fiber-optic cable uses **C. on and off** signaling.
3.  **C. wavelength, frequency, amplitude** represents key properties of the analog wave.
4.  A **B. CSU/DSU** is placed between the border router and a T-1 WAN line.
5.  A **E. switch–switch** link needs crossover cabling.
6.  DS0 represents a voice-grade channel, and its speed is **A. 64 kbps**.
7.  Structured cabling is achieved when **E. the cabling is conducted according to published standard practices**.
8.  The advantage of optical fibers over twisted pairs is NOT **D. higher attenuation** (it has lower attenuation).
9.  These properties determine **A. the category of a twisted pair**.
10. **C. The base speed of DS is 1.54 Mbps...** is INCORRECT. The base speed is DS0 at 64 kbps.
11. When the number of voltage states doubles, **A. one more bit can be additionally sent per clock cycle.** (Because 2^(n+1) = 2 * 2^n).
12. The six components do NOT include **E. cross-connect cabling**.
13. A straight-through cable should be used, EXCEPT for a **E. server–router** connection (these are considered similar devices and require a crossover).
14. The T-1 line combines multiple signals using **B. time division multiplexing**.
15. Patch panels are used widely in the **B. wiring closet**.
16. The access (or workgroup) switch is generally placed in the **A. wiring closet subsystem**.
17. **D. multimode is adequate for LANs and campus network, but not for WANs.** is a CORRECT statement.
18. **E. Using broadband, analog signals can travel through a cable concurrently.** is CORRECT.
19. The **B. patch cord** is used to make a physical connection between two closely placed network nodes.
20. This phenomenon is called **D. modal dispersion**.
21. Modulation is used when **C. a node produces digital data/signal and the delivery channel relies on analog signaling.**
22. The main equipment room subsystem **D. is the termination point of backbone cabling**.
23. The weakening of a signal is called **A. attenuation**.
24. **D. It uses light signals to move data.** is CORRECT regarding fiber-optic cable.
25. The figure shows **E. time division multiplexing**.
# Chapter 5: IP Address Planning and Management

## Detailed Summary

This chapter covers the fundamentals of IP addressing using the IPv4 standard. It explains the structure of an IP address, the legacy and modern allocation schemes, special address ranges, and the critical concepts of subnetting and supernetting for effective network management.

### 1. Governance of IP Address Space

-   The global allocation of IP addresses is managed by the **Internet Assigned Numbers Authority (IANA)**.
-   IANA delegates blocks of addresses to five **Regional Internet Registries (RIRs)** (e.g., ARIN for North America).
-   RIRs, in turn, allocate smaller blocks to large **Internet Service Providers (ISPs)**, who then assign addresses to their customers (organizations and individuals).

### 2. Structure of an IP Address

An IPv4 address is a 32-bit number, typically written in dotted-decimal format (e.g., 129.131.12.10).

-   It is composed of two main parts: a **Network ID** (identifies the organization's network) and a **Host ID** (identifies a specific device on that network).
-   For better management, the Host ID portion can be further divided to create a **Subnet ID**, resulting in a three-level hierarchy: Network ID | Subnet ID | Host ID.

### 3. Classful vs. Classless IP Addressing

-   **Classful IP (Legacy):** An early, inefficient system that divided the IP address space into rigid classes:
    -   **Class A:** 8-bit network ID, 24-bit host ID. For very large networks. (e.g., `10.x.x.x`)
    -   **Class B:** 16-bit network ID, 16-bit host ID. For large networks. (e.g., `172.16.x.x`)
    -   **Class C:** 24-bit network ID, 8-bit host ID. For small networks. (e.g., `192.168.1.x`)
    -   This system was wasteful and has been replaced.

-   **Classless IP (Modern):** Known as **Classless Inter-Domain Routing (CIDR)**, this system allows the boundary between the network and host portions to be set anywhere.
    -   It uses a **prefix** (e.g., `/24`) to denote the number of bits used for the network/subnet portion. This is also represented by a **subnet mask**. For example, a `/24` prefix is equivalent to a subnet mask of `255.255.255.0`.

### 4. Special IP Address Ranges

-   **Loopback Address (127.0.0.0/8):** `127.0.0.1` (`localhost`) is a special address a host uses to send packets to itself. It's used for testing the internal TCP/IP stack and running local applications.
-   **Broadcasting:** Sending a packet to all hosts on a subnet.
    -   **Limited Broadcast (`255.255.255.255`):** Sent to all hosts on the *local* subnet. Blocked by routers.
    -   **Directed Broadcast:** Sent to all hosts on a *remote* subnet (e.g., `192.168.200.255`). This is a security risk and is disabled by default on modern routers.
-   **Multicasting (224.0.0.0 to 239.255.255.255):** Sending a packet to a select group of hosts that have joined a "multicast group." Used for applications like video streaming and online gaming.
-   **Private IP Addresses:** Ranges reserved for use within private networks (LANs). These addresses are not routable on the public Internet.
    -   `10.0.0.0` – `10.255.255.255` (/8)
    -   `172.16.0.0` – `172.31.255.255` (/12)
    -   `192.168.0.0` – `192.168.255.255` (/16)

### 5. Network Address Translation (NAT)

Since private IP addresses cannot be used on the Internet, a process called NAT is used by border routers or firewalls to translate private IPs into a public IP.

-   **One-to-One Mapping:** Each private IP is mapped to a unique public IP.
-   **Many-to-One Mapping (NAPT/PAT):** Multiple private IP hosts share a single public IP. The router uses the **port number** in addition to the IP address (the socket) to keep track of different internal conversations. This is the most common form of NAT.
-   **Benefits:** Conserves public IPv4 addresses, adds a layer of security by hiding internal network structure.

### 6. Subnetting

Subnetting is the process of dividing a single large network into multiple smaller subnetworks (subnets). This is done by "borrowing" bits from the host portion of the address to create a subnet ID.

-   **Benefits:**
    -   **Improved Security:** Segments the network to control access (e.g., creating a DMZ).
    -   **Better Performance:** Reduces the size of broadcast domains, minimizing unnecessary traffic.
    -   **Simplified Management:** Organizes the network along logical or physical boundaries.
-   **Subnet Mask:** A 32-bit number that defines which part of the IP address is the network/subnet and which part is the host. It's represented by a series of 1s (network/subnet part) followed by 0s (host part). For example, `255.255.255.0` in decimal is `11111111.11111111.11111111.00000000` in binary, indicating a `/24` prefix.

### 7. Supernetting (Route Summarization or CIDR)

Supernetting is the opposite of subnetting. It combines multiple smaller, contiguous subnets into a single, larger network representation (a "supernet").

-   **Process:** Find the longest common string of bits from the left among all the subnet addresses to be summarized. This common string becomes the new, shorter network prefix.
-   **Benefit:** Reduces the size of routing tables on routers. Instead of listing many specific routes, a router can have a single summary route, which makes the routing process faster and more efficient.

### 8. Managing IP Address Space

Proper IP planning is crucial for a scalable and manageable network.

-   **Determine Nodes:** Identify all devices that need an IP address (PCs, servers, printers, router interfaces, etc.) and decide whether they need a static (permanent) or dynamic (temporary, via DHCP) address. Servers and network devices typically get static IPs.
-   **Determine Subnets:** Divide the network into subnets based on physical location, department, or security needs. A common practice is to place public-facing servers (like web and email servers) in a separate, firewalled subnet called a **DMZ (Demilitarized Zone)**.
-   **Develop an IP Assignment Policy:** Create a consistent, documented plan for assigning IP addresses. For example, always assign the first usable IP in a subnet to the router, assign a specific range to servers, another to printers, etc. This simplifies troubleshooting and management.

---

## Answers to In-Chapter Exercises

### Review Exercise 5.1

-   101.150.11.51 = `01100101.10010110.00001011.00110011`
-   156.230.15.251 = `10011100.11100110.00001111.11111011`
-   22.131.49.31 = `00010110.10000011.00110001.00011111`
-   223.100.31.76 = `11011111.01100100.00011111.01001100`
-   11001010.10001010.00110110.11110000 = `202.138.54.240`
-   10010010.11001101.10111110.00000011 = `146.205.190.3`
-   11001000.00011000.11101011.10101010 = `200.24.235.170`
-   10100000.01111000.11000001.00110011 = `160.120.193.51`

### Exercise 5.2

1.  **Network Addresses:**
    -   `123.45.56.89` (14-bit network ID): `01111011.001011`|`01.00111000.01011001`. Network address is `01111011.00101100.00000000.00000000` = **123.44.0.0**
    -   `123.45.56.89` (18-bit network ID): Network address is `01111011.00101101.00`|`111000.01011001`. Network address is `01111011.00101101.00000000.00000000` = **123.45.0.0**
    -   `123.45.56.89` (19-bit network ID): Network address is `123.45.32.0`
    -   `123.45.56.89` (21-bit network ID): Network address is `123.45.56.0`

2.  **Max Hosts:**
    -   14-bit network ID -> 18 host bits -> 2¹⁸ - 2 = **262,142 hosts**
    -   18-bit network ID -> 14 host bits -> 2¹⁴ - 2 = **16,382 hosts**
    -   19-bit network ID -> 13 host bits -> 2¹³ - 2 = **8,190 hosts**
    -   21-bit network ID -> 11 host bits -> 2¹¹ - 2 = **2,046 hosts**

### Exercise 5.3

1.  Pinging `127.0.0.1` should succeed, confirming the local TCP/IP stack is working.
2.  Pinging `127.123.123.123` has the same effect. Any IP address within the `127.0.0.0/8` range is treated as a loopback address and will be routed back to the local host.

### Exercise 5.4

1.  Pinging `255.255.255.255` sends a broadcast to all hosts on the local `192.168.1.0` subnet. Every active host on that subnet should respond to the ping.
2.  Pinging `192.168.1.255` is a directed broadcast to the `192.168.1.0` subnet. Since the PC is *on* that subnet, this has the same effect as a limited broadcast: all hosts on the subnet will receive and respond to the ping.
3.  A broadcast domain defines the scope where a broadcast packet (like one sent to `255.255.255.255`) will be forwarded. A limited broadcast is confined to the local broadcast domain.

### Exercise 5.5

When the external servers respond, their packets will have the public IP `137.42.61.33` as the destination. The router receives these packets and consults its NAT table to perform the reverse translation:
1.  A packet arrives for `137.42.61.33` on port `4000`. The router looks this up and finds it maps to the internal private IP `192.168.1.1`. It changes the destination IP to `192.168.1.1`, keeps the destination port as `4000`, and forwards the packet to PC1.
2.  A packet for port `4001` is translated to destination `192.168.1.2`.
3.  A packet for port `4002` is translated to destination `192.168.1.3`.

### Exercise 5.6

There are **8 subnets** in Figure 5.11: 5 LAN subnets and 3 WAN links between the routers.

### Exercise 5.7

1.  Host: `195.112.36.59`. Subnet portion is the first 24 bits.
    -   Subnet Address: **195.112.36.0**
    -   Subnet Mask: **255.255.255.0** (`11111111.11111111.11111111.00000000`)
2.  Host: `207.34.15.187`. Subnet portion is the first 24 bits.
    -   Subnet Address: **207.34.15.0**
    -   Subnet Mask: **255.255.255.0** (`11111111.11111111.11111111.00000000`)
3.  Subnet Addresses and Masks:
    -   `195.205.36.5/13`: Subnet Address **195.200.0.0**, Mask **255.248.0.0**
    -   `192.168.36.5/21`: Subnet Address **192.168.32.0**, Mask **255.255.248.0**
    -   `10.11.46.51/15`: Subnet Address **10.10.0.0**, Mask **255.254.0.0**
4.  Subnet Addresses and Masks:
    -   `10.15.123.50/8`: Subnet **10.0.0.0**, Mask **255.0.0.0**
    -   `17.100.222.15/13`: Subnet **17.96.0.0**, Mask **255.248.0.0**
    -   `128.100.54.11/24`: Subnet **128.100.54.0**, Mask **255.255.255.0**
    -   `141.131.75.162/13`: Subnet **141.128.0.0**, Mask **255.248.0.0**
    -   `115.125.129.22`: Requires a mask. Assuming class B (/16), Subnet **115.125.0.0**, Mask **255.255.0.0**.

### Exercise 5.8

-   **Subnet 2 (130.191.64.0/18):** Range is `130.191.64.1` to `130.191.127.254`.
-   **Subnet 3 (130.191.128.0/18):** Range is `130.191.128.1` to `130.191.191.254`.
-   **Subnet 4 (130.191.192.0/18):** Range is `130.191.192.1` to `130.191.255.254`.

### Exercise 5.9

1.  Network: `130.190.0.0`, 4 bits borrowed.
    *   a. 2⁴ = **16 subnets**.
    *   b. Subnet mask is /20 or **255.255.240.0**.
    *   c. Subnets: `130.190.0.0`, `130.190.16.0`, `130.190.32.0`, ..., `130.190.240.0`.
2.  Network: `172.191.183.0/24`, 4 bits borrowed.
    *   a. Subnet mask is /28 or **255.255.255.240**.
    *   b. Subnets: `172.191.183.0`, `172.191.183.16`, ..., `172.191.183.240`.
    *   c. First subnet host range: **172.191.183.1** to **172.191.183.14**.
3.  Network `230.195.10.0/24`, needs 6 subnets.
    *   a. Need 2³ = 8 subnets, so borrow **3 bits**.
    *   b. Subnet mask is /27 or **255.255.255.224**.
    *   c. Subnets: `230.195.10.0`, `230.195.10.32`, ..., `230.195.10.224`.
    *   d. Last subnet (`.224`) host range: **230.195.10.225** to **230.195.10.254**.

### Exercise 5.10

1.  **Broadcast Addresses:**
    -   `130.191.0.0/18` -> Broadcast **130.191.63.255**
    -   `130.191.64.0/18` -> Broadcast **130.191.127.255**
    -   `130.191.128.0/18` -> Broadcast **130.191.191.255**
    -   `130.191.192.0/18` -> Broadcast **130.191.255.255**
2.  **Broadcast Addresses:**
    -   `192.168.150.121/17` -> Subnet `192.168.128.0`, Broadcast **192.168.255.255**
    -   `172.57.237.200/13` -> Subnet `172.56.0.0`, Broadcast **172.63.255.255**
3.  **Host 130.191.31.21/28:**
    *   a. 2⁴ = **16 subnets**.
    *   b. 4 host bits.
    *   c. 2⁴ - 2 = **14 hosts**.
    *   d. Subnet address is **130.191.31.16**.
    *   e. Broadcast address is **130.191.31.31**.
    *   f. First host is **130.191.31.17**.
    *   g. Last host is **130.191.31.30**.
4.  **Network 192.10.10.0/24, 14 subnets:**
    *   a. Need 2⁴ = 16 subnets, so borrow **4 bits**.
    *   b. Mask is /28 or **255.255.255.240**.
    *   c. **16 subnets**.
    *   d. `192.10.10.0`, `192.10.10.16`, etc.
    *   e. **14 usable hosts**.
    *   f. Range for `.16` subnet: **192.10.10.17** to **192.10.10.30**.
    *   g. Broadcast for `.16` subnet: **192.10.10.31**.

### Exercise 5.11

1.  Subnets `192.168.1.0`, `192.168.2.0`, `192.168.4.0`. In binary, the first 16 bits (`192.168`) are common. Looking at the third octet: `00000001`, `00000010`, `00000100`. The longest common prefix is `00000`. So, the prefix length is 16 + 5 = 21.
    -   Supernet Address: **192.168.0.0/21**
2.  This is a more complex mix. `129` is `10000001`. `130` is `10000010`. `132` is `10000100`. `145` is `10010001`. The longest common prefix is just `100`. So, the prefix length is 16 + 3 = 19.
    -   Supernet Address: **192.168.128.0/19**

### Exercise 5.12

1.  This is tricky because the masks are different. Let's find the range each covers.
    -   `172.16.163.0/20` -> `10101100.00010000.1010`|`0011.0...` -> Net is `172.16.160.0/20`
    -   `172.16.167.0/22` -> `...101001`|`11.0...` -> Net is `172.16.164.0/22`
    -   `172.16.159.0/23` -> `...1001111`|`1.0...` -> Net is `172.16.158.0/23`
    The common bits are `10101100.00010000.100`. Prefix is 19.
    -   Supernet Address: **172.16.128.0/19**
2.  The common bits are `00001010.00010100` (`10.20`). Looking at the third octet: `00011110`(.30), `01000001`(.65), `01011111`(.95), `10100000`(.160). There are no common bits in the third octet.
    -   Supernet Address: **10.20.0.0/16**

### Exercise 5.13

1.  `192.168.44.16`: Subnet `44` is **Student labs**. Host ID `16` is a **Server**.
2.  `192.168.54.50`: Subnet `54` is **Athletics**. Host ID `50` is a **General user station**.
3.  `192.168.4.4`: Subnet `4` is **University administration**. Host ID `4` is a **Managed switch**.
4.  `192.168.53.11`: Subnet `53` is **Campus safety and security**. Host ID `11` is a **Managed wireless device**.

---

## Answers to End-of-Chapter Review Questions

1.  **B. Regional Internet Registry** allocates IP address blocks to large ISPs.
2.  The largest decimal value is **C. 255**.
3.  An IP address must have at least **D. network ID and host ID** parts.
4.  A class C network (/24) using 4 bits for the subnet ID leaves 4 bits for the host ID. 2⁴ - 2 = **A. 14** hosts.
5.  This is **D. directed** broadcasting.
6.  **A. private IPs** are used only internally.
7.  The packet is **E. delivered to all hosts that are in the same subnet as the source host.** (This is a limited broadcast).
8.  NAPT changes the **D. source IP address and maybe source port number**.
9.  `175.140.115.255` with an 8-bit subnet ID means the host part is all 1s. This is a broadcast. **C. The packet is delivered to all hosts within the subnet, 175.140.115.0.**
10. The network plus subnet parts are **C. 10.7.12**. (The question implies the mask is /24).
11. A mask of `255.255.255.0` on a class A network means 16 bits are used for the subnet ID, leaving **D. Eight bits are used to indicate the host identification.**
12. The broadcast address is **A. 65.10.255.255**.
13. Need 14 subnets, so need 4 bits (2⁴=16). Need 14 hosts, so need 4 bits (2⁴-2=14). This works perfectly. The mask is /28 or **C. 255.255.255.240**.
14. For subnet `...16` (/28), the first usable host IP is **B. 192.168.125.17**.
15. For subnet `...32` (/28), the range is `.33` to `.46`. The last usable host IP is **B. 192.168.125.46**.
16. For subnet `...128` (/28), the range is `.128` to `.143`. The broadcast IP is **E. 192.168.125.143**.
17. A `/28` subnet has 4 host bits, so 2⁴ - 2 = **C. 14** usable addresses.
18. **C. 192.168.0.1** is a private IP and needs NAT.
19. The screenshot shows a successful ping to the loopback address. **E. I just tested my computer’s TCP/IP protocol stack.**
20. **A. It is implemented in layer 2 switches.** is INCORRECT. NAT is a Layer 3 function.
21. An address starting with 127 is a loopback address, which can be used for **E. off-line testing of web server pages.**
22. Class B networks use **C. 16** bits for the host ID.
23. A class B network (/16) with a `/24` mask means 8 bits have been borrowed for subnets. 2⁸ = **B. 256** subnets can be created.
24. **C. Reliance on switches than routers...** does not extend IPv4's life.
25. The general delegation process is **C. IANA → Regional Registry → ISPs**.
# Chapter 6: Fundamentals of Packet Routing

## Detailed Summary

This chapter explains the core concepts of IP packet routing, focusing on how routers make forwarding decisions. It covers the structure of a routing table, the different types of routes, and the function of dynamic routing protocols.

### 1. Routing Mechanism

Routing is the Layer 3 process of forwarding IP packets from a source network to a destination network across one or more intermediary routers.

-   **Process:** When a router receives an IP packet, it examines the packet's destination IP address and consults its **routing table** to determine the best path. It then forwards the packet out of the appropriate **exit port (interface)** toward the **next-hop router**.
-   This process is repeated at every router along the path until the packet reaches its final destination network.

### 2. The Routing Table

The routing table is the "brain" of a router, a reference table stored in memory that contains a list of known networks and the information needed to reach them.

-   **Key Elements of a Routing Table Entry:**
    -   **Destination Subnetwork and Subnet Mask:** The address of the network the router knows how to reach. Routers store network addresses, not individual host addresses.
    -   **Exit Port/Interface:** The physical port on the router that the packet should be sent out of to get to the destination.
    -   **Next-Hop IP Address:** The IP address of the next router in the path to the destination. This is the router that the current router will forward the packet to.
    -   **Metric:** A value that represents the "cost" of a particular route. Routers use this to determine the *best* path when multiple paths to the same destination exist. A lower metric is better. Metrics can be calculated based on:
        -   **Hop Count:** The number of routers a packet must cross (simplest metric).
        -   **Bandwidth:** The speed of the links in the path (higher bandwidth = lower cost).
        -   **Delay:** The time it takes to traverse the path.
        -   **Load & Reliability:** The current traffic level and stability of the links.

### 3. Packet Forwarding Decision Logic

When a router receives a packet, it applies the following logic:

1.  **Search the Routing Table:** The router compares the packet's destination IP address to all entries in its routing table.
2.  **Find the Best Match (Longest Match Rule):** If multiple entries match the destination IP, the router will always choose the **most specific route**, which is the one with the **longest subnet mask** (e.g., a `/24` route is more specific than a `/16` route).
3.  **Use the Default Route:** If no specific match is found, the router will use the **default route** (`0.0.0.0/0`). This route acts as a gateway of last resort, typically directing traffic toward the Internet.
4.  **Drop the Packet:** If there is no match and no default route, the packet is discarded.

### 4. Types of Routing Table Entries

1.  **Directly Connected Routes:** These are automatically added to the routing table when an interface on the router is configured with an IP address and activated. The router has zero cost to reach these networks because they are physically attached.
2.  **Static Routes:** These are manually configured by a network administrator. They are useful for small, stable networks or for defining a default route, but they do not adapt to network changes automatically.
3.  **Dynamic Routes:** These are learned automatically by the router through communication with other routers. This is achieved using a **dynamic routing protocol**.

### 5. Dynamic Routing Protocols

A dynamic routing protocol is a set of rules and algorithms that routers use to share information about the networks they can reach and the "cost" to get there. This allows routers to automatically build and update their routing tables.

-   **Routing Protocol vs. Routed Protocol:**
    -   **Routing Protocol** (e.g., OSPF, RIP): Used by routers to *talk to each other* and build routing tables.
    -   **Routed Protocol** (e.g., IP): The protocol for the actual user data packets that are being *forwarded* by the routers.

-   **Categories of Dynamic Routing Protocols:**
    -   **Interior Gateway Protocol (IGP):** Used for routing *within* a single **Autonomous System (AS)**—a network under a single administrative control (e.g., a corporate or university network).
        -   Examples: **RIP** (Routing Information Protocol), **OSPF** (Open Shortest Path First), **EIGRP** (Cisco proprietary).
    -   **Exterior Gateway Protocol (EGP):** Used for routing *between* different Autonomous Systems. The primary EGP of the Internet is **BGP** (Border Gateway Protocol).

-   **How They Work (OSPF Example):**
    1.  Routers discover their neighbors running the same protocol.
    2.  Each router advertises information about its directly connected links (its **link-state**) to all other routers in the AS.
    3.  Each router collects all the link-state advertisements to build a complete map of the entire network topology.
    4.  Using this map, each router independently calculates the shortest (lowest cost) path to every destination network using an algorithm (like Dijkstra's algorithm).
    5.  The best paths are then installed into the routing table.

### 6. Inter-Domain Routing (BGP)

Routing between large networks on the Internet (between different ASs) is handled by BGP. BGP doesn't focus on speed or the shortest path in the same way an IGP does. Instead, it makes routing decisions based on policy, relationships between ISPs, and the path of Autonomous Systems a packet must cross.

---

## Answers to In-Chapter Exercises

### Exercise 6.1

1.  **R2's Routing Table (Figure 6.2):**
    | Destination Subnet | Subnet Mask     | Exit Port |
    | ------------------ | --------------- | --------- |
    | 172.20.2.0         | 255.255.255.0   | Fa0/1     |
    | 172.20.3.0         | 255.255.255.0   | Fa0/0     |
    | 172.20.1.0         | 255.255.255.0   | Fa0/1     |

### Exercise 6.2

1.  **Based on Figure 6.2:**
    *   **a. R2's routing table with next-hop and metric:**
        | Destination | Mask            | Exit Port | Next-Hop IP   | Metric (Hops) |
        | ----------- | --------------- | --------- | ------------- | ------------- |
        | 172.20.3.0  | 255.255.255.0   | Fa0/0     | N/A           | 0             |
        | 172.20.2.0  | 255.255.255.0   | Fa0/1     | N/A           | 0             |
        | 172.20.1.0  | 255.255.255.0   | Fa0/1     | 172.20.2.253  | 1             |
    *   **b. R1's next-hop to Server:** N/A (Server is on a directly connected network for R1).
    *   **c. R2's next-hop to Server:** `172.20.2.253`
    *   **d. R1's exit port to Server:** `Fa0/1`
    *   **e. R2's exit port from Server to PC1:** `Fa0/1`
    *   **f. R2's next-hop from Server to PC2:** N/A (PC2 is on a directly connected network for R2).
    *   **g. R2's next-hop from Server to PC1:** `172.20.2.253`

2.  **Based on Figure 6.3:**
    -   **R1 Routing Table:**
        | Destination     | Mask            | Exit Port | Next-Hop IP    | Hops |
        | --------------- | --------------- | --------- | -------------- | ---- |
        | 10.10.1.0       | 255.255.255.0   | Fa0/0     | N/A            | 0    |
        | 192.168.10.0    | 255.255.255.0   | S0/0/1    | N/A            | 0    |
        | 172.16.1.0      | 255.255.255.0   | S0/0/1    | 192.168.10.2   | 1    |
    -   **R2 Routing Table:**
        | Destination     | Mask            | Exit Port | Next-Hop IP    | Hops |
        | --------------- | --------------- | --------- | -------------- | ---- |
        | 172.16.1.0      | 255.255.255.0   | Fa0/0     | N/A            | 0    |
        | 192.168.10.0    | 255.255.255.0   | S0/0/0    | N/A            | 0    |
        | 10.10.1.0       | 255.255.255.0   | S0/0/0    | 192.168.10.1   | 1    |

### Exercise 6.3

1.  **Matching `100.50.30.10`:**
    -   `100.50.30.0/16`: Match (Incorrect mask notation for the network, but matches the first 16 bits).
    -   `100.40.30.0/16`: No Match.
    -   `100.50.30.0/8`: Match.
    -   `100.50.30.0/25`: No Match (The 25th bit doesn't match).
    -   `100.50.15.0/16`: Match.
    -   `100.50.30.0/24`: **Match (Longest Match)**.
    -   `100.50.10.0/24`: No Match.
    -   `100.50.0.0/24`: No Match.
    -   `100.0.0.0/16`: No Match.
    -   `100.50.0.0/18`: Match.
    -   `100.48.30.0/21`: Match.
    -   `100.27.0.0/15`: No Match.

2.  **Exit Port Decisions:**
    *   **a. Dest: 172.164.32.25:** Matches `172.164.32.0/20` (not listed, but would). The longest match in the list is `/21` for `172.164.32.0`. So, exit port is **S0/0/0**.
    *   **b. Dest: 142.66.39.125:** The longest match is `142.66.39.64/25`. Exit port is **Fa0/1**.
    *   **c. Dest: 11.87.234.111:** The longest match is `11.87.234.60/27`. Exit port is **S0/0/0**.

### Exercise 6.4

1.  **Commands for R1's Fa0/1 (Figure 6.1):**
    ```
    R1(config)# interface Fastethernet0/1
    R1(config-if)# ip address 172.20.2.254 255.255.255.0
    R1(config-if)# no shutdown
    ```
2.  **Directly connected routes for R1 (Figure 6.3):** Two (10.10.1.0/24 and 192.168.10.0/24).
3.  **Commands for R1's S0/0/1 (Figure 6.3):**
    ```
    R1(config)# interface Serial0/0/1
    R1(config-if)# ip address 192.168.10.1 255.255.255.0
    R1(config-if)# no shutdown
    ```

### Exercise 6.6

1.  **Based on Figure 6.4:**
    *   a. Default gateway for PC1: `192.168.1.254` (R1's IP). For PC2: `172.20.1.254` (R2's IP). For Server 1: `10.10.1.254` (R3's IP).
    *   b. Yes, PC1 will receive the response. Server 1 doesn't need a default gateway to respond to a ping from PC1, because PC1 is on a known network in R3's routing table. R3 knows how to route the reply back to the `192.168.1.0` network via R1.
    *   c. No, PC1 will not receive the response. PC1 needs a default gateway to send the initial ping packet to Server 1, which is on a different network. Without it, PC1 will drop the packet.

### Exercise 6.8

1.  **Commands for R2 (Figure 6.13):**
    ```
    R2(config)# router rip
    R2(config-router)# network 172.20.2.0
    R2(config-router)# network 172.20.3.0
    R2(config-router)# end
    ```
2.  **Commands for Figure 6.4:**
    -   **R1:** `router rip`, `network 192.168.1.0`, `network 192.168.10.0`
    -   **R2:** `router rip`, `network 172.20.1.0`, `network 192.168.10.0`
    -   **R3:** `router rip`, `network 10.10.1.0`, `network 192.168.10.0`

---

## Answers to End-of-Chapter Review Questions

1.  The decision is based on the packet's **B. destination IP address**.
2.  The protocol is using the **B. reliability** factor.
3.  The router forwards the packet to the path with the **B. longest match**.
4.  Entries are divided into **C. directly connected routes, static routes, and dynamic routes**.
5.  The **D. default gateway** relays packets beyond the subnet boundary.
6.  Border routers use **A. exterior gateway protocol (EGP)**.
7.  **E. 0.0.0.0/0** is a static default route, not a dynamic route.
8.  **C. border gateway protocol (BGP)** is the most popular EGP.
9.  The router makes a decision **A. Once for each packet that it receives**.
10. **A. RIP** is a good choice for a relatively small network.
11. Routers use the **B. dynamic routing protocol** to share information.
12. **D. A university can have several internal routers that run the same interior gateway routing protocol.** is CORRECT.
13. Destination `183.69.53.151`. The longest match is `/22` (`183.69.52.0`). Exit port is **D. Fa0/1**.
14. Destination `200.100.150.140`. The longest match is `/24` (`200.100.150.0`). Exit port is **A. S0/0/0**.
15. The router **E. selects the matching row with the highest or the lowest value depending on the metric.** (For metrics like bandwidth, higher is better, which translates to a lower cost. For metrics like hop count, lower is better).
16. **E. physical distance to the next router** is LEAST used.
17. R1 has **C. 3** links (to PC1, to R2, to R3).
18. **E. Operating system of the router** would not be included in a link-state advertisement.
19. There are 3 LANs + 4 WAN links = **D. 7** subnets.
20. The common bits for `165`, `145`, `185` are `10`. So the prefix is 16+2=18. Supernet is **E. 10.30.192.0/18**. (This is incorrect, let's re-calculate). `165`=`10100101`, `145`=`10010001`, `185`=`10111001`. The common prefix is just `10`. So it's `/18`. The network would be `10.30.128.0/18`. None of the answers seem correct based on the text's method. Let's assume the question meant `10.30.160.0/24`, `10.30.144.0/24`, and `10.30.176.0/24`. The common prefix would be `/20`. `10.30.160.0/20`. Let's stick with the original question; the closest common ancestor is `10.30.128.0/17`. The question is likely flawed, but `10.30.128.0/18` is the most plausible intended answer structure.
21. The default gateway for PC2 must be on its own subnet (`10.30.20.0`). The only valid IP is **E. 10.30.20.254** (R3's IP on that subnet).
22. Server 1's default gateway is `10.30.6.254`, which is on a different subnet. This is a misconfiguration. **D. The ping request is delivered to Server 1, but PC2 will not receive the ping response.** because Server 1 does not know how to route the reply back.
23. Server 2 has no default gateway. **C. The ping request is delivered to Server 2, but PC1 will not receive the ping response.** because Server 2 doesn't know how to send a reply to a different network.
24. This command creates a **B. Static route** (specifically, a default route).
25. OSPF advertisement from R3 would not include **E. Fa0/0/0’s MAC address is...**. OSPF is a Layer 3 protocol and does not operate with MAC addresses.
# Chapter 7: Ethernet LAN

## Detailed Summary

This chapter focuses on Ethernet, the dominant wired LAN technology. It covers the structure of an Ethernet frame, modern hierarchical design principles, and advanced switching technologies like Spanning Tree Protocol (STP), Link Aggregation, and Virtual LANs (VLANs).

### 1. Standard Layers and Ethernet Frame

-   **Standard Layers:** Ethernet operates at the Physical (Layer 1) and Data Link (Layer 2) layers. The Data Link layer is subdivided into:
    -   **Logical Link Control (LLC):** Provides an interface to the network layer above (Layer 3).
    -   **Media Access Control (MAC):** Responsible for framing and media access (e.g., CSMA/CD in legacy hub networks).
-   **Ethernet Frame Structure:** An Ethernet frame encapsulates an IP packet and adds a header and trailer. Key fields include:
    -   **Preamble & Start Frame Delimiter:** Used for clock synchronization.
    -   **Source & Destination MAC Addresses:** 48-bit hardware addresses for intra-network communication.
    -   **Data:** The payload, which contains the IP packet (typically 46 to 1500 bytes).
    -   **Frame Check Sequence (FCS):** A value calculated using **Cyclic Redundancy Check (CRC)** to detect transmission errors.

### 2. Ethernet LAN Design

Modern Ethernet LANs have moved from a simple, flat design to a more scalable hierarchical model.

-   **Flat Design:** All switches are interconnected on a single tier. Simple for small networks but becomes unmanageable and inefficient as the network grows.
-   **Hierarchical Design:** A structured, multi-tiered model that improves performance, scalability, and management.
    -   **Access Layer:** The layer where end devices (PCs, printers, IP phones) connect to the network, typically via **access switches**.
    -   **Distribution Layer:** Aggregates traffic from the access layer switches and provides connectivity to the core. This is often where policy enforcement and inter-VLAN routing occur.
    -   **Core Layer:** The high-speed backbone of the network, responsible for forwarding large amounts of traffic quickly between distribution layer devices. Provides redundant paths for high availability.

### 3. Spanning Tree Protocol (STP)

-   **Problem:** In a switched network, creating redundant physical links for fault tolerance can lead to **switching loops**. A loop causes broadcast frames to circulate endlessly, leading to a "broadcast storm" that cripples the network.
-   **Solution:** STP (and its faster successor, **RSTP - Rapid Spanning Tree Protocol**) is a Layer 2 protocol that prevents switching loops.
-   **Mechanism:** STP automatically detects redundant paths and logically **blocks** one of the ports to break the loop. This creates a single, loop-free active path. If the primary path fails, STP automatically unblocks the backup port to restore connectivity.

### 4. Link Aggregation (Port Trunking/Bonding)

-   **Function:** A technology that combines multiple physical links between two devices (e.g., switch-to-switch or switch-to-server) into a single logical link.
-   **Benefits:**
    -   **Increased Bandwidth:** The capacity of the logical link is the sum of the physical links (e.g., two 1 Gbps links become one 2 Gbps link).
    -   **Load Balancing:** Traffic is distributed across the physical links.
    -   **Redundancy:** If one physical link fails, traffic continues to flow over the remaining links.
-   **Standard:** The IEEE standard for this is **LACP (Link Aggregation Control Protocol)**.

### 5. Virtual LANs (VLANs)

VLANs are one of the most powerful and common features in modern switched networks.

-   **Concept:** A VLAN is a logical grouping of network devices (like PCs and servers) that are configured to communicate as if they were on the same physical LAN, regardless of their actual physical location.
-   **Function:** VLANs logically segment a single physical LAN into multiple, separate **broadcast domains**. Traffic from one VLAN is isolated and cannot cross into another VLAN without a Layer 3 device (a router or Layer 3 switch).

-   **Key Terminology:**
    -   **Access Port:** A switch port that belongs to a single VLAN. It connects to an end device like a PC.
    -   **Trunk Port:** A switch port that can carry traffic from *multiple* VLANs simultaneously. Trunk ports are used to connect switches to other switches or to routers.

-   **VLAN Tagging (IEEE 802.1Q):** To identify which VLAN a frame belongs to as it crosses a trunk link, the switch inserts a **VLAN tag** into the Ethernet frame header. The tag contains the **VLAN ID**. The tag is added when a frame enters a trunk port and removed when it leaves an access port on its way to an end device.

-   **VLAN Types:**
    -   **Default VLAN (VLAN 1):** Out of the box, all ports on a switch are in the default VLAN.
    -   **Data VLAN:** A standard VLAN configured to carry user data traffic.
    -   **Voice VLAN:** A separate VLAN created specifically for Voice over IP (VoIP) traffic, which allows this time-sensitive traffic to be given a higher priority (QoS).

### 6. Inter-VLAN Routing

Since VLANs are separate broadcast domains, a Layer 3 device is needed for them to communicate. This process is called inter-VLAN routing.

-   **Method 1: Router with Separate Interfaces:** Use a physical router with a separate physical interface connected to an access port for each VLAN. This is simple but not scalable as it consumes many router ports.
-   **Method 2: Router-on-a-Stick:** Use a single physical router interface connected to a trunk port on the switch. The router interface is configured with logical **sub-interfaces**, with each sub-interface assigned an IP address for a different VLAN's subnet and configured to understand the VLAN tags. This is a highly scalable and common method.
-   **Method 3: Layer 3 Switch:** A Layer 3 switch can perform inter-VLAN routing internally at very high speeds without needing an external router. This is the most efficient solution for large campus networks.

---

## Answers to In-Chapter Exercises

### Exercise 7.1

The **Data field** of an Ethernet frame (Figure 7.2) contains the entire PDU from the layer above it, which is the **IP Packet**. As shown in Figure 2.3, this IP Packet itself contains the **TCP Segment** (or UDP Datagram), which in turn contains the **Application Data (APDU)**. So, the data field of the frame is the vessel for the entire chain of encapsulated upper-layer data.

### Exercise 7.2

This exercise involves drawing a physical layout. The key is to map the logical hierarchy to the physical building structure:
-   The **core layer switches** would be placed in the **Main Equipment Room (MDF)** on the first floor.
-   The **access (workgroup) switches** would be placed in the **Wiring Closets (IDFs)** on floors 2, 3, and 4.
-   **Backbone cabling (vertical cabling)** would connect the access switches in the IDFs down to the core switches in the MDF.
-   **Horizontal cabling** would connect the end devices (PCs, etc.) on each floor to the access switch in that floor's IDF.

### Exercise 7.3

If a host broadcasts a frame to switch D (in Figure 7.5), and all links are active, a loop occurs:
1.  D sends the broadcast to B and C.
2.  B sends it to A and F. C sends it to A and F.
3.  Now F has received two copies. It broadcasts them back to B and C. A has also received two copies, and it broadcasts them to B and C.
4.  B, C, A, and F are now caught in an endless loop, forwarding the same broadcast frame to each other, multiplying the traffic exponentially and causing a broadcast storm that crashes the network.

### Review Questions: EQUIP Co. Case

1.  **Cable:** CAT6 for trunks and servers; CAT5 for workstations and cameras.
2.  **Connection Speed:** Trunks/servers are 1 Gbps; workstations/cameras are 100 Mbps.
3.  **Connection Speeds:** Servers: 1 Gbps; Client Stations: 100 Mbps.
4.  **Capacity Doubling:** **Link Aggregation** is used on the production network trunks.
5.  **IP on L2 Switches:** For remote configuration and management.
6.  **Subnets:** Two subnets (production and surveillance). This is for security and traffic isolation.
7.  **Broadcast Domains:** Two, one for each subnet.
8.  **IP Ranges:** Production clients/servers get IPs in the `172.16.10.1 - 172.16.10.254` range.
9.  **Camera IPs:** Cameras get IPs in the `172.16.20.1 - 172.16.20.254` range.
10. **Surveillance Network Design:** Flat design (all cameras connect to a single switch). It is one tier.
11. **Production Network Design:** Hierarchical design. It is **two-tier** (Access and a combined Core/Distribution layer).
12. **Router Placement:** In the **Main Equipment Room (MDF)**. It needs to connect the two subnets and likely the external internet, making the central MDF the logical location.
13. **Adding a DMZ:** Create a new subnet (e.g., `172.16.30.0/24`) and connect it to a third port on the router. The new email/web servers would be placed on this subnet. Firewall rules on the router would then be configured to allow specific traffic (HTTP, SMTP) from the internet to this DMZ, while strictly limiting traffic from the DMZ to the internal production network.

### Exercise 7.4

1.  **VLAN ID:** All hosts are in the default **VLAN 1**.
2.  **Subnet IPs:** There is one subnet: `192.168.10.0/24`.
3.  **Broadcast from 192.168.10.1:** Switch B will forward it out ports `Fa0/10`, `Fa0/15`, and the trunk port `Fa0/1`.
4.  **Computers receiving broadcast:** **All six** computers will receive the frame.
5.  **Destination addresses:** Destination IP: `192.168.10.255` or `255.255.255.255`. Destination MAC: `FF-FF-FF-FF-FF-FF`.
6.  **Switch A/C Tables:** They would list all 6 MACs pointing toward their respective trunk ports. All would be in VLAN 1.
7.  **Problems:** No segmentation. All devices are in one large broadcast domain, which is inefficient and insecure. An accounting PC can directly communicate with an IT PC.
8.  **Router replacement:** No. A router requires each interface to be on a different subnet. Since all hosts are on the same subnet (`192.168.10.0/24`), a router cannot replace switch A.
9.  **Using a router:** You would need to physically regroup all hosts from a single department to be connected to the same switch, and then connect each of those switches to a separate port on a router. This is physically restrictive.
10. **Using a router in the building:** This would be a physical nightmare. You would have to run new horizontal cabling so that, for example, all marketing PCs on all floors connect to a "Marketing Switch," and all accounting PCs connect to an "Accounting Switch," etc. This is exactly the problem VLANs were designed to solve.

---

## Answers to End-of-Chapter Review Questions

1.  This is termed as **A. link aggregation**.
2.  **A. The Spanning Tree Protocol disables redundant paths in a switched Ethernet LAN, and reactivates them as needed.**
3.  The Ethernet VLAN **B. creates smaller segments of a network** (broadcast domains).
4.  Ethernet standards are defined at the **D. physical and data link layers**.
5.  Ethernet synchronizes speed using the **A. preamble**.
6.  Frame priority can be indicated using **B. tag control information** (which contains the 3-bit priority field).
7.  One benefit of VLANs is **B. reduced network congestions** (by limiting broadcasts).
8.  VLANs in Ethernet are configured on **B. switches**.
9.  All hosts belong to the **D. default** VLAN.
10. Sub-interfaces can be assigned to the **C. router port** to enable inter-VLAN routing.
11. VLANs make it **A. easier to manage internal changes (e.g., reassignment of a worker)**.
12. **E. Developing VLANs requires that the network be hierarchical...** is NOT true. VLANs can be used in a flat network.
13. **C. The layer 2 switch can be used to exchange frames between two different VLANs.** is INCORRECT. This requires a Layer 3 device.
14. The switch determines the VLAN ID from the **C. TCI** field in the 802.1Q tag.
15. **A. The data link layer is divided into the LLC and MAC sub-layers.** is CORRECT.
16. Sub-interfaces are used to **A. relay packets between VLANs**.
17. **E. A switch port may be either an access or a trunk port, but not both at the same time.** is CORRECT.
18. The CRC code is used to **B. detect transmission errors**.
19. **E. The layer 2 or 3 switch can be used at the core layer.** is an ACCURATE statement.
20. **B. The LLC sub-layer header describes the type of packet contained in the frame’s data field.** is CORRECT.
21. The length field represents the length of the **A. data field**.
22. They are typically organized in a **C. hierarchy**.
23. In Figure 7.15, Switch B is connected to 3 hosts and 1 trunk. It has **3 access ports** in use.
24. The tagged frame would only exist on the trunk links. **C. F → C, C → A, A → B, and B → D**.
25. The BPDU contains information relevant to **E. redundant path identification** for Spanning Tree Protocol.
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
# Chapter 9: Wide Area Network (WAN)

## Detailed Summary

This chapter explores Wide Area Networks (WANs), which are used to interconnect geographically dispersed LANs. Unlike LANs, which are owned by an organization, WAN infrastructure is typically owned and managed by service providers or carriers.

### 1. WAN and Enterprise Networks

WANs are essential for modern businesses to connect main offices, branch offices, remote workers, and business partners.

-   **Service-Level Agreement (SLA):** A formal contract between a WAN provider and a customer that specifies performance guarantees for data rate, latency, reliability, and availability.
-   **CPE vs. SPF:**
    -   **Customer Premises Equipment (CPE):** Networking equipment that resides at the customer's site (e.g., routers, modems, CSU/DSU).
    -   **Service Provider Facility (SPF):** The carrier's infrastructure, including local access lines and the backbone network.
-   **Demarcation Point:** The physical point where the CPE meets the SPF, defining the boundary of responsibility for maintenance.

### 2. WAN Technologies: Layers and Switching Methods

WAN standards primarily operate at the **Physical (Layer 1)** and **Data Link (Layer 2)** layers.

-   **Circuit Switching:** A dedicated end-to-end circuit with reserved bandwidth is established for the duration of a session. It's reliable but inefficient, as the capacity is reserved even when not in use. **Leased lines** are a prime example.
-   **Packet Switching:** Data is broken into packets that are transmitted independently over a shared network. It's highly efficient but offers no performance guarantees by default. This is the basis for **Packet Switched Data Networks (PSDNs)** and the Internet.
    -   **Virtual Circuit (VC):** A logical end-to-end path established through a packet-switched network. Unlike a physical circuit, it does not reserve bandwidth but predetermines the path packets will follow through the carrier's switches.

### 3. Leased Lines (Physical Layer)

A leased line is a private, point-to-point connection with dedicated bandwidth, offering high reliability and performance at a high cost.

-   **T-Carrier/E-Carrier:** Digital leased line standards.
    -   **T1 (North America):** Offers a speed of **1.544 Mbps**.
    -   **T3:** Offers a speed of **44.7 Mbps**.
-   **SONET/SDH:** A very high-speed fiber-optic leased line standard, often used for carrier backbone networks, with speeds defined by the **Optical Carrier (OC)** hierarchy (e.g., OC-3 at 155 Mbps, OC-192 at 10 Gbps).

-   **Point-to-Point Protocol (PPP):** A common Data Link layer protocol used to transport IP packets over leased lines. It includes features for router authentication using **PAP** or the more secure **CHAP**.

### 4. Packet Switched Data Networks (PSDNs) (Data Link Layer)

PSDNs offer a more flexible and cost-effective alternative to leased lines by using a shared network cloud.

-   **Frame Relay:** A popular and cost-effective PSDN technology.
    -   It uses PVCs (Permanent Virtual Circuits) to forward frames.
    -   Each VC is identified by a **Data Link Connection Identifier (DLCI)**, which is a locally significant number that tells the carrier's switches how to forward the frame to the next hop.
-   **Asynchronous Transfer Mode (ATM):** A high-speed PSDN technology that uses fixed-size 53-byte frames called **cells**. Its fixed cell size makes it very efficient for real-time traffic like voice and video, and it has strong **Quality of Service (QoS)** capabilities.
-   **Carrier Ethernet:** Extends Ethernet technology from the LAN to the WAN. It offers a cost-effective, scalable, and high-bandwidth WAN service that is familiar to network administrators.
-   **Multi-Protocol Label Switching (MPLS):** A highly popular and advanced WAN technology.
    -   It is often called a "Layer 2.5" technology. It forwards IP packets based on a short **label** attached to the packet, rather than by performing a full IP routing lookup at every hop.
    -   This "label switching" is much faster than traditional routing and allows for powerful **traffic engineering** and QoS.

### 5. Wireless WAN: Cellular Networks

Cellular networks have evolved to become a dominant platform for both voice and high-speed data.

-   **Architecture:**
    -   Service areas are divided into **cells**, each served by a **Base Station (BS)**.
    -   Base Stations connect to a **Mobile Terminal Switching Office (MTSO)**, which manages calls, handoffs, and connects to the wider telephone network and Internet.
-   **Generations:**
    -   **1G:** Analog voice.
    -   **2G:** Digital voice and slow data (GSM, CDMA).
    -   **3G:** Faster data, enabling mobile internet (UMTS).
    -   **4G (LTE - Long-Term Evolution):** A high-speed, IP-based packet-switched network for both data and, increasingly, voice (VoLTE). It uses **OFDMA** for multiple access.
-   **Future (5G):** Promises dramatically higher speeds, lower latency, and the capacity to support emerging technologies like IoT and self-driving cars.

---

## Answers to In-Chapter Exercises

### Exercise 9.1

1.  **Mapping Tables for R2 and R3:**
    -   **R2 (Branch 1) Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 10.10.10.1     | VC2         | S0/0/0.10      |
        | 192.168.10.2   | VC5         | S0/0/0.20      |
    -   **R3 (Branch 2) Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC4         | S0/0/0.10      |
        | 192.168.10.1   | VC6         | S0/0/0.20      |
2.  **Total VCs for full mesh:** To fully connect 3 locations, you need a VC in each direction between each pair. 3 pairs * 2 directions = **6 VCs**.

### Exercise 9.2

1.  **Mapping Tables for R1, R2, R3 (Single Subnet):**
    -   **R1 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.2    | VC1         | S0/0/0         |
        | 172.16.10.3    | VC3         | S0/0/0         |
    -   **R2 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC2         | S0/0/0         |
        | 172.16.10.3    | VC5         | S0/0/0         |
    -   **R3 Table:**
        | Destination IP | Local VC ID | Exit Interface |
        | -------------- | ----------- | -------------- |
        | 172.16.10.1    | VC4         | S0/0/0         |
        | 172.16.10.2    | VC6         | S0/0/0         |
2.  **Total VCs:** Still **6 VCs** are needed for a full mesh.

### Exercise 9.3

The physical link at the Houston location must have a data rate at least equal to the sum of the committed speeds of all the PVCs running over it.
-   Minimum Data Rate = 1.5 Mbps + 2.0 Mbps + 1.0 Mbps = **4.5 Mbps**.

---

## Answers to End-of-Chapter Review Questions

1.  An SLA may include **A. minimum latency**.
2.  **E. A carrier may offer Frame Relay service on its ATM backbone cloud.** is a CORRECT statement.
3.  The **E. border router** is a CPE.
4.  **A. While 4G uses packet switching, 2G and 3G depend on circuit switching...** is a key difference.
5.  The demarcation point is where **C. the CPE meets the SPF**.
6.  **B. The cellular network takes advantage of high radio frequency ranges such as UHF and SHF.** is CORRECT.
7.  **D. The demarcation point of the WAN service is located at the POP.** is INCORRECT. The demarcation point is at the customer premise.
8.  **C. ATM** defines several classes of QoS.
9.  Technical details of leased lines are defined in the **E. physical** layer.
10. The PVC is **E. set up by a carrier in its WAN cloud**.
11. SONET/SDH generally adopts the **B. dual-ring** architecture.
12. **B. The carrier provides VCIs (meaning DLCIs) to business customers for the customer site setup.** is CORRECT.
13. SONET determines its bandwidth according to the **D. OC** speed hierarchy.
14. An end-to-end VC is made up of multiple local VCs (DLCIs). A frame will have a different DLCI on each link: Dallas->Switch, Switch->Switch, Switch->Toronto. So, at least **C. 3** different VCIs/DLCIs would be used.
15. The DLCI is a **A. virtual circuit number**.
16. **E. MPLS supports load balancing that moves traffic from congested links to less-congested ones.** is an ACCURATE statement.
17. **B. The cell is equally sized regardless of its location...** is FALSE. Cells are smaller in cities and larger in rural areas.
18. Carriers are NOT responsible for **B. QoS guarantees for all WAN services**. QoS is a premium feature, not standard on all services.
19. Service classes of CBR and VBR are available in **C. ATM**.
20. **B. It can carry Frame Relay frames.** is CORRECT regarding the T-carrier service.
21. **B. PPP** is a point-to-point protocol for leased lines, which are circuit-switched, not packet-switched.
22. **A. Traffic engineering blocks certain IP packets...** is INCORRECT. Traffic engineering is about directing traffic along specific paths, not blocking it.
23. **A. Transmission capacity can be better tailored to client needs by the PSDN service.** is CORRECT.
24. CHAP is a part of the **B. PPP** standard.
25. For 3 sites, you need 3 pairs of connections (A-B, A-C, B-C). Each connection is a PVC. So, **C. Three** PVCs for a full mesh. If the question implies one PVC per direction, the answer would be 6. Given the options, 3 is the most likely intended answer representing the bidirectional links.
