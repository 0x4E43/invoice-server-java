package com.nextonic.invoice.general.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextonic.invoice.general.model.InvoiceMasterModel;

public interface InvoiceMasterDAO extends JpaRepository<InvoiceMasterModel, Long> {

    List<InvoiceMasterModel> findByStatus(String status);

    InvoiceMasterModel findBy_id(String id);

}
