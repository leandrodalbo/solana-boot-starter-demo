package com.bootSolana.demo;

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

    @GetMapping("/sendfromb")
    public String sendToWalletA() {
        return solanaService.transferFromB();
    }

    @GetMapping("/sendfroma")
    public String sendToWalletB() {
        return solanaService.transferFromA();
    }

    @GetMapping("/balancea")
    public Object getWalletABalance() {
        return solanaService.walletABalance();
    }

    @GetMapping("/balanceb")
    public Object getWalletBBalance() {
        return solanaService.walletBBalance();
    }

}
