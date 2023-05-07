package com.nextonic.invoice.general.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextonic.invoice.general.assembler.InvoiceAssembler;
import com.nextonic.invoice.general.dao.InvoiceMasterDAO;
import com.nextonic.invoice.general.dto.InvoiceItemsDTO;
import com.nextonic.invoice.general.dto.InvoiceMasterDTO;
import com.nextonic.invoice.general.model.InvoiceMasterModel;

@Service
public class BillService {

    @Autowired
    InvoiceMasterDAO invoiceMasterDAO;

    @Autowired
    ItemService itemService;

    @Autowired
    AddressService addressService;

    public List<InvoiceMasterDTO> getAllBillDetails() {
        List<InvoiceMasterModel> model = invoiceMasterDAO.findAll();
        List<InvoiceMasterDTO> dtoInvoice = new ArrayList<InvoiceMasterDTO>();
        System.out.println("CALLING");
        for (InvoiceMasterModel invoice : model) {
            InvoiceMasterDTO dto = InvoiceAssembler.convertModelToVO(invoice);
            dto.setClientAddress(addressService.getAddress(invoice.getId()));
            dto.setItems(itemService.getItems(invoice.getId()));
            dtoInvoice.add(dto);
        }
        return dtoInvoice;
    }

    public InvoiceMasterDTO createInvoice(InvoiceMasterDTO dto) {
        try {
            System.out.println("CREATE");
            InvoiceMasterModel model = new InvoiceMasterModel();
            BeanUtils.copyProperties(dto, model);
            model = invoiceMasterDAO.save(model);

            InvoiceMasterDTO masterDTO = InvoiceAssembler.convertModelToVO(model);
            masterDTO.setItems(itemService.addItems(dto.getItems(), model));
            masterDTO.setClientAddress(addressService.addAddress(dto.getClientAddress(), model));
            return masterDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<InvoiceMasterDTO> findByStatus(String status) {
        List<InvoiceMasterModel> model = invoiceMasterDAO.findByStatus(status);
        List<InvoiceMasterDTO> dtoInvoice = new ArrayList<InvoiceMasterDTO>();
        System.out.println("CALLING");
        for (InvoiceMasterModel invoice : model) {
            InvoiceMasterDTO dto = InvoiceAssembler.convertModelToVO(invoice);
            dto.setClientAddress(addressService.getAddress(invoice.getId()));
            dto.setItems(itemService.getItems(invoice.getId()));
            dtoInvoice.add(dto);
        }
        return dtoInvoice;
    }

    public InvoiceMasterDTO findByCustomId(String id) {
        InvoiceMasterModel model = invoiceMasterDAO.findBy_id(id);
        InvoiceMasterDTO dto = InvoiceAssembler.convertModelToVO(model);
        dto.setClientAddress(addressService.getAddress(model.getId()));
        dto.setItems(itemService.getItems(model.getId()));
        return dto;
    }
}
