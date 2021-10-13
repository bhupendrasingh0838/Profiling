package bhup9.profiling.Service;

import bhup9.profiling.Entity.Item;

import java.util.List;

public interface ItemService {

    public String getWelcomeMessage() throws Exception;

    public List<Item> getItem();

    public void save(Item item);

    public void delete(int id);

    public Item getId(int id);

    public void update(int id,Item item);
}
