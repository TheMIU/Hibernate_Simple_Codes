package entity;

import embeddable.OrderDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;  // Composite ID

    @ManyToOne
    @JoinColumn(name = "itemCode", insertable = false, updatable = false) // Can't Insert or Update (Automatically happen)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "orderID", insertable = false, updatable = false)
    private Orders orders;

    private double unitPrice;
    private int qty;

}
