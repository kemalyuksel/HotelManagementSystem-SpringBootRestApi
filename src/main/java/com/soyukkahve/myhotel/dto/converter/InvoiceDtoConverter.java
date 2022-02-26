package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.InvoiceDto;
import com.soyukkahve.myhotel.model.Invoice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDtoConverter {

    private final ModelMapper modelMapper;

    public InvoiceDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public InvoiceDto convertToDto(Invoice invoice) {
        InvoiceDto invoiceDto = modelMapper.map(invoice, InvoiceDto.class);

        return invoiceDto;
    }

    public Invoice convertToEntity(InvoiceDto invoiceDto) {
        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);

//        if (userDto.getId() != null) {
//
//        }
        return invoice;
    }


}
