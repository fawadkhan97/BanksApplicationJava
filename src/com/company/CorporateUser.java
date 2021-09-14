package com.company;


class CorporateUser extends Users {
    private int noOfEmployess;
    private boolean isLocal;
    private boolean govtApproved;

    public int getNoOfEmployess() {
        return noOfEmployess;
    }

    public void setNoOfEmployess(int noOfEmployess) {
        this.noOfEmployess = noOfEmployess;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public boolean isGovtApproved() {
        return govtApproved;
    }

    public void setGovtApproved(boolean govtApproved) {
        this.govtApproved = govtApproved;
    }
}

