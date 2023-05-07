package com.nextonic.invoice.general.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextonic.invoice.general.dao.InvoiceItemsDAO;
import com.nextonic.invoice.general.dto.InvoiceItemsDTO;
import com.nextonic.invoice.general.model.InvoiceItemsModel;
import com.nextonic.invoice.general.model.InvoiceMasterModel;

@Service
public class ItemService {

    @Autowired
    InvoiceItemsDAO invoiceItemsDAO;

    public List<InvoiceItemsDTO> addItems(List<InvoiceItemsDTO> dtoList, InvoiceMasterModel masterModel) {
        List<InvoiceItemsDTO> itemsDTOList = new ArrayList<InvoiceItemsDTO>();
        try {
            for (InvoiceItemsDTO dto : dtoList) {
                InvoiceItemsDTO itemsDto = new InvoiceItemsDTO();
                InvoiceItemsModel model = new InvoiceItemsModel();
                BeanUtils.copyProperties(dto, model);
                model.setMasterId(masterModel.getId());
                model.setTotal(masterModel.getTotal().intValue());
                model = invoiceItemsDAO.save(model);
                itemsDto.setName(model.getName());
                itemsDto.setPrice(model.getPrice());
                itemsDto.setQuantity(model.getQuantity());
                itemsDto.setTotal(Long.parseLong(model.getTotal() + ""));
                itemsDTOList.add(itemsDto);
            }
            return itemsDTOList;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return itemsDTOList;
        }
    }

    public List<InvoiceItemsDTO> getItems(Long masterModelId) {
        List<InvoiceItemsDTO> itemsDTOList = new ArrayList<InvoiceItemsDTO>();
        try {
            for (InvoiceItemsModel model : invoiceItemsDAO.findByMasterId(masterModelId)) {
                InvoiceItemsDTO itemsDto = new InvoiceItemsDTO();
                itemsDto.setName(model.getName());
                itemsDto.setPrice(model.getPrice());
                itemsDto.setQuantity(model.getQuantity());
                itemsDto.setTotal(Long.parseLong(model.getTotal() + ""));
                itemsDTOList.add(itemsDto);
            }
            return itemsDTOList;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return itemsDTOList;
        }
    }

}
