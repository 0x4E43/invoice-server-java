package com.nextonic.invoice.general.assembler;

import org.springframework.beans.BeanUtils;

import com.nextonic.invoice.general.dto.InvoiceAddressDTO;
import com.nextonic.invoice.general.dto.InvoiceMasterDTO;
import com.nextonic.invoice.general.model.InvoiceAddressModel;
import com.nextonic.invoice.general.model.InvoiceMasterModel;

public class InvoiceAssembler {

    public static InvoiceMasterDTO convertModelToVO(InvoiceMasterModel model) {
        InvoiceMasterDTO dto = new InvoiceMasterDTO();
        InvoiceAddressDTO senderAddress = new InvoiceAddressDTO();
        senderAddress.setCity("Bangalore");
        senderAddress.setPostCode("560076");
        senderAddress.setCountry("INDIA");
        senderAddress.setStreet("871, 9th Cross Road");
        BeanUtils.copyProperties(model, dto);
        dto.setSenderAddress(senderAddress);
        return dto;
    }

}
