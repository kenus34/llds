package org.llds.zoom;

public class BookingService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Booking oldBooking = (Booking) oldEntity;
        Booking newBooking = (Booking) newEntity;
        oldBooking.setCreatedAt(newBooking.getCreatedAt());
        oldBooking.setDays(newBooking.getDays());
        oldBooking.setUserId(newBooking.getUserId());
        oldBooking.setVehicleId(newBooking.getVehicleId());
        oldBooking.setBookingState(newBooking.getBookingState());
        oldBooking.setPaymentId(newBooking.getPaymentId());
    }
}
