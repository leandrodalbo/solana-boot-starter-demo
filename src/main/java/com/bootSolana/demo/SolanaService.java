package com.bootSolana.demo;

import com.bootSolana.demo.wallets.WalletA;
import com.bootSolana.demo.wallets.WalletB;
import io.solana.boot.response.AccountBalance;
import io.solana.boot.solana.Solana;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class SolanaService {
    private final Solana solana;
    private final WalletA walletA;
    private final WalletB walletB;

    public SolanaService(Solana solana, WalletA walletA, WalletB walletB) {
        this.solana = solana;
        this.walletA = walletA;
        this.walletB = walletB;
    }


    public String transferFromA() {
        return solana.transfer(encodedKey(privateKeyBytes(walletA.privateKey())),
                encodedKey(walletA.publicKey().getBytes()),
                encodedKey(walletB.publicKey().getBytes()),
                1L
        );
    }

    public String transferFromB() {
        return solana.transfer(encodedKey(privateKeyBytes(walletB.privateKey())),
                encodedKey(walletB.publicKey().getBytes()),
                encodedKey(walletA.publicKey().getBytes()),
                1L
        );
    }

    public AccountBalance walletABalance() {
        return solana.getBalance(walletA.publicKey());
    }

    public AccountBalance walletBBalance() {
        return solana.getBalance(walletB.publicKey());
    }

    private byte[] privateKeyBytes(List<Integer> values) {
        byte[] keyBytes = new byte[values.size()];
        for (int i = 0; i < values.size(); i++) {
            keyBytes[i] = values.get(i).byteValue();
        }

        return keyBytes;
    }

    private String encodedKey(byte[] keyBytes) {
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
