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
