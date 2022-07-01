package org.example.repository;

import org.example.model.TransferModel;

import java.util.ArrayList;
import java.util.List;

public class TransferRepository {
    private List<TransferModel> transfers = new ArrayList<>();

    public TransferRepository() {
    }

    public List<TransferModel> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferModel> transfers) {
        this.transfers = transfers;
    }
}
