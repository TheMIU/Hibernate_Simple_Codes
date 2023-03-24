package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    private String orderId;
    private LocalDate date;
    private String customerID;

    @OneToMany (mappedBy = "orders")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
}
