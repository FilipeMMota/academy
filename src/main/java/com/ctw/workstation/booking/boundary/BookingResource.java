package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingRequestDTO;
import com.ctw.workstation.booking.entity.BookingResponseDTO;
import com.ctw.workstation.services.BookingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Path("/bookings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingService bookingService;

    @GET
    public List<BookingResponseDTO> getAllBookings() {
        return this.bookingService.getAllBookings();
    }

    @POST
    public Response createNewBooking(BookingRequestDTO booking) {
        BookingResponseDTO newBooking = this.bookingService.addBooking(booking);
        return Response.status(201).entity(newBooking).build();
    }

    @PUT
    @Path("{id}")
        public Response updateBookingWithId(@PathParam("id") UUID bookingId, @RequestBody BookingRequestDTO booking) {
        Booking bookingFound = this.bookingService.getBooking(bookingId);
        if(bookingFound == null){
            return Response.status(404).build();
        }
        BookingResponseDTO newBooking = this.bookingService.updateBooking(bookingFound, booking);
        return Response.status(200).entity(newBooking).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBookingWithId(@PathParam("id") UUID bookingId) {
        this.bookingService.deleteBooking(bookingId);
        return Response.status(204).build();
    }
}
