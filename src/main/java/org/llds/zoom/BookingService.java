package org.llds.zoom;

import lombok.AllArgsConstructor;

import java.awt.print.Book;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
public class BookingService extends CrudService{

    private PaymentService paymentService;
    private VehicleService vehicleService;
    private UserService userService;

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
    public Booking createBooking(int vehicleId, int userId, int days) throws Exception {
        Optional<Entity> optionalVehicle = vehicleService.getById(vehicleId);
        Optional<Entity> optionalUser = userService.getById(userId);

        if(optionalUser.isPresent()&&optionalVehicle.isPresent()){
            Vehicle vehicle = (Vehicle) optionalVehicle.get();
            User user = (User) optionalUser.get();
            if(vehicle.getVehicleStatus().get()==VehicleStatus.AVAILABLE&&user.getStatus()==UserStatus.ACTIVE){
                boolean changeStats = vehicle.setVehicleStatus(VehicleStatus.AVAILABLE, VehicleStatus.BOOKED);
                if(changeStats){
                    Booking booking = Booking.builder()
                            .createdAt(new Date())
                            .userId(userId)
                            .vehicleId(vehicleId)
                            .days(days)
                            .bookingState(BookingState.NEW)
                            .build();
                    booking = (Booking) add(booking);
                    String transactionId = paymentService.executePayment();
                    booking.setPaymentId(transactionId);

                    return booking;
                }else{
                }
            }
            throw new Exception("Already booked");
        }
        throw new Exception("Booking error");
    }
}
