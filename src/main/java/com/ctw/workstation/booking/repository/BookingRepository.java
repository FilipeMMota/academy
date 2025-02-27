package com.ctw.workstation.booking.repository;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {
    public Booking findById(UUID bookingId) {
        return find("id", bookingId).firstResult();
    }

    public void deleteById(UUID bookingId) {
        Booking booking = findById(bookingId);
        delete(booking);
    }
}
