package ru.itis.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.ProductResponse;
import ru.itis.dto.ProductResponseFront;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T06:42:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseFront toProductResponseFront(ProductResponse productResponse) {
        if ( productResponse == null ) {
            return null;
        }

        ProductResponseFront productResponseFront = new ProductResponseFront();

        productResponseFront.set_id( productResponse.get_id() );
        List list = productResponse.getCategories();
        if ( list != null ) {
            productResponseFront.setCategories( new ArrayList<String>( list ) );
        }
        List list1 = productResponse.getTags();
        if ( list1 != null ) {
            productResponseFront.setTags( new ArrayList<String>( list1 ) );
        }
        productResponseFront.setTitle( productResponse.getTitle() );
        productResponseFront.setLink( productResponse.getLink() );
        productResponseFront.setImage( productResponse.getImage() );
        productResponseFront.setInitialRating( productResponse.getInitialRating() );
        List list2 = productResponse.getCharacteristics();
        if ( list2 != null ) {
            productResponseFront.setCharacteristics( new ArrayList<ProductResponse.Characteristic>( list2 ) );
        }
        productResponseFront.setPrice( productResponse.getPrice() );
        productResponseFront.setOldPrice( productResponse.getOldPrice() );
        productResponseFront.setCredit( productResponse.getCredit() );
        productResponseFront.setDescription( productResponse.getDescription() );
        productResponseFront.setBigImage( productResponse.getBigImage() );
        productResponseFront.setAdditionalMeta( productResponse.getAdditionalMeta() );
        productResponseFront.setCompanyId( productResponse.getCompanyId() );
        productResponseFront.setClicks( productResponse.getClicks() );
        productResponseFront.setReviewCount( productResponse.getReviewCount() );
        productResponseFront.setReviewAvg( productResponse.getReviewAvg() );
        productResponseFront.setAdvantages( productResponse.getAdvantages() );
        productResponseFront.setDisAdvantages( productResponse.getDisAdvantages() );

        return productResponseFront;
    }
}
