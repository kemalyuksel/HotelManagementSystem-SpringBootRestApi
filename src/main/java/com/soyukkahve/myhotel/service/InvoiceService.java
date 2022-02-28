package com.soyukkahve.myhotel.service;


import com.soyukkahve.myhotel.dto.InvoiceDto;
import com.soyukkahve.myhotel.dto.converter.InvoiceDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.Invoice;
import com.soyukkahve.myhotel.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoConverter invoiceConverter;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          InvoiceDtoConverter invoiceConverter) {

        this.invoiceRepository = invoiceRepository;
        this.invoiceConverter = invoiceConverter;
    }

    public Invoice findById(Long id){
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice could not find by id : " + id ));
    }

    public InvoiceDto getById(Long id){
        return invoiceConverter.convertToDto(findById(id));
    }


    public List<InvoiceDto> getAll(){

        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<InvoiceDto> invoiceDtos = invoiceList.stream().map(i -> invoiceConverter.convertToDto(i)).collect(Collectors.toList());


        return invoiceDtos;
    }

    public InvoiceDto save(InvoiceDto invoiceDto){

        Invoice invoice = invoiceConverter.convertToEntity(invoiceDto);

        return invoiceConverter.convertToDto(invoiceRepository.save(invoice));

    }


}
