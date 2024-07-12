package com.SMM.FoodOrdering.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "Company_names")
    private String name;

    @Lob
    private byte[] logo;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid mobile number")
    private String mobileNumber;

    private String state;

    private String location;
}
