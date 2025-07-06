package com.sg.Hotel_Management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "PhoneNumber is required")
    private String phoneNumber;
    @NotBlank(message = "Password is required")
    private String password;
    private String role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings= new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return "";
    }


    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public long getId() {
        return id;
    }

    public @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public @NotBlank(message = "PhoneNumber is required") String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(@NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public void setPhoneNumber(@NotBlank(message = "PhoneNumber is required") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
