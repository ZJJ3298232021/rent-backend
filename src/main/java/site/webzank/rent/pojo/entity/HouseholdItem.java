package site.webzank.rent.pojo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author zank
 */
@Data
public class HouseholdItem {
    private String name;
    private List<Item> itemList;
}
