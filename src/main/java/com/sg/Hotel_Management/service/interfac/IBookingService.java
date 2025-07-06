package com.sg.Hotel_Management.service.interfac;

import com.sg.Hotel_Management.dto.Response;
import com.sg.Hotel_Management.entity.Booking;

public interface IBookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
