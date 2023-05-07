package com.nextonic.invoice.general.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextonic.invoice.general.dao.InvoiceAddressDAO;
import com.nextonic.invoice.general.dto.InvoiceAddressDTO;
import com.nextonic.invoice.general.model.InvoiceAddressModel;
import com.nextonic.invoice.general.model.InvoiceMasterModel;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class AddressService {

    @Autowired
    InvoiceAddressDAO invoiceAddressDAO;

    public InvoiceAddressDTO addAddress(InvoiceAddressDTO dto, InvoiceMasterModel masterModel) {
        try {
            InvoiceAddressModel model = new InvoiceAddressModel();
            model.setStreet(dto.getStreet());
            model.setCountry(dto.getCountry());
            model.setPostCode(dto.getPostCode());
            model.setCity(dto.getCity());
            model.setMasterId(masterModel.getId());
            model.setClient(true);
            model = invoiceAddressDAO.save(model);
            BeanUtils.copyProperties(model, dto);
            return dto;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return dto;
        }
    }

    public InvoiceAddressDTO getAddress(Long masterId) {
        InvoiceAddressDTO addressDTO = new InvoiceAddressDTO();
        try {
            InvoiceAddressModel model = invoiceAddressDAO.findByMasterId(masterId);
            if (model != null) {
                BeanUtils.copyProperties(model, addressDTO);
                return addressDTO;
            }
            return addressDTO;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return addressDTO;
        }
    }

}
