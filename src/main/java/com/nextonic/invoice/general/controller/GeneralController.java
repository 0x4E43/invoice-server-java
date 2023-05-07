package com.nextonic.invoice.general.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nextonic.invoice.general.dto.InvoiceMasterDTO;
import com.nextonic.invoice.general.services.BillService;

import jakarta.persistence.criteria.Path;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
// @RequestMapping(path = "/demo")
public class GeneralController {

    @Autowired
    BillService billService;

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<InvoiceMasterDTO> requestMethodName() {
        return billService.getAllBillDetails();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public InvoiceMasterDTO addInvoice(@RequestBody InvoiceMasterDTO dto) {
        return billService.createInvoice(dto);
    }

    @RequestMapping(value = "/invoices/{status}", method = RequestMethod.GET)
    public List<InvoiceMasterDTO> findByStatus(@PathVariable String status) {
        System.out.println("status: " + status);
        return billService.findByStatus(status);
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.PATCH)
    public InvoiceMasterDTO findByCustomId(@PathVariable String id) {
        System.out.println("Patch call: " + id);
        return billService.findByCustomId(id);
    }

}
