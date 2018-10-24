package daredevil.landlordbankrest.controllers;

import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.DTO.BankAccountDTO;
import daredevil.landlordbankrest.models.Models.BankAccountModel;
import daredevil.landlordbankrest.services.base.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/landlordBank")
public class BankAccountController {
    BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/getBankAccount/{iban}")
    public BankAccountDTO getBankAccount(@PathVariable String iban){
        return BankAccountDTO.getFromBankAccount(bankAccountService.getBankAccountByIban(iban));
    }

    @PostMapping("/addBankAccount")
    public void addBankAccount(@RequestBody BankAccountModel bankAccountModel){
        bankAccountService.addBankAccountFromBankAccountModel(bankAccountModel);
    }
}
