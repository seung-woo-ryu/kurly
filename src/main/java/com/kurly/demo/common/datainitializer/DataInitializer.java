package com.kurly.demo.common.datainitializer;

import com.kurly.demo.item.domain.Item;
import com.kurly.demo.item.repository.ItemRepository;
import com.kurly.demo.order.domain.Order;
import com.kurly.demo.order.domain.OrderInformation;
import com.kurly.demo.order.repository.OrderInformationRepository;
import com.kurly.demo.order.repository.OrderRepository;
import com.kurly.demo.user.domain.User;
import com.kurly.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {
    private static final String DEFAULT_PASSWORD = "qwerasdf12!";
    public final UserRepository userRepository;
    public final OrderRepository orderRepository;
    public final ItemRepository itemRepository;
    public final OrderInformationRepository orderInformationRepository;
    public static User testUser1;
    public static User testUser2;
    public static User testUser3;
    public static User testUser4;
    public static Order testOrder1;
    public static Order testOrder2;
    public static Order testOrder3;
    public static Order testOrder4;
    public static Item testItem1;
    public static Item testItem2;
    public static Item testItem3;
    public static Item testItem4;
    public static Item testItem5;
    public static Item testItem6;
    public static Item testItem7;
    public static Item testItem8;
    public static OrderInformation testOrderInformationByOrder1AndItem1;
    public static OrderInformation testOrderInformationByOrder1AndItem2;
    public static OrderInformation testOrderInformationByOrder1AndItem3;
    public static OrderInformation testOrderInformationByOrder2AndItem1;
    public static OrderInformation testOrderInformationByOrder3AndItem6;
    public static OrderInformation testOrderInformationByOrder3AndItem7;
    public static OrderInformation testOrderInformationByOrder4AndItem2;
    public static OrderInformation testOrderInformationByOrder4AndItem3;
    public static OrderInformation testOrderInformationByOrder4AndItem8;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testUser1 = saveUser("tmddn111@gmail.com", DEFAULT_PASSWORD, "seungwoo", 25L);
        testUser2 = saveUser("kmk111@gmail.com", DEFAULT_PASSWORD, "kimminkwon", 22L);
        testUser3 = saveUser("khm111@gmail.com", DEFAULT_PASSWORD, "kanghunmo", 23L);
        testUser4 = saveUser("ksj111@gmail.com", DEFAULT_PASSWORD, "kimseongjun", 24L);

        testOrder1 = saveOrder(testUser1,null,"서울 중구 서애로 12-20",false);
        testOrder2 = saveOrder(testUser2,null,"서울 중구 서애로 26",false);
        testOrder3 = saveOrder(testUser3,null,"서울 성동구 금호로 100",false);
        testOrder4 = saveOrder(testUser4,null,"서울 성동구 금호로 15",false);

        testItem1 = saveItem("크라운 신짱");
        testItem2 = saveItem("뉴질랜드 골드 키위");
        testItem3 = saveItem("대용량 영광굴비 1.2kg");
        testItem4 = saveItem("밀눈 오리지널 그래놀라");
        testItem5 = saveItem("대창 주꾸미 볶음 320g");
        testItem6 = saveItem("태국 소고기 쌀국수");
        testItem7 = saveItem("에빠끌라 세럼");
        testItem8 = saveItem("남도식 양념황태구이");

        testOrderInformationByOrder1AndItem1 = saveOrderInformation(testOrder1, testItem1, 2L);
        testOrderInformationByOrder1AndItem2 = saveOrderInformation(testOrder1, testItem2, 1L);
        testOrderInformationByOrder1AndItem3 = saveOrderInformation(testOrder1, testItem3, 3L);

        testOrderInformationByOrder2AndItem1 = saveOrderInformation(testOrder2, testItem1, 3L);

        testOrderInformationByOrder3AndItem6 = saveOrderInformation(testOrder3, testItem6, 2L);
        testOrderInformationByOrder3AndItem7 = saveOrderInformation(testOrder3, testItem7, 3L);

        testOrderInformationByOrder4AndItem2 = saveOrderInformation(testOrder4, testItem2, 1L);
        testOrderInformationByOrder4AndItem3 = saveOrderInformation(testOrder4, testItem3, 2L);
        testOrderInformationByOrder4AndItem8 = saveOrderInformation(testOrder4, testItem8, 3L);
    }

    private User saveUser(String email, String password, String name, Long age) {
        return userRepository.save(User.of(email, password, name, age));
    }

    private Order saveOrder(User user, String imageUrl, String address, boolean isCompleted) {
        return orderRepository.save(Order.of(user, imageUrl, address, isCompleted));
    }

    private Item saveItem(String name) {
        return itemRepository.save(Item.of(name));
    }

    private OrderInformation saveOrderInformation(Order order, Item item,Long quantity) {
        return orderInformationRepository.save(OrderInformation.of(order, item,quantity));
    }
}
