package bhup9.profiling.Service;

import bhup9.profiling.Entity.Item;
import bhup9.profiling.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    ItemRepository repository;

    @Value("${application.welcome.message}")  //Start Profiling logic
    private String welcomeMessage;   //@Value annotation bind the application properties msg into welcomeMessage
    @Override
    public String getWelcomeMessage() throws Exception {
        return welcomeMessage;
    }                                      //End Profiling logic
    @Override
    public List<Item> getItem() {
        return (List<Item>) repository.findAll();
    }
    @Override
    public void save(Item item) {
        repository.save(item);

    }
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    @Override
    public Item getId(int id) {
        return repository.findById(id).get();

    }
    @Override
    public void update(int id,Item item) {
        Item item1 = repository.findById(id).get();
      item1.setName(item.getName());
        repository.save(item1);
    }
}
