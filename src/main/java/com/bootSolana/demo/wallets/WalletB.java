package com.bootSolana.demo.wallets;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("wallet-b")
public record WalletB(String publicKey, List<Integer> privateKey) {
}
