    package com.generation.javeat.model.entities;

    import java.util.List;
    import java.util.Set;

    import com.fasterxml.jackson.annotation.JsonIgnore;

    import jakarta.persistence.CascadeType;
    import jakarta.persistence.CollectionTable;
    import jakarta.persistence.Column;
    import jakarta.persistence.ElementCollection;
    import jakarta.persistence.Entity;
    import jakarta.persistence.FetchType;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.OneToMany;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Restaurant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String phone, imgUrl;

        private int openingHour, closingHour, positionX, positionY, maxDeliveryDistance;

        @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
        @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restauran_id"))
        @Column(name = "restaurant", nullable = false)
        private List<String> foodTypes;

        @JsonIgnore
        @OneToMany(mappedBy = "deliveries", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
        private Set<Delivery> deliveries;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "menu_id")
        private Menu menu;

    }
