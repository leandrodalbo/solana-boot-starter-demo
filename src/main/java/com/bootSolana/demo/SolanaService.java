package com.bootSolana.demo;

import com.bootSolana.demo.wallets.WalletA;
import com.bootSolana.demo.wallets.WalletB;
import io.bootsolana.solana.Solana;
import org.springframework.stereotype.Service;

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
        return solana.transfer(Utils.encodePrivateKey(walletA.byte64PrivateKey()),
                walletB.publicKey(),
                1L
        );
    }

    public String transferFromB() {
        return solana.transfer(Utils.encodePrivateKey(walletB.byte64PrivateKey()),
                walletA.publicKey(),
                1L
        );

    }

    public Object walletABalance() {
        return solana.getBalance(walletA.publicKey());
    }

    public Object walletBBalance() {
        return solana.getBalance(walletB.publicKey());
    }

}
