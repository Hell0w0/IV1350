
package se.kth.IV1350.pos.discount;

import java.util.List;
import se.kth.IV1350.pos.DTO.DiscountDTO;
import se.kth.IV1350.pos.DTO.SaleDTO;

/**
 *
 * @author charl
 */
public interface DiscountFinder{

    /**
     *
     * @param saleDTO
     * @param availableDiscounts
     * @return
     */
    List<DiscountDTO> findDiscount(SaleDTO saleDTO, List<DiscountDTO> availableDiscounts);
}
