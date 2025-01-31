# 🚀 Solana Boot Starter Demo

A simple Spring Boot project demonstrating how to use solana-boot-starter.

## Starter

- https://github.com/leandrodalbo/solana-boot-starter

## 🛠️ Setup Solana locally and add a couple of wallets

```bash
solana-test-validator 
solana config set --url http://127.0.0.1:8899

solana-keygen new --outfile ./testwalletA.json
solana config set --keypair ./testwalletA.json

# SHOW PUBLIC KEYS
solana-keygen pubkey ./testwalletA.json
solana-keygen pubkey ./testwalletB.json

## SHOW PRIVATE KEYS
cat ./testwalletA.json
cat ./testwalletB.json

# ADD SOME SOLANA TO YOUR WALLETS
solana airdrop 11 PUBKEY_A
solana airdrop 21 PUBKEY_B
```

## Add your wallets to the application.yml

```yml
wallet-a:
  publicKey:
  byte64PrivateKey:

wallet-b:
  publicKey:
  byte64PrivateKey: 
```

## Run the application

```bash
./gradlew bootRun
```

### Get Balance

```bash
 curl http://localhost:8080/wallet/api/balancea
 curl http://localhost:8080/wallet/api/balanceb
```

### Transfer solana

```bash
 curl http://localhost:8080/wallet/api/sendfroma
 curl http://localhost:8080/wallet/api/sendfromb
```
