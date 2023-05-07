package com.nextonic.invoice.general.dto;

import java.util.List;

import com.nextonic.invoice.general.model.InvoiceAddressModel;

public class InvoiceMasterDTO {

    private String _id;
    private String clientName;
    private String clientEmail;
    private String createdAt;
    private String paymentDue;
    private Long paymentTerms;
    private String description;
    private String status;
    private Long total;
    private InvoiceAddressDTO clientAddress;
    private InvoiceAddressDTO senderAddress;
    private List<InvoiceItemsDTO> items;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(String paymentDue) {
        this.paymentDue = paymentDue;
    }

    public Long getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(Long paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public InvoiceAddressDTO getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(InvoiceAddressDTO clientAddress) {
        this.clientAddress = clientAddress;
    }

    public InvoiceAddressDTO getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(InvoiceAddressDTO senderAddress) {
        this.senderAddress = senderAddress;
    }

    public List<InvoiceItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemsDTO> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
