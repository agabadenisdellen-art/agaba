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
