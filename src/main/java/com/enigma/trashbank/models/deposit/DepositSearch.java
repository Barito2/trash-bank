package com.enigma.trashbank.models.deposit;


import com.enigma.trashbank.models.PageSearch;
import com.enigma.trashbank.models.trash.TrashSearch;

public class DepositSearch extends PageSearch {

    private TrashSearch trash;

    public TrashSearch getTrash() {
        return trash;
    }

    public void setTrash(TrashSearch trash) {
        this.trash = trash;
    }
}
