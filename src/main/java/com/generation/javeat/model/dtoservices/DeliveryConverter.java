package com.generation.javeat.model.dtoservices;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.delivery.DeliveryDtoRPost;
import com.generation.javeat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.javeat.model.entities.Delivery;
import com.generation.javeat.model.entities.Dish;
import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.entities.Restaurant;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.DeliveryRepository;
import com.generation.javeat.model.repositories.DishRepository;
import com.generation.javeat.model.repositories.RestaurantRepository;
import com.generation.javeat.model.repositories.UserRepository;
@Service
public class DeliveryConverter {
    
    @Autowired
    DeliveryRepository dRepo;
    @Autowired
    DishRepository pRepo;
    @Autowired
    UserRepository uRepo;
    @Autowired
    RestaurantRepository rRepo;

    /**
     * Converte un dto in un oggetto di tipo Delivery.
     * 
     * @param dto - L'oggetto DeliveryDtoRPost da convertire.
     * @return 
     * @return Delivery - L'entità Delivery risultante dalla conversione.
     */
    public Delivery dtoToDelivery(DeliveryDtoRPost dto){
        Restaurant r = getR(dto);
        User u = getU(dto);
        return Delivery
                .builder()
                .id(dto.getId())
                .expected_arrival(dto.getExpected_arrival())
                .distance(calculateDistance(r,u))
                .paymentMethod(dto.getPaymentMethod())
                .notes(dto.getNotes())
                .dishesDeliveries(riempiLista(dto.getIdPlateQuantity()))
                .user(u)
                .restaurant(r)
                .build();
    }

    /**
     * Converte un Delivery in un oggetto DeliveryDtoWFull.
     * 
     * @param e - L'oggetto Delivery da convertire.
     * @return DeliveryDtoWFull - L'entità DeliveryDtoWFull risultante dalla conversione.
     */
    public DeliveryDtoWFull deliveryToDtoWFull(Delivery e){
        return DeliveryDtoWFull
                .builder()
                .id(e.getId())
                .expected_arrival(e.getExpected_arrival())
                .distance(e.getDistance())
                .paymentMethod(e.getPaymentMethod())
                .notes(e.getNotes())
                .user(e.getUser())
                .restaurant(e.getRestaurant())
                .dishesDeliveries(e.getDishesDeliveries())
                .build();
    }

    /**
     * Converte un DTO DeliveryDtoWFull in un'entità Delivery.
     * 
     * @param dto - Il DTO DeliveryDtoWFull da convertire.
     * @return Delivery - L'entità Delivery risultante dalla conversione.
     */
    public Delivery dtoWFullToDelivery(DeliveryDtoWFull dto){
        Delivery delivery = new Delivery();
        delivery.setId(dto.getId());
        delivery.setExpected_arrival(dto.getExpected_arrival());
        delivery.setDistance(dto.getDistance());
        delivery.setPaymentMethod(dto.getPaymentMethod());
        delivery.setNotes(dto.getNotes());
        return delivery;
    }

    private Set<DishToDelivery> riempiLista(Map<Integer, Integer> mappa){
        Set<DishToDelivery> dishesDeliveries = new HashSet<DishToDelivery>();
        for (Map.Entry<Integer, Integer> entry : mappa.entrySet()){
            Dish d = null;
            Integer dish_id = entry.getKey();
            if (dish_id != null) {
                Optional<Dish> od = pRepo.findById(dish_id);
                if (od.isPresent())
                    d = od.get();
            }
            DishToDelivery dtd = new DishToDelivery();
            dtd.setDish(d);
            dtd.setQuantity(entry.getValue());
            dishesDeliveries.add(dtd);
        }
        return dishesDeliveries;
    }

    public Restaurant getR (DeliveryDtoRPost dto){
        Integer res_id = dto.getRestaurant_id();
        if (res_id != null) {
            Optional<Restaurant> or = rRepo.findById(res_id);
            if (or.isPresent())
                return or.get();
        }
        return null;
    }

    public User getU (DeliveryDtoRPost dto){
        Integer user_id = dto.getUser_id();
        if (user_id != null) {
            Optional<User> ou = uRepo.findById(user_id);
            if (ou.isPresent())
                return ou.get();
        }
        return null;
    }
    
    private int calculateDistance(Restaurant r, User u){
        //d = √(x2 − x1)^2 + (y2 − Y1)^2
        return (int) Math.sqrt(Math.pow(u.getPositionX() - r.getPositionX(), 2) 
        +                      Math.pow(u.getPositionY() - r.getPositionY(), 2));
    }

    // private boolean isInsideMaxDistance(Restaurant r, Delivery e){
    //     return r.getMaxDeliveryDistance() < e.getDistance();
    // }
}
