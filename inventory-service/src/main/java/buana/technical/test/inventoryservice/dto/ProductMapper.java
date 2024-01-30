package buana.technical.test.inventoryservice.dto;

import org.mapstruct.Mapper;

import buana.technical.test.inventoryservice.dto.request.CreateProductDTO;
import buana.technical.test.inventoryservice.dto.response.GetProductDTO;
import buana.technical.test.inventoryservice.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productRequestDTOtoProduct(CreateProductDTO createProductDTO);

    GetProductDTO productToGetDTO(Product product);
}
