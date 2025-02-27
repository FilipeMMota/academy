package com.ctw.workstation.services;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingRequestDTO;
import com.ctw.workstation.booking.entity.BookingResponseDTO;
import com.ctw.workstation.booking.repository.BookingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    public List<BookingResponseDTO> getAllBookings(){
        List<Booking> bookings = this.bookingRepository.listAll();
        return bookings.stream().map(BookingResponseDTO::new).collect(Collectors.toList());
    }

    public Booking getBooking(UUID id){
        return this.bookingRepository.findById(id);
    }

    public BookingResponseDTO getBookingResponse(UUID id){
        return new BookingResponseDTO(this.bookingRepository.findById(id));
    }


    @Transactional
    public BookingResponseDTO addBooking(BookingRequestDTO bookingFromRequestBody){
        Booking newBooking = new Booking();
        newBooking.setBookFrom(bookingFromRequestBody.bookFrom());
        newBooking.setBookTo(bookingFromRequestBody.bookTo());
        newBooking.setRackId(bookingFromRequestBody.rackId());
        newBooking.setRequesterId(bookingFromRequestBody.requesterId());

        this.bookingRepository.persistAndFlush(newBooking);

        return new BookingResponseDTO(newBooking);
    }

    @Transactional
    public BookingResponseDTO updateBooking(Booking existingBooking, BookingRequestDTO givenBooking) {
        existingBooking.setBookFrom(givenBooking.bookFrom());
        existingBooking.setBookTo(givenBooking.bookTo());
        existingBooking.setRequesterId(givenBooking.requesterId());
        existingBooking.setRackId(givenBooking.rackId());

        this.bookingRepository.getEntityManager().merge(existingBooking);

        return new BookingResponseDTO(existingBooking);
    }

    @Transactional
    public void deleteBooking(UUID bookingId){
        this.bookingRepository.deleteById(bookingId);
    }
}
