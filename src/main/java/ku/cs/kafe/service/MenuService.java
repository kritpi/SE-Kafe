//6510405300 Kritpiruch Chaiwong

import java.util.UUID;


@Service
public class MenuService {


   @Autowired
   private MenuRepository menuRepository;


   @Autowired
   private CategoryRepository categoryRepository;


   @Autowired
   private ModelMapper modelMapper;


   public List<Menu> getAllMenus() {
       return menuRepository.findAll();
   }


   public Menu getOneById(UUID id) {
       return menuRepository.findById(id).get();
   }
  
   public void create(MenuRequest request) {
       Menu record = modelMapper.map(request, Menu.class);
       Category category =
               categoryRepository.findById(request.getCategoryId()).get();
       record.setCategory(category);
       menuRepository.save(record);
   }
}
