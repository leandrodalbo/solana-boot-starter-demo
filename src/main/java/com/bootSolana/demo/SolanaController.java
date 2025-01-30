package com.bootSolana.demo;

import io.solana.boot.response.AccountBalance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet/api")
public class SolanaController {

    private final SolanaService solanaService;

    public SolanaController(SolanaService solanaService) {
        this.solanaService = solanaService;
    }

    @GetMapping("sendB")
    public String sendToWalletB() {
        return solanaService.transferFromA();
    }

    @GetMapping("sendA")
    public String sendToWalletA() {
        return solanaService.transferFromB();
    }

    @GetMapping("balanceA")
    public AccountBalance getWalletABalance() {
        return solanaService.walletABalance();
    }

    @GetMapping("balanceB")
    public AccountBalance getWalletBBalance() {
        return solanaService.walletBBalance();
    }
}
