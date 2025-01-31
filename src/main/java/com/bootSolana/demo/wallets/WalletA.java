package com.bootSolana.demo.wallets;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("wallet-a")
public record WalletA(String publicKey,  List<Integer> byte64PrivateKey) {}
