package com.nextonic.invoice.general.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextonic.invoice.general.model.InvoiceItemsModel;

public interface InvoiceItemsDAO extends JpaRepository<InvoiceItemsModel, Long> {

    List<InvoiceItemsModel> findByMasterId(Long masterModelId);

}
