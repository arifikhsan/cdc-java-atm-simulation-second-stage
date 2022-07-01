package org.example.repository;

import org.example.model.WithdrawModel;

import java.util.ArrayList;
import java.util.List;

public class WithdrawRepository {
    private List<WithdrawModel> withdraws = new ArrayList<>();

    public WithdrawRepository() {
    }

    public WithdrawRepository(List<WithdrawModel> withdraws) {
        this.withdraws = withdraws;
    }

    public List<WithdrawModel> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(List<WithdrawModel> withdraws) {
        this.withdraws = withdraws;
    }
}
