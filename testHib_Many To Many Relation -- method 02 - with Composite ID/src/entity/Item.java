package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private String itemCode;
    private String description;
    private double UnitPrice;
    private int QtyOnHand;

    @OneToMany (mappedBy = "item")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
}
