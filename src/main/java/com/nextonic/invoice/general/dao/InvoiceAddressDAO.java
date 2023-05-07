package com.nextonic.invoice.general.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextonic.invoice.general.model.InvoiceAddressModel;

public interface InvoiceAddressDAO extends JpaRepository<InvoiceAddressModel, Long> {

    InvoiceAddressModel findByMasterId(Long masterId);

}